package spring_projects.Book_My_Show.EntryDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntryDto {
    //it will not contain foreign key and auto generated attributes

    private String name;
    private String email;
    private int age;
    private String mobNo;
    private String address;
}
