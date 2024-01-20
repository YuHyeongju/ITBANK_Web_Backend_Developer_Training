package com.itbank.servlet; // . : 하위폴더를 나타는 요소 

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.action.CommandAction;

public class DispatcherServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// forword에 사용할 prefix, suffix
	private final String prefix = "/WEB-INF/views/";
	private final String suffix = ".jsp";
	
	// 주소: 갹체 형태로 저장하는 map
	private Map<String, CommandAction> map= new HashMap<>(); 
	// 맴버 필드로 저장되어 다른 메서드에서 사용 가능
	
	// web.xml에 있는 param-value 를 불러옴 
	@Override // 서블릿 생성시 초기 작동 함수(서블릿 컨테니어가 없으면 init을 사용하여 객체를 생성)
	public void init() throws ServletException{
		// 서블릿 설정에 initParameter가 있으면 그 항목의 값을 문자열로 가져온다.
		String configFile = getInitParameter("configFile");
		System.out.println(configFile);// 확인
		
		// 1)요청 주소 : 클래스 이름(패키지 포함) 의 맵을 구성하여 pro에 저장한다.
		
		Properties pro  = new Properties();	// 비어있는 Properties(=map)을 생성
		FileInputStream fis = null;// 파일에서 데이터를 읽어오는 객체의 변수 
		
		
		try {
			String configFilePath = getServletContext().getRealPath(configFile);
			fis = new FileInputStream(configFilePath);
			pro.load(fis);			// 파일을 지정하면 내용을 properties에 불러온다.
		} catch (IOException e) {
			throw new ServletException(e);
		
		}finally {
			if(fis != null) try {
				fis.close();
			} catch (Exception e) {
			
			}
		}
		System.out.println(pro);
		
		//2) 클래스 이름을 이용하여 실제 객체를 생성하고, 요청 주소: 객체 형태의 map에 저장한다.
		for(Object key: pro.keySet()) {
			
			String command = (String) key;
			String handlerClassName = pro.getProperty(command);

			try {
				Class<?> handlerClass = Class.forName(handlerClassName); // <?>: 모든 타입을 받을 수 있음.
				// 기본 클래스를 호출
				Constructor<?> constructor = handlerClass.getConstructor(null);
				CommandAction handlerInstance = (CommandAction) constructor.newInstance(null);
				// 객체 생성
				
				
				map.put(command,  handlerInstance);// 요청주소 , 객체
				
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		
		for(String key : map.keySet()) {
			System.out.println(key);
		}
	}
	
	@Override // 요청이 들어왔을 때 처리하는 함수
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String command = req.getRequestURI(); 
		if(command.indexOf(req.getContextPath()) == 0){
			command = command.substring(req.getContextPath().length());
			
		}
		System.out.println("URI: " + req.getRequestURI());
		System.out.println("command: " +  command);
		
		String viewName = null;
		CommandAction action = map.get(command); // map에서 주소를 넣어서 action 호출
		
		if(action == null) {
			
			resp.sendError(404,"요청하신 페이지를 찾을 수 없습니다.(다시 시도해보세용)");
			return;
		}
		
		switch(req.getMethod()) {
		case "GET":
			viewName = action.doGet(req,resp);
			break;
		case "POST":
			viewName = action.doPost(req, resp);
			break;
		}
		if(viewName.startsWith("redirect:")) {
			String location = req.getContextPath() + viewName.split(":")[1];
			resp.sendRedirect(location);
		}else { // 싹 다 forward 처리
			viewName = prefix  + viewName + suffix;
			RequestDispatcher rd = req.getRequestDispatcher(viewName);
			rd.forward(req, resp);
			
		}
	} 
}
