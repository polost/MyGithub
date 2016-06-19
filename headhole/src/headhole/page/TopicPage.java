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
		System.out.println("\t 主题列表：\n");
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
			System.out.println("请输入想要进行的操作，输入back返回上一级");
			System.out.println("add：添加主题，mod 修改主题，del 删除主题，dsp：查看主题，back：退回上级");
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
				System.out.println("返回上一级");
				return;
			}
			else
			{
				System.out.println("输入有误，请重新输入");
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
			System.out.println("请输入想要删除的故事编号，输入0返回上一级");
			int topicId = IoScanner.ScannerInputIndex();
			if(topicId == 0)
			{
				System.out.println("返回上一级");
				return;
			}
			else if(topicId == -1)
			{
				System.out.println("输入有误，请重新输入");
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
			System.out.println("请输入想要查看的主题编号，输入0返回上一级");
			int topicId = IoScanner.ScannerInputIndex();
			if(topicId == 0)
			{
				System.out.println("返回上一级");
				return;
			}
			else if(topicId == -1)
			{
				System.out.println("输入有误，请重新输入");
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
