package es.unileon.prg.date;

/**
 *
 *Class date
 *
 *@version initial
 *@author Raul Sevillano
 *
 */

public class Date {

	private int day;
	private int month;
	private int year;
	
	/**
	 *Constructor of class date
	 */

	public Date(int day, int month, int year) throws DateException{
		this.year = year;
		if ((month) < 1 || (month > 12)) {
			throw new DateException("Mes " + month + " no valido" +
					" Valores posibles entre 1 y 12.");
		} else {
			this.month = month;
		}
		//TODO falta comprobar el dia
		if ((day) < 1 || (day > getDaysOfMonth(month))) {
			throw new DateException("Dia " + day + " no valido" +
					" Valores posibles entre 1 y "+getDaysOfMonth(month));
		} else {
			this.day = day;
		}
		this.day = day;
	}

	/**
	 *@return the day
	 */

	public int getDay() {
		return day;
	}

	/**
	 * @return the month
	 */

	public int getMonth() {
		return month;
	}

	/**
	 * @return the year
	 */

	public int getYear() {
		return year;
	}
	
	/**
	 *@return Check if the year of two dates is the same
	 */
	
	public Boolean isSameYear(Date other) {
		return getYear() == other.getYear();
	}
	
	/**
	 *@return Check if the month of two dates is the same
	 */

	public Boolean isSameMonth(Date other) {
		return getMonth() == other.getMonth();

	}
	
	/**
	 *@return Check if the day of two dates is the same
	 */

	public Boolean isSameDay(Date other) {
		return getDay() == other.getDay();

	}
	
	/**
	 *Method that combines the previous three in one
	 */

	public void isSame(Date other) {
		StringBuffer salida = new StringBuffer();
			if (isSameDay(other)){
				salida.append("Es el mismo Dia\n");
			}
			if (isSameMonth(other)){
				salida.append("Es el mismo Mes\n");
			}
			if(isSameYear(other)){
				salida.append("Es el mismo Año\n");
			}
		System.out.println(salida.toString());
	}
	
	/**
	 *@return Number of days of the current month
	 *We dont consider leap years
	 */

