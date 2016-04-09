package org.apache.nutch.analysis.unl.ta;
//import org.apache.nutch.unl.utils.*;
import java.util.Stack;

public class PNG
{
	static ByteMeth ByteMeth;
	static String x = "";

	public static boolean check(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "PNG");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.An)) // 1
		{
			////System.out.println("PNG 1");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "An");
			s.pop();
			s.push(
			  new Entry(Constant.An, Tag.ThirdPersonMasculineSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.An.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.AL)) // 2
		{
			////System.out.println("PNG 2");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "AL");
			s.pop();
			s.push(new Entry(Constant.AL, Tag.ThirdPersonFemimeSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.AL.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.Ar)) // 3
		{
			////System.out.println("PNG 3");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Ar");
			s.pop();
			s.push(new Entry(Constant.Ar, Tag.PronominalThirdPersonSingular));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.Ar.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.ArkaL)) // 4
		{
			////System.out.println("PNG 4");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ArkaL");
			s.pop();
			s.push(new Entry(Constant.ArkaL, Tag.ThirdPersonPluralSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.ArkaL.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.athu)
		  && !ByteMeth.endsWith(topElmt, Constant.Athathu)
		  && !ByteMeth.endsWith(topElmt, Constant.uLLathu)
		  && !ByteMeth.endsWith(topElmt, Constant.thakkathu)) // 5
		{
			////System.out.println("PNG 5");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "athu");
			s.pop();
			s.push(new Entry(Constant.athu, Tag.NeuterSingulerORPronominal));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.athu.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.athan)) // 5
		{
			////System.out.println("PNG 6");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "athan");
			s.pop();
			s.push(new Entry(Constant.an, Tag.Euphonic));
			s.push(new Entry(Constant.athu, Tag.NeuterSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.athan.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.ana)&&
		            !ByteMeth.endsWith(topElmt, Constant.uLLana)) // 6
		{
			////System.out.println("PNG 7");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ana");
			s.pop();
			s.push(new Entry(Constant.ana, Tag.NeuterPluralSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.ana.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.IrkaL)
		  && !ByteMeth.endsWith(topElmt, Constant.AthIrkaL)) // 7
		{
			////System.out.println("PNG 8");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "IrkaL");
			s.pop();
			s.push(new Entry(Constant.IrkaL, Tag.SecondPersonPluralSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.IrkaL.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.Ir)) // 8
		{
			////System.out.println("PNG 9");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Ir");
			s.pop();
			s.push(new Entry(Constant.Ir, Tag.SecondPersonSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.Ir.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.Ay)) // 9
		{
			////System.out.println("PNG 10");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Ay");
			s.pop();
			s.push(new Entry(Constant.Ay, Tag.SecondPersonSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.Ay.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.Om)) // 10
		{
			////System.out.println("PNG 11");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Om");
			s.pop();
			s.push(new Entry(Constant.Om, Tag.FirstPersonPluralSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.Om.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.En)) // 11
		{
			////System.out.println("PNG 12");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "En");
			s.pop();
			s.push(new Entry(Constant.En, Tag.FirstPersonSingularSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.En.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.anar)) // 12
		{
			////System.out.println("PNG 13");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "anar");
			s.pop();
			s.push(new Entry(Constant.anar, Tag.ThirdPersonPluralSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.anar.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.ar)
		  && !ByteMeth.endsWith(topElmt, Constant.avar)) // 13
		{
			////System.out.println("PNG 14");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ar");
			s.pop();
			s.push(new Entry(Constant.ar, Tag.ThirdPersonPluralSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.ar.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.Or)) // 14
		{
			////System.out.println("PNG 15");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Or");
			s.pop();
			s.push(new Entry(Constant.Or, Tag.ThirdPersonPluralSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.Or.length));
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.um)
		  && !ByteMeth.endsWith(topElmt, Constant.ttum)
		  && !ByteMeth.endsWith(topElmt, Constant.kUdum)
		  && !ByteMeth.endsWith(topElmt, Constant.vENdum)) // 15
		{
			////System.out.println("PNG 16");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "um");
			s.pop();
			s.push(new Entry(Constant.um, Tag.ThirdFutureNeuterSingularORRP));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.um.length));
			if (ByteMeth.isEqual(topElmt, Constant.kEtk))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.L, 2);
			}
			if (ByteMeth.contains(topElmt, Constant.var)
			  || ByteMeth.contains(topElmt, Constant.thar))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.A, 2);
			}
			if (ByteMeth.isEqual(topElmt, Constant.kaRk)
			  || ByteMeth.isEqual(topElmt, Constant.viRk)
			  || ByteMeth.isEqual(topElmt, Constant.n_iRk))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.l, 2);
			}
			if (ByteMeth.isEqual(topElmt, Constant.sAk)
			  || ByteMeth.contains(topElmt, Constant.pOk))
			{
				topElmt = ByteMeth.subArray(topElmt, 0, topElmt.length - 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type4(s);
			Sandhi.type5(s);
			Sandhi.kk(s);
			return true;
		} else if (ByteMeth.endsWith(topElmt, Constant.iRRu)) // 15
		{
			////System.out.println("PNG 17");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "iRRu");
			s.pop();
			s.push(new Entry(Constant.iRRu, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  (topElmt.length - Constant.iRRu.length));
			if (ByteMeth.isEqual(topElmt, Constant.kEtk))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.L, 2);
			}
			if (ByteMeth.isEqual(topElmt, Constant.var)
			  || ByteMeth.isEqual(topElmt, Constant.thar))
			{
				topElmt = ByteMeth.addArray(topElmt, Constant.u);
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
			Sandhi.type4(s);
			Sandhi.type5(s);
			Sandhi.kk(s);
			return true;
		}
		
		return false;
	}

}
