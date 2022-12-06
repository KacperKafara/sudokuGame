package pl.lodz.p.sudoku;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class SecondaryController implements Initializable {

    @FXML
    private ChoiceBox<String> field1;

    private String[] fieldValue = {"0","1","2","3","4","5","6","7","8","9"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        field1.getItems().addAll(fieldValue);
    }
}