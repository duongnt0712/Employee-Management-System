package fa.training.problem02.utils;

import java.sql.Date;

public class Validator {
	
	/**
	 * validate from date and to date
	 * @param fromDate
	 * @param toDate
	 * @return
	 * if fromDate is smaller than toDate
	 * 	return true
	 * else
	 * 	return false
	 */
	public static boolean validateFromDateToDate(Date fromDate, Date toDate){
		return fromDate.compareTo(toDate) == -1;
	}
}
