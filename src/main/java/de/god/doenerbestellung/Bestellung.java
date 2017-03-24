package de.god.doenerbestellung;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bestellung")
public class Bestellung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String bestellnummer;
	private String fleischart;
	private String extras;
	private Date bestelldatum;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBestellnummer() {
		return bestellnummer;
	}

	public String getFleischart() {
		return fleischart;
	}

	public String getExtras() {
		return extras;
	}

	public Date getBestelldatum() {
		return bestelldatum;
	}

	public void setBestelldatum(Date bestelldatum) {
		this.bestelldatum = bestelldatum;
	}

}
