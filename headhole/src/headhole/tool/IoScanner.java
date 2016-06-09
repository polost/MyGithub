package headhole.tool;

import headhole.entity.Story;

import java.util.List;
import java.util.Scanner;

public class IoScanner {
	public static String ScannerInputString()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入：");
		return scanner.next();
	}
	
	public static int ScannerInputIndex()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入：");
		String indexString = scanner.next();
		String regex = "([0-9])|([1-9][0-9]+)";
		int index = -1;
		if(indexString.matches(regex))
		{
			index = Integer.parseInt(indexString);
		}
		return index;
	}
	
	public static void ScannerOutputStory(Story story)
	{
		System.out.println("-----------故事编号"+story.getStoryId()+"-----------");
		System.out.println("故事名："+story.getStoryName());
		System.out.println("日期："+story.getStoryTime());
		System.out.println("作者："+story.getStoryEditor());
		System.out.println(story.getStoryContext());
		System.out.println("-------------------------");
	}
	
	public static void ScannerOutputStoryBrief(Story story)
	{
		System.out.println("-----------故事编号"+story.getStoryId()+"-----------");
		System.out.println("故事名："+story.getStoryName());
		System.out.println("日期："+story.getStoryTime());
		System.out.println("作者："+story.getStoryEditor());
		System.out.println(story.getStoryBrief());
		System.out.println("-------------------------");
	}
	
	public static void ScannerOutputStoryList(List<Story> storys)
	{
		for(int storyIndex = 0; storyIndex < storys.size(); storyIndex++)
		{
			ScannerOutputStoryBrief(storys.get(storyIndex));
		}
	}
}
