
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class predicate
{
	@Element(required = false)
	private comparison_predicate comparison_predicate;
	
	@Element(required = false)
	private between_predicate between_predicate;
	
	@Element(required = false)
	private in_predicate in_predicate;
	
	@Element(required = false)
	private like_predicate like_predicate;
	
	@Element(required = false)
	private similar_predicate similar_predicate;
	
	@Element(required = false)
	private regex_like_predicate regex_like_predicate;
	
	@Element(required = false)
	private null_predicate null_predicate;
	
	@Element(required = false)
	private quantified_comparison_predicate quantified_comparison_predicate;
	
	@Element(required = false)
	private exists_predicate exists_predicate;
	
	@Element(required = false)
	private unique_predicate unique_predicate;
	
	@Element(required = false)
	private normalized_predicate normalized_predicate;
	
	@Element(required = false)
	private match_predicate match_predicate;
	
	@Element(required = false)
	private overlaps_predicate overlaps_predicate;
	
	@Element(required = false)
	private distinct_predicate distinct_predicate;
	
	@Element(required = false)
	private member_predicate member_predicate;
	
	@Element(required = false)
	private submultiset_predicate submultiset_predicate;
	
	@Element(required = false)
	private set_predicate set_predicate;
	
	@Element(required = false)
	private type_predicate type_predicate;

	public comparison_predicate getComparison_predicate( )
	{
		return comparison_predicate;
	}

	public void setComparison_predicate(
			comparison_predicate comparison_predicate )
	{
		this.comparison_predicate = comparison_predicate;
	}

	public between_predicate getBetween_predicate( )
	{
		return between_predicate;
	}

	public void setBetween_predicate( between_predicate between_predicate )
	{
		this.between_predicate = between_predicate;
	}

	public in_predicate getIn_predicate( )
	{
		return in_predicate;
	}

	public void setIn_predicate( in_predicate in_predicate )
	{
		this.in_predicate = in_predicate;
	}

	public like_predicate getLike_predicate( )
	{
		return like_predicate;
	}

	public void setLike_predicate( like_predicate like_predicate )
	{
		this.like_predicate = like_predicate;
	}

	public similar_predicate getSimilar_predicate( )
	{
		return similar_predicate;
	}

	public void setSimilar_predicate( similar_predicate similar_predicate )
	{
		this.similar_predicate = similar_predicate;
	}

	public regex_like_predicate getRegex_like_predicate( )
	{
		return regex_like_predicate;
	}

	public void setRegex_like_predicate(
			regex_like_predicate regex_like_predicate )
	{
		this.regex_like_predicate = regex_like_predicate;
	}

	public null_predicate getNull_predicate( )
	{
		return null_predicate;
	}

	public void setNull_predicate( null_predicate null_predicate )
	{
		this.null_predicate = null_predicate;
	}

	public quantified_comparison_predicate getQuantified_comparison_predicate( )
	{
		return quantified_comparison_predicate;
	}

	public void setQuantified_comparison_predicate(
			quantified_comparison_predicate quantified_comparison_predicate )
	{
		this.quantified_comparison_predicate = quantified_comparison_predicate;
	}

	public exists_predicate getExists_predicate( )
	{
		return exists_predicate;
	}

	public void setExists_predicate( exists_predicate exists_predicate )
	{
		this.exists_predicate = exists_predicate;
	}

	public unique_predicate getUnique_predicate( )
	{
		return unique_predicate;
	}

	public void setUnique_predicate( unique_predicate unique_predicate )
	{
		this.unique_predicate = unique_predicate;
	}

	public normalized_predicate getNormalized_predicate( )
	{
		return normalized_predicate;
	}

	public void setNormalized_predicate(
			normalized_predicate normalized_predicate )
	{
		this.normalized_predicate = normalized_predicate;
	}

	public match_predicate getMatch_predicate( )
	{
		return match_predicate;
	}

	public void setMatch_predicate( match_predicate match_predicate )
	{
		this.match_predicate = match_predicate;
	}

	public overlaps_predicate getOverlaps_predicate( )
	{
		return overlaps_predicate;
	}

	public void setOverlaps_predicate( overlaps_predicate overlaps_predicate )
	{
		this.overlaps_predicate = overlaps_predicate;
	}

	public distinct_predicate getDistinct_predicate( )
	{
		return distinct_predicate;
	}

	public void setDistinct_predicate( distinct_predicate distinct_predicate )
	{
		this.distinct_predicate = distinct_predicate;
	}

	public member_predicate getMember_predicate( )
	{
		return member_predicate;
	}

	public void setMember_predicate( member_predicate member_predicate )
	{
		this.member_predicate = member_predicate;
	}

	public submultiset_predicate getSubmultiset_predicate( )
	{
		return submultiset_predicate;
	}

	public void setSubmultiset_predicate(
			submultiset_predicate submultiset_predicate )
	{
		this.submultiset_predicate = submultiset_predicate;
	}

	public set_predicate getSet_predicate( )
	{
		return set_predicate;
	}

	public void setSet_predicate( set_predicate set_predicate )
	{
		this.set_predicate = set_predicate;
	}

	public type_predicate getType_predicate( )
	{
		return type_predicate;
	}

	public void setType_predicate( type_predicate type_predicate )
	{
		this.type_predicate = type_predicate;
	}
}
