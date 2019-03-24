package es.unileon.prg.date;

/**
 *
 *Clase Date
 *
 *@version
 *@author prog1
 */


public class Date {

	private int day;
	private int month;
	private int year;
	private String salida;

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


	public Boolean isSameYear(int year){
		return this.year == year;
	}

	public Boolean isSameMonth(int month){
		return this.month == month;
	}
	
	public Boolean isSameDay(int day){
		return this.day == day;
	}

	public Boolean isSame(int day, int month, int year){
		return this.day == day && this.month == month && this.year == year;
	}
		
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
		
	public int monthsUntilEndYear(){
		int endMonth=0;
		do{
			month+=1;
			endMonth+=1;
		}
		while (month<12);
	return endMonth;
}
	
	public int daysUntilEndMonth(int month){
		int endDays=0;
			do{
				day+=1;
				endDays+=1;
			}
			while(day<getDaysOfMonth(month));
		return endDays;
	}

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

	public int daysSinceYearStart(){
		int dias=0, i=1, j=1;
			do{
				if(i==getDaysOfMonth(month)){
					i=0;
					j+=1;
				}
				i+=1;
				dias+=1;
			}
			while((j!=month) && (i!=day));
		return dias;
	}

	public int ramdomDate(int day, int month){
		int i=0, j=0, tries=0;
		while((i!=day) && (j!=month)){
			i = (int) (Math.random()*12)+1;
			j = (int) (Math.random()*31)+1;
			tries+=1;
		}
		return tries;
	}
	
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



	@Override
	public String toString() {
		StringBuffer salida = new StringBuffer();
		if(isSameDay(day)){
			salida.append("Es el mismo dia\n");
		}
		if(isSameMonth(month)){
			salida.append("Es el mismo mes\n");
		}
		if(isSameYear(year)){
			salida.append("Es el mismo año\n");
		}
		salida.append(this.day + "/" + this.month + "/" + this.year+".\n");
		salida.append("Quedan "+monthsUntilEndYear()+ " meses para que se acabe el anio.\n");
		salida.append("Quedan "+daysUntilEndMonth(month)+ " dias para que se acabe el mes.\n");
		salida.append("Los meses con el mismo numero de dias son: "+sameDaysMonths()+".\n");
		salida.append("Llevamos "+daysSinceYearStart()+ " dias desde que el año empezo\n");
		salida.append(getMonthSeason(month)+"\n");
		salida.append(printMonthName(month)+"\n");
		salida.append(getDaysOfMonth(month)+"\n");
		salida.append(ramdomDate(day,month)+"\n");
		salida.append(ramdomDateDo(day,month)+"\n");
		salida.append(dayOfWeek(day, month, year));
		return salida.toString();
		}
	
}
