package docs.quickstart.repository;

import docs.quickstart.domain.Person;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository
  extends
    PagingAndSortingRepository<Person, Long>, CrudRepository<Person, Long> {
  List<Person> findByLastName(@Param("name") String name);
}
