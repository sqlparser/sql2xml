
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class in_predicate_part_2
{

	@Element(required = false)
	private String kw_not;

	@Element
	private String kw_in = "in";

	@Element
	private in_predicate_value in_predicate_value = new in_predicate_value( );

	public String getKw_not( )
	{
		return kw_not;
	}

	public void setKw_not( String kw_not )
	{
		this.kw_not = kw_not;
	}

	public in_predicate_value getIn_predicate_value( )
	{
		return in_predicate_value;
	}

}
