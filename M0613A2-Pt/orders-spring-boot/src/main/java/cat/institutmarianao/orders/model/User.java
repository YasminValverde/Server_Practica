package cat.institutmarianao.orders.model;

import java.io.Serializable;
import java.util.List;

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
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final int MAX_USERNAME = 50;
	private static final int MIN_PASSWORD = 4;
	private static final int MAX_PASSWORD = 50;

	@NotBlank
	@Size(max = MAX_USERNAME)
	// - username: not blank, max size MAX_USERNAME
	/* Lombok */
	@NonNull
	@EqualsAndHashCode.Include
	private String username;

	@NotBlank
	@Size(min = MIN_PASSWORD, max = MAX_PASSWORD)
	// - password: not blank, min size MIN_PASSWORD, max size MAX_PASSWORD
	private String password;

	@NotBlank
	// - role: not blank
	private String role;

	@NotBlank
	// - firstName: not blank
	private String firstName;

	private String lastName;

	private List<Order> orders;
}
