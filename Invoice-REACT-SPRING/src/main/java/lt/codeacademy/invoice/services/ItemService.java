package lt.codeacademy.invoice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.invoice.entities.Item;
import lt.codeacademy.invoice.repositories.ItemRepository;

@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepository;

	public List<Item> getItemList() {
		return itemRepository.findAll();
	}

	public Item addItem(Item item) {
		return itemRepository.save( item );
	}

	public Item getItemById(Long id) {
		Optional<Item> item = itemRepository.findById( id );

		if (item.isEmpty()) {
			return null;
		}

		return item.get();
	}

	public Item updateItemById(Long id, Item item) {

//		Item itemById = itemRepository.findById( id ).get();
//
//		itemById.setPavadinimas( item.getPavadinimas() );
//		itemById.setKodas( item.getKodas() );
//		itemById.setAprasymas( item.getAprasymas() );
//		itemById.setGrupe( item.getGrupe() );
//		itemById.setStatusas( item.getStatusas() );

		return itemRepository.save( item );
	}

	public String deleteItemById(Long id) {
		boolean exists = itemRepository.existsById( id );

		if (exists) {
			itemRepository.deleteById( id );
			return "Item was deleted with id: " + id;
		}
		return "Item does not exist";
	}
}