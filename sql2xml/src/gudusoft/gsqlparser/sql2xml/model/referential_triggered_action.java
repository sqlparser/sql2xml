
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class referential_triggered_action
{

	@Element(required = false)
	private update_delete_rule update_delete_rule;

	@Element(required = false)
	private delete_update_rule delete_update_rule;

	public update_delete_rule getUpdate_delete_rule( )
	{
		return update_delete_rule;
	}

	public void setUpdate_delete_rule( update_delete_rule update_delete_rule )
	{
		this.update_delete_rule = update_delete_rule;
	}

	public delete_update_rule getDelete_update_rule( )
	{
		return delete_update_rule;
	}

	public void setDelete_update_rule( delete_update_rule delete_update_rule )
	{
		this.delete_update_rule = delete_update_rule;
	}

}
