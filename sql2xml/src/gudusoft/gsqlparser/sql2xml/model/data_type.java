
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class data_type
{

	@Element(required = false)
	private predefined_type predefined_type;

	@Element(required = false)
	private row_type row_type;

	@Element(required = false)
	private path_resolved_user_defined_type_name path_resolved_user_defined_type_name;

	@Element(required = false)
	private reference_type reference_type;

	@Element(required = false)
	private collection_type collection_type;

	public predefined_type getPredefined_type( )
	{
		return predefined_type;
	}

	public void setPredefined_type( predefined_type predefined_type )
	{
		this.predefined_type = predefined_type;
	}

	public row_type getRow_type( )
	{
		return row_type;
	}

	public void setRow_type( row_type row_type )
	{
		this.row_type = row_type;
	}

	public path_resolved_user_defined_type_name getPath_resolved_user_defined_type_name( )
	{
		return path_resolved_user_defined_type_name;
	}

	public void setPath_resolved_user_defined_type_name(
			path_resolved_user_defined_type_name path_resolved_user_defined_type_name )
	{
		this.path_resolved_user_defined_type_name = path_resolved_user_defined_type_name;
	}

	public reference_type getReference_type( )
	{
		return reference_type;
	}

	public void setReference_type( reference_type reference_type )
	{
		this.reference_type = reference_type;
	}

	public collection_type getCollection_type( )
	{
		return collection_type;
	}

	public void setCollection_type( collection_type collection_type )
	{
		this.collection_type = collection_type;
	}

}
