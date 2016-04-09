package org.apache.nutch.analysis.unl.ta;

//import org.apache.nutch.unl.utils.*;
import java.util.*;


public class Method
{
	static String x = "";
	static String y = "";
	static UnicodeConverter TC;
	static ADictionary dictionary;
	static Stack originalStack;
	static Stack originalStack1;

	public static int analyse(String inputString, Stack allStk, boolean analysePart)
	{
		try
		{
			//System.println("inside mehtod class Word: " + inputString);
			// not necessary now
			int c = 0;
			boolean checkNum;
			boolean isNoun;
	                boolean isRoot;
        	        boolean isVerb;
			boolean isTourism;
			boolean isTamil=true;
			boolean isNumber=false;
			// new. not completed.
			/* eg:
			 100: < Noun>
			 10-Þô¢: <Unknown>
			 */
			for (int i = 0; i < inputString.length(); i++)
			{
				int j = inputString.charAt(i);
			
				if((j>57) && (j<=127))
				{
					isTamil = false;
					return 0;
				} 
			}
		
			
				byte topElmt[]=UnicodeConverter.convert(inputString);
				

				checkNum=NounMisc.checkNumber(allStk, inputString);
				if (checkNum)
				{	
					//System.out.println("NounMisc Check Number True");
					return c;
				}
				////////System.println("CHECK NUm is.."+checkNum);
				
				/*if(ADictionary.doubleNoun(allStk, topElmt)){
					//////System.println("Double word True");
					return c;
				}*/
				
				// root word

				  int stkSize=allStk.size();
				  isRoot = ADictionary.check(allStk, topElmt);
		    		  if(isRoot)
				  {
				    	return c;
				  }
				
				  c = 17;
				
				isTourism=ADictionary.tourismDomain(allStk, topElmt);
				if(isTourism)
				{
					return c;
				}
				// prefix
				boolean chkPrefix=Noun.checkPrefix(allStk, topElmt, analysePart);
				if(chkPrefix)
				{
					//return c;
				}
				//////System.println("chkPrefix is :"+chkPrefix);
			
			
				// noun analysis
				isNoun = Noun.check(allStk, topElmt, analysePart);
				//System.println("isNoun "+isNoun);
				if (isNoun)
				{
				
				 return c;
				}
			
				////////System.println("NOUNstack size is.."+allStk.size());
			
				// verb analysis
				isVerb = Verb.check(allStk, topElmt, analysePart);
		   		//System.println("isVerb"+isVerb);		
				// mARRu
				if (isVerb)
				{
					return c;
				}
						
				if(!(isNoun||isVerb))
				{
					////////System.println("enter into DW");
					////////System.println("allStk"+allStk.size());
					if(Doubleword.check(allStk, topElmt, analysePart)){
					//System.println("Double word True");
					return c;
					}
				}
			
            return 0;
		} catch (Exception ex)
		{
			String xxx = "";

			////////System.println(xxx + "Error while analysing input string: " + inputString);
			ex.printStackTrace();
			return 0;
		}

	}
}
