package spring_projects.Book_My_Show.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_projects.Book_My_Show.Conerters.TheaterConverter;
import spring_projects.Book_My_Show.Entities.TheaterEntity;
import spring_projects.Book_My_Show.Entities.TheaterSeatEntity;
import spring_projects.Book_My_Show.EntryDtos.TheaterEntryDto;
import spring_projects.Book_My_Show.Enums.SeatType;
import spring_projects.Book_My_Show.Repositories.TheaterRepository;
import spring_projects.Book_My_Show.Repositories.TheaterSeatRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;


    public String addTheater(TheaterEntryDto theaterEntryDto)throws Exception{

        //done some validations
        if(theaterEntryDto.getName()==null || theaterEntryDto.getLocation()==null){
            throw new Exception("Theater does not exist");
        }


        /*
        * 1. create theater seats
        * 2.I need to save theater : i need theater entity
        * 3.Always set the attributes before saving
        * */

        TheaterEntity theaterEntity = TheaterConverter.convertDtoToEntity(theaterEntryDto);

        //set the attributes(create theater seats)
        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDto,theaterEntity);

        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);

        theaterRepository.save(theaterEntity);
        //theater seats will automatically be saved


        return "Theater and theater seats added";
    }
    public List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto,TheaterEntity theaterEntity){
        //theaterEntity is a attribute which also needs to be set so it will come from function
        List<TheaterSeatEntity>theaterSeatEntityList= new ArrayList<>();
        for(int count =1;count<= theaterEntryDto.getClassicSeatCount();count++){
            //we need to make a new theaterSeat Entity
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder().theaterEntity(theaterEntity).seatType(SeatType.CLASSIC).SeatNo(count+"C").build();
            theaterSeatEntityList.add(theaterSeatEntity);
        }
        for(int count =1; count<= theaterEntryDto.getPremiumSeatCount(); count++){
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder().theaterEntity(theaterEntity).seatType(SeatType.PREMIUM).SeatNo(count+"P").build();
            theaterSeatEntityList.add(theaterSeatEntity);
        }

        //not saving the child here
      return theaterSeatEntityList;

    }
}
