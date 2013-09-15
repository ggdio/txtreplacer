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
 * Class responsible for replacing especial characters with unaccented characters
 * @author Guilherme Dio
 * @since 14/09/2013
 */
public class UnaccentedResolver extends ResolverTemplate {
	
	@SuppressWarnings("serial")
	public UnaccentedResolver() {
		super(new HashMap<String, String>(){{
			put("ã", "a");
			put("õ", "o");
			put("á", "a");
			put("é", "e");
			put("í", "i");
			put("ó", "o");
			put("ç", "c");
			put("ê", "e");
			put("ô", "o");
			put("ú", "u");
			
			put("Ã", "a");
			put("Õ", "o");
			put("Á", "a");
			put("É", "e");
			put("Í", "i");
			put("Ó", "o");
			put("Ç", "c");
			put("Ê", "e");
			put("Ô", "o");
			put("Ú", "u");
		}});
	}

}
