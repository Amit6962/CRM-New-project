package com.model.amit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.amit.entity.Customer;
import com.model.amit.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject customer service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		// get the customer from dao
		List<Customer> theCustomer = customerService.getCustomers();

		// and add the customer to model

		theModel.addAttribute("customers", theCustomer);

		return "list-customer";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create customer object
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("custmer") Customer theCustomer) {

		// save the Customer Usig our service
		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// get the customer from db
		Customer theCustomer = customerService.getCustomer(theId);

		// set customer as model to pre-populate

		theModel.addAttribute("customer", theCustomer);

		// send over to form

		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)
	{
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}

}
