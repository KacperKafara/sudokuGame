package pl.lodz.p.sudoku;

import java.util.ListResourceBundle;

public class Authors extends ListResourceBundle {

    private Object[][] contents = {
            {"author1", "Kacper Kafara"},
            {"author2", "Miłosz Kawczynski"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
