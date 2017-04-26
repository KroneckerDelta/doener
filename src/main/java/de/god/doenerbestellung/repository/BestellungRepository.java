package de.god.doenerbestellung.repository;

import java.util.Date;
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
	 * @return kann leer sein
	 */
	List<Bestellung> findByBestelldatum(@Param("bestelldatum") Date bestelldatum);

	/**
	 * Liefert die Bestellungen nach einem Namen zurück.
	 * 
	 * @param bestelldatum
	 * @return kann leer sein
	 */
	List<Bestellung> findByName(@Param("name") String bestelldatum);

}
