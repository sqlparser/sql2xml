
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class is_not_truth_value
{

	@Element
	private String kw_is = "is";

	@Element(required = false)
	private String kw_not;

	@Element
	private truth_value truth_value = new truth_value( );

	public String getKw_not( )
	{
		return kw_not;
	}

	public void setKw_not( String kw_not )
	{
		this.kw_not = kw_not;
	}

	public truth_value getTruth_value( )
	{
		return truth_value;
	}

}
