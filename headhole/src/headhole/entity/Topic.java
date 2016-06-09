package headhole.entity;

import java.sql.Date;

public class Topic {
	private int TopicId;
	private String TopicName;
	private Date TopicTime;
	private String TopicEditor;
	private String TopicBrief;
	
	public Topic(String TopicName, Date TopicTime, String TopicEditor, String TopicBrief)
	{
		this.TopicName = TopicName;
		this.TopicTime = TopicTime;
		this.TopicEditor = TopicEditor;
		this.TopicBrief = TopicBrief;
	}
	
	public Topic(int TopicId, String TopicName, Date TopicTime, String TopicEditor, String TopicBrief)
	{
		this.TopicId = TopicId;
		this.TopicName = TopicName;
		this.TopicTime = TopicTime;
		this.TopicEditor = TopicEditor;
		this.TopicBrief = TopicBrief;
	}
	
	public Topic(String TopicEditor)
	{
		this.TopicEditor = TopicEditor;
	}
	
	public Topic(int TopicId, String TopicBrief)
	{
		this.TopicId = TopicId;
		this.TopicBrief = TopicBrief;
	}
	
	public int getTopicId()
	{
		return TopicId;
	}
	
	public void setTopicId(int TopicId)
	{
		this.TopicId = TopicId;
	}
	
	public String getTopicName()
	{
		return TopicName;
	}
	
	public void setTopicName(String TopicName)
	{
		this.TopicName = TopicName;
	}

	public Date getTopicTime()
	{
		return TopicTime;
	}
	
	public void setTopicTime(Date TopicTime)
	{
		this.TopicTime = TopicTime;
	}

	public String getTopicEditor()
	{
		return TopicEditor;
	}
	
	public void setTopicEditor(String TopicEditor)
	{
		this.TopicEditor = TopicEditor;
	}
	
	public String getTopicBrief()
	{
		return TopicBrief;
	}
	
	public void setTopicBrief(String TopicBrief)
	{
		this.TopicBrief = TopicBrief;
	}
}
