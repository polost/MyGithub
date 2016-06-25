package headhole.page;

import headhole.dao.GenericDao;
import headhole.entity.Story;
import headhole.tool.IoScanner;

import java.util.Date;

public class StoryEditPage extends Page{
	private int TopicId = 0;
	public StoryEditPage(int TopicId)
	{
		this.TopicId = TopicId;
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
		System.out.println("�������������");
		String StoryName = IoScanner.ScannerInputString();
		System.out.println("��������¼��");
		String StoryBrief = IoScanner.ScannerInputString();
		System.out.println("�������������");
		String StoryContext = IoScanner.ScannerInputString();
		java.util.Date utilDate=new Date();
		java.sql.Date StoryTime=new java.sql.Date(utilDate.getTime());
		
		Story story = new Story(StoryName,StoryTime,"zjs",StoryContext,StoryBrief,this.TopicId);
		try {
			if(false == (new GenericDao(Story.class)).doCreate(story))
			{
				System.out.println("��������ʧ��");
			}
			else
			{
				System.out.println("�����������");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ActivePage(Story story)
	{
	}
}
