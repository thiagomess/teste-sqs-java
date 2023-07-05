package com.example.testesqs.service;

import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.example.testesqs.dto.RequestDTO;
import com.example.testesqs.dto.SendSqsDTO;
import com.example.testesqs.response.ResponseDTO;
import com.example.testesqs.util.JsonToString;

@Service
public class EventMessageSQSService {

	private AmazonSQS sqs;

	public EventMessageSQSService(AmazonSQS amazonSqs) {
		this.sqs = amazonSqs;
	}

	public ResponseDTO sendMessage(RequestDTO dto) {

		SendSqsDTO sendSqsDTO = new SendSqsDTO(dto);
		
//	    String queueUrl = sqs.getQueueUrl("sqsHelloWorld").getQueueUrl();

		String json = JsonToString.convert(sendSqsDTO);
		String messageId = sqs.sendMessage("http://localhost:4566/000000000000/sqsHelloWorld", json).getMessageId();

		return new ResponseDTO(messageId);

	}

}
