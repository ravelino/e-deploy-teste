package br.com.ravelino.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryResponseWrapper {
	
	
	@JsonProperty("RestResponse")
	RestResponseWrapper restResponse;

	public RestResponseWrapper getRestResponse() {
		return restResponse;
	}

	public void setRestResponse(RestResponseWrapper restResponse) {
		this.restResponse = restResponse;
	}
}
