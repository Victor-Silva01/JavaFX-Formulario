package javafx.challenge;

import javafx.application.Application;
import javafx.challenge.view.MainPane;
import javafx.challenge.view.identification.IdentificationPane;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    private static final int HEIGHT = 1200;
    private static final int WIDTH = 900;

    @Override
    public void start(Stage stage) throws Exception {
        buildGUI(stage);
    }

    private void buildGUI(Stage stage) {
        MainPane rootPane = new MainPane();
        Scene scene = new Scene(rootPane, WIDTH, HEIGHT);

        rootPane.add(new IdentificationPane(), 0, 0);

        centralize(rootPane, scene);
        stage.setTitle("JavaFX Project");
        stage.setScene(scene);
        stage.show();
    }

    private static void centralize(Pane rootPane, Scene scene) {
        rootPane.setLayoutX((scene.getWidth() - rootPane.getWidth()) / 2);
        rootPane.setLayoutY((scene.getHeight() - rootPane.getHeight()) / 2);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
