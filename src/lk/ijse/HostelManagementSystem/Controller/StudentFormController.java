package lk.ijse.HostelManagementSystem.Controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.HostelManagementSystem.Entity.Student;
import lk.ijse.HostelManagementSystem.bo.BoFactory;
import lk.ijse.HostelManagementSystem.bo.custom.StudentBo;
import lk.ijse.HostelManagementSystem.dto.StudentDTO;
import org.hibernate.Session;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class StudentFormController  implements Initializable {

    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentContact;
   
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXComboBox cmbGender;
    public JFXDatePicker txtDatePicker;
    public TableView tblStudent;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colDob;
    public TableColumn colGender;



    private Session session;
    private StudentBo studentBo=(StudentBo) BoFactory.getBo(BoFactory.BOTypes.STUDENT);

    public void btnAddOnAction(ActionEvent actionEvent) {
        String dob =String.valueOf(txtDatePicker.getValue());
        String gender = cmbGender.getValue().toString();
        StudentDTO studentDTO=new StudentDTO(txtStudentId.getText(),txtStudentName.getText(),txtStudentAddress.getText(),txtStudentContact.getText(),dob,gender);


        List<StudentDTO> allStudents=studentBo.loadAll();

        for(StudentDTO s : allStudents){
            if(s.getStudentId().equals(txtStudentId.getText())){
                new Alert(Alert.AlertType.ERROR, "This ID Already Have").show();
                break;
            }else {
                boolean isCheckValidate= checkValidation();
                if(isCheckValidate) {
                    studentBo.saveStudent(studentDTO);
                    new Alert(Alert.AlertType.CONFIRMATION, "Student save").show();
                    tblStudent.getItems().clear();
                    clearData();
                    loadAllStudent();
                }
            }
        }

    }

    private void clearData() {
        txtStudentId.clear();
        txtStudentName.clear();
        txtStudentAddress.clear();
        txtStudentContact.clear();
        txtDatePicker.setValue(null);
        cmbGender.setValue(null);
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setGender();
        setTableStudent();
        loadAllStudent ();
    }



    private void setTableStudent() {
        colStudentId.setCellValueFactory (new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory (new PropertyValueFactory<> ("studentName"));
        colAddress.setCellValueFactory (new PropertyValueFactory<> ("Address"));
        colContactNo.setCellValueFactory (new PropertyValueFactory<> ("contact"));
        colDob.setCellValueFactory (new PropertyValueFactory<> ("dob"));
        colGender.setCellValueFactory (new PropertyValueFactory<> ("gender"));
    }
    private void loadAllStudent() {

    }

    private void setGender() {
        ObservableList<String> data= FXCollections.observableArrayList("Male","Female","Other");
        cmbGender.setItems(data);
    }

    private boolean checkValidation(){
        String nameText=txtStudentName.getText();
        String addressText= txtStudentAddress.getText();
        String contactText=txtStudentContact.getText();


        if(!addressText.matches(".{2,}")){
            new Alert(Alert.AlertType.ERROR,"Address should be at least 3 characters long").show();
            txtStudentAddress.requestFocus();
            return false;
        }else if(!contactText.matches(".*(?:7|0|(?:\\\\\\\\+94))[0-9]{9,10}")){
            new Alert(Alert.AlertType.ERROR, "Invalid contact").show();
            txtStudentContact.requestFocus();
            return false;
        }else{
            return true;
        }
    }
}
