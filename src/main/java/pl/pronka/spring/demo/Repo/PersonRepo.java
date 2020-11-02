package pl.pronka.spring.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pronka.spring.demo.models.Person;

import java.util.List;

public interface PersonRepo extends JpaRepository <Person, Integer> {
    List<Person> findAllBymail(String search);

}

