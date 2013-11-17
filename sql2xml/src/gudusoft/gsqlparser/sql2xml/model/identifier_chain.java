
package gudusoft.gsqlparser.sql2xml.model;

import java.util.List;

import org.simpleframework.xml.ElementList;

public class identifier_chain
{

	@ElementList(entry = "identifier", inline = true)
	private List<identifier> identifier;
}
