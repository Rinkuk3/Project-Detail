package com.td.mbna.msec.midtier.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Mid-Tier
 * 
 *
 */
public class DateUtil {

	public final static boolean beforeNow(String odsStartTimestamp, String format) throws Exception {
		SimpleDateFormat odsDateFormatter = new SimpleDateFormat(format);
		synchronized (odsDateFormatter){
			Date odsTimestamp = odsDateFormatter.parse(odsStartTimestamp);
			Date now = Calendar.getInstance().getTime();
			return odsTimestamp.compareTo(now) <= 0;
		}
	}

	/**
	 * Returns if a given date is within a number of days prior from today.
	 * @param date - The date to check
	 * @param daysAgo - the number of days ago to check against
	 * @param defaultResponse - the default response to return if the input date is null.
	 * @return <default> if date == null, true if date is within days prior to today, false otherwise.
	 */
	public static boolean isDateWithinDays(XMLGregorianCalendar date, int daysAgo, boolean defaultResponse){
		if (date == null) {
			return defaultResponse;
		}
		return isDateWithinDays(date.toGregorianCalendar(), daysAgo, defaultResponse);
	}
	
	/**
	 * Returns if a given date is within a number of days prior from today.
	 * @param date - The date to check
	 * @param numDays - the number of days ago to check against
	 * @param defaultResponse - the default response to return if the input date is null.
	 * @return <default> if date == null, true if date is within days prior to today, false otherwise.
	 */
	public static boolean isDateWithinDays(GregorianCalendar date, int numDays, boolean defaultResponse){
		if (date == null) {
			return defaultResponse;				
		}
		GregorianCalendar daysFromNow = new GregorianCalendar();
		daysFromNow.add(GregorianCalendar.DATE, -(numDays));
		// set time to beginning of boundary start day
		daysFromNow.set(Calendar.HOUR_OF_DAY, 0);
		daysFromNow.set(Calendar.MINUTE, 0);
		daysFromNow.set(Calendar.SECOND, 0);
		daysFromNow.set(Calendar.MILLISECOND, 0);
		boolean withinDays = date.compareTo(daysFromNow) >= 0;
		return withinDays;
	}

	public static boolean isDateWithinHours(Long date, int hoursAgo, boolean defaultResponse){
		if(date == null){
			return false;
		}
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeInMillis(date);
		return isDateWithinHours(cal, hoursAgo, defaultResponse);

	}

	public static boolean isDateWithinHours(GregorianCalendar date, int hoursAgo, boolean defaultResponse){
		if (date == null) {
			return defaultResponse;
		}
		GregorianCalendar hoursFromNow = new GregorianCalendar();
		hoursFromNow.add(GregorianCalendar.HOUR, -(hoursAgo));

		boolean withinHoursAgo = date.compareTo(hoursFromNow) >= 0;
		return withinHoursAgo;
	}
	

		/**
		 * Utilities for conversion between the old and new JDK date types 
		 * (between {@code java.util.Date} and {@code java.time.*}).
		 * 
		 * <p>
		 * All methods are null-safe.
		 */
	 /**
     * Calls {@link #asLocalDate(Date, ZoneId)} with the system default time zone.
     */
    public static LocalDate asLocalDate(java.util.Date date) {
        return asLocalDate(date, ZoneId.systemDefault());
    }

    /**
     * 
     * @param java.util.Date date
     * @return LocalDate
     */
    public static LocalDate convertToLocalDate(java.util.Date date){
    	if (date == null){
    		return null;
    	}
    	return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();    	
    }
    
    /**
     * Creates {@link LocalDate} from {@code java.util.Date} or it's subclasses. Null-safe.
     */
    public static LocalDate asLocalDate(java.util.Date date, ZoneId zone) {
        if (date == null){
        	return null;
        }

        if (date instanceof java.sql.Date){
        	return ((java.sql.Date) date).toLocalDate();
        }
        if(zone == null){
        	zone = ZoneId.systemDefault();
        }
        return Instant.ofEpochMilli(date.getTime()).atZone(zone).toLocalDate();
    }

    /**
     * Calls {@link #asLocalDateTime(Date, ZoneId)} with the system default time zone.
     */
    public static LocalDateTime asLocalDateTime(java.util.Date date) {
        return asLocalDateTime(date, ZoneId.systemDefault());
    }

    /**
     * Creates {@link LocalDateTime} from {@code java.util.Date} or it's subclasses. Null-safe.
     */
    public static LocalDateTime asLocalDateTime(java.util.Date date, ZoneId zone) {
        if (date == null){
        	return null;
        }

        if (date instanceof java.sql.Timestamp){
        	return ((java.sql.Timestamp) date).toLocalDateTime();
        }
        return Instant.ofEpochMilli(date.getTime()).atZone(zone).toLocalDateTime();
    }

    /**
     * Calls {@link #asUtilDate(Object, ZoneId)} with the system default time zone.
     */
    public static java.util.Date asUtilDate(Object date) {
        return asUtilDate(date, ZoneId.systemDefault());
    }

    /**
     * Creates a {@link java.util.Date} from various date objects. Is null-safe. Currently supports:<ul>
     * <li>{@link java.util.Date}
     * <li>{@link java.sql.Date}
     * <li>{@link java.sql.Timestamp}
     * <li>{@link java.time.LocalDate}
     * <li>{@link java.time.LocalDateTime}
     * <li>{@link java.time.ZonedDateTime}
     * <li>{@link java.time.Instant}
     * </ul>
     * 
     * @param zone Time zone, used only if the input object is LocalDate or LocalDateTime.
     * 
     * @return {@link java.util.Date} (exactly this class, not a subclass, such as java.sql.Date)
     */
    public static java.util.Date asUtilDate(Object date, ZoneId zone) {
        if (date == null){
        	return null;
        }

        if (date instanceof java.sql.Date || date instanceof java.sql.Timestamp){
        	return new java.util.Date(((java.util.Date) date).getTime());
        }
        if (date instanceof java.util.Date){
        	return (java.util.Date) date;
        }
        if (date instanceof LocalDate){
        	return java.util.Date.from(((LocalDate) date).atStartOfDay(zone).toInstant());
        }
        if (date instanceof LocalDateTime){
        	return java.util.Date.from(((LocalDateTime) date).atZone(zone).toInstant());
        }
        if (date instanceof ZonedDateTime){
        	return java.util.Date.from(((ZonedDateTime) date).toInstant());
        }
        if (date instanceof Instant){
        	return java.util.Date.from((Instant) date);
        }

        throw new UnsupportedOperationException("Don't know hot to convert " + date.getClass().getName() + " to java.util.Date");
    }

    /**
     * Creates an {@link Instant} from {@code java.util.Date} or it's subclasses. Null-safe.
     */
    public static Instant asInstant(Date date) {
        if (date == null){
        	return null;
        	
        }
        return Instant.ofEpochMilli(date.getTime());
    }

    /**
     * Calls {@link #asZonedDateTime(Date, ZoneId)} with the system default time zone.
     */
    public static ZonedDateTime asZonedDateTime(Date date) {
        return asZonedDateTime(date, ZoneId.systemDefault());
    }

    /**
     * Creates {@link ZonedDateTime} from {@code java.util.Date} or it's subclasses. Null-safe.
     */
    public static ZonedDateTime asZonedDateTime(Date date, ZoneId zone) {
        if (date == null){
        	return null;
        }
        return asInstant(date).atZone(zone);
    }
	

}
