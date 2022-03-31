package site.metacoding.blogv2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    // 앱은 이 메서드 요청 안함, 웹만 함
    // SSR할지 CSR할지 선택 -> 이거는 SSR!
    @GetMapping("/s/user/{id}")
    public String userInfo(/* Model model, */@PathVariable Integer id) {
        // DB에서 셀렉트해서 모델에 담으면 끝
        // User userEntity = userService.회원정보(id);
        // model.addAttribute("user", userEntity);

        return "user/updateForm";
    }

    // @GetMapping("/logout")
    // public String logout() {
    // session.invalidate();
    // return "redirect:/";
    // }

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
}
