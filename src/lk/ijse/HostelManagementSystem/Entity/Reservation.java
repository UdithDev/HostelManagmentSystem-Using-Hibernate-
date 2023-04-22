package lk.ijse.HostelManagementSystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Reservation {
    @Id
    private String reservationId;
    private Date date;
    private String status;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Room room;


}
