
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class referencing_columns
{

	@Element
	private reference_column_list reference_column_list = new reference_column_list( );

	public reference_column_list getReference_column_list( )
	{
		return reference_column_list;
	}

}
