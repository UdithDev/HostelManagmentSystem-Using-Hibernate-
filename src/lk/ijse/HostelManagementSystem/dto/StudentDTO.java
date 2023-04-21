package lk.ijse.HostelManagementSystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private String studentId;
    private String name;
    private String address;
    private String contactNo;
    private String dob;
    private String gender;
}
