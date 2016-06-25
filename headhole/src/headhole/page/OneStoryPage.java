package headhole.page;

import headhole.entity.Story;
import headhole.tool.IoScanner;

public class OneStoryPage extends Page{
	private Story story;
	public OneStoryPage(Story story)
	{
		this.story = story;
		InitPage();
		ActivePage();
	}
	private void InitPage()
	{
		IoScanner.ScannerOutputStory(story);
	}
	private void ActivePage()
	{
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
