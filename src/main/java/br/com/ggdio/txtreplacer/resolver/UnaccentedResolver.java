/*****************************************************************************
* Unicode Escape Chars														 *
* � = \u00e3																 *
* � = \u00f5																 *
* � = \u00e1																 *
* � = \u00e9																 *
* � = \u00ed																 *
* � = \u00f3																 *
* � = \u00e7																 *
* � = \u00e2																 *
* � = \u00ea																 *
* � = \u00f4																 *
******************************************************************************/

package br.com.ggdio.txtreplacer.resolver;

import java.util.HashMap;

/**
 * Class responsible for replacing especial characters with unaccented characters
 * @author Guilherme Dio
 * @since 14/09/2013
 */
public class UnaccentedResolver extends ResolverTemplate {
	
	@SuppressWarnings("serial")
	public UnaccentedResolver() {
		super(new HashMap<String, String>(){{
			put("�", "a");
			put("�", "o");
			put("�", "a");
			put("�", "e");
			put("�", "i");
			put("�", "o");
			put("�", "c");
			put("�", "e");
			put("�", "o");
			put("�", "u");
			
			put("�", "a");
			put("�", "o");
			put("�", "a");
			put("�", "e");
			put("�", "i");
			put("�", "o");
			put("�", "c");
			put("�", "e");
			put("�", "o");
			put("�", "u");
		}});
	}

}
