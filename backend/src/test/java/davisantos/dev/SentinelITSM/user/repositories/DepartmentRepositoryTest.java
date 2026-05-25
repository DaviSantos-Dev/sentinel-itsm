package davisantos.dev.SentinelITSM.user.repositories;

import davisantos.dev.SentinelITSM.user.domain.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    void saveDepartmentTest(){
        Department department = new Department("TI");
        departmentRepository.save(department);

        System.out.println(department.getId());
        System.out.println(department.getName());
        System.out.println(department.getCreatedAt());
    }
}
