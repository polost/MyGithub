package headhole.entity;

import java.sql.Date;

public final class Story {
	private int StoryId;
	private int TopicId;
	private String StoryName;
	private Date StoryTime;
	private String StoryEditor;
	private String StoryContext;
	private String StoryBrief;
	
	public Story()
	{}
	
	public Story(int TopicId, int StoryId, String StoryName, Date StoryTime, String StoryEditor, String StoryContext, String StoryBrief)
	{
		this.TopicId = TopicId;
		this.StoryId = StoryId;
		this.StoryName = StoryName;
		this.StoryTime = StoryTime;
		this.StoryEditor = StoryEditor;
		this.StoryContext = StoryContext;
		this.StoryBrief = StoryBrief;
	}
	
	public Story(String StoryName, Date StoryTime, String StoryEditor, String StoryContext, String StoryBrief)
	{
		this.StoryName = StoryName;
		this.StoryTime = StoryTime;
		this.StoryEditor = StoryEditor;
		this.StoryContext = StoryContext;
		this.StoryBrief = StoryBrief;
	}
	
	public Story(int StoryId, String StoryName, Date StoryTime, String StoryEditor, String StoryContext, String StoryBrief)
	{
		this.StoryId = StoryId;
		this.StoryName = StoryName;
		this.StoryTime = StoryTime;
		this.StoryEditor = StoryEditor;
		this.StoryContext = StoryContext;
		this.StoryBrief = StoryBrief;
	}
	
	public Story(String StoryEditor)
	{
		this.StoryEditor = StoryEditor;
	}
	
	public Story(int StoryId, String StoryContext)
	{
		this.StoryId = StoryId;
		this.StoryName = StoryContext;
	}
	
	public int getStoryId()
	{
		return StoryId;
	}
	
	public void setStoryId(int StoryId)
	{
		this.StoryId = StoryId;
	}
	
	public int getTopicId()
	{
		return TopicId;
	}
	
	public void setTopicId(int TopicId)
	{
		this.TopicId = TopicId;
	}
	
	public String getStoryName()
	{
		return StoryName;
	}
	
	public void setStoryName(String StoryName)
	{
		this.StoryName = StoryName;
	}

	public Date getStoryTime()
	{
		return StoryTime;
	}
	
	public void setStoryTime(Date StoryTime)
	{
		this.StoryTime = StoryTime;
	}

	public String getStoryEditor()
	{
		return StoryEditor;
	}
	
	public void setStoryEditor(String StoryEditor)
	{
		this.StoryEditor = StoryEditor;
	}

	public String getStoryContext()
	{
		return StoryContext;
	}
	
	public void setStoryContext(String StoryContext)
	{
		this.StoryContext = StoryContext;
	}
	
	public String getStoryBrief()
	{
		return StoryBrief;
	}
	
	public void setStoryBrief(String StoryBrief)
	{
		this.StoryBrief = StoryBrief;
	}
}
