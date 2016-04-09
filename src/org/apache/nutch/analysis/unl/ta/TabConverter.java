package org.apache.nutch.analysis.unl.ta;


import java.io.*;
import java.util.*;
import java.util.StringTokenizer;



/**
 * Used to convert the TAB text in to the internal code and vise versa.
 *  @ version 5.12.2002
 * 	@ author RCILTS-Tamil,MIT.
 */
public class TabConverter
{

	/**
	 * This method does the reverse process of the method convert.
	 * @ b sequence of numbers for which the equivalent string is required.
	 */
	public static String revert(byte b[])
	{
		short tab = 0;
		short temp = 0;
		short prefix = 0;
		short suffix = 0;
		boolean puttemp = false;
		boolean tamil = false;
		boolean zero = false;
		boolean putprefix = false;
		boolean putsuffix = false;
		int i = 0;
		ArrayList al = new ArrayList();

		if (b[0] == 0)
		{
			zero = true;
			i++;
		} else
		{
			zero = false;
		}

		for (i=0; i < b.length; i++)
		{
			if (zero)
			{ // Nontamil
				tab = (short) b[i];
			} else
			{ // Tamil

				// the below two line for special sorting asked by palani
				// if(b[i]==38)
				// tab = (short) 32;
				if(b[i] == 35)
				{
						tab = (short) 3000;
						temp = (short) 3021;
						puttemp = true;
						
								
				}

				else if ((b[i] <= 13) && (b[i] >= 1))
				{
					tab = getProperTABCode(b[i]);
					
				}
				else if ((b[i] >= 14) && (b[i] <= 38) )
				{
					if (i + 1 < b.length)
					{
						switch (b[i + 1])
						{


						case 1:
							tab = getProperTABCode(b[i]);
							i++;
							break;

						case 2:
							tab = getProperTABCode(b[i]);
							temp = (short) 3006;
							puttemp = true;
							i++;
							break;

						case 3:
							{
								tab = getProperTABCode(b[i]);
								temp = (short) 3007;
								puttemp = true;
							}
							i++;
							break;

						case 4:
							{
								tab = getProperTABCode(b[i]);
								temp = (short) 3008;
								puttemp = true;
							}
							i++;
							break;

						case 5:
							if ((b[i] >= 14) && (b[i] <= 38))
							{
								tab = getProperTABCode(b[i]);
								temp = (short) 3009;
								puttemp = true;
							}
							i++;
							break;

						case 6:
							if ((b[i] >= 14) && (b[i] <= 38))
							{
								tab = getProperTABCode(b[i]);
								temp = (short) 3010;
								puttemp = true;
							}
							i++;
							break;

						case 7:
							temp = (short) 3014;
							tab = getProperTABCode(b[i]);
							puttemp = true;
							i++;
							break;

						case 8:
							temp = (short) 3015; // 34 has to be 171 .This is due to softview problem
							tab = getProperTABCode(b[i]);
							puttemp = true;
							i++;
							break;

						case 9:
							temp = (short) 3016;
							tab = getProperTABCode(b[i]);
							puttemp = true;
							i++;
							break;

						case 10:
							temp = (short) 3018;
							tab = getProperTABCode(b[i]);
							puttemp = true;
							i++;
							break;

						case 11:
							temp = (short) 3019; // 34 hat to be 171.This is due to softview 171-34 problem
							tab = getProperTABCode(b[i]);
							puttemp = true;
							i++;
							break;

						case 12:
							suffix = (short) 3014;
							tab = getProperTABCode(b[i]);
							temp = (short) 2995;
							putsuffix = true;
							puttemp = true;
							i++;
							break;

						default:
							tab = getProperTABCode(b[i]);
							temp = (short) 3021;
							puttemp = true;
							break;
						}// end of switch

					} // end inner if
					else
					{
						tab = getProperTABCode(b[i]);
						temp = (short) 3021;
						puttemp = true;
					}
				} // end else if
				else if (b[i] == 33)
				{
					//sri tab = (short) 255;
				}
			}// end of tamil

			if (putprefix)
			{
				al.add(new Character((char) prefix));
				putprefix = false;
			}
			
			al.add(new Character((char) tab));

			if (putsuffix)
			{
				al.add(new Character((char) suffix));
				putsuffix = false;
			}

			if (puttemp)
			{
				al.add(new Character((char) temp));
				puttemp = false;
			}



			if ((i + 1 < b.length) && (b[i + 1] == 0))
			{
				// ////System.out.println(" zero ");
				i++;
				if (zero)
				{
					zero = false;
					continue;
				} else
				{
					zero = true;
					continue;
				}
			}
		}// end of for

		String ret = (new String()).intern();

		for (int j = 0; j < al.size(); j++)
		{
			//////System.out.println(((Character) (al.get(j))).charValue());		
			ret = (ret + ((Character) (al.get(j))).charValue()).intern();
		}
		//////System.out.println(ret);
		return ret;
	}	 // end of revert

