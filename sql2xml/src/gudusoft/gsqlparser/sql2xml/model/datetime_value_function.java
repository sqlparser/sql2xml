
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class datetime_value_function
{

	@Element(required = false)
	private current_date_value_function current_date_value_function;

	@Element(required = false)
	private current_time_value_function current_time_value_function;

	@Element(required = false)
	private current_timestamp_value_function current_timestamp_value_function;

	@Element(required = false)
	private current_local_time_value_function current_local_time_value_function;

	@Element(required = false)
	private current_local_timestamp_value_function current_local_timestamp_value_function;

	public current_date_value_function getCurrent_date_value_function( )
	{
		return current_date_value_function;
	}

	public void setCurrent_date_value_function(
			current_date_value_function current_date_value_function )
	{
		this.current_date_value_function = current_date_value_function;
	}

	public current_time_value_function getCurrent_time_value_function( )
	{
		return current_time_value_function;
	}

	public void setCurrent_time_value_function(
			current_time_value_function current_time_value_function )
	{
		this.current_time_value_function = current_time_value_function;
	}

	public current_timestamp_value_function getCurrent_timestamp_value_function( )
	{
		return current_timestamp_value_function;
	}

	public void setCurrent_timestamp_value_function(
			current_timestamp_value_function current_timestamp_value_function )
	{
		this.current_timestamp_value_function = current_timestamp_value_function;
	}

	public current_local_time_value_function getCurrent_local_time_value_function( )
	{
		return current_local_time_value_function;
	}

	public void setCurrent_local_time_value_function(
			current_local_time_value_function current_local_time_value_function )
	{
		this.current_local_time_value_function = current_local_time_value_function;
	}

	public current_local_timestamp_value_function getCurrent_local_timestamp_value_function( )
	{
		return current_local_timestamp_value_function;
	}

	public void setCurrent_local_timestamp_value_function(
			current_local_timestamp_value_function current_local_timestamp_value_function )
	{
		this.current_local_timestamp_value_function = current_local_timestamp_value_function;
	}

}
