
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class large_object_length_token
{

	@ElementList(entry = "digit", inline = true)
	private List<Integer> digit = new ArrayList<Integer>( );

	@Element
	private String multiplier;

	public String getMultiplier( )
	{
		return multiplier;
	}

	public void setMultiplier( String multiplier )
	{
		this.multiplier = multiplier;
	}

	public List<Integer> getDigit( )
	{
		return digit;
	}

}
