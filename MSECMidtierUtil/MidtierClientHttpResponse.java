package com.td.mbna.msec.midtier.util.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

public class MidtierClientHttpResponse implements ClientHttpResponse{

	private ClientHttpResponse clientHttpResponse;
	private byte[] body = null;
	
	public MidtierClientHttpResponse(ClientHttpResponse clientHttpResponse) {
		this.clientHttpResponse = clientHttpResponse;
	}
	
	@Override
	public InputStream getBody() throws IOException {
		if (body != null){
			return new ByteArrayInputStream(body);
		}
		body = StreamUtils.copyToByteArray(this.clientHttpResponse.getBody());
		return new ByteArrayInputStream(body);
	}

	@Override
	public HttpHeaders getHeaders() {
		return this.clientHttpResponse.getHeaders();
	}

	@Override
	public void close() {
		this.clientHttpResponse.close();
	}

	@Override
	public int getRawStatusCode() throws IOException {
		return this.clientHttpResponse.getRawStatusCode();
	}

	@Override
	public HttpStatus getStatusCode() throws IOException {
		return this.clientHttpResponse.getStatusCode();
	}

	@Override
	public String getStatusText() throws IOException {
		return this.clientHttpResponse.getStatusText();
	}

}
