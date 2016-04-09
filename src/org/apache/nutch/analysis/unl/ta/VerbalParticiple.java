package org.apache.nutch.analysis.unl.ta;
//import org.apache.nutch.unl.utils.*;
import java.util.*;


public class VerbalParticiple
{
	static String x = "";

	public static boolean check(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "VP");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

	/*	// i
		if (ByteMeth.endsWith(topElmt, Constant.i))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "i");
			s.pop();
			s.push(new Entry(Constant.i, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.i.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}*/

		// n_thu
		if (ByteMeth.endsWith(topElmt, Constant.n_thu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "n_thu");
			s.pop();
			s.push(new Entry(Constant.u, Tag.VerbalParticipleSuffix));
			s.push(new Entry(Constant.n_th, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.n_thu.length);
			if (ByteMeth.contains(topElmt, Constant.va)
			  || ByteMeth.contains(topElmt, Constant.tha)
			  || ByteMeth.contains(topElmt, Constant.se))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.A, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// ththu
		if (ByteMeth.endsWith(topElmt, Constant.ththu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "ththu");
			s.pop();
			s.push(new Entry(Constant.u, Tag.VerbalParticipleSuffix));
			s.push(new Entry(Constant.thth, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.ththu.length);
			if (ByteMeth.contains(topElmt, Constant.va)
			  || ByteMeth.contains(topElmt, Constant.tha)
			  || ByteMeth.contains(topElmt, Constant.se))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.A, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// thu
		if (ByteMeth.endsWith(topElmt, Constant.thu)
		  && !ByteMeth.endsWith(topElmt, Constant.athu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "thu");
			s.pop();
			s.push(new Entry(Constant.u, Tag.VerbalParticipleSuffix));
			s.push(new Entry(Constant.th, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.thu.length);
			if (ByteMeth.contains(topElmt, Constant.va)
			  || ByteMeth.contains(topElmt, Constant.tha)
			  || ByteMeth.contains(topElmt, Constant.se))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.A, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// tu

		if (ByteMeth.endsWith(topElmt, Constant.tu)
			&&!ByteMeth.endsWith(topElmt, Constant.patu)
			&&(!ByteMeth.endsWith(topElmt, Constant.pattu)
			    ||ByteMeth.isEqual(topElmt, Constant.Itupattu)
			  )
		   )
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "tu");
			s.pop();
			s.push(new Entry(Constant.u, Tag.VerbalParticipleSuffix));
			s.push(new Entry(Constant.t, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.tu.length);
			if (ByteMeth.contains(topElmt, Constant.kaN))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.AN, 2);
			} else if (ByteMeth.endsWith(topElmt, Constant.N)
			  && !ByteMeth.isEqual(topElmt, Constant.uN)
			  && !ByteMeth.isEqual(topElmt, Constant.pUN))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
			} else if (ByteMeth.isEqual(topElmt, Constant.kEt))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
			} else if (ByteMeth.endsWith(topElmt, Constant.t))
			{
				topElmt = ByteMeth.addArray(topElmt, Constant.u);
			}

			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// Ru
		if (ByteMeth.endsWith(topElmt, Constant.Ru)
		&& !ByteMeth.endsWith(topElmt, Constant.kkinRu)
		&& !ByteMeth.endsWith(topElmt, Constant.kinRu)
		&& !ByteMeth.endsWith(topElmt, Constant.kkiRu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Ru");
			s.pop();
			s.push(new Entry(Constant.u, Tag.VerbalParticipleSuffix));
			s.push(new Entry(Constant.R, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.Ru.length);
			if (ByteMeth.isEqual(topElmt, Constant.kaR)
			  || ByteMeth.isEqual(topElmt, Constant.viR))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
			}
			if (ByteMeth.endsWith(topElmt, Constant.R))
			{
				topElmt = ByteMeth.addArray(topElmt, Constant.u);
			}

			// senRaan, enRaan,iinRaan - pbm
			if (ByteMeth.contains(topElmt, Constant.en)
			  && !ByteMeth.contains(topElmt, Constant.sen)
			  && !ByteMeth.contains(topElmt, Constant.ven)
			  && !ByteMeth.contains(topElmt, Constant.men))
			{
				s.push(new Entry(topElmt, -1, oldTopElmt));
				return true;
			}

			if (ByteMeth.endsWith(topElmt, Constant.n)
			  && !ByteMeth.isEqual(topElmt, Constant.thin)
			  && !ByteMeth.isEqual(topElmt, Constant.iin))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
			}

			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// y
		if (ByteMeth.endsWith(topElmt, Constant.y))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "y");
			s.pop();
			s.push(new Entry(Constant.y, Tag.VerbalParticipleSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.y.length);
			// doubt
			if (ByteMeth.endsWith(topElmt, Constant.i))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.u, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		return false;
	}
}
