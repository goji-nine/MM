package org.me.dao;

import java.io.Reader;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.me.vo.BoardVo;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository // ���� Ŭ������ dao bean���� ���
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {

	private final SqlSession SqlSession;
	
	private static SqlSessionFactory sqlMapper;
	
	private static SqlSessionFactory getInstance() {
		
			if(sqlMapper == null) {
				String resource = "mybatis-config.xml";
				
				try {
					Reader reader = Resources.getResourceAsReader(resource);
					sqlMapper = new SqlSessionFactoryBuilder().build(reader);
					reader.close();					
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
			return sqlMapper;		
	}	

	// 01. �Խñ� �ۼ�
	@Override
	public void create(BoardVo vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		session.insert("board.insertBoard", vo);
		session.commit();
	}

	// 02. �Խñ� �󼼺���
	@Override
	public BoardVo read(int bno) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		return session.selectOne("board.view", bno);
	}

	// 03. �Խñ� ����
	@Override
	public void update(BoardVo vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		session.update("board.updateBoard", vo);
		session.commit();
	}

	// 04. �Խñ� ����
	@Override
	public void delete(int bno) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		session.delete("board.deleteBoard", bno);
		session.commit();

	}

	// 05. �Խñ� ��ü ���
	@Override
	public List<BoardVo> listAll() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		List<BoardVo> boardVo = session.selectList("board.listAll");
		
		return boardVo;
	}

}
