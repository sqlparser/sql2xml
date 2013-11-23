
package gudusoft.gsqlparser.sql2xml.model;

import java.util.List;

import org.simpleframework.xml.ElementList;

public class asterisked_identifier_chain
{

	@ElementList(entry = "asterisked_identifier", inline = true)
	private List<asterisked_identifier> asterisked_identifier;

}
