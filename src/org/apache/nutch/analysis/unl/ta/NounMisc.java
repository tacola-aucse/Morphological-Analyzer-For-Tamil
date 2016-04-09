package org.apache.nutch.analysis.unl.ta;

//import org.apache.nutch.unl.utils.*;
import java.util.Stack;


public class NounMisc
{
	static org.apache.nutch.analysis.unl.ta.ByteMeth ByteMeth;
	static String x = "";

	public static boolean adjective(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Adjective");
		// Ana
		if (ByteMeth.endsWith(topElmt, Constant.Ana))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Ana");
			s.pop();
			s.push(new Entry(Constant.Ana, Tag.AdjectivalSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.Ana.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		// iya
		/* if(ByteMeth.endsWith(topElmt,Constant.iya) &&
		 !ByteMeth.endsWith(topElmt,Constant.ottiya))
		 {
		 //clia.unl.unicode.utils.Utils.printOut(Analyser.print,x + "iya");
		 s.pop();
		 s.push(new Entry(Constant.iya,Tag.AdjectivalSuffix));
		 topElmt = ByteMeth.subArray(topElmt,0,topElmt.
		 length-Constant.iya.length);
		 s.push(new Entry(topElmt,-1,oldTopElmt));
		 Sandhi.type2(s);
		 Sandhi.type4(s);
		 Sandhi.type5(s);
		 return true;
		 }*/

		// uLLa
		if (ByteMeth.endsWith(topElmt, Constant.uLLa))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "uLLa");
			s.pop();
			s.push(new Entry(Constant.uLLa, Tag.AdjectivalSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.uLLa.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		// aRRa
		if (ByteMeth.endsWith(topElmt, Constant.aRRa))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "aRRa");
			s.pop();
			s.push(new Entry(Constant.aRRa, Tag.AdjectivalSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.aRRa.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}
		return false;
	}

	public static boolean angu_ingu_engu(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "AIE - angku, ingku, engku");
		// angku
		if (ByteMeth.isEqual(topElmt, Constant.angku))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "angku");
			s.pop();
			s.push(new Entry(Constant.angku, Tag.Adverb));
			return true;
		}

		// ingku
		if (ByteMeth.isEqual(topElmt, Constant.ingku))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ingku");
			s.pop();
			s.push(new Entry(Constant.ingku, Tag.Adverb));
			return true;
		}

