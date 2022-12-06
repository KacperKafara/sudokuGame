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

    @FXML
    private void play() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public void getDifficulty(javafx.event.ActionEvent actionEvent) {
    }
}
