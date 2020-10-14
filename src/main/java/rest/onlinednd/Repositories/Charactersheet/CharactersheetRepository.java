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

    //find by ID
    @Query(value = "select * from Charactersheet c where c.charactersheetID = :characterid"
            ,nativeQuery = true)
        Charactersheet findCharactersheetByID(@Param("characterid") int characterid);


    //find all
    @Query(value = "Select * from Charactersheet c WHERE c.user_userid = :UserID"
            , nativeQuery = true )
        Set<Charactersheet> findAllCharactersheets(@Param("UserID") int UserID);

    //find all from Group
    @Query(value = "Select * from Charactersheet c WHERE c.groupid = :Groupid"
            , nativeQuery = true)
    Set<Charactersheet> findAllCharsFromGroup(@Param("Groupid") int Groupid);

}
