package rough;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Date d = new Date();
		
		String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	String filepath = 	System.getProperty("user.dir")+"\\reports\\"+fileName;
	System.out.println(filepath);
	}

}
