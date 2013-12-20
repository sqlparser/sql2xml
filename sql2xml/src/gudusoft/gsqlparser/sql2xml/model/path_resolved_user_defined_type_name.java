
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class path_resolved_user_defined_type_name
{

	@Element
	private user_defined_type_name user_defined_type_name = new user_defined_type_name( );

	public user_defined_type_name getUser_defined_type_name( )
	{
		return user_defined_type_name;
	}

}
