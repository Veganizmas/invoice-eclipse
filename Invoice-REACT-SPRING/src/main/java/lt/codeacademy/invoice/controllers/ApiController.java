package lt.codeacademy.invoice.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

import lt.codeacademy.invoice.entities.Customer;
import lt.codeacademy.invoice.entities.Invoice;
import lt.codeacademy.invoice.entities.InvoiceItem;
import lt.codeacademy.invoice.entities.Item;
import lt.codeacademy.invoice.entities.User;
import lt.codeacademy.invoice.services.CustomerService;
import lt.codeacademy.invoice.services.InvoiceService;
import lt.codeacademy.invoice.services.ItemService;
import lt.codeacademy.invoice.services.UserService;

/**
 * Komentaras virš klasės JavaDoc. ApiController komentaras Šita klasė pažymėta
 * kaip RestController, turi endpointus ir dirba su JSON tipo failais
 *
 */
@ApiOperation(value ="Invoice API", notes = "")
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
	
	@Autowired
	private UserService userService;

	@ApiOperation(value = "Get all Customers list")
	@GetMapping("/customers")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<Customer> getAllCustomers() {
		return customerService.getCustomerList();
	}

	@PostMapping("/customers")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Customer saveCustomerDetails(@RequestBody Customer customer) {
		System.out.println( customer );
		return customerService.addCustomer( customer );
	}

	@PostMapping("/customers/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
		return customerService.updateCustomerById( id, customer );
	}

	@GetMapping("/customers/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById( id );
	}

	@DeleteMapping("/customers/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id) {
		customerService.deleteCustomerById( id );
		return new ResponseEntity<>( HttpStatus.NO_CONTENT );
	}

	@GetMapping("/items")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<Item> getAllItems() {
		return itemService.getItemList();
	}

	@PostMapping("/items")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Item saveItemDetails(@RequestBody Item item) {
		return itemService.addItem( item );
	}

	@PostMapping("/items/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Item updateItem(@RequestBody Item item, @PathVariable Long id) {
		return itemService.updateItemById( id, item );
	}

	@GetMapping("/items/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Item getItemById(@PathVariable Long id) {
		return itemService.getItemById( id );
	}

	@DeleteMapping("/items/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteItemById(@PathVariable Long id) {
		itemService.deleteItemById( id );
		return new ResponseEntity<>( HttpStatus.NO_CONTENT );
	}
	
	//users endpoints
	
	@GetMapping("/users")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAllUsers() {
		return userService.getUserList();
	}

	@PostMapping("/users")
	@PreAuthorize("hasRole('ADMIN')")
	public User saveUserDetails(@RequestBody User user) {
		return userService.addUser( user );
	}

	@PostMapping("/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public User updateUser(@RequestBody User user, @PathVariable Long id) {
		return userService.updateUserById( id, user );
	}

	@GetMapping("/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById( id );
	}

	@DeleteMapping("/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id) {
		userService.deleteUserById( id );
		return new ResponseEntity<>( HttpStatus.NO_CONTENT );
	}
	
	//*****************

	@GetMapping("/invoices")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<Invoice> getAllInvoices() {

		return invoiceService.getInvoiceList();
	}

	@PostMapping("/invoices")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Invoice saveInvoiceDetails(@RequestBody Invoice invoice) {
		return invoiceService.addInvoice( invoice );
		// return invoice;

		// a
		// Customer cust = new Customer( 1L, "as","as","as","as","as","as","as", null);

		// return new Invoice(1L, "123" , LocalDate.now(), cust, null );
	}

	@PostMapping("/invoices/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Invoice updateInvoice(@RequestBody Invoice invoice, @PathVariable Long id) {
		return invoiceService.updateInvoiceById( id, invoice );
	}

	@GetMapping("/invoices/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Invoice getInvoiceById(@PathVariable Long id) {
		return invoiceService.getInvoiceById( id );
	}

	@DeleteMapping("/invoices/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteInvoiceById(@PathVariable Long id) {
		invoiceService.deleteInvoiceById( id );
		return new ResponseEntity<>( HttpStatus.NO_CONTENT );
	}

	// +++++++++++++++++++++++++++++++++++++

	@GetMapping("/invoices/dummy")
	public Invoice getTestInvoice() {
		return getDummyInvoice();
	}

	public Invoice getDummyInvoice() {
		Invoice inv2 = new Invoice();
		Item itemas1 = new Item();

		itemas1.setAprasymas( "metalinis kastuvelis" );
		itemas1.setBazineKaina( 0 );
		itemas1.setGrupe( "sodo prekės" );
		itemas1.setId( 1L );
		itemas1.setKodas( "8214" );
		itemas1.setPavadinimas( "Kastuvas" );
		itemas1.setStatusas( "aktyvus" );

		Customer cust2 = new Customer();
		cust2.setAdresas( "miesto g. 95" );
		cust2.setEmail( "bananas25@gmail.com" );
		cust2.setId( 1L );
		cust2.setKlientoStatusas( "aktyvus" );
		cust2.setPavarde( "Mackevicius" );
		cust2.setTelNumeris( "865228287" );
		cust2.setTipas( "juridinis" );
		cust2.setVardas( "Linas" );

		ArrayList<InvoiceItem> items = new ArrayList<InvoiceItem>();
		items.add( new InvoiceItem( null, itemas1, 10 ) );

		inv2.setCustomerId( cust2 );
		inv2.setInvoiceItems( items );
		inv2.setId( 1L );
		inv2.setMyDate( LocalDate.now() );
		inv2.setInvoiceNumber( "552285" );

		return inv2;

	}

}
