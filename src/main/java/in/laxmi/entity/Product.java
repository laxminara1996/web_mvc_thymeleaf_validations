package in.laxmi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue
	private Integer pid;
    @NotBlank(message="Name is Mandatory")
    @Size(min=3, max=15, message="Name should have only 3 to 15 characters")
	private String name;
    @NotNull(message="price is Mandatory")
    @Positive(message="price should be positive number")
	private Double price;
    @NotNull(message="Quatity is Mandatory")
	private Integer quantity;
}
