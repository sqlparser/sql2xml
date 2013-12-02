
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class direct_sql_statement
{
	@Attribute
	private String xmlns="http://www.sqlparser.com/xml/ansi2003";
	
	@Attribute(name = "xmlns:xsi")
	private String namespace = "http://www.w3.org/2001/XMLSchema-instance";

	@Attribute(name = "xsi:schemaLocation")
	private String schemaLocation = "http://www.sqlparser.com/xml/ansi2003 http://sqlparser.com/xml/ansi2003/ansi2003.xsd";

	@Element
	private directly_executable_statement directly_executable_statement = new directly_executable_statement( );

	@Element
	private String semicolon = ";";

	public directly_executable_statement getDirectly_executable_statement( )
	{
		return directly_executable_statement;
	}

}
