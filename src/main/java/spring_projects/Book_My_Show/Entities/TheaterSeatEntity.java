package spring_projects.Book_My_Show.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring_projects.Book_My_Show.Enums.SeatType;

import javax.persistence.*;

@Entity
@Table(name = "theaterSeats")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TheaterSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String SeatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    //it is child for theater entity
    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;
}
