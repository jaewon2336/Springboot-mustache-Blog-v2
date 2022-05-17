# 블로그V2 - 스프링부트 - with mustache

## 정재원
- Blog : https://jaewon2336.tistory.com/
- Github : https://github.com/jaewon2336

## 공부 내용 블로그 정리
https://jaewon2336.tistory.com/category/Spring/Blog-V2

### 남은 기능
- 프로필 사진 업로드
- 글 수정하기

## ⚒️기술스택

### Backend
|<img src = "https://blog.kakaocdn.net/dn/cKtAuQ/btrAIO5fzCU/NVWnU8UlhL93kq81Ve87uK/img.png" width="150" height="150" />|
|:--:|
|SpringBoot  |

### Frontend
|<img src = "https://blog.kakaocdn.net/dn/cj5mLL/btrAJSMQt43/yfpTni01hZgrvKHmUdVjk1/img.png" width="150" height="150" />|<img src = "https://blog.kakaocdn.net/dn/eG2w1k/btrAD5NJ1dy/YwmkEkygLgmKevkYNgWiPk/img.png" width="150" height="150" />|<img src = "https://blog.kakaocdn.net/dn/dJtW2R/btrAIfhLlRL/cTJDpEZlRWh9m9QczAkGqK/img.png" width="150" height="150" />|<img src = "https://blog.kakaocdn.net/dn/biJtm8/btrAGfWUCEm/wLv8P9GuJP55PI0AWxOyS1/img.png" width="150" height="150" />|<img src = "https://blog.kakaocdn.net/dn/m3Phc/btrAGgBsKbm/FNYpkhIrVweUUEH4h5tsWK/img.png" width="150" height="150" />|
|:--:|:--:|:--:|:--:|:--:|
|HTML5|CSS|jQuery|Bootstrap|JavaScript|

### 형상관리 도구
|<img src = "https://blog.kakaocdn.net/dn/eyjfrN/btrAKvXV0RA/zkyytdkZy7ESd85knYRDq1/img.png" width="150" height="150" />|<img src = "https://blog.kakaocdn.net/dn/mEK9t/btrAHjxWZX3/iEGILm2rWSrOKsfilmPUA1/img.png" width="150" height="150" />|
|:--:|:--:|
|Git|Github|

### 데이터베이스
|<img src = "https://blog.kakaocdn.net/dn/5J8iY/btrAHiseB54/P1Pkgmigz1aANiQLg0Aip0/img.png" width="150" height="150" />|
|:--:|
|MariaDB|

### 의존성
```java
implementation 'org.springframework.boot:spring-boot-starter-data-jpa' // jpa
implementation 'org.springframework.boot:spring-boot-starter-mustache' // mustache
implementation 'org.springframework.boot:spring-boot-starter-web' // spring web (mvc)
compileOnly 'org.projectlombok:lombok' // lombok
developmentOnly 'org.springframework.boot:spring-boot-devtools' // devtools
runtimeOnly 'org.mariadb.jdbc:mariadb-java-client' // mariaDB
annotationProcessor 'org.projectlombok:lombok'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
```

### 1. DB 및 사용자 생성
```sql
CREATE USER 'green'@'%' IDENTIFIED BY 'green1234';
CREATE DATABASE greendb;
GRANT ALL PRIVILEGES ON greendb.* TO 'green'@'%';
```

### 2. 프로젝트 세팅
- application.yml
- view 생성

```html
<!-- 제이쿼리 추가 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 부트스트랩 추가 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- 넘머노트 추가 -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
```
 

# 블로그 V1에서 달라진 점



## API Controller
<details>
<summary>상세보기</summary>
<div markdown="1">

- 기존에 V1에서는 데이터를 리턴해주는 메서드에 `@ResponseBody` 를 붙여 파일을 리턴해주는 메서드와 같은 파일에서 만들어줬었다.  
  json 데이터를 리턴해주는 컨트롤러(`@RestController`)와 파일을 리턴해주는 컨트롤러(`@Controller`)를 분리해주었다.

</div>
</details>


## 글로벌 Exception
<details>
<summary>상세보기</summary>
<div markdown="1">

