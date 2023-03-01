package spring_projects.Book_My_Show.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_projects.Book_My_Show.Conerters.ShowConverter;
import spring_projects.Book_My_Show.Entities.ShowEntity;
import spring_projects.Book_My_Show.Entities.TicketEntity;
import spring_projects.Book_My_Show.EntryDtos.ShowEntryDto;
import spring_projects.Book_My_Show.Repositories.ShowRepository;

import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    public String addShow(ShowEntryDto showEntryDto){
        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showEntryDto);

        //set foreign key attributes
       // List<TicketEntity> ticketEntityList = createTicketsList();


        return "show added";
    }
//    public List<TicketEntity> createTicketsList(){
//
//    }

}
