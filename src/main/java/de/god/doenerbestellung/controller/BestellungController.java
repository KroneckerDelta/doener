package de.god.doenerbestellung.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.god.doenerbestellung.domain.Bestellung;
import de.god.doenerbestellung.repository.BestellungRepository;

@RestController
public class BestellungController {

	private BestellungRepository repositoy;

	@Autowired
	public BestellungController(BestellungRepository repositoy) {
		this.repositoy = repositoy;
	}

	@RequestMapping("/findAll")
	public String showAll() {
		Iterable<Bestellung> findAll = repositoy.findAll();

		return "Bestellungen: ";
	}

	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Bestellung save(@RequestBody Bestellung bestellung) {

		bestellung.setBestelldatum(new Date());
		return repositoy.save(bestellung);

	}

}
