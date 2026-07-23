package davisantos.dev.SentinelITSM.modules.user.domain;

import davisantos.dev.SentinelITSM.shared.exceptions.InvalidStateException;
import davisantos.dev.SentinelITSM.shared.exceptions.InvalidValueException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "department")
    private List<User> users;
    private boolean active;
    @Column(nullable = false)
    private Instant createdAt;

    public Department(String name) {
        setName(name);
        activeDepartment();
        createdAt = Instant.now();
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidValueException("Department name is required");
        }
        this.name = name;
    }

    public void activeDepartment(){
        if (this.active) {
            throw new InvalidStateException("Department is already active");
        }
        this.active = true;
    }

    public void deactiveDepartment(){
        if (!this.active){
            throw new InvalidStateException("Department is already inactive");
        }
        this.active = false;
    }

}
