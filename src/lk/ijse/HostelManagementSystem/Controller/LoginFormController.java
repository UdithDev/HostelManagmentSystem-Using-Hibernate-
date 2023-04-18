package lk.ijse.HostelManagementSystem.Controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.HostelManagementSystem.util.Navigation;
import lk.ijse.HostelManagementSystem.util.Routes;

import java.io.IOException;

public class LoginFormController {
    public JFXButton btnLogin;
    public ImageView btnPasswordView;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane pane;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().toString().equals("") && txtPassword.getText().equals("") ){
            Navigation.navigate(Routes.DASHBOARD,pane);
        }

        else if(txtUserName.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Username is required !",
                    ButtonType.OK).show();
        }else if(txtPassword.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Password is required !",
                    ButtonType.OK).show();
        }
    }

    public void passwordOnAction(ActionEvent actionEvent) throws IOException {
        btnLoginOnAction(actionEvent);
    }
}
