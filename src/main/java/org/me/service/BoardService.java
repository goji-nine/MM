package org.me.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.me.vo.BoardVo;

public interface BoardService {

	// 01. �Խñ� �ۼ�
    public void create(BoardVo vo);
    
    // 02. �Խñ� �󼼺���
    public BoardVo read(int bno);
    
    // 03. �Խñ� ����
    public void update(BoardVo vo);
    
    // 04. �Խñ� ����
    public void delete(int bno);
    
    // 05. �Խñ� ��ü ���
    public List<BoardVo> listAll();
	
}