	/**
	 * Converts the given text to the internal code.
	 * Gets a string and checks each character. According to this it
	 * will check the next first and second characters if necessary. With
	 * this check condition appropriate one or two integers will be added
	 * in the output byte[].
	 * If a character is non-Tamil character then a zero (0) will be
	 * added stating that non Tamil is started and it puts the non-Tamil
	 * characters equivalent ASCII value.
	 * If the non-Tamil characters end by a Tamil character it will put a
	 * zero (0) stating that non-Tamil ends and then puts the correct
	 * numbers in the output bye[].
	 * Ex.     Some words and their converted out puts are given bellow.
	 * 		Üñ¢ñ£		-	1 23 23 2
	 * 		Üabcñ¢ñ£	-	1 0 97 98 99 0 23 23 2
	 * 		Apple		-	0 65 112 112 108 101
	 *
	 * @param p string to be converted.
	 */
	public static byte[] convert(String p)
	{
		byte mycode = 0;
		byte temp = 0;
		boolean puttemp = false;
		boolean tamil = false;
		boolean zero = false;
		ArrayList al = new ArrayList();

		
		if (p == null)
		{
			byte[] as = null;

			return as;
		}

		for (int i = 0; i < p.length(); i++)
		{
		int j = p.charAt(i);
		////System.out.println("Value--"+j);
		if ((p.charAt(i) <= 127) && (p.charAt(i) >= 0))
		{
			tamil = false;
		} else if (p.charAt(i) >= 128)
		{
			tamil = true;
		}
			if ((!tamil) && (!zero))
			{
				al.add(new Byte((byte) 0));
				zero = true;
			} else if ((tamil) && (zero))
			{
				al.add(new Byte((byte) 0));
				zero = false;
			}

			if (!tamil)
			{
				mycode = (byte) p.charAt(i);
				al.add(new Byte(mycode));
				continue;
			} else if (tamil)
			{ 
			if(p.charAt(i)==32)
			{
				mycode=32;
			}
			else if((p.charAt(i) >=2947) && (p.charAt(i) <=2964))
			{
				
				if(p.charAt(i) == 2949)
				{
					mycode=1;
				}
				if(p.charAt(i) == 2950)
				{
					mycode=2;
				}
				if(p.charAt(i) == 2951)
				{
					mycode=3;
				}
				if(p.charAt(i) == 2952)
				{
					mycode=4;
				}
				if(p.charAt(i) == 2953)
				{
					mycode=5;
				}
				if(p.charAt(i) == 2954)
				{
					mycode=6;
				}
				if(p.charAt(i) == 2958)
				{
					mycode=7;
				}
				if(p.charAt(i) == 2959)
				{
					mycode=8;
				}
				if(p.charAt(i) == 2960)
				{
					mycode=9;
				}
				if(p.charAt(i) == 2962)
				{
					mycode=10;
				}
				if(p.charAt(i) == 2963)
				{
					mycode=11;
				}
				if(p.charAt(i) == 2964)
				{
					mycode=10;
					temp = 29;
					puttemp=true;
				}
				if(p.charAt(i) == 2947)
				{
					mycode=13;
				}
				
			}else if(p.charAt(i) >=2965 && p.charAt(i) <=3001)
			{
				if(p.charAt(i) == 2965)
				{
					mycode=(byte)14;
				}
				if(p.charAt(i) == 2969)
				{
					mycode=(byte)15;
				}
				if(p.charAt(i) == 2970)
				{
					mycode=(byte)16;
				}
				if(p.charAt(i) == 2972)
				{
					mycode=(byte)38;
				}
				if(p.charAt(i) == 2974)
				{
					mycode=(byte)17;
				}
				if(p.charAt(i) == 2975)
				{
					mycode=(byte)18;
				}
				if(p.charAt(i) == 2979)
				{
					mycode=(byte)19;
				}
				if(p.charAt(i) == 2980)
				{
					mycode=(byte)20;
				}
				if(p.charAt(i) == 2984)
				{
					mycode=(byte)21;
				}
				if(p.charAt(i) == 2985)
				{
					mycode=(byte)31;
				}
				if(p.charAt(i) == 2986)
				{
					mycode=(byte)22;
				}
				if(p.charAt(i) == 2990)
				{
					mycode=(byte)23;
				}
				if(p.charAt(i) == 2991)
				{
					mycode=(byte)24;
				}
				if(p.charAt(i) == 2992)
				{
					mycode=(byte)25;
				}
				if(p.charAt(i) == 2993)
				{
					mycode=(byte)30;
				}
				if(p.charAt(i) == 2994)
				{
					mycode=(byte)26;
				}
				if(p.charAt(i) == 2995)
				{
					mycode=(byte)29;
				}
				if(p.charAt(i) == 2996)
				{
					mycode=(byte)28;
				}
				if(p.charAt(i) == 2997)
				{
					mycode=(byte)27;
				}
				if(p.charAt(i) == 2999)
				{
					mycode=(byte)34;
				}
				if(p.charAt(i) == 3000)
				{
					mycode=(byte)35;
				}	
								
				if(p.charAt(i) == 3001)
				{
					mycode=(byte)36;
				}
			
				if ((p.charAt(i) >= 2965) && (p.charAt(i) <= 3001))
				{
					if (i + 1 < p.length())
					{	switch (p.charAt(i + 1))
						{
					
					
						case 3021:
							
							i++;
							break;

						case 3006:
							i++;
							temp = 2;
							puttemp = true;
							break;

						case 3007:
							i++;
							temp = 3;
							puttemp = true;
							break;

						case 3008:
							i++;
							temp = 4;
							puttemp = true;
							break;

						case 3009:
							i++;
							temp = 5;
							puttemp = true;
							break;

						case 3010:
							i++;
							temp = 6;
							puttemp = true;
							break;
						case 3018:
							temp = 10;
							puttemp = true;
							i ++;
							break;

						case	 3014:
							if (i + 2 < p.length())
							{
								if(p.charAt(i+2)==2995)
								{
									temp = 12;
									puttemp = true;
									i +=2;
								}else
								{
									temp = 7;
									puttemp = true;
									i++;
								}
										
							} 
							else
							{
								temp = 7;
								puttemp = true;
								i++;
							}
							break;
						case 3019:
								temp = 11;
								puttemp = true;
								i ++;
								break;
								
						case	 3015:
								temp = 8;
								puttemp = true;
								i++;
								break;

						
						case 3016:
								i++;
								temp = 9;
								puttemp = true;
								break;
							
						default:
							temp = 1;
							puttemp = true;
							break;
						
						} // end of switch
					}else
					{
						temp = 1;
						puttemp = true;
					}
				}
			}
		}	

			al.add(new Byte(mycode));
			if (puttemp)
			{
				al.add(new Byte(temp));
				puttemp = false;
			}
		}

		byte ret[] = new byte[al.size()];

		for (int l = 0; l < al.size(); l++)
		{

			ret[l] = ((Byte) al.get(l)).byteValue(); // (Byte)al.get(l);
			////System.out.print( ret[l] +" ");
		}
		//////System.out.println();

		
		return ret;
	}

