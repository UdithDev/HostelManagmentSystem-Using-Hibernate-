package lk.ijse.HostelManagementSystem.dao.custom;

import lk.ijse.HostelManagementSystem.Entity.Student;
import lk.ijse.HostelManagementSystem.dao.CrudDAO;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student> {
    List<String> getStIds();
}
