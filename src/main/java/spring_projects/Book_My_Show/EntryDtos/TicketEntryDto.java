package spring_projects.Book_My_Show.EntryDtos;

import lombok.Data;
import spring_projects.Book_My_Show.Entities.TicketEntity;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketEntryDto {
    private int showId;
    private int userId;
    private List<String> requestedSeats = new ArrayList<>();
}
