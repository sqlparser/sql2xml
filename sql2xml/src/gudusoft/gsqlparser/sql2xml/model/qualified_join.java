
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

public class qualified_join
{

	@Path("table_reference_or_partitioned_join_table[1]")
	@Element(name = "table_reference", required = false)
	private table_reference table_reference;

	@Path("table_reference_or_partitioned_join_table[1]")
	@Element(name = "partitioned_join_table", required = false)
	private partitioned_join_table partitioned_join_table;

	@Element(required = false)
	private join_type join_type;

	@Element
	private String kw_join = "join";

	@Path("table_reference_or_partitioned_join_table[2]")
	@Element(name = "table_reference", required = false)
	private table_reference join_table_reference;

	@Path("table_reference_or_partitioned_join_table[2]")
	@Element(name = "partitioned_join_table", required = false)
	private partitioned_join_table join_partitioned_join_table;

	@Element
	private join_specification join_specification = new join_specification( );

	public join_type getJoin_type( )
	{
		return join_type;
	}

	public void setJoin_type( join_type join_type )
	{
		this.join_type = join_type;
	}

	public table_reference getTable_reference( )
	{
		return table_reference;
	}

	public void setTable_reference( table_reference table_reference )
	{
		this.table_reference = table_reference;
	}

	public partitioned_join_table getPartitioned_join_table( )
	{
		return partitioned_join_table;
	}

	public void setPartitioned_join_table(
			partitioned_join_table partitioned_join_table )
	{
		this.partitioned_join_table = partitioned_join_table;
	}

	public table_reference getJoin_table_reference( )
	{
		return join_table_reference;
	}

	public void setJoin_table_reference( table_reference join_table_reference )
	{
		this.join_table_reference = join_table_reference;
	}

	public partitioned_join_table getJoin_partitioned_join_table( )
	{
		return join_partitioned_join_table;
	}

	public void setJoin_partitioned_join_table(
			partitioned_join_table join_partitioned_join_table )
	{
		this.join_partitioned_join_table = join_partitioned_join_table;
	}

	public join_specification getJoin_specification( )
	{
		return join_specification;
	}

}
