package spring_projects.Book_My_Show.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_projects.Book_My_Show.Conerters.MovieConverter;
import spring_projects.Book_My_Show.Entities.MovieEntity;
import spring_projects.Book_My_Show.EntryDtos.MovieEntryDto;
import spring_projects.Book_My_Show.Repositories.MovieRepository;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(MovieEntryDto movieEntryDto)throws Exception{
        MovieEntity movieEntity = MovieConverter.convertDtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return "movie added successfully";
    }
}
