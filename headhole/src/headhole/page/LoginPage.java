package headhole.page;

import headhole.tool.IoScanner;

public class LoginPage extends Page{
	public LoginPage()
	{
		InitPage();
	}
	private void InitPage()
	{
		System.out.println("***************************\n");
		System.out.println("\t �������û�����\n");
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
						System.out.println("������һ��");
						return;
					default:
						System.out.println("������������������");
				}
			}
			
		}
		while(true);
	}
}
