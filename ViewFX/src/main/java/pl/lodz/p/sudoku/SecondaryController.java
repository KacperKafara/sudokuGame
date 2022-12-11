package pl.lodz.p.sudoku;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;

public class SecondaryController {

    @FXML
    private GridPane gridPane;

    ObservableList<Node> nodes;

    List<ChoiceBox> choiceBoxes = new ArrayList<>();

    SudokuBoard sudoku;

    private String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public void draw(SudokuBoard sudoku) {
        this.sudoku = sudoku;
        nodes = gridPane.getChildren();
        for (Node n : nodes) {
            if (n instanceof ChoiceBox) {
                choiceBoxes.add((ChoiceBox) n);
            }
        }

        for (ChoiceBox box : choiceBoxes) {
            box.getItems().addAll(numbers);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String text = Integer.toString(sudoku.getValue(i, j));
                choiceBoxes.get(j * 9 + i).setValue(text);
                if (Integer.parseInt(text) != 0) {
                    choiceBoxes.get(j * 9 + i).setDisable(true);
                }
            }
        }
    }

    @FXML
    private void saveToFile() {
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        FileSudokuBoardDao file = (FileSudokuBoardDao) factory.createFileSudokuBoardDao("plik");
        file.write(sudoku);
    }
}