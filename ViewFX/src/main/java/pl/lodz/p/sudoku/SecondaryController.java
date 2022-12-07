package pl.lodz.p.sudoku;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class SecondaryController {

    @FXML
    private GridPane gridPane;

    public void draw(SudokuBoard sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String text = Integer.toString(sudoku.getValue(i, j));
                gridPane.add(new Text(text), i, j);
            }
        }
    }
}