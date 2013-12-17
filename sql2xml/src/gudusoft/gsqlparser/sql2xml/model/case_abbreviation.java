
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class case_abbreviation
{

	@Element(required = false)
	private nullif nullif;

	@Element(required = false)
	private coalesce coalesce;

	public nullif getNullif( )
	{
		return nullif;
	}

	public void setNullif( nullif nullif )
	{
		this.nullif = nullif;
	}

	public coalesce getCoalesce( )
	{
		return coalesce;
	}

	public void setCoalesce( coalesce coalesce )
	{
		this.coalesce = coalesce;
	}

}
