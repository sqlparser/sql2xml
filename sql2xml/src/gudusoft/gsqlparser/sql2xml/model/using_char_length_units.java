
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class using_char_length_units
{

	@Element
	private String kw_using = "using";

	@Element
	private char_length_units char_length_units = new char_length_units( );

	public char_length_units getChar_length_units( )
	{
		return char_length_units;
	}

}
