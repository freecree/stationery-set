package services;

import lombok.RequiredArgsConstructor;
import models.TestEntity;
import org.springframework.stereotype.Service;
import repository.ProductSetRepository;
import repository.TestEntityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    final private TestEntityRepository testEntityRepository;

    public List<TestEntity> getTestRecords() {
      return testEntityRepository.findAll();
    }
}
