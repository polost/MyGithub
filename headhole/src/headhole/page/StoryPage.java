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
	}
	
	public StoryPage(List<Story> storys)
	{
		this.storys = storys;
		printStoryList();
	}
	
	private void printStoryList()
	{
		System.out.println("***************************\n");
		System.out.println("\t �����б�\n");
		System.out.println("***************************");

		IoScanner.ScannerOutputStoryList(storys);

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
					//story = (Story)(new GenericDao(Story.class)).findByPara(storyId,"StoryId");
					story = (Story)(new GenericDao(Story.class)).findById(storyId);
					//story = DaoFactory.getInstance().findById(storyId);
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
