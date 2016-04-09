package org.apache.nutch.analysis.unl.ta;
/**
 * This class defines some methods which are
 * specific to byte arrays
 */
public class charNum
{
	/**
	 * It checks the given byte arrays are equal or not
	 */
	public static boolean check(String s)
	{
		 char[] ch1 =new char[100];
		 int len =s.length();
		 int flag=0;
		 if(len>100)
		return false;
		 int i;
		 int[] v=new int[100];
		 s.getChars(0,len,ch1,0);
		// //////System.out.println("charNum:checking for number"+s);
		if(s.startsWith("குறைந்தபட்ச" ) || s.startsWith("அதிகபட்ச") )  //ñ¦ì¢ìó¢ è¤«ô£
             	return true;
		for(i=0;i<len;i++)
		{
			v[i]= ch1[i];
		}
		i=0;
		while(true)
		{
			if(( v[i]>=48) &&( v[i]<=57))
			{
				if ((s.endsWith("-வது"))||(s.endsWith("க்கு"))||(s.endsWith("க்கும்"))||(s.endsWith("-ஆவது"))||(s.endsWith("-ந்"))||(s.endsWith("ஆக"))||(s.endsWith("க"))||(s.endsWith("-ல்"))||(s.endsWith("-இல்")))
				{
	  				flag=1;
					break;
				}
				else if(s.endsWith("-ம்"))
				{
					flag=1;
					break;
				}
				else
      				break;
			}
			else if((v[i]== 2992) &&(v[i+1] ==3010)) //¢Ï
			{

						  	
				i=i+2;
			        if(i==len)
				{
                                  	flag=1;
					break;
				}
				else if((v[i]== 2986)&&(v[i+1]== 3006)&&(v[i+2]== 2991)&&(v[i+3]== 3021))//¢ð£y
				{
					i= i+3;
					flag=1;
					break;
				}
				else
				break;
			}//****
			else if(v[i]==2951) //Þ
			{
				i++;
		                if(v[i]==2992)  //ó
		                {
					i++;
					if((v[i]== 2979)&&(v[i+1]== 3021))    //í
					{
			                	i=i+2;
			               		if((v[i]== 2975)&&(v[i+1]== 3006)) //¢ì£
			                        {
							i+=2;
							flag=1;
							break;
						}
						else if((v[i]== 2975) &&(v[i+1]== 3009)) //´
						{
							i+=2;
							flag=1;
							break;
						}
						else
						break;
		                   	}
		                   	else
		                   	break;
				}
				else if((v[i]==2992) &&  (v[i+1]==3009))//¼
				{
					i=i+2;
					if((v[i]== 2986)&&(!(v[i+1]== 3021)))//¢ð
					{
							i+=2;
							flag=1;
							break;
					}
					else
		                        break;
				}
				else if(v[i]== 2994)//ô
				 {
					i++;
					if((v[i]== 2975)&&(v[i+1]== 3021)&&(v[i+2]== 2970))//¢ì¢ê
					{
						i=i+3;
						flag=1;
						break;
					}
					else
					break;				 }
				else
				break;

		 }//****
		else if(v[i]== 2994)//ô
		{
			 i++;
			if((v[i]== 2975)&&(v[i+1]== 3021)&&(v[i+2]== 2970))//¢ì¢ê
			{
					i=i+3;
				   	flag=1;
				   	break;
			}
			else
			break;
		 }//****
		else if(v[i]==2965 )//è
		 {		
			i++;
			if(v[i]==3019)//«£
			{
						  i++;
						  if((v[i]==2975) && (v[i+1]==3007))//¢®
					  	    {
							i+=2;
					  		flag=1;
					  		break;
		 		  		     }
		  					else
				                            break;
			}
			else
			break;
		}
		else if((v[i]==2990) && (v[i+1]==3009))//º
		{
			 i+=2;
			if((v[i]== 2986)&&(v[i+1]== 3021)&&(v[i+2]== 2986))//¢ð¢ð
			{
				i=i+3;flag=1;break;
			}
			else
			break;
		}//****
		else if(v[i]==2959)//ã
		{
			 i++;
			 if((v[i]==2996) && (v[i+1]==3009))//¿
			{
				i+=2;
				flag=1;
				break;
			}
			else if((v[i]== 2996)&&(v[i+1]== 3006)) //¢ö£
			{
				i+=2;
				flag=1;
	   			break;
			}
			else
			break;
		 }//***
		else if(v[i]==2958)//â
		{
			 i++;
			 if((v[i]==2979)&&(v[i+1]== 3021)) //¢í¢
			 {
				i+=2;
				if(v[i]== 2986) //¢ð
				{
					flag=1;
					break;
				}
				else if((v[i]== 2979) && (v[i+1] == 3009)) //È
				{
					i+=2;
					if((v[i]== 2993) && (v[i+1]==3009)) //¢Á
					{
						i+=2;
						flag=1;
						break;
					}
					else if((v[i]== 2993)&&(v[i+1]== 3021)) //¢ø¢
					{
						i+=2;
						flag=1;
						break;
					}
					else
					break;
				}
				else
				break;
		}
		else if((v[i]==2996) && (v[i+1] == 3009))//¿
		 {
				i+=2;
				if((v[i]== 2986)&&(!(v[i+1]== 3021)) ) //¢ð
				{
					i+=2;	
					flag=1;
					break;
				}
				else if((v[i]== 2984) && (v[i+1]==3009)) //¢Ë
				{
					i+=2;
					flag=1;
					break;
				}
				else
				 break;
		 }
		 else if((v[i]==2975)&&(v[i+1]== 3021))//ì¢
		 {
				i+=2;
				if((v[i]== 2975) && (v[i+1]==3009)) //´
				{
					  i+=2; 	
					  flag=1;
					  break;
				}
				else if((v[i]== 2975)&&(v[i+1]== 3006)) //¢ì£
				{
					 i+=2;
					if((v[i]== 2991)&&(v[i+1]== 3007))  //ò¤
					{
						 i+=2;	
						 flag=1;
						break;
					 }
					 else
					 break;
				}
				else
				break;
		 }
		else
		 break;

		}//****
		else if(v[i]==2990 && (v[i+1]==3010))//Í
		 {
			////////System.out.println("Kavitha");	
			i+=2;
			if((v[i]== 2997)&&(v[i+1]== 3006) &&(v[i+2]== 2991)&&(v[i+3]== 3007)  ) //¢õ£ò¤
			{
				i+=4;	
				flag=1;
				break;
			}
			else  if((v[i]==2985)&&(v[i+1]== 3021)) //¢ù¢
			{
			    	i+=2;
			   	if((v[i]== 2993) &&(v[i+1]==3009)) //¢Á
				 {
					      i+=2;
					     if(i==len )
				             {
			 		      		flag=1;
				        	     	break;
					     }
					    else
					    break;
				   }
				  else if((v[i]== 2993)&&(v[i+1]== 3006)) //¢ø£
				{	
						i+=2;
						flag=1;
					 	break;
				 }
				 else
				 break;
		}
		 else
		 break;
	   }
	   else if(v[i]==2962)//å
	   {
		   i++;
	 	if((v[i]== 2992) && (v[i+1]==3009))//'¼"
    		{
			i+=2;
			if(i==len)
			{
				  flag=1;
		        	 break;
			 }
			else
			break;
		 }
		else  if((v[i]==2985) &&(v[i+1]==3021)) //¢ù¢
		 {
			  i+=2;
			
			 if((v[i]== 2993)&&(v[i+1]== 3006)) //¢ø£
			 {
				i+=2;		
				 flag=1;
				 break;
		         }
			 else if((v[i]==2993) && (v[i+1]==3009))//¢Á
			 {
				i+=2;
				if(i==len )
		 		{
					flag=1;
			  		break;
				 }
				else
				break;
			 }
			 else  if(v[i]== 2986) //¢ð
			{
				i++;
				if((v[i]== 2980) && (v[i+1]==3009))//¶
				{
						  i+=2;				
						  flag=1;
						   break;
			        }
			        else  if((v[i]==2980)&&(v[i+1]== 3006)) //¢î£   ¢
			         {
						i+=2;
						flag=1;
						break;
				}
			        else
			        break;
			}
		   }
		else
		break;
	   }
	   else if(v[i]==2960)//ä
	   {
		   i++;
		if((v[i]==2990)&&(v[i+1]== 3021)) //ñ¢
	   	{
			i+=2;
			if(v[i]== 2986) //¢ð
			{
				 flag=1;
				 break;
			}
			else
			break;
	   	}
   		else if((v[i]==2984) &&(v[i+1]==3009))//Ë
	   	{
			i+=2;
			flag=1;
			 break;
		 }
		  else if((v[i]==2984)&&(v[i+1]== 3021))//ï¢
		 {
		      	i+=2;
			if((v[i]== 2980)  &&(v[i+1]==3009))//¶
			{
				i+=2;
				flag=1;
				 break;
		 	}
		       else if((v[i]== 2980)&&(v[i+1]== 3006)) //¢î£
			{
				i+=2;
				if((v[i]== 2991)&&(v[i+1]== 3007))  //ò¤
				{
					 i+=2;
					 flag=1;
					 break;
				}
				else
				break;
		         }
		  	else
			break;
		  }
		else
	       	break;

		}//****
		else if(v[i]==2986)//ð
		{
			i++;
			if((v[i]== 2979) &&(v[i+1]==3007))//¢í¤
			{
				i+=2;
				if(v[i]== 2992) //ó			      {
			  	   	flag=1;
			  	  	break;
			      }
			     else
		             break;
			}
			else if((v[i]== 2980)&&(v[i+1]== 3021)) //î¢
			{
				i+=2;
			      if((v[i]==2980)&&(v[i+1]==3009)) //¶
			     {
					i+=2;
					flag=1;
					break;
			      }
				else if((v[i]==2980)&&(v[i+1]== 3006)) //¢î£
				{
					i+=2;	
					if( (v[i]== 2991)&&(v[i+1]== 3007))//ò¤
					{
						i+=2;
					   	flag=1;
					   	break;
					}
					else
					break;
				 }
				else if((v[i]== 3014)&&(v[i+1]== 2980)&&(v[i+2]== 3006)) //¢ªî£
			      {
					 i+=3;
					flag=1;
					break;
				}
				else if((v[i]== 2980)&&(v[i+1]== 3007)) //¢î¤
				{
					   i+=2;
					if( (v[i]== 3015)&&(v[i+1]== 2985))//«ù
					  { 
						 i+=2;
					     	flag=1;
					  	break;
					  }
					  else if( (v[i]== 2985)&&(v[i+1]== 3006))//ù£
					  { 
						i+=2;
						flag=1;
						break;
					  }
					  else if( (v[i]== 3014)&&(v[i+1]== 2985)&&(v[i+2]== 3006))//ªù£
					{
						i+=3;
					   	flag=1;
					   	break;
					}
					else if( (v[i]== 3016)&&(v[i+1]==2985 ))//¬ù
					{
						i+=2;
			   			flag=1;
			   			break;
				    	}
					else if((v[i]== 2990) &&(v[i+1]==3010))//Í
					{
						 i+=2;
					   	flag=1;
					   	break;
				          }
					else
	                                 break;
			   	}				else
		                break;
			 }
			 else
		         break;

		  }//****
		  else if(v[i]==3014)//ª
		   {
				i++;
			        if(v[i]==2980)//î
			        {
						i++;
						if(v[i]==3006)//£
						{
						       i++;
						       if((v[i]== 2995)&&(v[i+1]== 3021) &&(v[i+2]== 2995)&&(v[i+3]== 3006)  ) //¢÷¢÷£
							{    
								i+=4;
							    	flag=1;
							    	break;
					                 }
					                else  if((v[i]== 2985)&&(v[i+1]== 3021) &&((v[i+2]== 2985 )&&(v[i+3]==3009)) ) //¢ù¢Û
							{
								i+=4;
							  	flag=1;
							  	break;
							}
							else
							break;
				           	}						else
					        break;
				}
				else
			    	break;		   }//****
		   else if((v[i]==2984) && (v[i+1] == 3009))//Ë
		   {
			   i+=2;
			   if((v[i]== 2993)&&(v[i+1]== 3006)) //¢ø£
			{
				i+=2;
				flag=1;
				break;
			}
			else if((v[i]== 2993)&&(v[i+1]== 3021))//¢ø¢
			{
				i+=2;
				if((v[i]== 2993)&&(v[i+1]== 3007))//¢ø¤
				{
					i+=2;
	   			   	flag=1;
	   			   	break;
				}
				else
				break;
			}
			else if((v[i]== 2993) && (v[i+1]==3009))//Á
			{
				i+=2;
			   	flag=1;
			   	break;
			}
			else
			break;
	   }//***
	   else if(v[i]==2984)//ï
	   {
		   i++;
		   if(v[i]==3006)//£
		   {
			   i++;
			   if( (v[i]== 2985)&&(v[i+1]== 3021))//ù
			   	{
				   	  i+=2;
				   	  	if((v[i]==2965)&&(v[i+1]== 3006)) //¢è£   ¢
					 	  {
							i+=2;
							flag=1;
							break;
					 	  }
				   	  	else if( (v[i]== 2965) &&(v[i+1]==3009))//"° "
					   	{ 
							 i+=2;
							flag=1;
							break;
						}
						else
						break;
				}

		  }
	   }
	   else if(v[i]==2949)//Ü
	   {
		   i++;
		   if((v[i]== 2993) &&(v[i+1]==3009))//Á
		   {
			    i+=2;
				 if((v[i]==2984) &&(v[i+1]==3009))//Ë
				{
					i+=2;
					flag=1;
					 break;
		   		}
		   		else if((v[i]== 2986) &&(v[i+1]== 2980)&&(v[i+2]== 3021))//¢ðî¢
				{
					i+=3;
					flag=1;
					break;
				}
				else
			 	break;
		   }
		  else
	  	break;	 }
	else if(v[i]==2950)//Ý
	   {
		i++;
		if((v[i]== 2991)&&(v[i+1]== 3007)&&(v[i+2]== 2992) )  //ò¤ó
		{
			   i+=3;
			if((v[i]==2990)&&(v[i+1]== 3021)) //ñ¢
			{
				i+=2;
				flag=1;
				break;
			}
		     else if((v[i]== 2980)&&(v[i+1]== 3021)) //î¢
		         {        
				i+=2;
				flag=1;
				break;
			}
		       else
			break;
		}
		else if((v[i]== 2993)&&(v[i+1]== 3006)) //¢ø£
		 {
			 i+=2;
			 if((v[i]== 2991)&&(v[i+1]== 3007))//ò¤
			 {
				i+=2;
				flag=1;
				break;
			}
			 if((v[i]== 2997)&&((v[i+1]== 2980)&& (v[i+2]==3009)))//õ¶
			 {
				i+=3; 
				flag=1;
				break;
			}
			else
		        break;
	     	}
	  	else if((v[i]== 2993) && (v[i+1]==3009))//Á
	 	{
			 i+=2;

	   		
			if(i==len )
		 	{
				flag=1;
		  		break;
			 }
			else
			break;
         	}
		else	       break;
	   }
           else
            return false;
            break;
       }
       if (flag==0){
       return false;}
       else{
	//////System.out.println("chk num true");
       return true;}
	}

