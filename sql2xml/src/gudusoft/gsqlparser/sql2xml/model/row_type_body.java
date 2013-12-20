
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class row_type_body
{

	@ElementList(entry = "field_definition", inline = true)
	private List<field_definition> field_definition = new ArrayList<field_definition>( );

	public List<field_definition> getField_definition( )
	{
		return field_definition;
	}

}
