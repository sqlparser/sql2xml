
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

	
	static List<String> aggregateFunctions = new ArrayList<String>( );
	static
	{
		aggregateFunctions.add( "COUNT" );
		aggregateFunctions.add( "AVG" );
		aggregateFunctions.add( "MAX" );
		aggregateFunctions.add( "MIN" );
		aggregateFunctions.add( "SUM" );
		aggregateFunctions.add( "EVERY" );
		aggregateFunctions.add( "ANY" );
		aggregateFunctions.add( "SOME" );
		aggregateFunctions.add( "STDDEV_POP" );
		aggregateFunctions.add( "STDDEV_SAMP" );
		aggregateFunctions.add( "VAR_SAMP" );
		aggregateFunctions.add( "VAR_POP" );
		aggregateFunctions.add( "COLLECT" );
		aggregateFunctions.add( "FUSION" );
		aggregateFunctions.add( "INTERSECTION" );
		aggregateFunctions.add( "SORT" );
		aggregateFunctions.add( "CEIL" );
		aggregateFunctions.add( "CEILING" );
		aggregateFunctions.add( "WIDTH_BUCKET" );
	}

	public static boolean isAggregateFunction( String functionName )
	{
		for ( int i = 0; i < aggregateFunctions.size( ); i++ )
		{
			if ( aggregateFunctions.get( i ).equalsIgnoreCase( functionName ) )
			{
				return true;
			}
		}
		return false;
	}

	
	public static boolean isNumber( String string )
	{
		try
		{
			Integer.parseInt( string );
			return true;
		}
		catch ( NumberFormatException e )
		{
		}
		try
		{
			Float.parseFloat( string );
			return true;
		}
		catch ( NumberFormatException e )
		{
		}
		try
		{
			Double.parseDouble( string );
			return true;
		}
		catch ( NumberFormatException e )
		{
		}
		return false;
	}

	static List<String> stringValueFunctions = new ArrayList<String>( );
	static
	{
		stringValueFunctions.add( "SUBSTRING" );
		stringValueFunctions.add( "SUBSTRING_REGEX" );
		stringValueFunctions.add( "UPPER" );
		stringValueFunctions.add( "LOWER" );
		stringValueFunctions.add( "CONVERT" );
		stringValueFunctions.add( "TRANSLATE" );
		stringValueFunctions.add( "TRANSLATE_REGEX" );
		stringValueFunctions.add( "TRIM" );
		stringValueFunctions.add( "OVERLAY" );
		stringValueFunctions.add( "NORMALIZE" );
		stringValueFunctions.add( "SPECIFICTYPE" );
	}

	public static boolean isStringValueFunction( String functionName )
	{
		for ( int i = 0; i < stringValueFunctions.size( ); i++ )
		{
			if ( stringValueFunctions.get( i ).equalsIgnoreCase( functionName ) )
			{
				return true;
			}
		}
		return false;
	}

	public static boolean isString( String string )
	{
		if ( string != null
				&& string.startsWith( "'" )
				&& string.endsWith( "'" ) )
			return true;
		else if ( isNationalString( string ) )
			return true;
		return false;
	}

	public static boolean isNationalString( String string )
	{
		if ( string.toUpperCase( ).startsWith( "N'" ) && string.endsWith( "'" ) )
			return true;
		return false;
	}

	public static boolean isUnicodeString( String string )
	{
		return false;
	}
}
