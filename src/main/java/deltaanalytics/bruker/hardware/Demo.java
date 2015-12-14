package deltaanalytics.bruker.hardware;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.entity.MeasureSample;
import deltaanalytics.bruker.data.repository.MeasureSampleRepository;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Demo extends Application {
    private Logger LOGGER = LoggerFactory.getLogger(Demo.class);
    private TableView<MeasureSample> tableView;

    public void start(Stage stage) {
        stage.setTitle("Demo");
        stage.setMaximized(true);

        GridPane gridPane = buildGridPane();

        gridPane.add(buildLeftVBox(), 0, 0);

        gridPane.add(buildRightTableView(), 1, 0);

        HBox hBox = new HBox(10);
        hBox.getChildren().add(new Label("Das wäre der Status"));
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.ALWAYS);
        gridPane.add(hBox, 0, 1, 2, 1);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);

        stage.show();
    }

    private TableView buildRightTableView() {

        List<MeasureSampleDto> measureSamples = build();
        tableView = new TableView();

        TableColumn tableColumn1 = new TableColumn("ID");
        tableColumn1.setCellValueFactory(new PropertyValueFactory<MeasureSampleDto, Long>("id"));
        TableColumn tableColumn2 = new TableColumn("StartedAt");
        tableColumn2.setCellValueFactory(new PropertyValueFactory<MeasureSampleDto, LocalDateTime>("createdAt"));
        TableColumn tableColumn3 = new TableColumn("FinishedAt");
        tableColumn3.setCellValueFactory(new PropertyValueFactory<MeasureSampleDto, LocalDateTime>("finishedAt"));
        TableColumn tableColumn4 = new TableColumn("State");
        tableColumn4.setCellValueFactory(new PropertyValueFactory<MeasureSampleDto, LocalDateTime>("brukerStateEnum"));
        TableColumn tableColumn5 = new TableColumn("Error");

        ObservableList observableSamples = FXCollections.observableList(measureSamples);

        tableView.getColumns().addAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4,
                tableColumn5);

        tableView.setItems(observableSamples);
        return tableView;
    }

    private List<MeasureSampleDto> build() {
        List<MeasureSampleDto> measureSampleDtos = new ArrayList<>();
        List<MeasureSample> measureSamples = new MeasureSampleRepository().findAll();
        for (MeasureSample measureSample : measureSamples) {
            measureSampleDtos.add(new MeasureSampleDto(measureSample));
        }
        return measureSampleDtos;
    }

    private VBox buildLeftVBox() {
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setFillWidth(true);
        vBox.setPadding(new Insets(40));
        Button one = new Button("ONE");
        Button two = new Button("TWO");
        Button three = new Button("MeasureSample");
        three.setOnAction(event -> {
            Thread thread = new Thread(getTask());
            thread.start();
        });
        Button four = new Button("FOUR");
        Button five = new Button("FIVE");
        Button six = new Button("SIX");
        Button seven = new Button("SEVEN");
        vBox.getChildren().addAll(one, two, three, four, five, six, seven);
        return vBox;
    }

    private GridPane buildGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setGridLinesVisible(true);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(20);
        column1.setHgrow(Priority.ALWAYS);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(80);
        column2.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(column1, column2);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100);
        gridPane.getRowConstraints().addAll(row1);
        return gridPane;
    }

    private void refreshTableView() {
        List<MeasureSampleDto> measureSamples = build();
        ObservableList observableSamples = FXCollections.observableList(measureSamples);
        tableView.setItems(observableSamples);
    }

    private Task<Void> getTask() {
        Task<Void> task = new Task<Void>() {
            @Override
            public Void call() throws InterruptedException {
                new CommandRunner().measureSample("localhost", 80, BrukerParameters.getDefault());
                return null;
            }
        };


        task.setOnSucceeded(e -> {
            refreshTableView();
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.initStyle(StageStyle.UNDECORATED);
            info.initModality(Modality.NONE);
            info.setTitle("MeasureSample beendet.");
            info.show();
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(5),
                    event -> {
                        info.hide();
                    }));
            timeline.play();


        });
        task.setOnFailed(event -> {
            refreshTableView();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UNDECORATED);
            alert.initModality(Modality.NONE);
            alert.setTitle("MeasureSample mit Fehler beendet.");
            alert.show();
            String message = task.exceptionProperty().getValue().getMessage();
            alert.setHeaderText(message);

            LOGGER.error(message);
        });


        return task;
    }

    public static void main(String args[]) {
        launch(args);
    }
}
