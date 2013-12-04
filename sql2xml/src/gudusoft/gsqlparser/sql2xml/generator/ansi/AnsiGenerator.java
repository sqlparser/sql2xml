
package gudusoft.gsqlparser.sql2xml.generator.ansi;

import gudusoft.gsqlparser.EAggregateType;
import gudusoft.gsqlparser.EDbVendor;
import gudusoft.gsqlparser.EExpressionType;
import gudusoft.gsqlparser.TBaseType;
import gudusoft.gsqlparser.TCustomSqlStatement;
import gudusoft.gsqlparser.TGSqlParser;
import gudusoft.gsqlparser.TSourceToken;
import gudusoft.gsqlparser.TStatementList;
import gudusoft.gsqlparser.nodes.TAliasClause;
import gudusoft.gsqlparser.nodes.TCTEList;
import gudusoft.gsqlparser.nodes.TExpression;
import gudusoft.gsqlparser.nodes.TForUpdate;
import gudusoft.gsqlparser.nodes.TFunctionCall;
import gudusoft.gsqlparser.nodes.TGroupBy;
import gudusoft.gsqlparser.nodes.TGroupByItem;
import gudusoft.gsqlparser.nodes.TJoin;
import gudusoft.gsqlparser.nodes.TJoinItem;
import gudusoft.gsqlparser.nodes.TJoinItemList;
import gudusoft.gsqlparser.nodes.TObjectName;
import gudusoft.gsqlparser.nodes.TOrderBy;
import gudusoft.gsqlparser.nodes.TOrderByItem;
import gudusoft.gsqlparser.nodes.TOrderByItemList;
import gudusoft.gsqlparser.nodes.TResultColumn;
import gudusoft.gsqlparser.nodes.TRollupCube;
import gudusoft.gsqlparser.nodes.TTable;
import gudusoft.gsqlparser.nodes.TWhereClause;
import gudusoft.gsqlparser.sql2xml.generator.SQL2XMLGenerator;
import gudusoft.gsqlparser.sql2xml.model.*;
import gudusoft.gsqlparser.stmt.TDeleteSqlStatement;
import gudusoft.gsqlparser.stmt.TInsertSqlStatement;
import gudusoft.gsqlparser.stmt.TMergeSqlStatement;
import gudusoft.gsqlparser.stmt.TSelectSqlStatement;
import gudusoft.gsqlparser.stmt.TUpdateSqlStatement;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

public class AnsiGenerator implements SQL2XMLGenerator
{

	private String errorMessage;

	public String generateXML( EDbVendor vendor, String sql )
	{
		errorMessage = null;
		TGSqlParser sqlparser = new TGSqlParser( vendor );
		sqlparser.sqltext = sql;
		int resultCode = sqlparser.parse( );
		if ( resultCode != 0 )
		{
			errorMessage = sqlparser.getErrormessage( );
			return null;
		}
		else
			return convertSQL2XML( sqlparser );
	}

	public String generateXML( String sql )
	{
		errorMessage = null;
		TGSqlParser sqlparser = new TGSqlParser( EDbVendor.dbvansi );
		sqlparser.sqltext = sql;
		int resultCode = sqlparser.parse( );
		if ( resultCode != 0 )
		{
			errorMessage = sqlparser.getErrormessage( );
			return null;
		}
		else
			return convertSQL2XML( sqlparser );
	}

	public String generateXML( EDbVendor vendor, File sqlFile )
	{
		errorMessage = null;
		TGSqlParser sqlparser = new TGSqlParser( vendor );
		sqlparser.sqlfilename = sqlFile.getAbsolutePath( );
		int resultCode = sqlparser.parse( );
		if ( resultCode != 0 )
		{
			errorMessage = sqlparser.getErrormessage( );
			return null;
		}
		else
			return convertSQL2XML( sqlparser );
	}

	public String generateXML( File sqlFile )
	{
		errorMessage = null;
		TGSqlParser sqlparser = new TGSqlParser( EDbVendor.dbvansi );
		sqlparser.sqlfilename = sqlFile.getAbsolutePath( );
		int resultCode = sqlparser.parse( );
		if ( resultCode != 0 )
		{
			errorMessage = sqlparser.getErrormessage( );
			return null;
		}
		else
			return convertSQL2XML( sqlparser );
	}

	protected String convertSQL2XML( TGSqlParser sqlparser )
	{
		StringBuffer buffer = new StringBuffer( );
		TStatementList stmts = sqlparser.getSqlstatements( );
		for ( int i = 0; i < stmts.size( ); i++ )
		{
			direct_sql_statement directSqlStatement = new direct_sql_statement( );
			convertStmt2Model( stmts.get( i ),
					directSqlStatement.getDirectly_executable_statement( ) );

			try
			{
				Serializer serializer = new Persister( new Format( "<?xml version=\"1.0\" encoding= \"UTF-8\" ?>" ) );
				StringWriter sw = new StringWriter( );
				serializer.write( directSqlStatement, sw );
				sw.close( );
				buffer.append( sw.toString( ) );
			}
			catch ( Exception e )
			{
				e.printStackTrace( );
			}
		}
		return buffer.toString( );
	}

	protected void convertStmt2Model( TCustomSqlStatement stmt,
			directly_executable_statement directlyExecutableStatement )
	{
		if ( Utility.isDirect_sql_data_statement( stmt ) )
		{
			direct_sql_data_statement directSqlDataStatement = new direct_sql_data_statement( );
			directlyExecutableStatement.setDirect_sql_data_statement( directSqlDataStatement );

			if ( stmt instanceof TSelectSqlStatement )
			{
				TSelectSqlStatement select = (TSelectSqlStatement) stmt;
				direct_select_statement_multiple_rows directSelectStatementMultipleRows = new direct_select_statement_multiple_rows( );
				directSqlDataStatement.setDirect_select_statement_multiple_rows( directSelectStatementMultipleRows );
				convertSelectStmt2Model( select,
						directSelectStatementMultipleRows );
			}
			else if ( stmt instanceof TInsertSqlStatement )
			{
				TInsertSqlStatement insert = (TInsertSqlStatement) stmt;
				insert_statement insertStatement = new insert_statement( );
				directSqlDataStatement.setInsert_statement( insertStatement );
				convertInsertStmt2Model( insert, insertStatement );
			}
			else if ( stmt instanceof TUpdateSqlStatement )
			{
				TUpdateSqlStatement update = (TUpdateSqlStatement) stmt;
				update_statement_searched updateStatementSearched = new update_statement_searched( );
				directSqlDataStatement.setUpdate_statement_searched( updateStatementSearched );
				convertUpdateStmt2Model( update, updateStatementSearched );
			}
			else if ( stmt instanceof TDeleteSqlStatement )
			{
				TDeleteSqlStatement delete = (TDeleteSqlStatement) stmt;
				delete_statement_searched deleteStatementSearched = new delete_statement_searched( );
				directSqlDataStatement.setDelete_statement_searched( deleteStatementSearched );
				convertDeleteStmt2Model( delete, deleteStatementSearched );
			}
			else if ( stmt instanceof TMergeSqlStatement )
			{
				TMergeSqlStatement merge = (TMergeSqlStatement) stmt;
				merge_statement mergeStatement = new merge_statement( );
				directSqlDataStatement.setMerge_statement( mergeStatement );
				convertMergeStmt2Model( merge, mergeStatement );
			}
		}
	}

