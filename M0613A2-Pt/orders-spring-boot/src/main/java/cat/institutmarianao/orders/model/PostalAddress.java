package cat.institutmarianao.orders.model;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/* Lombok */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostalAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int MAX_ADDRESS = 150;
	private static final int MAX_ZIP_CODE = 20;
	private static final int MAX_CITY = 150;
	private static final int MAX_STATE = 150;
	private static final int MAX_COUNTRY = 150;

	private String recipientName;

	@NotBlank
	@Size(max = MAX_ADDRESS)
	// - address: not blank, max size MAX_ADDRESS
	/* Lombok */
	@NonNull
	@EqualsAndHashCode.Include
	private String address;

	@NotBlank
	@Size(max = MAX_ZIP_CODE)
	// - zipCode: not blank, max size MAX_ZIP_CODE
	/* Lombok */
	@NonNull
	@EqualsAndHashCode.Include
	private String zipCode;

	@NotBlank
	@Size(max = MAX_CITY)
	// - city: not blank, max size MAX_CITY
	/* Lombok */
	@NonNull
	@EqualsAndHashCode.Include
	private String city;

	@NotBlank
	@Size(max = MAX_STATE)
	// - state: not blank, max size MAX_STATE
	/* Lombok */
	@NonNull
	@EqualsAndHashCode.Include
	private String state;

	@NotBlank
	@Size(max = MAX_COUNTRY)
	// - country: not blank, max size MAX_COUNTRY
	/* Lombok */
	@NonNull
	@EqualsAndHashCode.Include
	private String country;
}
