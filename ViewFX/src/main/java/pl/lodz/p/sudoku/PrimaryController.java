package pl.lodz.p.sudoku;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

public class PrimaryController {

    @FXML
    private RadioButton difficulty1;
    @FXML
    private RadioButton difficulty2;
    @FXML
    private RadioButton difficulty3;

    private int difficulty = 0;

    @FXML
    private void play() throws IOException {

        DifficultyLevel difficultyLevel = DifficultyLevel.EASY;

        switch (difficulty) {
            case(0): {
                difficultyLevel = DifficultyLevel.EASY;
                break;
            }
            case(1): {
                difficultyLevel = DifficultyLevel.MEDIUM;
                break;
            }
            case(2): {
                difficultyLevel = DifficultyLevel.HARD;
                break;
            }
            default: {
                break;
            }
        }

        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.solveGame();

        difficultyLevel.removeFields(sudoku);

        App.setRoot("secondary");
    }

    @FXML
    public void getDifficulty(javafx.event.ActionEvent actionEvent) {
        if (difficulty1.isSelected()) {
            difficulty = 0;
        } else if (difficulty2.isSelected()) {
            difficulty = 1;
        } else if (difficulty3.isSelected()) {
            difficulty = 2;
        }
    }
}
