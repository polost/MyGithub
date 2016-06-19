package headhole.page;

import java.util.List;

import headhole.dao.GenericDao;
import headhole.entity.Topic;
import headhole.tool.IoScanner;

public class TopicPage extends Page {
	public TopicPage()
	{
		InitPage();
	}
	
	private void printTopicList()
	{
		System.out.println("***************************\n");
		System.out.println("\t �����б�\n");
		System.out.println("***************************");
		
		List<Topic> topics = null;
		try {
			topics = (List<Topic>) (new GenericDao(Topic.class)).findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IoScanner.ScannerOutputTopicList(topics);
	}

	private void InitPage()
	{
		printTopicList();
	}
	
	public void ActivePage()
	{
		do
		{
			System.out.println("��������Ҫ���еĲ���������back������һ��");
			System.out.println("add��������⣬mod �޸����⣬del ɾ�����⣬dsp���鿴���⣬back���˻��ϼ�");
			String operation = IoScanner.ScannerInputString();
			if(operation.equals("add"))
			{
				addTopic();
				InitPage();
			}
			else if(operation.equals("mod"))
			{
				
			}
			else if(operation.equals("del"))
			{
				delTopic();
				InitPage();
			}
			else if(operation.equals("dsp"))
			{
				dspTopic();
				InitPage();
			}
			else if(operation.equals("back"))
			{
				System.out.println("������һ��");
				return;
			}
			else
			{
				System.out.println("������������������");
			}
		}
		while(true);
	}
	
	private void addTopic()
	{
		PageFactory pageFactory = new PageFactory();
		Page page = null;
		page = pageFactory.CreatePage("storyeditpage");
		page.ActivePage();
	}
	
	private void delTopic()
	{
		do
		{
			System.out.println("��������Ҫɾ���Ĺ��±�ţ�����0������һ��");
			int topicId = IoScanner.ScannerInputIndex();
			if(topicId == 0)
			{
				System.out.println("������һ��");
				return;
			}
			else if(topicId == -1)
			{
				System.out.println("������������������");
			}
			else if(topicId > 0)
			{
				try {
					(new GenericDao(Topic.class)).doDelete(topicId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				printTopicList();
			}
			
		}
		while(true);
	}
	
	private void dspTopic()
	{
		do
		{
			System.out.println("��������Ҫ�鿴�������ţ�����0������һ��");
			int topicId = IoScanner.ScannerInputIndex();
			if(topicId == 0)
			{
				System.out.println("������һ��");
				return;
			}
			else if(topicId == -1)
			{
				System.out.println("������������������");
			}
			else if(topicId > 0)
			{
				Topic topic = null;
				try {
					//topic = (Topic)(new GenericDao(Topic.class)).findByPara(topicId,"TopicId");
					topic = (Topic)(new GenericDao(Topic.class)).findById(topicId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PageFactory pageFactory = new PageFactory();
				Page page = null;
				page = pageFactory.CreatePage("onetopicpage");
				page.ActivePage(topic);
				printTopicList();
			}
			
		}
		while(true);
	}
}
