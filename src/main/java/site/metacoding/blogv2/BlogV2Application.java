package site.metacoding.blogv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 시간을 자동으로 넣어주는 JPA 어노테이션 추가
@SpringBootApplication
public class BlogV2Application {

	public static void main(String[] args) {
		SpringApplication.run(BlogV2Application.class, args);
	}

}