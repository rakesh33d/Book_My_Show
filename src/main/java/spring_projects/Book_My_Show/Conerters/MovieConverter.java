package spring_projects.Book_My_Show.Conerters;

import spring_projects.Book_My_Show.Entities.MovieEntity;
import spring_projects.Book_My_Show.EntryDtos.MovieEntryDto;

public class MovieConverter {
    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto){
        return MovieEntity.builder().name(movieEntryDto.getName()).genre(movieEntryDto.getGenre()).duration(movieEntryDto.getDuration()).rating(movieEntryDto.getRating()).language(movieEntryDto.getLanguage()).build();

    }
}
