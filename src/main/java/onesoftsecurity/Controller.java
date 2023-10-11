package onesoftsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping(path="/student") 
	public String get() {
		return "This is a Student";
	}
	@GetMapping(path="/trainer")
	public String get1() {
		return "This is a Trainer";
		
	}
	@GetMapping(path="/manager")
	public String get2() {
		return "This is a manager";
		
	}

}
