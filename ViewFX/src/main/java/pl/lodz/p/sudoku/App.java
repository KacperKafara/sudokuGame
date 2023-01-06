package pl.lodz.p.sudoku;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Locale currentLocation = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("appText", currentLocation);
        Parent root = FXMLLoader.load(Objects.requireNonNull(
                      getClass().getResource("primary.fxml")), bundle);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(FXMLLoader loader) throws IOException {
        scene.setRoot(loader.load());
    }

    public static void main(String[] args) {
        launch();
    }

}