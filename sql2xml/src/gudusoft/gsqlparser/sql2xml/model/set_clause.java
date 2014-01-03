
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class set_clause
{

	@Element(required = false)
	private multiple_column_assignment multiple_column_assignment;

	@Element(required = false)
	private set_target_equals_update_source set_target_equals_update_source;

	public multiple_column_assignment getMultiple_column_assignment( )
	{
		return multiple_column_assignment;
	}

	public void setMultiple_column_assignment(
			multiple_column_assignment multiple_column_assignment )
	{
		this.multiple_column_assignment = multiple_column_assignment;
	}

	public set_target_equals_update_source getSet_target_equals_update_source( )
	{
		return set_target_equals_update_source;
	}

	public void setSet_target_equals_update_source(
			set_target_equals_update_source set_target_equals_update_source )
	{
		this.set_target_equals_update_source = set_target_equals_update_source;
	}

}
