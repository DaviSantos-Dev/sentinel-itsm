package davisantos.dev.SentinelITSM.user.repositories;

import davisantos.dev.SentinelITSM.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
