package site.metacoding.blogv2.web.api.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blogv2.domain.post.Post;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailResponseDto {
    // 컴포지션
    private Post post;
    private boolean auth;
}
