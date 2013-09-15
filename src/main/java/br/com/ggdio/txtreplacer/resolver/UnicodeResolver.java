/*****************************************************************************
* Unicode Escape Chars														 *
* ã = \u00e3																 *
* õ = \u00f5																 *
* á = \u00e1																 *
* é = \u00e9																 *
* í = \u00ed																 *
* ó = \u00f3																 *
* ç = \u00e7																 *
* â = \u00e2																 *
* ê = \u00ea																 *
* ô = \u00f4																 *
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
			put("ã", "\\\\u00e3");
			put("õ", "\\\\u00f5");
			put("á", "\\\\u00e1");
			put("é", "\\\\u00e9");
			put("í", "\\\\u00ed");
			put("ó", "\\\\u00f3");
			put("ç", "\\\\u00e7");
			put("ê", "\\\\u00ea");
			put("ô", "\\\\u00f4");
			put("ú", "\\\\u00fa");
			
			put("Ã", "\\\\u00c3");
			put("Õ", "\\\\u00d5");
			put("Á", "\\\\u00c1");
			put("É", "\\\\u00c9");
			put("Í", "\\\\u00cd");
			put("Ó", "\\\\u00d3");
			put("Ç", "\\\\u00c7");
			put("Ê", "\\\\u00ca");
			put("Ô", "\\\\u00d4");
			put("Ú", "\\\\u00da");
		}});
	}

}
