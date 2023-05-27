package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private TextField productField;
    private Button insertButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create GUI components
        usernameField = new TextField();
        passwordField = new PasswordField();
        loginButton = new Button("Login");

        // Configure event handlers
        loginButton.setOnAction(event -> handleLogin());

        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                new Label("Username:"),
                usernameField,
                new Label("Password:"),
                passwordField,
                loginButton
        );

        // Set up scene and stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Engine Oil Supply Chain");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // Perform login authentication logic here
        // You can use a database or hardcoded credentials for simplicity
        if (authenticate(username, password)) {
            // Enable data insertion fields/buttons
            productField.setDisable(false);
            insertButton.setDisable(false);
        } else {
            // Clear fields and show error message
            usernameField.clear();
            passwordField.clear();
            productField.setDisable(true);
            insertButton.setDisable(true);
            // Show login error message
            // You can display it in a dialog or label, for example
        }
    }

    private boolean authenticate(String username, String password) {
        // Perform login authentication logic here
        // You can use a database or hardcoded credentials for simplicity
        // Return true if authentication is successful, false otherwise
        // You can replace this with your own authentication logic
        return username.equals("admin") && password.equals("password");
    }
}
