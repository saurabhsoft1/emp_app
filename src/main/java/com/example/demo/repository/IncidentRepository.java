package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Integer>{

}
