package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.dto.StudentDTO;

import java.util.List;

public interface StudentBo extends SuperBo {
    List<StudentDTO> loadAll();
    boolean saveStudent(StudentDTO studentDTO);
}
