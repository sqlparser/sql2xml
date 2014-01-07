
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class merge_when_matched_clause
{

	@Element
	private String kw_when = "when";

	@Element
	private String kw_matched = "matched";

	@Element
	private String kw_then = "then";

	@Element
	private merge_update_specification merge_update_specification = new merge_update_specification( );

	public merge_update_specification getMerge_update_specification( )
	{
		return merge_update_specification;
	}

}
