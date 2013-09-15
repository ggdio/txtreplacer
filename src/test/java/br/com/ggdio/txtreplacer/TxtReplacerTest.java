package br.com.ggdio.txtreplacer;

import java.io.File;

import junit.framework.TestCase;
import br.com.ggdio.txtreplacer.resolver.ResolverMethod;

public class TxtReplacerTest extends TestCase {
	public void testFileReplacerWithUnicode() throws Exception {
		TxtReplacer replacer = new TxtReplacer(ResolverMethod.UNACCENTED);
		replacer.replace(new File("C:\\teste.txt"));
	}
}
