
package gudusoft.gsqlparser.sql2xml.test;

import gudusoft.gsqlparser.EDbVendor;
import gudusoft.gsqlparser.sql2xml.generator.SQL2XMLGenerator;
import gudusoft.gsqlparser.sql2xml.generator.SQL2XMLGeneratorFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CodeGenerator
{

	public static void main( String[] args ) throws IOException
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
						fos.write( result.getBytes( ) );
						fos.close( );
					}
					catch ( Exception e )
					{
						e.printStackTrace( );
					}
				}
			}
		}
	}
}
