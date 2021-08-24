package com.utopia.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Entity클래스로 DB에 접근하게 해줄 Entity Repository
//JpaRepository<Entity클래스명, PK타입> 을 상속해주면 기본적인 CRUD를 자동적으로 생성해준다.
// Entity클래스와 Entity Repository는 같은 위치에 있어야 한다. 일반적으로 domain 패키지에서 함께 관리한다.

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
