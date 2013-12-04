
package gudusoft.gsqlparser.sql2xml.test;

import gudusoft.gsqlparser.EDbVendor;
import gudusoft.gsqlparser.sql2xml.generator.SQL2XMLGenerator;
import gudusoft.gsqlparser.sql2xml.generator.SQL2XMLGeneratorFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import junit.framework.TestCase;

import org.xml.sax.SAXException;

public class XMLGeneratorTester extends TestCase
{

	protected void setUp( ) throws Exception
	{
		File testBaseDir = new File( "./testcases" );
		File[] testcases = testBaseDir.listFiles( );
		SQL2XMLGenerator generator = SQL2XMLGeneratorFactory.getGenerator( EDbVendor.dbvansi );
		for ( int i = 0; i < testcases.length; i++ )
		{
			File testcase = testcases[i];
			String caseName = testcase.getName( );
			if ( caseName.toLowerCase( ).endsWith( ".sql" ) )
			{
				String result = generator.generateXML( testcase );
				if ( result == null )
				{
					System.err.println( generator.getErrorMessage( ) );
				}
				else
				{
					int index = caseName.lastIndexOf( '.' );
					try
					{
						FileOutputStream fos = new FileOutputStream( new File( testBaseDir,
								caseName.substring( 0, index ) + ".xml" ) );
						OutputStreamWriter writer = new OutputStreamWriter( fos,
								"UTF-8" );
						writer.write( result );
						writer.close( );
					}
					catch ( Exception e )
					{
						e.printStackTrace( );
					}
				}
			}
		}
	}

	public void testValidation( )
	{
		File testBaseDir = new File( "./testcases" );
		File[] testcases = testBaseDir.listFiles( );
		for ( int i = 0; i < testcases.length; i++ )
		{
			String caseName = testcases[i].getName( );
			if ( caseName.toLowerCase( ).endsWith( ".xml" ) )
			{
				assertTrue( validateXMLFile( testcases[i] ) );
			}
		}
	}

	private boolean validateXMLFile( File testcase )
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
				System.out.println( xmlFile.getSystemId( ) + " is valid" );
				return true;
			}
			catch ( SAXException e )
			{
				System.out.println( xmlFile.getSystemId( ) + " is NOT valid" );
				System.out.println( "Reason: " + e.getLocalizedMessage( ) );
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace( );
		}

		return false;
	}
}
