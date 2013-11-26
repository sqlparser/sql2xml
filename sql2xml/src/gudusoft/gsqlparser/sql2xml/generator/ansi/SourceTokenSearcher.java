
package gudusoft.gsqlparser.sql2xml.generator.ansi;

import gudusoft.gsqlparser.ETokenType;
import gudusoft.gsqlparser.TSourceToken;
import gudusoft.gsqlparser.TSourceTokenList;

public class SourceTokenSearcher
{

	/**
	 * search the source token in the source token list from the top
	 * 
	 * @param list
	 * @param startPos
	 * @param endPos
	 * @param text
	 * @return position
	 */
	public static int indexOf( TSourceTokenList list, int startPos, int endPos,
			String text )
	{
		if ( text == null )
		{
			return -1;
		}

		for ( int i = startPos; i < endPos; i++ )
		{
			if ( i >= 0 && i < list.size( ) )
			{
				if ( list.get( i ).astext != null
						&& list.get( i ).astext.trim( ).equalsIgnoreCase( text ) )
				{
					return i;
				}
			}
			else
			{
				return -1;
			}
		}

		return -1;
	}

	/**
	 * search the source token in the source token list from the top
	 * 
	 * @param list
	 * @param startPos
	 * @param endPos
	 * @param type
	 * @return
	 */
	public static int indexOf( TSourceTokenList list, int startPos, int endPos,
			ETokenType type )
	{
		for ( int i = startPos; i < endPos; i++ )
		{
			if ( i >= 0 && i < list.size( ) )
			{
				if ( type == list.get( i ).tokentype )
				{
					return i;
				}
			}
			else
			{
				return -1;
			}
		}

		return -1;
	}

	/**
	 * search the source token in the source token list from the top
	 * 
	 * @param list
	 * @param startPos
	 * @param text
	 * @return
	 */
	public static int indexOf( TSourceTokenList list, int startPos, String text )
	{
		return indexOf( list, startPos, list.size( ) - 1, text );
	}

	/**
	 * backward search the source token
	 * 
	 * @param list
	 * @param startPos
	 * @param backsearchSize
	 * @param text
	 * @return
	 */
	public static TSourceToken backforwardSearch( TSourceToken token,
			int backsearchSize, String text )
	{
		int pos = SourceTokenSearcher.lastIndexOf( token.container,
				token.posinlist - backsearchSize,
				token.posinlist,
				text );
		if ( pos == -1 )
		{
			return null;
		}
		return token.container.get( pos );
	}

	/**
	 * forward search the source token
	 * 
	 * @param token
	 * @param forwardSearchSize
	 * @param text
	 * @return
	 */
	public static TSourceToken forwardSearch( TSourceToken token,
			int forwardSearchSize, String text )
	{
		int pos = SourceTokenSearcher.indexOf( token.container,
				token.posinlist,
				token.posinlist + forwardSearchSize,
				text );
		if ( pos == -1 )
		{
			return null;
		}
		return token.container.get( pos );
	}

	/**
	 * search the source token in the source token list from the end
	 * 
	 * @param list
	 * @param startPos
	 * @param endPos
	 * @param text
	 * @return position
	 */
	public static int lastIndexOf( TSourceTokenList list, int startPos,
			int endPos, String text )
	{
		if ( text == null )
		{
			return -1;
		}
		if ( startPos < 0 )
		{
			startPos = 0;
		}
		if ( endPos - 1 > list.size( ) )
		{
			endPos = list.size( );
		}

		for ( int i = endPos - 1; i >= startPos; i-- )
		{
			if ( i >= 0 && i < list.size( ) )
			{
				if ( list.get( i ).astext != null
						&& list.get( i ).astext.trim( ).equalsIgnoreCase( text ) )
				{
					return i;
				}
			}
			else
			{
				return -1;
			}
		}

		return -1;
	}

	/**
	 * search the source token in the source token list from the end
	 * 
	 * @param list
	 * @param endPos
	 * @param text
	 * @return
	 */
	public static int lastIndexOf( TSourceTokenList list, int endPos,
			String text )
	{
		return lastIndexOf( list, 0, endPos, text );
	}

	/**
	 * get last token which is not whitespace and return token
	 * 
	 * @param list
	 * @param startPos
	 * @param endPos
	 * @return
	 */
	public static TSourceToken lastNotWhitespaceAndReturnToken(
			TSourceTokenList list, int startPos, int endPos )
	{

		for ( int i = endPos - 1; i >= startPos; i-- )
		{
			if ( i >= 0 && i < list.size( ) )
			{
				if ( list.get( i ).tokentype == ETokenType.ttwhitespace
						|| list.get( i ).tokentype == ETokenType.ttreturn
						|| list.get( i ).tokentype == ETokenType.ttsimplecomment
						|| list.get( i ).tokentype == ETokenType.ttbracketedcomment )
				{
					continue;
				}
				else
				{
					return list.get( i );
				}
			}
			else
			{
				return null;
			}
		}

		return null;
	}

	/**
	 * get last token which is not whitespace and return token
	 * 
	 * @param list
	 * @param endPos
	 * @return
	 */
	public static TSourceToken lastNotWhitespaceAndReturnToken(
			TSourceTokenList list, int endPos )
	{
		return lastNotWhitespaceAndReturnToken( list, 0, endPos );
	}

