package cat.institutmarianao.orders.model;

import java.io.Serializable;
import java.util.Base64;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/* Lombok */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int MAX_NAME = 50;
	private static final int MAX_DESCRIPTION = 250;

	/* Lombok */
	@NotNull
	@EqualsAndHashCode.Include
	private Long reference;

	@NotBlank
	@Size(max = MAX_NAME)
	// - name: not blank, max size MAX_NAME
	private String name;

	@NotBlank
	@Size(max = MAX_DESCRIPTION)
	// - description: not blank, max size MAX_DESCRIPTION
	private String description;

	@NotNull
	@PositiveOrZero
	// - price: not null and positive or zero
	private Double price;

	@NotNull
	// - image: not null
	private byte[] image;

	public String getBase64Image() {
		return Base64.getEncoder().encodeToString(image);
	}

	public void setBase64Image(String b64Image) {
		image = Base64.getDecoder().decode(b64Image);
	}
}
