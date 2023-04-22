package lk.ijse.HostelManagementSystem.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Room {
    @Id
    @Column(nullable = false)
    private String roomId;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String keyMoney;
    @Column(nullable = false)
    private int qty;

    @OneToMany(mappedBy = "room" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Reservation> reservationList=new ArrayList<>();

}
