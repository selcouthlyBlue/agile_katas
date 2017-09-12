from main import GestureEnum as Gesture

class Player:
    def __init__(self, name):
        self.name = name

    def throw_rock(self):
        return Gesture.ROCK

    def throw_scissors(self):
        return Gesture.SCISSORS

    def throw_paper(self):
        return Gesture.PAPER

    def get_name(self):
        return self.name
