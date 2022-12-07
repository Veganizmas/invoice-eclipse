package lt.codeacademy.invoice.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.invoice.entities.Customer;
import lt.codeacademy.invoice.entities.Invoice;
import lt.codeacademy.invoice.entities.InvoiceItem;
import lt.codeacademy.invoice.entities.Item;
import lt.codeacademy.invoice.services.CustomerService;
import lt.codeacademy.invoice.services.InvoiceService;
import lt.codeacademy.invoice.services.ItemService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ApiController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private InvoiceService invoiceService;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getCustomerList();
	}

	@PostMapping("/customers")
	public Customer saveCustomerDetails(@RequestBody Customer customer) {
		System.out.println(customer);
		return customerService.addCustomer( customer );
	}

	@PostMapping("/customers/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
		return customerService.updateCustomerById( id, customer );
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById( id );
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id) {
		customerService.deleteCustomerById( id );
		return new ResponseEntity<>( HttpStatus.NO_CONTENT );
	}

	@GetMapping("/items")
	public List<Item> getAllItems() {
		return itemService.getItemList();
	}

	@PostMapping("/items")
	public Item saveItemDetails(@RequestBody Item item) {
		return itemService.addItem( item );
	}

	@PostMapping("/items/{id}")
	public Item updateItem(@RequestBody Item item, @PathVariable Long id) {
		return itemService.updateItemById( id, item );
	}

	@GetMapping("/items/{id}")
	public Item getItemById(@PathVariable Long id) {
		return itemService.getItemById( id );
	}

	@DeleteMapping("/items/{id}")
	public ResponseEntity<HttpStatus> deleteItemById(@PathVariable Long id) {
		itemService.deleteItemById( id );
		return new ResponseEntity<>( HttpStatus.NO_CONTENT );
	}
	
	@GetMapping("/invoices")
	public List<Invoice> getAllInvoices() {
		
		return invoiceService.getInvoiceList();
	}

	@PostMapping("/invoices")
	public Invoice saveInvoiceDetails(@RequestBody Invoice invoice) {
		return invoiceService.addInvoice( invoice );
		//Customer cust = new Customer( 1L, "as","as","as","as","as","as","as", null);
		
		//return new Invoice(1L, "123" , LocalDate.now(), cust, null );
	}

	@PostMapping("/invoices/{id}")
	public Invoice updateInvoice(@RequestBody Invoice invoice, @PathVariable Long id) {
		return invoiceService.updateInvoiceById( id, invoice );
	}

	@GetMapping("/invoices/{id}")
	public Invoice getInvoiceById(@PathVariable Long id) {
		return invoiceService.getInvoiceById( id );
	}

	@DeleteMapping("/invoices/{id}")
	public ResponseEntity<HttpStatus> deleteInvoiceById(@PathVariable Long id) {
		invoiceService.deleteInvoiceById( id );
		return new ResponseEntity<>( HttpStatus.NO_CONTENT );
	}

}