	private void convertSelectStmt2Model(
			TSelectSqlStatement select,
			direct_select_statement_multiple_rows directSelectStatementMultipleRows )
	{
		cursor_specification cursorSpecification = directSelectStatementMultipleRows.getCursor_specification( );

		query_expression queryExpression = cursorSpecification.getQuery_expression( );

		convertSelectToQueryExpression( select, queryExpression );

		if ( select.getOrderbyClause( ) != null )
		{
			order_by_clause orderByClause = new order_by_clause( );
			cursorSpecification.setOrder_by_clause( orderByClause );
			convertOrderbyClause2Model( select.getOrderbyClause( ),
					orderByClause );
		}

		if ( select.getForUpdateClause( ) != null )
		{
			updatability_clause updatabilityClause = new updatability_clause( );
			cursorSpecification.setUpdatability_clause( updatabilityClause );
			convertForUpdateClause2Model( select.getForUpdateClause( ),
					updatabilityClause );
		}
	}

	private void convertSelectToQueryExpression( TSelectSqlStatement select,
			query_expression queryExpression )
	{
		if ( select.getCteList( ) != null )
		{
			with_clause withClause = new with_clause( );
			queryExpression.setWith_clause( withClause );
			convertWithClause2Model( select.getCteList( ), withClause );
		}

		query_expression_body queryExpreesionBody = queryExpression.getQuery_expression_body( );

		convertSelectToQueryExpressionBody( select, queryExpreesionBody );
	}

	private void convertSelectToQueryExpressionBody(
			TSelectSqlStatement select,
			query_expression_body queryExpreesionBody )
	{

		if ( select.getSetOperator( ) == TSelectSqlStatement.setOperator_union
				|| select.getSetOperator( ) == TSelectSqlStatement.setOperator_unionall )
		{
			query_expression_body_union queryExpreesionBodyUnion = new query_expression_body_union( );
			queryExpreesionBody.setQuery_expression_body_union( queryExpreesionBodyUnion );
			convertSelectToQueryExpreesionBodyUnion( select,
					queryExpreesionBodyUnion );
		}
		else if ( select.getSetOperator( ) == TSelectSqlStatement.setOperator_except
				|| select.getSetOperator( ) == TSelectSqlStatement.setOperator_exceptall )
		{
			query_expression_body_except queryExpreesionBodyExcept = new query_expression_body_except( );
			queryExpreesionBody.setQuery_expression_body_except( queryExpreesionBodyExcept );
			convertSelectToQueryExpreesionBodyExcept( select,
					queryExpreesionBodyExcept );
		}
		else
		{
			query_term queryTerm = new query_term( );
			queryExpreesionBody.setQuery_term( queryTerm );
			convertSelectToQueryTerm( select, queryTerm );
		}
	}

	private void convertSelectToQueryTerm( TSelectSqlStatement select,
			query_term queryTerm )
	{
		if ( select.getSetOperator( ) == TSelectSqlStatement.setOperator_intersect
				|| select.getSetOperator( ) == TSelectSqlStatement.setOperator_intersectall )
		{
			query_expression_body_intersect queryExpreesionBodyIntersect = new query_expression_body_intersect( );
			queryTerm.setQuery_expression_body_intersect( queryExpreesionBodyIntersect );
			convertSelectToQueryExpressionBodyIntersect( select,
					queryExpreesionBodyIntersect );
		}
		else
		{
			query_primary queryPrimary = new query_primary( );
			queryTerm.setQuery_primary( queryPrimary );
			convertSelectToQueryPrimary( select, queryPrimary );
		}
	}

	private void convertSelectToQueryPrimary( TSelectSqlStatement select,
			query_primary queryPrimary )
	{
		if ( select.getSetOperator( ) == TSelectSqlStatement.setOperator_none )
		{
			simple_table simpleTable = new simple_table( );
			queryPrimary.setSimple_table( simpleTable );
			convertSelectToSimpleTable( select, simpleTable );
		}
		else
		{
			query_expression_body queryExpressionBody = new query_expression_body( );
			queryPrimary.setQuery_expression_body( queryExpressionBody );
			convertSelectToQueryExpressionBody( select, queryExpressionBody );
		}
	}

	private void convertSelectToSimpleTable( TSelectSqlStatement select,
			simple_table simpleTable )
	{
		query_specification querySpecfication = new query_specification( );
		simpleTable.setQuery_specification( querySpecfication );
		convertSelectToQuerySpecification( select, querySpecfication );
	}

	private void convertSelectToQuerySpecification( TSelectSqlStatement select,
			query_specification querySpecfication )
	{
		if ( select.getSelectDistinct( ) != null )
		{
			set_quantifier setQuantifier = new set_quantifier( );
			querySpecfication.setSet_quantifier( setQuantifier );
			setQuantifier.setKw_distinct( "distinct" );
		}

		select_list selectList = querySpecfication.getSelect_list( );
		convertSelectToSelectList( select, selectList );

		table_expression tableExpression = querySpecfication.getTable_expression( );
		convertSelectToTableExpression( select, tableExpression );
	}

	private void convertSelectToTableExpression( TSelectSqlStatement select,
			table_expression tableExpression )
	{
		from_clause from_clause = tableExpression.getFrom_clause( );
		List<table_reference> tableReferences = from_clause.getTable_reference( );
		for ( int i = 0; i < select.joins.size( ); i++ )
		{
			table_reference tableReference = new table_reference( );
			tableReferences.add( tableReference );
			TJoin join = select.joins.getJoin( i );
			TTable table = join.getTable( );
			TJoinItemList items = join.getJoinItems( );
			if ( items != null && items.size( ) > 0 )
			{
				for ( int j = 0; j < items.size( ); j++ )
				{
					TJoinItem item = items.getJoinItem( j );
					TTable joinTable = item.getTable( );
				}
				// TODO Auto-generated method stub
			}
			else
			{
				table_factor tableFactor = new table_factor( );
				tableReference.setTable_factor( tableFactor );
				convertTableToTableFactor( table, tableFactor );
			}
		}

		if ( select.getWhereClause( ) != null
				&& select.getWhereClause( ).getCondition( ) != null )
		{
			where_clause whereClause = new where_clause( );
			tableExpression.setWhere_clause( whereClause );
			convertWhereConditionToModel( select.getWhereClause( ), whereClause );
		}

		if ( select.getGroupByClause( ) != null
				&& select.getGroupByClause( ).getItems( ) != null )
		{
			group_by_clause groupByClause = new group_by_clause( );
			tableExpression.setGroup_by_clause( groupByClause );
			convertGroupByClauseToModel( select.getGroupByClause( ),
					groupByClause );
		}

		if ( select.getGroupByClause( ) != null
				&& select.getGroupByClause( ).getHavingClause( ) != null )
		{
			having_clause havingClause = new having_clause( );
			tableExpression.setHaving_clause( havingClause );
			convertHavingClauseToModel( select.getGroupByClause( )
					.getHavingClause( ), havingClause );
		}
	}

	private void convertHavingClauseToModel( TExpression havingClause,
			having_clause havingClauseModel )
	{
		convertBooleanExpressionToModel( havingClause,
				havingClauseModel.getSearch_condition( )
						.getBoolean_value_expression( ) );

	}

	private void convertGroupByClauseToModel( TGroupBy groupByClause,
			group_by_clause groupByClauseModel )
	{
		if ( groupByClause.getItems( ).size( ) > 0 )
		{
			if ( SourceTokenSearcher.indexOf( groupByClause.getStartToken( ).container,
					groupByClause.getStartToken( ).posinlist,
					groupByClause.getItems( )
							.getGroupByItem( 0 )
							.getStartToken( ).posinlist,
					"ALL" ) != -1 )
			{
				set_quantifier setQuantifier = new set_quantifier( );
				setQuantifier.setKw_all( "all" );
				groupByClauseModel.setSet_quantifier( setQuantifier );
			}
		}

		List<grouping_element> groupingElements = groupByClauseModel.getGrouping_element_list( )
				.getGrouping_element( );
		for ( int i = 0; i < groupByClause.getItems( ).size( ); i++ )
		{
			TGroupByItem item = groupByClause.getItems( ).getGroupByItem( i );
			grouping_element groupingElement = new grouping_element( );
			groupingElements.add( groupingElement );
			convertGroupItemToModel( item, groupingElement );
		}
	}

