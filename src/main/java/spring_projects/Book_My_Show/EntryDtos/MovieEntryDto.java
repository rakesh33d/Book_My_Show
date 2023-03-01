package spring_projects.Book_My_Show.EntryDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring_projects.Book_My_Show.Enums.Genre;
import spring_projects.Book_My_Show.Enums.Language;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieEntryDto {
    private String name;
    private double rating;
    private int duration;
    private Language language;
    private Genre genre;

}
