package org.me.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.me.dao.BoardDAO;
import org.me.vo.BoardVo;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardDAO boardDao;
	    
	    // 01. �Խñ۾���
	    @Override
	    public void create(BoardVo vo) {
	        String title = vo.getTitle();
	        String content = vo.getContent();
	        String writer = vo.getWriter();
	        
	        // *�±׹��� ó�� (< ==> &lt; > ==> &gt;)
	        // replace(A, B) A�� B�� ����
	        title = title.replace("<", "&lt;");
	        title = title.replace("<", "&gt;");
	        writer = writer.replace("<", "&lt;");
	        writer = writer.replace("<", "&gt;");
	        // *���鹮�� ó��
	        title = title.replace("  ",    "&nbsp;&nbsp;");
	        writer = writer.replace("  ",    "&nbsp;&nbsp;");
	        // *�ٹٲ� ����ó��
	        content = content.replace("\n", "<br>");
	        
	        vo.setTitle(title);
	        vo.setContent(content);
	        vo.setWriter(writer);
	        
	        boardDao.create(vo);
	    }
	    
	    // 02. �Խñ� �󼼺���
	    @Override
	    public BoardVo read(int bno){
	        return boardDao.read(bno);
	    }
	    
	    // 03. �Խñ� ����
	    @Override
	    public void update(BoardVo vo){
	    	boardDao.update(vo);
	    }
	    
	    // 04. �Խñ� ����
	    @Override
	    public void delete(int bno){
	    	boardDao.delete(bno);
	    }
	    
	    // 05. �Խñ� ��ü ���
	    @Override
	    public List<BoardVo> listAll(){
	    	
	    	List<BoardVo> boardVo = boardDao.listAll();
	    	
	        return boardVo ;
	    }
	    
}
