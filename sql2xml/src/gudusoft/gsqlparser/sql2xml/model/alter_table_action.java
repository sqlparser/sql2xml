
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class alter_table_action
{

	@Element(required = false)
	private add_column_definition add_column_definition;

	@Element(required = false)
	private alter_column_definition alter_column_definition;

	@Element(required = false)
	private drop_column_definition drop_column_definition;

	@Element(required = false)
	private add_table_constraint_definition add_table_constraint_definition;

	@Element(required = false)
	private drop_table_constraint_definition drop_table_constraint_definition;

	public add_column_definition getAdd_column_definition( )
	{
		return add_column_definition;
	}

	public void setAdd_column_definition(
			add_column_definition add_column_definition )
	{
		this.add_column_definition = add_column_definition;
	}

	public alter_column_definition getAlter_column_definition( )
	{
		return alter_column_definition;
	}

	public void setAlter_column_definition(
			alter_column_definition alter_column_definition )
	{
		this.alter_column_definition = alter_column_definition;
	}

	public drop_column_definition getDrop_column_definition( )
	{
		return drop_column_definition;
	}

	public void setDrop_column_definition(
			drop_column_definition drop_column_definition )
	{
		this.drop_column_definition = drop_column_definition;
	}

	public add_table_constraint_definition getAdd_table_constraint_definition( )
	{
		return add_table_constraint_definition;
	}

	public void setAdd_table_constraint_definition(
			add_table_constraint_definition add_table_constraint_definition )
	{
		this.add_table_constraint_definition = add_table_constraint_definition;
	}

	public drop_table_constraint_definition getDrop_table_constraint_definition( )
	{
		return drop_table_constraint_definition;
	}

	public void setDrop_table_constraint_definition(
			drop_table_constraint_definition drop_table_constraint_definition )
	{
		this.drop_table_constraint_definition = drop_table_constraint_definition;
	}

}
