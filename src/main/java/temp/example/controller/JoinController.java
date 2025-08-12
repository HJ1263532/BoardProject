package temp.example.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import temp.example.DTO.JoinDTO;
import temp.example.service.JoinService;

@RestController
@AllArgsConstructor
public class JoinController {
    public final JoinService joinService;

    @PostMapping("/join")
    public String join(@RequestBody JoinDTO joinDTO) {
        System.out.println(joinDTO.getName());
        joinService.join(joinDTO);
        return "ok";
    }
}
