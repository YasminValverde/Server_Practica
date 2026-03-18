package cat.institutmarianao.orders.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.institutmarianao.orders.model.Order;
import cat.institutmarianao.orders.model.User;
import cat.institutmarianao.orders.repository.ItemRepository;
import cat.institutmarianao.orders.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

	@Override
	public Order get(Long reference) {

		return orderRepository.get(reference);
	}

	@Override
	public List<Order> getAll() {

		return orderRepository.getAll();
	}

	@Override
	public List<Order> findByUser(User client) {

		return orderRepository.findByUser(client);
	}

	@Override
	public void save(Order order) {		
		orderRepository.save(order);
	}

	@Override
	public Order update(Order order) {		
		return orderRepository.update(order);
	}
	

}