- 내가 제어할 수 없는 위치에서 터지는 오류를 만났을 때, 내가 원하는 예외 처리를 해주기 위해 전역적으로 사용할 수 있는 Exception 처리를 만들어준다.
- `@RestControllerAdvice` 를 붙여주면 모든 예외를 낚아채는 컨트롤러의 역할을 한다.
  `@ExceptionHandler` 로 특정 예외에만 낚아챌 수 있다.

</div>
</details>


## 제네릭 와일드카드 사용
<details>
<summary>상세보기</summary>
<div markdown="1">

- 데이터를 요청받고 응답하기 위해 ResponseDto를 만들어주는데 일일이 타입을 맞춰 적어주기 귀찮기 때문에 동적으로 타입 변경이 가능한 와일드 카드를 사용한다. `<?>`

</div>
</details>


## Ajax 사용
<details>
<summary>상세보기</summary>
<div markdown="1">

- 비동기 자바스크립트 통신으로써 페이지 전체 리로딩이 아닌 부분 리로딩이 가능하여 통신한 결과를 통해 **CSR(Client Side Rendering)** 이 가능하다.

</div>
</details>


## throw 사용
<details>
<summary>상세보기</summary>
<div markdown="1">

- 컨트롤러에서 뷰로 null을 리턴하게 되면 머스태치에서 뷰 렌더링시에 오류가 발생한다.
  이를 방지하기 위해 강제로 Exception을 터뜨려줄 수 있다.
  강제로 Exception을 터뜨리는 것을 `throw` 라고 한다.
- 강제로 터진 해당 Exception을 에러 핸들러가 낚아챈다.

</div>
</details>


## Interceptor를 사용한 인증 처리
<details>
<summary>상세보기</summary>
<div markdown="1">

- 컨트롤러 메서드의 전처리와 후처리를 제어할 수 있도록 인터셉터 클래스를 제공한다.
- 스프링 컨테이너 내부에서 DB 연결까지 가능하기 때문에 인증과 권한 체크가 가능하다.
- 인터셉터가 미리 인증, 권한 체크를 완료하면 컨트롤러 메서드 내부 코드가 심플해진다.  
- 하지만 권한 체크는 모든 메서드에서 공통적으로 사용할게 아니기 때문에 컨트롤러에서 처리하자.


- `/s`로 시작하는 주소의 요청을 받으면 인터셉터를 실행한다는 설정파일이다.
  ```java
  public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/s/**"); // *, ** 어떨땐 별 하나 어떨 땐 별 두개
    }
  ```


</div>
</details>

## 댓글 기능
<details>
<summary>상세보기</summary>
<div markdown="1">

### 양방향 매핑
- 게시글 상세보기할 때 댓글이 나와야한다.  
  = Post를 SELECT 하는데 Comment까지 가지고 올 수 없을 때 `양방향 매핑(@OneToMany)`을 해준다.
- 게시글 목록보기에서 Post를 SELECT 해올 때 Comment까지 다 가져오면 낭비가 심하기 때문에 `@OneToMany`의 기본 전략은 `LAZY`이다.
  ```text
  조인할 때 리스트 타입이 리턴되면 기본적으로 LAZY 전략 사용
  -> getter가 호출 될 때 조인실행
  ```
- 양방향 매핑을 해줄 때는 `mapppedBy="연관관계 주인의 변수명"` DB에 컬럼을 만들지 말라고 알려줘야한다.
- 양방향 매핑을 사용하면 MessageConverter가 getter를 때릴 때 무한 로딩이 일어난다.  
  이를 `N + 1` 문제라고한다.
- `N + 1` : 연관 관계가 설정된 엔티티를 조회할 경우에 조회된 데이터 개수(n) 만큼 연관 관계의 조회 쿼리가 추가로 발생하여 데이터(n+1)를 읽어와서 발생하는 문제
- 이 문제를 해결하는 여러가지 방법 중에 `@JsonIgnoreProperties`를 붙여 연관 관계 내부의 변수의 getter를 때리지 말라고 알려준다.
  ```java
  @JsonIgnoreProperties({ "post" }) // messageConverter에게 알려주는 어노테이션
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE) // 연관관계의 주인의 변수명
    private List<Comment> comments;
  ```

</div>
</details>

![](https://blog.kakaocdn.net/dn/cc8lyK/btrCqGK5e2k/CpFlugY386aO8Nz4w8qiUk/img.gif)
