
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root
@NamespaceList({
		@Namespace(reference = "http://www.sqlparser.com/xml/ansi2003"),
		@Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
})
public class direct_sql_statement
{

	@Element
	private directly_executable_statement directly_executable_statement = new directly_executable_statement( );

	@Element
	private String semicolon = ";";

	public directly_executable_statement getDirectly_executable_statement( )
	{
		return directly_executable_statement;
	}

}
