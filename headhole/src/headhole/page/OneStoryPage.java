package headhole.page;

import headhole.entity.Story;
import headhole.tool.IoScanner;

public class OneStoryPage extends Page{
	private Story story;
	public OneStoryPage()
	{
	}
	private void InitPage()
	{
		IoScanner.ScannerOutputStory(story);
	}
	public void ActivePage(Story story)
	{
		this.story = story;
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
