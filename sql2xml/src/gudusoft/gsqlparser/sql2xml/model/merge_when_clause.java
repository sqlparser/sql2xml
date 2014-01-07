
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class merge_when_clause
{

	@Element(required = false)
	private merge_when_matched_clause merge_when_matched_clause;

	@Element(required = false)
	private merge_when_not_matched_clause merge_when_not_matched_clause;

	public merge_when_matched_clause getMerge_when_matched_clause( )
	{
		return merge_when_matched_clause;
	}

	public void setMerge_when_matched_clause(
			merge_when_matched_clause merge_when_matched_clause )
	{
		this.merge_when_matched_clause = merge_when_matched_clause;
	}

	public merge_when_not_matched_clause getMerge_when_not_matched_clause( )
	{
		return merge_when_not_matched_clause;
	}

	public void setMerge_when_not_matched_clause(
			merge_when_not_matched_clause merge_when_not_matched_clause )
	{
		this.merge_when_not_matched_clause = merge_when_not_matched_clause;
	}

}
