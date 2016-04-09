package org.apache.nutch.analysis.unl.ta;

//import org.apache.nutch.unl.utils.*;
import java.util.*;


public class RelativeParticiple
{
	static String x = "";

	public static boolean check_Atha(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "RP Atha");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		// Atha
		if (ByteMeth.endsWith(topElmt, Constant.Atha))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Atha");
			s.pop();
			s.push(new Entry(Constant.a, Tag.RelativeParticipleSuffix));
			s.push(new Entry(Constant.Athu, Tag.FutureNegativeSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.Atha.length);
			topElmt = ByteMeth.addArray(topElmt, Constant.a);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		return false;
	}

	public static boolean check_uLLa(Stack s)
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "RP - uLLa");
			byte[] topElmt = ((Entry) s.peek()).getPart();
			byte[] oldTopElmt = topElmt;
           // uLLa
		   		if (ByteMeth.endsWith(topElmt, Constant.uLLa))
		   		{
		   		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "uLLa");
		   		s.pop();
		   		s.push(new Entry(Constant.uLLa, Tag.AdjectivalSuffix));
		   		topElmt = ByteMeth.subArray(topElmt, 0,
		   		topElmt.length - Constant.uLLa.length);
		   		s.push(new Entry(topElmt, -1, oldTopElmt));
		   		Sandhi.k(s);
		   		return true;
		}
		return false;
	}

	public static boolean check_thakka(Stack s)
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "RP - uLLa");
				byte[] topElmt = ((Entry) s.peek()).getPart();
				byte[] oldTopElmt = topElmt;
	           // thakka
			   		if (ByteMeth.endsWith(topElmt, Constant.thakka))
			   		{
			   		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "thakka");
			   		s.pop();
			   		s.push(new Entry(Constant.thakka, Tag.AdjectivalSuffix));
			   		topElmt = ByteMeth.subArray(topElmt, 0,
			   		topElmt.length - Constant.thakka.length);
			   		s.push(new Entry(topElmt, -1, oldTopElmt));
			   		Sandhi.k(s);
			   		return true;
			}
			return false;
	}

	public static boolean check_al(Stack s)
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "RP - al");
			byte[] topElmt = ((Entry) s.peek()).getPart();
			byte[] oldTopElmt = topElmt;

			// new
			// a
			if (ByteMeth.endsWith(topElmt,
			  ByteMeth.addArray(Constant.Tense, Constant.al)))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "al");
				s.pop();
				s.push(new Entry(Constant.al, Tag.RelativeParticipleSuffix));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.al.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				return true;
		     }
		     return false;
	     }

	public static boolean check_a(Stack s)
	{  if(!ADictionary.m_EndNoun(s))
	    {
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "RP - a");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// new
		// a
		if(!ByteMeth.endsWith(topElmt,Constant.Ana))
			{
		      if (ByteMeth.endsWith(topElmt,
		            ByteMeth.addArray(Constant.RTense, Constant.a)))
		        {
			    //clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "a");
			     s.pop();
			     s.push(new Entry(Constant.a, Tag.RelativeParticipleSuffix));
			     topElmt = ByteMeth.subArray(topElmt, 0,
			            topElmt.length - Constant.a.length);
			     s.push(new Entry(topElmt, -1, oldTopElmt));
			     Sandhi.check(s);
			     return true;
		         }
		         else if(ByteMeth.endsWith(topElmt,Constant.ta))
		         {
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "a");
					s.pop();
					s.push(new Entry(Constant.a, Tag.RelativeParticipleSuffix));
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.a.length);
					  topElmt = ByteMeth.addArray(topElmt, Constant.u);
					s.push(new Entry(topElmt, -1, oldTopElmt));
					Sandhi.check(s);
					return true;
		         }
			 }
	      }
		////System.out.println("relative participle false");
          return false;
	 }
}
