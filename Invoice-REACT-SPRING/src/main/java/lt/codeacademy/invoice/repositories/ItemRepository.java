package lt.codeacademy.invoice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.invoice.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
