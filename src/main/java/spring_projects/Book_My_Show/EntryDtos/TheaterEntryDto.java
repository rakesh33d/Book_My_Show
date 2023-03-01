package spring_projects.Book_My_Show.EntryDtos;

import lombok.Data;

@Data
public class TheaterEntryDto {
    private String name;
    private String Location;
    private int classicSeatCount;
    private int premiumSeatCount;

}
