package string;

public class Ex04 {

	public static void main(String[] args) {
		String[] arr = {"짱꾸" , "맹구" , "유리" , "훈이" , "수지" ,"철수" , "짱아"};
		String s2 = "";
		String search = "짱";	//sc.next();
		
		
		
		for(int i = 0; i < arr.length; i++ ) {// 전체 arr배열 중
			String name = arr[i];			  // 각 개별 데이터를 name이라고 할 때,
			if(name.contains(search)) {		  // name에 "구" 라는 글자가 포함되면,
			//System.out.println(name);		  // 출력
				s2 += name + "\n";			  // 이름과 줄바꿈문자를 더함.
			}
			
		}
		System.out.println(s2);
	}

}
