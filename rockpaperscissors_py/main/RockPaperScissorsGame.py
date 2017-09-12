from main import GestureEnum as Gesture

class RockPaperScissorsGame:
    def __init__(self, player1, player2):
        self.player1 = player1
        self.player2 = player2

    def determine_result(self, gesture_thrown_by_player1, gesture_thrown_by_player2):
        if gesture_thrown_by_player1 == gesture_thrown_by_player2:
            return "DRAW"
        gesture_list = [Gesture.ROCK, Gesture.PAPER, Gesture.SCISSORS]
        gesture_list.remove(gesture_thrown_by_player1)
        gesture_list.remove(gesture_thrown_by_player2)
        winning_gesture = self.get_winning_gesture(gesture_list[0])
        if gesture_thrown_by_player1 == winning_gesture:
            return self.player1.get_name()
        return self.player2.get_name()

    def get_winning_gesture(self, gesture):
        return {
            Gesture.ROCK: Gesture.SCISSORS,
            Gesture.PAPER: Gesture.ROCK,
            Gesture.SCISSORS: Gesture.PAPER
        }.get(gesture, Gesture.DRAW)
