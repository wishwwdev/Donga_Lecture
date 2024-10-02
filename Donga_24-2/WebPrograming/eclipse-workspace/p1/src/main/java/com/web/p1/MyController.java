package com.web.p1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 엄청나게 중요하게 신경써야 하는 부분
// 컨트롤러 선언(@Controller). 이걸 해줘야 고객응대 가능!!
@Controller
public class MyController { // 소스명, 클래스명 대소문자까지 완벽 동일
	
	// 여기 코딩할 건데
	// 이 안에는 메소드들을 코딩합니다. 화면1개에 메소드1개
	
	@GetMapping("/")	// 고객님이 사이트주소만 넣고 더이상 세부주소 안치시면 (홈페이지 첫화면)
	public String home() {	// 메소드명 자유. 대부분은 화면 이름이나 주소랑 동일하게 하는 경향
		return "home";	// 화면 내보내는 한 줄. html소스는 templates안에 있어야 함
	}
	
	@GetMapping("/ex01")
	public String ex01() {
		return "ex01"; 
	}
	
	@PostMapping("/ex01/answer")
	public String ex01Answer(@RequestParam(name="mid") String mid, @RequestParam(name="pw") String pw, Model mo) {
		mo.addAttribute("mid", mid);
		mo.addAttribute("pw", pw);
		return "ex01Answer";
	} 
	
	@GetMapping("/ex02")
	public String ex02() {
		return "ex02";
	}
	
	@PostMapping("/ex02/answer")
	public String ex02Answer(@RequestParam("mname") String mname, @RequestParam("po") String po, Model mo) {
		mo.addAttribute("mname", mname);
		mo.addAttribute("po", po);
		int salary = 0;
		switch(po){ // java switch문에서는 break없음 -> 한줄 하고 ;만나서 종료함
			case "사원" -> salary = 3500; /* Java switch문 */
			case "대리" -> salary = 5000; 
			case "팀장" -> salary = 7000; 
			case "임원" -> salary = 9900; 
		}
		mo.addAttribute("salary", salary);
		return "ex02Answer";
	}
	
	@GetMapping("/ex03")
	public String ex03() {
		return "ex03";
	}
	
	@PostMapping("/ex03/answer")
	public String ex03Answer(@RequestParam("mname") String mname, @RequestParam("color") String color, Model mo) {
		mo.addAttribute("mname", mname);
		mo.addAttribute("color", color);
		return "ex03Answer";
	}
	
	@GetMapping("/wise")
	public String wise() {
		return "wise"; 
	}
	
	@PostMapping("/wise/answer")
	public String wiseAnswer(@RequestParam(name="mname") String mname, @RequestParam(name="content") String content, Model mo) {
		mo.addAttribute("mname", mname);
		mo.addAttribute("content", content);
		return "wiseAnswer";
	}
}
