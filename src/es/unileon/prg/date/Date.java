package es.unileon.prg.date;

/**
 *
 *Clase Date
 *
 *@version
 *@author prog1
 */


public class Date {

	private int _day;
	private int _month;
	private int _year;
	

	public Date(int day, int month, int year) throws DateException{
		this._year = year;
		if ((month) < 1 || (month > 12)) {
			throw new DateException("Mes " + month + " no valido" +
					" Valores posibles entre 1 y 12.");
		} else {
			this._month = month;
		}
		//TODO falta comprobar el dia
		if ((day) < 1 || (day > getDaysOfMonth(month))) throws DateException{
			throw new DateException("Dia " + day + " no valido" +
					" Valores posibles entre 1 y 12.");
		} else {
			this._day = day;
		}
		this._day = day;
	}

	public void setDay(int day)throws DateException{
		if ((day) < 1 || (day > getDaysOfMonth(day))) {
			throw new DateException("Dia " + day + " no valido" +
					" Valores posibles entre 1 y 12.");
		} else {
			this._day = day;
		}
	}

	public Boolean isSameYear(int year){
		Boolean esElMismoDia = false;
			if (this._year == year){
				esElMismoDia = true;
			}
		return esElMismoDia;
	}

	public Boolean isSameMonth{ 

	/**
	 * Clase setMonth, setea el atributo 
	 *
	 *
	 *
         */


	public void setMonth(int month) throws DateException{
		if (month < 1 || month > 12) {
			throw new DateException("Mes " + month + " no valido" +
					" Valores posibles entre 1 y 12.");
		} else {
			this._month = month;
		}
	}

	public int getDaysOfMonth(int month) throws DateException{
		int number =0;
			switch(month){
				case 1: 
				case 3:
				case 5:
				case 7: 
				case 8:
				case 10:
				case 12:
			number=31;
				break;
				case 4:
				case 6:
				case 9:
				case 11:
			number=30;
				break;
				case 2:
			number=28;
				break;
				default: 
			number=-1;
		}
		return number;
	}
	private String printMonthName(int month){
		String nombreMes="";
		switch(month){
				case 1: 
			nombreMes="Enero";
				break;
				case 3:
				case 5:
				case 7: 
				case 8:
				case 10:
				case 12:
			number=31;
				break;
				case 4:
				case 6:
				case 9:
				case 11:
			number=30;
				break;
				case 2:
			number=28;
			nombreMes="Febrero";
				break;
				default: 
			number=-1;
		}
	}
	
	@Override
	public String toString() {
		return this._day + "/" + this._month + "/" + this._year;
	}

}
