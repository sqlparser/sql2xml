
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class approximate_numeric_type
{

	@Element(required = false)
	private float_with_precision float_with_precision;

	@Element(required = false)
	private String kw_real;

	@Element(required = false)
	private String kw_double_precision;

	public float_with_precision getFloat_with_precision( )
	{
		return float_with_precision;
	}

	public void setFloat_with_precision(
			float_with_precision float_with_precision )
	{
		this.float_with_precision = float_with_precision;
	}

	public String getKw_real( )
	{
		return kw_real;
	}

	public void setKw_real( String kw_real )
	{
		this.kw_real = kw_real;
	}

	public String getKw_double_precision( )
	{
		return kw_double_precision;
	}

	public void setKw_double_precision( String kw_double_precision )
	{
		this.kw_double_precision = kw_double_precision;
	}

}
