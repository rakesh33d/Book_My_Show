package spring_projects.Book_My_Show.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String movieName;
    private int totalAmount;
    private String ticketId = UUID.randomUUID().toString();
    private LocalDate showDate;
    private LocalTime showTime;
    private String theaterName;
    private String bookedSeats;
    //private List<TicketEntity> bookedTickets= new ArrayList<>();
    //this is child w.r.t. UserEntity
    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

    //it is child w.r.t ShowEntity
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;
}