		// engku
		if (ByteMeth.isEqual(topElmt, Constant.engku))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "engku");
			s.pop();
			s.push(new Entry(Constant.engku, Tag.InterrogativeNoun));
			return true;
		}

		return false;
	}

	public static boolean adverb(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Adverb");
		// aRRu
		if (ByteMeth.endsWith(topElmt, Constant.aRRu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "aRRu");
			s.pop();
			s.push(new Entry(Constant.aRRu, Tag.AdverbialSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.aRRu.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		// Aka
		if (ByteMeth.endsWith(topElmt, Constant.Aka)
		  && !ByteMeth.endsWith(topElmt, Constant.viLaivAka)
		  && !ByteMeth.endsWith(topElmt, Constant.sArbAka))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Aka");
			s.pop();
			s.push(new Entry(Constant.Aka, Tag.AdverbialSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.Aka.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		// Ay
		if (ByteMeth.endsWith(topElmt, Constant.Ay))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Ay");
			s.pop();
			s.push(new Entry(Constant.Ay, Tag.AdverbialSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.Ay.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}
		return false;
	}

	public static boolean pronominal(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Noun Misc Pronominal");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// van
		if (ByteMeth.endsWith(topElmt, Constant.van))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.van.length);

			if (!BooleanMethod.endsWith_Adjective(topElmt1))
			{
				return false;
			}

			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "v + an");
			s.pop();
			s.push(
			  new Entry(Constant.an, Tag.PronominalThirdPersonMasculineSingular));
			s.push(new Entry(Constant.v, Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.van.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// vaL
		if (ByteMeth.endsWith(topElmt, Constant.vaL))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vaL.length);
			  	System.out.println("Inside vaL");

			if (!BooleanMethod.endsWith_Adjective(topElmt1))
			{
				return false;
			}
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "v + aL");
			s.pop();
			s.push(
			  new Entry(Constant.aL, Tag.PronominalThirdPersonFemineSingular));
			s.push(new Entry(Constant.v, Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vaL.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// var
		if (ByteMeth.endsWith(topElmt, Constant.var))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.var.length);

			if (!BooleanMethod.endsWith_Adjective(topElmt1))
			{
				return false;
			}
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "v + ar");
			s.pop();
			s.push(new Entry(Constant.ar, Tag.PronominalThirdPersonSingular));
			s.push(new Entry(Constant.v, Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.var.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// varkaL
		if (ByteMeth.endsWith(topElmt, Constant.varkaL))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.varkaL.length);

			if (!BooleanMethod.endsWith_Adjective(topElmt1))
			{
				return false;
			}
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "v + arkaL");
			s.pop();
			s.push(new Entry(Constant.arkaL, Tag.PronominalThirdPersonPlural));
			s.push(new Entry(Constant.v, Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.varkaL.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// athu
		if (ByteMeth.endsWith(topElmt, Constant.thu))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.thu.length);

			if (!BooleanMethod.endsWith_Adjective(topElmt1))
			{
				return false;
			}
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "athu");
			s.pop();
			s.push(new Entry(Constant.thu, Tag.PronominalNeuterSingular));

			topElmt = ByteMeth.subArray(topElmt, 0,topElmt.length - Constant.thu.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// vai
		if (ByteMeth.endsWith(topElmt, Constant.vai))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vai.length);

			if (!BooleanMethod.endsWith_Adjective(topElmt1))
			{
				return false;
			}
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "v + ai");
			s.pop();
			s.push(new Entry(Constant.ai, Tag.PronomianlNeuterPlural));
			s.push(new Entry(Constant.v, Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vai.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// vaikaL
		if (ByteMeth.endsWith(topElmt, Constant.vaikaL))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vaikaL.length);

			if (!BooleanMethod.endsWith_Adjective(topElmt1))
			{
				return false;
			}
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "v + aikaL");
			s.pop();
			s.push(new Entry(Constant.aikaL, Tag.PronomianlNeuterPlural));
			s.push(new Entry(Constant.v, Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vaikaL.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}

		return false;
	}

	public static boolean finiteVerb(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Finite Verb");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// AyiRRu
		if (ByteMeth.endsWith(topElmt, Constant.AyiRRu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "AyiRRu");
			s.pop();
			s.push(new Entry(Constant.AyiRRu, Tag.FiniteVerbSuffix));

			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.AyiRRu.length);

			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		// irukkattum
		if (ByteMeth.endsWith(topElmt, Constant.irukkattum))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "irukkattum");
			s.pop();
			s.push(new Entry(Constant.irukkattum, Tag.FiniteVerbSuffix));

			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.irukkattum.length);

			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		// uNtu
		if (ByteMeth.endsWith(topElmt, Constant.uNtu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "uNtu");
			s.pop();
			s.push(new Entry(Constant.uNtu, Tag.FiniteVerbSuffix));

			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.uNtu.length);

			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
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
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		// AkAthu
		if (ByteMeth.endsWith(topElmt, Constant.AkAthu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "AkAthu");
			s.pop();
			s.push(new Entry(Constant.AkAthu, Tag.NegativeFiniteVerbSuffix));

			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.AkAthu.length);

			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		// iLLai
		if (ByteMeth.endsWith(topElmt, Constant.iLLai))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "iLLai");
			s.pop();
			s.push(new Entry(Constant.iLLai, Tag.NegativeFiniteVerbSuffix));

			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.iLLai.length);

			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}
		return false;
	}

	public static boolean checkNumber(Stack allStk, String inputString)
	{
		Stack s = new Stack();

		try
		{
			String strs=(new String(inputString)).intern();
			////System.out.println("checking number");
			if( charNum.check(strs))
			{
				////System.out.println("Nounmisc:check:"+strs);
				s.push(new Entry(UnicodeConverter.convert(inputString), Tag.cNumbers)); // temp
				allStk.push(s);
				return true;
			}
			else if( charNum.dtcheck(strs))
			{
				////System.out.println("Nounmisc:dtcheck"+strs);
				s.push(new Entry(UnicodeConverter.convert(inputString), Tag.DT)); // temp
				allStk.push(s);
				return true;
			}
			else if( charNum.EXcheck(strs))
			{
				////System.out.println("Nounmisc:Excheck"+strs);
				int e=inputString.indexOf("யில்");
				String Str1=(inputString.substring(0,e)).intern();
				s.push(new Entry(Constant.il, Tag.LocativeCase));
				s.push(new Entry(Constant.y, Tag.Sandhi));
				s.push(new Entry(UnicodeConverter.convert(Str1), Tag.Noun)); // temp
				allStk.push(s);
				return true;
			 }
			else if(!(Integer.parseInt(inputString)==0))
			{
			  	////System.out.println("Nounmisc:Non Integer");
				byte b[]=UnicodeConverter.convert(inputString);
				for(int i=0;i<b.length;i++)
				{
					////System.out.println(" hi"+b[i]);
				}
			  	s.push(new Entry(b, Tag.Numbers)); // temp
			  	allStk.push(s);
			  	return true;
		    	}

			else
		    	{
			  	////System.out.println("Nounmisc:not a number");
		      		return false;
		    	}
		}
		catch (NumberFormatException e)
		{    //   e.printStackTrace();
			return false;
		}

	}

}
