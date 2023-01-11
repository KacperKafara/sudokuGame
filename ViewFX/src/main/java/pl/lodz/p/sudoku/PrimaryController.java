package pl.lodz.p.sudoku;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import org.apache.log4j.Logger;

public class PrimaryController implements Initializable {

    @FXML
    private RadioButton difficulty1;
    @FXML
    private RadioButton difficulty2;
    @FXML
    private RadioButton difficulty3;
    @FXML
    private Label author1;
    @FXML
    private Label author2;

    private SudokuBoard sudoku;

    private int difficulty = 0;

    static Locale defaultLocation = new Locale("pl");

    private final ResourceBundle authors = ResourceBundle.getBundle("pl.lodz.p.sudoku.Authors");

    private final Logger logger = Logger.getLogger(PrimaryController.class);

    @FXML
    private void play() throws IOException, NoSuchMethodException, IndexOutOfRangeException {

        DifficultyLevel difficultyLevel = null;

        switch (difficulty) {
            case (0) -> {
                difficultyLevel = DifficultyLevel.EASY;
                logger.info("Gra zaladowana na poziomie latwym");
            }
            case (1) -> {
                difficultyLevel = DifficultyLevel.MEDIUM;
                logger.info("Gra zaladowana na poziomie srednim");
            }
            case (2) -> {
                difficultyLevel = DifficultyLevel.HARD;
                logger.info("Gra zaladowana na poziomie trudnym");
            }
            default -> {
                try {
                    readFromFile();
                } catch (MyException e) {
                    logger.info("Wyjatek");
                }
            }
        }

        SudokuSolver solver = new BacktrackingSudokuSolver();
        sudoku = new SudokuBoard(solver);
        sudoku.solveGame();

        difficultyLevel.removeFields(sudoku);

        ResourceBundle bundle = ResourceBundle.getBundle("appText", defaultLocation);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"), bundle);
        App.setRoot(loader);
        SecondaryController sc = loader.getController();
        sc.draw(sudoku);
    }

    @FXML
    private void changeLanguage() throws IOException {
        if (PrimaryController.defaultLocation.getLanguage() == "pl") {
            defaultLocation = new Locale("en");
        } else {
            defaultLocation = new Locale("pl");
        }
        logger.info("Jezyk zostal zmieniony");
        App.setStart(defaultLocation);
    }

    @FXML
    private void readFromFile() throws IOException, NoSuchMethodException, MyException {
        try {
            SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
            FileSudokuBoardDao file = (FileSudokuBoardDao) factory.createFileSudokuBoardDao("plik");
            sudoku = file.read();
            logger.info("Gra zaladowana z pliku");
            ResourceBundle bundle = ResourceBundle.getBundle("appText", defaultLocation);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"), bundle);
            App.setRoot(loader);
            SecondaryController sc = loader.getController();
            sc.draw(sudoku);
        } catch (FileNotFoundException e) {
            logger.error("Nie znaleziono pliku");
            throw new MyException(e.getMessage());
        }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        author1.setText(authors.getString("author1"));
        author2.setText(authors.getString("author2"));
    }
}
