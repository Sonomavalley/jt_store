package com.jt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.search.pojo.Item;
import com.jt.search.service.SearchService;

@Controller
public class SearchController {
	//微服务的消费者，得到动态代理对象，由dubbo创建
	//连网把接口名，方法名，参数传给微服务提供者
	@Autowired
	SearchService searchService;
//search.html?1=电脑
	@RequestMapping("search")
	public String search
	(String q,Model model)throws Exception
	{
		//请求由地址栏发出来的，是get,web.xml中配置filter不生效
		//浏览器发get请求，字符集是iso-8859-1
		byte[] data=q.getBytes("ISO-8859-1");
		//微服务消费者发字符给提供者，用的编码是utf-8
		String key=new String(data,"UTF-8");
		List<Item> itemList=searchService
				.search(key);
		//把数据放到request中
		model.addAttribute("itemList",itemList);
		//转发/web-inf/views/search.jsp
		return "search";
	}
}
