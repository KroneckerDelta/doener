package de.god.doenerbestellung.domain;

import javax.persistence.*;

@Entity
@Table(name = "Besteller")
public class Besteller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String bestelldatum;

    public String getBestelldatum() {
        return bestelldatum;
    }

    public void setBestelldatum(String bestelldatum) {
        this.bestelldatum = bestelldatum;
    }

    private String raum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaum() {
        return raum;
    }

    public void setRaum(String raum) {
        this.raum = raum;
    }
}
