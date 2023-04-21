package lk.ijse.HostelManagementSystem.Controller;


import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.HostelManagementSystem.util.Navigation;
import lk.ijse.HostelManagementSystem.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {
    public JFXButton btnLogin;
    public TextField txtUserName;

    public AnchorPane pane;

    public ImageView btnCloseEye;
    public ImageView btnOpenEye;
    public PasswordField txtHidePassword;
    public TextField txtShowPassword;

    String password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtShowPassword.setVisible(false);
        btnOpenEye.setVisible(false);
    }


    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

        if (txtUserName.getText().toString().equals("") && txtHidePassword.getText().equals("")) {
            Navigation.navigate(Routes.DASHBOARD, pane);
        } else if (txtUserName.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Username is required !",
                    ButtonType.OK).show();
        } else if (txtHidePassword.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Password is required !",
                    ButtonType.OK).show();
        }
    }


    public void passwordOnAction(ActionEvent actionEvent) throws IOException {
        btnLoginOnAction(actionEvent);
    }

    public void HidePasswordOnAction(KeyEvent keyEvent) {
        password = txtHidePassword.getText();
        txtShowPassword.setText(password);
    }

    public void ShowPasswordOnAction(KeyEvent keyEvent) {
        password = txtShowPassword.getText();
        txtHidePassword.setText(password);
    }

    public void CloseEyeOnAction(MouseEvent mouseEvent) {
        txtShowPassword.setVisible(true);
        btnOpenEye.setVisible(true);
        btnCloseEye.setVisible(false);
        txtHidePassword.setVisible(false);
    }

    public void OpenEyeOnAction(MouseEvent mouseEvent) {
        txtShowPassword.setVisible(false);
        btnOpenEye.setVisible(false);
        btnCloseEye.setVisible(true);
        txtHidePassword.setVisible(true);
    }
}


