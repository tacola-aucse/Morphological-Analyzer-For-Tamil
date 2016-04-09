package org.apache.nutch.analysis.unl.ta;
//import org.apache.nutch.unl.utils.*;
import java.util.*;


/*
 FLOW
 //1a - ISM - tA, ti
 //1b - ISM - utA, uti
 //1c - IPM1 - unkaL
 //1d - IPM2 - nkaL
 //2 - Clitic rule not designed preperly/fully - will not work now
 //3.0b - PNG
 //3.0a - aux
 //3 - Finite Verb - aux
 //5 - umpati
 //6 - Infinitive + endings
 //7 - Past Tense + Cond. Al
 //8 - RP - Atha
 //9 - RP - a (adv par only to a?)
 //10 - RP+Pronominal
 //11 - Infinitive
 //12 - VP
 */
public class Verb
{
	static String x = "";
	static Stack originalStack;
	static Stack originalStack1;
	static UnicodeConverter TC;
	static boolean gotoVerbExp = false;

	public static boolean check(Stack allStk,byte [] topElmt, boolean analysePart)
	{
		//System.out..println("Verb  -- check");
		boolean nopng = true;
		 int flag = 0;
		 Stack s = new Stack();
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "New VERB ANALYSER");
      		while(flag <2)
        	{
			while (!s.empty())
			{
						s.pop();
			}
		//System.out..println("flag is.."+flag);
		//System.out..println("stack size is.."+s.size());
		s.push(new Entry(topElmt, -1));
		Sandhi.kctp(s);
      	 	// 1a - ISM - tA, ti
		originalStack = (Stack) s.clone();
		
		if (RelativeParticiple.check_uLLa(s))
		{
			//System.out..println("1");
		    		if (Tense.check(s))
				{
		    			if (ADictionary.verb(s))
					{
							allStk.push(s);
							return true;
					}
				}
				if (AuxiliaryVerb.check(s))
				{
					
		        		  if (ADictionary.verb(s))
				    	{
							allStk.push(s);
							return true;
					}
					  if (ADictionary.noun(s))
					{
							 allStk.push(s);
							 return true;
					}
				 }
			//System.out..println(" Relative paritciple check_ulla is  ture in verb.java");
		}
		
	     	if (RelativeParticiple.check_thakka(s))
		{
			//System.out..println("2");
		    		if (Tense.check(s))
				{
					if (ADictionary.verb(s))
					{
						allStk.push(s);
						return true;
					}
				}
				if (AuxiliaryVerb.check(s))
				{
		  			if (ADictionary.verb(s))
				  	{
				  		allStk.push(s);
				  		return true;
				  	}
				  	 if (ADictionary.noun(s))
				  	{
				  		 allStk.push(s);
				  		 return true;
				  	}
				   }
	       }
		
		 if (Postposition.check(s))
	 	{
			
	 		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "PP check");
	 	}
		
			
			if (VerbMisc.imperativeSingular1(s))
			{
			//System.out..println("3");
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				} else
				{
					Misc.backTrack(originalStack, s);
				}
			}
		
		
		// 1b - ISM - utA, uti
		originalStack = (Stack) s.clone();
		
		if (VerbMisc.imperativeSingular2(s))
		{
			//System.out..println("4");
			if (ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			} else
			{
				Misc.backTrack(originalStack, s);
			}
		}
		
		// 1c - IPM1 - unkaL
		originalStack = (Stack) s.clone();

		if (VerbMisc.imperativePlural1(s))
		{
			//System.out..println("5");
			
			if(ADictionary.noun(s))
			{
			  allStk.push(s);
			  return true;
			}
			else if (ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
			else
			{
				Misc.backTrack(originalStack, s);
			}
		}
		
	/*	if(ADictionary.Nverb(s))
            {
		//	//System.out..println("NVERB   check\n");
   		    allStk.push(s);
   		    return true;
	        }*/
		// 1d - IPM2 - nkaL
		
		originalStack = (Stack) s.clone();
		if (VerbMisc.imperativePlural2(s))
		{
			//System.out..println("6");
			if(ADictionary.noun(s))
			{
			  allStk.push(s);
			  return true;
			}
			else if (ADictionary.verb(s))
			{
			  allStk.push(s);
			  return true;
			}
			else
			{
			  Misc.backTrack(originalStack, s);
			}
		}
		
 		if(flag ==0)
		{

		 //rule not designed preperly/fully
		 //2 - Clitic
			 if(Clitic.verb(s))
			 {
				//System.out..println("7");
				 ////System.out..println("flag ===0");
				 if(ADictionary.verb(s))
		 		{
		 			allStk.push(s);
		 			return true;
		 		}
		 	}
		}
		
		if(flag ==1)
		{
			
		    //rule not designed preperly/fully
				 //2 - Clitic
				 if(Clitic.verb1(s))
				 {
					//System.out..println("8");
				               if(ADictionary.verb(s))
				               {
				                allStk.push(s);
				                return true;
				               }
			          }
		 }//System.out..println(" Auxilary verb check ture in verb.java");


		//updates 3-1-06
		
	       if (Postposition.check(s))
	 	{
			//System.out..println("9");
	 		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "PP check");
	 	}
	
		//System.out..println("stack size " +s.size());
	 	if (VCase.check(s, true))
	 	{
			//System.out..println("9A");
	 		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Case check");
	 		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "check forTense");
			//System.out..println("Vcase  True"+s.size());
				if (Tense.check(s))
				{
					//System.out..println("Tense Ture 9A");
					gotoVerbExp = true;
					//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af png tense");
					if (ADictionary.verb(s))
					{
						allStk.push(s);
						return true;
					}
					
		          	}
			
	 	}
		//System.out..println("10");
	 	if (ADictionary.verb(s))
		{
					allStk.push(s);
					return true;
		}
		
		//System.out..println("11");
	 	if (SingPluralMarker.check(s))
	 	{
					if(ADictionary.noun(s))
					   {
						     allStk.push(s);
						     return true;
				              }
	 				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "SPM check");
	 	 }
		   // eupdate 3-1-06



		//System.out..println("12");
	    // 3.0a - PNG
		originalStack = (Stack) s.clone();
		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "b4 png");
		if (PNG.check(s))
		{
			nopng = false;
			//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af png a");
			if (ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
			if (Sandhi.verbException(s))
			{
				//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af png - verbExcep");
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
			//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "check forTense");
			if (Tense.check(s))
			{
				gotoVerbExp = true;
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
			//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "before noun");
			if (AuxiliaryVerb.check(s))
			{
				if(ADictionary.m_EndNoun(s))
				{
					     allStk.push(s);
					     return true;
			        }
				  if (ADictionary.verb(s))
				{
	 					allStk.push(s);
	  					return true;
		                }
				//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "check noun");
				  if (ADictionary.noun(s))
				{
						allStk.push(s);
						return true;
		                }

				//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af png aux");

			}
			else if (Infinity.mAtt(s))
			{
				if (Infinity.check(s))
				{
						if (ADictionary.verb(s))
						{
							allStk.push(s);
							return true;
						}

				}
				if (AuxiliaryVerb.check(s))
				{
					if (ADictionary.noun(s))
					 {
						 allStk.push(s);
						 return true;
				         }
					if (ADictionary.verb(s))
					{
						allStk.push(s);
						return true;
					}
				}
			}

			if (ADictionary.noun(s))
			{
				allStk.push(s);
				return true;
			}
			if (ADictionary.verb(s))
				{
				allStk.push(s);
				return true;
				}

	}
		//System.out..println("14");
		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af png");
		//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "gotoVerbExp: " + gotoVerbExp);
	/*	if(gotoVerbExp)
		Misc.backTrack(originalStack, s);
		*/

		// 3.0b - aux
		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "b4 aux");
		  if(nopng)
		      {
					//System.out..println("15");
							if (AuxiliaryVerb.check(s))
							{
								//System.out..println("Auxilary verb true");
									if (Tense.check(s))
					                  {
								//System.out..println("Tense true");
										if (ADictionary.verb(s))
											{
								
													allStk.push(s);
													return true;
											}
									  }
									else if (ADictionary.verb(s))
									  		{
								//System.out..println("Tense false");
								
									  	    	allStk.push(s);
									  			return true;
											}
							}
						//System.out..println("everything is false");

		        }
					//System.out..println("16");
		   if (ADictionary.verb(s))
						{
						allStk.push(s);
						return true;
						}
			//System.out..println("17");
			if (Tense.check(s))
			       {
					   	if (AuxiliaryVerb.check(s))
		                  {
						  }
							if (ADictionary.verb(s))
								{
										allStk.push(s);
										return true;
								}
			     }

		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af aux");
		// 3 - Finite Verb - aux
				//System.out..println("18");
		if (VerbMisc.finiteVerb(s))
		{
			originalStack = (Stack) s.clone();

			if (Infinity.check(s))
			{
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
			if (AuxiliaryVerb.check(s))
			{
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
			Misc.backTrack(originalStack, s);
		}
		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af fv");
				//System.out..println("19");
		// 5 - umpati
		if (VerbMisc.umpadi(s))
		{
			if (ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
			if (AuxiliaryVerb.check(s))
			{
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}
		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af umpadi");
				//System.out..println("20");
		// 6 - Infinitive + endings
		if (Infinity.infinitive_Ends(s))
		{
			if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			if (Infinity.check(s))
			{
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
			if (AuxiliaryVerb.check(s))
			{
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}
		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af inf ends");
				//System.out..println("21");
		// 7 - Past Tense + Cond. Al
		if (VerbMisc.pastTM_Al(s))
		{
			if (ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
			if (AuxiliaryVerb.check(s))
			{
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}
		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af ptm+Al");
				//System.out..println("22");
		// 8 - RP - Atha
		if (RelativeParticiple.check_Atha(s))
		{
			if (Infinity.check(s))
			{
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
			if (AuxiliaryVerb.check(s))
			{
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}
		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af rp - Atha");

		// 9 - RP - uLLa (adv par only to a?)
				//System.out..println("23");
         			 if (RelativeParticiple.check_uLLa(s))
					{
									if (Tense.check(s))
									{
										if (ADictionary.verb(s))
										{
											allStk.push(s);
											return true;
										}
									}
									if (AuxiliaryVerb.check(s))
									{
									  if (ADictionary.verb(s))
									    		{
														allStk.push(s);
														return true;
												}
			                            }
			          }
		// 9 - RP - a (adv par only to a?)
				//System.out..println("24");
		if (RelativeParticiple.check_a(s))
		{

			if (Tense.check(s))
			{
				//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "temp ...............check");
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
			if (ADictionary.verb(s))
							{
								allStk.push(s);
								return true;
				            }
			if (AuxiliaryVerb.check(s))
			{
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}
		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af rp - a");

// "al"
		//System.out..println("25");
		if (RelativeParticiple.check_al(s))
		{

			if (Tense.check(s))
			{
				//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "temp ...............check");
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
			if (ADictionary.verb(s))
							{
								allStk.push(s);
								return true;
				            }
			if (AuxiliaryVerb.check(s))
			{
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}


		//System.out..println("26");
		// 10 - RP+Pronominal
		if (VerbMisc.pronominal(s))
		{
			//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af pronominal a");
			// last
			if (RelativeParticiple.check_Atha(s))
			{
				//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af pronominal b");
				if (Infinity.check(s))
				{
					//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af pronominal c");
					if (ADictionary.verb(s))
					{
						//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s,  "af pronominal d");
						allStk.push(s);
						return true;
					}
				}
			}
			//System.out..println("27");
			if (RelativeParticiple.check_a(s))
			{
				if (Tense.check(s))
				{
					if (ADictionary.verb(s))
					{
						allStk.push(s);
						return true;
					}
				}
			}
		}
		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af pronominal");
			//System.out..println("28");
		// 11 - Infinitive
		if (Infinity.check(s))
		{
			if (ADictionary.verb(s))
			{
				//System.out..println("Only checking verb in ADictionary True");
				allStk.push(s);
				return true;
			}
			if (AuxiliaryVerb.check(s))
			{
					//System.out..println("Only checking verb in Auxilliary verb True");
				if (ADictionary.verb(s))
				{
					//System.out..println("Verb check");
					allStk.push(s);
					return true;
				}

			}
			if(ADictionary.noun(s))
				{
				 allStk.push(s);
				 return true;
				}
		}
		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af inf");
		//System.out..println("29");
		// 12 - VP
		if(ADictionary.noun(s))
			{
			allStk.push(s);
			return true;
			}
		//System.out..println("30");
		/*	if(ADictionary.Nverb(s))
            		{
		//	//System.out..println("NVERB   check\n");
   		  	  allStk.push(s);
   		    return true;	
	      		}*/
		//System.out..println("30A");
		if (VerbalParticiple.check(s))
		{
			//System.out..println("verbal participle true");
			
			if (ADictionary.verb(s))
			{
				//System.out..println("Adictionary verb true");
				allStk.push(s);
				
				return true;
				
			}
			if (AuxiliaryVerb.check(s))
			{
				//System.out..println("Auxiliaryverb true");
				if (ADictionary.verb(s))
				{
					//System.out..println("Adictionary verb true");
					allStk.push(s);
					return true;
				}
			}
			//System.out..println("verbal participle false");
			
		}
		//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af vp");
		//System.out..println("31");
		if (Sandhi.verbException(s))
		{
			//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "af sandhi verbExcep");
			if (ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
		}
				//System.out..println("32");
		if (analysePart)
		{
			allStk.push(s);
		}
		flag++;
	}
	//System.out..println("33");
	  if (ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
	  else if (ADictionary.m_EndNoun(s))
			{
				allStk.push(s);
				return true;
			}
	//System.out..println("34");
	    if (Tense.check(s))
			{
			//clia.unl.unicode.utils.Utils.printStack(Analyser.print, s, "temp ...............check");
				if (ADictionary.verb(s))
				  {
				   allStk.push(s);
				   return true;
				  }
			}
		//System.out..println("35");
			if(ADictionary.noun(s))
			{
		 		allStk.push(s);
		    		return true;
			}
		//System.out..println("36");
		if (Infinity.check(s))
		{
			if (ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
			if (AuxiliaryVerb.check(s))
			{
				if (ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}

			}
			if(ADictionary.noun(s))
				{
				 allStk.push(s);
				 return true;
				}
		}
		//System.out..println("37");
   		if(ADictionary.Nverb(s))
           	 {
		//	//System.out..println("NVERB   check\n");
   		    allStk.push(s);
   		    return true;
	       }
		
	/*	if(ADictionary.Verbalnoun(s,allStk))
           	 {
		//	//System.out..println("NVERB   check\n");
   		    allStk.push(s);
   		    return true;
	        }*/
	   //System.out..println("verbcase false");	
	   return false;
	}

}
