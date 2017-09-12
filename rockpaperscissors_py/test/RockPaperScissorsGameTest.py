import unittest
from main import RockPaperScissorsGame, Player


class MyTestCase(unittest.TestCase):
    def setUp(self):
        self.player1 = Player.Player("Ein")
        self.player2 = Player.Player("Rome")
        self.rock_paper_scissors_game = RockPaperScissorsGame.RockPaperScissorsGame(self.player1, self.player2)

    def test_player1_rock_beats_player2_scissors(self):
        gesture_thrown_by_player1 = self.player1.throw_rock()
        gesture_thrown_by_player2 = self.player2.throw_scissors()
        result = self.rock_paper_scissors_game.determine_result(
            gesture_thrown_by_player1, gesture_thrown_by_player2)
        assert result == self.player1.get_name()

    def test_player2_rock_beats_player1_scissors(self):
        gesture_thrown_by_player1 = self.player1.throw_scissors()
        gesture_thrown_by_player2 = self.player2.throw_rock()
        result = self.rock_paper_scissors_game.determine_result(
            gesture_thrown_by_player1, gesture_thrown_by_player2)
        assert result == self.player2.get_name()

    def test_player1_scissors_beats_player2_paper(self):
        gesture_thrown_by_player1 = self.player1.throw_scissors()
        gesture_thrown_by_player2 = self.player2.throw_paper()
        result = self.rock_paper_scissors_game.determine_result(
            gesture_thrown_by_player1, gesture_thrown_by_player2)
        assert result == self.player1.get_name()

    def test_player2_scissors_beats_player1_paper(self):
        gesture_thrown_by_player1 = self.player1.throw_paper()
        gesture_thrown_by_player2 = self.player2.throw_scissors()
        result = self.rock_paper_scissors_game.determine_result(
            gesture_thrown_by_player1, gesture_thrown_by_player2)
        assert result == self.player2.get_name()

    def test_player1_paper_beats_player2_rock(self):
        gesture_thrown_by_player1 = self.player1.throw_paper()
        gesture_thrown_by_player2 = self.player2.throw_rock()
        result = self.rock_paper_scissors_game.determine_result(
            gesture_thrown_by_player1, gesture_thrown_by_player2)
        assert result == self.player1.get_name()

    def test_player2_paper_beats_player1_rock(self):
        gesture_thrown_by_player1 = self.player1.throw_rock()
        gesture_thrown_by_player2 = self.player2.throw_paper()
        result = self.rock_paper_scissors_game.determine_result(
            gesture_thrown_by_player1, gesture_thrown_by_player2)
        assert result == self.player2.get_name()

    def test_same_moves_result_in_a_draw_for_rock(self):
        gesture_thrown_by_player1 = self.player1.throw_rock()
        gesture_thrown_by_player2 = self.player2.throw_rock()
        result = self.rock_paper_scissors_game.determine_result(
            gesture_thrown_by_player1, gesture_thrown_by_player2)
        assert result == "DRAW"

    def test_same_moves_result_in_a_draw_for_paper(self):
        gesture_thrown_by_player1 = self.player1.throw_paper()
        gesture_thrown_by_player2 = self.player2.throw_paper()
        result = self.rock_paper_scissors_game.determine_result(
            gesture_thrown_by_player1, gesture_thrown_by_player2)
        assert result == "DRAW"

    def test_same_moves_result_in_a_draw_for_scissors(self):
        gesture_thrown_by_player1 = self.player1.throw_scissors()
        gesture_thrown_by_player2 = self.player2.throw_scissors()
        result = self.rock_paper_scissors_game.determine_result(
            gesture_thrown_by_player1, gesture_thrown_by_player2)
        assert result == "DRAW"

if __name__ == '__main__':
    unittest.main()
