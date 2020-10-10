package rest.onlinednd.Repositories.Charactersheet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Charactersheet.Notes;

import java.util.Set;

public interface CharactersheetRepository extends CrudRepository<Charactersheet, Integer> {

    //find by Charactername
    @Query(value="select * from Charactersheet c where c.characterName = :text"
            ,   nativeQuery =true )
        Charactersheet findCharacterByName(@Param("text") String text);
         //Bsp. grp 2 :  @Query(value="select u from Player u where u.email = :text or u.name = :text", nativeQuery = true) Player findPlayerByEmailOrName(@Param("text") String text);

    @Query(value = "select * from Charactersheet c where c.charactersheetID = :characterid"
            ,nativeQuery = true)
        Charactersheet findCharactersheetByID(@Param("characterid") int characterid);




}
