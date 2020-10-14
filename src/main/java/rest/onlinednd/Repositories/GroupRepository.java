package rest.onlinednd.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Group;
import rest.onlinednd.Entities.User;

import java.util.Set;

public interface GroupRepository extends CrudRepository<Group, Integer> {

    //Find by ID
    @Query(value = "select * from group_table g where g.groupid = :Groupid"
            ,nativeQuery = true)
    Group findGroupByID(@Param("Groupid") int Groupid);








    }

