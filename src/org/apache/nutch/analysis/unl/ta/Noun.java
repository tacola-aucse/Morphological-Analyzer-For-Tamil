package org.apache.nutch.analysis.unl.ta;

//import org.apache.nutch.unl.utils.*;
import java.util.*;

// import demo.*;

public class Noun
{
	static String x = "";
	static UnicodeConverter TC;
	static int c = 0;

	public static boolean check(Stack allStk, byte [] topElmt, boolean analysePart)
	{
	
		boolean isNoun = false;
		try{
      
		 if (rule_a(allStk, topElmt))
		{
			//System.out..println("rule_a True");
			isNoun = true;
		}

		else if (rule_c1(allStk, topElmt))
		{
			//System.out..println("rule_c1 True");
			isNoun = true;
		}
		else if (rule_c(allStk, topElmt, analysePart))
		{
			//System.out..println("rule_c True");
			isNoun = true;
		}

		else if (rule_b(allStk, topElmt))
		{
			//System.out..println("rule_b True");
			isNoun = true;
		}
		else if (rule_e(allStk, topElmt))
		{
			//System.out..println("rule_e True");
			isNoun = true;
		}
		else if(rule_d(allStk, topElmt))
		{
			//System.out..println("rule_d True");
			isNoun = true;
		}
   
		}
		catch(Exception e)
		{
			e.printStackTrace();
		//System.out..println("printStackTrace:"+e);
		}
		//System.out..println("noun is "+isNoun);
     return isNoun;
		
	}
	

	// rule a <Noun/PronounClitic/InterrogativeNoun+Clitic>
	public static boolean rule_a(Stack allStk, byte [] topElmt)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "RULE a");
		//System.out..println("rule_a ");
		Stack s = new Stack();

		s.push(new Entry(topElmt, -1));
		Sandhi.kctp(s);	
		//byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		//System.out..println("Clitic before true"+s.size());
		//System.out..println("revert rule_a"+UnicodeConverter.revert(topElmt));
		if (Clitic.check(s))
		{
			////System.out..println("Clitic true"+s.size());
			c++;
			if (ADictionary.noun_PronounClitic_InterrogativeNoun(s))
			{
				//System.out..println("noun_PronounClitic_InterrogativeNoun");
				allStk.push(s);
				return true;
			}
			if (Sandhi.handleException(s))
			{
				c++;
				if (ADictionary.noun_PronounClitic_InterrogativeNoun(s))
				{
					allStk.push(s);
					return true;
				}
				//System.out..println("noun_PronounClitic_InterrogativeNoun1");
			}
		}
		return false;
	}

	// rule b <Postposition/Adverb+Clitic>
	public static boolean rule_b(Stack allStk,  byte [] topElmt)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "RULE b");
		//System.out..println("rule_b ");	
		Stack s = new Stack();
//System.out..println("revert rule_b"+UnicodeConverter.revert(topElmt));
		s.push(new Entry(topElmt, -1));
		Sandhi.kctp(s);

		if (Clitic.check(s))
		{
			c++;
			if (ADictionary.adverb(s))
			{
				allStk.push(s);
				return true;
			}
			if (ADictionary.noun(s))
			{
				//allStk.push(s);
				return false;
			}			
			c++;
			if (ADictionary.postposition(s))
			{
				allStk.push(s);
				return true;
			}
			
		}
		return false;
	}

	// rule c <Noun/Noun+Plural/PronounCase/InterrogativeNoun+Case+Postposition+Clitic>
	/*
	 Noun++Case+Postposition+Clitic
	 PronounCase+Case+Postposition+Clitic
	 InterrogativeNoun+Case+Postposition+Clitic
	 Noun+Plural++Case+Postposition+Clitic
	 */
	public static boolean rule_c(Stack allStk, byte [] topElmt, boolean analysePart)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "RULE c");
		//System.out..println("rule_c ");
		Stack s = new Stack();
