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

        DifficultyLevel difficultyLevel = null;

        switch (difficulty) {
            case(0): {
                difficultyLevel = new DifficultyLevelEasy();
                break;
            }
            case(1): {
                difficultyLevel = new DifficultyLevelMedium();
                break;
            }
            case(2): {
                difficultyLevel = new DifficultyLevelHard();
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
