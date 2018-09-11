package com.ljb.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 上传文件实体
 * 表名 upload_file
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 14:28:35
 */
@TableName("upload_file")
public class UploadFile extends Model<UploadFile> implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId(type=IdType.AUTO)
    private Integer id;
	//路径
	private String url;
	//大小
	private Integer size;
	//类型
	private String type;
	//格式
	private String ext;
	//上传时间
	private Date createTime;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：路径
     */
    public String getUrl() {
        return url;
    }
    /**
     * 设置：大小
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * 获取：大小
     */
    public Integer getSize() {
        return size;
    }
    /**
     * 设置：类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：类型
     */
    public String getType() {
        return type;
    }
    /**
     * 设置：格式
     */
    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * 获取：格式
     */
    public String getExt() {
        return ext;
    }
    /**
     * 设置：上传时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：上传时间
     */
    public Date getCreateTime() {
        return createTime;
    }
	@Override
	protected Serializable pkVal() {
	// TODO 自动生成的方法存根
	return this.id;
    }
}
