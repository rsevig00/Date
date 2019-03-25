package es.unileon.prg.date;

public class MainDate {

	public static void main(String[] args) {

		Date today, otherDate;

		try {
			today = new Date(5, 1, 2019);
			otherDate = new Date(7, 4, 2017);
			System.out.println(today.toString());			
			System.out.println(otherDate.toString());
			today.isSame(otherDate);
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}

	}
}
