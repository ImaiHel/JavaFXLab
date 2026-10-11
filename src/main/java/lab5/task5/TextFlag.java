package lab5.task5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFlag extends Application {

    private static final String[] COLORS = {"Красный", "Зелёный", "Белый", "Синий", "Жёлтый"};

    @Override
    public void start(Stage stage) {
        ToggleGroup group1 = new ToggleGroup();
        ToggleGroup group2 = new ToggleGroup();
        ToggleGroup group3 = new ToggleGroup();

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        root.getChildren().add(new Label("Верхняя полоса:"));
        root.getChildren().addAll(createRadioButtons(group1));

        root.getChildren().add(new Label("Средняя полоса:"));
        root.getChildren().addAll(createRadioButtons(group2));

        root.getChildren().add(new Label("Нижняя полоса:"));
        root.getChildren().addAll(createRadioButtons(group3));

        Button draw = new Button("Нарисовать");
        draw.setOnAction(e -> {
            String c1 = getSelected(group1);
            String c2 = getSelected(group2);
            String c3 = getSelected(group3);
            if (c1 == null || c2 == null || c3 == null) {
                showError("Выберите цвет для каждой полосы");
                return;
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Флаг");
            alert.setHeaderText("Ваш флаг:");
            alert.setContentText(c1 + ", " + c2 + ", " + c3);
            alert.showAndWait();
        });

        root.getChildren().add(draw);

        Scene scene = new Scene(root, 300, 600);
        stage.setScene(scene);
        stage.setTitle("Текстовый флаг");
        stage.setResizable(false);
        stage.show();
    }

    private RadioButton[] createRadioButtons(ToggleGroup group) {
        RadioButton[] buttons = new RadioButton[COLORS.length];
        for (int i = 0; i < COLORS.length; i++) {
            RadioButton rb = new RadioButton(COLORS[i]);
            rb.setToggleGroup(group);
            buttons[i] = rb;
        }
        return buttons;
    }

    private String getSelected(ToggleGroup group) {
        if (group.getSelectedToggle() == null) return null;
        return ((RadioButton) group.getSelectedToggle()).getText();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}