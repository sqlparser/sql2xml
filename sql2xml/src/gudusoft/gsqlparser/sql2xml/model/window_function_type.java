
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class window_function_type
{

	@Element(required = false)
	private String rank_function_type;

	@Element(required = false)
	private String kw_row_number;

	@Element(required = false)
	private aggregate_function aggregate_function;

	public String getRank_function_type( )
	{
		return rank_function_type;
	}

	public void setRank_function_type( String rank_function_type )
	{
		this.rank_function_type = rank_function_type;
	}

	public String getKw_row_number( )
	{
		return kw_row_number;
	}

	public void setKw_row_number( String kw_row_number )
	{
		this.kw_row_number = kw_row_number;
	}

	public aggregate_function getAggregate_function( )
	{
		return aggregate_function;
	}

	public void setAggregate_function( aggregate_function aggregate_function )
	{
		this.aggregate_function = aggregate_function;
	}

}
