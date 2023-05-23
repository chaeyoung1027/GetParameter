package kr.hs.study.GetParameter.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
public class testController {
    //homeController에도 들어있기 때문에 겹침에러
//    @GetMapping("/")
//    public String home() {
//        return "result";
//    }
    @GetMapping("/test1")
    public String test1(HttpServletRequest req)
    {
        String a = req.getParameter("data1");
        String b = req.getParameter("data2");
        String c = req.getParameter("data3");
        System.out.println("data1 : "+a);
        System.out.println("data2 : "+b);
        System.out.println("data3 : "+c);
        return "result";
    }

    @GetMapping("/test2")
    public String test2(HttpServletRequest req){
        String a = req.getParameter("data1");
        String b = req.getParameter("data2");
        String[] c = req.getParameterValues("data3");

        System.out.println("data1 : "+a);
        System.out.println("data2 : "+b);
        for(String str:c){
            System.out.println("data3 : "+str);
        }

        return "result";
    }

    @GetMapping("/test3")
    public String test3(WebRequest wr){
        String a = wr.getParameter("data1");
        String b = wr.getParameter("data2");
        String[] c = wr.getParameterValues("data3");
        for(String str:c){
            System.out.println("data3"+str);
        }
        return "result";
    }
}
