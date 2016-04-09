package org.apache.nutch.analysis.unl.ta;
//import org.apache.nutch.unl.utils.*;
import java.util.Stack;


public class Tense
{
	static ByteMeth ByteMeth;
	static String x = "";
	public static boolean check(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Tense");

		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		//System.out.println("Inside Tense"+UnicodeConverter.revert(topElmt));
		if(ADictionary.verb(s))
		{
			////System.out.println("verb True");
			return true;
		}
	/*	if (ADictionary.noun(s))
					{
					//allStk.push(s);
					return true;
					}*/
		// present
		// 15-kkinRu
		////System.out.println("Tense 1");
		if (ByteMeth.endsWith(topElmt, Constant.kkinR))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kkinRu");
			s.pop();
			s.push(new Entry(Constant.kkinRu, Tag.PresentTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.kkinR.length);
			if (ByteMeth.isEqual(topElmt, Constant.kEt))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
			} else if (ByteMeth.endsWith(topElmt, Constant.R))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		////System.out.println("Tense 2");
		if (ByteMeth.endsWith(topElmt, Constant.kkinRu))
				{
							//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kkinRu");
							s.pop();
							s.push(new Entry(Constant.kkinRu, Tag.PresentTenseMarker));
							topElmt = ByteMeth.subArray(topElmt, 0,
							  topElmt.length - Constant.kkinRu.length);
							if (ByteMeth.isEqual(topElmt, Constant.kEt))
							{
								topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
							} else if (ByteMeth.endsWith(topElmt, Constant.R))
							{
								topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
							}
							s.push(new Entry(topElmt, -1, oldTopElmt));
							return true;
		}
		// 14-kkiR
		////System.out.println("Tense 3");
				if (ByteMeth.endsWith(topElmt, Constant.kkiR))
				{
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kkiRu");
					s.pop();
					s.push(new Entry(Constant.kkiRu, Tag.PresentTenseMarker));
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.kkiR.length);
					if (ByteMeth.isEqual(topElmt, Constant.kEt))
					{
						topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
					} else if (ByteMeth.endsWith(topElmt, Constant.R))
					{
						topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
					}
					s.push(new Entry(topElmt, -1, oldTopElmt));
					return true;
				} // kiR
				else if (ByteMeth.endsWith(topElmt, Constant.kiR))
				{
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kiRu");
					s.pop();
					s.push(new Entry(Constant.kiRu, Tag.PresentTenseMarker));
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.kiR.length);
					if (ByteMeth.isEqual(topElmt, Constant.kEt))
					{
						topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
					} else if (ByteMeth.endsWith(topElmt, Constant.R))
					{
						topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
					} else if (ByteMeth.contains(topElmt, Constant.varu)
					  || ByteMeth.contains(topElmt, Constant.tharu))
					{
						topElmt = ByteMeth.replace(topElmt, Constant.A, 3);
					}
					s.push(new Entry(topElmt, -1, oldTopElmt));
					return true;
				}
				//kkiRu
			////System.out.println("Tense 4");
						if (ByteMeth.endsWith(topElmt, Constant.kkiRu))
						{
							////System.out.println("kkiRu");
							//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kkiRu");
							s.pop();
							s.push(new Entry(Constant.kkiRu, Tag.PresentTenseMarker));
							topElmt = ByteMeth.subArray(topElmt, 0,
							  topElmt.length - Constant.kkiRu.length);
							if (ByteMeth.isEqual(topElmt, Constant.kEt))
							{
								topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
							} else if (ByteMeth.endsWith(topElmt, Constant.R))
							{
								topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
							}
							s.push(new Entry(topElmt, -1, oldTopElmt));
							return true;
						}
						// kiRu
						else if (ByteMeth.endsWith(topElmt, Constant.kiRu))
						{
							////System.out.println("kiRu");
							//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kiRu");
							s.pop();
							s.push(new Entry(Constant.kiRu, Tag.PresentTenseMarker));
							topElmt = ByteMeth.subArray(topElmt, 0,
							  topElmt.length - Constant.kiRu.length);
							if (ByteMeth.isEqual(topElmt, Constant.kEt))
							{
								topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
							} else if (ByteMeth.endsWith(topElmt, Constant.R))
							{
								topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
							} else if (ByteMeth.contains(topElmt, Constant.varu)
							  || ByteMeth.contains(topElmt, Constant.tharu))
							{
								topElmt = ByteMeth.replace(topElmt, Constant.A, 3);
							}
							s.push(new Entry(topElmt, -1, oldTopElmt));
							return true;
				}

		// 15-kinRu
		else if (ByteMeth.endsWith(topElmt, Constant.kinR))
		{
			////System.out.println("kinRu");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kinRu");
			s.pop();
			s.push(new Entry(Constant.kinRu, Tag.PresentTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.kinR.length);
			if (ByteMeth.isEqual(topElmt, Constant.kEt))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
			} else if (ByteMeth.endsWith(topElmt, Constant.R))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
			} else if (ByteMeth.contains(topElmt, Constant.varu)
			  || ByteMeth.contains(topElmt, Constant.tharu))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.A, 3);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		else if (ByteMeth.endsWith(topElmt, Constant.kinRu))
				{
							//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kinRu");
							s.pop();
							s.push(new Entry(Constant.kinRu, Tag.PresentTenseMarker));
							topElmt = ByteMeth.subArray(topElmt, 0,
							  topElmt.length - Constant.kinRu.length);
							if (ByteMeth.isEqual(topElmt, Constant.kEt))
							{
								topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
							} else if (ByteMeth.endsWith(topElmt, Constant.R))
							{
								topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
							} else if (ByteMeth.contains(topElmt, Constant.varu)
							  || ByteMeth.contains(topElmt, Constant.tharu))
							{
								topElmt = ByteMeth.replace(topElmt, Constant.A, 3);
							}
							s.push(new Entry(topElmt, -1, oldTopElmt));
							return true;
				}

		// past
		// 1-in
		else if (ByteMeth.endsWith(topElmt, Constant.in))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "in");
				////System.out.println("in");
			s.pop();
			s.push(new Entry(Constant.in, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.in.length);
			if (ByteMeth.endsWith(topElmt, Constant.k)
			  || ByteMeth.endsWith(topElmt, Constant.s)
			  || ByteMeth.endsWith(topElmt, Constant.t)
			  || ByteMeth.endsWith(topElmt, Constant.th)
			  || ByteMeth.endsWith(topElmt, Constant.p)
			  || ByteMeth.endsWith(topElmt, Constant.R)
			  || ByteMeth.endsWith(topElmt, Constant.v))
			{
				topElmt = ByteMeth.addArray(topElmt, Constant.u);
			}

			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} // n_th
		else if (ByteMeth.endsWith(topElmt, Constant.n_th))
		{
			////System.out.println("n_th");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "n_th");
			s.pop();
			s.push(new Entry(Constant.n_th, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.n_th.length);
			if (ByteMeth.contains(topElmt, Constant.va)
			  || ByteMeth.contains(topElmt, Constant.tha)
			  || ByteMeth.contains(topElmt, Constant.se))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.A, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} // thth
		else if (ByteMeth.endsWith(topElmt, Constant.thth))
		{
			////System.out.println("thth");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "thth");
			s.pop();
			s.push(new Entry(Constant.thth, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.thth.length);
			if (ByteMeth.contains(topElmt, Constant.va)
			  || ByteMeth.contains(topElmt, Constant.tha)
			  || ByteMeth.contains(topElmt, Constant.se))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.A, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		// th
		else if (ByteMeth.endsWith(topElmt, Constant.th)&&!ByteMeth.endsWith(topElmt, Constant.Ath))
				{
					////System.out.println("th");
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "th");
					s.pop();
					s.push(new Entry(Constant.th, Tag.PastTenseMarker));
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.th.length);
					if (ByteMeth.contains(topElmt, Constant.va)
					  || ByteMeth.contains(topElmt, Constant.tha)
					  || ByteMeth.contains(topElmt, Constant.se))
					{
						topElmt = ByteMeth.replace(topElmt, Constant.A, 1);
					}
					s.push(new Entry(topElmt, -1, oldTopElmt));
					return true;
		}
		//Ath

		else if (ByteMeth.endsWith(topElmt, Constant.Ath))
				{
						////System.out.println("Ath");
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Ath");
					s.pop();
					s.push(new Entry(Constant.Ath, Tag.FutureNegativeSuffix));
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.Ath.length);
					if (ByteMeth.contains(topElmt, Constant.va)
					  || ByteMeth.contains(topElmt, Constant.tha)
					  || ByteMeth.contains(topElmt, Constant.se))
					{
						topElmt = ByteMeth.replace(topElmt, Constant.A, 1);
					}
					topElmt = ByteMeth.addArray(topElmt, Constant.u);
					s.push(new Entry(topElmt, -1, oldTopElmt));
					if(!ADictionary.verb(s))
					{
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - 1);
					s.pop();
					s.push(new Entry(topElmt, -1, oldTopElmt));
				    }
					return true;
		}



		 // 8-n
		else if (ByteMeth.endsWith(topElmt, Constant.n))
		{
			////System.out.println("n");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "n");
			s.pop();
			s.push(new Entry(Constant.n, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.n.length);
			if (ByteMeth.endsWith(topElmt, Constant.n)
			  && !ByteMeth.isEqual(topElmt, Constant.thin))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} // 9-t
		else if (ByteMeth.endsWith(topElmt, Constant.t)
		  && !ByteMeth.endsWith(topElmt, Constant.mAtt))
		{
			////System.out.println("t");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "t");
			s.pop();
			s.push(new Entry(Constant.t, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.t.length);

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
		} // 10-R
		else if (ByteMeth.endsWith(topElmt, Constant.R))
		{
			////System.out.println("R");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "R");
			s.pop();
			s.push(new Entry(Constant.R, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.R.length);
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
		// 3-i
				else if (ByteMeth.endsWith(topElmt, Constant.i))
				{
					////System.out.println("i");
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "i");
					s.pop();
					//s.push(new Entry(Constant.y, Tag.Sandhi));
					s.push(new Entry(Constant.i, Tag.PastTenseMarker));
					topElmt = ByteMeth.replace(topElmt, Constant.u, Constant.i.length);
					s.push(new Entry(topElmt, -1, oldTopElmt));
					return true;
		} // future


		// 3-i
		else if (ByteMeth.endsWith(topElmt, Constant.iy))
		{
			////System.out.println("i2");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "i");
			s.pop();
			s.push(new Entry(Constant.y, Tag.Sandhi));
			s.push(new Entry(Constant.i, Tag.PastTenseMarker));
			topElmt = ByteMeth.replace(topElmt, Constant.u, Constant.iy.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} // future
		// 17-v
		else if (ByteMeth.endsWith(topElmt, Constant.v))
		{
			////System.out.println("v");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "v");
			s.pop();
			s.push(new Entry(Constant.v, Tag.FutureTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.v.length);
			if (ByteMeth.isEqual(topElmt, Constant.kEt))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
			} else if (ByteMeth.contains(topElmt, Constant.varu)
			  || ByteMeth.contains(topElmt, Constant.tharu))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.A, 3);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} // 18-pp
		else if (ByteMeth.endsWith(topElmt, Constant.vu))
				{
					////System.out.println("vu1");
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "v");
					s.pop();
					s.push(new Entry(Constant.v, Tag.FutureTenseMarker));
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.vu.length);
					if (ByteMeth.isEqual(topElmt, Constant.kEt))
					{
						topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
					} else if (ByteMeth.contains(topElmt, Constant.varu)
					  || ByteMeth.contains(topElmt, Constant.tharu))
					{
						topElmt = ByteMeth.replace(topElmt, Constant.A, 3);
					}
					s.push(new Entry(topElmt, -1, oldTopElmt));
					return true;
		} // 18-pp
		else if (ByteMeth.endsWith(topElmt, Constant.pp))
		{
			////System.out.println("pp");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "pp");
			s.pop();
			s.push(new Entry(Constant.pp, Tag.FutureTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.pp.length);
			if (ByteMeth.isEqual(topElmt, Constant.kEt))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
			} else if (ByteMeth.endsWith(topElmt, Constant.R))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} // 18-p
		else if (ByteMeth.endsWith(topElmt, Constant.p))
		{
			////System.out.println("p");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "p");
			s.pop();
			s.push(new Entry(Constant.p, Tag.FutureTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.p.length);
			if (ByteMeth.isEqual(topElmt, Constant.kEt))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.L, 1);
			} else if (ByteMeth.endsWith(topElmt, Constant.R))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		return false;
	}

	public static boolean human(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Tense human");

		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		// 1-in
		if (ByteMeth.endsWith(topElmt, Constant.in))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "in");

			s.pop();
			s.push(new Entry(Constant.in, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.in.length);
			if (ByteMeth.endsWith(topElmt, Constant.k)
			  || ByteMeth.endsWith(topElmt, Constant.s)
			  || ByteMeth.endsWith(topElmt, Constant.t)
			  || ByteMeth.endsWith(topElmt, Constant.th)
			  || ByteMeth.endsWith(topElmt, Constant.p)
			  || ByteMeth.endsWith(topElmt, Constant.R)
			  || ByteMeth.endsWith(topElmt, Constant.v))
			{
				topElmt = ByteMeth.addArray(topElmt, Constant.u);
			}

			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} // n_th
		else if (ByteMeth.endsWith(topElmt, Constant.n_th))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "n_th");
			s.pop();
			s.push(new Entry(Constant.n_th, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.n_th.length);
			if (ByteMeth.contains(topElmt, Constant.va)
			  || ByteMeth.contains(topElmt, Constant.tha)
			  || ByteMeth.contains(topElmt, Constant.se))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.A, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} // thth
		else if (ByteMeth.endsWith(topElmt, Constant.thth))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "thth");
			s.pop();
			s.push(new Entry(Constant.thth, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.thth.length);
			if (ByteMeth.contains(topElmt, Constant.va)
			  || ByteMeth.contains(topElmt, Constant.tha)
			  || ByteMeth.contains(topElmt, Constant.se))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.A, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} // th
		else if (ByteMeth.endsWith(topElmt, Constant.th))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "th");
			s.pop();
			s.push(new Entry(Constant.th, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.th.length);
			if (ByteMeth.contains(topElmt, Constant.va)
			  || ByteMeth.contains(topElmt, Constant.tha)
			  || ByteMeth.contains(topElmt, Constant.se))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.A, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} // 8-n
		else if (ByteMeth.endsWith(topElmt, Constant.n))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "n");
			s.pop();
			s.push(new Entry(Constant.n, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.n.length);
			if (ByteMeth.endsWith(topElmt, Constant.n)
			  && !ByteMeth.isEqual(topElmt, Constant.thin))
			{
				topElmt = ByteMeth.replace(topElmt, Constant.l, 1);
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		} // 9-t
		else if (ByteMeth.endsWith(topElmt, Constant.t)
		  && !ByteMeth.endsWith(topElmt, Constant.mAtt))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "t");
			s.pop();
			s.push(new Entry(Constant.t, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.t.length);

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
		} // 10-R
		else if (ByteMeth.endsWith(topElmt, Constant.R))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "R");
			s.pop();
			s.push(new Entry(Constant.R, Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.R.length);
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

		return false;
	}
}

/*
 future pbm:
 endsWith and isEqual while going for Aux.
 eg:
 seithukoNtAL:endsWith
 koNtAL:isEqual
 */
