
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class case_expression
{

	@Element(required = false)
	private case_abbreviation case_abbreviation;

	@Element(required = false)
	private case_specification case_specification;

	public case_abbreviation getCase_abbreviation( )
	{
		return case_abbreviation;
	}

	public void setCase_abbreviation( case_abbreviation case_abbreviation )
	{
		this.case_abbreviation = case_abbreviation;
	}

	public case_specification getCase_specification( )
	{
		return case_specification;
	}

	public void setCase_specification( case_specification case_specification )
	{
		this.case_specification = case_specification;
	}

}
