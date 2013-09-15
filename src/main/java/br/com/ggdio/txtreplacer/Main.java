package br.com.ggdio.txtreplacer;

import java.io.File;

import br.com.ggdio.txtreplacer.resolver.ResolverMethod;

/**
 * Runnable class for the replace process
 * When calling this main, must specifiy a file and a optional {@link ResolverMethod}.
 * If the {@link ResolverMethod} is not defined, then the default is the UNCODE resolver
 */
public class Main {
	public static void main(String[] args) {
		if(args.length == 0){
			System.err.println( "A file must be specified as an argument: 'txtreplacer C:\\arquivo.txt'");
			System.exit(1);
			return;
		}
		ResolverMethod method = ResolverMethod.UNICODE;
		try{
			if(args.length == 2)
				method = ResolverMethod.valueOf(ResolverMethod.class, args[1]);
			TxtReplacer replacer = new TxtReplacer(method);
			replacer.replace(new File(args[0]));
			System.out.println("File content replaced !");
		}
		catch(IllegalArgumentException e){
			System.err.println("The specified resolve method does not exists: "+args[1]);
			System.exit(1);
		}
		catch(Exception e){
			System.err.println("A problem occurred during the execution: "+e.getMessage());
			System.exit(1);
		}
	}
}
