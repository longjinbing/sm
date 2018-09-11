package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.UploadFileDao;
import com.ljb.entity.UploadFile;
import com.ljb.service.UploadFileService;
import com.ljb.query.UploadFileQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;

/**
 * 上传文件Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-05 14:28:35
 */
@Service
public class UploadFileServiceImpl extends ServiceImpl<UploadFileDao,UploadFile> implements UploadFileService {
    @Autowired
    private UploadFileDao uploadFileDao;
    
    @Override
    public UploadFile queryObject(Integer id) {
        return uploadFileDao.selectById(id);
    }

    @Override
    public Page<UploadFile> queryList(Map<String, Object> map) {
        MapPageUtil<UploadFile> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<UploadFile> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<UploadFile> queryAll(Map<String, Object> map){
    	MapPageUtil<UploadFile> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<UploadFile> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<UploadFile> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<UploadFile> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(UploadFile entity) {
    	UploadFile uploadFile=new UploadFile();
    	BeanUtils.copyProperties(entity, uploadFile);
		return uploadFileDao.insert(uploadFile);
	}

    @Override
    public int update(UploadFile entity) {
    	UploadFile uploadFile=new UploadFile();
    	BeanUtils.copyProperties(entity, uploadFile);
        return uploadFileDao.updateById(uploadFile);
    }

    @Override
    public int delete(Integer id) {
    	return uploadFileDao.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return uploadFileDao.deleteBatchIds(Arrays.asList(ids));
    }
    
    @Override
    public int countByQuery(){
    	UploadFileQuery query=new UploadFileQuery();
        return uploadFileDao.countByQuery(query);
    }

	@Override
    public List<UploadFile> selectByQuery(){
    	UploadFileQuery query=new UploadFileQuery();
        return uploadFileDao.selectByQuery(query);
    }
	
	@Override
    public UploadFile selectOne(){
    	UploadFileQuery query=new UploadFileQuery();
        return uploadFileDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	UploadFileQuery query=new UploadFileQuery();
        return uploadFileDao.deleteByQuery(query);
    }
}
