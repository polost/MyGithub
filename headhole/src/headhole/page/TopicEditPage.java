package headhole.page;

import headhole.dao.GenericDao;
import headhole.entity.Topic;
import headhole.tool.IoScanner;

import java.util.Date;

public class TopicEditPage extends Page {
	public TopicEditPage()
	{
		InitPage();
	}
	
	private void InitPage()
	{
		System.out.println("***************************\n");
		System.out.println("\t 编辑主题\n");
		System.out.println("***************************");
	}
	
	public void ActivePage()
	{
		System.out.println("请输入主题名称");
		String TopicName = IoScanner.ScannerInputString();
		System.out.println("请输入主题简介");
		String TopicBrief = IoScanner.ScannerInputString();
		java.util.Date utilDate=new Date();
		java.sql.Date TopicTime=new java.sql.Date(utilDate.getTime());
		
		Topic topic = new Topic(TopicName,TopicTime,"zjs",TopicBrief);
		try {
			if(false == (new GenericDao(Topic.class)).doCreate(topic))
			{
				System.out.println("故事添加失败");
			}
			else
			{
				System.out.println("故事添加完成");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
