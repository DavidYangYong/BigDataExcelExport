package test.java;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author david
 * @create 2017-12-12 10:57
 **/
public class Test1 {

	public static void main(String[] args) {
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString="2014-04-24 08:11:59";
			Date date = sdf.parse(dateString);
			System.out.println(date.toString());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}


	}
}
