package com.example.demo.controller;

import com.example.demo.dto.TestDTO;
import com.example.demo.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/post")
    public void save(@RequestBody TestDTO testDTO) {
        System.out.println("title = " + testDTO.getTitle() + ", content = " + testDTO.getContent());
        testService.save(testDTO);
    }

    @GetMapping("/get/{id}")
    public TestDTO findById(@PathVariable Long id){
        TestDTO testDTO = testService.findById(id);
        return testDTO;
    }

    @PutMapping("/put/{id}")
    public void update(@PathVariable Long id, @RequestBody TestDTO testDTO){
        testService.update(id, testDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        testService.delete(id);
    }
}
