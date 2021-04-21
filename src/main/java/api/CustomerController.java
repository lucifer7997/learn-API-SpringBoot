package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Customer;

@Controller
@RequestMapping(value = "/api/customer")

public class CustomerController {
	@Autowired
	private CustomerRepository customerRes;
	
	@GetMapping(value = "/")
	@ResponseBody
	public List<Customer> getCustomer(){
		return customerRes.findAll();
	}
	
	@GetMapping(value = "/{idCustomer}")
	@ResponseBody
	public List<Customer> FindByIdCustomer(@PathVariable("idCustomer") String idCustomer){//@PathVariable này để xác thực khóa chính của entity muốn truy vấn. 
		return customerRes.findByidCustomer(idCustomer);
	}
	
	@PostMapping(value = "/")
	@ResponseBody
	public HttpStatus postCustomer(@RequestBody Customer customer) { //@RequestBody được dùng để ánh xạ HttpRequest body sang một domain object tự động.
		customerRes.save(customer);
		return HttpStatus.OK;
	}
	
	@PutMapping(value = "/{idCustomer}")
	@ResponseBody
	public HttpStatus putCustomer(@PathVariable String idCustomer, @RequestBody Customer customer) { //Các tham số được chú thích với @PathVariable mặc định phải khác NULL
		customer.setIdCustomer(idCustomer);
		customerRes.save(customer);
		return HttpStatus.OK;
	}
	
	@DeleteMapping(value = "/")
	@ResponseBody
	public HttpStatus delCustomer() {
		customerRes.deleteAll();
		return HttpStatus.OK;
	}
	
	@DeleteMapping(value = "/{idCustomer}")
	@ResponseBody
	public HttpStatus delCustomer(@PathVariable String idCustomer, @RequestBody Customer customer) {
		customerRes.deleteById(idCustomer);
		return HttpStatus.OK;
	}
	
	

}
