
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
}
