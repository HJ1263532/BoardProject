package temp.example.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import temp.example.board.dto.CommentDTO;
import temp.example.board.service.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CommentDTO commentDTO) {
        System.out.println("commentDTO = " + commentDTO);

        Long saveResult = commentService.save(commentDTO);
        if (saveResult != null) {
            // 작성 성공 → 해당 게시글의 댓글 목록 리턴
            List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoardId());
            return ResponseEntity.ok(commentDTOList);
        } else {
            // 실패 → 메시지와 404 응답
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("해당 게시글이 존재하지 않습니다.");
        }
    }

    @GetMapping("/list/{boardId}")
    public ResponseEntity<List<CommentDTO>> findAll(@PathVariable Long boardId) {
        List<CommentDTO> commentDTOList = commentService.findAll(boardId);
        return ResponseEntity.ok(commentDTOList);
    }
}
