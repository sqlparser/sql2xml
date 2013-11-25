
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class unsigned_value_specification
{

	@Element(required = false)
	private unsigned_literal unsigned_literal;

	@Element(required = false)
	private general_value_specification general_value_specification;

	public unsigned_literal getUnsigned_literal( )
	{
		return unsigned_literal;
	}

	public void setUnsigned_literal( unsigned_literal unsigned_literal )
	{
		this.unsigned_literal = unsigned_literal;
	}

	public general_value_specification getGeneral_value_specification( )
	{
		return general_value_specification;
	}

	public void setGeneral_value_specification(
			general_value_specification general_value_specification )
	{
		this.general_value_specification = general_value_specification;
	}

}
