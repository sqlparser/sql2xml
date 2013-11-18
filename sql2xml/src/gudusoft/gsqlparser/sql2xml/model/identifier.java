
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class identifier
{

	@Element
	private actual_identifier actual_identifier;

	public actual_identifier getActual_identifier( )
	{
		return actual_identifier;
	}

	public void setActual_identifier( actual_identifier actual_identifier )
	{
		this.actual_identifier = actual_identifier;
	}

}
