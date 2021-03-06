package com.mysql.to.elastic.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 物理分页工具包
 * @author: cactusli
 * @date: 2022.03.30
 */
@Data
@NoArgsConstructor
public class PhysicsPageUtils<T> {

    private Long totalCount;//总数
    private int pageSize=10;//每页显示数量
    private int currpageNum;//当前页
    private int pageCount;//总页数
    private int prePage;//上一页
    private int nextPage;//下一页
    private boolean hasPrePage;//是否有上一页
    private boolean hasNextPage;//是否有下一页
    private int firstPage;//第一页
    private int lastPage;//最后一页
    private int currentcount;//当前从第多少条数据开始显示
    private List<T> list ;


    public PhysicsPageUtils(Long totalCount,int pageNum){
        this.totalCount =totalCount;
        this.currpageNum=pageNum;
        this.pageCount = (int) Math.ceil(1.0*totalCount/pageSize);
        this.currentcount =(pageCount-1)*pageSize;
        if(pageNum>1){  //判断是不是第一页
            /*--不是第一页 则有上一页 ，也有第一页--*/
            hasPrePage=true;
            prePage = pageNum-1;
            firstPage =1;
        }
        if(pageNum<pageCount){//判断是不是最后一页
            /*--不是最后一页 则有上一页 ，也有最后一页--*/
            hasNextPage=true;
            nextPage=pageNum+1;
            lastPage=pageCount;
        }
    }
    public void setTotalCount(Long totalCount) {
        this.pageCount = (int) Math.ceil(1.0*totalCount/pageSize);
        if(this.currpageNum < 1)
        {
            this.currpageNum = 1 ;
        }
        this.currentcount =(currpageNum-1)*pageSize;
        if(currpageNum>1){  //判断是不是第一页
            /*--不是第一页 则有上一页 ，也有第一页--*/
            hasPrePage=true;
            prePage = currpageNum-1;
            firstPage =1;
        }
        if(currpageNum<pageCount){//判断是不是最后一页
            /*--不是最后一页 则有上一页 ，也有最后一页--*/
            hasNextPage=true;
            nextPage=currpageNum+1;
            lastPage=pageCount;
        }
        this.totalCount = totalCount;
    }
}
