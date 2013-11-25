
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class unsigned_literal
{

	@Element(required = false)
	private unsigned_numeric_literal unsigned_numeric_literal;

	@Element(required = false)
	private general_literal general_literal;

	public unsigned_numeric_literal getUnsigned_numeric_literal( )
	{
		return unsigned_numeric_literal;
	}

	public void setUnsigned_numeric_literal(
			unsigned_numeric_literal unsigned_numeric_literal )
	{
		this.unsigned_numeric_literal = unsigned_numeric_literal;
	}

	public general_literal getGeneral_literal( )
	{
		return general_literal;
	}

	public void setGeneral_literal( general_literal general_literal )
	{
		this.general_literal = general_literal;
	}

}
