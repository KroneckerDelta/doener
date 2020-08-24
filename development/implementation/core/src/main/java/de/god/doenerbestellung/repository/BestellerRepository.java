package de.god.doenerbestellung.repository;

import de.god.doenerbestellung.domain.Besteller;
import de.god.doenerbestellung.domain.Bestellung;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "besteller", path = "besteller")
public interface BestellerRepository extends PagingAndSortingRepository<Besteller, Long> {

    List<Besteller> findByBestelldatum(@Param("bestelldatum") String bestelldatum);
}
