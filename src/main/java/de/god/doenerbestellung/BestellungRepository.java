package de.god.doenerbestellung;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bestellung", path = "bestellung")
public interface BestellungRepository extends PagingAndSortingRepository<Bestellung, Long> {

	List<Bestellung> findByBestelldatum(@Param("bestelldatum") Date bestelldatum);

}
