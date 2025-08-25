package temp.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity{
    @CreationTimestamp //생성되었을 때의 시간을 명시
    @Column(updatable = false)//수정시 관여 x 옵션
    private LocalDateTime createdTime;

    @UpdateTimestamp//업데이트되었을 때의 시간을 명시
    @Column(insertable = false)// 처음 생성(create)시 관여 x 옵션
    private LocalDateTime updatedTime;


}
