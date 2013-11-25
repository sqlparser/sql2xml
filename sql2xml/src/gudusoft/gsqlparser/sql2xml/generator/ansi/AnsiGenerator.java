
package gudusoft.gsqlparser.sql2xml.generator.ansi;

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
import gudusoft.gsqlparser.nodes.TJoin;
import gudusoft.gsqlparser.nodes.TJoinItem;
import gudusoft.gsqlparser.nodes.TJoinItemList;
import gudusoft.gsqlparser.nodes.TObjectName;
import gudusoft.gsqlparser.nodes.TOrderBy;
import gudusoft.gsqlparser.nodes.TOrderByItem;
import gudusoft.gsqlparser.nodes.TOrderByItemList;
import gudusoft.gsqlparser.nodes.TResultColumn;
import gudusoft.gsqlparser.nodes.TTable;
import gudusoft.gsqlparser.sql2xml.generator.SQL2XMLGenerator;
import gudusoft.gsqlparser.sql2xml.model.actual_identifier;
import gudusoft.gsqlparser.sql2xml.model.as_clause;
import gudusoft.gsqlparser.sql2xml.model.catalog_name;
import gudusoft.gsqlparser.sql2xml.model.collection_derived_table_as_correction_name;
import gudusoft.gsqlparser.sql2xml.model.column_name;
import gudusoft.gsqlparser.sql2xml.model.column_name_list;
import gudusoft.gsqlparser.sql2xml.model.common_value_expression;
import gudusoft.gsqlparser.sql2xml.model.correlation_name_with_derived_column_list;
import gudusoft.gsqlparser.sql2xml.model.cursor_specification;
import gudusoft.gsqlparser.sql2xml.model.delete_statement_searched;
import gudusoft.gsqlparser.sql2xml.model.delimited_identifier;
import gudusoft.gsqlparser.sql2xml.model.derived_column;
import gudusoft.gsqlparser.sql2xml.model.derived_table_as_correlation_name;
import gudusoft.gsqlparser.sql2xml.model.direct_select_statement_multiple_rows;
import gudusoft.gsqlparser.sql2xml.model.direct_sql_data_statement;
import gudusoft.gsqlparser.sql2xml.model.directly_executable_statement;
import gudusoft.gsqlparser.sql2xml.model.factor;
import gudusoft.gsqlparser.sql2xml.model.from_clause;
import gudusoft.gsqlparser.sql2xml.model.identifier;
import gudusoft.gsqlparser.sql2xml.model.insert_statement;
import gudusoft.gsqlparser.sql2xml.model.lateral_derived_table_as_correlation_name;
import gudusoft.gsqlparser.sql2xml.model.local_or_schema_qualified_name;
import gudusoft.gsqlparser.sql2xml.model.local_or_schema_qualifier;
import gudusoft.gsqlparser.sql2xml.model.merge_statement;
import gudusoft.gsqlparser.sql2xml.model.minus;
import gudusoft.gsqlparser.sql2xml.model.numeric_primary;
import gudusoft.gsqlparser.sql2xml.model.numeric_value_expression;
import gudusoft.gsqlparser.sql2xml.model.numeric_value_function;
import gudusoft.gsqlparser.sql2xml.model.of_column_name_list;
import gudusoft.gsqlparser.sql2xml.model.only_spec_as_correction_name;
import gudusoft.gsqlparser.sql2xml.model.order_by_clause;
import gudusoft.gsqlparser.sql2xml.model.ordering_specification;
import gudusoft.gsqlparser.sql2xml.model.plus;
import gudusoft.gsqlparser.sql2xml.model.qualified_asterisk;
import gudusoft.gsqlparser.sql2xml.model.query_expression;
import gudusoft.gsqlparser.sql2xml.model.query_expression_body;
import gudusoft.gsqlparser.sql2xml.model.query_expression_body_except;
import gudusoft.gsqlparser.sql2xml.model.query_expression_body_intersect;
import gudusoft.gsqlparser.sql2xml.model.query_expression_body_union;
import gudusoft.gsqlparser.sql2xml.model.query_primary;
import gudusoft.gsqlparser.sql2xml.model.query_specification;
import gudusoft.gsqlparser.sql2xml.model.query_term;
import gudusoft.gsqlparser.sql2xml.model.read_only_or_update_of;
import gudusoft.gsqlparser.sql2xml.model.schema_name;
import gudusoft.gsqlparser.sql2xml.model.select_list;
import gudusoft.gsqlparser.sql2xml.model.select_sublist;
import gudusoft.gsqlparser.sql2xml.model.set_quantifier;
import gudusoft.gsqlparser.sql2xml.model.sign;
import gudusoft.gsqlparser.sql2xml.model.simple_table;
import gudusoft.gsqlparser.sql2xml.model.sort_key;
import gudusoft.gsqlparser.sql2xml.model.sort_specification;
import gudusoft.gsqlparser.sql2xml.model.sort_specification_list;
import gudusoft.gsqlparser.sql2xml.model.table_expression;
import gudusoft.gsqlparser.sql2xml.model.table_factor;
import gudusoft.gsqlparser.sql2xml.model.table_function_derived_table_as_correction_name;
import gudusoft.gsqlparser.sql2xml.model.table_name;
import gudusoft.gsqlparser.sql2xml.model.table_or_query_name;
import gudusoft.gsqlparser.sql2xml.model.table_or_query_name_as_correlation_name;
import gudusoft.gsqlparser.sql2xml.model.table_primary;
import gudusoft.gsqlparser.sql2xml.model.table_reference;
import gudusoft.gsqlparser.sql2xml.model.term;
import gudusoft.gsqlparser.sql2xml.model.term_asterisk_factor;
import gudusoft.gsqlparser.sql2xml.model.term_solidus_factor;
import gudusoft.gsqlparser.sql2xml.model.unicode_delimited_identifier;
import gudusoft.gsqlparser.sql2xml.model.updatability_clause;
import gudusoft.gsqlparser.sql2xml.model.update_of_clause;
import gudusoft.gsqlparser.sql2xml.model.update_statement_searched;
import gudusoft.gsqlparser.sql2xml.model.value_expression;
import gudusoft.gsqlparser.sql2xml.model.value_expression_primary;
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
		from_clause from_clause = tableExpression.getFrom_clause( );
		List<table_reference> tableReferences = from_clause.getTable_reference( );
		for ( int i = 0; i < select.joins.size( ); i++ )
		{
			table_reference tableReference = new table_reference( );
			tableReferences.add( tableReference );
			TJoin join = select.joins.getJoin( i );
			TTable table = join.getTable( );
			TJoinItemList items = join.getJoinItems( );
			if ( items != null )
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
				TExpression expression = column.getExpr( );
				switch ( expression.getExpressionType( ) )
				{
					case simple_object_name_t :
						qualified_asterisk qualifiedAsterisk = new qualified_asterisk( );
						sublist.setQualified_asterisk( qualifiedAsterisk );
						convertColumnToQualifiedAsterisk( column,
								qualifiedAsterisk );
						break;
					default :
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
		convertExpression2Model( column.getExpr( ),
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

			convertExpression2Model( item.getSortKey( ), valueExpression );
		}

	}

	private void convertExpression2Model( TExpression expression,
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
			convertExpressionToNumericPrimary( expression.getLeftOperand( ),
					factor.getNumeric_primary( ) );
		}
		else if ( expression.getExpressionType( ) == EExpressionType.unary_minus_t )
		{
			sign sign = new sign( );
			sign.setPlus_sign( "-" );
			factor.setSign( sign );
			convertExpressionToNumericPrimary( expression.getLeftOperand( ),
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
			numeric_value_function numericValueFunction = new numeric_value_function( );
			numericPrimary.setNumeric_value_function( numericValueFunction );
			convertExpressionToNumericValueFunction( expression,
					numericValueFunction );
		}
		else
		{
			value_expression_primary valueExpressionPrimary = new value_expression_primary( );
			numericPrimary.setValue_expression_primary( valueExpressionPrimary );
			convertExpressionToNumericValueExpressionPrimary( expression,
					valueExpressionPrimary );
		}
	}

	private void convertExpressionToNumericValueExpressionPrimary(
			TExpression expression,
			value_expression_primary valueExpressionPrimary )
	{
		// TODO Auto-generated method stub

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
			if ( Utility.isNumericValueFunction( functionName ) )
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

	@Override
	public String getErrorMessage( )
	{
		return errorMessage;
	}

}