	/**
	 * backward search the token which is the first not whitespace or return
	 * token, and its value is a fixed text
	 * 
	 * @param list
	 * @param endPos
	 * @param value
	 *            the fixed value
	 * @return
	 */
	public static TSourceToken lastSelectedNotWhitespaceAndReturnToken(
			TSourceTokenList list, int endPos, String text )
	{
		TSourceToken token = lastNotWhitespaceAndReturnToken( list, endPos );
		if ( token != null
				&& token.astext != null
				&& token.astext.trim( ).equalsIgnoreCase( text ) )
		{
			return token;
		}
		return null;
	}

	/**
	 * get first token which is not whitespace and return token
	 * 
	 * @param list
	 * @param startPos
	 * @param endPos
	 * @return
	 */
	public static TSourceToken firstNotWhitespaceAndReturnToken(
			TSourceTokenList list, int startPos, int endPos )
	{

		for ( int i = startPos; i <= endPos; i++ )
		{
			if ( i >= 0 && i < list.size( ) )
			{
				if ( list.get( i ).tokentype == ETokenType.ttwhitespace
						|| list.get( i ).tokentype == ETokenType.ttreturn
						|| list.get( i ).tokentype == ETokenType.ttsimplecomment
						|| list.get( i ).tokentype == ETokenType.ttbracketedcomment )
				{
					continue;
				}
				else
				{
					return list.get( i );
				}
			}
			else
			{
				return null;
			}
		}

		return null;
	}

	/**
	 * forward search the token which is the first not whitespace or return
	 * token, and its value is a fixed text
	 * 
	 * @param list
	 * @param startPos
	 * @param text
	 * @return
	 */
	public static TSourceToken firstSelectNotWhitespaceAndReturnToken(
			TSourceTokenList list, int startPos, String text )
	{
		for ( int i = startPos; i < list.size( ); i++ )
		{
			if ( i >= 0 && i < list.size( ) )
			{
				TSourceToken token = list.get( i );
				if ( token.tokentype == ETokenType.ttwhitespace
						|| token.tokentype == ETokenType.ttreturn
						|| list.get( i ).tokentype == ETokenType.ttsimplecomment
						|| list.get( i ).tokentype == ETokenType.ttbracketedcomment )
				{
					continue;
				}
				else
				{
					if ( token.astext != null
							&& token.astext.trim( ).equalsIgnoreCase( text ) )
					{
						return token;
					}
					else
					{
						return null;
					}
				}
			}
		}

		return null;
	}

	/**
	 * backward search the token which is the first not whitespace or return
	 * token, and its value is a fixed text
	 * 
	 * @param token
	 * @param text
	 * @return
	 */
	public static TSourceToken lastSelectedNotWhitespaceAndReturnToken(
			TSourceToken token, String text )
	{
		if ( token == null )
		{
			return null;
		}
		return lastSelectedNotWhitespaceAndReturnToken( token.container,
				token.posinlist,
				text );
	}

	public static boolean isNewLineToken( TSourceToken token )
	{
		if ( token == null || token.tokentype != ETokenType.ttreturn )
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public static boolean isSimpleComment( TSourceToken token )
	{
		if ( token == null || token.tokentype != ETokenType.ttsimplecomment )
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public static TSourceToken backforwardSearchNotWhitespaceAndReturnToken(
			TSourceToken endToken, int backforwardSearchSize, String text )
	{
		TSourceToken currentToken = endToken;
		while ( backforwardSearchSize > 0 )
		{
			currentToken = lastNotWhitespaceAndReturnToken( currentToken.container,
					currentToken.posinlist );
			if ( currentToken != null
					&& currentToken.astext != null
					&& currentToken.astext.trim( ).equalsIgnoreCase( text ) )
			{
				return currentToken;
			}

			backforwardSearchSize--;
		}
		return null;
	}

	public static TSourceToken lastSelectedToken( TSourceTokenList list,
			int startPos, int endPos, String text )
	{
		for ( int i = endPos; i >= startPos; i-- )
		{
			if ( i >= 0 && i < list.size( ) )
			{
				TSourceToken token = list.get( i );
				if ( token.toString( ).equalsIgnoreCase( text ) )
				{
					return token;
				}
			}
			else
			{
				return null;
			}
		}
		return null;
	}

	public static TSourceToken firstSelectedToken( TSourceTokenList list,
			int startPos, int endPos, String text )
	{
		for ( int i = startPos; i <= endPos; i++ )
		{
			if ( i >= 0 && i < list.size( ) )
			{
				TSourceToken token = list.get( i );
				if ( token.toString( ).equalsIgnoreCase( text ) )
				{
					return token;
				}
			}
			else
			{
				return null;
			}
		}
		return null;
	}

	// public static boolean isStartWithReturnToken(TSourceToken token) {
	// if (token == null) {
	// return false;
	// }
	// if (token.astext.startsWith("\n") || token.astext.startsWith("\r\n")) {
	// return true;
	// } else {
	// return false;
	// }
	// }

}
