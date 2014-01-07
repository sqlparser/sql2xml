
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class as_merge_correlation_name
{

	@Element(required = false)
	private String kw_as;

	@Element
	private merge_correlation_name merge_correlation_name = new merge_correlation_name( );

	public String getKw_as( )
	{
		return kw_as;
	}

	public void setKw_as( String kw_as )
	{
		this.kw_as = kw_as;
	}

	public merge_correlation_name getMerge_correlation_name( )
	{
		return merge_correlation_name;
	}

}
