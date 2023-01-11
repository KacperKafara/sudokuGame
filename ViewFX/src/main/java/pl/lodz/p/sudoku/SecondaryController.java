package pl.lodz.p.sudoku;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.beans.property.adapter.JavaBeanIntegerProperty;
import javafx.beans.property.adapter.JavaBeanIntegerPropertyBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import org.apache.log4j.Logger;

public class SecondaryController {

    @FXML
    private GridPane gridPane;

    ObservableList<Node> nodes;

    List<TextField> textFields = new ArrayList<>();

    SudokuBoard sudoku;

    ResourceBundle bundle = ResourceBundle.getBundle("appText", PrimaryController.defaultLocation);
    private final Logger logger = Logger.getLogger(SecondaryController.class);

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

    public void draw(SudokuBoard sudoku) throws NoSuchMethodException {
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

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JavaBeanIntegerProperty pr = JavaBeanIntegerPropertyBuilder.create()
                        .bean(this.sudoku.getField(i, j))
                        .name("fieldValue").build();
                StringConverter<Number> converter = new NumberStringConverter();
                textFields.get(i * 9 + j).textProperty().bindBidirectional(pr, converter);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int finalI = i;
                int finalJ = j;
                textFields.get(i * 9 + j).textProperty()
                        .addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        if (!sudoku.getBox(finalI, finalJ).verify()
                            || !sudoku.getRow(finalJ).verify()
                            || !sudoku.getColumn(finalI).verify()) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle(bundle.getString("alert.title"));
                            alert.setHeaderText(bundle.getString("alert.header"));
                            alert.setContentText(bundle.getString("alert.msg"));
                            alert.showAndWait();
                            textFields.get(finalI * 9 + finalJ).textProperty().setValue(oldValue);
                        }
                    }
                });
            }
        }
    }

    @FXML
    private void saveToFile() throws MyException {
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        FileSudokuBoardDao file = (FileSudokuBoardDao) factory.createFileSudokuBoardDao("plik");
        file.write(sudoku);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(bundle.getString("alert.save"));
        alert.setHeaderText(bundle.getString("alert.saveMsg"));
        logger.info("Gra zostala zapisana do pliku");
        alert.showAndWait();
    }
}