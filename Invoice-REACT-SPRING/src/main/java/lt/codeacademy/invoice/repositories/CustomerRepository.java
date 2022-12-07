package lt.codeacademy.invoice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.invoice.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
