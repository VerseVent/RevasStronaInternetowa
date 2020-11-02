package pl.pronka.spring.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pronka.spring.demo.models.Officer;
import pl.pronka.spring.demo.models.Person;

import java.util.List;

public interface OfficerRepo extends JpaRepository<Officer, Integer> {
    List<Officer> findAllBymail(String search);

}
