package pl.lodz.p.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;

public class SecondaryController {

    @FXML
    private GridPane gridPane;

    ObservableList<Node> nodes;

    List<TextField> textFields = new ArrayList<>();

    SudokuBoard sudoku;

    private void setupTextField(TextField textField) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();
            if (text.matches("[1-9]*") && change.getControlNewText().length() <= 1) {
                return change;
            }
            return null;
        };

        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        textField.setTextFormatter(textFormatter);
    }

    public void draw(SudokuBoard sudoku) {
        this.sudoku = sudoku;
        nodes = gridPane.getChildren();
        for (Node n : nodes) {
            if (n instanceof TextField) {
                textFields.add((TextField) n);
            }
        }

        for (TextField field : textFields) {
            setupTextField(field);
        }

//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                String text = Integer.toString(sudoku.getValue(i, j));
//                ChoiceBox<String> box = choiceBoxes.get(i * 9 + j);
//                box.setValue(text);
//                if (Integer.parseInt(text) != 0) {
//                    choiceBoxes.get(i * 9 + j).setDisable(true);
//                }
//                int finalI = i;
//                int finalJ = j;
//                box.setOnAction((e) -> {
//                    sudoku.setValue(finalI, finalJ, Integer.parseInt(box.getValue()));
//                    if (!sudoku.getBox(finalI, finalJ).verify()
//                            || !sudoku.getRow(finalJ).verify()
//                            || !sudoku.getColumn(finalI).verify()) {
//                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setTitle("Nieprawidłowa wartość!");
//                        alert.setHeaderText("Nieprawidłowa wartość!");
//                        alert.setContentText("Wprowadziłeś wartość która już pojawiła się \n"
//                                + "w danym rzędzie, boksie lub kolumnie!");
//                        alert.showAndWait();
//                        sudoku.setValue(finalI, finalJ, 0);
//                        box.setValue("0");
//                    }
//                });
//            }
//        }
    }

    @FXML
    private void saveToFile() {
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        FileSudokuBoardDao file = (FileSudokuBoardDao) factory.createFileSudokuBoardDao("plik");
        file.write(sudoku);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Zapis");
        alert.setHeaderText("Plansza została zapisana!");
        alert.showAndWait();
    }
}