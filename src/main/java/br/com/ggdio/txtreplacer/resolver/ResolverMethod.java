package br.com.ggdio.txtreplacer.resolver;

/**
 * Enum responsible for giving the resolver strategy
 * @author Guilheme Dio
 *
 */
public enum ResolverMethod {
	UNICODE(new UnicodeResolver()),
	UNACCENTED(new UnaccentedResolver());
	
	private final Resolver resolver;
	ResolverMethod(Resolver resolver){
		this.resolver = resolver;
	}
	
	public Resolver getResolverStrategy(){
		return resolver;
	}
}
