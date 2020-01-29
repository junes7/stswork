package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//기본 web에서 작성하던 서블릿과 동일한 역할을 하는 클래스
//컨트롤러
//- DispatcherServlet에서 호출되는 클래스
//- 서블릿에서 했던 것 처럼 dao의 메소드를 호출
//- 데이터 공유(스프링의 방법대로)

@Controller
public class TestController {
	@RequestMapping("/test.do")
	public ModelAndView handleRequest(HttpServletRequest arg0, 
		HttpServletResponse arg1) throws Exception {		
			System.out.println("컨트롤러 요청 완료");
		ModelAndView mav = new ModelAndView();
		
		String data="";
		for(int i=1; i<=9; i++) {
			data = data+(9+"*"+i+"="+(9*i))+"<br/>";
		}
		mav.addObject("msg",data);		
		//forward할 뷰의 정보를 정의 - 기본이 forward
		mav.setViewName("test/result");		
		
		return mav;
	}
}

