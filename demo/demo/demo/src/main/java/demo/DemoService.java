package demo;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoService {
	
	@PostConstruct
	private void initialize() {
		this.restTemplate = new RestTemplate();
	}
	
	private RestTemplate restTemplate;
	private String url = "https://coreuat-zwqcqy3qmq-el.a.run.app/getlogintoken";
	
	public String getData(){
		
		User user = new User(username: "iptl", password: "iptl4692");
		HttpEntity<User> request = new HttpEntity<User>(user);
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST,request,String.class);
		return response.getBody();
	}

}
