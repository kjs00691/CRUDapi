package com.example.demo.service;

import com.example.demo.dto.TestDTO;
import com.example.demo.entity.TestEntity;
import com.example.demo.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public void save(TestDTO testDTO) {
        TestEntity testEntity = TestEntity.toTestEntity(testDTO);
        testRepository.save(testEntity);
    }

    public TestDTO findById(Long id) {
        Optional<TestEntity> optionalTestEntity = testRepository.findById(id);
        if(optionalTestEntity.isPresent()) {
            return TestDTO.toTestDTO(optionalTestEntity.get());
        }else{
            return null;
        }
    }

    public void update(Long id, TestDTO testDTO){
        Optional<TestEntity> optionalTestEntity = testRepository.findById(id);
        if(optionalTestEntity.isPresent()) {
            TestEntity testEntity = optionalTestEntity.get();
            testEntity.setTitle(testDTO.getTitle());
            testEntity.setContent(testDTO.getContent());

            testRepository.save(testEntity);
        }

    }

    public void delete(Long id){
        testRepository.deleteById(id);
    }
}
