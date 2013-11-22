
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class natural_join
{

	@Element(name = "table_reference_or_partitioned_join_table")
	private table_reference_or_partitioned_join_table table = new table_reference_or_partitioned_join_table( );

	@Element
	private String kw_natural = "natural";

	@Element(required = false)
	private join_type join_type;

	@Element
	private String kw_join = "join";

	@Element(name = "table_reference_or_partitioned_join_table")
	private table_reference_or_partitioned_join_table join_table = new table_reference_or_partitioned_join_table( );

	public join_type getJoin_type( )
	{
		return join_type;
	}

	public void setJoin_type( join_type join_type )
	{
		this.join_type = join_type;
	}

	public table_reference_or_partitioned_join_table getTable( )
	{
		return table;
	}

	public table_reference_or_partitioned_join_table getJoin_table( )
	{
		return join_table;
	}

}
