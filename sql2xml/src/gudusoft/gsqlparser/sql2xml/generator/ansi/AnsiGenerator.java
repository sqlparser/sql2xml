
package gudusoft.gsqlparser.sql2xml.generator.ansi;

import gudusoft.gsqlparser.EDbVendor;
import gudusoft.gsqlparser.TBaseType;
import gudusoft.gsqlparser.TCustomSqlStatement;
import gudusoft.gsqlparser.TGSqlParser;
import gudusoft.gsqlparser.TStatementList;
import gudusoft.gsqlparser.nodes.TCTEList;
import gudusoft.gsqlparser.nodes.TExpression;
import gudusoft.gsqlparser.nodes.TForUpdate;
import gudusoft.gsqlparser.nodes.TObjectName;
import gudusoft.gsqlparser.nodes.TOrderBy;
import gudusoft.gsqlparser.nodes.TOrderByItem;
import gudusoft.gsqlparser.nodes.TOrderByItemList;
import gudusoft.gsqlparser.sql2xml.generator.SQL2XMLGenerator;
import gudusoft.gsqlparser.sql2xml.model.actual_identifier;
import gudusoft.gsqlparser.sql2xml.model.column_name;
import gudusoft.gsqlparser.sql2xml.model.column_name_list;
import gudusoft.gsqlparser.sql2xml.model.cursor_specification;
import gudusoft.gsqlparser.sql2xml.model.delete_statement_searched;
import gudusoft.gsqlparser.sql2xml.model.delimited_identifier;
import gudusoft.gsqlparser.sql2xml.model.direct_select_statement_multiple_rows;
import gudusoft.gsqlparser.sql2xml.model.direct_sql_data_statement;
import gudusoft.gsqlparser.sql2xml.model.directly_executable_statement;
import gudusoft.gsqlparser.sql2xml.model.identifier;
import gudusoft.gsqlparser.sql2xml.model.insert_statement;
import gudusoft.gsqlparser.sql2xml.model.merge_statement;
import gudusoft.gsqlparser.sql2xml.model.of_column_name_list;
import gudusoft.gsqlparser.sql2xml.model.order_by_clause;
import gudusoft.gsqlparser.sql2xml.model.ordering_specification;
import gudusoft.gsqlparser.sql2xml.model.query_expression;
import gudusoft.gsqlparser.sql2xml.model.query_expression_body;
import gudusoft.gsqlparser.sql2xml.model.query_expression_body_except;
import gudusoft.gsqlparser.sql2xml.model.query_expression_body_intersect;
import gudusoft.gsqlparser.sql2xml.model.query_expression_body_union;
import gudusoft.gsqlparser.sql2xml.model.query_primary;
import gudusoft.gsqlparser.sql2xml.model.query_specification;
import gudusoft.gsqlparser.sql2xml.model.query_term;
import gudusoft.gsqlparser.sql2xml.model.read_only_or_update_of;
import gudusoft.gsqlparser.sql2xml.model.select_list;
import gudusoft.gsqlparser.sql2xml.model.set_quantifier;
import gudusoft.gsqlparser.sql2xml.model.simple_table;
import gudusoft.gsqlparser.sql2xml.model.sort_key;
import gudusoft.gsqlparser.sql2xml.model.sort_specification;
import gudusoft.gsqlparser.sql2xml.model.sort_specification_list;
import gudusoft.gsqlparser.sql2xml.model.table_expression;
import gudusoft.gsqlparser.sql2xml.model.updatability_clause;
import gudusoft.gsqlparser.sql2xml.model.update_of_clause;
import gudusoft.gsqlparser.sql2xml.model.update_statement_searched;
import gudusoft.gsqlparser.sql2xml.model.value_expression;
import gudusoft.gsqlparser.sql2xml.model.with_clause;
import gudusoft.gsqlparser.stmt.TDeleteSqlStatement;
import gudusoft.gsqlparser.stmt.TInsertSqlStatement;
import gudusoft.gsqlparser.stmt.TMergeSqlStatement;
import gudusoft.gsqlparser.stmt.TSelectSqlStatement;
import gudusoft.gsqlparser.stmt.TUpdateSqlStatement;

import java.util.ArrayList;
import java.util.List;

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

	@Override
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

	protected String convertSQL2XML( TGSqlParser sqlparser )
	{

		TStatementList stmts = sqlparser.getSqlstatements( );
		for ( int i = 0; i < stmts.size( ); i++ )
		{
			directly_executable_statement directly_executable_statement = new directly_executable_statement( );
			convertStmt2Model( stmts.get( i ), directly_executable_statement );
		}
		return null;
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
		// TODO Auto-generated method stub

	}

	private void convertSelectToSelectList( TSelectSqlStatement select,
			select_list selectList )
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

				identifier identifier = new identifier( );
				columnName.setIdentifier( identifier );

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

			convertExpression2Model( item.getSortKey( ), valueExpression );
		}

	}

	private void convertExpression2Model( TExpression expression,
			value_expression valueExpression )
	{
		// TODO Auto-generated method stub

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

	@Override
	public String getErrorMessage( )
	{
		return errorMessage;
	}

}
