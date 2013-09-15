package br.com.ggdio.txtreplacer.util;

import java.io.File;
import java.io.IOException;

public class FileOperations {
	public static File touch(String name) throws IOException{
		File file = new File(name);
		file.createNewFile();
		return file;
	}
	
	public static void rm(File file){
		if(file != null && file.exists()){
			file.delete();
		}
	}
	
	public static void rename(File file,String name){
		if(file != null && file.exists()){
			file.renameTo(new File(file.getParent()+name));
		}
	}
}