	private void convertGroupItemToModel( TGroupByItem item,
			grouping_element groupingElement )
	{
		if ( item.getRollupCube( ) != null )
		{

		}
		else if ( item.getGroupingSet( ) != null )
		{

		}
		else
		{
			ordinary_grouping_set ordinaryGroupingSet = new ordinary_grouping_set( );
			groupingElement.setOrdinary_grouping_set( ordinaryGroupingSet );
			convertGroupItemToOrdinaryGroupingSet( item, ordinaryGroupingSet );
		}
	}

	private void convertGroupItemToOrdinaryGroupingSet( TGroupByItem item,
			ordinary_grouping_set ordinaryGroupingSet )
	{
		String groupItemString = item.toString( ).trim( );
		if ( groupItemString.startsWith( "(" )
				&& groupItemString.endsWith( ")" ) )
		{
			grouping_column_reference_list_with_paren groupingColumnReferenceListWithParen = new grouping_column_reference_list_with_paren( );
			ordinaryGroupingSet.setGrouping_column_reference_list_with_paren( groupingColumnReferenceListWithParen );
			List<grouping_column_reference> groupingColumnReferences = groupingColumnReferenceListWithParen.getGrouping_column_reference_list( )
					.getGrouping_column_reference( );
			grouping_column_reference groupingColumnReference = new grouping_column_reference( );
			groupingColumnReferences.add( groupingColumnReference );
			convertExpressionToColumnReference( item.getExpr( )
					.getLeftOperand( ),
					groupingColumnReference.getColumn_reference( ) );
		}
		else
		{
			grouping_column_reference groupingColumnReference = new grouping_column_reference( );
			ordinaryGroupingSet.setGrouping_column_reference( groupingColumnReference );
			convertExpressionToColumnReference( item.getExpr( ),
					groupingColumnReference.getColumn_reference( ) );
		}
	}

	private void convertWhereConditionToModel( TWhereClause whereClause,
			where_clause whereClauseModel )
	{
		boolean_value_expression booleanValueExpression = whereClauseModel.getSearch_condition( )
				.getBoolean_value_expression( );
		TExpression condition = whereClause.getCondition( );
		convertBooleanExpressionToModel( condition, booleanValueExpression );
	}

	private void convertBooleanExpressionToModel( TExpression condition,
			boolean_value_expression booleanValueExpression )
	{
		if ( condition.getExpressionType( ) == EExpressionType.logical_or_t )
		{
			boolean_value_expression_or booleanValueExpressionOr = new boolean_value_expression_or( );
			booleanValueExpression.setBoolean_value_expression_or( booleanValueExpressionOr );
			convertOrExpressionToModel( condition, booleanValueExpressionOr );
		}
		else
		{
			boolean_term booleanTerm = new boolean_term( );
			booleanValueExpression.setBoolean_term( booleanTerm );
			convertBooleanExpressionToBooleanTerm( condition, booleanTerm );
		}
	}

	private void convertBooleanExpressionToBooleanTerm( TExpression condition,
			boolean_term booleanTerm )
	{
		if ( condition.getExpressionType( ) == EExpressionType.logical_and_t )
		{
			boolean_value_expression_and booleanValueExpressionAnd = new boolean_value_expression_and( );
			booleanTerm.setBoolean_value_expression_and( booleanValueExpressionAnd );
			convertAndExpressionToModel( condition, booleanValueExpressionAnd );
		}
		else
		{
			boolean_factor booleanFactor = new boolean_factor( );
			booleanTerm.setBoolean_factor( booleanFactor );
			convertBooleanExpressionToBooleanFactor( condition, booleanFactor );
		}
	}

	private void convertBooleanExpressionToBooleanFactor(
			TExpression condition, boolean_factor booleanFactor )
	{
		if ( condition.getNotToken( ) != null )
		{
			booleanFactor.setKw_not( "not" );
			convertBooleanExpressionToBooleanTest( condition.getLeftOperand( ),
					booleanFactor.getBoolean_test( ) );
		}
		else
		{
			convertBooleanExpressionToBooleanTest( condition,
					booleanFactor.getBoolean_test( ) );
		}
	}

	private void convertBooleanExpressionToBooleanTest( TExpression condition,
			boolean_test booleanTest )
	{
		convertBooleanExpressionToBooleanTest( condition,
				booleanTest.getBoolean_primary( ) );

	}

	private void convertBooleanExpressionToBooleanTest( TExpression condition,
			boolean_primary boolean_primary )
	{
		switch ( condition.getExpressionType( ) )
		{
			case simple_comparison_t :
				predicate predicate = new predicate( );
				boolean_primary.setPredicate( predicate );
				comparison_predicate comparisonPredicate = new comparison_predicate( );
				predicate.setComparison_predicate( comparisonPredicate );
				convertComparisonExpressionToComparisonPredicate( condition,
						comparisonPredicate );
				break;
			case in_t :
				break;
			case between_t :
				break;
			case null_t :
				break;
			case exists_t :
				break;
		}

	}

	private void convertComparisonExpressionToComparisonPredicate(
			TExpression condition, comparison_predicate comparisonPredicate )
	{
		convertExpressionToRowValuePredicand( condition.getLeftOperand( ),
				comparisonPredicate.getRow_value_predicand( ) );
		convertExpressionOperationToCompOp( condition.getComparisonOperator( ),
				comparisonPredicate.getComparison_predicate_part_2( )
						.getComp_op( ) );
		convertExpressionToRowValuePredicand( condition.getRightOperand( ),
				comparisonPredicate.getComparison_predicate_part_2( )
						.getRow_value_predicand( ) );

	}

	private void convertExpressionOperationToCompOp(
			TSourceToken comparisonOperator, comp_op compop )
	{
		if ( comparisonOperator.tokencode == (int) '=' )
		{
			compop.setEquals_operator( "=" );
		}
		else if ( comparisonOperator.tokencode == TBaseType.not_equal )
		{
			compop.setNot_equals_operator( "<>" );
		}
		else if ( comparisonOperator.tokencode == (int) '>' )
		{
			compop.setGreater_than_operator( ">" );
		}
		else if ( comparisonOperator.tokencode == (int) '<' )
		{
			compop.setLess_than_operator( ">" );
		}
		else if ( comparisonOperator.tokencode == TBaseType.less_equal )
		{
			compop.setLess_than_or_equals_operator( "<=" );
		}
		else if ( comparisonOperator.tokencode == TBaseType.great_equal )
		{
			compop.setGreater_than_or_equals_operator( ">=" );
		}
	}

	private void convertExpressionToRowValuePredicand( TExpression expression,
			row_value_predicand rowValuePredicand )
	{
		if ( expression.getExpressionType( ) == EExpressionType.simple_constant_t
				|| expression.getExpressionType( ) == EExpressionType.simple_object_name_t )
		{
			row_value_special_case rowValueSpecialCase = new row_value_special_case( );
			rowValuePredicand.setRow_value_special_case( rowValueSpecialCase );
			convertExpressionToNonParenthesizedValueExpression( expression,
					rowValueSpecialCase.getNonparenthesized_value_expression_primary( ) );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.function_t
				&& ( Utility.isAggregateFunction( expression.getFunctionCall( )
						.getFunctionName( )
						.toString( ) ) ) )
		{
			row_value_special_case rowValueSpecialCase = new row_value_special_case( );
			rowValuePredicand.setRow_value_special_case( rowValueSpecialCase );
			convertExpressionToNonParenthesizedValueExpression( expression,
					rowValueSpecialCase.getNonparenthesized_value_expression_primary( ) );
		}
		else
		{
			row_value_constructor_predicand rowValueConstructorPredicand = new row_value_constructor_predicand( );
			rowValuePredicand.setRow_value_constructor_predicand( rowValueConstructorPredicand );
		}
	}

