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
		System.out.println("\t �����б�\n");
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
			System.out.println("��������Ҫ���еĲ���������back������һ��");
			System.out.println("add����ӹ��£�mod �޸Ĺ��£�del ɾ�����£�dsp���ۿ����£�back���˻��ϼ�");
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
			System.out.println("��������Ҫɾ���Ĺ��±�ţ�����0������һ��");
			int storyId = IoScanner.ScannerInputIndex();
			if(storyId == 0)
			{
				System.out.println("������һ��");
				return;
			}
			else if(storyId == -1)
			{
				System.out.println("������������������");
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
			System.out.println("��������Ҫ�鿴�Ĺ��±�ţ�����0������һ��");
			int storyId = IoScanner.ScannerInputIndex();
			if(storyId == 0)
			{
				System.out.println("������һ��");
				return;
			}
			else if(storyId == -1)
			{
				System.out.println("������������������");
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
