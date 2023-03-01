package spring_projects.Book_My_Show.Conerters;

import spring_projects.Book_My_Show.Entities.UserEntity;
import spring_projects.Book_My_Show.EntryDtos.UserEntryDto;

public class UserConverter {
    //static is kept to avoid calling it via objects/instances
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){

        return UserEntity.builder().age(userEntryDto.getAge()).mobNo(userEntryDto.getMobNo()).name(userEntryDto.getName()).address(userEntryDto.getAddress()).email(userEntryDto.getEmail()).build();

    }
}
