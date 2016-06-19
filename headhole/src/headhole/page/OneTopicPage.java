package headhole.page;

import java.util.ArrayList;
import java.util.List;

import headhole.dao.GenericDao;
import headhole.entity.Story;
import headhole.entity.Topic;
import headhole.tool.IoScanner;

public class OneTopicPage extends Page{
	private Topic topic;
	public OneTopicPage()
	{
	}
	private void InitPage()
	{
		System.out.println("-----------主题编号"+topic.getTopicId()+"-----------");
		System.out.println("主题名："+topic.getTopicName());
		System.out.println("日期："+topic.getTopicTime());
		System.out.println("作者："+topic.getTopicEditor());
		System.out.println(topic.getTopicBrief());
		System.out.println("-------------------------");
		List<Story> storys = new ArrayList<Story>();
		try {
			storys = (List<Story>)(new GenericDao(Story.class)).findByPara(topic.getTopicId(),"TopicId");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageFactory pageFactory = new PageFactory();
		Page page = pageFactory.CreatePage("storypage");
		page.ActivePage();
		//IoScanner.ScannerOutputStoryList(storys);
	}
	public void ActivePage(Topic topic)
	{
		this.topic = topic;
		InitPage();
		System.out.println("输入0返回上一级");
		do
		{
			String InputChoice = IoScanner.ScannerInputString();
			String regex = "[0-4]";
			if(InputChoice.matches(regex))
			{
				int Choice = Integer.parseInt(InputChoice);
				switch(Choice)
				{
					case 0:
						System.out.println("您已返回上级");
						return;
					default:
						System.out.println("输入有误，请重新输入");
				}
			}
			
		}
		while(true);
	}
}
