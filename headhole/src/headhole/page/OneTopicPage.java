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
		System.out.println("-----------������"+topic.getTopicId()+"-----------");
		System.out.println("��������"+topic.getTopicName());
		System.out.println("���ڣ�"+topic.getTopicTime());
		System.out.println("���ߣ�"+topic.getTopicEditor());
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
		System.out.println("����0������һ��");
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
						System.out.println("���ѷ����ϼ�");
						return;
					default:
						System.out.println("������������������");
				}
			}
			
		}
		while(true);
	}
}
