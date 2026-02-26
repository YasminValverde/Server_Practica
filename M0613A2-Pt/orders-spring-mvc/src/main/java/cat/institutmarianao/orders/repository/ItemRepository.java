package cat.institutmarianao.orders.repository;

import java.util.List;

import cat.institutmarianao.orders.model.Item;

public interface ItemRepository {
	Item get(Long reference);

	List<Item> getAll();
}
