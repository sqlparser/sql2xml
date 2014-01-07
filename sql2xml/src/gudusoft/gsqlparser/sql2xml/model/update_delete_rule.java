
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class update_delete_rule
{

	@Element
	private update_rule update_rule = new update_rule( );

	@Element(required = false)
	private delete_rule delete_rule;

	public delete_rule getDelete_rule( )
	{
		return delete_rule;
	}

	public void setDelete_rule( delete_rule delete_rule )
	{
		this.delete_rule = delete_rule;
	}

	public update_rule getUpdate_rule( )
	{
		return update_rule;
	}

}
