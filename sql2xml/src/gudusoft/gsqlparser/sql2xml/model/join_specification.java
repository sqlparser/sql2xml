
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class join_specification
{

	@Element(required = false)
	private join_condition join_condition;

	@Element(required = false)
	private named_column_condition named_column_condition;

	public join_condition getJoin_condition( )
	{
		return join_condition;
	}

	public void setJoin_condition( join_condition join_condition )
	{
		this.join_condition = join_condition;
	}

	public named_column_condition getNamed_column_condition( )
	{
		return named_column_condition;
	}

	public void setNamed_column_condition(
			named_column_condition named_column_condition )
	{
		this.named_column_condition = named_column_condition;
	}

}
