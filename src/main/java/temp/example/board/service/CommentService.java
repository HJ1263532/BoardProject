package temp.example.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import temp.example.board.dto.CommentDTO;
import temp.example.board.entity.BoardEntity;
import temp.example.board.entity.CommentEntity;
import temp.example.board.repository.BoardRepository;
import temp.example.board.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public Long save(CommentDTO commentDTO) {
        //부모 엔티티(BoardEntity)조회
        Optional<BoardEntity> optionalBoardEntity=boardRepository.findById(commentDTO.getBoardId());
        if(optionalBoardEntity.isPresent()){
            BoardEntity boardEntity=optionalBoardEntity.get();
            CommentEntity commentEntity= CommentEntity.toSaveEntity(commentDTO,boardEntity);
            return commentRepository.save(commentEntity).getId();
        }else{
            return null;
        }
    }

    public List<CommentDTO> findAll(Long boardId) {
        BoardEntity boardEntity= boardRepository.findById(boardId).get();
        List<CommentEntity> commentEntityList=commentRepository.findAllByBoardEntityOrderByIdDesc(boardEntity);
        //Entity리스트->DTOList
        List<CommentDTO> commentDTOList=new ArrayList<>();
        for(CommentEntity commentEntity:commentEntityList){
            CommentDTO commentDTO= CommentDTO.toCommentDTO(commentEntity,boardId);
            commentDTOList.add(commentDTO);
        }
        return commentDTOList;
    }
}
