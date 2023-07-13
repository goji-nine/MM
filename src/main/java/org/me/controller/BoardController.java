package org.me.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.me.service.BoardService;
import org.me.vo.BoardVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller // ���� Ŭ������ ��Ʈ�ѷ� ��(bean)���� ���
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	// 01. �Խñ� ���
	// Ư�� uri�� ��û�� ������ Controller���� ��� ������� ó������ ����
	/**
	 * @RequestMapping(value = "/hello-basic")
 �̷��� ������ �ϸ� localhost:8080/hello-basic���� url�� �Է����� ��쿡 �̰Ϳ� �ش��ϴ� �޼��尡 ����ȴ�.
	 */
	@RequestMapping(value = "/list.do")
	//  ModelAndView�� �����Ϳ� �̵��ϰ��� �ϴ� View Page�� ���� �����Ѵ�
	public ModelAndView list() {

		List<BoardVo> list = boardService.listAll();
		
		// ModelAndView - �𵨰� ��
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/board/list"); // �並 list.jsp�� ����
		mav.addObject("list", list); // �����͸� ����
		
		return mav; // list.jsp�� List�� ���޵ȴ�.
	}
	
	// 02_01. �Խñ� �ۼ�ȭ��
	@RequestMapping(value = "/board/write.do", method = RequestMethod.GET)
	public ModelAndView insertPage(@ModelAttribute BoardVo vo) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/write");
		
		return mav; 
	}

	// 02_02. �Խñ� �ۼ�
	@RequestMapping(value = "/board/insert.do", method = RequestMethod.POST)
	public String insert(@ModelAttribute BoardVo vo) {
		
		boardService.create(vo);
		
		return "redirect:/list.do";
	}

	// 03. �Խñ� �󼼳��� ��ȸ, �Խñ� ��ȸ�� ���� ó��
	// @RequestParam
	@RequestMapping(value = "/board/view.do", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int bno) {
		// ��(������)+��(ȭ��)�� �Բ� �����ϴ� ��ü
		ModelAndView mav = new ModelAndView();
		// ���� �̸�
		mav.setViewName("board/view");
		// �信 ������ ������
		mav.addObject("dto", boardService.read(bno));
		
		return mav;
	}

	// 04. �Խñ� ����
	// ������ �Է��� ������� @ModelAttribute BoardVo vo�� ���޵�
	@RequestMapping(value = "/board/update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardVo vo) {
		
		boardService.update(vo);
		
		return "redirect:/list.do";
	}

	// 05. �Խñ� ����
	@RequestMapping("/board/delete.do")
	public String delete(@RequestParam int bno) {
		
		boardService.delete(bno);
		
		return "redirect:/list.do";
	}

}
