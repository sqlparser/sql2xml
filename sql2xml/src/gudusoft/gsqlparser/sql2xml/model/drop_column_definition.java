
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class drop_column_definition
{

	@Element
	private String kw_drop = "drop";

	@Element(required = false)
	private String kw_column;

	@Element
	private column_name column_name = new column_name( );

	@Element
	private drop_behavior drop_behavior = new drop_behavior( );

	public String getKw_column( )
	{
		return kw_column;
	}

	public void setKw_column( String kw_column )
	{
		this.kw_column = kw_column;
	}

	public column_name getColumn_name( )
	{
		return column_name;
	}

	public drop_behavior getDrop_behavior( )
	{
		return drop_behavior;
	}

}