	public int getDaysOfMonth(int month){
		int number=0;
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
				break;
		}
		return number;
	}
	
	/**
	 *@return The name of the current month
	 */

	private String printMonthName(int month){
		String nombreMes="";
		switch(month){
				case 1: 
			nombreMes="Enero";
				break;
				case 2:
			nombreMes="Febrero";
				break;
				case 3:
			nombreMes="Marzo";
				break;
				case 4:
			nombreMes="Abril";
				break;
				case 5:
			nombreMes="Mayo";
				break;
				case 6:
			nombreMes="Junio";
				break;
				case 7: 
			nombreMes="Julio";
				break;
				case 8:
			nombreMes="Agosto";
				break;
				case 9:
			nombreMes="Septiembre";
				break;
				case 10:
			nombreMes="Octubre";
				break;
				case 11:
			nombreMes="Noviembre";
				break;
				case 12:
			nombreMes="Diciembre";
				break;
				default: 
			nombreMes="Mes no valido";
		}
		return nombreMes;
	}
	
	/**
	 *@return If the date of the month is correct
	 *We dont consider leap years
	 */

	public Boolean isDayRight(int day, int month){
		boolean rigth=true;
			switch(month){
				case 1: //next
				case 3: //next
				case 5: //next
				case 7: //next
				case 8: //next 
				case 10: //next
				case 12: if((day<1) || (day>31)){
					rigth=false;
				}
				break;
				case 2: if((day<1) || (day>28)){
					rigth=false;
				}
				break;
				case 4: //next
				case 6: //next
				case 9: //next
				case 11: if((day<1) || (day>30)){
					rigth=false;
				}
				break;
			}
			return rigth;
		}

	/**
	 *@return The name of the current month
	 */
		
	public String getMonthSeason(int month){
			String nombreEstacion="";
		switch(month){
			case 1:
			case 2:
			case 3: nombreEstacion="Invierno";
			break;
			case 4:
			case 5:
			case 6: nombreEstacion="Primavera";
			break;
			case 7:
			case 8:
			case 9: nombreEstacion="Verano";
		 	break;
			case 10:
			case 11:
			case 12: nombreEstacion="Otoño";
			break;
			default: nombreEstacion="Mes no valido";
		}
		return nombreEstacion;
	}
	
	/**
	 *@return The name of the months with the same number of days of the current month
	 */

	public String sameDaysMonths(){
		String mes="";
		if(month==2){
			mes="0";
		}else{
		if((month==1) || (month==3) || (month==5) || (month==7) || (month==8) || (month==10) || (month==12)){
			mes="Enero Marzo Mayo Julio Agosto Octubre Diciembre";
		}else{
		if((month==4) || (month==6) || (month==9) || (month==11)){
			mes="Abril Junio Septiembre Octubre";
		}
		}
		}
	return mes;
}

	/**
	 *@return The number of months until year finish
	 */

	public int monthsUntilEndYear(){
		int endMonth=0;
		do{
			month+=1;
			endMonth+=1;
		}
		while (month<12);
	return endMonth;
	}
	
	/**
	 *Method that print the dates until the month finish
	 */
	
	public void datesUntilEndMonth(){
		int i;
		String dateLeft="";
			for(i=day;i<getDaysOfMonth(month);i++){
				dateLeft=i+"/"+month+"/"+year;
				System.out.println(dateLeft+"\n");
		}
	} 
	
	/**
	 *Method that generates a ramdom date
	 *@return The number of tries needed to get the same date of the given date.
	 */

	public int ramdomDate(int day, int month){
		int i=0, j=0, tries=0;
		while((i!=day) && (j!=month)){
			i = (int) (Math.random()*12)+1;
			j = (int) (Math.random()*31)+1;
			tries+=1;
		}
		return tries;
	}
	
	/**
	 *Same method as previous with another type of loop
	 *@return The number of tries needed to get the same date of the given date.
	 */

	public int ramdomDateDo(int day, int month){
		int i=0, j=0, tries=0;
		do{
			i = (int) (Math.random()*12)+1;
			j = (int) (Math.random()*31)+1;
			tries+=1;
		}
		while((i!=day) && (j!=month));
	return tries;
}
	
	/**
	 *
	 *@return The number of days since year start
	 */
	
	public int daysSinceYearStart(){
		int dias = 0;
			if(month==1){
				dias=day;
			}
			if(month==2){
				dias=day+31;
			}
			if(month==3){
				dias=day+31+28;
			}
			if(month==4){
				dias=day+(31*2)+28;
			}
			if(month==5){
				dias=day+(31*2)+28+30;
			}
			if(month==6){
				dias=day+(31*3)+28+30;
			}
			if(month==7){
				dias=day+(31*3)+28+(30*2);
			}
			if(month==8){
				dias=day+(31*4)+28+(30*2);
			}
			if(month==9){
				dias=day+(31*5)+28+(30*2);
			}
			if(month==10){
				dias=day+(31*5)+28+(30*3);
			}
			if(month==11){
				dias=day+(31*6)+28+(30*3);
			}
			if(month==12){
				dias=day+(31*6)+28+(30*4);
			}
		return dias;
	}
	
	/**
	 *
	 *@return The name of day of the week of the current date.
	 *We dont consider leap years
	 *We consider that 1/1 is monday
	 */

	public String dayOfWeek(){
		int diaSemana=daysSinceYearStart()%7;
			if(diaSemana==0){
				return "Lunes";
			}
			if(diaSemana==1){
				return "Martes";
			}
			if(diaSemana==2){
				return "Miercoles";
			}
			if(diaSemana==3){
				return "Jueves";
			}
			if(diaSemana==4){
				return "Viernes";
			}
			if(diaSemana==5){
				return "Sabado";
			}else{
				return "Domingo";
			}
		}
	
	/**
	 *
	 *@return the current date
	 */

	@Override
	public String toString(){
		StringBuffer salida = new StringBuffer();
		salida.append(this.day + "/" + this.month + "/" + this.year+".\n");
		return salida.toString();
		}
}

