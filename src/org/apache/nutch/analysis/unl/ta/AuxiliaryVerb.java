package org.apache.nutch.analysis.unl.ta;

//import org.apache.nutch.unl.utils.*;
import java.util.*;



public class AuxiliaryVerb
{
	static String x = "";

	static boolean hasAux = false;

	public static boolean infinitive(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Aux Verb - Infinitive");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (BooleanMethod.hasAux(topElmt))
		{
			if(ADictionary.verb(s))
			{
				return false;
			}
			// patu
			if (ByteMeth.endsWith(topElmt, Constant.patu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "patu");
				s.pop();
				s.push(new Entry(Constant.patu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.patu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.p(s);
				return true;
			}
			// pattu
						if (!(ByteMeth.isEqual(topElmt, Constant.Itupattu))
						    && ByteMeth.endsWith(topElmt, Constant.pattu)
						   )
						    {
							//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "pattu");
							s.pop();
							s.push(new Entry(Constant.pattu, Tag.AuxiliaryVerb));
							topElmt = ByteMeth.subArray(topElmt, 0,
							  topElmt.length - Constant.pattu.length);
							s.push(new Entry(topElmt, -1, oldTopElmt));
							Sandhi.p(s);
							return true;
			}
			if (ByteMeth.isEqual(topElmt, Constant.ERpata))
						           return false;

			// pata
					else if (ByteMeth.endsWith(topElmt, Constant.pata))
						{
							//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "pata");
							s.pop();
							s.push(new Entry(Constant.pata, Tag.AuxiliaryVerb));
							topElmt = ByteMeth.subArray(topElmt, 0,
							  topElmt.length - Constant.pata.length);
							s.push(new Entry(topElmt, -1, oldTopElmt));
							Sandhi.p(s);
							return true;
			              }
		}
		return false;
	}

	public static boolean verbalParticiple(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Aux Verb - VP");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (BooleanMethod.hasAux(topElmt))
		{
			// n_il
			if (ByteMeth.endsWith(topElmt, Constant.n_il))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "n_il");
				s.pop();
				s.push(new Entry(Constant.n_il, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.n_il.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				return true;
			}
			// tholai
			if (ByteMeth.endsWith(topElmt, Constant.tholai))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "tholai");
				s.pop();
				s.push(new Entry(Constant.tholai, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.tholai.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.k(s);
				return true;
			}
			// thIr
			if (ByteMeth.endsWith(topElmt, Constant.thIr))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "thIr");
				s.pop();
				s.push(new Entry(Constant.thIr, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.thIr.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.k(s);
				return true;
			}
			// thiri
			if (ByteMeth.endsWith(topElmt, Constant.thiri))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "thiri");
				s.pop();
				s.push(new Entry(Constant.thiri, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.thiri.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.th(s);
				return true;
			}
			// thA
			if (ByteMeth.endsWith(topElmt, Constant.thA))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "thA");
				s.pop();
				s.push(new Entry(Constant.thA, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.thA.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.th(s);
				return true;
			}
			// tharu
			if (ByteMeth.endsWith(topElmt, Constant.tharu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "tharu");
				s.pop();
				s.push(new Entry(Constant.tharu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.tharu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.th(s);
				return true;
			}
			// sey
			if (ByteMeth.endsWith(topElmt, Constant.sey))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "sey");
				s.pop();
				s.push(new Entry(Constant.sey, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.sey.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.s(s);
				return true;
			}
			// koL
			if (ByteMeth.endsWith(topElmt, Constant.koL))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "koL");
				s.pop();
				s.push(new Entry(Constant.koL, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.koL.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.k(s);
				return true;
			}
			//mod-30/12/05
			//////System.out.println ("in uLL");
			// uLL
						if (ByteMeth.endsWith(topElmt, Constant.uLL))
						{
							//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "uLL");
							s.pop();
							s.push(new Entry(Constant.uLL, Tag.AuxiliaryVerb));
							topElmt = ByteMeth.subArray(topElmt, 0,
							  topElmt.length - Constant.uLL.length);
							if (ByteMeth.endsWith(topElmt, Constant.iy))
							     topElmt = ByteMeth.subArray(topElmt, 0,
							          topElmt.length - Constant.y.length);
							s.push(new Entry(topElmt, -1, oldTopElmt));
							Sandhi.check(s);
							return true;
			}
			//end
			// kotu
			if (ByteMeth.endsWith(topElmt, Constant.kotu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kotu");
				s.pop();
				s.push(new Entry(Constant.kotu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.kotu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.k(s);
				return true;
			}
			// kUtu
			if (ByteMeth.endsWith(topElmt, Constant.kUtu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kUtu");
				s.pop();
				s.push(new Entry(Constant.kUtu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.kUtu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.k(s);
				return true;
			}
			// kuvi
			if (ByteMeth.endsWith(topElmt, Constant.kuvi))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kuvi");
				s.pop();
				s.push(new Entry(Constant.kuvi, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.kuvi.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.k(s);
				return true;
			}
			// kita
			if (ByteMeth.endsWith(topElmt, Constant.kita))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kita");
				s.pop();
				s.push(new Entry(Constant.kita, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.kita.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.k(s);
				return true;
			}

			//kizi

			if (ByteMeth.endsWith(topElmt, Constant.kizi))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kizi");
				s.pop();
				s.push(new Entry(Constant.kizi, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.kizi.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.k(s);
				return true;
			}
			// kAnpi
			if (ByteMeth.endsWith(topElmt, Constant.kAnpi))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kAnpi");
				s.pop();
				s.push(new Entry(Constant.kAnpi, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.kAnpi.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.k(s);
				return true;
			}
			// kAttu
			if (ByteMeth.endsWith(topElmt, Constant.kAttu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kAttu");
				s.pop();
				s.push(new Entry(Constant.kAttu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.kAttu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.k(s);
				return true;
			}
			// kattu
			if (ByteMeth.endsWith(topElmt, Constant.kattu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kattu");
				s.pop();
				s.push(new Entry(Constant.kattu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.kattu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.k(s);
				return true;
			}
			// Ongku
			if (ByteMeth.endsWith(topElmt, Constant.Ongku))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Ongku");
				s.pop();
				s.push(new Entry(Constant.Ongku, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.Ongku.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.type2(s);
				Sandhi.type4(s);
				return true;
			}
			// ozi
			if (ByteMeth.endsWith(topElmt, Constant.ozi))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ozi");
				s.pop();
				s.push(new Entry(Constant.ozi, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.ozi.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.type2(s);
				Sandhi.type4(s);
				return true;
			}
			// eri
			if (ByteMeth.endsWith(topElmt, Constant.eri))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "eri");
				s.pop();
				s.push(new Entry(Constant.eri, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.eri.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.type2(s);
				Sandhi.type4(s);
				return true;
			}
			// ezu
			if (ByteMeth.endsWith(topElmt, Constant.ezu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ezu");
				s.pop();
				s.push(new Entry(Constant.ezu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.ezu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.type2(s);
				Sandhi.type4(s);
				return true;
			}
			// etu
			if (ByteMeth.endsWith(topElmt, Constant.etu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "etu");
				s.pop();
				s.push(new Entry(Constant.etu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.etu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.type2(s);
				Sandhi.type4(s);
				return true;
			}
			// itu
			if (ByteMeth.endsWith(topElmt, Constant.itu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "itu");
				s.pop();
				s.push(new Entry(Constant.itu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.itu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.type2(s);
				Sandhi.type4(s);
				return true;
			}
			// Aku
			if (ByteMeth.endsWith(topElmt, Constant.Aku))

			{
				//////System.out.println("here Aku");
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Aku");
				s.pop();
				s.push(new Entry(Constant.Aku, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.Aku.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.type2(s);
				Sandhi.type4(s);
				return true;
			}
			// Akku
			if (ByteMeth.endsWith(topElmt, Constant.Akku))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Akku");
				s.pop();
				s.push(new Entry(Constant.Akku, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.Akku.length);
				if(ByteMeth.endsWith(topElmt, Constant.y))
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.y.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.type2(s);
				Sandhi.type4(s);
				return true;
			}
			// aruL
			if (ByteMeth.endsWith(topElmt, Constant.aruL))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "aruL");
				s.pop();
				s.push(new Entry(Constant.aruL, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.aruL.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.type2(s);
				Sandhi.type4(s);
				return true;
			}
			// ati
			if (ByteMeth.endsWith(topElmt, Constant.ati)
			  && !ByteMeth.isEqual(topElmt, Constant.pati))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ati");
				s.pop();
				s.push(new Entry(Constant.ati, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.ati.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.type2(s);
				Sandhi.type4(s);
				return true;
			}
			// mudi
			if (ByteMeth.endsWith(topElmt, Constant.mudi)
			  && !ByteMeth.isEqual(topElmt, Constant.pati))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "mudi");
				s.pop();
				s.push(new Entry(Constant.mudi, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.mudi.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				return true;
			}
			// thaLLu
			if (ByteMeth.endsWith(topElmt, Constant.thaLLu)
			  && !ByteMeth.isEqual(topElmt, Constant.pati))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "thaLLu");
				s.pop();
				s.push(new Entry(Constant.thaLLu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.thaLLu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.th(s);
				return true;
			}
			// sA
			if (ByteMeth.endsWith(topElmt, Constant.sA)
			  && !ByteMeth.isEqual(topElmt, Constant.pati))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "sA");
				s.pop();
				s.push(new Entry(Constant.sA, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.sA.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.s(s);
				return true;
			}
		}
		else
		   return false;
		return true;
	}

	public static boolean infinitive_VP(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Aux Verb - VP and Infinitive");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (BooleanMethod.hasAux(topElmt))
		{
			// vai
			if (ByteMeth.endsWith(topElmt, Constant.vai)&& !ByteMeth.endsWith(topElmt, Constant.pEravai))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "vai");
				s.pop();
				s.push(new Entry(Constant.vai, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.vai.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				return true;
			}
			// Avitu
						if (ByteMeth.endsWith(topElmt, Constant.Avitu))
						{
							//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Avitu");
							s.pop();
							s.push(new Entry(Constant.Avitu, Tag.AuxiliaryVerb));
							topElmt = ByteMeth.subArray(topElmt, 0,
							  topElmt.length - Constant.Avitu.length);
							s.push(new Entry(topElmt, -1, oldTopElmt));
							Sandhi.type2(s);
				            Sandhi.type4(s);
							return true;
			}
			// vitu
			if (ByteMeth.endsWith(topElmt, Constant.vitu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "vitu");
				s.pop();
				s.push(new Entry(Constant.vitu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.vitu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				return true;
			}
			// vA
			if (ByteMeth.endsWith(topElmt, Constant.vA))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "vA");
				s.pop();
				s.push(new Entry(Constant.vA, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.vA.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				return true;
			}
			// paNNu
			if (ByteMeth.endsWith(topElmt, Constant.paNNu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "paNNu");
				s.pop();
				s.push(new Entry(Constant.paNNu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.paNNu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.p(s);
				return true;
			}
			// pOtu
			if (ByteMeth.endsWith(topElmt, Constant.pOtu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "pOtu");
				s.pop();
				s.push(new Entry(Constant.pOtu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.pOtu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.p(s);
				return true;
			}
			// pO
			if (ByteMeth.endsWith(topElmt, Constant.pO))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "pO");
				s.pop();
				s.push(new Entry(Constant.pO, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.pO.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.p(s);
				return true;
			}
			// pEsu
			if (ByteMeth.endsWith(topElmt, Constant.pEsu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "pEsu");
				s.pop();
				s.push(new Entry(Constant.pEsu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.pEsu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.p(s);
				return true;
			}
			// peRu
			if (ByteMeth.endsWith(topElmt, Constant.peRu))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "peRu");
				s.pop();
				s.push(new Entry(Constant.peRu, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.peRu.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.p(s);
				return true;
			}
			// piti
			if (ByteMeth.endsWith(topElmt, Constant.piti))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "piti");
				s.pop();
				s.push(new Entry(Constant.piti, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.piti.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.p(s);
				return true;
			}
			// pAr
			if (ByteMeth.endsWith(topElmt, Constant.pAr))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "pAr");
				s.pop();
				s.push(new Entry(Constant.pAr, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.pAr.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.p(s);
				return true;
			}
			// nEr
			if (ByteMeth.endsWith(topElmt, Constant.nEr))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "nEr");
				s.pop();
				s.push(new Entry(Constant.nEr, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.nEr.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				return true;
			}
			// koNdiru
			if (ByteMeth.endsWith(topElmt, Constant.koNdiru))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "koNdiru");
				s.pop();
				s.push(new Entry(Constant.koNdiru, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.koNdiru.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				Sandhi.k(s);
				return true;
			}
			//  iru
			if (ByteMeth.endsWith(topElmt, Constant.iru))
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "iru");
				s.pop();
				s.push(new Entry(Constant.iru, Tag.AuxiliaryVerb));
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - Constant.iru.length);
				s.push(new Entry(topElmt, -1, oldTopElmt));
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x+"after iru" );
				Sandhi.type2(s);
				Sandhi.type4(s);
				return true;
			}
	else
			{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x+"sorry" );
			}
		}
		return false;
	}

	// not necessary. use check1
	public static boolean check(Stack s)
	{

		/*
		 no backtracking mechanism now.
		 and chked aux for all these types separately
		 so all these things r not needed now
		 */

		/*
		 if(VerbMisc.finiteVerb(s))
		 {
		 if(check1(s))
		 return true;
		 }

		 if(VerbMisc.adverbial_Particle(s))
		 {
		 if(check1(s))
		 return true;
		 }
		 if(Infinity.infinitive_Ends(s))
		 {
		 if(Infinity.check(s))
		 if(check1(s))
		 return true;
		 }
		 if(RelativeParticiple.check_Atha(s))
		 {
		 if(Infinity.check(s))
		 {
		 if(check1(s))
		 return true;
		 }
		 }
		 if(RelativeParticiple.check_a(s))
		 {
		 if(Tense.check(s))
		 {
		 if(check1(s))
		 return true;
		 }
		 }*/

		hasAux = false;
		if (check1(s))
		{
			return true;
		}
		return false;
	}

	// doubt - max 4 aux. so stop in middle?
	public static boolean check1(Stack s)
		{
	       if(!ADictionary.verb(s))
	        {
	      	     if (AuxiliaryVerb.infinitive_VP(s))
	      	     {
					   if(ADictionary.verb(s))
				         {
					     return true;
			             }
				         else if (VerbalParticiple.check(s))
				         {
					     hasAux = true;
					     check1(s);
					     return true;
				         }
				         else if (Infinity.check(s))
	                     {
					     hasAux = true;
					     check1(s);
					     return true;
				         }
			     }
	         	if (AuxiliaryVerb.verbalParticiple(s))
			     {
				  if (VerbalParticiple.check(s))
				      {
					   hasAux = true;
					   check1(s);
					   return true;
				       }
			     }
			   if (AuxiliaryVerb.infinitive(s))
			    {
				 if (Infinity.check(s))
				  {
					hasAux = true;
					check1(s);
					return true;
				   }
			     }
		}
			if (hasAux)
			{

				return true;
			}
			return false;

  }
}
