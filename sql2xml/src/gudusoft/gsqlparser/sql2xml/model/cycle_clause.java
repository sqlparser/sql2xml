
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class cycle_clause
{

	@Element
	private String kw_cycle;

	@Element
	private cycle_column_list cycle_column_list;

	@Element
	private String kw_set;

	@Element
	private cycle_mark_column cycle_mark_column;

	@Element
	private String kw_to;

	@Element
	private cycle_mark_value cycle_mark_value;

	@Element
	private String kw_default;

	@Element
	private non_cycle_mark_value non_cycle_mark_value;

	@Element
	private String kw_using;

	@Element
	private path_column path_column;
}
