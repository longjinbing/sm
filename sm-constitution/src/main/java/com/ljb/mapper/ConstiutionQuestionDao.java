package com.ljb.mapper;

import com.ljb.entity.ConstiutionQuestion;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ljb.query.ConstiutionQuestionQuery;
import com.ljb.utils.BaseDao;
import java.util.List;

/**
 * 体质测试问题Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-08-08 16:58:16
 */
public interface ConstiutionQuestionDao extends BaseMapper<ConstiutionQuestion>,BaseDao<ConstiutionQuestion> {

    int countByQuery(ConstiutionQuestionQuery query);

	List<ConstiutionQuestion> selectByQuery(ConstiutionQuestionQuery query);
	
	ConstiutionQuestion selectOne(ConstiutionQuestionQuery query);
	
	int deleteByQuery(ConstiutionQuestionQuery query);

}
