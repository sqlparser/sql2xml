
package gudusoft.gsqlparser.sql2xml.test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLValidator
{

	public static class DTDEntityResolver implements EntityResolver
	{

		public InputSource resolveEntity( String publicId, String systemId )
				throws SAXException, IOException
		{
			return new InputSource( "E:\\git\\sql2xml\\sql2xml-test\\dtd\\ansi2003.xsd" );
		}
	}

	public static void main( String[] args ) throws IOException
	{
		File testBaseDir = new File( "./testcases" );
		File[] testcases = testBaseDir.listFiles( );
		for ( int i = 0; i < testcases.length; i++ )
		{
			File testcase = testcases[i];
			String caseName = testcase.getName( );
			if ( caseName.toLowerCase( ).endsWith( ".xml" ) )
			{
				try
				{
					URL schemaFile = new File( ".\\dtd\\ansi2003.xsd" ).toURI( )
							.toURL( );
					Source xmlFile = new StreamSource( testcase );
					SchemaFactory schemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
					Schema schema = schemaFactory.newSchema( schemaFile );
					Validator validator = schema.newValidator( );
					try
					{
						validator.validate( xmlFile );
						System.out.println( xmlFile.getSystemId( )
								+ " is valid" );
					}
					catch ( SAXException e )
					{
						System.out.println( xmlFile.getSystemId( )
								+ " is NOT valid" );
						System.out.println( "Reason: "
								+ e.getLocalizedMessage( ) );
					}
				}
				catch ( SAXException e )
				{
					e.printStackTrace( );
				}
			}
		}
	}
}
