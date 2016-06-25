package headhole.entity;

public class User {
	private int UserId;
	private String UserName;
	private String UserPass;
	
	public User()
	{
		
	}
	
	public User(String UserName)
	{
		this.UserName = UserName;
	}
	
	public int getUserId()
	{
		return UserId;
	}
	
	public void setUserId(int UserId)
	{
		this.UserId = UserId;
	}
	
	public String getUserName()
	{
		return UserName;
	}
	
	public void setUserName(String UserName)
	{
		this.UserName = UserName;
	}

	public String getUserPass()
	{
		return UserPass;
	}
	
	public void setUserPass(String UserPass)
	{
		this.UserPass = UserPass;
	}
}
