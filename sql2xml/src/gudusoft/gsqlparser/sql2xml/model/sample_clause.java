
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class sample_clause
{

	@Element
	private String kw_tablesample = "tablesample";

	@Element
	private sample_method sample_method = new sample_method( );

	@Element
	private sample_percentage sample_percentage = new sample_percentage( );

	@Element(required = false)
	private repeatable_clause repeatable_clause;

	public repeatable_clause getRepeatable_clause( )
	{
		return repeatable_clause;
	}

	public void setRepeatable_clause( repeatable_clause repeatable_clause )
	{
		this.repeatable_clause = repeatable_clause;
	}

	public sample_method getSample_method( )
	{
		return sample_method;
	}

	public sample_percentage getSample_percentage( )
	{
		return sample_percentage;
	}

}
