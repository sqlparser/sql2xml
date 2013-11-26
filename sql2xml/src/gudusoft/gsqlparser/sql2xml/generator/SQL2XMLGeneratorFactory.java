
package gudusoft.gsqlparser.sql2xml.generator;

import gudusoft.gsqlparser.EDbVendor;
import gudusoft.gsqlparser.sql2xml.generator.ansi.AnsiGenerator;

public class SQL2XMLGeneratorFactory
{

	public static SQL2XMLGenerator getGenerator( EDbVendor vendor )
	{
		switch ( vendor )
		{
			case dbvansi :
				return new AnsiGenerator( );
		}

		return new AnsiGenerator( );
	}
}
