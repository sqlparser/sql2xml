
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class unique_specification
{

	@Element(required = false)
	private String kw_unique;

	@Element(required = false)
	private primary_key primary_key;

	public primary_key getPrimary_key( )
	{
		return primary_key;
	}

	public String getKw_unique( )
	{
		return kw_unique;
	}

	public void setKw_unique( String kw_unique )
	{
		this.kw_unique = kw_unique;
	}

	public void setPrimary_key( primary_key primary_key )
	{
		this.primary_key = primary_key;
	}

}
