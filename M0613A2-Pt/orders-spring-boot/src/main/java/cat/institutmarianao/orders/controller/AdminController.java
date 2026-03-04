package cat.institutmarianao.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import cat.institutmarianao.orders.model.Order;
import cat.institutmarianao.orders.model.User;
import cat.institutmarianao.orders.repository.OrderRepository;
import cat.institutmarianao.orders.service.impl.OrderService;

// REVIEW - Add necessary annotations to declare a Controller with corresponding base path
@Controller
@RequestMapping("/admin/orders")
public class AdminController {

	// REVIEW - Inject the OrderService
	@Autowired
	private OrderService orderService;

	// REVIEW - Add necessary annotation to handle corresponding GET request
	@GetMapping()
	public ModelAndView orders(Authentication authentication) {
		// REVIEW - Get all orders from the service layer
		User loggedUser = (User) authentication.getPrincipal();

		// REVIEW - Create and return a ModelAndView object to send to the view named "orders" with the following parameters:
		ModelAndView modelView = new ModelAndView("orders");
		// · "orders" with the list of all the orders of all users obtained from the service layer
		modelView.addObject("orders", orderService.findByUser(loggedUser));
		// · "orderStatus" with the Order.Status values
		modelView.addObject("orderStatus", Order.Status.values());
		
		// REVIEW - return the ModelAndView object
		return modelView;
	}

	// REVIEW - Add necessary annotation to handle corresponding POST request
	@PostMapping("/setDelivery")
	// TODO - Add necessary annotation to validate "reference" and "deliveryDate" request parameters
	public String setDeliveryDate(@SessionAttribute("order") Order order,@RequestParam("reference") Long reference)/* TODO - Get "reference" and "deliveryDate" request parameters */ {
		// TODO - Get the order related to the reference passed as parameter from the service layer
		
		 order = orderService.get(reference);
		// REVIEW - Set the order delivery date with the deliveryDate value
		 order.setDeliveryDate(order.getDeliveryDate());
		// REVIEW - Update the order
		orderService.update(order) ;

		// REVIEW - Redirect to admin's orders page
		return "redirect:/admin/orders";
	}

	// REVIEW - Add necessary annotation to handle corresponding POST request
	@PostMapping("/setStatus")
	// TODO - Add necessary annotation to validate "reference" and "status" request parameters
	public String setStatus(/* TODO - Get "reference" and "status" request parameters */) {
		// TODO - Get the order related to the reference passed as parameter from the service layer
		// TODO - Set the order state with the status value
		// TODO - Update the order
		

		// REVIEW - Redirect to admin's orders page
		return "redirect:/admin/orders";
	}
}
