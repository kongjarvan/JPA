package site.metacoding.white.domain;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository // ioc 컨테이너 띄우기
public class BoardRepository {

	private final EntityManager em;

	public void save(Board board) {
		em.persist(board); // insert 시켜줌, update는 안됨
	}

	public Board findById(Long id) {
		Board boardPS = em.createQuery("select b from Board b where b.id = :id", Board.class)
				.setParameter("id", id)
				.getSingleResult();
		return boardPS;
	}

	public List<Board> findAll() {
		List<Board> boardList = em.createQuery("select b from Board b", Board.class)
				.getResultList();
		return boardList;
	}

	public void deleteById(Long id) {
		em.createQuery("delete from Board b where b.id= :id")
				.setParameter("id", id)
				.executeUpdate();
	}

}
