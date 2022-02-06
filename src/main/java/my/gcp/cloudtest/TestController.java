package my.gcp.cloudtest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("info")
    public ResponseEntity<String> info(){
        return ResponseEntity.status(HttpStatus.OK).body("Application is running");
    }
}