	/**
	 *  Used to check the 'La' character(29) comes as a combination
	 *  three letters or separate letter.
	 *
	 * @ param nexttola next character of 'la' in the text.
	 * @ return boolean true if 'La' comes in three letter consonant i.e 'auv'
	 *				   false if 'La' comes in two letters consonant
	 */
	public static boolean checkLa(char nexttola)
	{
		switch (nexttola)
		{
		case 3021:
			return false;

		case 3006:
			return false;

		case 3007:
			return false;

		case 3008:
			return false;

		default:
			return true;
		}
	}

	/**
	 * Used to check whether the given word is Tamil word or non-Tamil word.
	 * It checks the first character. If this is Tamil then the word is Tamil
	 * word. Otherwise it is a non-Tamil word. Mixed words are not considered here.
	 * That is they are decided with their first character.
	 *
	 * @ param word word whose language has to be identified.
	 * @ boolean true if the word is tamil, otherwise false.
	 *
	 */
	public static boolean checkLanguage(String word)
	{
		if (word.length() == 1)
		{
			if ((word.charAt(0) <= 3021) && (word.charAt(0) >= 2947))
			{
				return true;
			} else
			{
				return false;
			}
		}
		return false;
	}

	public static short getProperTABCode(byte internalCode)
	{
		short mycode = 0;


					
				
		if ((internalCode >= 1) && (internalCode <= 31))
		{
			switch(internalCode)
			{
			case 1:
				mycode = (short)2949;
				break;
			case 2:
				mycode = (short)2950;
				break;
			case 3:
				mycode = (short)2951;
				break;
			case 4:
				mycode = (short)2952;
				break;
			case 5:
				mycode = (short)2953;
				break;
			case 6:
				mycode = (short)2954;
				break;
			case 7:
				mycode = (short)2958;
				break;
			case 8:
				mycode = (short)2959;
				break;
			case 9:
				mycode = (short)2960;
				break;
			case 10:
				mycode = (short)2962;
				break;
			case 11:
				mycode = (short)2963;
				break;
			case 12:
				mycode = (short)2964;
				break;
			case 13:
				mycode = (short)2947;
				break;
			case 14:
				mycode = (short)2965;
				break;
			case 15:
				mycode = (short)2969;
				break;

			case 16:
				mycode = (short)2970;
				break;

			case 17:
				mycode = (short)2974;
				break;

			case 18:
				mycode = (short)2975;
				break;
			case 19:
				mycode = (short)2979;
				break;
			case 20:
				mycode = (short)2980;
				break;
			case 21:
				mycode = (short)2984;
				break;
			case 22:
				mycode = (short)2986;
				break;
			case 23:
				mycode = (short)2990;
				break;
			case 24:
				mycode = (short)2991;
				break;
			case 25:
				mycode = (short)2992;
				break;
			case 26:
				mycode = (short)2994;
				break;
			case 27:
				mycode = (short)2997;
				break;
			case 28:
				mycode = (short)2996;
				break;
			case 29:
				mycode = (short)2995;
				break;
			case 30:
				mycode = (short)2993;
				break;
			case 31:
				mycode = (short)2985;
				break;
			case 38:
				mycode = (short) 2972;
				break;
			case 34:
				mycode = (short) 2999;
				break;
			case 35:
				mycode = (short) 3000;
				break;
			case 36:
				mycode = (short) 3001;
				break;
			case 37:
			//tabCode = (short) "KUSH";
				break;
		}
	    }	
		return mycode;
	}
	public static byte getProperInternalCode(char d)
	{
		//int k = (int) d;
		byte  mycode=0;
		if ((d >= 2965) && (d <= 3001))
		{
		switch (d)
		{
			case 2965:
				mycode = (byte)14;
				break;
			case 2969:
				mycode = (byte)15;
				break;

			case 2970:
				mycode = (byte)16;
				break;

			case 2974:
				mycode = (byte)17;
				break;

			case 2975:
				mycode = (byte)18;
				break;
			case 2979:
				mycode = (byte)19;
				break;
			case 2980:
				mycode = (byte)20;
				break;
			case 2984:
				mycode = (byte)21;
				break;
			case 2986:
				mycode = (byte)22;
				break;
			case 2990:
				mycode = (byte)23;
				break;
			case 2991:
				mycode = (byte)24;
				break;
			case 2992:
				mycode = (byte)25;
				break;
			case 2994:
				mycode = (byte)26;
				break;
			case 2997:
				mycode = (byte)27;
				break;
			case 2996:
				mycode = (byte)28;
				break;
			case 2995:
				mycode = (byte)29;
				break;
			case 2993:
				mycode = (byte)30;
				break;
			case 2985:
				mycode = (byte)31;
				break;
			case 3000:
				mycode = (byte)35;
				break;
			case 2999:
				mycode = (byte)34;
				break;
			case 2972:
				mycode = (byte)32;
				break;
			case 3001:
				mycode = (byte)36;
				break;
			//case "sri":
			//	mycode =(byte)33;
			//	break;
												
			}
		}		
		return mycode;
	}

