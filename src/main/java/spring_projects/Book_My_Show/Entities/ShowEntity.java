package spring_projects.Book_My_Show.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import spring_projects.Book_My_Show.Enums.ShowType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate Date;
    private LocalTime Time;
    @Enumerated(value = EnumType.STRING)
    private ShowType showType;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;

    //it is parent w.r.t. tickets
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<TicketEntity> listOfBookedTickets = new ArrayList<>();

    //it is child w.r.t theaterEntity
    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

    //it is parent for show seat entity
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<ShowSeatEntity>listOfShowSeat = new ArrayList<>();

    // it is child for movie entity
    @ManyToOne
    @JoinColumn
    private MovieEntity movieEntity;
}
