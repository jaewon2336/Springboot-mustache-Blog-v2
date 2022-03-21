package site.metacoding.blogv2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestViewController {
    // 파일명 가장 끝에 Test가 붙으면 데브툴이 작동하지 않음 -> 서버리로드 안함
    // ex)ViewControllerTest

    @GetMapping("/post/detail")
    public String detail() {
        return "post/detail";
    }

    @GetMapping("/post/list")
    public String list() {
        return "post/list";
    }

    @GetMapping("/post/updateForm")
    public String updateForm() {
        return "post/updateForm";
    }

    @GetMapping("/post/writeForm")
    public String writeForm() {
        return "post/writeForm";
    }

    @GetMapping("/user/detail")
    public String userDetail() {
        return "user/detail";
    }

    @GetMapping("/user/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/user/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String userUpdateForm() {
        return "user/updateForm";
    }

}
