
package gudusoft.gsqlparser.sql2xml.generator.ansi;

import gudusoft.gsqlparser.EAggregateType;
import gudusoft.gsqlparser.EDbVendor;
import gudusoft.gsqlparser.EExpressionType;
import gudusoft.gsqlparser.EJoinType;
import gudusoft.gsqlparser.TBaseType;
import gudusoft.gsqlparser.TCustomSqlStatement;
import gudusoft.gsqlparser.TGSqlParser;
import gudusoft.gsqlparser.TSourceToken;
import gudusoft.gsqlparser.TStatementList;
import gudusoft.gsqlparser.nodes.TAliasClause;
import gudusoft.gsqlparser.nodes.TAnalyticFunction;
import gudusoft.gsqlparser.nodes.TCTEList;
import gudusoft.gsqlparser.nodes.TCaseExpression;
import gudusoft.gsqlparser.nodes.TColumnDefinition;
import gudusoft.gsqlparser.nodes.TColumnDefinitionList;
import gudusoft.gsqlparser.nodes.TExpression;
import gudusoft.gsqlparser.nodes.TExpressionList;
import gudusoft.gsqlparser.nodes.TForUpdate;
import gudusoft.gsqlparser.nodes.TFunctionCall;
import gudusoft.gsqlparser.nodes.TGroupBy;
import gudusoft.gsqlparser.nodes.TGroupByItem;
import gudusoft.gsqlparser.nodes.TJoin;
import gudusoft.gsqlparser.nodes.TJoinItem;
import gudusoft.gsqlparser.nodes.TJoinItemList;
import gudusoft.gsqlparser.nodes.TObjectName;
import gudusoft.gsqlparser.nodes.TObjectNameList;
import gudusoft.gsqlparser.nodes.TOrderBy;
import gudusoft.gsqlparser.nodes.TOrderByItem;
import gudusoft.gsqlparser.nodes.TOrderByItemList;
import gudusoft.gsqlparser.nodes.TResultColumn;
import gudusoft.gsqlparser.nodes.TTable;
import gudusoft.gsqlparser.nodes.TTypeName;
import gudusoft.gsqlparser.nodes.TWhenClauseItem;
import gudusoft.gsqlparser.nodes.TWhenClauseItemList;
import gudusoft.gsqlparser.nodes.TWhereClause;
import gudusoft.gsqlparser.sql2xml.generator.SQL2XMLGenerator;
import gudusoft.gsqlparser.sql2xml.model.*;
import gudusoft.gsqlparser.stmt.TCreateTableSqlStatement;
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
		if ( Utility.isDirectly_executable_statement( stmt ) )
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
			else if ( Utility.isSql_schema_statement( stmt ) )
			{
				sql_schema_statement sqlSchemaStatement = new sql_schema_statement( );
				directlyExecutableStatement.setSql_schema_statement( sqlSchemaStatement );
				if ( stmt instanceof TCreateTableSqlStatement )
				{
					TCreateTableSqlStatement createTable = (TCreateTableSqlStatement) stmt;
					sql_schema_definition_statement sql_schema_definition_statement = new sql_schema_definition_statement( );
					sqlSchemaStatement.setSql_schema_definition_statement( sql_schema_definition_statement );
					table_definition table_definition = new table_definition( );
					sql_schema_definition_statement.setTable_definition( table_definition );
					convertCreateTableStmt2Model( createTable, table_definition );
				}
			}
		}
	}

	private void convertCreateTableStmt2Model(
			TCreateTableSqlStatement createTable,
			table_definition table_definition )
	{
		convertTableNameToModel( createTable.getTableName( ),
				table_definition.getTable_name( ) );

		if ( createTable.getColumnList( ) != null )
		{
			table_element_list table_element_list = new table_element_list( );
			table_definition.getTable_contents_source( )
					.setTable_element_list( table_element_list );
			convertTableColumnListToTableElementList( createTable.getColumnList( ),
					table_element_list );
		}
	}

	private void convertTableColumnListToTableElementList(
			TColumnDefinitionList columnList,
			table_element_list table_element_list )
	{
		List<table_element> table_elements = table_element_list.getTable_element( );
		for ( int i = 0; i < columnList.size( ); i++ )
		{
			TColumnDefinition columnDef = columnList.getColumn( i );
			table_element element = new table_element( );
			table_elements.add( element );
			convertColumnDefinitionToTableElement( columnDef, element );
		}
	}

	private void convertColumnDefinitionToTableElement(
			TColumnDefinition columnDef, table_element element )
	{
		column_definition column_definition = new column_definition( );
		element.setColumn_definition( column_definition );
		convertObjectName2Model( columnDef.getColumnName( ),
				column_definition.getColumn_name( ).getIdentifier( ) );

		if ( columnDef.getDatatype( ) != null )
		{
			data_type_or_domain_name data_type_or_domain_name = new data_type_or_domain_name( );
			column_definition.setData_type_or_domain_name( data_type_or_domain_name );

			data_type data_type = new data_type( );
			data_type_or_domain_name.setData_type( data_type );

			convertTypeNameToDataType( columnDef.getDatatype( ), data_type );
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

			TJoin join = select.joins.getJoin( i );
			TTable table = join.getTable( );
			TJoinItemList items = join.getJoinItems( );
			if ( items != null && items.size( ) > 0 )
			{
				for ( int j = 0; j < items.size( ); j++ )
				{
					TJoinItem item = items.getJoinItem( j );
					table_reference tableReference = new table_reference( );
					tableReferences.add( tableReference );
					joined_table joinedTable = new joined_table( );
					tableReference.setJoined_table( joinedTable );
					convertJoinItemToJoinedTable( table, item, joinedTable );
				}
			}
			else
			{
				table_reference tableReference = new table_reference( );
				tableReferences.add( tableReference );
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

	private void convertJoinItemToJoinedTable( TTable table, TJoinItem item,
			joined_table joinedTable )
	{
		if ( item.getJoinType( ) == EJoinType.natural
				|| item.getJoinType( ) == EJoinType.natural_full
				|| item.getJoinType( ) == EJoinType.natural_fullouter
				|| item.getJoinType( ) == EJoinType.natural_inner
				|| item.getJoinType( ) == EJoinType.natural_left
				|| item.getJoinType( ) == EJoinType.natural_leftouter
				|| item.getJoinType( ) == EJoinType.natural_right
				|| item.getJoinType( ) == EJoinType.natural_rightouter )
		{
			natural_join naturalJoin = new natural_join( );
			joinedTable.setNatural_join( naturalJoin );
			convertJoinItemToNaturalJoin( table, item, naturalJoin );
		}
		if ( item.getJoinType( ) == EJoinType.cross )
		{
			cross_join crossJoin = new cross_join( );
			joinedTable.setCross_join( crossJoin );

			table_factor tableFactor = new table_factor( );
			crossJoin.getTable_reference( ).setTable_factor( tableFactor );
			convertTableToTableFactor( table, tableFactor );

			convertTableToTableFactor( item.getTable( ),
					crossJoin.getTable_factor( ) );

		}
		if ( item.getJoinType( ) == EJoinType.full
				|| item.getJoinType( ) == EJoinType.fullouter
				|| item.getJoinType( ) == EJoinType.inner
				|| item.getJoinType( ) == EJoinType.left
				|| item.getJoinType( ) == EJoinType.leftouter
				|| item.getJoinType( ) == EJoinType.right
				|| item.getJoinType( ) == EJoinType.rightouter )
		{
			qualified_join qualifiedJoin = new qualified_join( );
			joinedTable.setQualified_join( qualifiedJoin );
			convertJoinItemToQualifiedJoin( table, item, qualifiedJoin );

			if ( item.getOnCondition( ) != null )
			{
				qualifiedJoin.getJoin_specification( )
						.setJoin_condition( new join_condition( ) );
				convertExpressionToJoinCondition( item.getOnCondition( ),
						qualifiedJoin.getJoin_specification( )
								.getJoin_condition( ) );
			}
			else if ( item.getUsingColumns( ) != null )
			{
				qualifiedJoin.getJoin_specification( )
						.setNamed_column_condition( new named_column_condition( ) );
				convertExpressionTotNamedColumnCondition( item.getUsingColumns( ),
						qualifiedJoin.getJoin_specification( )
								.getNamed_column_condition( ) );
			}
		}
	}

	private void convertExpressionTotNamedColumnCondition(
			TObjectNameList columns,
			named_column_condition named_column_condition )
	{
		List<column_name> columnNames = named_column_condition.getJoin_column_list( )
				.getColumn_name_list( )
				.getColumn_name( );
		for ( int i = 0; i < columns.size( ); i++ )
		{
			column_name columnName = new column_name( );
			columnNames.add( columnName );
			identifier identifier = columnName.getIdentifier( );
			convertObjectName2Model( columns.getObjectName( i ), identifier );
		}
	}

	private void convertExpressionToJoinCondition( TExpression onCondition,
			join_condition join_condition )
	{
		convertBooleanExpressionToModel( onCondition,
				join_condition.getSearch_condition( )
						.getBoolean_value_expression( ) );

	}

	private void convertJoinItemToQualifiedJoin( TTable table, TJoinItem item,
			qualified_join qualifiedJoin )
	{
		convertTableToQualifiedJoin( table, qualifiedJoin, false );
		convertTableToQualifiedJoin( item.getTable( ), qualifiedJoin, true );

		join_type joinType = new join_type( );
		qualifiedJoin.setJoin_type( joinType );
		convertJoinTypeToModel( item.getJoinType( ), joinType );

	}

	private void convertTableToQualifiedJoin( TTable table,
			qualified_join qualifiedJoin, boolean isJoinTable )
	{
		if ( table.getPartitionExtensionClause( ) != null )
		{
			partitioned_join_table partitionedJoinTable = new partitioned_join_table( );

			if ( !isJoinTable )
			{
				qualifiedJoin.setPartitioned_join_table( partitionedJoinTable );
			}
			else
			{
				qualifiedJoin.setJoin_partitioned_join_table( partitionedJoinTable );
			}
			convertTableToTableFactor( table,
					partitionedJoinTable.getTable_factor( ) );

			// FIXME lost PARTITION BY <partitioned join column reference list>
		}
		else
		{
			table_reference tableReference = new table_reference( );

			if ( !isJoinTable )
			{
				qualifiedJoin.setTable_reference( tableReference );
			}
			else
			{
				qualifiedJoin.setJoin_table_reference( tableReference );
			}

			table_factor tableFactor = new table_factor( );
			tableReference.setTable_factor( tableFactor );
			convertTableToTableFactor( table, tableFactor );
		}

	}

	private void convertJoinItemToNaturalJoin( TTable table, TJoinItem item,
			natural_join naturalJoin )
	{
		convertTableToNaturalJoin( table, naturalJoin, false );
		convertTableToNaturalJoin( item.getTable( ), naturalJoin, true );

		join_type joinType = new join_type( );
		naturalJoin.setJoin_type( joinType );
		convertJoinTypeToModel( item.getJoinType( ), joinType );

	}

	private void convertJoinTypeToModel( EJoinType joinType,
			join_type joinTypeModel )
	{
		if ( joinType == EJoinType.inner )
		{
			joinTypeModel.setKw_inner( "inner" );
		}
		else
		{
			outer_join_type_with_outer outerJoinTypeWithOuter = new outer_join_type_with_outer( );
			joinTypeModel.setOuter_join_type_with_outer( outerJoinTypeWithOuter );
			if ( joinType == EJoinType.fullouter
					|| joinType == EJoinType.leftouter
					|| joinType == EJoinType.rightouter
					|| joinType == EJoinType.natural_fullouter
					|| joinType == EJoinType.natural_leftouter
					|| joinType == EJoinType.natural_rightouter )
			{
				outerJoinTypeWithOuter.setKw_outer( "outer" );
			}
			if ( joinType == EJoinType.full
					|| joinType == EJoinType.fullouter
					|| joinType == EJoinType.natural_full
					|| joinType == EJoinType.natural_fullouter
					|| joinType == EJoinType.natural )
			{
				outerJoinTypeWithOuter.getOuter_join_type( )
						.setKw_full( "full" );
			}
			if ( joinType == EJoinType.left
					|| joinType == EJoinType.leftouter
					|| joinType == EJoinType.natural_left
					|| joinType == EJoinType.natural_leftouter )
			{
				outerJoinTypeWithOuter.getOuter_join_type( )
						.setKw_full( "left" );
			}
			if ( joinType == EJoinType.right
					|| joinType == EJoinType.rightouter
					|| joinType == EJoinType.natural_right
					|| joinType == EJoinType.natural_rightouter )
			{
				outerJoinTypeWithOuter.getOuter_join_type( )
						.setKw_full( "full" );
			}
		}
	}

	private void convertTableToNaturalJoin( TTable table,
			natural_join naturalJoin, boolean isJoinTable )
	{
		if ( table.getPartitionExtensionClause( ) != null )
		{
			partitioned_join_table partitionedJoinTable = new partitioned_join_table( );

			if ( !isJoinTable )
			{
				naturalJoin.setPartitioned_join_table( partitionedJoinTable );
			}
			else
			{
				naturalJoin.setJoin_partitioned_join_table( partitionedJoinTable );
			}
			convertTableToTableFactor( table,
					partitionedJoinTable.getTable_factor( ) );

			// FIXME lost PARTITION BY <partitioned join column reference list>
		}
		else
		{
			table_reference tableReference = new table_reference( );

			if ( !isJoinTable )
			{
				naturalJoin.setTable_reference( tableReference );
			}
			else
			{
				naturalJoin.setJoin_table_reference( tableReference );
			}

			table_factor tableFactor = new table_factor( );
			tableReference.setTable_factor( tableFactor );
			convertTableToTableFactor( table, tableFactor );
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
		if ( condition.getExpressionType( ) == EExpressionType.logical_not_t )
		{
			booleanFactor.setKw_not( "not" );
			convertBooleanExpressionToBooleanTest( condition.getRightOperand( ),
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
			{
				predicate predicate = new predicate( );
				boolean_primary.setPredicate( predicate );
				comparison_predicate comparisonPredicate = new comparison_predicate( );
				predicate.setComparison_predicate( comparisonPredicate );
				convertComparisonExpressionToComparisonPredicate( condition,
						comparisonPredicate );
			}
				break;
			case in_t :
			{
				predicate predicate = new predicate( );
				boolean_primary.setPredicate( predicate );
				in_predicate inPredicate = new in_predicate( );
				predicate.setIn_predicate( inPredicate );
				convertExpressionToInPredicate( condition, inPredicate );
			}
				break;
			case between_t :
			{
				predicate predicate = new predicate( );
				boolean_primary.setPredicate( predicate );
				between_predicate betweenPredicate = new between_predicate( );
				predicate.setBetween_predicate( betweenPredicate );
				convertExpressionToBetweenPredicate( condition,
						betweenPredicate );
			}
				break;
			case null_t :
			{
				predicate predicate = new predicate( );
				boolean_primary.setPredicate( predicate );
				null_predicate nullPredicate = new null_predicate( );
				predicate.setNull_predicate( nullPredicate );
				convertExpressionToNullPredicate( condition, nullPredicate );
			}
				break;
			case exists_t :
			{
				predicate predicate = new predicate( );
				boolean_primary.setPredicate( predicate );
				exists_predicate existsPredicate = new exists_predicate( );
				predicate.setExists_predicate( existsPredicate );
				convertExpressionToExistsPredicate( condition, existsPredicate );
			}
				break;
			case pattern_matching_t :
			{

				predicate predicate = new predicate( );
				boolean_primary.setPredicate( predicate );
				like_predicate likePredicate = new like_predicate( );
				predicate.setLike_predicate( likePredicate );
				convertExpressionToLikePredicate( condition, likePredicate );
			}
				break;
			case member_of_t :
			{
				predicate predicate = new predicate( );
				boolean_primary.setPredicate( predicate );
				member_predicate memberPredicate = new member_predicate( );
				predicate.setMember_predicate( memberPredicate );
				convertExpressionToMemberPredicate( condition, memberPredicate );
			}
				break;
			case parenthesis_t :
			{
				boolean_predicand boolean_predicand = new boolean_predicand( );
				boolean_primary.setBoolean_predicand( boolean_predicand );
				parenthesized_boolean_value_expression parenthesized_boolean_value_expression = new parenthesized_boolean_value_expression( );
				boolean_predicand.setParenthesized_boolean_value_expression( parenthesized_boolean_value_expression );
				convertBooleanExpressionToModel( condition.getLeftOperand( ),
						parenthesized_boolean_value_expression.getBoolean_value_expression( ) );
			}
				break;
			case is_of_type_t :
			{

			}
				break;
		}

	}

	private void convertExpressionToMemberPredicate( TExpression condition,
			member_predicate memberPredicate )
	{
		convertExpressionToRowValuePredicand( condition.getLeftOperand( ),
				memberPredicate.getRow_value_predicand( ) );
		convertExpressionToMemberPredicatePart2( condition,
				memberPredicate.getMember_predicate_part_2( ) );

	}

	private void convertExpressionToMemberPredicatePart2(
			TExpression condition,
			member_predicate_part_2 member_predicate_part_2 )
	{
		if ( condition.getNotToken( ) != null )
		{
			member_predicate_part_2.setKw_not( "not" );
		}

		if ( SourceTokenSearcher.indexOf( condition.getStartToken( ).container,
				condition.getStartToken( ).posinlist,
				condition.getEndToken( ).posinlist,
				"OF" ) != -1 )
		{
			member_predicate_part_2.setKw_of( "of" );
		}

		convertExpressionToMultisetValueExpression( condition.getRightOperand( ),
				member_predicate_part_2.getMultiset_value_expression( ) );
	}

	private void convertExpressionToMultisetValueExpression(
			TExpression expression,
			multiset_value_expression multiset_value_expression )
	{
		multiset_term multiset_term = new multiset_term( );
		multiset_value_expression.setMultiset_term( multiset_term );
		multiset_primary multiset_primary = new multiset_primary( );
		multiset_term.setMultiset_primary( multiset_primary );
		value_expression_primary value_expression_primary = new value_expression_primary( );
		multiset_primary.setValue_expression_primary( value_expression_primary );
		convertExpressionToValueExpressionPrimary( expression,
				value_expression_primary );
	}

	private void convertExpressionToLikePredicate( TExpression condition,
			like_predicate likePredicate )
	{
		character_like_predicate character_like_predicate = new character_like_predicate( );
		likePredicate.setCharacter_like_predicate( character_like_predicate );
		convertExpressionToRowValuePredicand( condition.getLeftOperand( ),
				character_like_predicate.getRow_value_predicand( ) );
		convertExpressionToCharacterLikePredicatePart2( condition,
				character_like_predicate.getCharacter_like_predicate_part_2( ) );
	}

	private void convertExpressionToCharacterLikePredicatePart2(
			TExpression condition,
			character_like_predicate_part_2 character_like_predicate_part_2 )
	{
		if ( condition.getNotToken( ) != null )
		{
			character_like_predicate_part_2.setKw_not( "not" );
		}
		if ( condition.getLikeEscapeOperand( ) != null )
		{
			escape_character_clause escape_character_clause = new escape_character_clause( );
			character_like_predicate_part_2.setEscape_character_clause( escape_character_clause );
			convertExpressionToCharacterValueExpression( condition.getLikeEscapeOperand( ),
					escape_character_clause.getEscape_character( )
							.getCharacter_value_expression( ) );
		}

		convertExpressionToCharacterValueExpression( condition.getRightOperand( ),
				character_like_predicate_part_2.getCharacter_pattern( )
						.getCharacter_value_expression( ) );
	}

	private void convertExpressionToExistsPredicate( TExpression expression,
			exists_predicate existsPredicate )
	{
		convertSelectToQueryExpression( expression.getSubQuery( ),
				existsPredicate.getTable_subquery( )
						.getSubquery( )
						.getQuery_expression( ) );

	}

	private void convertExpressionToBetweenPredicate( TExpression condition,
			between_predicate betweenPredicate )
	{
		convertExpressionToRowValuePredicand( condition.getBetweenOperand( ),
				betweenPredicate.getRow_value_predicand( ) );
		convertExpressionToBetweenPredicatePart2( condition,
				betweenPredicate.getBetween_predicate_part_2( ) );
	}

	private void convertExpressionToBetweenPredicatePart2(
			TExpression condition,
			between_predicate_part_2 between_predicate_part_2 )
	{
		if ( condition.getNotToken( ) != null )
		{
			between_predicate_part_2.setKw_not( "not" );
		}

		TExpression leftExpression = condition.getLeftOperand( );
		convertExpressionToRowValueRredicand( leftExpression,
				between_predicate_part_2,
				true );
		TExpression rightExpression = condition.getRightOperand( );
		convertExpressionToRowValueRredicand( rightExpression,
				between_predicate_part_2,
				false );
	}

	private void convertExpressionToInPredicate( TExpression condition,
			in_predicate inPredicate )
	{
		convertExpressionToRowValuePredicand( condition.getLeftOperand( ),
				inPredicate.getRow_value_predicand( ) );
		convertExpressionToInPredicatePart2( condition,
				inPredicate.getIn_predicate_part_2( ) );
	}

	private void convertExpressionToNullPredicate( TExpression condition,
			null_predicate nullPredicate )
	{
		convertExpressionToRowValuePredicand( condition.getLeftOperand( ),
				nullPredicate.getRow_value_predicand( ) );
		convertExpressionToNullPredicatePart2( condition,
				nullPredicate.getNull_predicate_part_2( ) );
	}

	private void convertExpressionToNullPredicatePart2( TExpression condition,
			null_predicate_part_2 null_predicate_part_2 )
	{
		if ( condition.getNotToken( ) != null )
		{
			null_predicate_part_2.setKw_not( "not" );
		}
	}

	private void convertExpressionToInPredicatePart2( TExpression condition,
			in_predicate_part_2 in_predicate_part_2 )
	{
		if ( condition.getNotToken( ) != null )
		{
			in_predicate_part_2.setKw_not( "not" );
		}
		convertExpressionToInPredicateValue( condition.getRightOperand( ),
				in_predicate_part_2.getIn_predicate_value( ) );
	}

	private void convertExpressionToInPredicateValue( TExpression expression,
			in_predicate_value in_predicate_value )
	{

		if ( expression.getExpressionType( ) == EExpressionType.list_t )
		{
			in_value_list inValueList = new in_value_list( );
			in_predicate_value.setIn_value_list( inValueList );
			List<row_value_expression> rowValueExpressions = inValueList.getRow_value_expression( );
			for ( int i = 0; i < expression.getExprList( ).size( ); i++ )
			{
				TExpression value = expression.getExprList( ).getExpression( i );
				row_value_expression rowValueExpression = new row_value_expression( );
				rowValueExpressions.add( rowValueExpression );
				convertExpressionToRowValueExpression( value,
						rowValueExpression );
			}
		}
		else if ( expression.getExpressionType( ) == EExpressionType.subquery_t )
		{
			table_subquery tableSubquery = new table_subquery( );
			in_predicate_value.setTable_subquery( tableSubquery );
			convertSelectToQueryExpression( expression.getSubQuery( ),
					tableSubquery.getSubquery( ).getQuery_expression( ) );
		}
	}

	private void convertExpressionToRowValueExpression( TExpression expression,
			row_value_expression rowValueExpression )
	{
		if ( expression.getExpressionType( ) == EExpressionType.simple_constant_t
				|| expression.getExpressionType( ) == EExpressionType.simple_object_name_t )
		{
			row_value_special_case rowValueSpecialCase = new row_value_special_case( );
			rowValueExpression.setRow_value_special_case( rowValueSpecialCase );
			convertExpressionToNonParenthesizedValueExpression( expression,
					rowValueSpecialCase.getNonparenthesized_value_expression_primary( ) );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.function_t
				&& ( Utility.isAggregateFunction( expression.getFunctionCall( )
						.getFunctionName( )
						.toString( ) ) ) )
		{
			row_value_special_case rowValueSpecialCase = new row_value_special_case( );
			rowValueExpression.setRow_value_special_case( rowValueSpecialCase );
			convertExpressionToNonParenthesizedValueExpression( expression,
					rowValueSpecialCase.getNonparenthesized_value_expression_primary( ) );
		}
		else
		{
			explicit_row_value_constructor explicitRowValueConstructor = new explicit_row_value_constructor( );
			rowValueExpression.setExplicit_row_value_constructor( explicitRowValueConstructor );
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
			compop.setLess_than_operator( "<" );
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

	private void convertExpressionToRowValueRredicand( TExpression expression,
			between_predicate_part_2 between_predicate_part_2,
			boolean leftExpression )
	{
		if ( expression.getExpressionType( ) == EExpressionType.simple_constant_t
				|| expression.getExpressionType( ) == EExpressionType.simple_object_name_t )
		{
			row_value_special_case rowValueSpecialCase = new row_value_special_case( );
			if ( leftExpression )
			{
				between_predicate_part_2.setLeft_row_value_special_case( rowValueSpecialCase );
			}
			else
			{
				between_predicate_part_2.setRight_row_value_special_case( rowValueSpecialCase );
			}
			convertExpressionToNonParenthesizedValueExpression( expression,
					rowValueSpecialCase.getNonparenthesized_value_expression_primary( ) );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.function_t
				&& ( Utility.isAggregateFunction( expression.getFunctionCall( )
						.getFunctionName( )
						.toString( ) ) ) )
		{
			row_value_special_case rowValueSpecialCase = new row_value_special_case( );
			if ( leftExpression )
			{
				between_predicate_part_2.setLeft_row_value_special_case( rowValueSpecialCase );
			}
			else
			{
				between_predicate_part_2.setRight_row_value_special_case( rowValueSpecialCase );
			}
			convertExpressionToNonParenthesizedValueExpression( expression,
					rowValueSpecialCase.getNonparenthesized_value_expression_primary( ) );
		}
		else
		{
			row_value_constructor_predicand rowValueConstructorPredicand = new row_value_constructor_predicand( );
			if ( leftExpression )
			{
				between_predicate_part_2.setLeft_row_value_constructor_predicand( rowValueConstructorPredicand );
			}
			else
			{
				between_predicate_part_2.setRight_row_value_constructor_predicand( rowValueConstructorPredicand );
			}
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

		convertOrderbyClauseToSortSpecificationList( orderby,
				sortSpecificationList );
	}

	private void convertOrderbyClauseToSortSpecificationList( TOrderBy orderby,
			sort_specification_list sortSpecificationList )
	{
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
				orderingSpecification.setKw_asc( "asc" );
				sortSpecification.setOrdering_specification( orderingSpecification );
			}
			else if ( item.getSortType( ) == TBaseType.srtDesc )
			{
				ordering_specification orderingSpecification = new ordering_specification( );
				orderingSpecification.setKw_desc( "desc" );
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
		if ( isCastExpression( expression ) )
		{
			reference_value_expression referenceValueExpression = new reference_value_expression( );
			commonValueExpression.setReference_value_expression( referenceValueExpression );
			convertExpressionToValueExpressionPrimary( expression,
					referenceValueExpression.getValue_expression_primary( ) );
		}
		else if ( isCaseAbbreviationExpression( expression ) )
		{
			reference_value_expression referenceValueExpression = new reference_value_expression( );
			commonValueExpression.setReference_value_expression( referenceValueExpression );
			convertExpressionToValueExpressionPrimary( expression,
					referenceValueExpression.getValue_expression_primary( ) );
		}
		else if ( isCaseExpression( expression ) )
		{
			reference_value_expression referenceValueExpression = new reference_value_expression( );
			commonValueExpression.setReference_value_expression( referenceValueExpression );
			convertExpressionToValueExpressionPrimary( expression,
					referenceValueExpression.getValue_expression_primary( ) );
		}
		else if ( isWindowFunctionExpression( expression ) )
		{
			reference_value_expression referenceValueExpression = new reference_value_expression( );
			commonValueExpression.setReference_value_expression( referenceValueExpression );
			convertExpressionToValueExpressionPrimary( expression,
					referenceValueExpression.getValue_expression_primary( ) );
		}
		else if ( isDateTypeValueExpression( expression ) )
		{
			datetime_value_expression datetimeValueExpression = new datetime_value_expression( );
			commonValueExpression.setDatetime_value_expression( datetimeValueExpression );
			convertExpressionToDatetimeValueExpression( expression,
					datetimeValueExpression );
		}
		else if ( isIntervalValueExpression( expression ) )
		{
			interval_value_expression intervalValueExpression = new interval_value_expression( );
			commonValueExpression.setInterval_value_expression( intervalValueExpression );
			convertExpressionToIntervalValueExpression( expression,
					intervalValueExpression );
		}
		else if ( isNumericValueExpression( expression ) )
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
			reference_value_expression referenceValueExpression = new reference_value_expression( );
			commonValueExpression.setReference_value_expression( referenceValueExpression );
			convertExpressionToValueExpressionPrimary( expression,
					referenceValueExpression.getValue_expression_primary( ) );
		}

	}

	private boolean isCaseExpression( TExpression expression )
	{
		return expression.getExpressionType( ) == EExpressionType.case_t;
	}

	private void convertExpressionToDatetimeValueExpression(
			TExpression expression,
			datetime_value_expression datetimeValueExpression )
	{
		if ( expression.getExpressionType( ) == EExpressionType.arithmetic_plus_t )
		{
			if ( isDateTypeValueExpression( expression.getLeftOperand( ) ) )
			{
				datetime_value_expression_plus_interval_term datetimeValuePlusExpression = new datetime_value_expression_plus_interval_term( );
				datetimeValueExpression.setDatetime_value_expression_plus_interval_term( datetimeValuePlusExpression );
				convertExpressionToDatetimeValueExpression( expression.getLeftOperand( ),
						datetimeValuePlusExpression.getDatetime_value_expression( ) );
				convertExpressionToIntervalTerm( expression.getRightOperand( ),
						datetimeValuePlusExpression.getInterval_term( ) );
			}
		}
		else if ( expression.getExpressionType( ) == EExpressionType.arithmetic_minus_t )
		{
			if ( isDateTypeValueExpression( expression.getLeftOperand( ) ) )
			{
				datetime_value_expression_minus_interval_term datetimeValueMinusExpression = new datetime_value_expression_minus_interval_term( );
				datetimeValueExpression.setDatetime_value_expression_minus_interval_term( datetimeValueMinusExpression );
				convertExpressionToDatetimeValueExpression( expression.getLeftOperand( ),
						datetimeValueMinusExpression.getDatetime_value_expression( ) );
				convertExpressionToIntervalTerm( expression.getRightOperand( ),
						datetimeValueMinusExpression.getInterval_term( ) );
			}
		}
		else
		{
			datetime_term datetimeTerm = new datetime_term( );
			datetimeValueExpression.setDatetime_term( datetimeTerm );
			convertExpressionToDateTimeFactor( expression,
					datetimeTerm.getDatetime_factor( ) );
		}
	}

	private void convertExpressionToIntervalValueExpression(
			TExpression expression,
			interval_value_expression intervalValueExpression )
	{
		if ( expression.getExpressionType( ) == EExpressionType.arithmetic_plus_t )
		{
			if ( isIntervalValueExpression( expression.getLeftOperand( ) ) )
			{
				interval_value_expression_plus_interval_term intervalValuePlusExpression = new interval_value_expression_plus_interval_term( );
				intervalValueExpression.setInterval_value_expression_plus_interval_term( intervalValuePlusExpression );
				convertExpressionToIntervalValueExpression( expression.getLeftOperand( ),
						intervalValuePlusExpression.getInterval_value_expression_1( )
								.getInterval_value_expression( ) );
				convertExpressionToIntervalTerm( expression.getRightOperand( ),
						intervalValuePlusExpression.getInterval_term_1( )
								.getInterval_term( ) );
			}
		}
		else if ( expression.getExpressionType( ) == EExpressionType.arithmetic_minus_t )
		{
			if ( isDateTypeValueExpression( expression.getLeftOperand( ) ) )
			{
				interval_value_expression_minus_interval_term intervalValuePlusExpression = new interval_value_expression_minus_interval_term( );
				intervalValueExpression.setInterval_value_expression_minus_interval_term( intervalValuePlusExpression );
				convertExpressionToIntervalValueExpression( expression.getLeftOperand( ),
						intervalValuePlusExpression.getInterval_value_expression_1( )
								.getInterval_value_expression( ) );
				convertExpressionToIntervalTerm( expression.getRightOperand( ),
						intervalValuePlusExpression.getInterval_term_1( )
								.getInterval_term( ) );
			}
		}
		else
		{
			interval_term intervalTerm = new interval_term( );
			intervalValueExpression.setInterval_term( intervalTerm );
			convertExpressionToIntervalTerm( expression, intervalTerm );
		}
	}

	private void convertExpressionToIntervalTerm( TExpression expression,
			interval_term interval_term )
	{
		if ( expression.getExpressionType( ) == EExpressionType.arithmetic_plus_t )
		{
			interval_factor intervalFactor = new interval_factor( );
			interval_term.setInterval_factor( intervalFactor );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.arithmetic_minus_t )
		{
			interval_factor intervalFactor = new interval_factor( );
			interval_term.setInterval_factor( intervalFactor );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.arithmetic_divide_t )
		{
			interval_term_solidus intervalTermSolidus = new interval_term_solidus( );
			interval_term.setInterval_term_solidus( intervalTermSolidus );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.arithmetic_times_t )
		{
			interval_term_asterisk intervalTermAsterisk = new interval_term_asterisk( );
			interval_term.setInterval_term_asterisk( intervalTermAsterisk );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.simple_constant_t )
		{
			interval_factor intervalFactor = new interval_factor( );
			interval_term.setInterval_factor( intervalFactor );
			value_expression_primary_interval_qualifier value_expression_primary_interval_qualifier = new value_expression_primary_interval_qualifier( );
			intervalFactor.getInterval_primary( )
					.setValue_expression_primary_interval_qualifier( value_expression_primary_interval_qualifier );
			convertExpressionToValueExpressionPrimary( expression,
					value_expression_primary_interval_qualifier.getValue_expression_primary( ) );
		}
		else
		{

		}
	}

	private void convertExpressionToDateTimeFactor( TExpression expression,
			datetime_factor datetime_factor )
	{
		convertExpressionToDateTimePrimary( expression,
				datetime_factor.getDatetime_primary( ) );
		// FIXME ingore time zone here.
	}

	private void convertExpressionToDateTimePrimary( TExpression expression,
			datetime_primary datetime_primary )
	{
		if ( expression.getExpressionType( ) == EExpressionType.simple_constant_t )
		{
			value_expression_primary valueExpressionPrimary = new value_expression_primary( );
			datetime_primary.setValue_expression_primary( valueExpressionPrimary );
			convertExpressionToValueExpressionPrimary( expression,
					valueExpressionPrimary );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.function_t )
		{
			datetime_value_function datetimeValueFunction = new datetime_value_function( );
			datetime_primary.setDatetime_value_function( datetimeValueFunction );
			convertExpressionToDateTimeValueFunction( expression,
					datetimeValueFunction );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.simple_object_name_t )
		{
			datetime_value_function datetimeValueFunction = new datetime_value_function( );
			datetime_primary.setDatetime_value_function( datetimeValueFunction );
			convertExpressionToDateTimeValueFunction( expression,
					datetimeValueFunction );
		}
	}

	private void convertExpressionToDateTimeValueFunction(
			TExpression expression,
			datetime_value_function datetimeValueFunction )
	{
		String expressionContent = expression.toString( ).trim( ).toUpperCase( );
		if ( "CURRENT_DATE".equals( expressionContent ) )
		{
			current_date_value_function current_date_value_function = new current_date_value_function( );
			datetimeValueFunction.setCurrent_date_value_function( current_date_value_function );
		}
		else if ( "CURRENT_TIME".equals( expressionContent ) )
		{
			current_time_value_function current_time_value_function = new current_time_value_function( );
			datetimeValueFunction.setCurrent_time_value_function( current_time_value_function );
		}
		else if ( expressionContent.startsWith( "CURRENT_TIMESTAMP" ) )
		{
			current_timestamp_value_function current_timestamp_value_function = new current_timestamp_value_function( );
			datetimeValueFunction.setCurrent_timestamp_value_function( current_timestamp_value_function );
		}
		else if ( expressionContent.startsWith( "LOCALTIME" ) )
		{
			current_local_time_value_function current_local_time_value_function = new current_local_time_value_function( );
			datetimeValueFunction.setCurrent_local_time_value_function( current_local_time_value_function );
		}
		else if ( expressionContent.startsWith( "LOCALTIMESTAMP" ) )
		{
			current_local_timestamp_value_function current_local_timestamp_value_function = new current_local_timestamp_value_function( );
			datetimeValueFunction.setCurrent_local_timestamp_value_function( current_local_timestamp_value_function );
		}
	}

	private boolean isDateTypeValueExpression( TExpression expression )
	{
		if ( expression.getExpressionType( ) == EExpressionType.arithmetic_plus_t
				|| expression.getExpressionType( ) == EExpressionType.arithmetic_minus_t )
		{
			if ( expression.getLeftOperand( ) != null )
				return isDateTypeValueExpression( expression.getLeftOperand( ) );
			else
				return false;
		}
		else if ( expression.getExpressionType( ) == EExpressionType.simple_constant_t )
		{
			if ( Utility.isDateTypeValue( expression.toString( ) ) )
			{
				return true;
			}
		}
		else if ( expression.getExpressionType( ) == EExpressionType.function_t )
		{
			String functionName = expression.getFunctionCall( )
					.getFunctionName( )
					.toString( );
			if ( Utility.isDateTypeValueFunction( functionName ) )
			{
				return true;
			}
		}
		else if ( expression.getExpressionType( ) == EExpressionType.simple_object_name_t )
		{
			String functionName = expression.toString( );
			if ( Utility.isDateTypeValueFunction( functionName ) )
			{
				return true;
			}
		}
		return false;
	}

	private boolean isIntervalValueExpression( TExpression expression )
	{
		if ( expression.getExpressionType( ) == EExpressionType.arithmetic_plus_t
				|| expression.getExpressionType( ) == EExpressionType.arithmetic_minus_t )
		{
			if ( expression.getLeftOperand( ) != null )
				return isIntervalValueExpression( expression.getLeftOperand( ) );
			else
				return false;
		}
		else if ( expression.getExpressionType( ) == EExpressionType.simple_constant_t )
		{
			if ( Utility.isIntervalTypeValue( expression.toString( ) ) )
			{
				return true;
			}
		}
		return false;
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
				else if ( isWindowFunctionExpression( expression ) )
				{
					window_function windowFunction = new window_function( );
					nonparenthesizedValueExpressionPrimary.setWindow_function( windowFunction );
					convertExpressionToWindowFunction( expression,
							windowFunction );
				}
				else if ( isCaseAbbreviationExpression( expression ) )
				{
					case_expression caseExpression = new case_expression( );
					nonparenthesizedValueExpressionPrimary.setCase_expression( caseExpression );
					case_abbreviation caseAbbreviation = new case_abbreviation( );
					caseExpression.setCase_abbreviation( caseAbbreviation );
					convertExpressionToCaseAbbreviationExpression( expression,
							caseAbbreviation );
				}
				else if ( isCastExpression( expression ) )
				{
					cast_specification castSpecification = new cast_specification( );
					nonparenthesizedValueExpressionPrimary.setCast_specification( castSpecification );
					convertExpressionToCastOperand( expression.getFunctionCall( )
							.getExpr1( ),
							castSpecification.getCast_operand( ) );
					data_type data_type = new data_type( );
					castSpecification.getCast_target( )
							.setData_type( data_type );
					convertTypeNameToDataType( expression.getFunctionCall( )
							.getTypename( ), data_type );
				}
				break;
			case case_t :
			{
				case_expression caseExpression = new case_expression( );
				nonparenthesizedValueExpressionPrimary.setCase_expression( caseExpression );
				case_specification caseSpecification = new case_specification( );
				caseExpression.setCase_specification( caseSpecification );
				convertExpressionToCaseSpecification( expression,
						caseSpecification );
			}
				break;
			default :
		}

	}

	private void convertTypeNameToDataType( TTypeName typename,
			data_type data_type )
	{

		switch ( typename.getDataType( ) )
		{
			case float_t :
			{
				predefined_type type = createPredefinedType( data_type );
				numeric_type numeric_type = new numeric_type( );
				type.setNumeric_type( numeric_type );
				approximate_numeric_type approximate_numeric_type = new approximate_numeric_type( );
				numeric_type.setApproximate_numeric_type( approximate_numeric_type );
				float_with_precision float_with_precision = new float_with_precision( );
				approximate_numeric_type.setFloat_with_precision( float_with_precision );
				if ( typename.getLength( ) != null )
				{
					precision precision = new precision( );
					precision.setUnsigned_integer( typename.getLength( )
							.toString( ) );
					float_with_precision.setPrecision( precision );
				}
			}
				break;
			case real_t :
			{
				predefined_type type = createPredefinedType( data_type );
				numeric_type numeric_type = new numeric_type( );
				type.setNumeric_type( numeric_type );
				approximate_numeric_type approximate_numeric_type = new approximate_numeric_type( );
				numeric_type.setApproximate_numeric_type( approximate_numeric_type );
				approximate_numeric_type.setKw_real( "real" );
			}
				break;
			case double_t :
			case double_precision_t :
			{
				predefined_type type = createPredefinedType( data_type );
				numeric_type numeric_type = new numeric_type( );
				type.setNumeric_type( numeric_type );
				approximate_numeric_type approximate_numeric_type = new approximate_numeric_type( );
				numeric_type.setApproximate_numeric_type( approximate_numeric_type );
				approximate_numeric_type.setKw_double_precision( "double precision" );
			}
				break;
			case dec_t :
			{
				predefined_type type = createPredefinedType( data_type );
				numeric_type numeric_type = new numeric_type( );
				type.setNumeric_type( numeric_type );
				exact_numeric_type exact_numeric_type = new exact_numeric_type( );
				numeric_type.setExact_numeric_type( exact_numeric_type );
				if ( typename.toString( ).toUpperCase( ).startsWith( "DECIMAL" ) )
				{
					decimal_with_precision_scale decimal_with_precision_scale = new decimal_with_precision_scale( );
					exact_numeric_type.setDecimal_with_precision_scale( decimal_with_precision_scale );
					decimal_with_precision_scale.setPrecision_scale( getTypeNamePrecision( typename ) );
				}
				else if ( typename.toString( )
						.toUpperCase( )
						.startsWith( "DEC" ) )
				{
					dec_with_precision_scale dec_with_precision_scale = new dec_with_precision_scale( );
					exact_numeric_type.setDec_with_precision_scale( dec_with_precision_scale );
					dec_with_precision_scale.setPrecision_scale( getTypeNamePrecision( typename ) );
				}
			}
				break;
			case smallint_t :
			{
				predefined_type type = createPredefinedType( data_type );
				numeric_type numeric_type = new numeric_type( );
				type.setNumeric_type( numeric_type );
				exact_numeric_type exact_numeric_type = new exact_numeric_type( );
				numeric_type.setExact_numeric_type( exact_numeric_type );
				exact_numeric_type.setKw_smallint( "smallint" );
			}
				break;
			case int_t :
			{
				predefined_type type = createPredefinedType( data_type );
				numeric_type numeric_type = new numeric_type( );
				type.setNumeric_type( numeric_type );
				exact_numeric_type exact_numeric_type = new exact_numeric_type( );
				numeric_type.setExact_numeric_type( exact_numeric_type );
				if ( typename.toString( ).equalsIgnoreCase( "INTEGER" ) )
					exact_numeric_type.setKw_integer( "integer" );
				else if ( typename.toString( ).equalsIgnoreCase( "INT" ) )
					exact_numeric_type.setKw_int( "int" );
			}
				break;
			case bigint_t :
			{
				predefined_type type = createPredefinedType( data_type );
				numeric_type numeric_type = new numeric_type( );
				type.setNumeric_type( numeric_type );
				exact_numeric_type exact_numeric_type = new exact_numeric_type( );
				numeric_type.setExact_numeric_type( exact_numeric_type );
				exact_numeric_type.setKw_bigint( "bigint" );
			}
				break;
			case numeric_t :
			{
				predefined_type type = createPredefinedType( data_type );
				numeric_type numeric_type = new numeric_type( );
				type.setNumeric_type( numeric_type );
				exact_numeric_type exact_numeric_type = new exact_numeric_type( );
				numeric_type.setExact_numeric_type( exact_numeric_type );
				numeric_with_precision_scale numeric_with_precision_scale = new numeric_with_precision_scale( );
				exact_numeric_type.setNumeric_with_precision_scale( numeric_with_precision_scale );
				numeric_with_precision_scale.setPrecision_scale( getTypeNamePrecision( typename ) );
			}
				break;
			case char_t :
			{
				predefined_type type = createPredefinedType( data_type );
				character_string_type_with_charater_set_collate character_string_type_with_charater_set_collate = new character_string_type_with_charater_set_collate( );
				type.setCharacter_string_type_with_charater_set_collate( character_string_type_with_charater_set_collate );
				character_string_type character_string_type = character_string_type_with_charater_set_collate.getCharacter_string_type( );
				if ( typename.toString( )
						.toUpperCase( )
						.startsWith( "CHARACTER" ) )
				{
					character_with_length character_with_length = new character_with_length( );
					character_string_type.setCharacter_with_length( character_with_length );
					if ( typename.getLength( ) != null )
					{
						length length = new length( );
						character_with_length.setLength( length );
						length.setUnsigned_integer( typename.getLength( )
								.toString( ) );
					}
				}
				else if ( typename.toString( )
						.toUpperCase( )
						.startsWith( "CHAR" ) )
				{
					char_with_length char_with_length = new char_with_length( );
					character_string_type.setChar_with_length( char_with_length );
					if ( typename.getLength( ) != null )
					{
						length length = new length( );
						char_with_length.setLength( length );
						length.setUnsigned_integer( typename.getLength( )
								.toString( ) );
					}
				}
			}
				break;
			case varchar_t :
			case varchar2_t :
			{
				predefined_type type = createPredefinedType( data_type );
				character_string_type_with_charater_set_collate character_string_type_with_charater_set_collate = new character_string_type_with_charater_set_collate( );
				type.setCharacter_string_type_with_charater_set_collate( character_string_type_with_charater_set_collate );
				character_string_type character_string_type = character_string_type_with_charater_set_collate.getCharacter_string_type( );
				if ( typename.toString( ).toUpperCase( ).startsWith( "VARCHAR" ) )
				{
					varchar_with_length varchar_with_length = new varchar_with_length( );
					character_string_type.setVarchar_with_length( varchar_with_length );
					if ( typename.getLength( ) != null )
					{
						length length = new length( );
						varchar_with_length.setLength( length );
						length.setUnsigned_integer( typename.getLength( )
								.toString( ) );
					}
				}
				else if ( typename.toString( )
						.matches( "(?i).*char\\s+varying.*" ) )
				{
					char_varying char_varying = new char_varying( );
					character_string_type.setChar_varying( char_varying );
					if ( typename.getLength( ) != null )
					{
						length length = new length( );
						char_varying.setLength( length );
						length.setUnsigned_integer( typename.getLength( )
								.toString( ) );
					}
				}
				else if ( typename.toString( )
						.matches( "(?i).*character\\s+varying.*" ) )
				{
					character_varying_with_length character_varying_with_length = new character_varying_with_length( );
					character_string_type.setCharacter_varying_with_length( character_varying_with_length );
					if ( typename.getLength( ) != null )
					{
						length length = new length( );
						character_varying_with_length.setLength( length );
						length.setUnsigned_integer( typename.getLength( )
								.toString( ) );
					}
				}
			}
				break;
			case nvarchar_t :
			{

			}
				break;
			case char_large_object_t :
				break;
			case clob_t :
			{
				predefined_type type = createPredefinedType( data_type );
				character_string_type_with_charater_set_collate character_string_type_with_charater_set_collate = new character_string_type_with_charater_set_collate( );
				type.setCharacter_string_type_with_charater_set_collate( character_string_type_with_charater_set_collate );
				character_string_type character_string_type = character_string_type_with_charater_set_collate.getCharacter_string_type( );
				character_large_object_type character_large_object_type = new character_large_object_type( );
				character_string_type.setCharacter_large_object_type( character_large_object_type );
				clob_with_length clob_with_length = new clob_with_length( );
				character_large_object_type.setClob_with_length( clob_with_length );
			}
				break;
			case timestamp_with_time_zone_t :
			case timestamp_with_local_time_zone_t :
			{
				predefined_type type = createPredefinedType( data_type );
				datetime_type datetime_type = new datetime_type( );
				type.setDatetime_type( datetime_type );
				timestamp_precision_zone timestamp_precision_zone = new timestamp_precision_zone( );
				datetime_type.setTimestamp_precision_zone( timestamp_precision_zone );
				with_or_without_time_zone with_or_without_time_zone = new with_or_without_time_zone( );
				timestamp_precision_zone.setWith_or_without_time_zone( with_or_without_time_zone );
				with_or_without_time_zone.setWith_time_zone( new with_time_zone( ) );
			}
				break;
		}
	}

	private precision_scale getTypeNamePrecision( TTypeName typename )
	{
		precision_scale precision_scale = null;
		if ( typename.getPrecision( ) != null )
		{
			precision_scale = new precision_scale( );
			precision_scale.getPrecision( )
					.setUnsigned_integer( typename.getPrecision( ).toString( ) );
			if ( typename.getScale( ) != null )
			{
				scale scale = new scale( );
				precision_scale.setScale( scale );
				scale.setUnsigned_integer( typename.getScale( ).toString( ) );
			}
		}
		return precision_scale;
	}

	private predefined_type createPredefinedType( data_type dataType )
	{
		predefined_type predefined_type = new predefined_type( );
		dataType.setPredefined_type( predefined_type );
		return predefined_type;
	}

	private void convertExpressionToCastOperand( TExpression expression,
			cast_operand cast_operand )
	{
		String expressionContent = expression.toString( ).trim( ).toUpperCase( );
		if ( expressionContent.equals( "NULL" ) )
		{
			implicitly_typed_value_specification implicitly_typed_value_specification = new implicitly_typed_value_specification( );
			cast_operand.setImplicitly_typed_value_specification( implicitly_typed_value_specification );
			implicitly_typed_value_specification.setNull_specification( new null_specification( ) );
		}
		else if ( expressionContent.startsWith( "ARRAY" ) )
		{
			implicitly_typed_value_specification implicitly_typed_value_specification = new implicitly_typed_value_specification( );
			cast_operand.setImplicitly_typed_value_specification( implicitly_typed_value_specification );
			empty_specification empty_specification = new empty_specification( );
			implicitly_typed_value_specification.setEmpty_specification( empty_specification );
			empty_specification.setKw_array( "array" );
		}
		else if ( expressionContent.startsWith( "MULTISET" ) )
		{
			implicitly_typed_value_specification implicitly_typed_value_specification = new implicitly_typed_value_specification( );
			cast_operand.setImplicitly_typed_value_specification( implicitly_typed_value_specification );
			empty_specification empty_specification = new empty_specification( );
			implicitly_typed_value_specification.setEmpty_specification( empty_specification );
			empty_specification.setKw_multiset( "multiset" );
		}
		else
		{
			value_expression value_expression = new value_expression( );
			cast_operand.setValue_expression( value_expression );
			convertExpressionToValueExpression( expression, value_expression );
		}
	}

	private void convertExpressionToCaseSpecification( TExpression expression,
			case_specification caseSpecification )
	{
		TCaseExpression caseExpression = expression.getCaseExpression( );
		if ( caseExpression.getInput_expr( ) != null )
		{
			simple_case simple_case = new simple_case( );
			caseSpecification.setSimple_case( simple_case );
			convertExpressionToCaseOperand( caseExpression.getInput_expr( ),
					simple_case.getCase_operand( ) );
			convertExpressionToSimpleWhenClause( caseExpression.getWhenClauseItemList( ),
					simple_case.getSimple_when_clause( ) );
			if ( caseExpression.getElse_expr( ) != null )
			{
				else_clause elseClause = new else_clause( );
				simple_case.setElse_clause( elseClause );
				convertExpressionToElseClause( caseExpression.getElse_expr( ),
						elseClause );
			}
		}
		else
		{
			searched_case searched_case = new searched_case( );
			caseSpecification.setSearched_case( searched_case );
			convertExpressionToSearchedWhenClause( caseExpression.getWhenClauseItemList( ),
					searched_case.getSearched_when_clause( ) );
			if ( caseExpression.getElse_expr( ) != null )
			{
				else_clause elseClause = new else_clause( );
				searched_case.setElse_clause( elseClause );
				convertExpressionToElseClause( caseExpression.getElse_expr( ),
						elseClause );
			}
		}
	}

	private void convertExpressionToSearchedWhenClause(
			TWhenClauseItemList whenClauseItemList,
			List<searched_when_clause> searched_when_clauses )
	{
		for ( int i = 0; i < whenClauseItemList.size( ); i++ )
		{
			TWhenClauseItem item = whenClauseItemList.getWhenClauseItem( i );
			searched_when_clause searched_when_clause = new searched_when_clause( );
			searched_when_clauses.add( searched_when_clause );
			convertBooleanExpressionToModel( item.getComparison_expr( ),
					searched_when_clause.getSearch_condition( )
							.getBoolean_value_expression( ) );
			convertExpressionToResult( item.getReturn_expr( ),
					searched_when_clause.getResult( ) );
		}
	}

	private void convertExpressionToElseClause( TExpression else_expr,
			else_clause elseClause )
	{
		result result = elseClause.getResult( );
		convertExpressionToResult( else_expr, result );
	}

	private void convertExpressionToResult( TExpression else_expr, result result )
	{
		if ( else_expr.toString( ).trim( ).equalsIgnoreCase( "NULL" ) )
		{
			result.setKw_null( "null" );
		}
		else
		{
			result_expression result_expression = new result_expression( );
			result.setResult_expression( result_expression );
			convertExpressionToValueExpression( else_expr,
					result_expression.getValue_expression( ) );
		}
	}

	private void convertExpressionToSimpleWhenClause(
			TWhenClauseItemList whenClauseItemList,
			List<simple_when_clause> simple_when_clauses )
	{
		for ( int i = 0; i < whenClauseItemList.size( ); i++ )
		{
			TWhenClauseItem item = whenClauseItemList.getWhenClauseItem( i );
			simple_when_clause simple_when_clause = new simple_when_clause( );
			simple_when_clauses.add( simple_when_clause );
			List<when_operand> when_operands = simple_when_clause.getWhen_operand_list( )
					.getWhen_operand( );
			when_operand when_operand = new when_operand( );
			when_operands.add( when_operand );
			convertExpressionToWhenOperand( item.getComparison_expr( ),
					when_operand );
			convertExpressionToResult( item.getReturn_expr( ),
					simple_when_clause.getResult( ) );
		}
	}

	private void convertExpressionToWhenOperand( TExpression condition,
			when_operand when_operand )
	{
		switch ( condition.getExpressionType( ) )
		{
			case simple_constant_t :
			{
				row_value_predicand row_value_predicand = new row_value_predicand( );
				when_operand.setRow_value_predicand( row_value_predicand );
				convertExpressionToRowValuePredicand( condition,
						row_value_predicand );
			}
				break;
			case simple_comparison_t :
			{
				row_value_predicand row_value_predicand = new row_value_predicand( );
				when_operand.setRow_value_predicand( row_value_predicand );
				convertExpressionToRowValuePredicand( condition.getLeftOperand( ),
						row_value_predicand );
				comparison_predicate_part_2 comparison_predicate_part_2 = new comparison_predicate_part_2( );
				when_operand.setComparison_predicate_part_2( comparison_predicate_part_2 );
				convertExpressionOperationToCompOp( condition.getComparisonOperator( ),
						comparison_predicate_part_2.getComp_op( ) );
				convertExpressionToRowValuePredicand( condition.getRightOperand( ),
						comparison_predicate_part_2.getRow_value_predicand( ) );
			}
				break;
			case in_t :
			{
				row_value_predicand row_value_predicand = new row_value_predicand( );
				when_operand.setRow_value_predicand( row_value_predicand );
				convertExpressionToRowValuePredicand( condition.getLeftOperand( ),
						row_value_predicand );
				in_predicate_part_2 in_predicate_part_2 = new in_predicate_part_2( );
				when_operand.setIn_predicate_part_2( in_predicate_part_2 );
				convertExpressionToInPredicatePart2( condition,
						in_predicate_part_2 );
			}
				break;
			case between_t :
			{
				row_value_predicand row_value_predicand = new row_value_predicand( );
				when_operand.setRow_value_predicand( row_value_predicand );
				convertExpressionToRowValuePredicand( condition.getBetweenOperand( ),
						row_value_predicand );
				between_predicate_part_2 between_predicate_part_2 = new between_predicate_part_2( );
				when_operand.setBetween_predicate_part_2( between_predicate_part_2 );
				convertExpressionToBetweenPredicatePart2( condition,
						between_predicate_part_2 );;
			}
				break;
			case null_t :
			{
				row_value_predicand row_value_predicand = new row_value_predicand( );
				when_operand.setRow_value_predicand( row_value_predicand );
				convertExpressionToRowValuePredicand( condition.getLeftOperand( ),
						row_value_predicand );
				null_predicate_part_2 null_predicate_part_2 = new null_predicate_part_2( );
				when_operand.setNull_predicate_part_2( null_predicate_part_2 );
				convertExpressionToNullPredicatePart2( condition,
						null_predicate_part_2 );
			}
				break;
		}

	}

	private void convertExpressionToCaseOperand( TExpression input_expr,
			case_operand case_operand )
	{
		row_value_predicand row_value_predicand = new row_value_predicand( );
		case_operand.setRow_value_predicand( row_value_predicand );
		convertExpressionToRowValuePredicand( input_expr, row_value_predicand );
	}

	private void convertExpressionToCaseAbbreviationExpression(
			TExpression expression, case_abbreviation caseAbbreviation )
	{
		String functionName = expression.getFunctionCall( )
				.getFunctionName( )
				.toString( );
		if ( "NULLIF".equalsIgnoreCase( functionName ) )
		{
			nullif nullif = new nullif( );
			caseAbbreviation.setNullif( nullif );
			TExpressionList expressions = expression.getFunctionCall( )
					.getArgs( );
			for ( int i = 0; i < expressions.size( ); i++ )
			{
				value_expression valueExpression = new value_expression( );
				nullif.getValue_expression( ).add( valueExpression );
				convertExpressionToValueExpression( expressions.getExpression( i ),
						valueExpression );
			}

		}
		else if ( "COALESCE".equalsIgnoreCase( functionName ) )
		{
			coalesce coalesce = new coalesce( );
			caseAbbreviation.setCoalesce( coalesce );
			TExpressionList expressions = expression.getFunctionCall( )
					.getArgs( );
			for ( int i = 0; i < expressions.size( ); i++ )
			{
				value_expression valueExpression = new value_expression( );
				coalesce.getValue_expression( ).add( valueExpression );
				convertExpressionToValueExpression( expressions.getExpression( i ),
						valueExpression );
			}
		}
	}

	private boolean isWindowFunctionExpression( TExpression expression )
	{
		if ( expression.getExpressionType( ) == EExpressionType.function_t )
		{
			String functionName = expression.getFunctionCall( )
					.getFunctionName( )
					.toString( );
			if ( Utility.isWindowFunction( functionName ) )
			{
				return true;
			}
		}
		return false;
	}

	private boolean isCastExpression( TExpression expression )
	{
		if ( expression.getExpressionType( ) == EExpressionType.function_t )
		{
			String functionName = expression.getFunctionCall( )
					.getFunctionName( )
					.toString( )
					.trim( );
			if ( "CAST".equalsIgnoreCase( functionName ) )
			{
				return true;
			}
		}
		return false;
	}

	private boolean isCaseAbbreviationExpression( TExpression expression )
	{
		if ( expression.getExpressionType( ) == EExpressionType.function_t )
		{
			String functionName = expression.getFunctionCall( )
					.getFunctionName( )
					.toString( );
			if ( Utility.isCaseAbbreviationFunction( functionName ) )
			{
				return true;
			}
		}
		return false;
	}

	private void convertExpressionToWindowFunction( TExpression expression,
			window_function windowFunction )
	{
		String functionName = expression.getFunctionCall( )
				.getFunctionName( )
				.toString( );

		if ( functionName.equalsIgnoreCase( "row_number" ) )
		{
			windowFunction.getWindow_function_type( )
					.setKw_row_number( "row_number" );
		}
		else if ( functionName.equalsIgnoreCase( "rank" ) )
		{
			windowFunction.getWindow_function_type( )
					.setRank_function_type( "rank" );
		}
		else if ( functionName.equalsIgnoreCase( "percent_rank" ) )
		{
			windowFunction.getWindow_function_type( )
					.setRank_function_type( "percent_rank" );
		}
		else if ( functionName.equalsIgnoreCase( "cume_dist" ) )
		{
			windowFunction.getWindow_function_type( )
					.setRank_function_type( "cume_dist" );
		}
		else if ( functionName.equalsIgnoreCase( "dense_rank" ) )
		{
			windowFunction.getWindow_function_type( )
					.setRank_function_type( "dense_rank" );
		}

		TAnalyticFunction analyticFunction = expression.getFunctionCall( )
				.getAnalyticFunction( );
		in_line_window_specification inLineWindowSpecification = new in_line_window_specification( );
		windowFunction.getWindow_name_or_specification( )
				.setIn_line_window_specification( inLineWindowSpecification );
		convertAnalyticFunctionToInLineWindowSpecification( analyticFunction,
				inLineWindowSpecification.getWindow_specification( )
						.getWindow_specification_details( ) );
	}

	private void convertAnalyticFunctionToInLineWindowSpecification(
			TAnalyticFunction analyticFunction,
			window_specification_details windowSpecificationDetails )
	{
		if ( analyticFunction.getPartitionBy_ExprList( ) != null )
		{
			window_partition_clause windowPartitionClause = new window_partition_clause( );
			windowSpecificationDetails.setWindow_partition_clause( windowPartitionClause );
			convertPartitionByToModel( analyticFunction.getPartitionBy_ExprList( ),
					windowPartitionClause.getWindow_partition_column_reference_list( )
							.getWindow_partition_column_reference( ) );
		}
		if ( analyticFunction.getOrderBy( ) != null )
		{
			window_order_clause windowOrderClause = new window_order_clause( );
			windowSpecificationDetails.setWindow_order_clause( windowOrderClause );
			convertOrderbyClauseToSortSpecificationList( analyticFunction.getOrderBy( ),
					windowOrderClause.getSort_specification_list( ) );

		}
		if ( analyticFunction.getKeepDenseRankClause( ) != null )
		{

		}
	}

	private void convertPartitionByToModel(
			TExpressionList partitionBy_ExprList,
			List<window_partition_column_reference> window_partition_column_references )
	{
		for ( int i = 0; i < partitionBy_ExprList.size( ); i++ )
		{
			window_partition_column_reference window_partition_column_reference = new window_partition_column_reference( );
			window_partition_column_references.add( window_partition_column_reference );
			convertExpressionToPartitionColumnReference( partitionBy_ExprList.getExpression( i ),
					window_partition_column_reference );
		}
	}

	private void convertExpressionToPartitionColumnReference(
			TExpression expression,
			window_partition_column_reference partitionColumnReference )
	{
		convertExpressionToColumnReference( expression,
				partitionColumnReference.getColumn_reference( ) );
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
		if ( Utility.isIntervalTypeValue( expression.toString( ) ) )
		{
			interval_literal intervalLiteral = new interval_literal( );
			generalLiteral.setInterval_literal( intervalLiteral );
			convertExpressionToIntervalLiteral( expression, intervalLiteral );
		}
		else if ( Utility.isDateTypeValue( expression.toString( ) ) )
		{
			datetime_literal datetimeLiteral = new datetime_literal( );
			generalLiteral.setDatetime_literal( datetimeLiteral );
			convertExpressionToDatetimeLiteral( expression, datetimeLiteral );
		}
		else if ( Utility.isString( expression.toString( ) ) )
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

	private void convertExpressionToIntervalLiteral( TExpression expression,
			interval_literal intervalLiteral )
	{
		String expressionContent = expression.toString( ).trim( ).toUpperCase( );
		if ( expressionContent.startsWith( "INTERVAL" ) )
		{
			String intervalString = expressionContent.substring( expressionContent.indexOf( "'" ) + 1,
					expressionContent.lastIndexOf( "'" ) )
					.trim( );

			String qualifier = expressionContent.substring( expressionContent.lastIndexOf( "'" ) + 1 )
					.trim( );
			if ( qualifier.toUpperCase( ).indexOf( "TO" ) == -1 )
			{
				single_datetime_field single_datetime_field = new single_datetime_field( );
				intervalLiteral.getInterval_qualifier( )
						.setSingle_datetime_field( single_datetime_field );
				if ( qualifier.toUpperCase( ).indexOf( "SECOND" ) != -1 )
				{
					single_datetime_field_2 single_datetime_field_2 = new single_datetime_field_2( );
					single_datetime_field.setSingle_datetime_field_2( single_datetime_field_2 );

					if ( qualifier.indexOf( "(" ) != -1
							&& qualifier.indexOf( ")" ) != -1 )
					{
						interval_leading_field_precision_comma interval_leading_field_precision_comma = new interval_leading_field_precision_comma( );
						single_datetime_field_2.setInterval_leading_field_precision_comma( interval_leading_field_precision_comma );
						String precision = qualifier.substring( qualifier.indexOf( "(" ) + 1,
								qualifier.lastIndexOf( ")" ) );
						String[] splits = precision.split( "\\," );
						if ( splits.length > 0 )
						{
							interval_leading_field_precision_comma.getInterval_leading_field_precision( )
									.setUnsigned_integer( splits[0] );
							if ( splits.length > 1 )
							{
								interval_fractional_seconds_precision interval_fractional_seconds_precision = new interval_fractional_seconds_precision( );
								interval_leading_field_precision_comma.setInterval_fractional_seconds_precision( interval_fractional_seconds_precision );
								interval_fractional_seconds_precision.setUnsigned_integer( splits[1] );
							}
						}
					}
				}
				else
				{
					single_datetime_field_1 single_datetime_field_1 = new single_datetime_field_1( );
					single_datetime_field.setSingle_datetime_field_1( single_datetime_field_1 );

					if ( qualifier.indexOf( "(" ) != -1
							&& qualifier.indexOf( ")" ) != -1 )
					{
						interval_leading_field_precision interval_leading_field_precision = new interval_leading_field_precision( );
						single_datetime_field_1.setInterval_leading_field_precision( interval_leading_field_precision );
						String precision = qualifier.substring( qualifier.indexOf( "(" ) + 1,
								qualifier.lastIndexOf( ")" ) );
						interval_leading_field_precision.setUnsigned_integer( precision );

						String datetimeField = qualifier.substring( 0,
								qualifier.indexOf( "(" ) )
								.toUpperCase( )
								.trim( );
						convertDateTimeFieldToSingleDatetimeField1( datetimeField,
								single_datetime_field_1 );
					}
					else
					{
						String datetimeField = qualifier.toUpperCase( ).trim( );
						convertDateTimeFieldToSingleDatetimeField1( datetimeField,
								single_datetime_field_1 );
					}
				}
			}
			else
			{
				start_to_end_field start_to_end_field = new start_to_end_field( );
				intervalLiteral.getInterval_qualifier( )
						.setStart_to_end_field( start_to_end_field );

				String[] fields = qualifier.trim( ).toUpperCase( ).split( "TO" );
				convertDateTimeFieldToSingleDatetimeField1( fields[0].trim( ),
						start_to_end_field.getStart_field( ) );

				if ( fields[1].trim( ).indexOf( "SECOND" ) == -1 )
				{
					non_second_primary_datetime_field non_second_primary_datetime_field = new non_second_primary_datetime_field( );
					start_to_end_field.getEnd_field( )
							.setNon_second_primary_datetime_field( non_second_primary_datetime_field );
					convertDateTimeFieldToNonSecondPrimaryDatetimeField( fields[1].trim( ),
							start_to_end_field.getEnd_field( )
									.getNon_second_primary_datetime_field( ) );
				}
				else
				{
					second_interval_fractional_seconds_precision second_interval_fractional_seconds_precision = new second_interval_fractional_seconds_precision( );
					start_to_end_field.getEnd_field( )
							.setSecond_interval_fractional_seconds_precision( second_interval_fractional_seconds_precision );
					if ( qualifier.indexOf( "(" ) != -1
							&& qualifier.indexOf( ")" ) != -1 )
					{
						interval_fractional_seconds_precision interval_fractional_seconds_precision = new interval_fractional_seconds_precision( );
						second_interval_fractional_seconds_precision.setInterval_fractional_seconds_precision( interval_fractional_seconds_precision );
						String precision = qualifier.substring( qualifier.indexOf( "(" ) + 1,
								qualifier.lastIndexOf( ")" ) );
						interval_fractional_seconds_precision.setUnsigned_integer( precision );
					}
				}
			}

			year_month_or_day_time_literal yearMonthOrDayTimeLiteral = intervalLiteral.getInterval_string( )
					.getUnquoted_interval_string( )
					.getYear_month_or_day_time_literal( );

			if ( qualifier.toUpperCase( ).indexOf( "YEAR" ) != -1
					|| qualifier.toUpperCase( ).indexOf( "MONTH" ) != -1 )
			{
				year_month_literal yearMonthLiteral = new year_month_literal( );
				yearMonthOrDayTimeLiteral.setYear_month_literal( yearMonthLiteral );

				if ( intervalString.indexOf( '-' ) != -1 )
				{
					years_value_or_minus_months_value years_value_or_minus_months_value = new years_value_or_minus_months_value( );
					yearMonthLiteral.setYears_value_or_minus_months_value( years_value_or_minus_months_value );
					String[] splits = intervalString.split( "\\-" );
					years_value_or_minus_months_value.getYears_value( )
							.getDatetime_value( )
							.setUnsigned_integer( splits[0] );

					minus_months_value minus_months_value = new minus_months_value( );
					years_value_or_minus_months_value.setMinus_months_value( minus_months_value );
					minus_months_value.getMonths_value( )
							.getDatetime_value( )
							.setUnsigned_integer( splits[1] );
				}
				else
				{
					if ( qualifier.toUpperCase( ).indexOf( "YEAR" ) != -1 )
					{
						years_value_or_minus_months_value years_value_or_minus_months_value = new years_value_or_minus_months_value( );
						yearMonthLiteral.setYears_value_or_minus_months_value( years_value_or_minus_months_value );
						years_value_or_minus_months_value.getYears_value( )
								.getDatetime_value( )
								.setUnsigned_integer( intervalString );
					}
					else if ( qualifier.toUpperCase( ).indexOf( "MONTH" ) != -1 )
					{
						months_value months_value = new months_value( );
						yearMonthLiteral.setMonths_value( months_value );
						months_value.getDatetime_value( )
								.setUnsigned_integer( intervalString );
					}

				}
			}
			else
			{
				day_time_literal dayTimeLiteral = new day_time_literal( );
				yearMonthOrDayTimeLiteral.setDay_time_literal( dayTimeLiteral );

				if ( qualifier.toUpperCase( ).indexOf( "DAY" ) != -1 )
				{
					day_time_interval day_time_interval = new day_time_interval( );
					dayTimeLiteral.setDay_time_interval( day_time_interval );
					String[] splits = intervalString.split( "\\s+" );
					day_time_interval.getDays_value( )
							.getDatetime_value( )
							.setUnsigned_integer( splits[0] );
					if ( splits.length > 1 )
					{
						hours_minutes_seconds_value hours_minutes_seconds_value = new hours_minutes_seconds_value( );
						day_time_interval.setHours_minutes_seconds_value( hours_minutes_seconds_value );
						String[] times = splits[1].split( "\\:" );
						if ( times.length > 0 )
						{
							hours_minutes_seconds_value.getHours_value( )
									.getDatetime_value( )
									.setUnsigned_integer( times[0] );

							if ( times.length > 1 )
							{
								minutes_seconds_value minutes_seconds_value = new minutes_seconds_value( );
								hours_minutes_seconds_value.setMinutes_seconds_value( minutes_seconds_value );
								minutes_seconds_value.getMinutes_value( )
										.getDatetime_value( )
										.setUnsigned_integer( times[1] );
								if ( times.length > 2 )
								{
									seconds_value seconds_value = new seconds_value( );
									minutes_seconds_value.setSeconds_value( seconds_value );
									seconds_value.getDatetime_value( )
											.setUnsigned_integer( times[2] );
								}
							}
						}
					}
				}
				else
				{
					time_interval time_interval = new time_interval( );
					dayTimeLiteral.setTime_interval( time_interval );

					if ( qualifier.toUpperCase( ).indexOf( "HOUR" ) != -1 )
					{
						hours_minutes_seconds_value hours_minutes_seconds_value = new hours_minutes_seconds_value( );
						time_interval.setHours_minutes_seconds_value( hours_minutes_seconds_value );
						String[] times = intervalString.split( "\\:" );
						if ( times.length > 0 )
						{
							hours_minutes_seconds_value.getHours_value( )
									.getDatetime_value( )
									.setUnsigned_integer( times[0] );

							if ( times.length > 1 )
							{
								minutes_seconds_value minutes_seconds_value = new minutes_seconds_value( );
								hours_minutes_seconds_value.setMinutes_seconds_value( minutes_seconds_value );
								minutes_seconds_value.getMinutes_value( )
										.getDatetime_value( )
										.setUnsigned_integer( times[1] );
								if ( times.length > 2 )
								{
									seconds_value seconds_value = new seconds_value( );
									minutes_seconds_value.setSeconds_value( seconds_value );
									seconds_value.getDatetime_value( )
											.setUnsigned_integer( times[2] );
								}
							}
						}
					}
					else if ( qualifier.toUpperCase( ).indexOf( "MINUTE" ) != -1 )
					{
						minutes_seconds_value minutes_seconds_value = new minutes_seconds_value( );
						time_interval.setMinutes_seconds_value( minutes_seconds_value );
						String[] times = intervalString.split( "\\:" );
						if ( times.length > 0 )
						{
							minutes_seconds_value.getMinutes_value( )
									.getDatetime_value( )
									.setUnsigned_integer( times[0] );
							if ( times.length > 1 )
							{
								seconds_value seconds_value = new seconds_value( );
								minutes_seconds_value.setSeconds_value( seconds_value );
								seconds_value.getDatetime_value( )
										.setUnsigned_integer( times[2] );
							}
						}
					}
					else if ( qualifier.toUpperCase( ).indexOf( "SECOND" ) != -1 )
					{
						seconds_value seconds_value = new seconds_value( );
						time_interval.setSeconds_value( seconds_value );
						seconds_value.getDatetime_value( )
								.setUnsigned_integer( intervalString );

					}
				}
			}
		}
	}

	private void convertDateTimeFieldToSingleDatetimeField1(
			String datetimeField,
			single_datetime_field_1 single_datetime_field_1 )
	{
		non_second_primary_datetime_field non_second_primary_datetime_field = single_datetime_field_1.getNon_second_primary_datetime_field( );
		convertDateTimeFieldToNonSecondPrimaryDatetimeField( datetimeField,
				non_second_primary_datetime_field );
	}

	private void convertDateTimeFieldToNonSecondPrimaryDatetimeField(
			String datetimeField,
			non_second_primary_datetime_field non_second_primary_datetime_field )
	{
		if ( datetimeField.equals( "YEAR" ) )
		{
			non_second_primary_datetime_field.setKw_year( "year" );
		}
		else if ( datetimeField.equals( "MONTH" ) )
		{
			non_second_primary_datetime_field.setKw_month( "month" );
		}
		else if ( datetimeField.equals( "DAY" ) )
		{
			non_second_primary_datetime_field.setKw_day( "day" );
		}
		else if ( datetimeField.equals( "HOUR" ) )
		{
			non_second_primary_datetime_field.setKw_hour( "hour" );
		}
		else if ( datetimeField.equals( "MINUTE" ) )
		{
			non_second_primary_datetime_field.setKw_minute( "minute" );
		}
	}

	private void convertExpressionToDatetimeLiteral( TExpression expression,
			datetime_literal datetimeLiteral )
	{
		String expressionContent = expression.toString( ).trim( ).toUpperCase( );
		if ( expressionContent.startsWith( "TIMESTAMP" ) )
		{
			timestamp_literal timestampLiteral = new timestamp_literal( );
			datetimeLiteral.setTimestamp_literal( timestampLiteral );
			String timestamp = expressionContent.substring( expressionContent.indexOf( "'" ) + 1,
					expressionContent.length( ) - 1 );
			convertStringToTimestampString( timestamp,
					timestampLiteral.getTimestamp_string( )
							.getUnquoted_timestamp_string( ) );
		}
		else if ( expressionContent.startsWith( "TIME" ) )
		{
			time_literal timeLiteral = new time_literal( );
			datetimeLiteral.setTime_literal( timeLiteral );
			String time = expressionContent.substring( expressionContent.indexOf( "'" ) + 1,
					expressionContent.length( ) - 1 );
			convertStringToTimeString( time, timeLiteral.getTime_string( )
					.getUnquoted_time_string( ) );
		}
		else
		{
			date_literal dateLiteral = new date_literal( );
			datetimeLiteral.setDate_literal( dateLiteral );
			String date = expressionContent.substring( expressionContent.indexOf( "'" ) + 1,
					expressionContent.length( ) - 1 );
			convertStringToDateString( date, dateLiteral.getDate_string( )
					.getUnquoted_date_string( ) );
		}

	}

	private void convertStringToTimeString( String time,
			unquoted_time_string unquoted_time_string )
	{
		String[] splits = time.trim( ).split( "\\s+" );
		if ( splits.length > 0 )
		{
			convertStringToTimeValue( splits[0],
					unquoted_time_string.getTime_value( ) );
		}
		if ( splits.length > 1 )
		{
			time_zone_interval timeZoneInterval = new time_zone_interval( );
			unquoted_time_string.setTime_zone_interval( timeZoneInterval );
			convertStringTotimeZoneInterval( splits[1], timeZoneInterval );
		}
	}

	private void convertStringTotimeZoneInterval( String string,
			time_zone_interval timeZoneInterval )
	{
		String[] splits = string.split( "\\:" );
		if ( splits.length > 0 )
		{
			String hour = splits[0];
			if ( hour.startsWith( "-" ) )
			{
				timeZoneInterval.getSign( ).setMinus_sign( "-" );
				timeZoneInterval.getHours_value( )
						.getDatetime_value( )
						.setUnsigned_integer( splits[0].substring( 1 ) );
			}
			else if ( hour.startsWith( "+" ) )
			{
				timeZoneInterval.getSign( ).setPlus_sign( "+" );
				timeZoneInterval.getHours_value( )
						.getDatetime_value( )
						.setUnsigned_integer( splits[0].substring( 1 ) );
			}
			else
			{
				timeZoneInterval.getSign( ).setPlus_sign( "+" );
				timeZoneInterval.getHours_value( )
						.getDatetime_value( )
						.setUnsigned_integer( splits[0] );
			}
		}
		if ( splits.length > 1 )
		{
			timeZoneInterval.getMinutes_value( )
					.getDatetime_value( )
					.setUnsigned_integer( splits[1] );
		}

	}

	private void convertStringToTimeValue( String string, time_value time_value )
	{
		String[] splits = string.split( "\\:" );
		if ( splits.length > 0 )
		{
			time_value.getHours_value( )
					.getDatetime_value( )
					.setUnsigned_integer( splits[0] );
		}
		if ( splits.length > 1 )
		{
			time_value.getMinutes_value( )
					.getDatetime_value( )
					.setUnsigned_integer( splits[1] );
		}
		if ( splits.length > 2 )
		{
			time_value.getSeconds_value( )
					.getDatetime_value( )
					.setUnsigned_integer( splits[2] );
		}

	}

	private void convertStringToTimestampString( String timestamp,
			unquoted_timestamp_string unquoted_timestamp_string )
	{
		String[] splits = timestamp.trim( ).split( "\\s+" );
		if ( splits.length > 0 )
		{
			convertStringToDateString( splits[0],
					unquoted_timestamp_string.getUnquoted_date_string( ) );
		}
		if ( splits.length > 1 )
		{
			String time = splits[1];
			if ( splits.length > 2 )
			{
				time += " ";
				time += splits[2];
			}
			convertStringToTimeString( time,
					unquoted_timestamp_string.getUnquoted_time_string( ) );
		}
	}

	private void convertStringToDateString( String date,
			unquoted_date_string unquoted_date_string )
	{
		String[] splits = date.split( "\\-" );
		if ( splits.length > 0 )
		{
			unquoted_date_string.getDate_value( )
					.getYears_value( )
					.getDatetime_value( )
					.setUnsigned_integer( splits[0] );
		}
		if ( splits.length > 1 )
		{
			unquoted_date_string.getDate_value( )
					.getMonths_value( )
					.getDatetime_value( )
					.setUnsigned_integer( splits[1] );
		}
		if ( splits.length > 2 )
		{
			unquoted_date_string.getDate_value( )
					.getDays_value( )
					.getDatetime_value( )
					.setUnsigned_integer( splits[2] );
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
			if ( expression.getLeftOperand( ) != null )
			{
				boolean isDateType = isDateTypeValueExpression( expression.getLeftOperand( ) );
				if ( isDateType )
					return false;
			}
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
