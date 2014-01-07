
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class merge_when_not_matched_clause
{

	@Element
	private String kw_when = "when";

	@Element
	private String kw_not = "not";

	@Element
	private String kw_matched = "matched";

	@Element
	private String kw_then = "then";

	@Element
	private merge_insert_specification merge_insert_specification = new merge_insert_specification( );

	public merge_insert_specification getMerge_insert_specification( )
	{
		return merge_insert_specification;
	}

}
