package site.metacoding.blogv2.web.api;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.service.UserService;
import site.metacoding.blogv2.web.api.dto.ResponseDto;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;
import site.metacoding.blogv2.web.api.dto.user.LoginDto;
import site.metacoding.blogv2.web.api.dto.user.UpdateDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final HttpSession session;

    // 이것도 있어야 나중에 앱에서 상세보기 할 수 있음
    // 우리 웹브라우저에서는 현재 사용안함. 추후 앱에서 요청시에 사용할 예정
    @GetMapping("/s/api/user/{id}")
    public ResponseDto<?> userInfo(@PathVariable Integer id) {
        User userEntity = userService.회원정보(id);
        return new ResponseDto<>(1, "성공", userEntity);
    }

    // 유저정보 수정 password, email, address
    @PutMapping("/s/api/user/{id}")
    public ResponseDto<?> update(@PathVariable Integer id, @RequestBody UpdateDto updateDto, Model model) {

        // System.out.println("id : " + id + ", updateDto : " + updateDto);

        // 세션의 아이디와 {id}를 비교
        User principal = (User) session.getAttribute("principal");
        if (principal.getId() != id) {
            throw new RuntimeException("권한이 없습니다.");
        }

        User userEntity = userService.회원수정(id, updateDto);
        session.setAttribute("principal", userEntity); // 세션 변경하기

        return new ResponseDto<>(1, "업데이트 성공", null);
    }

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