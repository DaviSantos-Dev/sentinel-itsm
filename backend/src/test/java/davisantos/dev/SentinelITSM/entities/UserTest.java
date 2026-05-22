package davisantos.dev.SentinelITSM.entities;

import davisantos.dev.SentinelITSM.user.domain.Department;
import davisantos.dev.SentinelITSM.user.domain.User;
import davisantos.dev.SentinelITSM.user.domain.enums.Role;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Test
    void createUserTest(){
        Department department = new Department("RH");
        User roberto = new User("Davi", "Santos","meuemail@gmail.com","1234", Role.ADMIN, department);

        System.out.println();
        System.out.println(roberto);
        System.out.println();
    }
}
