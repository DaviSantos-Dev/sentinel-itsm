package davisantos.dev.SentinelITSM.user.domain;

import davisantos.dev.SentinelITSM.modules.department.domain.Department;
import davisantos.dev.SentinelITSM.modules.user.domain.User;
import davisantos.dev.SentinelITSM.modules.user.domain.enums.Role;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Test
    void createUserTest(){
        Department department = new Department("TI");
        User davi = new User("Davi", "Santos","meuemail@gmail.com","1234", Role.ADMIN, department);

        System.out.println();
        System.out.println(davi);
        System.out.println();
    }
}
