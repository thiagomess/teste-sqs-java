package com.example.testesqs.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

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
		Instant now = Instant.now();
		ZonedDateTime atZone = now.atZone(ZoneId.of("America/Sao_Paulo"));
		Instant instant = now.atZone(ZoneId.of("GMT")).toInstant();

		this.id = requestDTO.getId();
		this.events = requestDTO.getEvents();
		this.data = requestDTO.getData();
		this.traceId = MDC.get("X-B3-TraceId");
		this.notificationCreateDate = atZone.format(DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss.SSS"));
		this.notificationCreateEpoch = String.format("%s.%.6s", instant.getEpochSecond(), instant.getNano()) ;
	}
}
