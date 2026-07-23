package davisantos.dev.SentinelITSM.modules.user.repositories;

import davisantos.dev.SentinelITSM.modules.user.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
