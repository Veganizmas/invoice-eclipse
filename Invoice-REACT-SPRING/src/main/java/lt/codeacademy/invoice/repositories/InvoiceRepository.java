package lt.codeacademy.invoice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.invoice.entities.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
