package apitest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class InterzoidApi {

	private String baseUrl;
	private String licenseKey;
	protected String statusDescription;
	protected int statusCode;

	protected InterzoidApi() {
		this.baseUrl = "https://api.interzoid.com";
		this.licenseKey = "0f3d3a0a95b4e2555d4788c3e98f87ea";
		this.statusDescription = null;
		this.statusCode = 0;
	}

	public String getStatusDescription() {
		return this.statusDescription;
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	protected void getApi(String method, String queryParams) {

		String url = baseUrl + "/" + method + "?license=" + licenseKey + queryParams;

		HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			statusCode = conn.getResponseCode();
			statusDescription = conn.getResponseMessage();

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
