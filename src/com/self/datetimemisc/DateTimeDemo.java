package com.self.datetimemisc;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeDemo {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		Period period = Period.ofDays(30);
		Duration duration = Duration.ofHours(2);
		
		System.out.println("date: " + date);
		System.out.println("plusDays(10): " + date.plusDays(10));
		System.out.println("plus(Period): " + date.plus(period));
		System.out.println("plus(duration): " + date.plus(duration));
		System.out.println("date.minusDays(5): " + date.minusDays(5));
		System.out.println("date.getDayOfMonth(): " + date.getDayOfMonth() );
		System.out.println("date.getDayOfYear(): " + date.getDayOfYear());
		
		LocalTime time = LocalTime.now();
		
		System.out.println("time:  " + time);
		System.out.println("plus(duration): " + time.plus(duration));
		System.out.println("time.plusHours(4):  " + time.plusHours(4));
		System.out.println("time.minusHours(5): " + time.minusHours(5));
		System.out.println("time.getHour() : " + time.getHour() );
		System.out.println("time.getSecond(): " + time.getSecond());
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("dateTime: " + dateTime);
		System.out.println("plusDays(10): " + dateTime.plusDays(10));
		System.out.println("dateTime.minusDays(5): " + dateTime.minusDays(5));
		System.out.println("dateTime.getDayOfMonth(): " + dateTime.getDayOfMonth() );
		System.out.println("dateTime.getDayOfYear(): " + dateTime.getDayOfYear());
		System.out.println("dateTime.plusHours(4):  " + dateTime.plusHours(4));
		System.out.println("dateTime.minusHours(5): " + dateTime.minusHours(5));
		System.out.println("dateTime.getHour() : " + dateTime.getHour() );
		System.out.println("dateTime.getSecond(): " + dateTime.getSecond());
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println(zonedDateTime);
		

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = dateTime.format(formatter);
		System.out.println( "formattedDateTime" + formattedDateTime);
		
		String strDateTime = "2024-01-21 15:30:00";
		LocalDateTime parsedDateTime = LocalDateTime.parse(strDateTime, formatter);
		System.out.println( "parsedDateTime" + parsedDateTime);
		
		LocalDate startDate = LocalDate.of(2024, 1, 1);
		LocalDate endDate = LocalDate.of(2024, 7, 1);
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		
		System.out.println( "daysBetween " + startDate +  " and " + endDate + " :  " + daysBetween);
		



		

		

	}

}