	private void convertAndExpressionToModel( TExpression condition,
			boolean_value_expression_and booleanValueExpressionAnd )
	{
		convertBooleanExpressionToBooleanTerm( condition.getRightOperand( ),
				booleanValueExpressionAnd.getBoolean_term( ) );
		convertBooleanExpressionToBooleanFactor( condition.getLeftOperand( ),
				booleanValueExpressionAnd.getBoolean_factor( ) );

	}

	private void convertOrExpressionToModel( TExpression condition,
			boolean_value_expression_or booleanValueExpressionOr )
	{
		convertBooleanExpressionToModel( condition.getRightOperand( ),
				booleanValueExpressionOr.getBoolean_value_expression( ) );
		convertBooleanExpressionToBooleanTerm( condition.getLeftOperand( ),
				booleanValueExpressionOr.getBoolean_term( ) );
	}

	private void convertTableToTableFactor( TTable table,
			table_factor tableFactor )
	{
		table_primary tablePrimary = tableFactor.getTable_primary( );
		convertTableToTablePrimary( table, tablePrimary );
	}

	private void convertTableToTablePrimary( TTable table,
			table_primary tablePrimary )
	{
		TSourceToken sourceToken = SourceTokenSearcher.firstNotWhitespaceAndReturnToken( table.getStartToken( ).container,
				table.getStartToken( ).posinlist,
				table.getEndToken( ).posinlist );

		if ( sourceToken.astext.equalsIgnoreCase( "lateral" ) )
		{
			lateral_derived_table_as_correlation_name lateralDerivedTable = new lateral_derived_table_as_correlation_name( );
			tablePrimary.setLateral_derived_table_as_correlation_name( lateralDerivedTable );
		}
		else if ( sourceToken.astext.equalsIgnoreCase( "unnest" ) )
		{
			collection_derived_table_as_correction_name collectionDerivedTable = new collection_derived_table_as_correction_name( );
			tablePrimary.setCollection_derived_table_as_correction_name( collectionDerivedTable );
		}
		else if ( sourceToken.astext.equalsIgnoreCase( "table" ) )
		{
			table_function_derived_table_as_correction_name tableFunctionDerivedTable = new table_function_derived_table_as_correction_name( );
			tablePrimary.setTable_function_derived_table_as_correction_name( tableFunctionDerivedTable );
		}
		else if ( sourceToken.astext.equalsIgnoreCase( "only" ) )
		{
			only_spec_as_correction_name onlySpecTable = new only_spec_as_correction_name( );
			tablePrimary.setOnly_spec_as_correction_name( onlySpecTable );
		}
		else if ( table.subquery == null )
		{
			table_or_query_name_as_correlation_name normalTypeTable = new table_or_query_name_as_correlation_name( );
			tablePrimary.setTable_or_query_name_as_correlation_name( normalTypeTable );
			convertTableToNormalTableModel( table, normalTypeTable );
		}
		else
		{
			derived_table_as_correlation_name derivedTable = new derived_table_as_correlation_name( );
			tablePrimary.setDerived_table_as_correlation_name( derivedTable );
			convertTableToDerivedTableModel( table, derivedTable );
		}
	}

	private void convertTableToDerivedTableModel( TTable table,
			derived_table_as_correlation_name derivedTable )
	{
		convertSelectToQueryExpression( table.getSubquery( ),
				derivedTable.getDerived_table( )
						.getTable_subquery( )
						.getSubquery( )
						.getQuery_expression( ) );

	}

	private void convertTableToNormalTableModel( TTable table,
			table_or_query_name_as_correlation_name normalTypeTable )
	{
		table_or_query_name tableOrQueryName = normalTypeTable.getTable_or_query_name( );

		table_name tableName = new table_name( );
		tableOrQueryName.setTable_name( tableName );
		convertTableNameToModel( table.getTableName( ), tableName );

		if ( table.getAliasClause( ) != null )
		{
			correlation_name_with_derived_column_list correlationName = new correlation_name_with_derived_column_list( );
			normalTypeTable.setCorrelation_name_with_derived_column_list( correlationName );
			convertTableNameAliasToModel( table.getAliasClause( ),
					correlationName );
		}
	}

	private void convertTableNameAliasToModel( TAliasClause aliasClause,
			correlation_name_with_derived_column_list correlationName )
	{
		if ( aliasClause.getAsToken( ) != null )
		{
			correlationName.setKw_as( "as" );
		}

		convertIdentifierToModel( aliasClause.getAliasName( ).toString( ),
				correlationName.getCorrelation_name( )
						.getIdentifier( )
						.getActual_identifier( ) );
	}

	private void convertTableNameToModel( TObjectName tableName,
			table_name tableNameModel )
	{
		local_or_schema_qualified_name tableQualifiedNameModel = tableNameModel.getLocal_or_schema_qualified_name( );
		if ( tableName.getSchemaString( ) != null )
		{
			local_or_schema_qualifier schemaQulifier = new local_or_schema_qualifier( );
			tableQualifiedNameModel.setLocal_or_schema_qualifier( schemaQulifier );

			schema_name schemaName = new schema_name( );
			schemaQulifier.setSchema_name( schemaName );
			convertSchemaToModel( tableName, schemaName );
		}

		actual_identifier actualIdentifier = tableQualifiedNameModel.getQualified_identifier( )
				.getIdentifier( )
				.getActual_identifier( );
		convertIdentifierToModel( tableName.getObjectString( ),
				actualIdentifier );
	}

	private void convertSchemaToModel( TObjectName name, schema_name schemaName )
	{
		if ( name.getPartString( ) != null )
		{
			catalog_name catalogName = new catalog_name( );
			schemaName.setCatalog_name( catalogName );

			convertIdentifierToModel( name.getSchemaString( ),
					catalogName.getIdentifier( ).getActual_identifier( ) );
		}

		convertIdentifierToModel( name.getSchemaString( ),
				schemaName.getUnqualified_schema_name( )
						.getIdentifier( )
						.getActual_identifier( ) );
	}

	private void convertIdentifierToModel( String tableName,
			actual_identifier actualIdentifier )
	{
		if ( tableName.startsWith( "&" ) )
		{
			unicode_delimited_identifier identifier = new unicode_delimited_identifier( );
			actualIdentifier.setUnicode_delimited_identifier( identifier );
			identifier.setUnicode_delimiter_body( tableName.substring( 2,
					tableName.length( ) - 1 ) );
		}
		else if ( ( tableName.startsWith( "\"" ) && tableName.endsWith( "\"" ) )
				|| ( tableName.startsWith( "'" ) && tableName.endsWith( "'" ) ) )
		{
			delimited_identifier identifier = new delimited_identifier( );
			actualIdentifier.setDelimited_identifier( identifier );
			identifier.setDelimited_identifier_body( tableName.substring( 1,
					tableName.length( ) - 1 ) );
		}
		else
		{
			actualIdentifier.setRegular_identifier( tableName );
		}
	}

	private void convertSelectToSelectList( TSelectSqlStatement select,
			select_list selectList )
	{
		if ( select.getResultColumnList( ).size( ) == 1
				&& select.getResultColumnList( ).toString( ).equals( "*" ) )
		{
			selectList.setAsterisk( "*" );
		}
		else
		{
			List<select_sublist> selectSublist = new ArrayList<select_sublist>( );
			selectList.setSelect_sublist( selectSublist );
			for ( int i = 0; i < select.getResultColumnList( ).size( ); i++ )
			{
				TResultColumn column = select.getResultColumnList( )
						.getResultColumn( i );
				select_sublist sublist = new select_sublist( );
				selectSublist.add( sublist );
				if ( column.getFieldAttr( ) != null
						&& column.getFieldAttr( ).toString( ).endsWith( "*" ) )
				{
					qualified_asterisk qualifiedAsterisk = new qualified_asterisk( );
					sublist.setQualified_asterisk( qualifiedAsterisk );
					convertColumnToQualifiedAsterisk( column, qualifiedAsterisk );
				}
				else
				{
					derived_column derivedColumn = new derived_column( );
					sublist.setDerived_column( derivedColumn );
					convertColumnToDerivedColumn( column, derivedColumn );
				}
			}
		}
	}

