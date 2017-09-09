class FizzBuzz:
    class __FizzBuzz:
        def __init(self):
            self.val = None
            self.substitution_map = {}

        def get_value_of(self, number):
            result = []
            for key, substitute in self.substitution_map.items():
                if number % key == 0:
                    result.append(substitute)
            if result:
                return ' '.join(result)
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
