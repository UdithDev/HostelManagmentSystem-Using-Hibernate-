package lk.ijse.HostelManagementSystem.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @Column(nullable = false)
    private String studentId;

    @Column(name = "full_name" ,nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String contactNo;

    @Column(nullable = false)
    private String dob;

    @Column(nullable = false)
    private String gender;


}