	public static void main(String args[])
	{
		TabConverter tab = new TabConverter();
		byte bytep1[]=tab.convert("க்ங்ச்ஞ்ட்ண்த்ந்ப்ம்ய்ர்ல்வ்ழ்ள்ற்ன்");
		String str1 = tab.revert(bytep1);
		
		
		byte bytep[]=tab.convert("கஙசஞடணதநபமயரலவழளறன");
		String str = tab.revert(bytep);

		byte byte3[]=tab.convert("காஙாசாஞாடாணாதாநாபாமாயாராலாவாழாளாறானா");
		String str3 = tab.revert(byte3);

		byte bytep2[]=tab.convert("கிஙிசிஞிடிணிதிநிபிமியிரிலிவிழிளிறினி");
		String str2 = tab.revert(bytep2);

		byte bytep8[]=tab.convert("கீஙீசீஞீடீணீதீநீபீமீயீரீலீவீழீளீறீனீ");		
		String str8 = tab.revert(bytep8);

		byte bytep7[]=tab.convert("குஙுசுஞுடுணுதுநுபுமுயுருலுவுழுளுறுனு");
		String str7 = tab.revert(bytep7);

		byte bytep13[]=tab.convert("கூஙூசூஞூடூணூதூநூபூமூயூரூலூவூழூளூறூனூ");
		String str13 = tab.revert(bytep13);

		byte bytep4[]=tab.convert("கெஙெசெஞெடெணெதெநெபெமெயெரெலெவெழெறெனெ ளெ");
		String str4 = tab.revert(bytep4);			

		byte bytep10[]=tab.convert("கொஙொசொஞொடொணொதொநொபொமொயொரொலொவொழொளொறொனொ");
		String str10 = tab.revert(bytep10);

		byte bytep11[]=tab.convert("கெளஙெளசெளஞெளடெளணெளதெளநெளபெளமெளயெளரெளலெளவெளழெளளெளறெளனெள");
		String str11 = tab.revert(bytep11);

		byte bytep5[]=tab.convert("கோஙோசோஞோடோணோதோநோபோமோயோரோலோவோழோளோறோனோ");
		String str5 = tab.revert(bytep5);

		byte bytep9[]=tab.convert("கேஙேசேஞேடேணேதேநேபேமேயேரேலேவேழேளேறேனே");
		String str9 = tab.revert(bytep9);
		
		byte bytep6[]=tab.convert("கைஙைசைஞைடைணைதைநைபைமையைரைலைவைழைளைறைனை");
		String str6 = tab.revert(bytep6);	
	

	}

}

