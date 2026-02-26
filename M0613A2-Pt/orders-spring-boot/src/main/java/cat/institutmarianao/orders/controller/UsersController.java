package cat.institutmarianao.orders.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import cat.institutmarianao.orders.model.Item;
import cat.institutmarianao.orders.model.Order;
import cat.institutmarianao.orders.model.User;
import cat.institutmarianao.orders.repository.ItemRepository;
import cat.institutmarianao.orders.repository.OrderRepository;
import jakarta.validation.Valid;

//REVIEW - Add necessary annotations to declare a Controller with corresponding base path
@Controller
//REVIEW - Add necessary annotation to manage "order" attribute in session
@RequestMapping("/users/orders")
@SessionAttributes("order")
public class UsersController {

	// REVIEW - Inject services
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ItemService ItemService;
	
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

	// REVIEW - Add necessary annotation to handle corresponding GET request
	@GetMapping()
	public ModelAndView orders(Authentication authentication) {
		// REVIEW - Get all the orders of the logged user from the service layer
		User loggedUser = (User) authentication.getPrincipal();
		
		// REVIEW - Create and return a ModelAndView object to send to the view named "orders" with the following parameter:
		// · "orders" with the list of all the orders of the logged user obtained from the service layer
		ModelAndView modelView = new ModelAndView("orders");
		
		modelView.addObject("orders", orderRepository.findByUser(loggedUser));

		// REVIEW - return the ModelAndView object
		return modelView;
	}

	// REVIEW - Add necessary annotation to handle corresponding GET request
	@GetMapping("/newOrder")
	public ModelAndView newOrder() {
		// REVIEW - Create and return a ModelAndView object to send to the view named "newOrder" with the following parameter:
		ModelAndView modelView = new ModelAndView("newOrder");
		// · "items" with the list of all the items obtained from the service layer
		modelView.addObject("items", itemRepository.getAll());
		
		// REVIEW - return the ModelAndView object
		return modelView;
	}

	// REVIEW - Add necessary annotation to handle corresponding GET request
	@GetMapping("/newOrder/clearItems")
	public String newOrderClearItems(@SessionAttribute("order") Order order) {

		// Clear order items
		order.getItems().clear();

		// REVIEW - Redirect to newOrder page
		return "redirect:/users/newOrder";
	}

	// REVIEW - Add necessary annotation to handle corresponding GET request
	@GetMapping("/newOrder/increaseItem")
	public String newOrderIncreaseItem(@SessionAttribute("order") Order order
	/* REVIEW - Get the "reference" parameter */,@RequestParam("reference") Long reference) {
		

		// TODO - Get the item related to the reference passed as parameter from the service layer
		  Item item = itemRepository.get(reference);
		// TODO - Increase item quantity
		  Integer quantity = order.getItems().get(item);
		  if (quantity != null) {
			    order.getItems().put(item, quantity + 1);
			} else {
			    order.getItems().put(item, 1);
			}
		// Convenience methods to update quantities from controller/service 
		// REVIEW - Redirect to newOrder page
		return "redirect:/users/newOrder";
	}

	// REVIEW - Add necessary annotation to handle corresponding GET request
	@GetMapping("/newOrder/decreaseItem")
	public String newOrderDecreaseItem(@SessionAttribute("order") Order order
	/* REVIEW - Get the "reference" parameter */,@RequestParam("reference") Long reference) {

		// REVIEW - Get the item related to the reference passed as parameter from the service layer
		Item item = itemRepository.get(reference);
		// TODO - Decrease item quantity
		  if (item != null) {
		        Integer quantity = order.getItems().get(item);
		        if (quantity != null) {
		            if (quantity > 1) {
		                order.getItems().put(item, quantity - 1);
		            } else {
		                order.getItems().remove(item);
		            }
		        }
		    }


		// REVIEW - Redirect to newOrder page
		return "redirect:/users/newOrder";
	}

	// REVIEW - Add necessary annotation to handle corresponding GET request
	@GetMapping("/finishOrder")
	public String finishOrder() {
		// Nothing to do here, just show the finishOrder view.
		// The order is yet ready in session, so the view can take it from the session and show it

		// TODO - Return the finishOrder view name
		return null;
	}

	// REVIEW - Add necessary annotation to handle corresponding POST request
	// @Valid annotation is used to validate the Order object and the binding result will hold validation results
	@PostMapping("/finishOrder")
	public String finishOrder(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult,
			SessionStatus sessionStatus) {

		// TODO - If there are validation errors, return to finishOrder view
		// TODO - Set the order start date to current date
		// TODO - Save the order using the service layer

		// Mark session complete to clear the order object from session
		sessionStatus.setComplete();

		// REVIEW - Redirect to user's orders page
		return "redirect:/users/orders";
	}
}




























/*
 * 
 * public void decreaseItem(Item item) { if (item == null) { return; } Integer
 * qty = getItems().get(item); if (qty == null) { return; } if (qty > 1) {
 * getItems().put(item, qty - 1); } else { getItems().remove(item); } }
 */