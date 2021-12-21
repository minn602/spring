package Beginner.springbeginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    //url 주소를 치고 들어오면 GET방식이기 때문에 GetMapping 어노테이션을 붙여준다.
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!");
        //여기서 리턴되는 값은 resources -> templates-> 동일한 이름의 파일을 찾아서 렌더링 해라 라는 의미이다.
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-spring")
    //http 응답 body 부분에 이 데이터를 직접 내려주겠다는 의미이다.
    //이전에 view template를 통해 데이터를 전달하는 것이 아닌 문자 그대로 전달된다.
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    //json 형식으로 반환된다.
    @ResponseBody
    public Hello HelloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        //getter, setter -> java bean 표준 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
