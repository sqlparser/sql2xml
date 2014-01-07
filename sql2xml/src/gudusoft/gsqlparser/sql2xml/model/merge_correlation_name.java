
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class merge_correlation_name
{

	@Element
	private correlation_name correlation_name = new correlation_name( );

	public correlation_name getCorrelation_name( )
	{
		return correlation_name;
	}

}
