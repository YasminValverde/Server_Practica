package cat.institutmarianao.orders.model;

import java.io.Serializable;
import java.util.Base64;
import java.util.Objects;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int MAX_NAME = 50;
	private static final int MAX_DESCRIPTION = 250;

	private Long reference;

	// TODO - Add validation annotations:
	// - name: not blank, max size MAX_NAME
	private String name;

	// TODO - Add validation annotations:
	// - description: not blank, max size MAX_DESCRIPTION
	private String description;

	// TODO - Add validation annotations:
	// - price: not null and positive or zero
	private Double price;

	// TODO - Add validation annotations:
	// - image: not null
	private byte[] image;

	public Long getReference() {
		return reference;
	}

	public void setReference(Long reference) {
		this.reference = reference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getBase64Image() {
		return Base64.getEncoder().encodeToString(image);
	}

	public void setBase64Image(String b64Image) {
		image = Base64.getDecoder().decode(b64Image);
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
		if (object instanceof Item item) {
			return Objects.equals(reference, item.reference);
		}
		return false;
	}

}