public static boolean dtcheck(String s)
	{
		String[ ] Dlist= new String[100];		Dlist[0] ="ஆண்டு";
	        Dlist[1] =  "தேதி";
	        Dlist[2] ="ஏப்ரல்";
	        Dlist[3] ="செப்டம்பர்";
		Dlist[4] =" தேதிக்கு";
		Dlist[5] ="மார்ச்";
	        Dlist[6] ="மாதம்";
	        Dlist[7] ="ஆண்டுகாலமாக";
	        Dlist[8] ="ஆகஸ்டு";
	        Dlist[9] ="தேதியான";
	        Dlist[10] ="நேற்று";
	        Dlist[11] ="டிசம்பர்";
	        Dlist[12] ="முதல்நாள்";
	        Dlist[13] ="செப்டெம்பர்";
	        Dlist[54] = "அக்டோபர்";
	        Dlist[14] ="வியாழன்";
	        Dlist[15] ="அதிகாலையில்";
	        Dlist[16] ="ஜனவரி";
	        Dlist[17] ="பிப்ரவரி";
	        Dlist[18] ="மே ";
	        Dlist[19] ="ஜூன்";
	        Dlist[20] ="ஜூலை";
	        Dlist[21] ="நவம்பர்";
	        Dlist[22] ="தேதியன்று";
	        Dlist[23] ="மாதத்தில்";
	        Dlist[24] ="வருசம்";
	        Dlist[25] ="வருசத்தில்";
	        Dlist[26] ="தினமான";
	        Dlist[27] ="ஆம்";
	        Dlist[28] ="ஆண்டில்";
	        Dlist[29] ="நாள்";
	        Dlist[30] ="ஆண்டுகள்";
	        Dlist[31] ="நடுஇரவு";
	        Dlist[32] ="காலம்";
	        Dlist[33] ="காலாண்டில்";
	        Dlist[34] ="மார்ச்சியில்";
	        Dlist[35] ="மாதத்துடன்";
	        Dlist[36] ="ஜூனில்";
	        Dlist[37] ="மாலையில்";
	        Dlist[38] ="காலையில்";
	        Dlist[39] ="இரவில்";
	        Dlist[40] ="பகலில்";
	        Dlist[41] ="நள்ளிரவில்";
	        Dlist[42] ="நடுஇரவில்";
	        Dlist[43] ="நன்பகல்";
	        Dlist[44] ="நடுனிசியில்";
	        Dlist[45] ="பகல்";
	        Dlist[46] ="இரவு";
	        Dlist[47] ="முன்பகல்";
	        Dlist[48] ="பிற்பகல்";
	        Dlist[49] ="சாயங்காலம்";
	        Dlist[50] ="சாமத்தில்";
	        Dlist[51] ="கருக்கலில்";
	        Dlist[52] ="மேமாத";
	        Dlist[53] ="ஒருமணி";
	        Dlist[55] ="நாளை";
	         Dlist[56] ="காலை";
	        Dlist[57] = "மணியளவில்";
	        Dlist[58]= "முற்பகல்";
	        Dlist[59]="வார";
	        Dlist[60]="அடுத்தாண்டு";
	        Dlist[61]="இந்தாண்டு";
		//Dlist[62]="அக்டோபர்";
	        int i = 0;
        for( i=0;i<62;i++)
        {
			////////System.out.println(Dlist[i]);
			if(s.startsWith(Dlist[i]))
			 break;
		}
		if(s.equals("«ñ"))
		   return true;
	    if(i == 62)
	    return false;
	    else
	    return true;

	}
public static boolean EXcheck(String s)
	{
		String[ ] Elist= new String[100];
		Elist[0]="மாளிகையில்";
		Elist[1]="வாழ்க்கையில்";
		Elist[2]="தொகையில்";
		 int i = 0;
		        for( i=0;i<2;i++)
		        {
				if(s.startsWith(Elist[i]))
				break;
			}
			if(i == 2)
		        return false;
			else
			return true;
	}

}
