package br.com.ggdio.txtreplacer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import br.com.ggdio.txtreplacer.resolver.ResolverMethod;
import br.com.ggdio.txtreplacer.util.FileOperations;

/**
 * Handle files to replace it values
 * @author Guilherme Dio
 *
 */
public class TxtReplacer {

	private final ResolverMethod method;

	public TxtReplacer(ResolverMethod unicode) {
		this.method = unicode;
	}

	/**
	 * Execute the text replacement
	 * @param file
	 */
	public void replace(File file) {
		if(file == null)
			throw new IllegalArgumentException("The file must be specified");
		if(!file.canRead() && !file.canWrite())
			throw new RuntimeException("The program does not have the permission to modify it.");
		 handle(file);
	}
	
	/**
	 * Private method to handle the file replacement
	 * @param file
	 */
	private void handle(File file){
		Scanner scan = null;
		PrintStream print = null;
		boolean successful = false;
		String flName = file.getName();
		File aux = null;
		try {
			aux = FileOperations.touch(file.getPath()+".txtreplacer");
			scan = new Scanner(file);
			print = new PrintStream(aux);
			while(scan.hasNextLine()){
				String line = method.getResolverStrategy().resolve(scan.nextLine());
				print.println(line);
			}
			successful = true;
		} 
		catch (FileNotFoundException e) {
			throw new RuntimeException("The file could not be found.");
		} 
		catch (IOException e) {
			throw new RuntimeException("The file is being used by another program, close it.");
		}
		finally{
			if(scan != null)
				scan.close();
			if(print != null)
				print.close();
			if(successful){
				FileOperations.rm(file);
				FileOperations.rename(aux, flName);
			}
		}
	}

}