	private void convertColumnToDerivedColumn( TResultColumn column,
			derived_column derivedColumn )
	{
		convertExpressionToValueExpression( column.getExpr( ),
				derivedColumn.getValue_expression( ) );

		if ( column.getAliasClause( ) != null )
		{
			as_clause asClause = new as_clause( );
			derivedColumn.setAs_clause( asClause );
			convertAliasToModel( column.getAliasClause( ), asClause );
		}
	}

	private void convertAliasToModel( TAliasClause aliasClause,
			as_clause asClause )
	{
		if ( aliasClause.getAsToken( ) != null )
		{
			asClause.setKw_as( "as" );
		}

		convertObjectName2Model( aliasClause.getAliasName( ),
				asClause.getColumn_name( ).getIdentifier( ) );
	}

	private void convertColumnToQualifiedAsterisk( TResultColumn column,
			qualified_asterisk qualifiedAsterisk )
	{
		if ( column.getAliasClause( ) != null )
		{
			all_fields_reference allFieldsReference = new all_fields_reference( );
			qualifiedAsterisk.setAll_fields_reference( allFieldsReference );
			convertResultColumnToAllFieldsReference( column, allFieldsReference );
		}
		else
		{
			asterisked_identifier_chain_asterisk asteriskedIdentifierChainAsterisk = new asterisked_identifier_chain_asterisk( );
			qualifiedAsterisk.setAsterisked_identifier_chain_asterisk( asteriskedIdentifierChainAsterisk );
			convertResultColumnToAsteriskedIdentifierChainAsterisk( column,
					asteriskedIdentifierChainAsterisk );
		}
	}

	private void convertResultColumnToAsteriskedIdentifierChainAsterisk(
			TResultColumn column,
			asterisked_identifier_chain_asterisk asteriskedIdentifierChainAsterisk )
	{
		List<asterisked_identifier> asteriskedIdentifiers = asteriskedIdentifierChainAsterisk.getAsterisked_identifier_chain( )
				.getAsterisked_identifier( );

		asterisked_identifier asteriskedIdentifier = new asterisked_identifier( );
		asteriskedIdentifiers.add( asteriskedIdentifier );

		convertResultColumnToAsteriskedIdentifier( column, asteriskedIdentifier );
	}

	private void convertResultColumnToAsteriskedIdentifier(
			TResultColumn column, asterisked_identifier asteriskedIdentifier )
	{
		convertObjectName2Model( column.getFieldAttr( ),
				asteriskedIdentifier.getIdentifier( ) );
	}

	private void convertResultColumnToAllFieldsReference( TResultColumn column,
			all_fields_reference allFieldsReference )
	{
		// TODO Auto-generated method stub

	}

	private void convertSelectToQueryExpressionBodyIntersect(
			TSelectSqlStatement select,
			query_expression_body_intersect queryExpreesionBodyIntersect )
	{
		// TODO Auto-generated method stub

	}

	private void convertSelectToQueryExpreesionBodyExcept(
			TSelectSqlStatement select,
			query_expression_body_except queryExpreesionBodyExcept )
	{
		// TODO Auto-generated method stub

	}

	private void convertSelectToQueryExpreesionBodyUnion(
			TSelectSqlStatement select,
			query_expression_body_union queryExpreesionBodyUnion )
	{
		// TODO Auto-generated method stub

	}

	private void convertWithClause2Model( TCTEList cteList,
			with_clause withClause )
	{
		// TODO Auto-generated method stub

	}

	private void convertForUpdateClause2Model( TForUpdate forUpdate,
			updatability_clause updatabilityClause )
	{
		read_only_or_update_of readOnlyOrUpdateOf = new read_only_or_update_of( );

		update_of_clause updateOfClause = new update_of_clause( );
		readOnlyOrUpdateOf.setUpdate_of_clause( updateOfClause );

		if ( forUpdate.getColumnRefs( ) != null )
		{
			of_column_name_list ofColumnNameList = new of_column_name_list( );
			updateOfClause.setOf_column_name_list( ofColumnNameList );

			column_name_list columnNameList = new column_name_list( );
			ofColumnNameList.setColumn_name_list( columnNameList );

			List<column_name> columnNames = columnNameList.getColumn_name( );

			for ( int i = 0; i < forUpdate.getColumnRefs( ).size( ); i++ )
			{
				TObjectName column = forUpdate.getColumnRefs( )
						.getObjectName( i );

				column_name columnName = new column_name( );
				columnNames.add( columnName );
				identifier identifier = columnName.getIdentifier( );
				convertObjectName2Model( column, identifier );
			}
		}
	}

	private void convertObjectName2Model( TObjectName objectName,
			identifier identifier )
	{
		actual_identifier actualIdentifier = identifier.getActual_identifier( );

		String word = objectName.toString( );
		if ( word.startsWith( "\"" ) && word.endsWith( "\"" ) )
		{
			delimited_identifier delimitedIdentifier = new delimited_identifier( );
			actualIdentifier.setDelimited_identifier( delimitedIdentifier );

			delimitedIdentifier.setDelimited_identifier_body( word.substring( 1,
					word.length( ) - 1 ) );
		}
		else
		{
			actualIdentifier.setRegular_identifier( word );
		}
	}

	private void convertOrderbyClause2Model( TOrderBy orderby,
			order_by_clause orderByClause )
	{
		sort_specification_list sortSpecificationList = new sort_specification_list( );
		orderByClause.setSort_specification_list( sortSpecificationList );

		List<sort_specification> sort_specifications = new ArrayList<sort_specification>( );
		sortSpecificationList.setSort_specification( sort_specifications );

		TOrderByItemList orderByItems = orderby.getItems( );
		for ( int i = 0; i < orderByItems.size( ); i++ )
		{
			TOrderByItem item = orderByItems.getOrderByItem( i );
			sort_specification sortSpecification = new sort_specification( );

			sort_specifications.add( sortSpecification );

			sort_key sortKey = sortSpecification.getSort_key( );

			if ( item.getSortType( ) == TBaseType.srtAsc )
			{
				ordering_specification orderingSpecification = new ordering_specification( );
				sortSpecification.setOrdering_specification( orderingSpecification );
			}
			else if ( item.getSortType( ) == TBaseType.srtDesc )
			{
				ordering_specification orderingSpecification = new ordering_specification( );
				sortSpecification.setOrdering_specification( orderingSpecification );
			}

			value_expression valueExpression = sortKey.getValue_expression( );

			convertExpressionToValueExpression( item.getSortKey( ),
					valueExpression );
		}

	}

	private void convertExpressionToValueExpression( TExpression expression,
			value_expression valueExpression )
	{
		switch ( expression.getExpressionType( ) )
		{
			default :
				common_value_expression commonValueExpression = new common_value_expression( );
				valueExpression.setCommon_value_expression( commonValueExpression );
				convertExpressionToCommonValueExpression( expression,
						commonValueExpression );
		}
	}

