package com.jt.search.pojo;

import org.apache.solr.client.solrj.beans.Field;

import com.jt.common.po.BasePojo;

//item对应的是solr中的数据
public class Item extends BasePojo{
	//solr有个jt core
	//每个数据有id field,title field
	//sellPoint field,price file
	//image field
	//对应的id Field
	@Field("id")
	private Long id;
	
	@Field("title")
	private String  title;
	
	@Field("sellPoint")
	private String sellPoint;
	
	@Field("price")
	private Long price;
	
    // jsp jstl foreach(list<item>)
	//item.title,item.images
	//solr配置文件中filed的名字是image
	//jsp是通过images取图片
	@Field("image") 
	private String images;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSellPoint() {
		return sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
//jsp显示图片时,有多张图
	//数据库image 存的是1.png,2.png,3.png
	public String[] getImages() {
		return images.split(",");
	}

	public void setImages(String images) {
		this.images = images;
	}
	
}





