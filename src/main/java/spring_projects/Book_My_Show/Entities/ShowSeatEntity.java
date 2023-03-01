package spring_projects.Book_My_Show.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring_projects.Book_My_Show.Enums.SeatType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "showseats")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isBooked;
    private int price;
    private String seatNo;
    private Date bookedAt;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    //it is child for show entity
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;

}
