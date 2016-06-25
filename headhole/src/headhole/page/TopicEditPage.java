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
		System.out.println("\t �༭����\n");
		System.out.println("***************************");
	}
	
	public void ActivePage()
	{
		System.out.println("��������������");
		String TopicName = IoScanner.ScannerInputString();
		System.out.println("������������");
		String TopicBrief = IoScanner.ScannerInputString();
		java.util.Date utilDate=new Date();
		java.sql.Date TopicTime=new java.sql.Date(utilDate.getTime());
		
		Topic topic = new Topic(TopicName,TopicTime,"zjs",TopicBrief);
		try {
			if(false == (new GenericDao(Topic.class)).doCreate(topic))
			{
				System.out.println("�������ʧ��");
			}
			else
			{
				System.out.println("����������");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
