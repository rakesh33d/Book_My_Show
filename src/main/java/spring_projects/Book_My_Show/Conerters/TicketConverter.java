package spring_projects.Book_My_Show.Conerters;

import spring_projects.Book_My_Show.Entities.TicketEntity;
import spring_projects.Book_My_Show.EntryDtos.TicketEntryDto;

public class TicketConverter {

    public static TicketEntity convertDtoToEntity(TicketEntryDto ticketEntryDto){
        TicketEntity ticketEntity = new TicketEntity();
        return ticketEntity;
    }
}
