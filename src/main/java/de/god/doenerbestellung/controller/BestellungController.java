package de.god.doenerbestellung.controller;

import java.util.Date;
import java.util.List;

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

		String result = "";
		Iterable<Bestellung> findAll = repositoy.findAll();
		for (Bestellung bestellung : findAll) {
			result += bestellung.toString();
			result += "<br>";
			System.out.println("Name: " + result);
		}
		return "" + result;
	}

	@RequestMapping("/findHeute")
	public List<Bestellung> heutigeBestellungen() {
		return repositoy.findByName("Thomas");
	}

	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Bestellung save(@RequestBody Bestellung bestellung) {

		bestellung.setBestelldatum(new Date());
		return repositoy.save(bestellung);

	}

	// @RequestMapping(value = "/test1", method = RequestMethod.GET)
	// public Bestellung test1(@RequestBody String a, @RequestBody String b) {
	//
	// Bestellung bestellung = new Bestellung();
	// bestellung.setBestelldatum(new Date());
	// return bestellung;
	//
	// }

	@RequestMapping(value = "/saveMe", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Bestellung saveBestellung(String bestellung, String name, String extras, String telefonnummer) {
		System.out.println("Bestellung: " + bestellung + " Name: " + name);
		Bestellung b = new Bestellung();
		b.setName(name);
		b.setExtras(extras);
		b.setBestellung(bestellung);
		b.setBestelldatum(new Date());
		b.setTelefonnummer(telefonnummer);
		return repositoy.save(b);

	}

}
