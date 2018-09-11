package com.ljb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ljb.mapper.TokenDao;
import com.ljb.entity.Token;
import com.ljb.service.TokenService;
import com.ljb.query.TokenQuery;
import com.ljb.utils.BeanUtils;
import com.ljb.utils.MapPageUtil;

/**
 * 用户TokenService实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-01 18:05:56
 */
@Service
public class TokenServiceImpl extends ServiceImpl<TokenDao,Token> implements TokenService {
    @Autowired
    private TokenDao tokenDao;
    
    @Override
    public Token queryObject(Integer userId) {
        return tokenDao.selectById(userId);
    }

    @Override
    public Page<Token> queryList(Map<String, Object> map) {
        MapPageUtil<Token> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<Token> wrapper=mapPage.condition();
        return selectPage(mapPage.page(), wrapper);
    }
    
     @Override
    public List<Token> queryAll(Map<String, Object> map){
    	MapPageUtil<Token> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<Token> wrapper=mapPage.condition();
    	return selectList(wrapper);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        MapPageUtil<Token> mapPage=new MapPageUtil<>(map);
    	EntityWrapper<Token> wrapper=mapPage.condition();
        return selectCount(wrapper);
    }
    
    @Override
	public int save(Token entity) {
    	Token token=new Token();
    	BeanUtils.copyProperties(entity, token);
		return tokenDao.insert(token);
	}

    @Override
    public int update(Token entity) {
    	Token token=new Token();
    	BeanUtils.copyProperties(entity, token);
        return tokenDao.updateById(token);
    }

    @Override
    public int delete(Integer userId) {
    	return tokenDao.deleteById(userId);
    }

    @Override
    public int deleteBatch(Integer[] userIds) {
        return tokenDao.deleteBatchIds(Arrays.asList(userIds));
    }
    
    @Override
    public int countByQuery(){
    	TokenQuery query=new TokenQuery();
        return tokenDao.countByQuery(query);
    }

	@Override
    public List<Token> selectByQuery(){
    	TokenQuery query=new TokenQuery();
        return tokenDao.selectByQuery(query);
    }
	
	@Override
    public Token selectOne(){
    	TokenQuery query=new TokenQuery();
        return tokenDao.selectOne(query);
    }
	@Override
    public int deleteByQuery(){
    	TokenQuery query=new TokenQuery();
        return tokenDao.deleteByQuery(query);
    }
}
