package de.god.doenerbestellung.controller;

import de.god.doenerbestellung.domain.Bestellung;
import de.god.doenerbestellung.repository.BestellerRepository;
import de.god.doenerbestellung.repository.BestellungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Controller for Bestellungen
 *
 * @author tmichael
 */
@RestController()
public class BestellungController {

    private BestellungRepository repositoy;


    @Autowired
    public BestellungController(BestellungRepository repositoy, BestellerRepository bestellerRepo) {
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

    @RequestMapping(value = "/api/findHeute/{typ}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
    public List<Bestellung> heutigeBestellungen(@PathVariable("typ") String typ, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");

        String dateAsString = Heute.get();

        List<Bestellung> byBestelldatumAndTypOrderByBestellung = repositoy.findByBestelldatumAndTypOrderByBestellung(dateAsString, typ);
        return byBestelldatumAndTypOrderByBestellung;

    }

    @Transactional
    @CrossOrigin(origins = {"http://localhost:3000", "http://10.0.10.2:3000"}, allowCredentials = "true", allowedHeaders = "*")
    @RequestMapping(value = "/api/bestellung/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        System.out.println("Lösche Bestellung: " + id);
        repositoy.deleteById(id);
    }

    @Transactional
    @CrossOrigin(origins = {"http://localhost:3000", "http://10.0.10.2:3000"}, allowCredentials = "true", allowedHeaders = "*")
    @RequestMapping(value = "/api/bestellung", method = RequestMethod.PUT, consumes = MediaType.ALL_VALUE)
    public void update(@RequestBody Bestellung bestellung) {
        System.out.println("Speichere Bestellung: " + bestellung);

        repositoy.save(bestellung);
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
    public Bestellung saveBestellung(String typ, String bestellung, String name, String extras, String telefonnummer, String fleisch, String sauce, String email, String price) {
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
        b.setTyp(typ);
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