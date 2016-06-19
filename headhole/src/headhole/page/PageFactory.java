package headhole.page;

public class PageFactory {
	
	public Page CreatePage(String PageName)
	{
		Page page = null;
		if(PageName.equals("firstpage"))
		{
			page = new FirstPage();
		}
		else if(PageName.equals("storypage"))
		{
			page = new StoryPage();
		}
		else if(PageName.equals("topicpage"))
		{
			page = new TopicPage();
		}
		else if(PageName.equals("searchpage"))
		{
			page = new SearchPage();
		}
		else if(PageName.equals("loginpage"))
		{
			page = new LoginPage();
		}
		else if(PageName.equals("onestorypage"))
		{
			page = new OneStoryPage();
		}
		else if(PageName.equals("storyeditpage"))
		{
			page = new StoryEditPage();
		}
		else if(PageName.equals("onetopicpage"))
		{
			page = new OneTopicPage();
		}
		else if(PageName.equals("topiceditpage"))
		{
			page = new OneStoryPage();
		}
		return page;
	}
}
