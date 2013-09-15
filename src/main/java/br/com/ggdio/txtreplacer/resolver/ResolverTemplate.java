package br.com.ggdio.txtreplacer.resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A template class for resolver strategy
 * @author Guilherme Dio
 *
 */
public abstract class ResolverTemplate implements Resolver {

	protected final Map<String, String> charMap;
	
	public ResolverTemplate(Map<String, String> charMap) {
		this.charMap = charMap;
	}
	
	@Override
	public String resolve(String acentos) {
		for(String key : getCharmapKeys())
			acentos = acentos.replaceAll(key, charMap.get(key));
		return acentos;
	}
	
	private final List<String> getCharmapKeys(){
		return new ArrayList<>(charMap.keySet());
	}
}
