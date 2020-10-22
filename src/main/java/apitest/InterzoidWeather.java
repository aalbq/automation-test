package apitest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class InterzoidWeather extends InterzoidApi {
	
	private String method;
	
	public InterzoidWeather() {
		this.method = "getweather";
	}
	
	public int getWeather(String city, String state) {
		String queryParams;
		
		try {
			queryParams = "&city=" + URLEncoder.encode(city, "utf-8") + "&state=" + URLEncoder.encode(state, "utf-8");
			getApi(method, queryParams);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statusCode;
	}

}
