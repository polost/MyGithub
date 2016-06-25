package headhole.page;

import java.util.List;

import headhole.dao.GenericDao;
import headhole.entity.Story;
import headhole.entity.User;
import headhole.tool.IoScanner;

public class LoginPage extends Page{
	private User user = null;
	public LoginPage()
	{
		InitPage();
	}
	private void InitPage()
	{
		do
		{
			System.out.println("***************************\n");
			System.out.println("\t 请输入用户名：\n");
			String InputUser = IoScanner.ScannerInputString();
			System.out.println("\t 请输入密码：\n");
			String InputPass = IoScanner.ScannerInputString();
			List<User> users = null;
			try {
				users = (List<User>) (new GenericDao(User.class)).findByPara(InputUser,"username");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(1 == users.size() && users.get(0).getUserPass().equals(InputPass))
			{
				this.user = users.get(0);
				System.out.println("\t 登录成功\n");
				break;
			}
			else
			{
				System.out.println("\t 错误的用户名或密码，请重新输入\n");
			}
		}
		while(true);

		
		do
		{
			System.out.println("***************************\n");
			System.out.println("\t 1.我的故事\n");
			//System.out.println("\t 2.我的主题\n");
			System.out.println("\t 3.热门故事\n");
			System.out.println("\t 4.热门主题\n");
			System.out.println("***************************");
			
			System.out.println("\n请输入选项,或者按0退出程序.");
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
						List<Story> storys = null;
						try {
							storys = (List<Story>) (new GenericDao(Story.class)).findByPara(user.getUserName(),"storyeditor");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						new StoryPage(storys);
						break;
					case 2:
						new TopicPage();
						break;
					case 3:
						new StoryPage();
						break;
					case 4:
						new TopicPage();
						break;
					default:
						System.out.println("输入有误，请重新输入");
						continue;
				}
			}
		}
		while(true);
	}
}
