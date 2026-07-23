package davisantos.dev.SentinelITSM.modules.user.repositories;

import davisantos.dev.SentinelITSM.modules.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
