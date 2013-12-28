
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class exact_numeric_type
{

	@Element(required = false)
	private numeric_with_precision_scale numeric_with_precision_scale;

	@Element(required = false)
	private decimal_with_precision_scale decimal_with_precision_scale;

	@Element(required = false)
	private dec_with_precision_scale dec_with_precision_scale;

	@Element(required = false)
	private String kw_smallint;

	@Element(required = false)
	private String kw_integer;

	@Element(required = false)
	private String kw_int;

	@Element(required = false)
	private String kw_bigint;

	public numeric_with_precision_scale getNumeric_with_precision_scale( )
	{
		return numeric_with_precision_scale;
	}

	public void setNumeric_with_precision_scale(
			numeric_with_precision_scale numeric_with_precision_scale )
	{
		this.numeric_with_precision_scale = numeric_with_precision_scale;
	}

	public decimal_with_precision_scale getDecimal_with_precision_scale( )
	{
		return decimal_with_precision_scale;
	}

	public void setDecimal_with_precision_scale(
			decimal_with_precision_scale decimal_with_precision_scale )
	{
		this.decimal_with_precision_scale = decimal_with_precision_scale;
	}

	public dec_with_precision_scale getDec_with_precision_scale( )
	{
		return dec_with_precision_scale;
	}

	public void setDec_with_precision_scale(
			dec_with_precision_scale dec_with_precision_scale )
	{
		this.dec_with_precision_scale = dec_with_precision_scale;
	}

	public String getKw_smallint( )
	{
		return kw_smallint;
	}

	public void setKw_smallint( String kw_smallint )
	{
		this.kw_smallint = kw_smallint;
	}

	public String getKw_integer( )
	{
		return kw_integer;
	}

	public void setKw_integer( String kw_integer )
	{
		this.kw_integer = kw_integer;
	}

	public String getKw_int( )
	{
		return kw_int;
	}

	public void setKw_int( String kw_int )
	{
		this.kw_int = kw_int;
	}

	public String getKw_bigint( )
	{
		return kw_bigint;
	}

	public void setKw_bigint( String kw_bigint )
	{
		this.kw_bigint = kw_bigint;
	}

}
