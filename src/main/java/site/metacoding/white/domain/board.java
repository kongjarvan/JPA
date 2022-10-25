package site.metacoding.white.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity // 엔티티로 설정
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 DB에 위임
	private Long id; // id에 auto_increment를 설정
	private String title;
	@Column(length = 1000) // varchar의 길이를 설정
	private String content;

	// FK가 만들어짐 user_id
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	@Builder
	public Board(Long id, String title, String content, User user) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.user = user;
	}

	// 변경하는 코드는 의미 있게 메서드로 구현
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}

}
