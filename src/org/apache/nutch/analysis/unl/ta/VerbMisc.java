package org.apache.nutch.analysis.unl.ta;
//import org.apache.nutch.unl.utils.*;
import java.util.*;


public class VerbMisc
{
	static ByteMeth ByteMeth;
	static String x = "";

	public static boolean umpadi(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.umpadi))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "umpadi");
			s.pop();
			s.push(new Entry(Constant.pati, Tag.ParticleSuffix));
			s.push(new Entry(Constant.um, Tag.ThirdFutureNeuterSingularORRP));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.umpadi.length);
			if (ByteMeth.isEqual(topElmt, Constant.kEtk))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.L, 2);
			}
			if (ByteMeth.endsWith(topElmt, Constant.var)
			  || ByteMeth.endsWith(topElmt, Constant.thar))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.A,
				  Constant.ar.length);
			}
			if (ByteMeth.isEqual(topElmt, Constant.kaRk)
			  || ByteMeth.isEqual(topElmt, Constant.viRk)
			  || ByteMeth.isEqual(topElmt, Constant.n_iRk))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.l, 2);
			}
			if (ByteMeth.isEqual(topElmt, Constant.sAk)
			  || ByteMeth.isEqual(topElmt, Constant.pOk))
			{
				topElmt = ByteMeth.subArray(topElmt, 0, topElmt.length - 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.kk(s);
			Sandhi.check(s);
			return true;
		}

		return false;
	}

	public static boolean pastTM_Al(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (BooleanMethod.endsWith_PastTMHuman_Al(topElmt))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "TM_Al");
			s.pop();
			s.push(new Entry(Constant.Al, Tag.ConditionalSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.Al.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));

			Tense.human(s);
			return true;
		}
		if (BooleanMethod.endsWith_PastTMHuman_Alum(topElmt))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "TM_Alum");
			s.pop();
			s.push(new Entry(Constant.um, Tag.Clitic));
			s.push(new Entry(Constant.Al, Tag.ConditionalSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.Alum.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));

			Tense.human(s);
			return true;
		}
		return false;
	}

	public static boolean imperativeSingular1(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ISM 1 - ta,ti");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// tA
		if (ByteMeth.endsWith(topElmt, Constant.tA))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "tA");
			s.pop();
			s.push(new Entry(Constant.tA, Tag.ImperativeSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.tA.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// ti
		if (ByteMeth.endsWith(topElmt, Constant.ti))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ti");
			s.pop();
			s.push(new Entry(Constant.ti, Tag.ImperativeSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.ti.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// mmA
		if (ByteMeth.endsWith(topElmt, Constant.mmA))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "mmA");
			s.pop();
			s.push(new Entry(Constant.mmA, Tag.ImperativeSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.mmA.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// ppA
		if (ByteMeth.endsWith(topElmt, Constant.ppA))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ppA");
			s.pop();
			s.push(new Entry(Constant.ppA, Tag.ImperativeSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.ppA.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// yyA
		if (ByteMeth.endsWith(topElmt, Constant.yyA))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "yyA");
			s.pop();
			s.push(new Entry(Constant.yyA, Tag.ImperativeSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.yyA.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}

		return false;
	}

	public static boolean imperativeSingular2(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ISM 2 - uta,uti");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// utA
		if (ByteMeth.endsWith(topElmt, Constant.utA))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "utA");
			s.pop();
			s.push(new Entry(Constant.utA, Tag.ImperativeSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.utA.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type5(s);
			return true;
		}
		// uti
		if (ByteMeth.endsWith(topElmt, Constant.uti))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "uti");
			s.pop();
			s.push(new Entry(Constant.uti, Tag.ImperativeSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.uti.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type5(s);
			return true;
		}
		// ummA
		if (ByteMeth.endsWith(topElmt, Constant.ummA))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ummA");
			s.pop();
			s.push(new Entry(Constant.ummA, Tag.ImperativeSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.ummA.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type5(s);
			return true;
		}
		// uppA
		if (ByteMeth.endsWith(topElmt, Constant.uppA))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "uppA");
			s.pop();
			s.push(new Entry(Constant.uppA, Tag.ImperativeSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.uppA.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type5(s);
			return true;
		}
		// uyyA
		if (ByteMeth.endsWith(topElmt, Constant.uyyA))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "uyyA");
			s.pop();
			s.push(new Entry(Constant.uyyA, Tag.ImperativeSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.uyyA.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type5(s);
			return true;
		}

		return false;
	}

	public static boolean imperativePlural1(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "IPM1");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// ungkaL
		if (ByteMeth.endsWith(topElmt, Constant.ungkaL))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ungkaL");
			s.pop();
			s.push(new Entry(Constant.ungkaL, Tag.ImperativePluralSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.ungkaL.length);
			if (ByteMeth.isEqual(topElmt, Constant.vAr)
			  || ByteMeth.isEqual(topElmt, Constant.thAr))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.aru, 2);
			}
			if (ByteMeth.isEqual(topElmt, Constant.sAk))
			{
				topElmt = ByteMeth.subArray(topElmt, 0, topElmt.length - 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type5(s);
			return true;
		}
		return false;
	}

	public static boolean imperativePlural2(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "IPM2");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.ngkaL))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ngkaL");
			s.pop();
			s.push(new Entry(Constant.ngkaL, Tag.ImperativePluralSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.ngkaL.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type5(s);
			return true;
		}
		return false;
	}

	public static boolean finiteVerb(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Verb Misc - Finite Verb");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// kUdum
		if (ByteMeth.endsWith(topElmt, Constant.kUdum))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kUdum");
			s.pop();
			s.push(new Entry(Constant.kUdum, Tag.FiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.kUdum.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		// kUtAthu
		if (ByteMeth.endsWith(topElmt, Constant.kUtAthu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kUtAthu");
			s.pop();
			s.push(new Entry(Constant.kUtAthu, Tag.FiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.kUtAthu.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		// illai
		if (ByteMeth.endsWith(topElmt, Constant.illai))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "illai");
			s.pop();
			s.push(new Entry(Constant.illai, Tag.FiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.illai.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type2(s);
			return true;
		}
		// vENtAm
		if (ByteMeth.endsWith(topElmt, Constant.vENtAm))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "vENtAm");
			s.pop();
			s.push(new Entry(Constant.vENtAm, Tag.NegativeFiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vENtAm.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// mutiyAthu
		if (ByteMeth.endsWith(topElmt, Constant.mutiyAthu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "mutiyAthu");
			s.pop();
			s.push(new Entry(Constant.mutiyAthu, Tag.NegativeFiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.mutiyAthu.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}

		// vitAthu
		if (ByteMeth.endsWith(topElmt, Constant.vitAthu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "vitAthu");
			s.pop();
			s.push(new Entry(Constant.vitAthu, Tag.NegativeFiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vitAthu.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// vENdum
		if (ByteMeth.endsWith(topElmt, Constant.vENdum))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "vENdum");
			s.pop();
			s.push(new Entry(Constant.vENdum, Tag.FiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vENdum.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		return false;
	}

	public static boolean adverbial_Particle(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// kayil
		if (ByteMeth.endsWith(topElmt, Constant.kayil))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kayil");
			s.pop();
			s.push(new Entry(Constant.kayil, Tag.ParticleSuffix)); // change
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.kayil.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		// poothu
		if (ByteMeth.endsWith(topElmt, Constant.poothu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "poothu");
			s.pop();
			s.push(new Entry(Constant.poothu, Tag.ParticleSuffix)); // change
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.poothu.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.k(s);
			return true;
		}

		return false;
	}

	public static boolean pronominal(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Verb Misc Pronominal");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// van
		if (ByteMeth.endsWith(topElmt, Constant.van))
		{
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
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "v + arkaL");
			s.pop();
			s.push(new Entry(Constant.arkaL, Tag.PronominalThirdPersonPlural));
			s.push(new Entry(Constant.v, Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.varkaL.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}

		/* handled in Tense - athu
		 //thu - not van-thu, seththu
		 if(ByteMeth.endsWith(topElmt,Constant.thu) &&
		 !ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.n_,Constant.thu)) &&
		 !ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.th,Constant.thu)))
		 {
		 //clia.unl.unicode.utils.Utils.printOut(Analyser.print,x + "thu");
		 s.pop();
		 s.push(new Entry(Constant.thu,Tag.PronominalNeuterSingular));

		 topElmt = ByteMeth.subArray(topElmt,0,topElmt.
		 length-Constant.thu.length);
		 s.push(new Entry(topElmt,-1,oldTopElmt));
		 return true;
		 }
		 */
		// vai
		if (ByteMeth.endsWith(topElmt, Constant.vai))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "v + ai");
			s.pop();
			s.push(new Entry(Constant.ai, Tag.PronomianlNeuterPlural));
			s.push(new Entry(Constant.v, Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vai.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		//enRu 23-04-07
		if (ByteMeth.endsWith(topElmt, Constant.enRu) && !(ByteMeth.isEqual(topElmt, Constant.cenRu)) )
		{
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "enRu");
					s.pop();
					s.push(new Entry(Constant.enRu, Tag.ConjunctionSuffix));
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.enRu.length);
					s.push(new Entry(topElmt, -1, oldTopElmt));
					return true;
		 }
		// vaikaL
		if (ByteMeth.endsWith(topElmt, Constant.vaikaL))
		{
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
}
