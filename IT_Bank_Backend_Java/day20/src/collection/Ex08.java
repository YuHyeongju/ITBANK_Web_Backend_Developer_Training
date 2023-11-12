package collection;


import java.util.HashMap;

public class Ex08 {

	public static void main(String[] args) throws Exception {
		String url = "https://Search.naver.com/search.naver";
		url += "?";
		
		HashMap<String, String> param = new HashMap<>();
		param.put("query", "");
		param.put("where", "image"); // 비워두면 통합검색, news, image등 카테고리
		
		param.put("query", param.get("query").replace(" ", "%20")); // 공백문자: 32번 32 / 2 = 16 32의 16진수
		
		for(String key : param.keySet()) { // keySet(): 키만 모아서 Set에 담아서 반환
			String value = param.get(key);
			url += key + "=" + value + "&";
		}
		
		Runtime rt = Runtime.getRuntime();
		String chromePath = "C://Program Files\\Google\\chrome\\Application\\chrome.exe";
		rt.exec(chromePath + " " + url); 

	}

}
