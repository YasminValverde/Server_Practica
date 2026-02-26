package cat.institutmarianao.orders.controller;

import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import cat.institutmarianao.orders.model.Order;
import cat.institutmarianao.orders.model.User;
import jakarta.validation.Valid;

//TODO - Add necessary annotations to declare a Controller with corresponding base path
//TODO - Add necessary annotation to manage "order" attribute in session
public class UsersController {

	// TODO - Inject services

	/*
	 * This annotated method will be called by Spring MVC to prepare the Order
	 * object required by the session, if not already present. The Order object will
	 * be associated with "order" name in session.
	 */
	@ModelAttribute("order")
	public Order setupOrder(Authentication authentication) {
		// The authentication principal is the logged in user
		User loggedUser = (User) authentication.getPrincipal();

		// Create a new order for the logged user
		Order order = new Order();
		order.setClient(loggedUser);
		return order;
	}

	// TODO - Add necessary annotation to handle corresponding GET request
	public ModelAndView orders(Authentication authentication) {
		// TODO - Get all the orders of the logged user from the service layer
		// TODO - Create and return a ModelAndView object to send to the view named
		// "orders"
		// with the following parameter:
		// · "orders" with the list of all the orders of the logged user obtained from
		// the
		// service layer

		// TODO - return the ModelAndView object
		return null;
	}

	// TODO - Add necessary annotation to handle corresponding GET request
	public ModelAndView newOrder() {
		// TODO - Create and return a ModelAndView object to send to the view named
		// "newOrder"
		// with the following parameter:
		// · "items" with the list of all the items obtained from the service layer
		// ·
		// TODO - return the ModelAndView object
		return null;
	}

	// TODO - Add necessary annotation to handle corresponding GET request
	public String newOrderClearItems(@SessionAttribute("order") Order order) {

		// Clear order items
		order.getItems().clear();

		// TODO - Redirect to newOrder page
		return null;
	}

	// TODO - Add necessary annotation to handle corresponding GET request
	public String newOrderIncreaseItem(@SessionAttribute("order") Order order
	/* TODO - Get the "reference" parameter */) {

		// TODO - Get the item related to the reference passed as parameter from the
		// service layer
		// TODO - Increase item quantity

		// TODO - Redirect to newOrder page
		return null;
	}

	// TODO - Add necessary annotation to handle corresponding GET request
	public String newOrderDecreaseItem(@SessionAttribute("order") Order order
	/* TODO - Get the "reference" parameter */) {

		// TODO - Get the item related to the reference passed as parameter from the
		// service layer
		// TODO - Decrease item quantity

		// TODO - Redirect to newOrder page
		return null;
	}

	// TODO - Add necessary annotation to handle corresponding GET request
	public String finishOrder() {
		// Nothing to do here, just show the finishOrder view.
		// The order is yet ready in session, so the view can take it from the session
		// and show it

		// TODO - Return the finishOrder view name
		return null;
	}

	// TODO - Add necessary annotation to handle corresponding POST request
	// @Valid annotation is used to validate the Order object and the binding result
	// will hold validation results
	public String finishOrder(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult,
			SessionStatus sessionStatus) {

		// TODO - If there are validation errors, return to finishOrder view
		// TODO - Set the order start date to current date
		// TODO - Save the order using the service layer

		// Mark session complete to clear the order object from session
		sessionStatus.setComplete();

		// TODO - Redirect to user's orders page
		return null;
	}
}
