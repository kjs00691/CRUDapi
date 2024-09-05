package com.example.demo.dto;

import com.example.demo.entity.TestEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestDTO {
    private Long id;
    private String title;
    private String content;

    public static TestDTO toTestDTO(TestEntity testEntity){
        TestDTO testDTO = new TestDTO();
        testDTO.setId(testEntity.getId());
        testDTO.setTitle(testEntity.getTitle());
        testDTO.setContent(testEntity.getContent());
        return testDTO;
    }
}
