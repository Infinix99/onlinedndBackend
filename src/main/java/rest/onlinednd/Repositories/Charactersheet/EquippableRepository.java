package rest.onlinednd.Repositories.Charactersheet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rest.onlinednd.Entities.Charactersheet.Equippable;
import rest.onlinednd.Entities.Charactersheet.Notes;

import java.util.Set;

public interface EquippableRepository extends CrudRepository<Equippable, Integer> {

    @Query(value = "Select * from equippable e WHERE e.charactersheet_charactersheetid = :charactersheetid"
            , nativeQuery = true )
    Set<Equippable> findAllEquippablesFromSheet(@Param("charactersheetid") int charactersheetid);

    @Query(value = "Select * from equippable e WHERE e.charactersheet_charactersheetid = :charactersheetid AND e.equippableid = :equippableid"
            , nativeQuery = true)
    Equippable findEquippableByIds(@Param("charactersheetid") int charactersheetid, @Param("equippableid") int equippableid);

}
