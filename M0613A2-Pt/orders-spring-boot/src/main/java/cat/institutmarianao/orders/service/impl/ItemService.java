package cat.institutmarianao.orders.service.impl;

import java.util.List;

import cat.institutmarianao.orders.model.Item;

public interface ItemService {
	Item get(Long reference);

	List<Item> getAll();
}
