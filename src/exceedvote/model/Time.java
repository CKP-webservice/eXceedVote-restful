
package exceedvote.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Time {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int min;
	private int sec;

	public Time() {

	}

	public Time(int year,int month,int day,int hour,int min,int sec) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}
	
	public boolean checkTimeout() {
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String monthf = "", dayf = "", hourf = "", minf = "", secf = "";
		if(this.month + 1 < 10) monthf = "0" + this.month;
		else monthf = this.month + "";
		if(this.day < 10) dayf = "0" + this.day;
		else dayf = this.day + "";
		if(this.hour < 10) hourf = "0" + this.hour;
		else hourf = this.hour + "";
		if(this.min < 10) minf = "0" + this.min;
		else minf = this.min + "";
		if(this.sec < 10) secf = "0" + this.sec;
		else secf = this.sec + "";
		String timeFormat = this.year + "/" + monthf + "/" + dayf + " " + hourf + ":" + minf + ":" + secf;
		try {
			Date countdown = dateFormat.parse(timeFormat);
			if(countdown.getTime() < now.getTime() || countdown.equals(now)) return true;
			else return false;
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}

	}
}