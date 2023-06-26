package javafx.challenge.view;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class MainPane extends GridPane {

    private static final Insets PADDING = new Insets(40, 20, 20, 30);

    public MainPane() {
        setPadding(PADDING);
    }

}
