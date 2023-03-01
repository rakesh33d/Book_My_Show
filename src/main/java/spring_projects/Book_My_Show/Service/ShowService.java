package spring_projects.Book_My_Show.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_projects.Book_My_Show.Conerters.ShowConverter;
import spring_projects.Book_My_Show.Conerters.TheaterConverter;
import spring_projects.Book_My_Show.Entities.*;
import spring_projects.Book_My_Show.EntryDtos.ShowEntryDto;
import spring_projects.Book_My_Show.EntryDtos.TheaterEntryDto;
import spring_projects.Book_My_Show.Enums.SeatType;
import spring_projects.Book_My_Show.Repositories.MovieRepository;
import spring_projects.Book_My_Show.Repositories.ShowRepository;
import spring_projects.Book_My_Show.Repositories.TheaterRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    public String addShow(ShowEntryDto showEntryDto){
        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showEntryDto);

        //set foreign key attributes
        int movieId=showEntryDto.getMovieId();
        MovieEntity movieEntity = movieRepository.findById(movieId).get();

        int theaterId = showEntryDto.getTheaterId();
        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();

        //set them
        showEntity.setTheaterEntity(theaterEntity);
        showEntity.setMovieEntity(movieEntity);

        List<ShowSeatEntity>showSeatEntityList = ceateShowSeats(showEntryDto,showEntity);

        showEntity.setListOfShowSeat(showSeatEntityList);

        //we also need to update parent attributes
        //get and set attributes and save parent
        List<ShowEntity>showEntityList = movieEntity.getShowEntityList();
        showEntityList.add(showEntity);
        movieEntity.setShowEntityList(showEntityList);

        movieRepository.save(movieEntity);

        //save other parent also
        List<ShowEntity>showEntityList1 = theaterEntity.getShowEntityList();

        showEntityList1.add(showEntity);
        theaterEntity.setShowEntityList(showEntityList1);

        theaterRepository.save(theaterEntity);

        return "show and show seats added";
    }
    private List<ShowSeatEntity> ceateShowSeats(ShowEntryDto showEntryDto,ShowEntity showEntity){
        //now goal is to create the show seat entity
        //we need to set its attributes
        List<TheaterSeatEntity>theaterSeatEntityList = showEntity.getTheaterEntity().getTheaterSeatEntityList();
        List<ShowSeatEntity>showSeatEntityList = new ArrayList<>();
//        for(int count = 1; count<= theaterSeatEntityList.size();count++){
//            ShowSeatEntity showSeatEntity = new ShowSeatEntity();
//            showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());
//        }
        for(TheaterSeatEntity theaterSeatEntity: theaterSeatEntityList){
            //create show seat entity for every theater seat
            ShowSeatEntity showSeatEntity = new ShowSeatEntity();
            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());
            if(theaterSeatEntity.getSeatType().equals(SeatType.CLASSIC)){
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());
            }
            else
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());
            showSeatEntity.setBooked(false);

            //set foreign key
            showSeatEntity.setShowEntity(showEntity);

            //add it to list
            showSeatEntityList.add(showSeatEntity);


        }

        return showSeatEntityList;

    }


}
