package spring_projects.Book_My_Show.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_projects.Book_My_Show.Conerters.TicketConverter;
import spring_projects.Book_My_Show.Entities.ShowEntity;
import spring_projects.Book_My_Show.Entities.ShowSeatEntity;
import spring_projects.Book_My_Show.Entities.TicketEntity;
import spring_projects.Book_My_Show.Entities.UserEntity;
import spring_projects.Book_My_Show.EntryDtos.TicketEntryDto;
import spring_projects.Book_My_Show.Repositories.ShowRepository;
import spring_projects.Book_My_Show.Repositories.TicketRepository;
import spring_projects.Book_My_Show.Repositories.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;
    public String bookTickets (TicketEntryDto ticketEntryDto) throws Exception{
        //1.convert dto to entity
        //2.set attributes
        //3.save parent
        TicketEntity ticketEntity = TicketConverter.convertDtoToEntity(ticketEntryDto);

        int showId = ticketEntryDto.getShowId();
        ShowEntity showEntity = showRepository.findById(showId).get();

        //done some validations
        //like seat is available or not
        boolean isValidRequest = checkValidityOfRequestedSeat(ticketEntryDto);

        if(isValidRequest==false){
            throw  new Exception("requested seats are not available");
        }

        //calculate total amount
        List<String>requestedSeats = ticketEntryDto.getRequestedSeats();

        List<ShowSeatEntity>listOfSeats = showEntity.getListOfShowSeat();

        int totalAmount=0;
        for(ShowSeatEntity showSeatEntity: listOfSeats){
            if(requestedSeats.contains(showSeatEntity)){
                totalAmount = totalAmount+showSeatEntity.getPrice();
                showSeatEntity.setBooked(true);
                showSeatEntity.setBookedAt(new Date());
            }
        }

        ticketEntity.setTotalAmount(totalAmount);

        //set other attributes
        ticketEntity.setMovieName(showEntity.getMovieEntity().getName());
        ticketEntity.setShowDate(showEntity.getDate());
        ticketEntity.setShowTime(showEntity.getTime());
        ticketEntity.setTheaterName(showEntity.getTheaterEntity().getName());


        //we need to set that string that talked about requested seats
        String allotedSeats = getAllotedSeatsFromShowseat(requestedSeats);
        ticketEntity.setBookedSeats(allotedSeats);


        //set foreign key attributes
        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId()).get();
        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);

        ticketEntity = ticketRepository.save(ticketEntity);

        //save the parents
        List<TicketEntity>bookedTickets = userEntity.getBookedTickets();
        bookedTickets.add(ticketEntity);
        userEntity.setBookedTickets(bookedTickets);

        userRepository.save(userEntity);

        //save other parent also
        List<TicketEntity>ticketEntityList = showEntity.getListOfBookedTickets();
        ticketEntityList.add(ticketEntity);
        showEntity.setListOfBookedTickets(ticketEntityList);

        showRepository.save(showEntity);



        return "Tickets booked successfully";
    }
    private boolean checkValidityOfRequestedSeat(TicketEntryDto ticketEntryDto){

        int showId = ticketEntryDto.getShowId();
        List<String>requestedSeats = ticketEntryDto.getRequestedSeats();
        ShowEntity showEntity = showRepository.findById(showId).get();
        List<ShowSeatEntity>listOfSeats = showEntity.getListOfShowSeat();

        //iterate over seats for this particular show
        for(ShowSeatEntity seat: listOfSeats){
            String seatNo = seat.getSeatNo();

            if(requestedSeats.contains(seatNo)){
                if(seat.isBooked()==true){
                    return false;
                }
            }
        }
        //iterated over all seats and all are valid and not booked seats
        return true;

    }
    private String getAllotedSeatsFromShowseat(List<String> requestedSeats){
        String res = "";
        for(String seat : requestedSeats){
            res = res +seat +", ";
        }
        return res;
    }
}
