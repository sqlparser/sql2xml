
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class referential_action
{

	@Element(required = false)
	private String kw_cascade;

	@Element(required = false)
	private set_null set_null;

	@Element(required = false)
	private set_default set_default;

	@Element(required = false)
	private String kw_restrict;

	@Element(required = false)
	private no_action no_action;

	public String getKw_cascade( )
	{
		return kw_cascade;
	}

	public void setKw_cascade( String kw_cascade )
	{
		this.kw_cascade = kw_cascade;
	}

	public set_null getSet_null( )
	{
		return set_null;
	}

	public void setSet_null( set_null set_null )
	{
		this.set_null = set_null;
	}

	public set_default getSet_default( )
	{
		return set_default;
	}

	public void setSet_default( set_default set_default )
	{
		this.set_default = set_default;
	}

	public String getKw_restrict( )
	{
		return kw_restrict;
	}

	public void setKw_restrict( String kw_restrict )
	{
		this.kw_restrict = kw_restrict;
	}

	public no_action getNo_action( )
	{
		return no_action;
	}

	public void setNo_action( no_action no_action )
	{
		this.no_action = no_action;
	}

}
