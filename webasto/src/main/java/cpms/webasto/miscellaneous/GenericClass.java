package cpms.webasto.miscellaneous;

import java.io.File;

public class GenericClass {

public String extractFileName()
{
	String fileName = null;
	File file = new File("C:\\Users\\DELL\\Downloads");
    File[] files = file.listFiles();
    for(File fx: files){
    	fileName=fx.getName();
    	if(fileName.contains("Diagnostics.tar.gz"))
    	{
    		break;	
    	}
    }
	return fileName;
}
}
