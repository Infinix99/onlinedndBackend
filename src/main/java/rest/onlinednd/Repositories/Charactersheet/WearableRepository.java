package rest.onlinednd.Repositories.Charactersheet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rest.onlinednd.Entities.Charactersheet.Equippable;
import rest.onlinednd.Entities.Charactersheet.Wearable;

import java.util.Set;

public interface WearableRepository extends CrudRepository<Wearable, Integer> {

    @Query(value = "Select * from wearable w WHERE w.charactersheet_charactersheetid = :charactersheetid"
            , nativeQuery = true )
    Set<Wearable> findAllWearableFromSheet(@Param("charactersheetid") int charactersheetid);

    @Query(value = "Select * from wearable w WHERE w.charactersheet_charactersheetid = :charactersheetid AND w.wearableid = :wearableid"
            , nativeQuery = true)
    Wearable findWearableByIds(@Param("charactersheetid") int charactersheetid, @Param("wearableid") int wearableid);

}
