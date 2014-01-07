
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class delete_update_rule
{

	@Element
	private delete_rule delete_rule = new delete_rule( );

	@Element(required = false)
	private update_rule update_rule;

	public update_rule getUpdate_rule( )
	{
		return update_rule;
	}

	public void setUpdate_rule( update_rule update_rule )
	{
		this.update_rule = update_rule;
	}

	public delete_rule getDelete_rule( )
	{
		return delete_rule;
	}

}
