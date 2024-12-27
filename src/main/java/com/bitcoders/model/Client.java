package com.bitcoders.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	
	@NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	public String name;
	
	@NotNull(message = "Email cannot be null")
	@Email(message = "Invalid email address")
	public String email;
	
	@NotNull(message = "Phone Number cannot be null")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be digits only")
	public String phone;
	
	@NotNull(message = "Company Name cannot be null")
	@Size(min = 2, max = 60, message = "Company name must be between 2 and 60 characters")
	public String companyName;
	
	@NotNull(message = "Query cannot be null")
	@Size(min = 10, max = 60, message = "Query must be between 10 and 60 characters")
	public String query;
    
	@Override
	public String toString() {
		
		return "Client [name=" + name + ", email=" + email + ", phone=" + phone + ", companyName=" + companyName
				+ ", query=" + query + "]";
	}
}
