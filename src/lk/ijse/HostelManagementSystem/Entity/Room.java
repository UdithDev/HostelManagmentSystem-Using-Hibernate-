package lk.ijse.HostelManagementSystem.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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






}
