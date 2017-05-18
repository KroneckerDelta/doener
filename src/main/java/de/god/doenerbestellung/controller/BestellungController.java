package de.god.doenerbestellung.controller;

import java.util.ArrayList;
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
		}
		System.out.println("Name: " + result);
		return "" + result;
	}

	@RequestMapping(value = "/findHeute", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
	public List<Bestellung> heutigeBestellungen() {

		String dateAsString = Heute.get();

		return repositoy.findByBestelldatum(dateAsString);

	}

	@RequestMapping(value = "/findHeutePdf", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_PDF_VALUE)
	public List<Bestellung> heutigeBestellungenAlsPdf() {

		String dateAsString = Heute.get();

		return repositoy.findByBestelldatum(dateAsString);

	}

	@RequestMapping(value = "/emailSenden", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
	public String emailVersenden() {
		List<String> alleMails = new ArrayList<>();
		List<Bestellung> heutigeBestellungen = repositoy.findByBestelldatum(Heute.get());
		for (Bestellung bestellung : heutigeBestellungen) {
			String email = bestellung.getEmail();
			alleMails.add(email);
		}

		return sendeEMails(alleMails);
	}

	private String sendeEMails(List<String> alleMails) {

		return "noch nicht implementiert! Wenn Du Entwickler bist, kannst Du das gerne machen. :-) ";
	}

	@RequestMapping(value = "/findPerDate", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public List<Bestellung> heutigeBestellungen(@RequestBody String containsDate) {
		String dateAsString = containsDate.substring(containsDate.indexOf("=") + 1, containsDate.length());

		return repositoy.findByBestelldatum(dateAsString);

	}

	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Bestellung save(@RequestBody Bestellung bestellung) {

		String bestelldatum = Heute.get();

		bestellung.setBestelldatum(bestelldatum);
		return repositoy.save(bestellung);

	}

	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	public Bestellung requestKontrollMethode(@RequestBody String a, @RequestBody String b) {
		System.out.println("Request: " + a);
		System.out.println("Und: " + b);

		Bestellung bestellung = new Bestellung();
		bestellung.setBestelldatum("nur ein String");
		bestellung.setBestellung("bestel1");
		bestellung.setEmail("email1");
		bestellung.setExtras("extra1");
		bestellung.setFleisch("fleisch1");
		bestellung.setName("name1");
		bestellung.setSauce("sauce1");
		bestellung.setTelefonnummer("tel1");
		return bestellung;

	}

	@Transactional
	@RequestMapping(value = "/saveMe", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Bestellung saveBestellung(String bestellung, String name, String extras, String telefonnummer,
			String fleisch, String sauce, String email) {
		System.out.println("Bestellung: " + bestellung + " Name: " + name);
		Bestellung b = new Bestellung();
		b.setName(name);
		b.setExtras(extras);
		b.setBestellung(bestellung);
		b.setBestelldatum(Heute.get());
		b.setTelefonnummer(telefonnummer);
		b.setFleisch(fleisch == null ? "ohne" : fleisch);
		b.setEmail(email);
		b.setSauce(sauce == null ? "ohne" : sauce);
		System.out.println("Bestellung: " + b + " Name: " + name);
		return repositoy.save(b);

	}

}
