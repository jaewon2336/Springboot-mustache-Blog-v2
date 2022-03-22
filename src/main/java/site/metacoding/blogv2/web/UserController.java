package site.metacoding.blogv2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    // 웹브라우저 -> 회원가입 페이지 주세요!! (O)
    // 앱 -> 회원가입 페이지 주세요? (X)
    // 회원가입폼 (인증 X)
    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    // 로그인폼 (인증 X)
    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/")
    public String list() {
        return "post/list";
    }
}
