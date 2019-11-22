package de.god.doenerbestellung.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.god.doenerbestellung.domain.Bestellung;

@RepositoryRestResource(collectionResourceRel = "bestellung", path = "bestellung")
public interface BestellungRepository extends PagingAndSortingRepository<Bestellung, Long> {
	/**
	 * Liefert die Bestellungen nach einen Datum zurück
	 * 
	 * @param bestelldatum
	 * @param typ
	 * @return kann leer sein
	 */

	List<Bestellung> findByBestelldatumAndTypOrderByBestellung(@Param("bestelldatum") String bestelldatum, @Param("typ") String typ);

}
