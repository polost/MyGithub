package headhole.page;

import headhole.tool.IoScanner;

public class FirstPage extends Page{
	public FirstPage()
	{
		InitPage();
	}
	
	private void InitPage()
	{
		System.out.println("***************************\n");
		System.out.println("\t 1.热门故事\n");
		System.out.println("\t 2.精华主题\n");
		System.out.println("\t 3.搜索\n");
		System.out.println("\t 4.我的脑洞\n");
		System.out.println("***************************");

		System.out.println("\n请输入选项,或者按0退出程序.");
	}
	
	
	public void ActivePage()
	{
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
						System.out.println("您已退出系统");
						System.exit(1);
						break;
					case 1:
						new StoryPage();
						break;
					case 2:
						new TopicPage();
						break;
					case 3:
						new SearchPage();
						break;
					case 4:
						new LoginPage();
						break;
					default:
						System.out.println("输入有误，请重新输入");
						continue;
				}
				InitPage();
			}
		}
		while(true);
	}
}
