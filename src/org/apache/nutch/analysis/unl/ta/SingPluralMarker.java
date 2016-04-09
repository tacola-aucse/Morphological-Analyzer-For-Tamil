package org.apache.nutch.analysis.unl.ta;

//import org.apache.nutch.unl.utils.*;
import java.util.Stack;



// Plural and Singular MArker
public class SingPluralMarker
{
	static ByteMeth ByteMeth;
	static String x = "";

	// maramKaL - correct output?
	static boolean check(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "SingPluralMarker");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// 1
		if (!ByteMeth.endsWith(topElmt, Constant.nAyanmArkaL)
		  && !ByteMeth.isEqual(topElmt, Constant.mArkaL)
		  && !ByteMeth.endsWith(topElmt, Constant.sumArkaL)
		  && ByteMeth.endsWith(topElmt, Constant.mArkaL))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "mArkaL");
			s.pop();
			s.push(new Entry(Constant.mArkaL, Tag.PluralSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.mArkaL.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// 2
		if (ByteMeth.endsWith(topElmt, Constant.mAr))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "mAr");
			s.pop();
			s.push(new Entry(Constant.mAr, Tag.SingularPluralSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.mAr.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// 3
		if (ByteMeth.endsWith(topElmt, Constant.kkaL))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kkaL");
			s.pop();
			s.push(new Entry(Constant.kkaL, Tag.PluralSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.kkaL.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		if (ByteMeth.endsWith(topElmt, Constant.kaL))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kaL");
			s.pop();
			s.push(new Entry(Constant.kaL, Tag.PluralSuffix));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.kaL.length);
			// ng to m
			if (ByteMeth.endsWith(topElmt, Constant.ng))
			{
				topElmt = ByteMeth.addArray(
				  ByteMeth.subArray(topElmt, 0, topElmt.length - 1), Constant.m);
			} // t to L
			else if (ByteMeth.endsWith(topElmt, Constant.t))
			{
				topElmt = ByteMeth.addArray(
				  ByteMeth.subArray(topElmt, 0, topElmt.length - 1), Constant.L);
			} // R to l
			else if (ByteMeth.endsWith(topElmt, Constant.R))
			{
				topElmt = ByteMeth.addArray(
				  ByteMeth.subArray(topElmt, 0, topElmt.length - 1), Constant.l);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		////System.out.println("singular marker flase");
		return false;
	}
}
