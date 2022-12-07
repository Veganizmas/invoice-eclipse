//package lt.codeacademy.invoice;
//
//import java.awt.print.Book;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//import lt.codeacademy.invoice.entities.Item;
//import lt.codeacademy.invoice.repositories.CustomerRepository;
//import lt.codeacademy.invoice.repositories.ItemRepository;
//
//@Slf4j
//@Component
//public class DatabaseLoader implements CommandLineRunner {
//	@Autowired
//	private final ItemRepository itemRepository;
//	@Autowired
//	private final CustomerRepository customerRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		Item item = this.itemRepository.save( new Item( "autorius", "pavadinimas", "metai", "IMG URL" ) );
//		log.info( "Initial data saved" + empl );
//	}
//
//}
