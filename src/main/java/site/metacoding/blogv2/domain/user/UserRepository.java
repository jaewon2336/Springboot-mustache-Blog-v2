package site.metacoding.blogv2.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    // = executeQuery()
    @Query(value = "SELECT * FROM user WHERE username=:username AND password=:password", nativeQuery = true)
    User mLogin(@Param("username") String username, @Param("password") String password);

    // UPDATE시에 영속화말고 직접 네이티브 쿼리를 짜도됨
    // @Modifying // 네이티브쿼리로 WRITE 작업을 하려면 이 어노테이션을 붙여줘야함 = executeUpdate()
    // @Query(value="UPDATE user SET password = :password, email = :email, address=
    // :address WHERE id=:id", nativeQuery = true)
    // void mUpdate(@Param("password") String password, @Param("email") String
    // email, @Param("address") String address, @Param("id") Integer id);
}
