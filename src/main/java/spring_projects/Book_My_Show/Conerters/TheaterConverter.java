package spring_projects.Book_My_Show.Conerters;

import spring_projects.Book_My_Show.Entities.TheaterEntity;
import spring_projects.Book_My_Show.EntryDtos.TheaterEntryDto;

public class TheaterConverter {
    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto){
        return TheaterEntity.builder().name(theaterEntryDto.getName()).location(theaterEntryDto.getLocation()).build();
    }
}
