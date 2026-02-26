package cat.institutmarianao.orders.controller;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;

// TODO - Add necessary annotations to declare a Controller with corresponding base path
public class LoginController {

	// TODO - Add necessary annotation to handle corresponding GET request
	public String check(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			// Redirect to admin orders page
			return "redirect:/admin/orders";
		}
		// Redirect to user orders page
		return "redirect:/users/orders";
	}

	// TODO - Add necessary annotation to handle corresponding GET request
	public String login() {
		// Show login page
		return "login";
	}

	// TODO - Add necessary annotation to handle corresponding GET request
	public String loginFailed(Model model) {
		model.addAttribute("error", "true");
		// Show login page with error message
		return "login";
	}
}