//System.out..println("revert rule_c"+UnicodeConverter.revert(topElmt));
		s.push(new Entry(topElmt, -1));
		Sandhi.kctp(s);
		
		boolean anySuffixFound = false,
		  hasSth = false;

		if (Clitic.check(s))
		{
			//System.out..println("clitic for noun true");
			hasSth = true;
		}
		if (ADictionary.noun(s))
		{
		 allStk.push(s);
		 return true;
		}

		if (Postposition.check(s))
		{
			//System.out..println("Postposition True");
			hasSth = true;
		}
		if (ADictionary.noun(s))
		{
		 allStk.push(s);
		 return true;
		}

		if (Case.check(s, false))
		{
			//System.out..println("Case True");
			anySuffixFound = true;
		}
		if (ADictionary.noun(s))
		{
		 allStk.push(s);
		 return true;
		}

		if (anySuffixFound)
		{
			c++;
			if (ADictionary.noun_PronounCase_InterrogativeNoun(s))
			{
				allStk.push(s);
				return true;
			}
			if (Sandhi.handleException(s))
			{
				c++;
				if (ADictionary.noun_PronounCase_InterrogativeNoun(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}

		if (anySuffixFound && SingPluralMarker.check(s))
		{
			c++;
			if (ADictionary.noun(s))
			{
				allStk.push(s);
				return true;
			}
		}

		if (analysePart)
		{
			allStk.push(s);
		}
		return false;
	}

	// why split - anu
	// rule c1 <Noun/Noun+Plural/PronounCase/InterrogativeNoun+Postposition+Clitic>
	public static boolean rule_c1(Stack allStk, byte [] topElmt)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "RULE c1");
		//System.out..println("rule_c1 ");
		Stack s = new Stack();
//System.out..println("revert rule_c1"+UnicodeConverter.revert(topElmt));
		s.push(new Entry(topElmt, -1));
		Sandhi.kctp(s);

		boolean anySuffixFound = false;

		if (Clitic.check(s))
		{
			;
		}
		// anySuffixFound = true;

		if (Postposition.check(s))
		{
			//System.out..println("In Noun Postposition True");
			anySuffixFound = true;
		}

		if (anySuffixFound)
		{
			
			c++;
			if (ADictionary.noun_PronounCase_InterrogativeNoun(s))
			{
				//System.out..println("In noun_PronounCase_InterrogativeNoun True");
				allStk.push(s);
				return true;
			}
			if (Sandhi.handleException(s))
			{
				c++;
				if (ADictionary.noun_PronounCase_InterrogativeNoun(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}

		if (SingPluralMarker.check(s))
		{
			//System.out..println("SingPluralMarker");	
			c++;
			if (ADictionary.noun(s))
			{
				allStk.push(s);
				return true;
			}
		}

		return false;
	}

	// rule d <Noun/angu_ingu_engu+AdjSuffix+Pronominal+Plural+Case+Postposition+Clitic>
	// AdjSuffix+Pronominal is a must
	public static boolean rule_d(Stack allStk, byte [] topElmt)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "RULE d");
		//System.out..println("rule_d ");
		Stack s = new Stack();
//System.out..println("revert rule_d"+UnicodeConverter.revert(topElmt));
		s.push(new Entry(topElmt, -1));
		Sandhi.kctp(s);

		boolean anySuffixFound = false,
		  hasSth = false,
		  pp = false;

		if (Clitic.check(s))
		{
			hasSth = true;
		}

		if (Postposition.check(s))
		{
			pp = true;
		}

		if (Case.check(s, true))
		{
			hasSth = true;
		}

		if (SingPluralMarker.check(s))
		{
			hasSth = true;
		}
		if (NounMisc.pronominal(s))
		{
			anySuffixFound = true;
		}

		if (NounMisc.adjective(s))
		{
			anySuffixFound = true;
		}

		// anu
		if (pp)
		{
			if (NounMisc.angu_ingu_engu(s)) // angku, ingku, engku
			{
				allStk.push(s);
				return true;
			}
		}
		if (anySuffixFound)
		{
			c++;
			if (ADictionary.noun(s))
			{
				allStk.push(s);
				return true;
			}
			if (NounMisc.angu_ingu_engu(s)) // angku, ingku, engku
			{
				allStk.push(s);
				return true;
			}
			if (Sandhi.handleException(s))
			{
				c++;
				if (ADictionary.noun(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}

		if (SingPluralMarker.check(s))
		{
			c++;
			if (ADictionary.noun(s))
			{
				allStk.push(s);
				return true;
			}
		}
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "end of.................................................... RULE d");
		return false;
	}

	// rule e <Noun/Noun+Plural/PronounClitic/InterrogativeNoun+AdvSuffix/FiniteVerb+Clitic>
	public static boolean rule_e(Stack allStk, byte [] topElmt)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "RULE e");
		//System.out..println("rule_e ");
		Stack s = new Stack();
//System.out..println("revert rule_e"+UnicodeConverter.revert(topElmt));
		s.push(new Entry(topElmt, -1));
		Sandhi.kctp(s);

		boolean anySuffixFound = false,
		  hasClitic = false;

		if (Clitic.check(s))
		{
			hasClitic = true;
		}

		if (NounMisc.adverb(s))
		{
			anySuffixFound = true;
		}

		if (NounMisc.finiteVerb(s))
		{
			anySuffixFound = true;
		}

		if (anySuffixFound)
		{
			c++;
			if (ADictionary.noun_PronounClitic_InterrogativeNoun(s))
			{
				allStk.push(s);
				return true;
			}
			if (Sandhi.handleException(s))
			{
				c++;
				if (ADictionary.noun_PronounClitic_InterrogativeNoun(s))
				{
					allStk.push(s);
					return true;
				}
			}
			if (SingPluralMarker.check(s))
			{
				c++;
				if (ADictionary.noun(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}
		return false;
	}

  /* public static boolean rule_f(Stack allStk, String inputString)
	{


	}*/
	public static boolean checkPrefix(Stack allStk, byte [] topElmt, boolean analysePart)
	{
		//System.out..println("INSIDE NOUN CHECKPREFIX");
		////System.out..println("CheckPrefix: allStk:"+allStk+"inputString:"+ inputString+"analysePart:"+analysePart);
		////clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Prefix");
		Stack s = new Stack();
		
		s.push(new Entry(topElmt, -1));

		byte[] inputByte = ((Entry) s.peek()).getPart();

		////System.out..println("inputByte:"+inputByte.toString());
		if (inputByte.length <= 3)
		{
			return false;
		}

		byte[] inputByte1 = null;
		//System.out..println("checkprefix"+UnicodeConverter.revert(topElmt));
		byte[] prefix = BooleanMethod.startsWith_prefix(inputByte);

		////System.out..println("PREFIX:"+prefix.toString());
        if (prefix != null)
	{

			s.pop();
			if(prefix.length==3)
			{
			inputByte1 = ByteMeth.subArray(inputByte, prefix.length-1, inputByte.length);
			s.push(new Entry((new byte[] { prefix[1]}), Tag.Sandhi));
			s.push(
			  new Entry((new byte[] { prefix[0]}), Tag.DemonstrativeAdjective)); // temp name for tag
	    		}
	    		else
	    		 {
		  
	    		  s.push(new Entry(prefix , Tag.DemonstrativeAdjective));
	    		  inputByte1 = ByteMeth.subArray(inputByte, prefix.length, inputByte.length);
			     }
     			
			//String nounStr = UnicodeConverter.revert(inputByte1);

			////System.out..println(nounStr);
			if (check(allStk,inputByte1, analysePart))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Prefix + Noun Inflections");
				int size = allStk.size();
				Stack[] nounInfStk = new Stack[size];

				for (int i = 0; i < size; i++)
				{
					nounInfStk[i] = (Stack) allStk.pop();
				}

				for (int i = 0; i < size; i++)
				{
					Misc.merge(s, nounInfStk[i]);
					allStk.push(nounInfStk[i]);
				}
				//return true;
			}
			//System.out..println("process completed");
			// noun
			Stack nounStk = new Stack();

			nounStk.push(new Entry(inputByte1, -1));
			if (ADictionary.noun(nounStk))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Prefix + Noun");
				Misc.merge(s, nounStk);
				allStk.push(nounStk);
				return true;
			}

		}
		return false;
	}
	// last
}
