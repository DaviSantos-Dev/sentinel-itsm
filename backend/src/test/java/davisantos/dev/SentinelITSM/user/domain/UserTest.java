package davisantos.dev.SentinelITSM.user.domain;

import davisantos.dev.SentinelITSM.user.domain.enums.Role;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Test
    void createUserTest(){
        Department department = new Department("RH");
        User davi = new User("Davi", "Santos","meuemail@gmail.com","1234", Role.ADMIN, department);

        System.out.println();
        System.out.println(davi);
        System.out.println();
    }
}
