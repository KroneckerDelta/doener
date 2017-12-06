package de.god.doenerbestellung.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.god.doenerbestellung.domain.Bestellung;
import de.god.doenerbestellung.repository.BestellungRepository;

/**
 * Controller for Bestellungen
 * 
 * @author tmichael
 *
 */
@RestController()
public class BestellungController {

	private BestellungRepository repositoy;

	@Autowired
	public BestellungController(BestellungRepository repositoy) {
		this.repositoy = repositoy;
	}

	@RequestMapping("/api/findAll")
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

	@RequestMapping(value = "/api/findHeute", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
	public List<Bestellung> heutigeBestellungen(HttpServletResponse response) {

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");

		String dateAsString = Heute.get();

		return repositoy.findByBestelldatumOrderByBestellung(dateAsString);

	}

	@Transactional
	@CrossOrigin(origins = { "http://localhost:3000", "http://10.0.10.2:3000" }, allowCredentials = "true", allowedHeaders = "*")
	@RequestMapping(value = "/api/bestellung/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		System.out.println("Lösche Bestellung: " + id);
		repositoy.delete(id);
	}

	@Transactional
	@CrossOrigin(origins = { "http://localhost:3000", "http://10.0.10.2:3000" }, allowCredentials = "true", allowedHeaders = "*")
	@RequestMapping(value = "/api/bestellung", method = RequestMethod.PUT, consumes = MediaType.ALL_VALUE)
	public void update(@RequestBody Bestellung bestellung) {
		System.out.println("Speichere Bestellung: " + bestellung);

		repositoy.save(bestellung);
	}

	@RequestMapping(value = "/api/findHeutePdf", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_PDF_VALUE)
	public List<Bestellung> heutigeBestellungenAlsPdf() {

		String dateAsString = Heute.get();

		return repositoy.findByBestelldatumOrderByBestellung(dateAsString);

	}

	@RequestMapping(value = "/api/emailSenden", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
	public String emailVersenden() {
		List<String> alleMails = new ArrayList<>();
		List<Bestellung> heutigeBestellungen = repositoy.findByBestelldatumOrderByBestellung(Heute.get());
		for (Bestellung bestellung : heutigeBestellungen) {
			String email = bestellung.getEmail();
			alleMails.add(email);
		}

		return sendeEMails(alleMails);
	}

	private String sendeEMails(List<String> alleMails) {

		return "noch nicht implementiert! Wenn Du Entwickler bist, kannst Du das gerne machen. :-) ";
	}

	@RequestMapping(value = "/api/findPerDate", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public List<Bestellung> heutigeBestellungen(@RequestBody String containsDate) {
		String dateAsString = containsDate.substring(containsDate.indexOf("=") + 1, containsDate.length());

		return repositoy.findByBestelldatumOrderByBestellung(dateAsString);

	}

	@Transactional
	@RequestMapping(value = "/api/save", method = RequestMethod.POST)
	public Bestellung save2(@RequestBody Bestellung bestellung) {
		String bestelldatum = Heute.get();

		bestellung.setBestelldatum(bestelldatum);
		System.out.println("Versuche zu speichern: " + bestelldatum);
		Bestellung save = repositoy.save(bestellung);
		System.out.println("Gespeichert: " + save);
		return save;

	}

	@RequestMapping(value = "/api/test1", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
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
	@RequestMapping(value = "/api/saveMe", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Bestellung saveBestellung(String bestellung, String name, String extras, String telefonnummer, String fleisch, String sauce, String email, String price) {
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
		b.setBezahlt(false);
		b.setPrice(price);
		System.out.println("Bestellung: " + b + " Name: " + name);
		return repositoy.save(b);

	}

	@RequestMapping(value = "/api/get")
	public Bestellung get() {
		Bestellung b = new Bestellung();
		b.setName("myName");
		b.setExtras("myExtra");
		b.setBestellung("MyDoener");
		b.setTelefonnummer("0531 84027");
		b.setFleisch("ohne");
		b.setSauce("ohne");
		return b;
	}
}