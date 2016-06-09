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
		System.out.println("\t 1.���Ź���\n");
		System.out.println("\t 2.��������\n");
		System.out.println("\t 3.����\n");
		System.out.println("\t 4.�ҵ��Զ�\n");
		System.out.println("***************************");

		System.out.println("\n������ѡ��,���߰�0�˳�����.");
	}
	
	
	public void ActivePage()
	{
		PageFactory pageFactory = new PageFactory();
		Page page = null;
		
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
						System.out.println("�����˳�ϵͳ");
						System.exit(1);
						break;
					case 1:
						page = pageFactory.CreatePage("storypage");
						break;
					case 2:
						page = pageFactory.CreatePage("topicpage");
						break;
					case 3:
						page = pageFactory.CreatePage("searchpage");
						break;
					case 4:
						page = pageFactory.CreatePage("loginpage");
						break;
					default:
						System.out.println("������������������");
						continue;
				}
				page.ActivePage();
				InitPage();
			}
		}
		while(true);
	}
}
