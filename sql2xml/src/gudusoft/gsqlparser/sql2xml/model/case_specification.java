
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class case_specification
{

	@Element(required = false)
	private simple_case simple_case;

	@Element(required = false)
	private searched_case searched_case;

	public simple_case getSimple_case( )
	{
		return simple_case;
	}

	public void setSimple_case( simple_case simple_case )
	{
		this.simple_case = simple_case;
	}

	public searched_case getSearched_case( )
	{
		return searched_case;
	}

	public void setSearched_case( searched_case searched_case )
	{
		this.searched_case = searched_case;
	}

}
