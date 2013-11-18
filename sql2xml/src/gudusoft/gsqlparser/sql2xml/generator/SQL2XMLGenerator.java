
package gudusoft.gsqlparser.sql2xml.generator;

import gudusoft.gsqlparser.EDbVendor;

public interface SQL2XMLGenerator
{

	String generateXML( EDbVendor vendor, String sql );

	String generateXML( String sql );

	String getErrorMessage( );

}
