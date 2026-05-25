package davisantos.dev.SentinelITSM.user.repositories;

import davisantos.dev.SentinelITSM.user.domain.Department;
import davisantos.dev.SentinelITSM.user.domain.User;
import davisantos.dev.SentinelITSM.user.domain.enums.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void saveUserTest(){
        Department department =  new Department("TI");
        departmentRepository.save(department);

        User user = new User("Davi", "Santos","meuemail@gmail.com","1234", Role.ADMIN, department);

        repository.save(user);

        System.out.println(user.getId());
        System.out.println(user);
    }
}
