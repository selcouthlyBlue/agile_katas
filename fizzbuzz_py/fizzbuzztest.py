import unittest
import fizzbuzz


class MyTestCase(unittest.TestCase):
    def setUp(self):
        self.fizzbuzz_instance = fizzbuzz.FizzBuzz()
        self.add_to_substitution_map(3, "fizz")
        self.add_to_substitution_map(5, "buzz")
        self.add_to_substitution_map(7, "pop")

    def add_to_substitution_map(self, number, substitute):
        self.fizzbuzz_instance.add_to_substitution_map(number, substitute)

    def test_normal_numbers_return_same_number(self):
        number = 1
        self.set_expected_result(1)
        self.assert_expected_result_is_attained_with(number)

    def test_multiples_of_three_return_fizz(self):
        number = 3
        self.set_expected_result("fizz")
        self.assert_expected_result_is_attained_with(number)

    def test_multiples_of_five_return_buzz(self):
        number = 5
        self.set_expected_result("buzz")
        self.assert_expected_result_is_attained_with(number)

    def test_multiples_of_three_and_five_return_fizz_buzz(self):
        number = 15
        self.set_expected_result("fizz buzz")
        self.assert_expected_result_is_attained_with(number)

    def test_multiples_of_seven_return_pop(self):
        number = 7
        self.set_expected_result("pop")
        self.assert_expected_result_is_attained_with(number)

    def test_multiples_of_three_and_seven_return_fizz_pop(self):
        number = 21
        self.set_expected_result("fizz pop")
        self.assert_expected_result_is_attained_with(number)

    def test_multiples_of_five_and_seven_return_buzz_pop(self):
        number = 35
        self.set_expected_result("buzz pop")
        self.assert_expected_result_is_attained_with(number)

    def test_multiples_of_three_five_and_seven_return_fizz_buzz_pop(self):
        number = 105
        self.set_expected_result("fizz buzz pop")
        self.assert_expected_result_is_attained_with(number)

    def test_multiples_of_custom_substitution_two_should_return_fuzz(self):
        number = 2
        self.set_expected_result("fuzz")
        self.add_to_substitution_map(2, "fuzz")
        self.assert_expected_result_is_attained_with(number)

    def test_multiples_of_custom_substitutions_two_and_three_should_return_fuzz_bizz(self):
        number = 6
        self.add_to_substitution_map(2, "fuzz")
        self.add_to_substitution_map(3, "bizz")
        self.set_expected_result("fuzz bizz")
        self.assert_expected_result_is_attained_with(number)

    def set_expected_result(self, expected_result):
        self.expected_result = expected_result

    def assert_expected_result_is_attained_with(self, number):
        result = self.fizzbuzz_instance.get_value_of(number)
        self.assertTrue(result == self.expected_result, "Result is {}".format(result))


if __name__ == '__main__':
    unittest.main()
