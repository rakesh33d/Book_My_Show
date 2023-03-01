package spring_projects.Book_My_Show.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_projects.Book_My_Show.Entities.ShowEntity;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
}
