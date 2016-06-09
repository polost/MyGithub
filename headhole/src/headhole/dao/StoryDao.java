package headhole.dao;

import java.util.List;

import headhole.entity.Story;

public interface StoryDao {
    public boolean doCreate(Story story)throws Exception; 
    public boolean doUpdate(Story story)throws Exception; 
    public boolean doDelete(int StoryId)throws Exception; 
    public List<Story> findAll()throws Exception;  
    public Story findById(int StoryId)throws Exception;  
}
