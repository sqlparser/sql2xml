
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class explicit_table
{

	@Element
	private String kw_table = "table";

	@Element
	private table_or_query_name table_or_query_name;
}
