package temp.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="user_table")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long userId;

    @Column
    private String nickname;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String age;

    private String role;
}

