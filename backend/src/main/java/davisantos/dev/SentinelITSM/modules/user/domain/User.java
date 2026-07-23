package davisantos.dev.SentinelITSM.modules.user.domain;

import davisantos.dev.SentinelITSM.modules.department.domain.Department;
import davisantos.dev.SentinelITSM.shared.exceptions.InvalidStateException;
import davisantos.dev.SentinelITSM.shared.exceptions.InvalidValueException;
import davisantos.dev.SentinelITSM.modules.user.domain.enums.Role;
import davisantos.dev.SentinelITSM.modules.user.domain.enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="first_name", nullable = false)
    private String firstName;
    @Column(name ="last_name", nullable = false)
    private String lastName;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",nullable = false)
    private Department department;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @Column (name ="created_at",nullable = false)
    private Instant createdAt;
    @Column (name ="updated_at")
    private Instant updatedAt;

    public User(String firstName, String lastName, String email, String password, Role role, Department department) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setRole(role);
        setDepartment(department);
        createdAt = Instant.now();
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new InvalidValueException("First name cannot be empty");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new InvalidValueException("First name cannot be empty");
        }
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new InvalidValueException("Email is required");
        }
        this.email = email.toLowerCase().trim();
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new InvalidValueException("Password required");
        }
        this.password = password;
    }

    public void setRole(Role role) {
        if (role == null) {
            this.role = Role.CLIENT;
        }else {
            this.role = role;
        }
    }

    public void setDepartment(Department department) {
        if (department == null) {
            throw new InvalidValueException("Department is required");
        }
        if (!department.isActive()){
            throw new InvalidStateException("This department is not active");
        }
        this.department = department;
    }

    public void activeUser() {
        if (status == UserStatus.ACTIVE) {
            throw new InvalidStateException("User is already active");
        }
        if (status == UserStatus.BLOCKED) {
            throw new InvalidStateException("User is blocked, cannot be Activated");
        }
        this.status = UserStatus.ACTIVE;
    }

    public void deactiveUser() {
        if (status == UserStatus.INACTIVE) {
            throw new InvalidStateException("User is already inactive");
        }
        if (status == UserStatus.BLOCKED) {
            throw new InvalidStateException("User is blocked, cannot be Deactivated");
        }
        this.status = UserStatus.INACTIVE;
    }

    public void blockUser() {
        if (status == UserStatus.BLOCKED) {
            throw new InvalidStateException("User is already blocked");
        }
        this.status = UserStatus.BLOCKED;
    }

    public void unblockUser() {
        if (status == UserStatus.INACTIVE) {
            throw new InvalidStateException("User are not blocked");
        }
        if (status == UserStatus.ACTIVE) {
            throw new InvalidStateException("User are not blocked");
        }
        this.status = UserStatus.ACTIVE;
    }

}
