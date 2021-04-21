package api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

	List<Customer> findByidCustomer(String idCustomer);

}
