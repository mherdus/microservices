package com.mherdus.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	ExchangeValue findByFromAndTo(String from, String to);
}