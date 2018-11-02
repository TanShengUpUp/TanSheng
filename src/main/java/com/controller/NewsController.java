package com.controller;


import java.io.PrintWriter;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.News;
import com.github.pagehelper.PageInfo;
import com.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	@Resource
	private NewsService newsService;
	
	public NewsController() {
		System.out.println("YES OK");
	}
	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
//
//		// Date 类型转换
//		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
//			@Override
//			public void setAsText(String text) {
//				setValue(DateUtils.parseDate(text));
//			}
//
//		});
//	}
	
	
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String list(HttpServletRequest request,HttpServletResponse response,HttpSession session,PrintWriter out,ModelMap map) {
		
		List<News> findAll=newsService.findAll();
		map.addAttribute("list",findAll);
		
		System.out.println("list");
		
		return "news/news-list";
	}
	
	
	@RequestMapping(value="/delete/{id}/{ccc}",method=RequestMethod.GET)
	public String delete(@PathVariable(value="id") Integer ids,@PathVariable(value="ccc") Integer ggg) {
		
		System.out.println("NewsController delete===>"+ids);
		System.out.println("NewsController delete===>"+ggg);
		
		System.out.println("delete");
		
		return "redirect:/news";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(News news,@RequestParam("image") MultipartFile part) {
		String filename=part.getOriginalFilename();//get image name
		long size=part.getSize();//long 
		String name=part.getName();//get input name
		String contentType=part.getContentType();//get file type
		
		System.out.println("filename="+filename);
		System.out.println("size="+size);
		System.out.println("name="+name);
		System.out.println("content="+contentType);
		System.out.println("save");
		return "redirect:/news";
	}
	
	@RequestMapping("/add")
	public String add() {

		System.out.println("NewsController add");

		// /WEB-INF/manage/news/news-add.jsp
		return "news/news-add";
	}
	
	
	
	
	
	@RequestMapping(value="/ajax")
	public String ajax(ModelMap map,HttpServletResponse response) {
		String result="aaa哈哈哈";
		
		
		return result;
	}
	
	
	
	
	
	
}
