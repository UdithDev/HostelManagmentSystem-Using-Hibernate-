package lk.ijse.HostelManagementSystem.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes routes, AnchorPane pane) throws IOException {
        Navigation.pane=pane;
        Navigation.pane.getChildren().clear();
        Stage window=(Stage)Navigation.pane.getScene().getWindow();

        switch (routes){
            case LOGIN:
                window.setTitle("Login Form");
                window.setMaxWidth(600);
                window.setMaxHeight(400);
                initUI("LoginForm.fxml");
                break;

            case DASHBOARD:
                window.setTitle("DashBoard Form");
//                window.centerOnScreen();
                window.setResizable(true);
                window.setMaxWidth(980);
                window.setMaxHeight(650);
                initUI("DashBoardForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();

    }
}

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/HostelManagementSystem/view/"+ location)));
    }
    }
