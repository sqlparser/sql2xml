
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class correlation_name_with_derived_column_list
{

	@Element(required = false)
	private String kw_as;

	@Element
	private correlation_name correlation_name = new correlation_name( );

	@Element(required = false)
	private derived_column_list derived_column_list;

	public String getKw_as( )
	{
		return kw_as;
	}

	public void setKw_as( String kw_as )
	{
		this.kw_as = kw_as;
	}

	public derived_column_list getDerived_column_list( )
	{
		return derived_column_list;
	}

	public void setDerived_column_list( derived_column_list derived_column_list )
	{
		this.derived_column_list = derived_column_list;
	}

	public correlation_name getCorrelation_name( )
	{
		return correlation_name;
	}

}
