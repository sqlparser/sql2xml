
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class like_predicate
{

	@Element(required = false)
	private character_like_predicate character_like_predicate;

	@Element(required = false)
	private octet_like_predicate octet_like_predicate;

	public character_like_predicate getCharacter_like_predicate( )
	{
		return character_like_predicate;
	}

	public void setCharacter_like_predicate(
			character_like_predicate character_like_predicate )
	{
		this.character_like_predicate = character_like_predicate;
	}

	public octet_like_predicate getOctet_like_predicate( )
	{
		return octet_like_predicate;
	}

	public void setOctet_like_predicate(
			octet_like_predicate octet_like_predicate )
	{
		this.octet_like_predicate = octet_like_predicate;
	}

}
