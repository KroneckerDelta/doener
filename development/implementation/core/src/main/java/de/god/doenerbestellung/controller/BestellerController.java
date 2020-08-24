package de.god.doenerbestellung.controller;

import de.god.doenerbestellung.domain.Besteller;
import de.god.doenerbestellung.repository.BestellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController()
public class BestellerController {
    private BestellerRepository bestellerRepo;

    @Autowired
    public BestellerController(BestellerRepository bestellerRepo) {
        this.bestellerRepo = bestellerRepo;
    }

    @Transactional
    @RequestMapping(value = "/api/besteller", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Besteller saveAnrufer(@RequestBody Besteller besteller) {
        String bestelldatum = Heute.get();
        besteller.setBestelldatum(bestelldatum);
        System.out.println("Anrufer: " + besteller );
        return bestellerRepo.save(besteller) ;

    }

}
