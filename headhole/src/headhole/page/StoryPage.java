package headhole.page;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import headhole.entity.Story;
import headhole.factory.DaoFactory;
import headhole.tool.IoScanner;

public class StoryPage extends Page{
	public StoryPage()
	{
		InitPage();
	}
	private void printStoryList()
	{
		System.out.println("***************************\n");
		System.out.println("\t 故事列表：\n");
		System.out.println("***************************");

		List<Story> storys = null;
		try {
			storys = DaoFactory.getInstance().findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IoScanner.ScannerOutputStoryList(storys);

	}
	
	private void InitPage()
	{
		printStoryList();
	}
	
	public void ActivePage()
	{
		do
		{
			System.out.println("请输入想要进行的操作，输入back返回上一级");
			System.out.println("add：添加故事，mod 修改故事，del 删除故事，dsp：观看故事，back：退回上级");
			String operation = IoScanner.ScannerInputString();
			if(operation.equals("add"))
			{
				addStory();
				InitPage();
			}
			else if(operation.equals("mod"))
			{
				
			}
			else if(operation.equals("del"))
			{
				delStory();
				InitPage();
			}
			else if(operation.equals("dsp"))
			{
				dspStory();
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
	
	private void addStory()
	{
		PageFactory pageFactory = new PageFactory();
		Page page = null;
		page = pageFactory.CreatePage("storyeditpage");
		page.ActivePage();
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
					DaoFactory.getInstance().doDelete(storyId);
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
					story = DaoFactory.getInstance().findById(storyId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PageFactory pageFactory = new PageFactory();
				Page page = null;
				page = pageFactory.CreatePage("onestorypage");
				page.ActivePage(story);
				printStoryList();
			}
			
		}
		while(true);
	}
	
}
