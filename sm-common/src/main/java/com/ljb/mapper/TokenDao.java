package com.ljb.mapper;

import com.ljb.entity.Token;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.TokenQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 用户TokenDao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-07-26 06:45:21
 */
public interface TokenDao extends BaseMapper<Token>,BaseDao<Token> {

    int countByQuery(TokenQuery query);

	List<Token> selectByQuery(TokenQuery query);
	
	Token selectOne(TokenQuery query);
	
	int deleteByQuery(TokenQuery query);

}
