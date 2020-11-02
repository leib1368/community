package life.majiang.community;

import life.majiang.community.mapper.QuestionExtMapper;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.QuestionExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {

	@Autowired
	QuestionExtMapper questionExtMapper;

	@Autowired
	QuestionMapper questionMapper;

	@Test
	@Rollback()
	@Transactional(propagation= Propagation.REQUIRED )
	public void update1() {
		//通过主键查询问题
		Question record = questionMapper.selectByPrimaryKey((long) 3);
		//设置浏览数为11
		record.setViewCount(111);
		//执行更新
		questionMapper.updateByPrimaryKey(record);
		update2();
	}

	@Test
	//@Rollback()
	@Transactional(propagation= Propagation.REQUIRED )
	public void update2() {
		//通过主键查询问题
		Question record = questionMapper.selectByPrimaryKey((long) 3);
		//设置浏览数为11
		record.setViewCount(222);
		//执行更新
		questionMapper.updateByPrimaryKey(record);
	}

}
