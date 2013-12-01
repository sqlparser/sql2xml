
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class transcoding
{

	@Element
	private String kw_convert = "convert";

	@Element
	character_value_expression character_value_expression = new character_value_expression( );

	@Element
	private String kw_using = "using";

	@Element
	transcoding_name transcoding_name = new transcoding_name( );

	public character_value_expression getCharacter_value_expression( )
	{
		return character_value_expression;
	}

	public transcoding_name getTranscoding_name( )
	{
		return transcoding_name;
	}

}
