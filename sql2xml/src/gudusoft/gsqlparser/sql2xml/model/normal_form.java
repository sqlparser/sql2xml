
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class normal_form
{

	@Element(required = false)
	private String kw_nfc;

	@Element(required = false)
	private String kw_nfd;

	@Element(required = false)
	private String kw_nfkc;

	@Element(required = false)
	private String kw_nfkd;

	public String getKw_nfc( )
	{
		return kw_nfc;
	}

	public void setKw_nfc( String kw_nfc )
	{
		this.kw_nfc = kw_nfc;
	}

	public String getKw_nfd( )
	{
		return kw_nfd;
	}

	public void setKw_nfd( String kw_nfd )
	{
		this.kw_nfd = kw_nfd;
	}

	public String getKw_nfkc( )
	{
		return kw_nfkc;
	}

	public void setKw_nfkc( String kw_nfkc )
	{
		this.kw_nfkc = kw_nfkc;
	}

	public String getKw_nfkd( )
	{
		return kw_nfkd;
	}

	public void setKw_nfkd( String kw_nfkd )
	{
		this.kw_nfkd = kw_nfkd;
	}

}
