
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class computational_operation
{

	@Element(required = false)
	private String kw_avg;

	@Element(required = false)
	private String kw_max;

	@Element(required = false)
	private String kw_min;

	@Element(required = false)
	private String kw_sum;

	@Element(required = false)
	private String kw_every;

	@Element(required = false)
	private String kw_any;

	@Element(required = false)
	private String kw_some;

	@Element(required = false)
	private String kw_count;

	@Element(required = false)
	private String kw_stddev_pop;

	@Element(required = false)
	private String kw_stddev_samp;

	@Element(required = false)
	private String kw_var_samp;

	@Element(required = false)
	private String kw_var_pop;

	@Element(required = false)
	private String kw_collect;

	@Element(required = false)
	private String kw_fusion;

	@Element(required = false)
	private String kw_intersection;

	public String getKw_avg( )
	{
		return kw_avg;
	}

	public void setKw_avg( String kw_avg )
	{
		this.kw_avg = kw_avg;
	}

	public String getKw_max( )
	{
		return kw_max;
	}

	public void setKw_max( String kw_max )
	{
		this.kw_max = kw_max;
	}

	public String getKw_min( )
	{
		return kw_min;
	}

	public void setKw_min( String kw_min )
	{
		this.kw_min = kw_min;
	}

	public String getKw_sum( )
	{
		return kw_sum;
	}

	public void setKw_sum( String kw_sum )
	{
		this.kw_sum = kw_sum;
	}

	public String getKw_every( )
	{
		return kw_every;
	}

	public void setKw_every( String kw_every )
	{
		this.kw_every = kw_every;
	}

	public String getKw_any( )
	{
		return kw_any;
	}

	public void setKw_any( String kw_any )
	{
		this.kw_any = kw_any;
	}

	public String getKw_some( )
	{
		return kw_some;
	}

	public void setKw_some( String kw_some )
	{
		this.kw_some = kw_some;
	}

	public String getKw_count( )
	{
		return kw_count;
	}

	public void setKw_count( String kw_count )
	{
		this.kw_count = kw_count;
	}

	public String getKw_stddev_pop( )
	{
		return kw_stddev_pop;
	}

	public void setKw_stddev_pop( String kw_stddev_pop )
	{
		this.kw_stddev_pop = kw_stddev_pop;
	}

	public String getKw_stddev_samp( )
	{
		return kw_stddev_samp;
	}

	public void setKw_stddev_samp( String kw_stddev_samp )
	{
		this.kw_stddev_samp = kw_stddev_samp;
	}

	public String getKw_var_samp( )
	{
		return kw_var_samp;
	}

	public void setKw_var_samp( String kw_var_samp )
	{
		this.kw_var_samp = kw_var_samp;
	}

	public String getKw_var_pop( )
	{
		return kw_var_pop;
	}

	public void setKw_var_pop( String kw_var_pop )
	{
		this.kw_var_pop = kw_var_pop;
	}

	public String getKw_collect( )
	{
		return kw_collect;
	}

	public void setKw_collect( String kw_collect )
	{
		this.kw_collect = kw_collect;
	}

	public String getKw_fusion( )
	{
		return kw_fusion;
	}

	public void setKw_fusion( String kw_fusion )
	{
		this.kw_fusion = kw_fusion;
	}

	public String getKw_intersection( )
	{
		return kw_intersection;
	}

	public void setKw_intersection( String kw_intersection )
	{
		this.kw_intersection = kw_intersection;
	}

}
