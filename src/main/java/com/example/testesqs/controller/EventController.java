package com.example.testesqs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testesqs.dto.RequestDTO;
import com.example.testesqs.response.ResponseDTO;
import com.example.testesqs.service.EventMessageSQSService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(path = "/teste/v1/register")
@RestController
public class EventController {
	
	private EventMessageSQSService eventMessageSQSService;
	
	public EventController(EventMessageSQSService eventMessageSQSService) {
		this.eventMessageSQSService = eventMessageSQSService;
	}

	@PostMapping
	public ResponseEntity<ResponseDTO> createMessage(@RequestBody RequestDTO dto){
		log.info("controller");
		ResponseDTO sendMessage = eventMessageSQSService.sendMessage(dto);
		return ResponseEntity.ok(sendMessage);
	}

}
