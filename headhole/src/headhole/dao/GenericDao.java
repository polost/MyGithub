package headhole.dao;

import headhole.db.DatabaseConnection;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GenericDao {
	private final Class<?> tableClass;
	private DatabaseConnection dbConnection;
	private Connection con;
    private PreparedStatement stat = null; 
	
	public GenericDao(Class<?> cls)
	{
		this.tableClass = cls;
	}
	
	public boolean doCreate(Object obj)throws Exception{
		dbConnection = new DatabaseConnection();
		con = dbConnection.getConnection();
    	Field[] fields = tableClass.getDeclaredFields();
    	String commaSeparatedFieldNames = "";
    	String commaSeparatedQuestionMarks = "";
    	for(int fieldIndex = 0; fieldIndex < fields.length; fieldIndex++)
    	{
    		if(fieldIndex > 0)
    		{
    			commaSeparatedFieldNames += ",";
    			commaSeparatedQuestionMarks += ",";
    		}
    		commaSeparatedFieldNames += fields[fieldIndex].getName();
    		commaSeparatedQuestionMarks += "?";
    	}
    	String sql = String.format("INSERT INTO %s(%s) VALUES(%s)", tableClass.getSimpleName(), commaSeparatedFieldNames, commaSeparatedQuestionMarks);
    	stat = con.prepareStatement(sql);
    	for(int fieldIndex = 0; fieldIndex < fields.length; fieldIndex++)
    	{
    		Method method = tableClass.getMethod("get"+fields[fieldIndex].getName());
    		stat.setObject(fieldIndex+1, method.invoke(obj));
    	}
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
	
	public boolean doUpdate(Object obj)throws Exception{
		return true;
    }  
	
	public boolean doDelete(Object id)throws Exception{
		dbConnection = new DatabaseConnection();
		con = dbConnection.getConnection();
    	Field[] fields = tableClass.getDeclaredFields();
    	String sql = String.format("DELETE FROM %s WHERE %s=?", tableClass.getSimpleName(), fields[0].getName());
    	stat = con.prepareStatement(sql);
    	stat.setObject(1,id);
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
	
	public List<? extends Object> findAll() throws Exception
	{
		dbConnection = new DatabaseConnection();
		con = dbConnection.getConnection();
		//Method[] methods = tableClass.getMethods();
		//因为类中的属性都是设置成私有属性，所以此处需要用getDeclaredFields，而不能用getFields
    	Field[] fields = tableClass.getDeclaredFields();
	    List<Object> objectList = new ArrayList<Object>();
    	String sql = String.format("SELECT * FROM %s", tableClass.getSimpleName());
    	stat = con.prepareStatement(sql);
    	ResultSet rs = stat.executeQuery();
    	while(rs.next())
    	{
    		//此处需要获取操作实体的一个具体的对象而不能是Object对象，why?
    		Object obj = (Object)tableClass.newInstance();
    		//Object obj = new Object();
    		for(Field field : fields)
    		{
    			Object value = rs.getObject(field.getName());
    			//因为类中的属性都是设置成私有属性，所以不能直接使用set操作，而应该调用这个类的提供的公共方法进行值得设置
    			Method method = tableClass.getMethod("set"+field.getName(), field.getType());
    			method.invoke(obj, value);
    			//field.set(obj, value);
    		}
    		objectList.add(obj);
    	}
    	return objectList;
	}
	
	public Object findById(Object id) throws Exception
	{
		Object obj = null;
		dbConnection = new DatabaseConnection();
		con = dbConnection.getConnection();
    	Field[] fields = tableClass.getDeclaredFields();
    	String sql = String.format("SELECT * FROM %s WHERE %s=?", tableClass.getSimpleName(), tableClass.getSimpleName()+"Id");
    	stat = con.prepareStatement(sql);
    	stat.setObject(1,id);
    	ResultSet rs = stat.executeQuery();
    	if(rs.next())
    	{
    		obj = (Object)tableClass.newInstance();
    		for(Field field : fields)
    		{
    			Object value = rs.getObject(field.getName());
    			//因为类中的属性都是设置成私有属性，所以不能直接使用set操作，而应该调用这个类的提供的公共方法进行值得设置
    			Method method = tableClass.getMethod("set"+field.getName(), field.getType());
    			method.invoke(obj, value);
    		}
    	}
    	return obj;
	}
	
	public List<? extends Object> findByPara(Object paraValue, String paraName) throws Exception
	{
		List<Object> objectList = new ArrayList<Object>();
		dbConnection = new DatabaseConnection();
		con = dbConnection.getConnection();
    	Field[] fields = tableClass.getDeclaredFields();
    	String sql = String.format("SELECT * FROM %s WHERE %s=?", tableClass.getSimpleName(), paraName);
    	stat = con.prepareStatement(sql);
    	stat.setObject(1,paraValue);
    	ResultSet rs = stat.executeQuery();
    	while(rs.next())
    	{
    		Object obj = (Object)tableClass.newInstance();
    		for(Field field : fields)
    		{
    			Object value = rs.getObject(field.getName());
    			//因为类中的属性都是设置成私有属性，所以不能直接使用set操作，而应该调用这个类的提供的公共方法进行值得设置
    			Method method = tableClass.getMethod("set"+field.getName(), field.getType());
    			method.invoke(obj, value);
    		}
    		objectList.add(obj);
    	}
    	return objectList;
	}
}
