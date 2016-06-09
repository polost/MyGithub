package headhole.page;

import headhole.tool.IoScanner;

public class SearchPage extends Page{
	public SearchPage()
	{
		InitPage();
	}
	private void InitPage()
	{
		System.out.println("***************************\n");
		System.out.println("\t 请输入搜索内容：\n");
		System.out.println("***************************");
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
						System.out.println("返回上一级");
						return;
					default:
						System.out.println("输入有误，请重新输入");
				}
			}
			
		}
		while(true);
	}
}
