package headhole.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import headhole.dao.StoryDao;
import headhole.entity.Story;

public class StoryDaoImpl implements StoryDao{
	private Connection con;  
    private PreparedStatement stat = null;  
    public StoryDaoImpl(Connection con){  
        this.con = con;  
    }
    
    public boolean doCreate(Story story)throws Exception{  
    	String sql = "INSERT INTO STORY(StoryName,StoryTime,StoryEditor,StoryContext,StoryBrief) VALUES(?,?,?,?,?)";
    	stat = con.prepareStatement(sql);
    	stat.setString(1, story.getStoryName());
    	stat.setDate(2, new java.sql.Date(story.getStoryTime().getTime()));
    	stat.setString(3, story.getStoryEditor());
    	stat.setString(4, story.getStoryContext());
    	stat.setString(5, story.getStoryBrief());
    	int rs = stat.executeUpdate();
    	if(rs > 0)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }  
    
    public boolean doUpdate(Story story)throws Exception{  
    	return true;
    }
    
    public boolean doDelete(int StoryId)throws Exception{  
    	String sql = "DELETE FROM STORY WHERE StoryId=?";
    	stat = con.prepareStatement(sql);
    	stat.setInt(1, StoryId);
    	int rs = stat.executeUpdate();
    	if(rs > 0)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public List<Story> findAll()throws Exception{  
    	List<Story> storys = new ArrayList<Story>();
    	Story story = null;
    	String sql = "SELECT StoryId,StoryName,StoryTime,StoryEditor,StoryContext,StoryBrief FROM STORY";
    	stat = con.prepareStatement(sql);
    	ResultSet rs = stat.executeQuery();
    	while(rs.next())
    	{
    		int StoryId = rs.getInt(1);
    		String StoryName = rs.getString(2);
    		String StoryEditor = rs.getString(4);
    		String StoryContext = rs.getString(5);
    		String StoryBrief = rs.getString(6);
    		story = new Story(StoryId,StoryName,rs.getDate(3),StoryEditor,StoryContext,StoryBrief);
    		storys.add(story);
    	}
    	return storys;
    }
    
    public Story findById(int StoryId)throws Exception{ 
    	Story story = null;
    	String sql = "SELECT StoryId,StoryName,StoryTime,StoryEditor,StoryContext,StoryBrief FROM STORY WHERE StoryId=?";
    	stat = con.prepareStatement(sql);
    	stat.setInt(1, StoryId);
    	ResultSet rs = stat.executeQuery();
    	if(rs.next())
    	{
    		String StoryName = rs.getString(2);
    		String StoryEditor = rs.getString(4);
    		String StoryContext = rs.getString(5);
    		String StoryBrief = rs.getString(6);
    		story = new Story(StoryId,StoryName,rs.getDate(3),StoryEditor,StoryContext,StoryBrief);
    	}
    	return story;
    }
}
