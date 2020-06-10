package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.model.Incident;
import com.example.demo.repository.IncidentRepository;

@Service
public class IncidentService {
	
	@Autowired
	private IncidentRepository incidentRepository;
	
	//Schedule a job to add object in DB in every 15 sec
	@Scheduled(fixedRate = 15000)
	public void add2DBJob()
	{
		Incident incident=new Incident();
		incident.setName("INC100"+new Random().nextInt(374483));
		incidentRepository.save(incident);
		System.out.println("ADD SERVICE CALL IN " + new Date().toString());
	}
	
	//Schedule a job to fetch the record from DB in every 15 sec
	@Scheduled(cron = "0/30 * * * * *")
	public void fetchDBJob()
	{
		List<Incident> list=incidentRepository.findAll();
		System.out.println("FETCH SERVICE CALL IN" + new Date().toString());
		System.out.println("NO. OF RECORD FETCHED : " + list.size());
		System.out.println(list);
	}

}
