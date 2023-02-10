package com.crud.task.DTO;



import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCrudDTO {

	
	//private int Id;
	
	@NotBlank(message="Name required")
	private String name;
	@NotBlank(message="Work field mandatory")
	private String work;
	@NotBlank(message="action can't be null")
	private String action;

	
	
}
