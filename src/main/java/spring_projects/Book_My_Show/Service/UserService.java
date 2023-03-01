package spring_projects.Book_My_Show.Service;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_projects.Book_My_Show.Conerters.UserConverter;
import spring_projects.Book_My_Show.Entities.UserEntity;
import spring_projects.Book_My_Show.EntryDtos.UserEntryDto;
import spring_projects.Book_My_Show.Repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto) throws Exception,NullPointerException{
   UserEntity userEntity = UserConverter.convertDtoToEntity(userEntryDto);
   userRepository.save(userEntity);
   return "user added";
    }
}
