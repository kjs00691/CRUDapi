package com.example.demo.entity;


import com.example.demo.dto.TestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "table_test")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    public static TestEntity toTestEntity(TestDTO testDTO) {
        TestEntity testEntity = new TestEntity();
        testEntity.setTitle(testDTO.getTitle());
        testEntity.setContent(testDTO.getContent());
        return testEntity;
    }

}
