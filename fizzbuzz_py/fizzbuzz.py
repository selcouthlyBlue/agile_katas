class FizzBuzz:
    class __FizzBuzz:
        def __init(self):
            self.val = None
            self.substitution_map = {}

        def get_value_of(self, number):
            result = ''
            is_multiple_of_a_previous_number = False
            for key, substitute in self.substitution_map.items():
                if number % key == 0:
                    if is_multiple_of_a_previous_number:
                        result += ' '
                    result += substitute
                    is_multiple_of_a_previous_number = True
            if is_multiple_of_a_previous_number:
                return result
            return number

        def add_to_substitution_map(self, number, substitute):
            self.substitution_map[number] = substitute

        def __str__(self):
            return repr(self)

    instance = None

    def __new__(cls):
        if not FizzBuzz.instance:
            FizzBuzz.instance = FizzBuzz.__FizzBuzz()
            FizzBuzz.instance.substitution_map = {}
        return FizzBuzz.instance

    def __getattr__(self, item):
        return getattr(self.instance, item)

    def __setattr__(self, item, val):
        return setattr(self.instance, item, val)
