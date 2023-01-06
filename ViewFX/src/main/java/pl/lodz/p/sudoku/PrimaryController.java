package pl.lodz.p.sudoku;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;

public class PrimaryController {

    @FXML
    private RadioButton difficulty1;
    @FXML
    private RadioButton difficulty2;
    @FXML
    private RadioButton difficulty3;

    private SudokuBoard sudoku;

    private int difficulty = 0;

    @FXML
    private void play() throws IOException, NoSuchMethodException {

        DifficultyLevel difficultyLevel = null;

        switch (difficulty) {
            case (0) -> difficultyLevel = DifficultyLevel.EASY;
            case (1) -> difficultyLevel = DifficultyLevel.MEDIUM;
            case (2) -> difficultyLevel = DifficultyLevel.HARD;
            default -> {
            }
        }

        SudokuSolver solver = new BacktrackingSudokuSolver();
        sudoku = new SudokuBoard(solver);
        sudoku.solveGame();

        difficultyLevel.removeFields(sudoku);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        App.setRoot(loader);
        SecondaryController sc = loader.getController();
        sc.draw(sudoku);
    }

    @FXML
    private void readFromFile() throws IOException, NoSuchMethodException {
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        FileSudokuBoardDao file = (FileSudokuBoardDao) factory.createFileSudokuBoardDao("plik");
        sudoku = file.read();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        App.setRoot(loader);
        SecondaryController sc = loader.getController();
        sc.draw(sudoku);
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
