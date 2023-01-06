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
    private static Stage stage;
    static Locale defaultLocation = new Locale("pl");

    static void setStart(Locale defaultLocation) throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("appText", defaultLocation);
        Parent root = FXMLLoader.load(Objects.requireNonNull(
                App.class.getResource("primary.fxml")), bundle);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    static void setStart() throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("appText", defaultLocation);
        Parent root = FXMLLoader.load(Objects.requireNonNull(
                App.class.getResource("primary.fxml")), bundle);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
        App.stage = stage;
        setStart();
    }

    static void setRoot(FXMLLoader loader) throws IOException {
        scene.setRoot(loader.load());
    }

    public static void main(String[] args) {
        launch();
    }

}