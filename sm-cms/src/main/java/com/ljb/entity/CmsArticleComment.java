package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 文章评论实体
 * 表名 cms_article_comment
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 13:08:46
 */
@TableName("cms_article_comment")
public class CmsArticleComment extends Model<CmsArticleComment> implements Serializable {
    private static final long serialVersionUID = 1L;

    //评论ID
    @TableId(type=IdType.AUTO)
    private Integer id;
	//用户ID
	private Integer userId;
	//父评论ID
	private Integer parentId;
	//内容
	private String content;
	//Ip
	private String ip;
	//状态
	private Integer status;
	//创建时间
	private Date createtime;

    /**
     * 设置：评论ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：评论ID
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取：用户ID
     */
    public Integer getUserId() {
        return userId;
    }
    /**
     * 设置：父评论ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：父评论ID
     */
    public Integer getParentId() {
        return parentId;
    }
    /**
     * 设置：内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：内容
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：Ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取：Ip
     */
    public String getIp() {
        return ip;
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
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
