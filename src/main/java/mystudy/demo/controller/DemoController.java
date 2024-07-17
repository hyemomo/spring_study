package mystudy.demo.controller;

import org.apache.catalina.users.GenericRole;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "helllO!!!");
        return "hello";

    }
    @GetMapping("hello-mvc")
    public String helloMvc (@RequestParam("name")String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name")String name){
        return "hello"+name; //hello spring
        //view 가 없고 문자 그대로 화면에 나옴.html 거치지 않고 하는 거 같음.!
    }
    @GetMapping("hello-api")//api 하면은 객체를 리턴할 수 도 있음 json 방식
    @ResponseBody
    public  Hello helloApi(@RequestParam("name") String name){
Hello hello = new Hello();
hello.setName(name);
return hello;

    }
    public class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
