package pl.lodz.p.sudoku;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class SecondaryController implements Initializable {

    @FXML
    private ChoiceBox<Integer> field1;

    private Integer[] fieldValue = {0,1,2,3,4,5,6,7,8,9};

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<ChoiceBox<Integer>> choiceBoxes = null;

        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.solveGame();

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
            }
        }
    }
}