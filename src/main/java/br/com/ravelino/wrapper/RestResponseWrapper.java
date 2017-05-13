package br.com.ravelino.wrapper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestResponseWrapper {
	
	@JsonProperty("result")
	List<ResultWrapper> result;

	public List<ResultWrapper> getResult() {
		return result;
	}

	public void setResult(List<ResultWrapper> result) {
		this.result = result;
	}
}
