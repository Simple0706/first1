package com.hnjd.news.dao;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.hnjd.news.entity.News;

public class NewsDaoImplTest {

	@Test
	public void testAddNews() throws Exception {
		NewsDao newsDao = new NewsDaoImpl();
		
		News news = new News();
		news.setNtid(2);
		news.setNcreateDate(new Date());
		news.setNauthor("中国新闻网");
		news.setNpicPath("");
		news.setNsummary("国际货币基金组织在即将发表的《世界经济展望》中写道，数据表明，疫情期间政府的封锁政策成功地降低了感染率。虽然这些政策同时加快了经济衰退，但这只是短期成本。感染率的降低，减少了人们由于担心感染而导致的自愿社会疏离，因此可能导致更快的经济复苏。");
		news.setNmodifyDate(new Date());
		news.setNcontent("目前，美国累计确诊已近760万例，死亡逾21.2万例。当地时间10月8日，据美国《纽约时报》统计，在过去一周中，美国每天平均新增逾4.5万例确诊病例，比两周前的平均水平增加了9%。美国疾控中心发布的整体预报称，到2020年10月31日，美国新冠死亡人数或将达到22.4万至23.3万人。\r\n" + 
				"\r\n" + 
				"　　另一方面，白宫医生康利8日称，美国总统特朗普已经完成了新冠肺炎的治疗疗程。他表示，特朗普回到白宫后，身体检查结果稳定，整体来说对新冠疗程的反应非常好，没有不良效果。他表示，医疗团队高度预期特朗普可以于10日“安全地重返公共活动”。\r\n" + 
				"\r\n" + 
				"　　此外，特朗普本人宣称，不相信自己具有传染性，并准备恢复竞选集会。他还表示，自己不能接受总统辩论以线下形式举行。8日晚些时候，特朗普的竞选经理比尔·斯蒂芬发表新声明，宣布他们同意拜登竞选团队的建议，将第二次辩论推迟一周，以便可以亲自参加辩论。");
		news.setNtitle("特朗普已完成新冠治疗疗程 全球多国加强防疫管控");
		newsDao.addNews(news);
	}
	
	@Test
	public void testDeleteNews() throws SQLException {
		NewsDao newsDao = new NewsDaoImpl();
		newsDao.deleteNews(194);
	}

}
