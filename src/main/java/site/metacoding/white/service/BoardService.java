package site.metacoding.white.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.white.domain.Board;
import site.metacoding.white.domain.BoardRepository;

// 트랜젝션 관리
// DTO 변환하여 컨트롤러에게 리턴

@RequiredArgsConstructor
@Service // ioc컨테이너에 띄워줌
public class BoardService {

	private final BoardRepository boardRepository;

	@Transactional // 이거 안붙이면 save가 안됨
	public void save(Board board) {
		boardRepository.save(board);
	}

	public Board findById(Long id) { // select만 할거면 transactional 안붙여도 됨
		return boardRepository.findById(id);
	}

	public List<Board> findAll() {
		return boardRepository.findAll();
	}

	@Transactional
	public void update(Long id, Board board) {
		Board boardPS = boardRepository.findById(id);
		boardPS.setTitle(board.getTitle());
		boardPS.setContent(board.getContent());
	} // 종료시 더티체킹 하여 모든 쓰레기 데이터를 flush => update 됨

	@Transactional
	public void deleteById(Long id) {
		boardRepository.deleteById(id);
	}

}