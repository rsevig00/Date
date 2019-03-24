package es.unileon.prg.date;

public class MainDate {

	public static void main(String[] args) {

		Date today, nextDate;
			//int meses = (int) (Math.random()*12)+1;
			//System.out.println(meses);
		try {
			today = new Date(19, 2, 2017);
			System.out.println(today.toString());
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}

	}

}

