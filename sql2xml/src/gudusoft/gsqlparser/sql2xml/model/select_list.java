
package gudusoft.gsqlparser.sql2xml.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class select_list
{

	@Element(required = false)
	private String asterisk;

	@ElementList(entry = "select_sublist", inline = true, required = false)
	private List<select_sublist> select_sublist;

	public String getAsterisk( )
	{
		return asterisk;
	}

	public void setAsterisk( String asterisk )
	{
		this.asterisk = asterisk;
	}

	public List<select_sublist> getSelect_sublist( )
	{
		return select_sublist;
	}

	public void setSelect_sublist( List<select_sublist> select_sublist )
	{
		this.select_sublist = select_sublist;
	}

}
