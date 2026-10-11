package lab5.task3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class RestaurantOrder extends Application {

    private static class Dish {
        String name;
        double price;
        CheckBox checkBox;
        Spinner<Integer> spinner;

        Dish(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    @Override
    public void start(Stage stage) {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Борщ", 250));
        dishes.add(new Dish("Пельмени", 320));
        dishes.add(new Dish("Салат Цезарь", 400));
        dishes.add(new Dish("Стейк", 750));
        dishes.add(new Dish("Чай", 100));

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        for (Dish dish : dishes) {
            dish.checkBox = new CheckBox(dish.name + " (" + dish.price + " руб.)");
            dish.spinner = new Spinner<>(1, 20, 1);
            dish.spinner.setPrefWidth(70);
            dish.spinner.setDisable(true);
            CheckBox cb = dish.checkBox;
            Spinner<Integer> sp = dish.spinner;
            cb.setOnAction(e -> sp.setDisable(!cb.isSelected()));
            root.getChildren().add(new HBox(10, dish.checkBox, new Label("Порций:"), dish.spinner));
        }

        Button orderButton = new Button("Оформить заказ");
        orderButton.setOnAction(e -> showReceipt(dishes));
        root.getChildren().add(orderButton);

        stage.setScene(new Scene(root, 500, 400));
        stage.setTitle("Заказ в ресторане");
        stage.show();
    }

    private void showReceipt(List<Dish> dishes) {
        StringBuilder sb = new StringBuilder();
        double total = 0;

        for (Dish dish : dishes) {
            if (dish.checkBox.isSelected()) {
                int count = dish.spinner.getValue();
                double sum = count * dish.price;
                total += sum;
                sb.append(dish.name)
                        .append(" — ")
                        .append(count)
                        .append(" шт. × ")
                        .append(dish.price)
                        .append(" руб. = ")
                        .append(sum)
                        .append(" руб.\n");
            }
        }

        if (total == 0) {
            sb.append("Ничего не выбрано.");
        } else {
            sb.append("\nИтого: ").append(total).append(" руб.");
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Чек");
        alert.setHeaderText("Ваш заказ");
        alert.setContentText(sb.toString());
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}