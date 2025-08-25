package temp.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import temp.example.board.dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="board_table")
public class BoardEntity extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String boardWriter;
    private String boardTitle;
    private String boardContents;
    private String boardPass;
    private int boardHits;

    //부모 삭제시 자식도 함께 삭제가 됨
    @OneToMany(mappedBy = "boardEntity",cascade = CascadeType.REMOVE, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList=new ArrayList<>();

    public static BoardEntity tosaveEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardHits(0);
        return boardEntity;
    }

    public static BoardEntity toupdateEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(boardDTO.getId());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardHits(boardDTO.getBoardHits());
        return boardEntity;
    }
}
