package org.apache.nutch.analysis.unl.ta;
//import org.apache.nutch.unl.utils.*;
import java.util.Stack;


public class Infinity
{
	static String x = "";
	static ByteMeth ByteMeth;
	static UnicodeConverter TC;

	public static boolean kka_ka(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Infinitive kka ka");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// kka
		if (ByteMeth.endsWith(topElmt, Constant.kka))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kka");
			s.pop();
			s.push(new Entry(Constant.kka, Tag.InfinitiveSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.kka.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// ka
		if (ByteMeth.endsWith(topElmt, Constant.ka))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ka");
			s.pop();
			s.push(new Entry(Constant.ka, Tag.InfinitiveSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.ka.length);
			if (ByteMeth.isEqual(topElmt, Constant.kEt))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
			}
			if (ByteMeth.isEqual(topElmt, Constant.kaR))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		return false;
	}

	public static boolean a(Stack s)
	 {
		if(!ADictionary.m_EndNoun(s))
	    {
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Inf a");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// a
		   if (ByteMeth.endsWith(topElmt, Constant.a)&& !ByteMeth.endsWith(topElmt, Constant.alla)
		   && !ByteMeth.endsWith(topElmt, Constant.Ana))
	    	{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "a");
			s.pop();
			s.push(new Entry(Constant.a, Tag.InfinitiveSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.a.length);
			if (ByteMeth.contains(topElmt, Constant.var)
			  || ByteMeth.contains(topElmt, Constant.thar))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "var,thar - va,tha");
				topElmt = ByteMeth.replace(topElmt, Constant.A,
				  Constant.ar.length);
			}

			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
	    	}
	   // athAl
			if (ByteMeth.endsWith(topElmt, Constant.athAl))
			 	{
				 //clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "athAl");
				 s.pop();
				 s.push(new Entry(Constant.athAl, Tag.ConditionalSuffix));
				 topElmt = ByteMeth.subArray(topElmt, 0,
				 topElmt.length - Constant.athAl.length);
				 if (ByteMeth.contains(topElmt, Constant.var)
									  || ByteMeth.contains(topElmt, Constant.thar))
				  {
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "var,thar - va,tha");
					topElmt = ByteMeth.replace(topElmt, Constant.A,
					  Constant.ar.length);
				  }
			     s.push(new Entry(topElmt, -1, oldTopElmt));
				 return true;
		    	 }
	   }
		return false;
	}

	public static boolean infinitive_Ends(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Inf End");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// AvittAl
		if (ByteMeth.endsWith(topElmt, Constant.AvittAl))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "AvittAl");
			s.pop();
			s.push(
			  new Entry(Constant.AvittAl, Tag.NegativeConditionalSuffixSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.AvittAl.length);
			topElmt = ByteMeth.addArray(topElmt, Constant.a);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		// AvittAlum
		if (ByteMeth.endsWith(topElmt, Constant.AvittAlum))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "AvittAlum");
			s.pop();
			s.push(new Entry(Constant.um, Tag.ConcessiveSuffix));
			s.push(
			  new Entry(Constant.AvittAlum, Tag.NegativeConditionalSuffixSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.AvittAlum.length);
			topElmt = ByteMeth.addArray(topElmt, Constant.a);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.check(s);
			return true;
		}
		// illAmal
				if (ByteMeth.endsWith(topElmt, Constant.illAmal))
				{
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "illAmal");
					s.pop();
					s.push(new Entry(Constant.illAmal, Tag.NegativeConditionalSuffixSuffix));
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.illAmal.length);
					s.push(new Entry(topElmt, -1, oldTopElmt));
					Sandhi.check(s);
					return true;
				}


		// Amal
		if (ByteMeth.endsWith(topElmt, Constant.Amal))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Amal");
			s.pop();
			s.push(new Entry(Constant.Amal, Tag.NegativeConditionalSuffixSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.Amal.length);
			topElmt = ByteMeth.addArray(topElmt, Constant.a);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.check(s);
			return true;
		}
		// AthathAl
				if (ByteMeth.endsWith(topElmt, Constant.AthathAl))
				{
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "AthathAl");
					s.pop();
					s.push(new Entry(Constant.AthathAl, Tag.NegativeConditionalSuffixSuffix));
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.AthathAl.length);
					topElmt = ByteMeth.addArray(topElmt, Constant.a);
					s.push(new Entry(topElmt, -1, oldTopElmt));
					Sandhi.check(s);
					return true;
		}

		// Amalum
		if (ByteMeth.endsWith(topElmt, Constant.Amalum))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Amalum");
			s.pop();
			s.push(new Entry(Constant.um, Tag.ConcessiveSuffix));
			s.push(new Entry(Constant.Amal, Tag.NegativeConditionalSuffixSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.Amalum.length);
			topElmt = ByteMeth.addArray(topElmt, Constant.a);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		// lAm
		if (ByteMeth.endsWith(topElmt, Constant.lAm))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "lAm");
			s.pop();
			s.push(new Entry(Constant.lAm, Tag.PermissiveSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.lAm.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// ttum
		if (ByteMeth.endsWith(topElmt, Constant.ttum))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ttum");
			s.pop();
			s.push(new Entry(Constant.ttum, Tag.PermissiveSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.ttum.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// vittAl
		if (ByteMeth.endsWith(topElmt, Constant.vittAl))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "vittAl");
			s.pop();
			s.push(new Entry(Constant.vittAl, Tag.ConditionalSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vittAl.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// AthE
		if (ByteMeth.endsWith(topElmt, Constant.AthE))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "AthE");
			s.pop();
			s.push(new Entry(Constant.E, Tag.SecondPersonSingularSuffix));
			s.push(new Entry(Constant.Ath, Tag.ImperativeNegativeORProhibitive));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.AthE.length);
			topElmt = ByteMeth.addArray(topElmt, Constant.a);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.check(s);
			return true;
		}
		// AthIrkaL
		if (ByteMeth.endsWith(topElmt, Constant.AthIrkaL))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "AthIrkaL");
			s.pop();
			s.push(new Entry(Constant.IrkaL, Tag.SecondPersonPluralSuffix));
			s.push(new Entry(Constant.Ath, Tag.ImperativeNegativeORProhibitive));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.AthIrkaL.length);
			topElmt = ByteMeth.addArray(topElmt, Constant.a);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.check(s);
			return true;
		}
		// Athu
		if (ByteMeth.endsWith(topElmt, Constant.Athu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Athu");
			s.pop();
			s.push(new Entry(Constant.Athu, Tag.FutureNegativeSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.Athu.length);
			topElmt = ByteMeth.addArray(topElmt, Constant.a);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.check(s);
			return true;
		}
		// Avitil
		if (ByteMeth.endsWith(topElmt, Constant.Avitil))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Avitil");
			s.pop();
			s.push(new Entry(Constant.Avitil, Tag.NegativeConditionalSuffixSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.Avitil.length);
			topElmt = ByteMeth.addArray(topElmt, Constant.a);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.check(s);
			return true;
		}
		// uLLathu
				if (ByteMeth.endsWith(topElmt, Constant.uLLathu))
				{
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "uLLathu");
					s.pop();
					s.push(new Entry(Constant.uLLathu, Tag.FiniteVerbSuffix));
					topElmt = ByteMeth.subArray(topElmt, 0,
				    topElmt.length - Constant.uLLathu.length);
				    s.push(new Entry(topElmt, -1, oldTopElmt));
				    Sandhi.check(s);
					return true;
		}
		// uLLana
						if (ByteMeth.endsWith(topElmt, Constant.uLLana))
						{
							//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "uLLana");
							s.pop();
							s.push(new Entry(Constant.uLLana, Tag.FiniteVerbSuffix));
							topElmt = ByteMeth.subArray(topElmt, 0,
						    topElmt.length - Constant.uLLana.length);
						    s.push(new Entry(topElmt, -1, oldTopElmt));
						    Sandhi.check(s);
							return true;
		}
		// vENtumAnAl
				if (ByteMeth.endsWith(topElmt, Constant.vENtumAnAl))
				{
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "vENtumAnAl");
					s.pop();
					s.push(new Entry(Constant.AnAl, Tag.ConditionalSuffix));
					s.push(new Entry(Constant.vENdum, Tag.Verb));
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.vENtumAnAl.length);
					s.push(new Entry(topElmt, -1, oldTopElmt));
					return true;
		}
		// AnAl
				if (ByteMeth.endsWith(topElmt, Constant.AnAl))
				{
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "AnAl");
					s.pop();
					s.push(new Entry(Constant.AnAl, Tag.ConjunctionSuffix));
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.AnAl.length);
					s.push(new Entry(topElmt, -1, oldTopElmt));
					return true;
		        }

		// vENtumena
		if (ByteMeth.endsWith(topElmt, Constant.vENtumena))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "vENtumena");
			s.pop();
			s.push(new Entry(Constant.ena, Tag.ParticleSuffix));
			s.push(new Entry(Constant.vENdum, Tag.Verb));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vENtumena.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// vENtumenRu
		if (ByteMeth.endsWith(topElmt, Constant.vENtumenRu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "vENtumenRu");
			s.pop();
			s.push(new Entry(Constant.enRu, Tag.ParticleSuffix));
			s.push(new Entry(Constant.vENdum, Tag.Verb));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vENtumenRu.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		return false;
	}

	public static boolean mAtt(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// mAtt
		if (ByteMeth.endsWith(topElmt, Constant.mAtt))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "mAtt");
			s.pop();
			s.push(new Entry(Constant.mAtt, Tag.FutureNegativeSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.mAtt.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		return false;
	}

	public static boolean check(Stack s)
	{
		Stack originalStack = (Stack) s.clone();
		
		if (Infinity.kka_ka(s))
		{
			////System.out.println("kka_ka");
			byte[] topElmt = ((Entry) s.peek()).getPart();
			byte[] oldTopElmt = topElmt;
			
			if (ADictionary.Verb_BTree.equals(topElmt))
			{
				return true;
			}
			if (BooleanMethod.endsWith_AuxVerb(topElmt))
			{
				return true;
			}
		}
		Misc.backTrack(originalStack, s);
		if (Infinity.a(s))
		{
			//////System.out.println("a");
			originalStack = (Stack) s.clone();
			if (Sandhi.type5(s))
			{
			//////System.out.println("type5");
				;
			} else if (Sandhi.type2(s))
			{
			//////System.out.println("type2");	
				;
			}
			byte[] topElmt = ((Entry) s.peek()).getPart();
			byte[] oldTopElmt = topElmt;

			if (ADictionary.Verb_BTree.equals(topElmt))
			{
				return true;
			}
			if (BooleanMethod.endsWith_AuxVerb(topElmt))
			{
				return true;
			} else
			{
				////System.out.println("else");
				Misc.backTrack(originalStack, s);
				if (Sandhi.type4(s))
				{
					topElmt = ((Entry) s.peek()).getPart();
					if (ADictionary.Verb_BTree.equals(topElmt))
					{
						return true;
					}
					if (BooleanMethod.endsWith_AuxVerb(topElmt))
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	/* public static boolean check_Athu(Stack s)
	 {
	 //last - see fix.txt last line
	 //Athu
	 if(ByteMeth.endsWith(topElmt,Constant.Ath))
	 {
	 //clia.unl.unicode.utils.Utils.printOut(Analyser.print,x + "Athu");
	 s.pop();
	 s.push(new Entry(Constant.Athu,Tag.FutureNegativeSuffix));
	 topElmt = ByteMeth.subArray(topElmt,0,topElmt.
	 length-Constant.Ath.length);
	 topElmt = ByteMeth.addArray(topElmt,Constant.a);
	 s.push(new Entry(topElmt,-1,oldTopElmt));
	 return true;
	 }
	 }*/
}
