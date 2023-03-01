package spring_projects.Book_My_Show.EntryDtos;

import lombok.Data;
import spring_projects.Book_My_Show.Enums.ShowType;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDto {
    LocalDate Date;
    LocalTime Time;
    private ShowType showType;

}
