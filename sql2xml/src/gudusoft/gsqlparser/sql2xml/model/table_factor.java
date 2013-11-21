
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_factor
{

	@Element
	private table_primary table_primary = new table_primary( );

	@Element(required = false)
	private sample_clause sample_clause;

	public sample_clause getSample_clause( )
	{
		return sample_clause;
	}

	public void setSample_clause( sample_clause sample_clause )
	{
		this.sample_clause = sample_clause;
	}

	public table_primary getTable_primary( )
	{
		return table_primary;
	}

}
