package rest.onlinednd.Repositories.Charactersheet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;

public interface CharactersheetRepository extends CrudRepository<Charactersheet, Integer> {

    //find by Charactername
    @Query(value="select c from Charactersheet c where c.characterName = :text",   nativeQuery =true ) Charactersheet findCharacterByName(@Param("text") String text);
    //@Query(value="select u from Player u where u.email = :text or u.name = :text", nativeQuery = true) Player findPlayerByEmailOrName(@Param("text") String text);


}
