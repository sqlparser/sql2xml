
package gudusoft.gsqlparser.sql2xml.generator;

import gudusoft.gsqlparser.EDbVendor;

import java.io.File;

public interface SQL2XMLGenerator
{

	String generateXML( EDbVendor vendor, String sql );

	String generateXML( String sql );

	String generateXML( EDbVendor vendor, File file );

	String generateXML( File file );

	String getErrorMessage( );

}
