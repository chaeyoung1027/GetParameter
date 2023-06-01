package kr.hs.study.GetParameter.contoller;

import kr.hs.study.GetParameter.dto.test6;
import kr.hs.study.GetParameter.dto.test7;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
            System.out.println("data3 : "+str);
        }
        return "result";
    }

    @GetMapping("/test4/{a}/{b}/{c}")
    public String test4(@PathVariable String a, @PathVariable String b, @PathVariable String c){
        System.out.println("data1 : "+a);
        System.out.println("data2 : "+b);
        System.out.println("data3 : "+c);
        return "result";
    }

    @GetMapping("/test5")
    public String test5(@RequestParam("data1") String data1, @RequestParam("data2") String data2, @RequestParam("data3") String [] data3){
        System.out.println("data1 : "+data1);
        System.out.println("data2 : "+data2);
        for(String str:data3){
            System.out.println("data3 : " + str);
        }

        return "result";
    }

    @GetMapping("/test6")
    public String test6(@ModelAttribute test6 t){
        //@ModelAttribute test6 t
        //부트가 test6객체 t를 만들고
        //사용자의 데이터를 set메서드를 이용해서 멤버변수에 넣는다. -> Boot가 해줌.
        //출력

        System.out.println("data1 : "+t.getData1());
        System.out.println("data2 : "+t.getData2());
        System.out.println("data3 : "+t.getData3());

        return "result";
    }

    @GetMapping("/test7")
    public String test7(@ModelAttribute test7 t){
        System.out.println("id : "+t.getId());
        System.out.println("password : "+t.getPassword());
        return "login.html";
    }
}
