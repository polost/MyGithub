package headhole.factory;

import headhole.dao.StoryDao;
import headhole.daoproxy.StoryDaoProxy;

public class DaoFactory {
	public static StoryDao getInstance()
	{
		StoryDao storyDao = null;
		try{
			storyDao = new StoryDaoProxy();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return storyDao;
	}
}
