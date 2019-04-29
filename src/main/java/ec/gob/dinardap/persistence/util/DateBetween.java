package ec.gob.dinardap.persistence.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 
 * 
 */
public class DateBetween implements Serializable {

	private static final long serialVersionUID = -190959176899888616L;

	private Date from;

	private Date to;

	/**
	 * @param from
	 * @param to
	 */
	public DateBetween(Date from, Date to) {
		super();
		if (from != null) {
			this.from = from;
		} else { // desde el 2000
			Calendar fromDefault = Calendar.getInstance();
			fromDefault.set(Calendar.YEAR, 2000);
			this.from = fromDefault.getTime();
		}

		if (to != null) {
			this.to = to;
		} else {
			// hasta un anio del actual
			Calendar toDefault = Calendar.getInstance();
			toDefault.set(Calendar.YEAR, toDefault.get(Calendar.YEAR) + 1);
			this.to = toDefault.getTime();
		}

		// se pone a fecha from: 0:0:0 0.000
		Calendar f = Calendar.getInstance();
		f.setTime(this.from);
		f.set(Calendar.HOUR_OF_DAY, 0);
		f.set(Calendar.MINUTE, 0);
		f.set(Calendar.SECOND, 0);
		f.set(Calendar.MILLISECOND, 0);
		this.from = f.getTime();

		// se pone a fecha to: 59:59:59 0.999
		Calendar t = Calendar.getInstance();
		t.setTime(this.to);
		t.set(Calendar.HOUR_OF_DAY, 23);
		t.set(Calendar.MINUTE, 59);
		t.set(Calendar.SECOND, 59);
		t.set(Calendar.MILLISECOND, 999);
		this.to = t.getTime();
	}
	
	public DateBetween(Date fromWithHour, Date toWithHour, boolean withHour) {
		
		if(!withHour){
			new DateBetween(fromWithHour, toWithHour);
			return;
		}
		
		if (fromWithHour != null) {
			this.from = fromWithHour;
		} else { // desde el 2000
			Calendar fromDefault = Calendar.getInstance();
			fromDefault.set(Calendar.YEAR, 2000);
			fromDefault.set(Calendar.HOUR_OF_DAY, 0);
			fromDefault.set(Calendar.MINUTE, 0);
			this.from = fromDefault.getTime();
		}

		if (toWithHour != null) {
			this.to = toWithHour;
		} else {
			// hasta un anio del actual
			Calendar toDefault = Calendar.getInstance();
			toDefault.set(Calendar.YEAR, toDefault.get(Calendar.YEAR) + 1);
			toDefault.set(Calendar.HOUR_OF_DAY, 23);
			toDefault.set(Calendar.MILLISECOND, 999);
			this.to = toDefault.getTime();
		}

		// se pone a fecha from: 0:0:0 0.000
		Calendar f = Calendar.getInstance();
		f.setTime(this.from);
		//f.set(Calendar.HOUR_OF_DAY, 0);
		//f.set(Calendar.MINUTE, 0);
		f.set(Calendar.SECOND, 0);
		f.set(Calendar.MILLISECOND, 0);
		this.from = f.getTime();

		// se pone a fecha to: 59:59:59 0.999
		Calendar t = Calendar.getInstance();
		t.setTime(this.to);
		//t.set(Calendar.HOUR_OF_DAY, 23);
		//t.set(Calendar.MINUTE, 59);
		t.set(Calendar.SECOND, 59);
		t.set(Calendar.MILLISECOND, 999);
		this.to = t.getTime();
	}

	/**
	 * @return the from
	 */
	public Date getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(Date from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public Date getTo() {
		return to;
	}

	/**
	 * @param to
	 *            the to to set
	 */
	public void setTo(Date to) {
		this.to = to;
	}
}