package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter

public class Customer {
	@Id
	@Column(name = "Id_Customer")
	private String idCustomer;
	@Column(name = "Name_Customer")
	private String nameCustomer;
	@Column(name = "Phone_Customer")
	private String phoneCustomer;

}
