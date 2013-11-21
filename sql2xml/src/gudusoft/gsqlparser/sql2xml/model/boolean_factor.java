
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class boolean_factor
{

	@Element(required = false)
	private String kw_not;

	@Element
	private boolean_test boolean_test = new boolean_test( );

	public String getKw_not( )
	{
		return kw_not;
	}

	public void setKw_not( String kw_not )
	{
		this.kw_not = kw_not;
	}

	public boolean_test getBoolean_test( )
	{
		return boolean_test;
	}

}
