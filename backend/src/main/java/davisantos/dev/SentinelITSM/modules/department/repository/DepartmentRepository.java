package davisantos.dev.SentinelITSM.modules.department.repository;

import davisantos.dev.SentinelITSM.modules.department.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
