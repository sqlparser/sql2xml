
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class null_predicate_part_2
{

	@Element
	private String kw_is = "is";

	@Element(required = false)
	private String kw_not;

	@Element
	private String kw_null = "null";

	public String getKw_not( )
	{
		return kw_not;
	}

	public void setKw_not( String kw_not )
	{
		this.kw_not = kw_not;
	}

}
