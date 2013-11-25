
package gudusoft.gsqlparser.sql2xml.generator.ansi;

import gudusoft.gsqlparser.TCustomSqlStatement;
import gudusoft.gsqlparser.stmt.TDeleteSqlStatement;
import gudusoft.gsqlparser.stmt.TInsertSqlStatement;
import gudusoft.gsqlparser.stmt.TMergeSqlStatement;
import gudusoft.gsqlparser.stmt.TSelectSqlStatement;
import gudusoft.gsqlparser.stmt.TUpdateSqlStatement;

import java.util.ArrayList;
import java.util.List;

public class Utility
{

	public static boolean isDirect_sql_data_statement( TCustomSqlStatement stmt )
	{
		if ( stmt instanceof TSelectSqlStatement
				|| stmt instanceof TInsertSqlStatement
				|| stmt instanceof TUpdateSqlStatement
				|| stmt instanceof TDeleteSqlStatement
				|| stmt instanceof TMergeSqlStatement )
			return true;
		return false;
	}

	static List<String> numericValueFunctions = new ArrayList<String>( );
	static
	{
		numericValueFunctions.add( "POSITION" );
		numericValueFunctions.add( "OCCURRENCES_REGEX" );
		numericValueFunctions.add( "POSITION_REGEX" );
		numericValueFunctions.add( "EXTRACT" );
		numericValueFunctions.add( "CHAR_LENGTH" );
		numericValueFunctions.add( "CHARACTER_LENGTH" );
		numericValueFunctions.add( "OCTET_LENGTH" );
		numericValueFunctions.add( "CARDINALITY" );
		numericValueFunctions.add( "ABS" );
		numericValueFunctions.add( "MOD" );
		numericValueFunctions.add( "LN" );
		numericValueFunctions.add( "EXP" );
		numericValueFunctions.add( "POWER" );
		numericValueFunctions.add( "SORT" );
		numericValueFunctions.add( "FLOOR" );
		numericValueFunctions.add( "SORT" );
		numericValueFunctions.add( "CEIL" );
		numericValueFunctions.add( "CEILING" );
		numericValueFunctions.add( "WIDTH_BUCKET" );
	}

	public static boolean isNumericValueFunction( String functionName )
	{
		for ( int i = 0; i < numericValueFunctions.size( ); i++ )
		{
			if ( numericValueFunctions.get( i ).equalsIgnoreCase( functionName ) )
			{
				return true;
			}
		}
		return false;
	}

	public static boolean isNumber( String string )
	{
		// TODO Auto-generated method stub
		return false;
	}
}
