
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class table_element_list
{

	@ElementList(entry = "table_element", inline = true)
	private List<table_element> table_element = new ArrayList<table_element>( );

	public List<table_element> getTable_element( )
	{
		return table_element;
	}

}
