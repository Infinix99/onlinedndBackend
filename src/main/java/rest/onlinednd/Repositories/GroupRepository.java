package rest.onlinednd.Repositories;

import org.springframework.data.repository.CrudRepository;
import rest.onlinednd.Entities.Group;

public interface GroupRepository extends CrudRepository<Group, Integer> {
}
