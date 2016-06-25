package headhole.page;

import java.util.List;

import headhole.dao.GenericDao;
import headhole.entity.Story;
import headhole.tool.IoScanner;

public class StoryPage extends Page{
	private List<Story> storys = null;
	
	public StoryPage()
	{
		try {
			storys = (List<Story>) (new GenericDao(Story.class)).findAll();
			//storys = DaoFactory.getInstance().findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printStoryList();
		ActivePage();
	}
	
	public StoryPage(List<Story> storys)
	{
		this.storys = storys;
		printStoryList();
		ActivePage();
	}
	
	private void printStoryList()
	{
		System.out.println("***************************\n");
		System.out.println("\t 故事列表：\n");
		System.out.println("***************************");

		IoScanner.ScannerOutputStoryList(storys);

	}
	
	private void ActivePage()
	{
		do
		{
			System.out.println("请输入想要进行的操作，输入back返回上一级");
			System.out.println("add：添加故事，mod 修改故事，del 删除故事，dsp：观看故事，back：退回上级");
			String operation = IoScanner.ScannerInputString();
			if(operation.equals("add"))
			{
				addStory();
				printStoryList();
			}
			else if(operation.equals("mod"))
			{
				
			}
			else if(operation.equals("del"))
			{
				delStory();
				printStoryList();
			}
			else if(operation.equals("dsp"))
			{
				dspStory();
				printStoryList();
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
	
	private void addStory()
	{
		do
		{
			System.out.println("请输入想要添加故事的主题编号，输入0返回上一级");
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
				StoryEditPage storyEditPage = new StoryEditPage(topicId);
				storyEditPage.ActivePage();
			}
		}
		while(true);
	}
	
	private void delStory()
	{
		do
		{
			System.out.println("请输入想要删除的故事编号，输入0返回上一级");
			int storyId = IoScanner.ScannerInputIndex();
			if(storyId == 0)
			{
				System.out.println("返回上一级");
				return;
			}
			else if(storyId == -1)
			{
				System.out.println("输入有误，请重新输入");
			}
			else if(storyId > 0)
			{
				try {
					(new GenericDao(Story.class)).doDelete(storyId);
					//DaoFactory.getInstance().doDelete(storyId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				printStoryList();
			}
			
		}
		while(true);
	}
	
	private void dspStory()
	{
		do
		{
			System.out.println("请输入想要查看的故事编号，输入0返回上一级");
			int storyId = IoScanner.ScannerInputIndex();
			if(storyId == 0)
			{
				System.out.println("返回上一级");
				return;
			}
			else if(storyId == -1)
			{
				System.out.println("输入有误，请重新输入");
			}
			else if(storyId > 0)
			{
				Story story = null;
				try {
					//story = (Story)(new GenericDao(Story.class)).findByPara(storyId,"StoryId");
					story = (Story)(new GenericDao(Story.class)).findById(storyId);
					//story = DaoFactory.getInstance().findById(storyId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				new OneStoryPage(story);
				printStoryList();
			}
			
		}
		while(true);
	}
	
}
