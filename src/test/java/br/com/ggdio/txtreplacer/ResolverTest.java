

package br.com.ggdio.txtreplacer;

import junit.framework.TestCase;
import br.com.ggdio.txtreplacer.resolver.UnaccentedResolver;
import br.com.ggdio.txtreplacer.resolver.UnicodeResolver;

/**
 * Unit test for simple App.
 */
/**
 * @author Guilherme Dio
 *
 */
public class ResolverTest extends TestCase {
	
	
	public void testUnicodeResolver() throws Exception {
		String result = new UnicodeResolver().resolve("γινσυϊη");System.out.println("testUnicodeResolver: result="+result);
		assertTrue("Deveria somente conter os respectivos unicodes",result.equals("\\u00e3\\u00e9\\u00ed\\u00f3\\u00f5\\u00fa\\u00e7"));
		System.out.println("testUnicodeResolver: result="+result);
	}
	
	public void testUnnacentedResolver() throws Exception {
		String result = new UnaccentedResolver().resolve("γινσυϊη");
		assertTrue("Deveria somente conter as letras sem acento",result.equals("aeioouc"));
		System.out.println("testUnnacentedResolver: result="+result);
	}
	
}
