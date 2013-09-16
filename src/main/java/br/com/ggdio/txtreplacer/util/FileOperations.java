package br.com.ggdio.txtreplacer.util;

import java.io.File;
import java.io.IOException;

public class FileOperations {
	public static File touch(String name) throws IOException{
		File file = new File(name);
		file.createNewFile();
		return file;
	}
	
	public static boolean rm(File file){
		if(file != null && file.exists()){
			return file.delete();
		}
		return false;
	}
	
	public boolean rename(File file,String name){
		if(file != null && file.exists()){
			return file.renameTo(new File(file.getParent()+name));
		}
		return false;
	}
	
	public static boolean create(File file) throws IOException{
		if(!file.exists())
			return file.createNewFile();
		return false;
	}
}
