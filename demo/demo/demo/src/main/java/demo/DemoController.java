package demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@Autowired
	private DemoService service;
     
	@GetMapping(value = "/getToken", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getToken() {
		
		String response = service.getData();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	//Ignore This Code
	@GetMapping(value="Hello")
	public String sayHello(@RequestParam(name = "name", required = false)String name) {
		if(null == name || "".equalsIgnoreCase(name.trim())){
			return "Hello World!";
		}else {
			return String.format("Hello,%s!", name);
		}
	}
}
