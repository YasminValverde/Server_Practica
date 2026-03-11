package cat.institutmarianao.orders.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/* Lombok */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum Status {
		PENDING, TRANSIT, DELIVERY, ABSENT, PENDING_COLLECTION, RETURNED
	}

	/* Lombok */
	@NotNull
	@EqualsAndHashCode.Include
	private Long reference;
	
	// REVIEW - Add validation annotations:
	@NotNull
	// - client: not null
	private User client;

	// REVIEW - Add validation annotations:
	@Valid // Invoke validation on nested object
	@NonNull
	private PostalAddress deliveryAddress;

	private Date startDate;

	private Date deliveryDate;
	// REVIEW - Add validation annotations:
	@NotNull
	@NotEmpty
	// - items: not null nor empty
	private Map<Item, Integer> items;
	private Status status = Status.PENDING;

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

	
}