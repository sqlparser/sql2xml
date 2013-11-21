
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class boolean_test
{

	@Element
	private boolean_primary boolean_primary = new boolean_primary( );

	@Element(required = false)
	private is_not_truth_value is_not_truth_value;

	public is_not_truth_value getIs_not_truth_value( )
	{
		return is_not_truth_value;
	}

	public void setIs_not_truth_value( is_not_truth_value is_not_truth_value )
	{
		this.is_not_truth_value = is_not_truth_value;
	}

	public boolean_primary getBoolean_primary( )
	{
		return boolean_primary;
	}

}
