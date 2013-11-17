
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class qualified_join
{

	@Element(name="table_reference_or_partitioned_join_table")
	private table_reference_or_partitioned_join_table table;

	@Element(required = false)
	private join_type join_type;

	@Element
	private String kw_join;

	@Element(name="table_reference_or_partitioned_join_table")
	private table_reference_or_partitioned_join_table join_table;

	@Element
	private join_specification join_specification;
}
