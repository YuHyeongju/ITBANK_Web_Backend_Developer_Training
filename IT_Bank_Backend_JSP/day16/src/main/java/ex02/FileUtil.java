package ex02;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileUtil {
	// 싱글톤: 어떠한 경우에도 객체는 하나만 존재 , 객체를 한번만 만들어놓고 계속 사용
	private static FileUtil instance = new FileUtil();	 // new FileUtil(); 로 미리 객체 생성
	
	public static FileUtil getInstance() {
		return instance;
	}
	
	
	public FileUtil() {
		
	}
	
	
	// 파일 처리에 관련된 필드
	private String saveDirectory = null;		//jsp실행될때 값이 채워짐
	private int maxPostSize = 1024 * 1024 * 20;
	private String encoding = "UTF-8"; 
	private FileRenamePolicy policy = new DefaultFileRenamePolicy();
	
	//request를 전달받아서, 파일 및 다른 데이터를 DTO에 담아서 반환하는 함수
	public Ex02DTO getDTO(HttpServletRequest request) throws IOException, ParseException {

		
		Ex02DTO dto = null;
		
		// 1).저장할 디렉토리가 없으면 새로 생성해야한다.
		if(saveDirectory == null) {
			ServletContext application = request.getServletContext();
			saveDirectory = application.getRealPath("/upload"); 
			File dir = new File(saveDirectory);
			dir.mkdirs();
			
			System.out.println(saveDirectory); // 절대경로로 출력해준다.(톰캣 안에 upload폴더가 생긴다.)
		}
		
		// 2). request를 이용하여 MultipartRequest 객체를 생성한다.
		// 이때, 첨부파일은 saveDirectory 위치에 자동으로 생성된다.(업로드된다.)
		MultipartRequest mpRequest = new MultipartRequest(request, saveDirectory,maxPostSize, encoding, policy);
		//request: 요청이 들어올때 마다 변경->필드에 있지 않음 ,saveDirectory: 반 고정값,maxPostSize:고정값, encoding:고정값,
		//policy:고정값
		
		
		// 3).일반 문자열 파라미터는 getParameter(String name)으로 받는다.
		String title = mpRequest.getParameter("title"); // 폼에서의 제목 태그, request를 쓰면 안된다.
		
		// 4). 첨부파일은 getFile(String name)으로 받는다.
		File image = mpRequest.getFile("image");	//<input type="file" name="image">
		
		System.out.println("상대경로: " + image.getName());
		System.out.println("절대경로: " + image.getAbsolutePath());
		
		// 5) java.sql.Date는 new java.sql.Date(new java.util.Date().getTime())로 받는다.
		// String -> java.util.Date -> long -> java.sql.Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String inputDate  = mpRequest.getParameter("eventDate");
		java.util.Date d1 = sdf.parse(inputDate); // parse하면 문자열을 Date형으로 바꾸어줌
		long time = d1.getTime(); //1970년 1월 1일을 기준으로 오늘까지를 계산하여 넣어줌
		java.sql.Date d2 = new java.sql.Date(time);
		
		// 6) 준비된 값을 dto에 모두 세팅한다.
		dto = new Ex02DTO();
		dto.setTitle(title);
		dto.setImage(image.getName()); // 파일의 이름만 문자열 형식으로 저장한다.(출력 할 때 태그에 이름을 써줘야되기때문에)
		dto.setEventDate(d2);
		
		return dto;
	}


	// saveDirectory 내부의 파일이름을 문자열의 배열 형태로 반환하는 함수
	public String[] getFileNames() {
		String[] arr = null;
		if(saveDirectory != null) {
			File dir = new File(saveDirectory);
			arr = dir.list();
		}
		return arr;
	}




}
