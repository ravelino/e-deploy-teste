/**
 * 
 */
package br.com.ravelino.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.ravelino.wrapper.CountryResponseWrapper;
import br.com.ravelino.wrapper.ResultWrapper;
import br.com.ravelino.wrapper.UserWrapper;

/**
 * @author ravelino
 *
 */

@Controller
public class AppController {
	
	private static final String URL_CONTRY = "http://services.groupkt.com/country/get/all";
	
	private static final String URL_POST = "http://jsonplaceholder.typicode.com/posts";
	
	private static final RestTemplate REST_TEMPLATE = new RestTemplate();
	
	@RequestMapping("/index")
    public String index() {
        return "index";
    }
	
	
	@RequestMapping(
			value = "/findUser",
			method = RequestMethod.POST,
			produces = "application/json"
		)
	@ResponseBody
	public String findUser(@ModelAttribute UserWrapper userWrapper) {
		
		ResponseEntity<UserWrapper> user = 
				REST_TEMPLATE.postForEntity(URL_POST, userWrapper, UserWrapper.class);
		
		return new Gson().toJson(user.getBody());
	}
	
	@RequestMapping(
		value = "/getCountries",
		method = RequestMethod.GET,
		produces = "application/json"
	)
	@ResponseBody
	public String getCountries(@RequestParam("country") String country) {
		final ResponseEntity<CountryResponseWrapper> response = 
	    		REST_TEMPLATE.getForEntity(URL_CONTRY, CountryResponseWrapper.class);

	    final List<ResultWrapper> countries = response.getBody().getRestResponse().getResult();
	    
	    final List<ResultWrapper> filteredCountries =
	    		countries
	    			.stream()
	    			.filter(item -> item.getName().equals("Brazil"))
	    			.collect(Collectors.toList());
	    
	    return new Gson().toJson(filteredCountries);
	}
}
