package kr.codesquad.office;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloApi {

    @GetMapping
    public String hello() {
        return "hello";
    }
}
