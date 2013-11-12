/*******************************************************************************
 * Copyright (c) 2007 cnfree.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  cnfree  - initial API and implementation
 *******************************************************************************/

package gudusoft.gsqlparser.sql2xml.model.gen.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtil
{

	public static void replaceStream( InputStream inputStream, String regex1,
			String regex2, String replacement, File saveFile )
	{
		Map<String, String> map = new HashMap<String, String>( );
		map.put( regex2, replacement );
		replaceStream( inputStream, regex1, map, saveFile );
	}

	public static void replaceStream( InputStream inputStream, String regex,
			Map<String, String> map, File saveFile )
	{
		try
		{
			BufferedReader reader = new BufferedReader( new InputStreamReader( inputStream ) );
			StringBuilder builder = new StringBuilder( );

			String line = null;
			try
			{
				while ( ( line = reader.readLine( ) ) != null )
				{
					builder.append( line );
					builder.append( "\n" );
				}
			}
			catch ( IOException e )
			{
				e.printStackTrace( );
			}
			finally
			{
				try
				{
					inputStream.close( );
				}
				catch ( IOException e )
				{
					e.printStackTrace( );
				}
			}
			String temp = builder.toString( );
			Pattern pattern = Pattern.compile( regex );
			Matcher matcher = pattern.matcher( temp );
			StringBuffer sbr = new StringBuffer( );
			while ( matcher.find( ) )
			{
				Iterator<String> iter = map.keySet( ).iterator( );
				String group = matcher.group( );
				while ( iter.hasNext( ) )
				{
					String key = (String) iter.next( );
					Pattern pattern1 = Pattern.compile( key );
					Matcher matcher1 = pattern1.matcher( group );
					group = matcher1.replaceAll( Matcher.quoteReplacement( (String) map.get( key ) ) );
				}
				matcher.appendReplacement( sbr,
						Matcher.quoteReplacement( group ) );
			}
			matcher.appendTail( sbr );
			PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter( new FileOutputStream( saveFile ) ) ),
					false );
			out.print( sbr );
			out.close( );
		}
		catch ( Exception e )
		{
			e.printStackTrace( );
		}
	}
}
