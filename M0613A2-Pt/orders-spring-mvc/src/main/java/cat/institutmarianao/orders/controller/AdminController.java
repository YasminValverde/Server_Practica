package cat.institutmarianao.orders.controller;

import org.springframework.web.servlet.ModelAndView;

// TODO - Add necessary annotations to declare a Controller with corresponding base path
public class AdminController {

	// TODO - Inject the OrderService

	// TODO - Add necessary annotation to handle corresponding GET request
	public ModelAndView orders() {
		// TODO - Get all orders from the service layer
		// TODO - Create and return a ModelAndView object to send to the view named
		// "orders" with the following parameters:
		// · "orders" with the list of all the orders of all users obtained from the
		// service layer
		// · "orderStatus" with the Order.Status values

		// TODO - return the ModelAndView object
		return null;
	}

	// TODO - Add necessary annotation to handle corresponding POST request
	// TODO - Add necessary annotation to validate "reference" and "deliveryDate"
	// request parameters
	public String setDeliveryDate(/* TODO - Get "reference" and "deliveryDate" request parameters */) {
		// TODO - Get the order related to the reference passed as parameter from the
		// service layer
		// TODO - Set the order delivery date with the deliveryDate value
		// TODO - Update the order

		// TODO - Redirect to admin's orders page
		return null;
	}

	// TODO - Add necessary annotation to handle corresponding POST request
	// TODO - Add necessary annotation to validate "reference" and "status" request
	// parameters
	public String setStatus(/* TODO - Get "reference" and "status" request parameters */) {
		// TODO - Get the order related to the reference passed as parameter from the
		// service layer
		// TODO - Set the order state with the status value
		// TODO - Update the order

		// TODO - Redirect to admin's orders page
		return null;
	}
}
