package lk.ijse.HostelManagementSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    private String reservationId;
    private Date date;
    private String status;


    public Reservation() {
    }

    public Reservation(String reservationId, Date date, String status) {
        this.reservationId = reservationId;
        this.date = date;
        this.status = status;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