	private void convertExpressionToCommonValueExpression(
			TExpression expression,
			common_value_expression commonValueExpression )
	{
		if ( isNumericValueExpression( expression ) )
		{
			numeric_value_expression numericValueExpression = new numeric_value_expression( );
			commonValueExpression.setNumeric_value_expression( numericValueExpression );
			convertExpressionToNumericValueExpression( expression,
					numericValueExpression );
		}
		else if ( isStringValueExpression( expression ) )
		{
			string_value_expression stringValueExpression = new string_value_expression( );
			commonValueExpression.setString_value_expression( stringValueExpression );
			convertExpressionToStringValueExpression( expression,
					stringValueExpression );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.simple_object_name_t )
		{
			string_value_expression stringValueExpression = new string_value_expression( );
			commonValueExpression.setString_value_expression( stringValueExpression );
			convertExpressionToStringValueExpression( expression,
					stringValueExpression );
		}

	}

	private void convertExpressionToStringValueExpression(
			TExpression expression,
			string_value_expression stringValueExpression )
	{
		// Ignore binary_value_expression, I can't analyze the binary type
		// here.
		character_value_expression charValueExpression = new character_value_expression( );
		stringValueExpression.setCharacter_value_expression( charValueExpression );
		convertExpressionToCharacterValueExpression( expression,
				charValueExpression );

	}

	private void convertExpressionToCharacterValueExpression(
			TExpression expression,
			character_value_expression charValueExpression )
	{
		if ( expression.getExpressionType( ) == EExpressionType.concatenate_t )
		{
			concatenation concatenation = new concatenation( );
			charValueExpression.setConcatenation( concatenation );
			convertExpressionToConcatenation( expression, concatenation );
		}
		else
		{
			character_factor characterFactor = new character_factor( );
			charValueExpression.setCharacter_factor( characterFactor );
			convertExpressionToCharacterFactor( expression, characterFactor );
		}
	}

	private void convertExpressionToCharacterFactor( TExpression expression,
			character_factor character_factor )
	{
		convertExpressionToCharacterPrimary( expression,
				character_factor.getCharacter_primary( ) );
	}

	private void convertExpressionToCharacterPrimary( TExpression expression,
			character_primary character_primary )
	{
		if ( expression.getExpressionType( ) == EExpressionType.function_t )
		{
			string_value_function stringValueFunction = new string_value_function( );
			character_primary.setString_value_function( stringValueFunction );
			convertExpressionToStringValueFunction( expression,
					stringValueFunction );
		}
		else
		{
			value_expression_primary valueExpressionPrimary = new value_expression_primary( );
			character_primary.setValue_expression_primary( valueExpressionPrimary );
			convertExpressionToValueExpressionPrimary( expression,
					valueExpressionPrimary );
		}
	}

	private void convertExpressionToStringValueFunction(
			TExpression expression, string_value_function stringValueFunction )
	{
		character_value_function characterValueFunction = new character_value_function( );
		stringValueFunction.setCharacter_value_function( characterValueFunction );
		convertExpressionToCharacterValueFunction( characterValueFunction );
	}

	private void convertExpressionToCharacterValueFunction(
			character_value_function characterValueFunction )
	{
		// TODO Auto-generated method stub

	}

	private void convertExpressionToConcatenation( TExpression expression,
			concatenation concatenation )
	{
		convertExpressionToCharacterValueExpression( expression.getLeftOperand( ),
				concatenation.getCharacter_value_expression( ) );
		convertExpressionToCharacterFactor( expression.getRightOperand( ),
				concatenation.getCharacter_factor( ) );
	}

	private boolean isStringValueExpression( TExpression expression )
	{
		if ( expression.getExpressionType( ) == EExpressionType.concatenate_t )
		{
			return true;
		}
		else if ( expression.getExpressionType( ) == EExpressionType.simple_constant_t )
		{
			if ( Utility.isString( expression.toString( ) ) )
			{
				return true;
			}
		}
		else if ( expression.getExpressionType( ) == EExpressionType.function_t )
		{
			String functionName = expression.getFunctionCall( )
					.getFunctionName( )
					.toString( );
			if ( Utility.isStringValueFunction( functionName ) )
			{
				return true;
			}
		}
		return false;
	}

	private void convertExpressionToNumericValueExpression(
			TExpression expression,
			numeric_value_expression numericValueExpression )
	{
		if ( expression.getExpressionType( ) == EExpressionType.arithmetic_plus_t )
		{
			plus plus = new plus( );
			numericValueExpression.setPlus( plus );
			convertExpressionToPlus( expression, plus );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.arithmetic_minus_t )
		{
			minus minus = new minus( );
			numericValueExpression.setMinus( minus );
			convertExpressionToMinus( expression, minus );
		}
		else
		{
			term term = new term( );
			numericValueExpression.setTerm( term );
			convertExpressionToTerm( expression, term );
		}
	}

	private void convertExpressionToTerm( TExpression expression, term term )
	{
		if ( expression.getExpressionType( ) == EExpressionType.arithmetic_divide_t )
		{
			term_solidus_factor termSolidusFactor = new term_solidus_factor( );
			term.setTerm_solidus_factor( termSolidusFactor );
			convertExpressionToTermSolidusFactor( expression, termSolidusFactor );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.arithmetic_times_t )
		{
			term_asterisk_factor termAsteriskFactor = new term_asterisk_factor( );
			term.setTerm_asterisk_factor( termAsteriskFactor );
			convertExpressionToTermAsteriskFactor( expression,
					termAsteriskFactor );
		}
		else
		{
			factor factor = new factor( );
			term.setFactor( factor );
			convertExpressionToFactor( expression, factor );
		}
	}

	private void convertExpressionToFactor( TExpression expression,
			factor factor )
	{
		if ( expression.getExpressionType( ) == EExpressionType.unary_plus_t )
		{
			sign sign = new sign( );
			sign.setPlus_sign( "+" );
			factor.setSign( sign );
			convertExpressionToNumericPrimary( expression.getRightOperand( ),
					factor.getNumeric_primary( ) );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.unary_minus_t )
		{
			sign sign = new sign( );
			sign.setMinus_sign( "-" );
			factor.setSign( sign );
			convertExpressionToNumericPrimary( expression.getRightOperand( ),
					factor.getNumeric_primary( ) );
		}
		else
		{
			convertExpressionToNumericPrimary( expression,
					factor.getNumeric_primary( ) );
		}
	}

	private void convertExpressionToNumericPrimary( TExpression expression,
			numeric_primary numericPrimary )
	{
		if ( expression.getExpressionType( ) == EExpressionType.function_t )
		{
			String functionName = expression.getFunctionCall( )
					.getFunctionName( )
					.toString( );
			if ( Utility.isNumericValueFunction( functionName ) )
			{
				numeric_value_function numericValueFunction = new numeric_value_function( );
				numericPrimary.setNumeric_value_function( numericValueFunction );
				convertExpressionToNumericValueFunction( expression,
						numericValueFunction );
			}
			else if ( Utility.isAggregateFunction( functionName ) )
			{
				value_expression_primary valueExpressionPrimary = new value_expression_primary( );
				numericPrimary.setValue_expression_primary( valueExpressionPrimary );
				convertExpressionToValueExpressionPrimary( expression,
						valueExpressionPrimary );
			}
		}
		else
		{
			value_expression_primary valueExpressionPrimary = new value_expression_primary( );
			numericPrimary.setValue_expression_primary( valueExpressionPrimary );
			convertExpressionToValueExpressionPrimary( expression,
					valueExpressionPrimary );
		}
	}

	private void convertExpressionToValueExpressionPrimary(
			TExpression expression,
			value_expression_primary valueExpressionPrimary )
	{
		if ( expression.toString( ).startsWith( "(" )
				&& expression.toString( ).endsWith( ")" ) )
		{
			parenthesized_value_expression parenthesizedValueExpression = new parenthesized_value_expression( );
			valueExpressionPrimary.setParenthesized_value_expression( parenthesizedValueExpression );
			convertExpressionToParenthesizedValueExpression( expression.getLeftOperand( ),
					parenthesizedValueExpression );
		}
		else
		{
			nonparenthesized_value_expression_primary nonparenthesizedValueExpressionPrimary = new nonparenthesized_value_expression_primary( );
			valueExpressionPrimary.setNonparenthesized_value_expression_primary( nonparenthesizedValueExpressionPrimary );
			convertExpressionToNonParenthesizedValueExpression( expression,
					nonparenthesizedValueExpressionPrimary );
		}
	}

