
package gudusoft.gsqlparser.sql2xml.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class from_clause
{

	@Element
	private String kw_from;

	@ElementList(entry = "table_reference", inline = true)
	private List<table_reference> table_reference;
}
