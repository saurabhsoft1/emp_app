package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProductServiceException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public double getPrice(String name) throws ProductServiceException
	{
		Product product = null;
		double amount = 0;
		try
		{
			product = productRepository.findByName(name);
			amount = product.getAmount();
		}
		catch(Exception e)
		{
			throw new ProductServiceException("Amount not found for Product :" + name);
		}
		return amount;
	}

}
