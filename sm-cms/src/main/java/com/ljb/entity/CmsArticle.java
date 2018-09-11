package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 文章管理实体
 * 表名 cms_article
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 14:38:45
 */
@TableName("cms_article")
public class CmsArticle extends Model<CmsArticle> implements Serializable {
    private static final long serialVersionUID = 1L;

    //文件ID
    @TableId(type=IdType.AUTO)
    private Integer id;
	//文章标题
	private String title;
	//图片url
	private String url;
	//文件内容
	private String content;
	//浏览数
	private Integer viewcount;
	//评论数
	private Integer commentcount;
	//排序
	private Integer orderNum;
	//状态
	private Integer status;
	//创建时间
	private Date createTime;
	//创建者
	private Integer createId;
	//更新时间
	private Date updateTime;
	//类别Id
	private Integer catogryId;

    /**
     * 设置：文件ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：文件ID
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：文章标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：文章标题
     */
    public String getTitle() {
        return title;
    }
    /**
     * 设置：图片url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：图片url
     */
    public String getUrl() {
        return url;
    }
    /**
     * 设置：文件内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：文件内容
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：浏览数
     */
    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    /**
     * 获取：浏览数
     */
    public Integer getViewcount() {
        return viewcount;
    }
    /**
     * 设置：评论数
     */
    public void setCommentcount(Integer commentcount) {
        this.commentcount = commentcount;
    }

    /**
     * 获取：评论数
     */
    public Integer getCommentcount() {
        return commentcount;
    }
    /**
     * 设置：排序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取：排序
     */
    public Integer getOrderNum() {
        return orderNum;
    }
    /**
     * 设置：状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：创建者
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 获取：创建者
     */
    public Integer getCreateId() {
        return createId;
    }
    /**
     * 设置：更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
     * 设置：类别Id
     */
    public void setCatogryId(Integer catogryId) {
        this.catogryId = catogryId;
    }

    /**
     * 获取：类别Id
     */
    public Integer getCatogryId() {
        return catogryId;
    }
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
