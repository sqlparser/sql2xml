
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class referential_constraint_definition
{

	@Element
	private String kw_foreign = "foreign";

	@Element
	private String kw_key = "key";

	@Element
	private referencing_columns referencing_columns = new referencing_columns( );

	@Element
	private references_specification references_specification = new references_specification( );

	public referencing_columns getReferencing_columns( )
	{
		return referencing_columns;
	}

	public references_specification getReferences_specification( )
	{
		return references_specification;
	}

}
