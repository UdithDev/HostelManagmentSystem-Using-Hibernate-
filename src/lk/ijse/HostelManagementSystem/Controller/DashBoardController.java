package lk.ijse.HostelManagementSystem.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.HostelManagementSystem.util.Navigation;
import lk.ijse.HostelManagementSystem.util.Routes;

import java.io.IOException;
import java.net.URL;

public class DashBoardController {
    public AnchorPane pane;
    public JFXButton btnLogOut;
    public Label lbLoading;
    public JFXButton btnAddStudent;
    public AnchorPane loadFormContext;

    public void initialize(){
        Timeline timeline=new Timeline();

        KeyFrame keyFrame1=new KeyFrame(Duration.millis(1000), event -> {
            lbLoading.setText("Hello...!!!     Hello...!!!      Hello...!!! ");
        });
        KeyFrame keyFrame2=new KeyFrame(Duration.millis(5000),event -> {
            lbLoading.setText(" Welcome  To D24  Hostel....!!!");
        });
        KeyFrame keyFrame3=new KeyFrame(Duration.millis(8000),event -> {
            lbLoading.setText(" Wish you a  Happy New Year!!!");
        });

        KeyFrame keyFrame4=new KeyFrame(Duration.millis(10000),event -> {

        });
        timeline.getKeyFrames().addAll(keyFrame1,keyFrame2,keyFrame3,keyFrame4);
        timeline.playFromStart();
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void btnAddStudentOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/StudentForm.fxml");
        assert resource!=null;
        Parent load = FXMLLoader.load(resource);
        loadFormContext.getChildren().clear();
        loadFormContext.getChildren().add(load);
    }
}
