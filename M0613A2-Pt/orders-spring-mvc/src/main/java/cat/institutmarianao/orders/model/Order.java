package cat.institutmarianao.orders.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.Valid;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum Status {
		PENDING, TRANSIT, DELIVERY, ABSENT, PENDING_COLLECTION, RETURNED
	}

	private Long reference;

	// TODO - Add validation annotations:
	// - client: not null
	private User client;

	// TODO - Add validation annotations:
	@Valid // Invoke validation on nested object
	private PostalAddress deliveryAddress;

	private Date startDate;

	private Date deliveryDate;

	// TODO - Add validation annotations:
	// - items: not null nor empty
	private Map<Item, Integer> items;

	private Status status = Status.PENDING;

	public Long getReference() {
		return reference;
	}

	public void setReference(Long reference) {
		this.reference = reference;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public PostalAddress getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(PostalAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Map<Item, Integer> getItems() {
		if (items == null) {
			items = new HashMap<>();
		}
		return items;
	}

	public void setItems(Map<Item, Integer> items) {
		this.items = Objects.requireNonNullElse(items, new HashMap<>());
	}

	public Integer getTotalQuantity() {
		return items.values().stream().reduce(0, Integer::sum);
	}

	public Double getTotalAmount() {
		return items.entrySet().stream().map(e -> e.getKey().getPrice() * e.getValue()).reduce(0d, Double::sum);
	}

	@Override
	public int hashCode() {
		return Objects.hash(reference);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object instanceof Order order) {
			return Objects.equals(reference, order.reference);
		}
		return false;
	}

}
