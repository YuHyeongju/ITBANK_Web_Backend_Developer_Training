package com.itbank.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Service;



@Service
public class Ex01Service {
	// 공공데이터 포털, 부산 축제 정보

	private final String serviceKey = "IR2BW6s721w4X5%2Faw2H9BbrtrUf4BoBG7Wvh7YN5J17Xyx3DymV6mk%2FI%2Fvpcj8ezYB7iYXafiG0KABUcoEjtjA%3D%3D";
	
	//요청주소 및 파라미터를 준비하는 단계
	public String getFestivalJson() throws MalformedURLException, IOException {
		String url = "https://apis.data.go.kr/6260000/FestivalService/getFestivalKr";
		HashMap<String, String> param = new HashMap<>();
		param.put("pageNo", "1");      // 가져올 페이지
		param.put("numOfRows", "10");  // 가져올 줄 수
		param.put("resultType", "json");
		param.put("serviceKey", serviceKey);
		url += "?";
		for(String key : param.keySet()) {
			url += key + "=" + param.get(key) + "&"; //마지막 &는 있어도 관계없음
		}
		
		// 요청을 전송하여 응답을 받아서 저장
		
		Scanner sc = null;
		String response = "";
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		
		if(conn.getResponseCode() == 200) { // 정상 응답시
			sc = new Scanner(conn.getInputStream());
			while(sc.hasNextLine()){
				response += sc.nextLine();
			}
			sc.close();
			conn.disconnect();
		}
		 
		return response;
	}
	
	
}
