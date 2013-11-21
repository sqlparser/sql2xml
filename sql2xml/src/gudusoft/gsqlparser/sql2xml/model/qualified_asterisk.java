
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class qualified_asterisk
{

	@Element(required = false)
	private asterisked_identifier_chain_asterisk asterisked_identifier_chain_asterisk;

	@Element(required = false)
	private all_fields_reference all_fields_reference;

	
	public asterisked_identifier_chain_asterisk getAsterisked_identifier_chain_asterisk( )
	{
		return asterisked_identifier_chain_asterisk;
	}

	
	public void setAsterisked_identifier_chain_asterisk(
			asterisked_identifier_chain_asterisk asterisked_identifier_chain_asterisk )
	{
		this.asterisked_identifier_chain_asterisk = asterisked_identifier_chain_asterisk;
	}

	
	public all_fields_reference getAll_fields_reference( )
	{
		return all_fields_reference;
	}

	
	public void setAll_fields_reference(
			all_fields_reference all_fields_reference )
	{
		this.all_fields_reference = all_fields_reference;
	}

	
}
