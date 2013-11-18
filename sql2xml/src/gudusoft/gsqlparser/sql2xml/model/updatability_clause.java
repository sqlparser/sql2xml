
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class updatability_clause
{

	@Element
	private String kw_for = "for";

	@Element
	private read_only_or_update_of read_only_or_update_of;

	public read_only_or_update_of getRead_only_or_update_of( )
	{
		return read_only_or_update_of;
	}

	public void setRead_only_or_update_of(
			read_only_or_update_of read_only_or_update_of )
	{
		this.read_only_or_update_of = read_only_or_update_of;
	}
}
