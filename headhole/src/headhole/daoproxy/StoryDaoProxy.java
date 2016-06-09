package headhole.daoproxy;

import java.util.List;

import headhole.dao.StoryDao;
import headhole.daoimpl.StoryDaoImpl;
import headhole.db.DatabaseConnection;
import headhole.entity.Story;

public class StoryDaoProxy implements StoryDao{
	private DatabaseConnection dbConnection;
	private StoryDao storyDao = null;
	
	public StoryDaoProxy() throws Exception
	{
		dbConnection = new DatabaseConnection();
		storyDao = new StoryDaoImpl(dbConnection.getConnection());
	}
	
	public boolean doCreate(Story story)throws Exception{  
		boolean flag = false;
		if(storyDao.findById(story.getStoryId()) == null)
		{
			flag = storyDao.doCreate(story);
		}
		dbConnection.close();
    	return flag;
    }  
    
    public boolean doUpdate(Story story)throws Exception{  
    	return true;
    }
    
    public boolean doDelete(int StoryId)throws Exception{ 
    	boolean flag = false;
		if(storyDao.findById(StoryId) != null)
		{
			flag = storyDao.doDelete(StoryId);
		}
		dbConnection.close();
    	return flag;
    }
    
    public List<Story> findAll()throws Exception{  
    	List<Story> storys = storyDao.findAll();
		dbConnection.close();
    	return storys;
    }
    
    public Story findById(int StoryId)throws Exception{ 
    	Story story = storyDao.findById(StoryId); 
		dbConnection.close();
    	return story;
    }
}
