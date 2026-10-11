package lab5.task1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WordSwapper extends Application {

    private boolean leftToRight = true;

    @Override
    public void start(Stage stage) {
        TextField left = new TextField();
        left.setPromptText("Левое поле");
        TextField right = new TextField();
        right.setPromptText("Правое поле");

        Button swapButton = new Button("→");

        swapButton.setOnAction(e -> {
            if (leftToRight) {
                right.setText(left.getText());
                left.clear();
                swapButton.setText("←");
            } else {
                left.setText(right.getText());
                right.clear();
                swapButton.setText("→");
            }
            leftToRight = !leftToRight;
        });

        HBox root = new HBox(10, left, swapButton, right);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(root, 500, 120));
        stage.setTitle("Перекидыватель слов");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}