	private void convertExpressionToNonParenthesizedValueExpression(
			TExpression expression,
			nonparenthesized_value_expression_primary nonparenthesizedValueExpressionPrimary )
	{
		switch ( expression.getExpressionType( ) )
		{
			case simple_constant_t :
				unsigned_value_specification unsignedValueSpecification = new unsigned_value_specification( );
				nonparenthesizedValueExpressionPrimary.setUnsigned_value_specification( unsignedValueSpecification );
				convertExpressionToUnsignedValueSpecification( expression,
						unsignedValueSpecification );
				break;
			case simple_object_name_t :
				column_reference columnReference = new column_reference( );
				nonparenthesizedValueExpressionPrimary.setColumn_reference( columnReference );
				convertExpressionToColumnReference( expression, columnReference );
				break;
			case function_t :
				if ( Utility.isAggregateFunction( expression.getFunctionCall( )
						.getFunctionName( )
						.toString( ) ) )
				{
					set_function_specification setFunctionSpecification = new set_function_specification( );
					nonparenthesizedValueExpressionPrimary.setSet_function_specification( setFunctionSpecification );
					convertExpressionToSetFunction( expression.getFunctionCall( ),
							setFunctionSpecification );
				}
				break;
			default :
		}

	}

	private void convertExpressionToSetFunction( TFunctionCall function,
			set_function_specification setFunctionSpecification )
	{
		aggregate_function aggregateFunction = new aggregate_function( );
		setFunctionSpecification.setAggregate_function( aggregateFunction );
		convertExpressionToAggregateFunction( function, aggregateFunction );
	}

	private void convertExpressionToAggregateFunction( TFunctionCall function,
			aggregate_function aggregateFunction )
	{
		if ( function.getFunctionName( ).toString( ).equalsIgnoreCase( "count" )
				&& ( function.getArgs( ) == null || function.getArgs( )
						.toString( )
						.trim( )
						.equals( "*" ) ) )
		{
			aggregate_count aggregateCount = new aggregate_count( );
			aggregateFunction.setAggregate_count( aggregateCount );
		}
		else
		{
			aggregate_function_general_set aggregateFunctionGeneralSet = new aggregate_function_general_set( );
			aggregateFunction.setAggregate_function_general_set( aggregateFunctionGeneralSet );
			convertExpressionToAggregateFunction( function,
					aggregateFunctionGeneralSet.getGeneral_set_function( ) );
		}
	}

	private void convertExpressionToAggregateFunction( TFunctionCall function,
			general_set_function general_set_function )
	{
		String functionName = function.getFunctionName( ).toString( );
		computational_operation operation = general_set_function.getSet_function_type( )
				.getComputational_operation( );
		if ( functionName.equalsIgnoreCase( "any" ) )
			operation.setKw_any( "any" );
		if ( functionName.equalsIgnoreCase( "avg" ) )
			operation.setKw_avg( "avg" );
		if ( functionName.equalsIgnoreCase( "collect" ) )
			operation.setKw_collect( "collect" );
		if ( functionName.equalsIgnoreCase( "count" ) )
			operation.setKw_count( "count" );
		if ( functionName.equalsIgnoreCase( "every" ) )
			operation.setKw_every( "every" );
		if ( functionName.equalsIgnoreCase( "fusion" ) )
			operation.setKw_fusion( "fusion" );
		if ( functionName.equalsIgnoreCase( "intersection" ) )
			operation.setKw_intersection( "intersection" );
		if ( functionName.equalsIgnoreCase( "max" ) )
			operation.setKw_max( "max" );
		if ( functionName.equalsIgnoreCase( "min" ) )
			operation.setKw_min( "min" );
		if ( functionName.equalsIgnoreCase( "some" ) )
			operation.setKw_some( "some" );
		if ( functionName.equalsIgnoreCase( "stddev_pop" ) )
			operation.setKw_stddev_pop( "stddev_pop" );
		if ( functionName.equalsIgnoreCase( "stddev_samp" ) )
			operation.setKw_stddev_samp( "stddev_samp" );
		if ( functionName.equalsIgnoreCase( "sum" ) )
			operation.setKw_sum( "sum" );
		if ( functionName.equalsIgnoreCase( "var_pop" ) )
			operation.setKw_var_pop( "var_pop" );
		if ( functionName.equalsIgnoreCase( "var_samp" ) )
			operation.setKw_var_samp( "var_samp" );

		if ( function.getAggregateType( ) == EAggregateType.distinct )
		{
			set_quantifier setQuantifier = new set_quantifier( );
			general_set_function.setSet_quantifier( setQuantifier );
			setQuantifier.setKw_distinct( "distinct" );
		}
		else if ( function.getAggregateType( ) == EAggregateType.all )
		{
			set_quantifier setQuantifier = new set_quantifier( );
			general_set_function.setSet_quantifier( setQuantifier );
			setQuantifier.setKw_all( "all" );
		}
		value_expression valueExpression = general_set_function.getValue_expression( );
		common_value_expression commonValueExpression = new common_value_expression( );
		valueExpression.setCommon_value_expression( commonValueExpression );
		convertExpressionToCommonValueExpression( function.getArgs( )
				.getExpression( 0 ), commonValueExpression );
	}

	private void convertExpressionToColumnReference( TExpression expression,
			column_reference columnReference )
	{
		if ( expression.toString( ).toUpperCase( ).startsWith( "MODULE." ) )
		{
			module_identifier_chain moduleIdentifierChain = new module_identifier_chain( );
			columnReference.setModule_identifier_chain( moduleIdentifierChain );
		}
		else
		{
			basic_identifier_chain basicIdentifierChain = new basic_identifier_chain( );
			columnReference.setBasic_identifier_chain( basicIdentifierChain );
			List<identifier> identifiers = basicIdentifierChain.getIdentifier_chain( )
					.getIdentifier( );
			convertResultColumnToIdentifierChain( expression, identifiers );
		}
	}

	private void convertResultColumnToIdentifierChain( TExpression expression,
			List<identifier> identifiers )
	{
		TObjectName object = expression.getObjectOperand( );
		if ( object.getServerToken( ) != null )
		{
			identifier identifier = new identifier( );
			identifiers.add( identifier );
			convertIdentifierToModel( object.getServerToken( ).toString( ),
					identifier.getActual_identifier( ) );
		}
		if ( object.getDatabaseToken( ) != null )
		{
			identifier identifier = new identifier( );
			identifiers.add( identifier );
			convertIdentifierToModel( object.getDatabaseToken( ).toString( ),
					identifier.getActual_identifier( ) );
		}
		if ( object.getSchemaToken( ) != null )
		{
			identifier identifier = new identifier( );
			identifiers.add( identifier );
			convertIdentifierToModel( object.getSchemaToken( ).toString( ),
					identifier.getActual_identifier( ) );
		}

		if ( object.getObjectToken( ) != null )
		{
			identifier identifier = new identifier( );
			identifiers.add( identifier );
			convertIdentifierToModel( object.getObjectToken( ).toString( ),
					identifier.getActual_identifier( ) );
		}
		if ( object.getPartToken( ) != null )
		{
			identifier identifier = new identifier( );
			identifiers.add( identifier );
			convertIdentifierToModel( object.getPartToken( ).toString( ),
					identifier.getActual_identifier( ) );
		}
	}

