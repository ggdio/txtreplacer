package br.com.ggdio.txtreplacer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	
	private void handle(File file){
		FileReader freader = null;
		FileWriter fwriter = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			//Creates the readers
			freader = new FileReader(file);
			reader = new BufferedReader(freader);
			
			//Scans the file
			String content = read(reader);
			close(freader,reader);
			
			//Handles the file
			FileOperations.rm(file);
			FileOperations.create(file);
			
			//Creates the writers
			fwriter = new FileWriter(file);
			writer = new BufferedWriter(fwriter);
			
			//Records the content
			write(writer,content);
		} 
		catch (FileNotFoundException e) {
			throw new RuntimeException("The file could not be found.");
		} 
		catch (IOException e) {
			throw new RuntimeException("The file is being used by another program, close it.");
		}
		catch(Exception e){
			throw new RuntimeException("An unexpected error occurred: "+e.getMessage());
		}
		finally{
			close(reader,freader,writer,fwriter);
		}
	}


	/**
	 * Executes the file reading
	 * @param reader - The reader to be used
	 * @return The file content
	 * @throws IOException
	 */
	private String read(BufferedReader reader) throws IOException {
		String content = "";
		String line;
		while((line = reader.readLine()) != null){
			if("".equals(line))
				content = content.concat("\n");
			else
				content = content.concat(method.getResolverStrategy().resolve(line)+"\n");
		}
		return content;
	}
	
	/**
	 * Method responsible for recording the content on the specified file
	 * @param print - PrintStream opened for use
	 * @param content - The String content to be recorded on the file
	 * @throws IOException 
	 */
	private void write(BufferedWriter writer, String content) throws IOException {
		for(String line : content.split("\n")){
			if("".equals(line))
				writer.newLine();
			else{
				writer.write(line);
				writer.newLine();
			}
		}
		System.out.println(content);
	}
	
	/**
	 * Close all the closeables
	 * @param closeables - The closeables to be closed
	 */
	private void close(Closeable...closeables){
		for(Closeable closeable : closeables){
			if(closeable != null){
				try {
					closeable.close();
				} 
				catch (IOException e) {
					System.out.println("Could not close the stream "+closeable.getClass().getSimpleName());
				}
			}
		}
	}

}
