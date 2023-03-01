package spring_projects.Book_My_Show.Conerters;

import spring_projects.Book_My_Show.Entities.ShowEntity;
import spring_projects.Book_My_Show.EntryDtos.ShowEntryDto;

public class ShowConverter {

public static ShowEntity convertDtoToEntity(ShowEntryDto showEntryDto){
    return ShowEntity.builder().Date(showEntryDto.getDate()).Time(showEntryDto.getTime()).showType(showEntryDto.getShowType()).build();


}
}
