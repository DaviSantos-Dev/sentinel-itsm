package davisantos.dev.SentinelITSM.user.repositories;

import davisantos.dev.SentinelITSM.user.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
