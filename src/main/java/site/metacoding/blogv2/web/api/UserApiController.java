package site.metacoding.blogv2.web.api;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.service.UserService;
import site.metacoding.blogv2.web.api.dto.ResponseDto;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;
import site.metacoding.blogv2.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final HttpSession session;

    @PostMapping("/join")
    public ResponseDto<?> join(@RequestBody JoinDto joinDto) {

        userService.회원가입(joinDto);

        return new ResponseDto<>(1, "회원가입 성공", null);
    }

    @PostMapping("/login")
    public ResponseDto<?> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {

        User userEntity = userService.로그인(loginDto);

        if (userEntity == null) {
            return new ResponseDto<>(-1, "로그인 실패", null);
        }

        session.setAttribute("principal", userEntity); // 세션에 저장

        if (loginDto.getRemember().equals("on")) {
            System.out.println(loginDto.getRemember()); // on
            // response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername() +
            // ";path=/; httpOnly=true");
            response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername() + ";path=/");
        }

        return new ResponseDto<>(1, "로그인 성공", null);
    }

    @GetMapping("/logout")
    public ResponseDto<?> logout() {

        session.invalidate(); // 해당 JSESSIONID 영역 전체 날리기 -> 로그아웃

        return new ResponseDto<>(1, "로그아웃 성공", null);
    }
}