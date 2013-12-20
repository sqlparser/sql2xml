
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class cast_target
{

	@Element(required = false)
	private domain_name domain_name;

	@Element(required = false)
	private data_type data_type;

	public domain_name getDomain_name( )
	{
		return domain_name;
	}

	public void setDomain_name( domain_name domain_name )
	{
		this.domain_name = domain_name;
	}

	public data_type getData_type( )
	{
		return data_type;
	}

	public void setData_type( data_type data_type )
	{
		this.data_type = data_type;
	}

}
