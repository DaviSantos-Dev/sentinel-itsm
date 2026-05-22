package davisantos.dev.SentinelITSM.entities;

import davisantos.dev.SentinelITSM.user.domain.Department;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentTest {

    @Test
    void createDepartmentTest(){
        Department department = new Department("RH");
        System.out.println("\n \n \n" + department +  "\n \n \n");
    }

}
