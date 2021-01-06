package com.yuntu.demo.util;

import java.util.List;

public class PageUtil<T> {

    private int pageindex=1;//当前页码
    private int pagesize=10;//页大小
    private int counts=0;//总记录数，总条数
    private int pagecount=0;//总页数
    private List<T> list;//每页对象的集合

    public int getPageindex() {
        return pageindex;
    }
    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }
    public int getPagesize() {
        return pagesize;
    }
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
    public int getCounts() {
        return counts;
    }
    public void setCounts(int counts) {
        this.counts = counts;
        if (counts>0) {//确保有数据
            if (counts%pagesize==0) {//判断是否整除
                pagecount= counts/pagesize;//总页数=总数/页大小=1
            }else {
                pagecount= (counts/pagesize)+1;//总页数=总数/页大小+1
            }
        }
    }
    public int getPagecount() {
        return pagecount;
    }
    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "pageindex=" + pageindex +
                ", pagesize=" + pagesize +
                ", counts=" + counts +
                ", pagecount=" + pagecount +
                ", list=" + list +
                '}';
    }

    //get、set
	/*public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getNewsCount() {
		return newsCount;
	}
	public void setNewsCount(int newsCount) {
		this.newsCount = newsCount;//3
		if(newsCount>0){
			if(newsCount%pagesize==0){
				pageCount=newsCount/pagesize;//4
			}else{
				pageCount=newsCount/pagesize+1;//4
			}
		}
	}
	public List<News> getList() {
		return list;
	}
	public void setList(List<News> list) {
		this.list = list;
	}
	*/
}
