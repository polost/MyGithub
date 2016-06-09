package headhole.page;

import headhole.entity.Story;
import headhole.factory.DaoFactory;
import headhole.tool.IoScanner;

import java.util.Date;

public class StoryEditPage extends Page{
	public StoryEditPage()
	{
		InitPage();
	}
	
	private void InitPage()
	{
		System.out.println("***************************\n");
		System.out.println("\t 编辑故事\n");
		System.out.println("***************************");
	}
	
	public void ActivePage()
	{
		System.out.println("请输入故事名称");
		String StoryName = IoScanner.ScannerInputString();
		System.out.println("请输入故事简介");
		String StoryBrief = IoScanner.ScannerInputString();
		System.out.println("请输入故事内容");
		String StoryContext = IoScanner.ScannerInputString();
		java.util.Date utilDate=new Date();
		java.sql.Date StoryTime=new java.sql.Date(utilDate.getTime());
		
		Story story = new Story(StoryName,StoryTime,"zjs",StoryContext,StoryBrief);
		try {
			if(false == DaoFactory.getInstance().doCreate(story))
			{
				System.out.println("故事添加失败");
			}
			else
			{
				System.out.println("故事添加完成");
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
