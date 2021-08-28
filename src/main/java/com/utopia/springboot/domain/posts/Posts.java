package com.utopia.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Entity 클래스에서는 절대 Setter를 만들지 않는다.
// 값 변경이 필요한 경우에는 명확한 목적과 의도를 나타낼 수 있는 메소드를 만들어서 처리한다.

//// 이런 식으로 Setter를 만들지 않고
//@NoArgsConstructor
//class Order {
//    private boolean m_status;
//
//    public void setStatus(boolean p_status) {
//        this.m_status = p_status;
//    }
//}

@Getter
@NoArgsConstructor
@Entity //테이블과 연결될 클래스임을 나타냄, 기본적으로 클래스명의 Camel Case를 ASD_QWE 형식으로 매칭시켜줌 (AsdQwe -> ASD_QWE)
public class Posts {

    @Id //테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙을 나타냄, GenerationType.IDENTIFY를 추가해줘야 Auto-Increment가 된다.
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

//    // 이런식으로 호출하지 않는다.
//    public static Order order;
//    public static void cancelOrder() {
//        order.setStatus(false);
//    }

}
