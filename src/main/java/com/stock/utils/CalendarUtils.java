package com.stock.utils;

import java.util.Calendar;

import org.apache.commons.lang3.time.DateUtils;

public class CalendarUtils {
	
	public static Calendar addDays(Calendar date, int days) {
		if (date == null)
			date = Calendar.getInstance();
		
		date.add(Calendar.DAY_OF_MONTH, days);
		
		return date;
	}
	
	public static Calendar addMonths(Calendar date, int months) {
		if (date == null)
			date = Calendar.getInstance();
		
		date.add(Calendar.MONTH, months);
		
		return date;
	}
	
	public static Calendar addYears(Calendar date, int years) {
		if (date == null)
			date = Calendar.getInstance();
		
		date.add(Calendar.YEAR, years);
		
		return date;
	}
	
	/**
	 * Verifica se o dia é o mesmo entre os Calendar, desconsiderando as horas, minutos, segundos...
	 * @param a
	 * @param b
	 * @return true se as datas representarem o mesmo dia do mesmo ano, na mesma Era.
	 */
	public static boolean isSameDay(Calendar a, Calendar b) {
		return (a != null && b != null) ? DateUtils.isSameDay(a, b) : false;
	}
	
	/**
	 * Verifica se o primeiro calendar vem após o segundo, considerando até os milisegundos.
	 * @param a
	 * @param b
	 * @return true se a primeira data vier depois da segunda
	 */
	public static boolean isAfter(Calendar a, Calendar b) {
		return (a != null && b != null) ? a.after(b) : false;
	}
	
	/**
	 * Verifica se o primeiro calendar vem antes o segundo, considerando até os milisegundos.
	 * @param a
	 * @param b
	 * @return true se a primeira data vier antes da segunda
	 */
	public static boolean isBefore(Calendar a, Calendar b) {
		return (a != null && b != null) ? a.before(b) : false;
	}
	
	/**
	 * Verifica se a primeira data vem antes da segunda, desconsiderando horas, minutos, segundos...
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isDayBefore(Calendar a, Calendar b) {
		if (a == null || b == null)
			return false;
		
		return	
		(a.get(Calendar.ERA) < b.get(Calendar.ERA)) ||
                (a.get(Calendar.YEAR) < b.get(Calendar.YEAR)) ||
                (a.get(Calendar.DAY_OF_YEAR) < b.get(Calendar.DAY_OF_YEAR));
	}
	
	/**
	 * Verifica se a primeira data vem após a segunda, desconsiderando horas, minutos, segundos...
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isDayAfter(Calendar a, Calendar b) {
		if (a == null || b == null)
			return false;
		
		return	
		(a.get(Calendar.ERA) > b.get(Calendar.ERA)) ||
                (a.get(Calendar.YEAR) > b.get(Calendar.YEAR)) ||
                (a.get(Calendar.DAY_OF_YEAR) > b.get(Calendar.DAY_OF_YEAR));
	}

}
