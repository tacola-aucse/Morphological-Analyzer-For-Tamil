package org.apache.nutch.analysis.unl.ta;
//import org.apache.nutch.unl.utils.*;
import java.util.Stack;



public class Sandhi
{
	static ByteMeth ByteMeth;
	static String x = "";

	// later
	static String kctp_exception(Stack s)
	{
		return null;
	}

	static byte[] remove_kctp(byte[] topElmt)
	{
		if (ByteMeth.endsWith(topElmt, Constant.k)
		  || ByteMeth.endsWith(topElmt, Constant.s)
		  || ByteMeth.endsWith(topElmt, Constant.th)
		  || ByteMeth.endsWith(topElmt, Constant.p))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "remove_kctp");
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.k.length);
			return topElmt;
		}
		return null;
	}
	static byte[] remove_kctp1(byte[] topElmt)
	{
		if (ByteMeth.endsWith(topElmt, Constant.k)
		  || ByteMeth.endsWith(topElmt, Constant.s)
		  || ByteMeth.endsWith(topElmt, Constant.th)
		  || ByteMeth.endsWith(topElmt, Constant.p))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "remove_kctp");
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.k.length);
			return topElmt;
		}
		return topElmt;
	}
	static void euphonic(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.isEqual(topElmt, Constant.athan)
		  || ByteMeth.isEqual(topElmt, Constant.ithan)
		  || ByteMeth.isEqual(topElmt, Constant.ethan))
		{
			euphonic_an(s);
		} else
		{
			euphonic_in(s);
		}
	}

	static void euphonic_in(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.in))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Euphonic in");
			s.pop();
			s.push(new Entry(Constant.in, Tag.Euphonic));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.in.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return;
		}
	}

	static void euphonic_an(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.an))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Euphonic an");
			s.pop();
			s.push(new Entry(Constant.an, Tag.Euphonic));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.an.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return;
		}
	}

	public static boolean verbException(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Sandhi verbException");


		int size = s.size();

		if (size < 2)
		{
			return false;
		}

		byte[] entry1Part = ((Entry) s.get(size - 1)).getPart();
		byte[] entry2Part = ((Entry) s.get(size - 2)).getPart();
		int entry2Tag = ((Entry) s.get(size - 2)).getTag();

		// azum
		if (ByteMeth.endsWith(entry1Part, Constant.z))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Exp:z - zu");
			s.pop();
			s.push(new Entry(ByteMeth.addArray(entry1Part, Constant.u), -1));
			return true;
		} // viLakkum
		else if (ByteMeth.endsWith(entry1Part, Constant.kku))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Exp:kk is Sandhi");
			s.pop();
			entry1Part = ByteMeth.subArray(entry1Part, 0,
			  entry1Part.length - Constant.kku.length);
			s.push(new Entry(Constant.kk, Tag.Sandhi));
			s.push(new Entry(entry1Part, -1));
			return true;
		}
	/*	// veelaiseythaan
		if (entry2Tag == Tag.AuxiliaryVerb)
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Exp:aux - !aux");
			s.pop();
			s.pop();
			s.push(new Entry(ByteMeth.addArray(entry1Part, entry2Part), -1));
			return true;
		} */
		return false;
	}

	public static boolean handleException(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Sandhi Exception");

		int size = s.size();

		if (size < 2)
		{
			return false;
		}

		byte[] entry1Part = ((Entry) s.get(size - 1)).getPart();
		byte[] entry2Part = ((Entry) s.get(size - 2)).getPart();
		int entry2Tag = ((Entry) s.get(size - 2)).getTag();

		// maavaa
		if (ByteMeth.isEqual(entry2Part, Constant.v)
		  && (entry2Tag == Tag.Sandhi))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Exp:v - vu");
			s.pop();
			s.pop();
			s.push(new Entry(ByteMeth.addArray(entry1Part, Constant.vu), -1));
			return true;
		}

		// thaayai
		if (ByteMeth.isEqual(entry2Part, Constant.y)
		  && (entry2Tag == Tag.Sandhi))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Exp:y(sandhi) yes - no");
			s.pop();
			s.pop();
			s.push(new Entry(ByteMeth.addArray(entry1Part, Constant.y), -1));
			return true;
		}

		// maththai
	/*	if (ByteMeth.isEqual(entry2Part, Constant.aththu)
		  && (entry2Tag == Tag.Oblique))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Exp:m+aththu - ththu");
			s.pop();
			s.pop();
			entry1Part = ByteMeth.subArray(entry1Part, 0,
			  entry1Part.length - Constant.m.length);
			s.push(new Entry(ByteMeth.addArray(entry1Part, Constant.ththu), -1));
			return true;
		}*/
		// n-aattai
		if (ByteMeth.endsWith(entry1Part, Constant.ttu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Exp:ttu - tu");
			s.pop();
			entry1Part = ByteMeth.replace(entry1Part, Constant.tu, 3);
			s.push(new Entry(entry1Part, -1));
			return true;
		}
		// aaRRai
		if (ByteMeth.endsWith(entry1Part, Constant.RRu))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Exp:RRu - Ru");
			s.pop();
			entry1Part = ByteMeth.replace(entry1Part, Constant.Ru, 3);
			s.push(new Entry(entry1Part, -1));
			return true;
		}
		return false;
	}

	static void clitic(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (BooleanMethod.isPronoun(topElmt))
		{
			return;
		}
		if (type2_clitic(s))
		{
			return;
		}
		if (type4(s))
		{
			return;
		}
		if (type5(s))
		{
			return;
		}
	}

	static void postposition(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.isEqual(topElmt, Constant.athan)
		  || ByteMeth.isEqual(topElmt, Constant.ithan)
		  || ByteMeth.isEqual(topElmt, Constant.ethan))
		{
			euphonic_an(s);
		} else
		{
			euphonic_in(s);
		}
		if (type1(s))
		{
			////System.out.println("sandhi Tyep1");
			return;
		}
		if (type2(s))
		{
			////System.out.println("sandhi Tyep2");
			return;
		}
		if (type3(s))
		{
			////System.out.println("sandhi Tyep3");
			return;
		}
		if (type4(s))
		{
			////System.out.println("sandhi Tyep4");
			return;
		}
		if (type5(s))
		{
			////System.out.println("sandhi Tyep5");
			return;
		}
	}

	static void check(Stack s)
	{
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Sandhi");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		////System.out.println("INSIDE SNADHI.. hi"+UnicodeConverter.revert(topElmt));
		if (ByteMeth.isEqual(topElmt, Constant.athan)
		  || ByteMeth.isEqual(topElmt, Constant.ithan)
		  || ByteMeth.isEqual(topElmt, Constant.ethan))
		{
			euphonic_an(s);
		} else
		{
			euphonic_in(s);
		}
		if(ADictionary.noun(s))
		{
			////System.out.println("Natri true");
			return;
		}
		if (type1(s))
		{
			////System.out.println("sandhi Tyep1");
			return;
		}
		if (type2(s))
		{
			////System.out.println("sandhi Tyep2");
			return;
		}
		if (type3(s))
		{
			////System.out.println("sandhi Tyep3");
			return;
		}
		if (type5(s))
		{
			////System.out.println("sandhi Tyep5");
			return;
		}
		if (type4(s))
		{
			////System.out.println("sandhi Tyep4");
			return;
		}
	}

	static boolean type1(Stack s)
	{
		// 1 - aRRu
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.vaRR))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "type 1");
			s.pop();
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.vaRR.length);
			////System.out.println("inside aRRU");
			s.push(new Entry(Constant.aRRu, Tag.Oblique));
			if (ByteMeth.isEqual(topElmt, Constant.ellA))
			{
				
				topElmt = ByteMeth.addArray(topElmt, Constant.m);
				s.push(new Entry(topElmt, Tag.Noun));
				return true;
			}
			s.push(new Entry(topElmt, -1, oldTopElmt));
		}
		return false;
	}

	static boolean type2(Stack s)
	{
		// 2 - v,y sandhi
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (topElmt.length >= 2)
		{
			if (ByteMeth.endsWith(topElmt, Constant.y))
			{
				if (topElmt[topElmt.length - 2] == Constant.i[0]
				  || topElmt[topElmt.length - 2] == Constant.I[0]
				  || topElmt[topElmt.length - 2] == Constant.ai[0]
				  || topElmt[topElmt.length - 2] == Constant.E[0])
				{
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "type 2a");
					s.pop();
					s.push(new Entry(Constant.y, Tag.Sandhi));
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.y.length);
					s.push(new Entry(topElmt, -1, oldTopElmt));
					
					return true;
				}
			} else if (ByteMeth.endsWith(topElmt, Constant.v))
			{
				////System.out.println("வ்");
				if (topElmt[topElmt.length - 2] == Constant.a[0]
				  || topElmt[topElmt.length - 2] == Constant.A[0]
				  || topElmt[topElmt.length - 2] == Constant.u[0]
				  || topElmt[topElmt.length - 2] == Constant.U[0]
				  || topElmt[topElmt.length - 2] == Constant.O[0]
				  || topElmt[topElmt.length - 2] == Constant.au[0])
				{
					////System.out.println("வ்1");
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "type 2b");
					s.pop();
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.v.length);
					s.push(new Entry(Constant.v, Tag.Sandhi));
					s.push(new Entry(topElmt, -1, oldTopElmt));
					////System.out.println("elseType 2 True ");
					return true;
				}
			}
		}
		return false;
	}

	// no difference from type2
	static boolean type2_clitic(Stack s)
	{
		// 2 - v,y sandhi
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (topElmt.length >= 2)
		{
			if (ByteMeth.endsWith(topElmt, Constant.y))
			{
				if (topElmt[topElmt.length - 2] == Constant.i[0]
				  || topElmt[topElmt.length - 2] == Constant.I[0]
				  || topElmt[topElmt.length - 2] == Constant.E[0]
				  || topElmt[topElmt.length - 2] == Constant.ai[0])
				{
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "type 2a");
					s.pop();
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.y.length);
					s.push(new Entry(Constant.y, Tag.Sandhi));
					s.push(new Entry(topElmt, -1, oldTopElmt));
					return true;
				}
			} else if (ByteMeth.endsWith(topElmt, Constant.v))
			{
				if (topElmt[topElmt.length - 2] == Constant.a[0]
				  || topElmt[topElmt.length - 2] == Constant.A[0]
				  || topElmt[topElmt.length - 2] == Constant.u[0]
				  || topElmt[topElmt.length - 2] == Constant.U[0]
				  || topElmt[topElmt.length - 2] == Constant.O[0]
				  || topElmt[topElmt.length - 2] == Constant.au[0])
				{
					//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "type 2b");
					s.pop();
					topElmt = ByteMeth.subArray(topElmt, 0,
					  topElmt.length - Constant.v.length);
					s.push(new Entry(Constant.v, Tag.Sandhi));
					s.push(new Entry(topElmt, -1, oldTopElmt));
					return true;
				}
			}
		}
		return false;
	}

	static boolean type3(Stack s)
	{
		// 3 - aththu
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.athth))
		{
			if(
				!(ByteMeth.endsWith(topElmt, Constant.pathth)||
				  ByteMeth.endsWith(topElmt, Constant.uvarathth)
				 )
			   )

				{
			     //clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "type 3");
			     // ////System.out.println("type 3 enter=========================");
			      s.pop();
			      topElmt = ByteMeth.subArray(topElmt, 0,
			      topElmt.length - Constant.thth.length);
			      topElmt = ByteMeth.addArray(topElmt, Constant.m);
			      s.push(new Entry(Constant.aththu, Tag.Oblique));
			      s.push(new Entry(topElmt, -1, oldTopElmt));
			      return true;
		         }
		     else
		         {
				  s.pop();
				  topElmt = ByteMeth.addArray(topElmt, Constant.u);
				  s.push(new Entry(topElmt, -1, oldTopElmt));
				  return true;
				 }
		}
		return false;
	}

	static boolean type4(Stack s)
	{
		// 4 - add u
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		////System.out.println("sandhi:"+UnicodeConverter.revert(topElmt));
		if (BooleanMethod.endsWith_type4_letter(topElmt))
		{
		if(!ByteMeth.endsWith(topElmt, Constant.ERk))
			{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "type 4");
			s.pop();
			topElmt = ByteMeth.addArray(topElmt, Constant.u);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			
		    }
		    else
		    {
	    	  s.pop();
			  topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.Rk.length);
			  topElmt = ByteMeth.addArray(topElmt, Constant.L);
			  s.push(new Entry(topElmt, -1, oldTopElmt));
			////System.out.println("else Type 4 True ");
		    }
			////System.out.println("else Type 4 True ");
			return true;
		}
		////System.out.println("if Type 4 false ");
		return false;
	}

	static boolean type5(Stack s)
		{
			// 5 - doubling
			int flag = 0;
			byte[] topElmt = ((Entry) s.peek()).getPart();
			byte[] oldTopElmt = topElmt;
			//////System.out.println("TOPELMT --"+topElmt);
			if(topElmt.length >=2 )
			{
				if(topElmt[topElmt.length-1]==24 && topElmt[topElmt.length-2]==3)
				{	
										
					topElmt[topElmt.length-2] =24;
					flag =1;
	     	        	}
			}
			byte[] sandhi = BooleanMethod.endswith_doubling_Letter(topElmt);

	        if(flag==1)
	        	topElmt[topElmt.length-2] =3;
			if (sandhi != null)
			{
				if(!ByteMeth.endsWith(topElmt, Constant.nn))
				{
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "type 5");
				s.pop();
				topElmt = ByteMeth.subArray(topElmt, 0,
				  topElmt.length - sandhi.length);
				s.push(new Entry(sandhi, Tag.Sandhi));
				s.push(new Entry(topElmt, -1, oldTopElmt));
				return true;
			    }
			}
			return false;
		}


	// remove later
	static boolean type6(Stack s)
	{
		// 6 - t - oblique
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.tt))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "type 6");
			s.pop();
			s.push(new Entry(Constant.t, Tag.Oblique));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.t.length);
			topElmt = ByteMeth.addArray(topElmt, Constant.u);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			return true;
		}
		return false;
	}

	// doubt
	static void kk(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.kk))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "kk");
			s.pop();
			s.push(new Entry(Constant.kk, Tag.Sandhi));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.kk.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
		}
		if (ByteMeth.endsWith(topElmt, Constant.k))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "k");
			s.pop();
			s.push(new Entry(Constant.k, Tag.Sandhi));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.k.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
		}
	}

	static void kctp(Stack s)
	{
	//	////System.out.println("INSIDE SANDHI KCTP");
		
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		////System.out.println("INSIDE SANDHI KCTP");
		if (!ByteMeth.endsWith(topElmt, Constant.Rk)
		  && !ByteMeth.endsWith(topElmt, Constant.ss)
		  && !ByteMeth.endsWith(topElmt, Constant.thth)
		  && !ByteMeth.endsWith(topElmt, Constant.pp)
		  && (ByteMeth.endsWith(topElmt, Constant.k)
		    || ByteMeth.endsWith(topElmt, Constant.s)
		    || ByteMeth.endsWith(topElmt, Constant.th)
		    || ByteMeth.endsWith(topElmt, Constant.p)))
		{
			//////System.out.println("INSIDE topelmt:"+topElmt.toString());
			//////System.out.println("topelmt.length:"+topElmt.length);
		//	////System.out.println("CONSTANT.length"+Constant.k.length+""+Constant.k);
			////System.out.println("hello its me");
			s.pop();
			s.push(
			  new Entry(new byte[] { topElmt[topElmt.length - 1]}, Tag.Sandhi));
			topElmt = ByteMeth.subArray(topElmt, 0,topElmt.length - Constant.k.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			////System.out.println("Santhi is True ...");
		}
		else
		{

				////System.out.println("Santhi is false");
		}
		////System.out.println("INSIDE SANDHI KCTP");
	}

	static void k(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.k)
		  && !ByteMeth.endsWith(topElmt, Constant.Rk))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "k");
			s.pop();
			s.push(new Entry(Constant.k, Tag.Sandhi));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.k.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
		}
	}

	static void s(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.s)
		  && !ByteMeth.endsWith(topElmt, Constant.ss))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "s");
			s.pop();
			s.push(new Entry(Constant.s, Tag.Sandhi));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.s.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
		}
	}

	static void th(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.th)
		  && !ByteMeth.endsWith(topElmt, Constant.thth))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "th");
			s.pop();
			s.push(new Entry(Constant.th, Tag.Sandhi));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.th.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			////System.out.println("STACK size"+s.size());
		}
	}

	static void p(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.p))
		{
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "p");
			s.pop();
			s.push(new Entry(Constant.p, Tag.Sandhi));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.p.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
		}
	}

//          added this mehtod to check whether thAn comes with th
	static boolean th(Stack s,boolean b)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if (ByteMeth.endsWith(topElmt, Constant.th)
		  && !ByteMeth.endsWith(topElmt, Constant.thth))
		{
			/*//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "th");
			s.pop();
			s.push(new Entry(Constant.th, Tag.Sandhi));
			topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.th.length);
			s.push(new Entry(topElmt, -1, oldTopElmt));
			////System.out.println("STACK size"+s.size());*/
			return true;
		}
		return false;
	}
}
