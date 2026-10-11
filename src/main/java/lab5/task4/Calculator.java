package lab5.task4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage stage) {
        TextField a = new TextField();
        a.setPromptText("Первое число");
        TextField b = new TextField();
        b.setPromptText("Второе число");
        Label result = new Label("Результат: —");

        Button add = new Button("+");
        Button sub = new Button("−");
        Button mul = new Button("×");
        Button div = new Button("÷");

        add.setOnAction(e -> calculate(a, b, result, '+'));
        sub.setOnAction(e -> calculate(a, b, result, '-'));
        mul.setOnAction(e -> calculate(a, b, result, '*'));
        div.setOnAction(e -> calculate(a, b, result, '/'));

        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(10);
        root.setVgap(10);

        root.add(new Label("Первое число:"), 0, 0);
        root.add(a, 1, 0);
        root.add(new Label("Второе число:"), 0, 1);
        root.add(b, 1, 1);
        root.add(add, 0, 2);
        root.add(sub, 1, 2);
        root.add(mul, 0, 3);
        root.add(div, 1, 3);
        root.add(result, 0, 4, 2, 1);

        stage.setScene(new Scene(root, 350, 260));
        stage.setTitle("Калькулятор");
        stage.show();
    }

    private void calculate(TextField a, TextField b, Label result, char op) {
        try {
            double x = Double.parseDouble(a.getText());
            double y = Double.parseDouble(b.getText());
            double res;
            switch (op) {
                case '+': res = x + y; break;
                case '-': res = x - y; break;
                case '*': res = x * y; break;
                case '/':
                    if (y == 0) {
                        showError("Деление на ноль невозможно");
                        return;
                    }
                    res = x / y;
                    break;
                default: return;
            }
            result.setText("Результат: " + res);
        } catch (NumberFormatException ex) {
            showError("Введите корректные числа");
        }
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