	private void convertExpressionToUnsignedValueSpecification(
			TExpression expression,
			unsigned_value_specification unsignedValueSpecification )
	{
		switch ( expression.getExpressionType( ) )
		{
			case simple_constant_t :
				unsigned_literal unsignedLiteral = new unsigned_literal( );
				unsignedValueSpecification.setUnsigned_literal( unsignedLiteral );
				convertExpressionToUnsignedLiteral( expression, unsignedLiteral );
				break;
			default :
		}

	}

	private void convertExpressionToUnsignedLiteral( TExpression expression,
			unsigned_literal unsignedLiteral )
	{
		if ( Utility.isNumber( expression.toString( ) ) )
		{
			unsigned_numeric_literal unsignedNumericLiteral = new unsigned_numeric_literal( );
			unsignedLiteral.setUnsigned_numeric_literal( unsignedNumericLiteral );
			convertExpressionToUnsignedNumericLiteral( expression,
					unsignedNumericLiteral );
		}
		else
		{
			general_literal generalLiteral = new general_literal( );
			unsignedLiteral.setGeneral_literal( generalLiteral );
			convertExpressionToGeneralLiteral( expression, generalLiteral );
		}
	}

	private void convertExpressionToGeneralLiteral( TExpression expression,
			general_literal generalLiteral )
	{
		if ( Utility.isString( expression.toString( ) ) )
		{
			if ( Utility.isNationalString( expression.toString( ) ) )
			{
				national_character_string_literal nationalCharacterStringLiteral = new national_character_string_literal( );
				generalLiteral.setNational_character_string_literal( nationalCharacterStringLiteral );
				convertExpressionToNationalCharacterStringLiteral( expression,
						nationalCharacterStringLiteral );
			}
			else if ( Utility.isUnicodeString( expression.toString( ) ) )
			{
				unicode_character_string_literal unicodeCharacterStringLiteral = new unicode_character_string_literal( );
				generalLiteral.setUnicode_character_string_literal( unicodeCharacterStringLiteral );
				convertExpressionToUnicodeCharacterStringLiteral( expression,
						unicodeCharacterStringLiteral );
			}
			else
			{
				character_string_literal characterStringLiteral = new character_string_literal( );
				generalLiteral.setCharacter_string_literal( characterStringLiteral );
				convertExpressionToCharacterStringLiteral( expression,
						characterStringLiteral );
			}
		}

	}

	private void convertExpressionToCharacterStringLiteral(
			TExpression expression,
			character_string_literal characterStringLiteral )
	{
		List<quoted_character_representation> quotedCharacterRepresentations = characterStringLiteral.getQuoted_character_representation( );
		quoted_character_representation quotedCharacterRepresentation = new quoted_character_representation( );
		quotedCharacterRepresentations.add( quotedCharacterRepresentation );
		quotedCharacterRepresentation.setCharacter_representation( expression.toString( )
				.substring( 1, expression.toString( ).length( ) - 1 ) );

	}

	private void convertExpressionToUnicodeCharacterStringLiteral(
			TExpression expression,
			unicode_character_string_literal unicodeCharacterStringLiteral )
	{
		// TODO Auto-generated method stub

	}

	private void convertExpressionToNationalCharacterStringLiteral(
			TExpression expression,
			national_character_string_literal nationalCharacterStringLiteral )
	{
		List<quoted_character_representation> quotedCharacterRepresentations = nationalCharacterStringLiteral.getQuoted_character_representation( );
		quoted_character_representation quotedCharacterRepresentation = new quoted_character_representation( );
		quotedCharacterRepresentations.add( quotedCharacterRepresentation );
		quotedCharacterRepresentation.setCharacter_representation( expression.toString( )
				.substring( 2, expression.toString( ).length( ) - 1 ) );
	}

	private void convertExpressionToUnsignedNumericLiteral(
			TExpression expression,
			unsigned_numeric_literal unsignedNumericLiteral )
	{
		if ( expression.toString( ).toLowerCase( ).indexOf( 'e' ) != -1 )
		{
			unsignedNumericLiteral.setApproximate_numeric_literal( expression.toString( ) );
		}
		else
		{
			unsignedNumericLiteral.setExact_numeric_literal( expression.toString( ) );
		}
	}

	private void convertExpressionToParenthesizedValueExpression(
			TExpression expression,
			parenthesized_value_expression parenthesizedValueExpression )
	{
		convertExpressionToValueExpression( expression,
				parenthesizedValueExpression.getValue_expression( ) );

	}

	private void convertExpressionToNumericValueFunction(
			TExpression expression, numeric_value_function numericValueFunction )
	{
		// TODO Auto-generated method stub

	}

	private void convertExpressionToTermAsteriskFactor( TExpression expression,
			term_asterisk_factor termAsteriskFactor )
	{
		convertExpressionToTerm( expression.getLeftOperand( ),
				termAsteriskFactor.getTerm( ) );
		convertExpressionToFactor( expression.getRightOperand( ),
				termAsteriskFactor.getFactor( ) );
	}

	private void convertExpressionToTermSolidusFactor( TExpression expression,
			term_solidus_factor termSolidusFactor )
	{
		convertExpressionToTerm( expression.getLeftOperand( ),
				termSolidusFactor.getTerm( ) );
		convertExpressionToFactor( expression.getRightOperand( ),
				termSolidusFactor.getFactor( ) );
	}

	private void convertExpressionToMinus( TExpression expression, minus minus )
	{
		convertExpressionToNumericValueExpression( expression.getLeftOperand( ),
				minus.getNumeric_value_expression( ) );
		convertExpressionToTerm( expression.getRightOperand( ), minus.getTerm( ) );
	}

	private void convertExpressionToPlus( TExpression expression, plus plus )
	{
		convertExpressionToNumericValueExpression( expression.getLeftOperand( ),
				plus.getNumeric_value_expression( ) );
		convertExpressionToTerm( expression.getRightOperand( ), plus.getTerm( ) );
	}

	private boolean isNumericValueExpression( TExpression expression )
	{
		if ( expression.getExpressionType( ) == EExpressionType.arithmetic_plus_t
				|| expression.getExpressionType( ) == EExpressionType.arithmetic_minus_t
				|| expression.getExpressionType( ) == EExpressionType.arithmetic_divide_t
				|| expression.getExpressionType( ) == EExpressionType.arithmetic_times_t
				|| expression.getExpressionType( ) == EExpressionType.unary_plus_t
				|| expression.getExpressionType( ) == EExpressionType.unary_minus_t )
		{
			return true;
		}
		else if ( expression.getExpressionType( ) == EExpressionType.simple_constant_t )
		{
			if ( Utility.isNumber( expression.toString( ) ) )
			{
				return true;
			}
		}
		else if ( expression.getExpressionType( ) == EExpressionType.function_t )
		{
			String functionName = expression.getFunctionCall( )
					.getFunctionName( )
					.toString( );
			if ( Utility.isNumericValueFunction( functionName )
					|| Utility.isAggregateFunction( functionName ) )
			{
				return true;
			}
		}
		return false;
	}

	private void convertInsertStmt2Model( TInsertSqlStatement insert,
			insert_statement insertStatement )
	{
		// TODO Auto-generated method stub

	}

	private void convertUpdateStmt2Model( TUpdateSqlStatement update,
			update_statement_searched updateStatementSearched )
	{
		// TODO Auto-generated method stub

	}

	private void convertDeleteStmt2Model( TDeleteSqlStatement delete,
			delete_statement_searched deleteStatementSearched )
	{
		// TODO Auto-generated method stub

	}

	private void convertMergeStmt2Model( TMergeSqlStatement merge,
			merge_statement mergeStatement )
	{
		// TODO Auto-generated method stub

	}

	public String getErrorMessage( )
	{
		return errorMessage;
	}

}
