package spring_projects.Book_My_Show.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_projects.Book_My_Show.EntryDtos.ShowEntryDto;
import spring_projects.Book_My_Show.Repositories.ShowRepository;
import spring_projects.Book_My_Show.Service.ShowService;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;
    @PostMapping("/add")
    public String addShow(@RequestBody ShowEntryDto showEntryDto){

        return showService.addShow(showEntryDto);
    }
}
