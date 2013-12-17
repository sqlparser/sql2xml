
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class when_operand
{

	@Element(required = false)
	private row_value_predicand row_value_predicand;

	@Element(required = false)
	private comparison_predicate_part_2 comparison_predicate_part_2;

	@Element(required = false)
	private between_predicate_part_2 between_predicate_part_2;

	@Element(required = false)
	private in_predicate_part_2 in_predicate_part_2;

	@Element(required = false)
	private character_like_predicate_part_2 character_like_predicate_part_2;

	@Element(required = false)
	private octet_like_predicate_part_2 octet_like_predicate_part_2;

	@Element(required = false)
	private similar_predicate_part_2 similar_predicate_part_2;

	@Element(required = false)
	private regex_like_predicate_part_2 regex_like_predicate_part_2;

	@Element(required = false)
	private null_predicate_part_2 null_predicate_part_2;

	@Element(required = false)
	private quantified_comparison_predicate_part_2 quantified_comparison_predicate_part_2;

	@Element(required = false)
	private normalized_predicate_part_2 normalized_predicate_part_2;

	@Element(required = false)
	private match_predicate_part_2 match_predicate_part_2;

	@Element(required = false)
	private overlaps_predicate_part_2 overlaps_predicate_part_2;

	@Element(required = false)
	private distinct_predicate_part_2 distinct_predicate_part_2;

	@Element(required = false)
	private member_predicate_part_2 member_predicate_part_2;

	@Element(required = false)
	private submultiset_predicate_part_2 submultiset_predicate_part_2;

	@Element(required = false)
	private set_predicate_part_2 set_predicate_part_2;

	@Element(required = false)
	private type_predicate_part_2 type_predicate_part_2;

	public row_value_predicand getRow_value_predicand( )
	{
		return row_value_predicand;
	}

	public void setRow_value_predicand( row_value_predicand row_value_predicand )
	{
		this.row_value_predicand = row_value_predicand;
	}

	public comparison_predicate_part_2 getComparison_predicate_part_2( )
	{
		return comparison_predicate_part_2;
	}

	public void setComparison_predicate_part_2(
			comparison_predicate_part_2 comparison_predicate_part_2 )
	{
		this.comparison_predicate_part_2 = comparison_predicate_part_2;
	}

	public between_predicate_part_2 getBetween_predicate_part_2( )
	{
		return between_predicate_part_2;
	}

	public void setBetween_predicate_part_2(
			between_predicate_part_2 between_predicate_part_2 )
	{
		this.between_predicate_part_2 = between_predicate_part_2;
	}

	public in_predicate_part_2 getIn_predicate_part_2( )
	{
		return in_predicate_part_2;
	}

	public void setIn_predicate_part_2( in_predicate_part_2 in_predicate_part_2 )
	{
		this.in_predicate_part_2 = in_predicate_part_2;
	}

	public character_like_predicate_part_2 getCharacter_like_predicate_part_2( )
	{
		return character_like_predicate_part_2;
	}

	public void setCharacter_like_predicate_part_2(
			character_like_predicate_part_2 character_like_predicate_part_2 )
	{
		this.character_like_predicate_part_2 = character_like_predicate_part_2;
	}

	public octet_like_predicate_part_2 getOctet_like_predicate_part_2( )
	{
		return octet_like_predicate_part_2;
	}

	public void setOctet_like_predicate_part_2(
			octet_like_predicate_part_2 octet_like_predicate_part_2 )
	{
		this.octet_like_predicate_part_2 = octet_like_predicate_part_2;
	}

	public similar_predicate_part_2 getSimilar_predicate_part_2( )
	{
		return similar_predicate_part_2;
	}

	public void setSimilar_predicate_part_2(
			similar_predicate_part_2 similar_predicate_part_2 )
	{
		this.similar_predicate_part_2 = similar_predicate_part_2;
	}

	public regex_like_predicate_part_2 getRegex_like_predicate_part_2( )
	{
		return regex_like_predicate_part_2;
	}

	public void setRegex_like_predicate_part_2(
			regex_like_predicate_part_2 regex_like_predicate_part_2 )
	{
		this.regex_like_predicate_part_2 = regex_like_predicate_part_2;
	}

	public null_predicate_part_2 getNull_predicate_part_2( )
	{
		return null_predicate_part_2;
	}

	public void setNull_predicate_part_2(
			null_predicate_part_2 null_predicate_part_2 )
	{
		this.null_predicate_part_2 = null_predicate_part_2;
	}

	public quantified_comparison_predicate_part_2 getQuantified_comparison_predicate_part_2( )
	{
		return quantified_comparison_predicate_part_2;
	}

	public void setQuantified_comparison_predicate_part_2(
			quantified_comparison_predicate_part_2 quantified_comparison_predicate_part_2 )
	{
		this.quantified_comparison_predicate_part_2 = quantified_comparison_predicate_part_2;
	}

	public normalized_predicate_part_2 getNormalized_predicate_part_2( )
	{
		return normalized_predicate_part_2;
	}

	public void setNormalized_predicate_part_2(
			normalized_predicate_part_2 normalized_predicate_part_2 )
	{
		this.normalized_predicate_part_2 = normalized_predicate_part_2;
	}

	public match_predicate_part_2 getMatch_predicate_part_2( )
	{
		return match_predicate_part_2;
	}

	public void setMatch_predicate_part_2(
			match_predicate_part_2 match_predicate_part_2 )
	{
		this.match_predicate_part_2 = match_predicate_part_2;
	}

	public overlaps_predicate_part_2 getOverlaps_predicate_part_2( )
	{
		return overlaps_predicate_part_2;
	}

	public void setOverlaps_predicate_part_2(
			overlaps_predicate_part_2 overlaps_predicate_part_2 )
	{
		this.overlaps_predicate_part_2 = overlaps_predicate_part_2;
	}

	public distinct_predicate_part_2 getDistinct_predicate_part_2( )
	{
		return distinct_predicate_part_2;
	}

	public void setDistinct_predicate_part_2(
			distinct_predicate_part_2 distinct_predicate_part_2 )
	{
		this.distinct_predicate_part_2 = distinct_predicate_part_2;
	}

	public member_predicate_part_2 getMember_predicate_part_2( )
	{
		return member_predicate_part_2;
	}

	public void setMember_predicate_part_2(
			member_predicate_part_2 member_predicate_part_2 )
	{
		this.member_predicate_part_2 = member_predicate_part_2;
	}

	public submultiset_predicate_part_2 getSubmultiset_predicate_part_2( )
	{
		return submultiset_predicate_part_2;
	}

	public void setSubmultiset_predicate_part_2(
			submultiset_predicate_part_2 submultiset_predicate_part_2 )
	{
		this.submultiset_predicate_part_2 = submultiset_predicate_part_2;
	}

	public set_predicate_part_2 getSet_predicate_part_2( )
	{
		return set_predicate_part_2;
	}

	public void setSet_predicate_part_2(
			set_predicate_part_2 set_predicate_part_2 )
	{
		this.set_predicate_part_2 = set_predicate_part_2;
	}

	public type_predicate_part_2 getType_predicate_part_2( )
	{
		return type_predicate_part_2;
	}

	public void setType_predicate_part_2(
			type_predicate_part_2 type_predicate_part_2 )
	{
		this.type_predicate_part_2 = type_predicate_part_2;
	}

}
