package de.god.doenerbestellung.controller;

import java.util.Date;
import java.util.Locale;

import org.springframework.format.datetime.DateFormatter;

public class Heute {

	private static String convertToDateWithoutTime(Date date) {

		DateFormatter df = new DateFormatter();
		df.setPattern("dd.MM.yyyy");
		String print = df.print(date, Locale.GERMAN);
		return print;
	}

	/**
	 * Liefert das heutige Datum ohne Zeit als String
	 * 
	 * @return datum
	 */
	public static String get() {
		return convertToDateWithoutTime(new Date());
	}
}
