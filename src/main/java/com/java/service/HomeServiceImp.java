package com.java.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.java.dao.HomeDao;
import com.java.dto.Ex1DTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HomeServiceImp implements HomeService {

	private final HomeDao homeDao;
	
	@Override
	public String list(Model model, HttpServletRequest req) {
		String accept = req.getParameter("accept");
		if(accept == null) accept = "2";
		List<Ex1DTO> ex1s = homeDao.findList(accept);
		model.addAttribute("result", ex1s);
		return "list";
	}

	@Override
	public String detail(Model model, HttpServletRequest req) {
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			Ex1DTO ex1 = homeDao.findOne(no);
			model.addAttribute("result", ex1);
			return "detail";
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "redirect:/";
		}
	}

	@Override
	public String accept(HttpServletRequest req) {
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			boolean accept = (req.getParameter("accept").equals("0")) ? true : false;
			Ex1DTO ex1DTO = Ex1DTO.builder().no(no).accept(accept).build();
			int status = homeDao.accept(ex1DTO);
			if(status == 1) return "redirect:/detail?no=" + no;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@Override
	public String edit(HttpServletRequest req) {
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			Ex1DTO ex1DTO = Ex1DTO.builder().no(no).title(title).content(content).build();
			int status = homeDao.edit(ex1DTO);
			if(status == 1) return "redirect:/detail?no=" + no;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@Override
	public String input(HttpServletRequest req) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			Ex1DTO ex1DTO = Ex1DTO.builder().title(title).content(content).build();
			ex1DTO = homeDao.save(ex1DTO);
			if(ex1DTO == null) {
				return "redirect:/";
			} else {
				return "redirect:/detail?no=" + ex1DTO.getNo();
			}
	}

}
