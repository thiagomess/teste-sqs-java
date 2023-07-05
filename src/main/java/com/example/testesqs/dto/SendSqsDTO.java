package com.example.testesqs.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.MDC;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendSqsDTO implements Serializable {

	private static final long serialVersionUID = -838667072848915050L;
	private Long id;
	private List<String> events;
	private HashMap<String, Object> data;

	private String traceId;

	private String notificationCreateDate;

	private String notificationCreateEpoch;
	
	


	public SendSqsDTO(RequestDTO requestDTO) {
		ZonedDateTime atZone = Instant.now().atZone(ZoneId.of("America/Sao_Paulo"));
		Instant instant = Instant.now().atZone(ZoneId.of("GMT")).toInstant();

		this.id = requestDTO.getId();
		this.events = requestDTO.getEvents();
		this.data = requestDTO.getData();
		this.traceId = MDC.get("X-B3-TRACE_ID");
		this.notificationCreateDate = atZone.format(DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss.SSS"));
		this.notificationCreateEpoch = String.format("%s.%.6s", instant.getEpochSecond(), instant.getNano()) ;
	}
//	

//	public static void main(String[] args) {
//
//		ZonedDateTime atZone = Instant.now().atZone(ZoneId.of("America/Sao_Paulo"));
//		System.out.println(atZone.format(DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss.SSS")));
//
//		ZonedDateTime instant = Instant.now().atZone(ZoneId.of("GMT"));
//
////	instant.
//		long timeStampMillis = instant.toEpochSecond();
//		System.err.println(timeStampMillis);
//
//		String dateTimeString = "2020-12-12T14:34:18.111Z";
//
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSzzz");
//
//		LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
//
//		Long dateTimeMillis = localDateTime.atZone(ZoneId.of("GMT")).toInstant().getEpochSecond();
//
//		System.err.println(dateTimeMillis);
//
//
//
//
////	long epoch = System.currentTimeMillis()/1000;
////	
////	System.out.println(epoch);
//
////    DateTimeFormatter sdr = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSzzz");
////    ZonedDateTime MydateTime = ZonedDateTime.parse(kafkaTime,sdr);
////    this.time = MydateTime.toInstant().toEpochMilli();
//
////	  OffsetDateTime currentTimeInUtc = OffsetDateTime.now(ZoneId.of("GMT"));
////	    System.out.println(currentTimeInUtc);
////	    long millisecondsSinceEpoch = currentTimeInUtc.toInstant().toe;
////	    System.out.println(millisecondsSinceEpoch);
//
////		//Format examples
////		LocalDate date = LocalDate.now();
////		//default format
////		System.out.println("Default format of LocalDate="+date);
////		//specific format
////		System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
////		System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));
////		
////		
////		ZonedDateTime dateTime = LocalDateTime.now().atZone(ZoneId.of("Europe/Paris"));
////		
////		ZonedDateTime lastUpdated = LocalDateTime.now().atZone(ZoneId.of("Europe/Paris"));
//////		ZonedDateTime time = lastUpdated;
////		System.out.println(lastUpdated);
//////		System.out.println(time.withZoneSameInstant());
////		System.out.println(lastUpdated.withZoneSameInstant(ZoneId.of("America/Los_Angeles")));
////		
////		//default format
////		System.out.println("Default format of LocalDateTime="+dateTime);
////		//specific format
////		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss.SSS")));
////		System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
////		
////		Instant timestamp = Instant.now();
////		//default format
////		System.out.println("Default format of Instant="+timestamp);
////		
////		//Parse examples
////		LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48",
////				DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
////		System.out.println("Default format after parsing = "+dt);
//	}

}
