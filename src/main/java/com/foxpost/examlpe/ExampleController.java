package com.foxpost.examlpe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @GetMapping("/user")
    public ExampleMessage userEndpoint() {
        return new ExampleMessage("Hello user!");
    }

    @GetMapping("/admin")
    public ExampleMessage adminEndpoint() {
        return new ExampleMessage("Hello admin!");
    }
}
