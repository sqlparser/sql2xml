
package gudusoft.gsqlparser.sql2xml.generator.ansi;

import gudusoft.gsqlparser.TCustomSqlStatement;
import gudusoft.gsqlparser.stmt.TDeleteSqlStatement;
import gudusoft.gsqlparser.stmt.TInsertSqlStatement;
import gudusoft.gsqlparser.stmt.TMergeSqlStatement;
import gudusoft.gsqlparser.stmt.TSelectSqlStatement;
import gudusoft.gsqlparser.stmt.TUpdateSqlStatement;

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
}
