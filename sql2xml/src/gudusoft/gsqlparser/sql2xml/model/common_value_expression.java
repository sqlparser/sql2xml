
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class common_value_expression
{

	@Element(required = false)
	private numeric_value_expression numeric_value_expression;

	@Element(required = false)
	private string_value_expression string_value_expression;

	@Element(required = false)
	private datetime_value_expression datetime_value_expression;

	@Element(required = false)
	private interval_value_expression interval_value_expression;

	@Element(required = false)
	private user_defined_type_value_expression user_defined_type_value_expression;

	@Element(required = false)
	private reference_value_expression reference_value_expression;

	@Element(required = false)
	private collection_value_expression collection_value_expression;

	public numeric_value_expression getNumeric_value_expression( )
	{
		return numeric_value_expression;
	}

	public void setNumeric_value_expression(
			numeric_value_expression numeric_value_expression )
	{
		this.numeric_value_expression = numeric_value_expression;
	}

	public string_value_expression getString_value_expression( )
	{
		return string_value_expression;
	}

	public void setString_value_expression(
			string_value_expression string_value_expression )
	{
		this.string_value_expression = string_value_expression;
	}

	public datetime_value_expression getDatetime_value_expression( )
	{
		return datetime_value_expression;
	}

	public void setDatetime_value_expression(
			datetime_value_expression datetime_value_expression )
	{
		this.datetime_value_expression = datetime_value_expression;
	}

	public interval_value_expression getInterval_value_expression( )
	{
		return interval_value_expression;
	}

	public void setInterval_value_expression(
			interval_value_expression interval_value_expression )
	{
		this.interval_value_expression = interval_value_expression;
	}

	public user_defined_type_value_expression getUser_defined_type_value_expression( )
	{
		return user_defined_type_value_expression;
	}

	public void setUser_defined_type_value_expression(
			user_defined_type_value_expression user_defined_type_value_expression )
	{
		this.user_defined_type_value_expression = user_defined_type_value_expression;
	}

	public reference_value_expression getReference_value_expression( )
	{
		return reference_value_expression;
	}

	public void setReference_value_expression(
			reference_value_expression reference_value_expression )
	{
		this.reference_value_expression = reference_value_expression;
	}

	public collection_value_expression getCollection_value_expression( )
	{
		return collection_value_expression;
	}

	public void setCollection_value_expression(
			collection_value_expression collection_value_expression )
	{
		this.collection_value_expression = collection_value_expression;
	}

}
