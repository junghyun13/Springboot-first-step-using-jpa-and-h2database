package hello.hello_spring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam(value="name",required =false) String name,Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello-string "+name;
    }
    @GetMapping("hello-api")
    @ResponseBody //api방식은 객체를 반환 HTTP 메세지 컨버터를 통해 JSON방식바꿔서 반환후  HTTP 리스판스바디에 값을 넣어서 반환
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello =new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
