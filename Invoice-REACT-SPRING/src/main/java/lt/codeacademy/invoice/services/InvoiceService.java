package lt.codeacademy.invoice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.invoice.entities.Customer;
import lt.codeacademy.invoice.entities.Invoice;
import lt.codeacademy.invoice.entities.Item;
import lt.codeacademy.invoice.repositories.CustomerRepository;
import lt.codeacademy.invoice.repositories.InvoiceRepository;
import lt.codeacademy.invoice.repositories.ItemRepository;



@Service
public class InvoiceService {
	@Autowired
	InvoiceRepository invoiceRepository;
	@Autowired
	CustomerRepository customerRepository;

	public List<Invoice> getInvoiceList() {
		var list = invoiceRepository.findAll();
		System.out.println(list);
		return list;
	}
	
	public Invoice addInvoice(Invoice invoice) {
		
		System.out.println(invoice + " servisas");
		
		try{
			
			Invoice inv = invoiceRepository.save(invoice );
			System.out.println(inv);
			return inv;
		}	catch(Exception e) {
			System.out.println(e.getMessage() + "Suluzo cia");
		}
		
		return null;
	}

	public Invoice getInvoiceById(Long id) {
		Optional<Invoice> invoice = invoiceRepository.findById( id );

		if (invoice.isEmpty()) {
			return null;
		}

		return invoice.get();
	}

	public Invoice updateInvoiceById(Long id, Invoice invoice) {



		return invoiceRepository.save( invoice );
	}

	public String deleteInvoiceById(Long id) {
		boolean exists = invoiceRepository.existsById( id );

		if (exists) {
			invoiceRepository.deleteById( id );
			return "Invoice was deleted with id: " + id;
		}
		return "Invoice does not exist";
	}
}

