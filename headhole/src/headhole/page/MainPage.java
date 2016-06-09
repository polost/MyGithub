package headhole.page;

/**
 * headholeÖ÷½çÃæ            
 * @author zjs
 * @version 1.0
 */

public class MainPage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PageFactory pageFactory = new PageFactory();
		Page page = pageFactory.CreatePage("firstpage");
		page.ActivePage();
	}
	
	

}
