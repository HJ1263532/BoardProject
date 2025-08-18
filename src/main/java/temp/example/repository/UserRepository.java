package temp.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import temp.example.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Boolean existsByNickname(String nickname);

    UserEntity findByNickname(String nickname);

}
