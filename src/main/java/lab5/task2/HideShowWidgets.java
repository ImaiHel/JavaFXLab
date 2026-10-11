package lab5.task2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HideShowWidgets extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Произвольная надпись");
        TextField textField = new TextField("Текстовое поле");
        Slider slider = new Slider(0, 100, 50);
        Button button = new Button("Произвольная кнопка");

        CheckBox cbLabel = new CheckBox("Показать надпись");
        cbLabel.setSelected(true);
        cbLabel.setOnAction(e -> label.setVisible(cbLabel.isSelected()));

        CheckBox cbText = new CheckBox("Показать текстовое поле");
        cbText.setSelected(true);
        cbText.setOnAction(e -> textField.setVisible(cbText.isSelected()));

        CheckBox cbSlider = new CheckBox("Показать слайдер");
        cbSlider.setSelected(true);
        cbSlider.setOnAction(e -> slider.setVisible(cbSlider.isSelected()));

        CheckBox cbButton = new CheckBox("Показать кнопку");
        cbButton.setSelected(true);
        cbButton.setOnAction(e -> button.setVisible(cbButton.isSelected()));

        VBox root = new VBox(10,
                label, cbLabel,
                textField, cbText,
                slider, cbSlider,
                button, cbButton);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 400, 400));
        stage.setTitle("Показать/скрыть виджеты");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}