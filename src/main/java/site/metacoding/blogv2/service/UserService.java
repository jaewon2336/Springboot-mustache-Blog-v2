package site.metacoding.blogv2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.domain.user.UserRepository;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;
import site.metacoding.blogv2.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
// 트랜잭션을 관리하는 오브젝트 : 서비스
// 기능들의 모임 (비즈니스 로직)
@Service // 컴포넌트 스캔시에 IoC 컨테이너에 등록
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(JoinDto joinDto) {
        // save하면 DB에 INSERT하고 INSERT된 결과를 다시 return 해준다. -> jpa가 리턴해줌
        userRepository.save(joinDto.toEntity());
    }

    public User 로그인(LoginDto loginDto) {
        // 로그인 처리 쿼리를 JPA에서 제공해주지 않음 -> nativeQuery 생성
        return userRepository.mLogin(loginDto.getUsername(), loginDto.getPassword());
    }
}
