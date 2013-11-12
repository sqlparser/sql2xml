
package gudusoft.gsqlparser.sql2xml.model.gen;

import gudusoft.gsqlparser.sql2xml.model.gen.util.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CodeGenerator
{

	public static void main( String[] args )
	{
		try
		{
			InputStreamReader reader = new InputStreamReader( CodeGenerator.class.getResourceAsStream( "/XSDElementList" ) );
			BufferedReader br = new BufferedReader( reader );
			List<String> elementList = new ArrayList<String>( );
			String line = null;
			while ( ( line = br.readLine( ) ) != null )
			{
				elementList.add( line.trim( ) );
			}
			br.close( );
			reader.close( );

			for ( int i = 0; i < elementList.size( ); i++ )
			{
				InputStream inputStream = CodeGenerator.class.getResourceAsStream( "/XSDElementTemplate" );

				String element = elementList.get( i );

				File saveFile = new File( ".",
						"/src/gudusoft/gsqlparser/sql2xml/model/"
								+ element
								+ ".java" );
				FileUtil.replaceStream( inputStream,
						Pattern.quote( "{XSDElement}" ),
						Pattern.quote( "{XSDElement}" ),
						element,
						saveFile );
			}
		}
		catch ( IOException e )
		{
			e.printStackTrace( );
		}
	}
}
