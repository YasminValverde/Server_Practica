package cat.institutmarianao.orders.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

// REVIEW - Add necessary annotations to declare a Controller with corresponding base path
@Controller
public class LoginController {

	// REVIEW - Add necessary annotation to handle corresponding GET request
	@GetMapping({"", "/"})
	public String check(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			// Redirect to admin orders page
			return "redirect:/admin/orders";
		}
		// Redirect to user orders page
		return "redirect:/users/orders";
	}

	// REVIEW - Add necessary annotation to handle corresponding GET request
	@GetMapping("/login")
	public String login() {
		// Show login page
		return "login";
	}

	// REVIEW - Add necessary annotation to handle corresponding GET request
	@GetMapping("/loginfailed")
	public String loginFailed(Model model) {
		model.addAttribute("error", "true");
		// Show login page with error message
		return "login";
	}
}
