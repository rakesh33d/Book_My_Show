package spring_projects.Book_My_Show.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_projects.Book_My_Show.EntryDtos.TicketEntryDto;
import spring_projects.Book_My_Show.Service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping("/add")
    public ResponseEntity<String> bookTickets (@RequestBody TicketEntryDto ticketEntryDto){
        try{
            String response = ticketService.bookTickets(ticketEntryDto);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
