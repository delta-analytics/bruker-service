package deltaanalytics.bruker.hardware;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Demo2 extends Application {
    final TitledPane[] tps1 = new TitledPane[4];
    final Label label = new Label("N/A");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("TitledPane");
        Scene scene = new Scene(new Group(), 800, 250);
        scene.setFill(Color.GHOSTWHITE);

        // --- GridPane container
        TitledPane gridTitlePane = new TitledPane();
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("To: "), 0, 0);
        grid.add(new TextField(), 1, 0);
        grid.add(new Label("Cc: "), 0, 1);
        grid.add(new TextField(), 1, 1);
        grid.add(new Label("Subject: "), 0, 2);
        grid.add(new TextField(), 1, 2);
        grid.add(new Label("Attachment: "), 0, 3);
        grid.add(label, 1, 3);
        gridTitlePane.setText("Grid");
        gridTitlePane.setContent(grid);

        // --- Accordion
        final Accordion accordion = new Accordion();

        tps1[0] = new TitledPane("BRUKER", new Button("...."));
        tps1[1] = new TitledPane("JUEKE", new Label("...."));
        tps1[2] = new TitledPane("CALIBRATION", new Label("...."));
        tps1[3] = new TitledPane("USER", new Label("...."));
        accordion.getPanes().addAll(tps1);
        accordion.expandedPaneProperty().addListener((ov, old_val, new_val) -> {
            if (new_val != null) {
                label.setText(accordion.getExpandedPane().getText() +
                        ".jpg");
            }
        });

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(20, 0, 0, 20));
        hbox.getChildren().setAll(gridTitlePane, accordion);

        Group root = (Group) scene.getRoot();
        root.getChildren().add(hbox);
        stage.setScene(scene);
        stage.show();
    }
}