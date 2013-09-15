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
 * Class responsible for replacing especial characters with unicode escape characters
 * @author Guilherme Dio
 */
public class UnicodeResolver extends ResolverTemplate {

	@SuppressWarnings("serial")
	public UnicodeResolver() {
		super(new HashMap<String, String>(){{
			put("�", "\\\\u00e3");
			put("�", "\\\\u00f5");
			put("�", "\\\\u00e1");
			put("�", "\\\\u00e9");
			put("�", "\\\\u00ed");
			put("�", "\\\\u00f3");
			put("�", "\\\\u00e7");
			put("�", "\\\\u00ea");
			put("�", "\\\\u00f4");
			put("�", "\\\\u00fa");
			
			put("�", "\\\\u00c3");
			put("�", "\\\\u00d5");
			put("�", "\\\\u00c1");
			put("�", "\\\\u00c9");
			put("�", "\\\\u00cd");
			put("�", "\\\\u00d3");
			put("�", "\\\\u00c7");
			put("�", "\\\\u00ca");
			put("�", "\\\\u00d4");
			put("�", "\\\\u00da");
		}});
	}

}
