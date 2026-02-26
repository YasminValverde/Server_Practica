package cat.institutmarianao.orders.security.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cat.institutmarianao.orders.model.User;
import cat.institutmarianao.orders.repository.UserRepository;
import cat.institutmarianao.orders.security.model.UserPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.get(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found" + username);
		}
		return new UserPrincipal(user);
	}

}
