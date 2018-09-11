package com.ljb.mapper;

import com.ljb.entity.UploadFile;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.UploadFileQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 上传文件Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 14:28:35
 */
public interface UploadFileDao extends BaseMapper<UploadFile>,BaseDao<UploadFile> {

    int countByQuery(UploadFileQuery query);

	List<UploadFile> selectByQuery(UploadFileQuery query);
	
	UploadFile selectOne(UploadFileQuery query);
	
	int deleteByQuery(UploadFileQuery query);

}
