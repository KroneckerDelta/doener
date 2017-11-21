package de.god.doenerbestellung.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class HeuteTest {

	@Test
	public void shouldReturnTodayWithoutTimeWithLength8() throws Exception {
		String today = Heute.get();
		assertEquals(10, today.length());
	}

	@Test
	public void dateShouldStartWithDay() throws Exception {
		String today = Heute.get();
		GregorianCalendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		assertTrue(today.startsWith(String.valueOf(day)));
	}

	@Test
	public void dateShouldEndWithYear() throws Exception {
		String today = Heute.get();
		GregorianCalendar cal = new GregorianCalendar();
		int year = cal.get(Calendar.YEAR);
		assertTrue(today.endsWith(String.valueOf(year)));
	}
}
