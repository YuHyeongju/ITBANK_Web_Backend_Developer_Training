package ex03;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileUtil {
	private static FileUtil instance = new FileUtil();

	public static FileUtil getInstance() {
		return instance;
	}

	private FileUtil() {

	}

	private String saveDirectory = "C:\\upload";  // 톰캣에 파일을 저장해놓을 경로를 지정함.
	private final int maxPostSize = 1024 * 1024 * 50; // 최대 파일 크기를 지정한다. 1024바이트 * 1024 킬로바이트 * 50 메가바이트
 	private final String encoding = "UTF-8";	      // 인코딩 형식을 지정함.
	private final FileRenamePolicy policy = new DefaultFileRenamePolicy(); // 파일 중복 정책 지정.

	public ReviewDTO getDTO(HttpServletRequest request) throws IOException, ParseException {
		ReviewDTO dto = null;
		/*
		 * if(saveDirectory == null) { // ServletContext application =
		 * request.getServletContext(); 서버가 초기화되면 사진 파일까지 다날아감 // saveDirectory =
		 * application.getRealPath("/reviewImage"); }
		 */

		MultipartRequest mpRequest = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);

		dto = new ReviewDTO();
		dto.setContent(mpRequest.getParameter("content"));
		dto.setImage(mpRequest.getFile("image").getName());
		dto.setStoreName(mpRequest.getParameter("storeName"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 형식 지정
		long time = sdf.parse(mpRequest.getParameter("visitDate")).getTime(); 
		// long time에 visitDate 문자열을 날짜 형식으로 변환하여 저장
		dto.setVisitDate(new java.sql.Date(time));
		// dto에 visitDate에 time을 sql에서 사용할 수 있는 date타입으로 변환하여 저장 
		return dto;
	}
}
