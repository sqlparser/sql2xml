
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class as_correlation_name
{

	@Element(required = false)
	private String kw_as;

	@Element
	private correlation_name correlation_name = new correlation_name( );

	public String getKw_as( )
	{
		return kw_as;
	}

	public void setKw_as( String kw_as )
	{
		this.kw_as = kw_as;
	}

	public correlation_name getCorrelation_name( )
	{
		return correlation_name;
	}

}
