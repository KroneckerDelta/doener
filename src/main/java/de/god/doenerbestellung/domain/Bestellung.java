package de.god.doenerbestellung.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Bestellung")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bestellung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String bestellung;
	@Column(nullable = true)
	private String telefonnummer;
	@Column(nullable = true)
	private String extras;
	private Date bestelldatum;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBestellung() {
		return bestellung;
	}

	public Date getBestelldatum() {
		return bestelldatum;
	}

	public void setBestelldatum(Date bestelldatum) {
		this.bestelldatum = bestelldatum;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBestellung(String bestellung) {
		this.bestellung = bestellung;
	}

	@Override
	public String toString() {
		return bestelldatum + " " + bestellung + " mit " + extras + " von " + name + " Tel: " + telefonnummer;
	}
}