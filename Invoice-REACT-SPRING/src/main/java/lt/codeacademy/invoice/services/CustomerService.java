package lt.codeacademy.invoice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.invoice.entities.Customer;
import lt.codeacademy.invoice.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> getCustomerList() {
		return customerRepository.findAll();
	}

	public Customer addCustomer(Customer customer) {
		return customerRepository.save( customer );
	}

	public Customer getCustomerById(Long id) {
		Optional<Customer> customer = customerRepository.findById( id );

		if (customer.isEmpty()) {
			return null;
		}

		return customer.get();
	}

	public Customer updateCustomerById(Long id, Customer customer) {
//
//		Customer customerById = customerRepository.findById( id ).get();
//
//		customerById.setAdresas( customer.getAdresas() );
//		customerById.setEmail( customer.getEmail() );
//		customerById.setKlientoStatusas( customer.getKlientoStatusas() );
//		customerById.setPavarde( customer.getPavarde() );
//		customerById.setTelNumeris( customer.getTelNumeris() );
//		customerById.setTipas( customer.getTipas() );
//		customerById.setVardas( customer.getVardas() );

		return customerRepository.save( customer );
	}

	public String deleteCustomerById(Long id) {
		boolean exists = customerRepository.existsById( id );

		if (exists) {
			customerRepository.deleteById( id );
			return "Customer was deleted with id: " + id;
		}
		return "Customer does not exist";
	}
}
