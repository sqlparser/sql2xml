
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class read_only_or_update_of
{

	@Element(required = false)
	private read_only read_only;

	@Element(required = false)
	private update_of_clause update_of_clause;

	public read_only getRead_only( )
	{
		return read_only;
	}

	public void setRead_only( read_only read_only )
	{
		this.read_only = read_only;
	}

	public update_of_clause getUpdate_of_clause( )
	{
		return update_of_clause;
	}

	public void setUpdate_of_clause( update_of_clause update_of_clause )
	{
		this.update_of_clause = update_of_clause;
	}

}
