package cat.institutmarianao.orders.repository;

import cat.institutmarianao.orders.model.User;

public interface UserRepository {
	User get(String username);
}
