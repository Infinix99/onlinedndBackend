package rest.onlinednd.MappingController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleTestController {

    @GetMapping("/")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/restricted")
    public String restrictedHello(){
        return "Hello restricted";
    }
}
