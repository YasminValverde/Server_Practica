package cat.institutmarianao.orders.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum Status {
        PENDING, TRANSIT, DELIVERY, ABSENT, PENDING_COLLECTION, RETURNED
    }

    // Si la generates al guardar, evita @NotNull para no fallar en el POST
    @EqualsAndHashCode.Include
    private Long reference;

    // REVIEW - client: not null
    @NotNull
    private User client;

    // REVIEW - deliveryAddress validado en cascada
    @Valid
    @NotNull
    private PostalAddress deliveryAddress;

    private Date startDate;
    private Date deliveryDate;

    // REVIEW - items: not null nor empty
    @NotNull
    @NotEmpty
    private Map<Item, Integer> items;

    private Status status = Status.PENDING;

    public Map<Item, Integer> getItems() {
        if (items == null) items = new HashMap<>();
        return items;
    }

    public void setItems(Map<Item, Integer> items) {
        this.items = Objects.requireNonNullElse(items, new HashMap<>());
    }

    public Integer getTotalQuantity() {
        return getItems().values().stream().reduce(0, Integer::sum);
    }

  
    public Double getTotalAmount() {
        return getItems().entrySet().stream()
                .map(e -> e.getKey().getPrice() * e.getValue())
                .reduce(0d, Double::sum);
    }
}