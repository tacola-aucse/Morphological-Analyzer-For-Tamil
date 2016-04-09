
package org.apache.nutch.analysis.unl.ta;

//import org.apache.nutch.unl.utils.*;
import java.util.Stack;
import java.util.Vector;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.io.*;

public class ADictionary
{
	static ByteMeth ByteMeth;
	static UnicodeConverter TC;
	static String x = "";
	static String y = "";
	static boolean b=true;
	// initialise dictionary
	static BTree Noun_BTree = new BTree();
	static BTree Verb_BTree = new BTree();
	static BTree Adjective_BTree = new BTree();
	static BTree Adverb_BTree = new BTree();
	static BTree Particle_BTree = new BTree();
	static BTree Neg_Finite_Verb_BTree = new BTree();
	static BTree Conjuntion_BTree = new BTree();
	static BTree Interjection_BTree = new BTree();
	static BTree Interrogative_BTree = new BTree();
	static BTree Interrogative_Adj_BTree = new BTree();
	static BTree Demo_Adj_BTree = new BTree();
	static BTree Finite_Verb_BTree = new BTree();
	static BTree Postposition_BTree = new BTree();
	static BTree Intensifier_BTree = new BTree();
	static BTree Non_Tamil_BTree = new BTree();
	static BTree m_End_Noun_BTree = new BTree();
    static BTree ProNoun_BTree = new BTree();
    static BTree En_BTree = new BTree();
	static BTree Entity_BTree = new BTree();
	// load dictionary in memory
	static
	{
		String path="./Analyser/";
		Verb_BTree.updateDictTree(path+"Verb_vi.txt");
		Noun_BTree.updateDictTree(path+"Noun_pe.txt");
		Adjective_BTree.updateDictTree(path+"Adjective_pe_a.txt");
		Adverb_BTree.updateDictTree(path+"Adverb_vi_a.txt");
		Particle_BTree.updateDictTree(path+"Particle_i_so.txt");
		Postposition_BTree.updateDictTree(path+"Postposition_sollurubu.txt");
		Neg_Finite_Verb_BTree.updateDictTree(path+"Neg_Finite_Verb_e_v_mu.txt");
		Conjuntion_BTree.updateDictTree(path+"Conjuction_i_i_so.txt");
		Interjection_BTree.updateDictTree(path+"Interjection_vi_i_so.txt");
		Interrogative_BTree.updateDictTree(path+"Interrogative_Noun_vi_pe.txt");
		Interrogative_Adj_BTree.updateDictTree(path+"Interrogative_Adj_vi_pe_a.txt");
		Demo_Adj_BTree.updateDictTree(path+"Demon_Adjective_su_pe_a.txt");
		Finite_Verb_BTree.updateDictTree(path+"Finite_Verb_vi_mu.txt");

		Intensifier_BTree.updateDictTree(path+"Intensifier.txt");
		Non_Tamil_BTree.updateDictTree(path+"NonTamil.txt");
		m_End_Noun_BTree.updateDictTree(path+"m_End_Noun.txt");
		ProNoun_BTree.updateDictTree(path+"pronoun.txt");
		En_BTree.updateDictTree(path+"En.txt");
		Entity_BTree.updateDictTree(path+"entitylist.txt");
		b=false;
		
	}


	/*public static void reloadDic()
	{
		////////System.out.println("Reloading Dictionary...");

		Verb_BTree.makeEmpty();
		Noun_BTree.makeEmpty();
		Adjective_BTree.makeEmpty();
		Adverb_BTree.makeEmpty();
		Particle_BTree.makeEmpty();
		Postposition_BTree.makeEmpty();
		Neg_Finite_Verb_BTree.makeEmpty();
		Conjuntion_BTree.makeEmpty();
		Interjection_BTree.makeEmpty();
		Interrogative_BTree.makeEmpty();
		Interrogative_Adj_BTree.makeEmpty();
		Demo_Adj_BTree.makeEmpty();
		Finite_Verb_BTree.makeEmpty();
		Intensifier_BTree.makeEmpty();
		Non_Tamil_BTree.makeEmpty();
		m_End_Noun_BTree.makeEmpty();
		ProNoun_BTree.makeEmpty();
		En_BTree.makeEmpty();
		Entity_BTree.makeEmpty();
		////////System.out.println("going to load the dictionary");

		Verb_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Verb_vi.txt");
		////////System.out.println("loaded");
		Noun_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Noun_pe.txt");
		////////System.out.println("loaded");
		Adjective_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Adjective_pe_a.txt");
		////////System.out.println("loaded");
		Adverb_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Adverb_vi_a.txt");
		////////System.out.println("loaded");
		Particle_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Particle_i_so.txt");
		////////System.out.println("loaded");
		Postposition_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Postposition_sollurubu.txt");
		  ////////System.out.println("loaded");
		Neg_Finite_Verb_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Neg_Finite_Verb_e_v_mu.txt");
		  ////////System.out.println("loaded");
		Conjuntion_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Conjuction_i_i_so.txt");
		////////System.out.println("loaded");
		Interjection_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Interjection_vi_i_so.txt");
		////////System.out.println("loaded");
		Interrogative_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Interrogative_Noun_vi_pe.txt");
		 // //////System.out.println("loaded");
		Interrogative_Adj_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Interrogative_Adj_vi_pe_a.txt");
		  ////////System.out.println("loaded");
		Demo_Adj_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Demon_Adjective_su_pe_a.txt");
		////////System.out.println("loaded");
		Finite_Verb_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Finite_Verb_vi_mu.txt");
		////////System.out.println("loaded");

		Intensifier_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Intensifier.txt");
		////////System.out.println("loaded");
		Non_Tamil_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/Intensifier.txt");
		////////System.out.println("loaded");
		m_End_Noun_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/m_End_Noun.txt");
		////////System.out.println("loaded");
		ProNoun_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/pronoun.txt");
		////////System.out.println("loaded");
		En_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/En.txt");
		Entity_BTree.updateDictTree("clia/unl/unicode/analyzer/Dictionary/entitylist.txt");
		////////System.out.println("loaded");
	}*/

	// dictionary checking order - wont follow any rule
	public static boolean check(Stack allStk, byte topElmt1[])
	{
	

            System.out.println("Entering in ADictionary Check ");
		Stack s2 = new Stack();
		s2.push(new Entry(topElmt1, -1));
		
		Sandhi.kctp(s2);
		allStk.push(s2);
		String input="";
		String inputstring="";
		Stack s1 = (Stack) allStk.pop();
		byte[] topElmt = ((Entry) s1.peek()).getPart();
		byte[] oldTopElmt = topElmt.clone();
		//String input = TC.revert(topElmt);
		//System.out.print("here");
		for(int i=0;i<topElmt.length;i++)
		{
		//	System.out.print(topElmt[i]);
			input+=topElmt[i];
		}
		for(int i=0;i<topElmt1.length;i++)
		inputstring+=topElmt1[i];
		
		//////System.out.println("chk"+input);
		boolean found = false;
		boolean isVerb = false;
		
		 if(Entity_BTree.contains(inputstring))
		{
			Stack s = new Stack();
			s.push(new Entry(topElmt1,Tag.Entity));
			allStk.push(s);
			found = true;
			return true;
		}
		if (BooleanMethod.isPronoun(topElmt))
		{

			Stack s = (Stack) s1.clone();

			// doubt why poping?
			s.pop();
			s.push(new Entry(topElmt, Tag.Pronoun));
			allStk.push(s);
			found = true;
		}
		//////System.out.println("2");
		if (BooleanMethod.isPronoun_Case(topElmt))
		{
		
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.PronounCase));
			allStk.push(s);
			found = true;
		}
		//////System.out.println("3");
		if (BooleanMethod.isPronoun_Clitic(topElmt))
		{
			////////System.out.println("pronoun clitic");
			//////System.out.println( "Pronoun Clitic");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.PronounClitic));
			allStk.push(s);
			found = true;
		}
		//////System.out.println("4");
		if (Demo_Adj_BTree.contains(input))
		{

			////////System.out.println("Demo Adj");
			//////System.out.println( "Demo Adj");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.DemonstrativeAdjective));
			allStk.push(s);
			found = true;
		}
		//////System.out.println("5");
		 if (Neg_Finite_Verb_BTree.contains(input))
		{
			////////System.out.println("NegFiniteVerb");
			//////System.out.println( "NegFiniteVerb");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.NegativeFiniteVerb));
			allStk.push(s);
			found = true;

		}
		//////System.out.println("6");
		//////System.out.println("size of Tree"+Finite_Verb_BTree.size());
		if (Finite_Verb_BTree.contains(input))
		{
			////////System.out.println("Finite Verb");
			//////System.out.println( "Finite Verb");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.FiniteVerb));
			allStk.push(s);
			found = true;

		}
		//////System.out.println("7");
		//////System.out.println("size of stack is."+Finite_Verb_BTree.size());
		 if (Interjection_BTree.contains(input))
		{
			////////System.out.println("Interjection");
			//////System.out.println( "Interjection");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.Interjection));
			allStk.push(s);
			found = true;

		}
		//////System.out.println("8");
		if (Interrogative_BTree.contains(input))
		{
			////////System.out.println("InterrogativeNoun");
			//////System.out.println( "InterrogativeNoun");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.InterrogativeNoun));
			allStk.push(s);
			found = true;
		}
		//////System.out.println("9");
		if (Interrogative_Adj_BTree.contains(input))
		{
			////////System.out.println("InterrogativeAdj");
			//////System.out.println( "InterrogativeAdj");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.InterrogativeAdjective));
			allStk.push(s);
			found = true;
		}
		//////System.out.println("10");
		 if (Conjuntion_BTree.contains(input))
		{
			////////System.out.println("IIS");
			//////System.out.println( "IIS");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.Conjunction));
			allStk.push(s);
			found = true;
		}
		//////System.out.println("11");
		if (Adjective_BTree.contains(input))
		{
			////////System.out.println("ADJ");
			//////System.out.println( "ADJ");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.Adjective));
			allStk.push(s);
			found = true;

		}
		//////System.out.println("12");
		if (Intensifier_BTree.contains(input))
		{
			////////System.out.println("Intensifier");
			//////System.out.println( "Intensifier");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.Intensifier));
			allStk.push(s);
			found = true;
		}
		//////System.out.println("13");
		 if (Particle_BTree.contains(input))
		{
			////////System.out.println("Particle");
			//////System.out.println( "Particle");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.Particle));
			allStk.push(s);
			found = true;
		}
		//////System.out.println("14");
		 if (Postposition_BTree.contains(input))
		{
			//////System.out.println("postPosition");
			//////System.out.println( "Postposition");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.Postposition));
			allStk.push(s);
			found = true;
		}
		//////System.out.println("15");
		 if (Verb_BTree.contains(input))
		{
			////////System.out.println("verb");
			//////System.out.println( "Verb");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.Verb));
			allStk.push(s);
			found = true;
			isVerb = true;
		}
		//////System.out.println("16");
		if (Adverb_BTree.contains(input))
		{
			////////System.out.println("adverb");
			//////System.out.println( "Adverb");
			Stack s = (Stack) s1.clone();

			s.pop();
			s.push(new Entry(topElmt, Tag.Adverb));
			allStk.push(s);
			found = true;
		}
		//////System.out.println("17");
		//////System.out.println("Non_Tamil_BTree"+Non_Tamil_BTree.size());
		if(Non_Tamil_BTree.contains(inputstring))
		{
			////////System.out.println("Nn-Tamil");
			//////System.out.println( "Non Tamil");
			Stack s = new Stack();

			s.push(new Entry(topElmt1, Tag.NonTamilNoun));
			allStk.push(s);
			found = true;
		}
		//////System.out.println("18");
		////System.out.println("noun btree"+input);
		if (Noun_BTree.contains(input))
		{
			System.out.println("Noun");
			//////System.out.println( "Noun");
			Stack s = (Stack) s1.clone();
			s.pop();
			s.push(new Entry(topElmt, Tag.Noun));
			allStk.push(s);
			found = true;
		}
		//////System.out.println("19");
		 if (m_End_Noun_BTree.contains(input))
				{
			//		//////System.out.println("m_End_Noun");
					//////System.out.println( "m_End_Noun");
					Stack s = (Stack) s1.clone();
					s.pop();
					s.push(new Entry(topElmt,Tag.AdjectivalNoun));
					allStk.push(s);
					found = true;
		}
		//////System.out.println("20");
		 if(Entity_BTree.contains(input))
		{
					//Utils.printOut(Analyser.print, x + "Entity");
					Stack s = (Stack) s1.clone();
					s.pop();
					s.push(new Entry(topElmt,Tag.Entity));
					allStk.push(s);
					found = true;
		}
		if(!found)
		{
			
		}
		//////System.out.println("Hello bharath");		
		// found for future
		if (found)
		{
			return true;
		}
		
	
		return false;
	}
	public static boolean tourismDomain(Stack allStk,byte [] topElmt1)
	{
		Stack s2 = new Stack();
		s2.push(new Entry(topElmt1, -1));
		Sandhi.kctp(s2);
		allStk.push(s2);
		Stack s1 = (Stack) allStk.pop();
		byte[] topElmt = ((Entry) s1.peek()).getPart();
		String ahcheck="";
	
		// for making அ as ஆ  ex சீன becomes சீனா
		if(topElmt[topElmt.length-1]==1)
		{
			byte[] oldTopElmt = topElmt.clone();
			oldTopElmt[oldTopElmt.length-1]=2; // 2 is internal code value of ஆ
			String str=UnicodeConverter.revert(oldTopElmt);
			for(int i=0;i<oldTopElmt.length;i++)
			ahcheck+=oldTopElmt[i];
			 if(Entity_BTree.contains(ahcheck))
			{
					Stack s = (Stack) s1.clone();
					s.pop();
					s.push(new Entry(topElmt,Tag.Entity));
					allStk.push(s);
					return true;
					
			}
			
			
		}
		//System.out.println("before revert="+UnicodeConverter.revert(topElmt));
		// adding ம்  at the end of word ex மகாபல்லிபுர become மகாபல்லிபுரம்
		
		if(topElmt[topElmt.length-1]==1)
		{
			//System.out.println("ன்  adding");
			int length=topElmt.length+1;
			byte [] oldTopElmt=new byte[length];
			for(int i=0;i<topElmt.length;i++)
			{
				oldTopElmt[i]=topElmt[i];
			}
			////System.out.println("revert="+UnicodeConverter.revert(oldTopElmt));
			oldTopElmt[topElmt.length]=31; //31 is internalcode value of ன் 
			String str=UnicodeConverter.revert(oldTopElmt);
			////System.out.println("after added ன் revert="+UnicodeConverter.revert(oldTopElmt));
			ahcheck="";
			for(int i=0;i<oldTopElmt.length;i++)
			ahcheck+=oldTopElmt[i];
			 if(Entity_BTree.contains(ahcheck))
			{
					Stack s = (Stack) s1.clone();
					s.pop();
					s.push(new Entry(oldTopElmt,Tag.Entity));
					allStk.push(s);
					return true;
					
			}
		}
		if(topElmt[topElmt.length-1]==1)
		{
			//System.out.println("ர் adding");
			int length=topElmt.length+1;
			byte [] oldTopElmt=new byte[length];
			for(int i=0;i<topElmt.length;i++)
			{
				oldTopElmt[i]=topElmt[i];
			}
			//System.out.println("revert="+UnicodeConverter.revert(oldTopElmt));
			oldTopElmt[topElmt.length]=25;  // 25 is internal code value of ர் 
			String str=UnicodeConverter.revert(oldTopElmt);
			//System.out.println("after added ர் revert="+UnicodeConverter.revert(oldTopElmt));
			ahcheck="";
			for(int i=0;i<oldTopElmt.length;i++)
			ahcheck+=oldTopElmt[i];
			 if(Entity_BTree.contains(ahcheck))
			{
					Stack s = (Stack) s1.clone();
					s.pop();
					s.push(new Entry(oldTopElmt,Tag.Entity));
					allStk.push(s);
					return true;
					
			}
			
		}
		if(topElmt[topElmt.length-1]==1)
		{
			//System.out.println("ம்  adding");
			int length=topElmt.length+1;
			byte [] oldTopElmt=new byte[length];
			for(int i=0;i<topElmt.length;i++)
			{
				oldTopElmt[i]=topElmt[i];
			}
			//System.out.println("revert="+UnicodeConverter.revert(oldTopElmt));
			oldTopElmt[topElmt.length]=23; //23 is internal code value of ம்
			String str=UnicodeConverter.revert(oldTopElmt);
			ahcheck="";
			for(int i=0;i<oldTopElmt.length;i++)
			ahcheck+=oldTopElmt[i];
			 if(Entity_BTree.contains(ahcheck))
			{
					Stack s = (Stack) s1.clone();
					s.pop();
					s.push(new Entry(oldTopElmt,Tag.Entity));
					allStk.push(s);
					return true;
					
			}
		}
		if(ByteMeth.endsWith(topElmt, Constant.eyya))
		{
			//System.out.println(UnicodeConverter.revert(topElmt).toString());
			String chk="";
			byte [] oldTopElmt=new byte[topElmt.length];
			for(int i=0;i<topElmt.length;i++)
			{
				oldTopElmt[i]=topElmt[i];
			}
			oldTopElmt=ByteMeth.subArray(oldTopElmt, 0,oldTopElmt.length - Constant.eyya.length);
			oldTopElmt=Sandhi.remove_kctp1(oldTopElmt);
			for(int i=0;i<oldTopElmt.length;i++)
			chk+=oldTopElmt[i];
			 if(Entity_BTree.contains(chk))
			{
					
					Stack s = (Stack) s1.clone();
					s.pop();
					s.push(new Entry(oldTopElmt,Tag.Entity));
					allStk.push(s);
					return true;
					
			}
			
		
		}
		return false;
		
	}
	public static boolean adjectivalNoun(Stack allStk,byte [] topElmt)
	{
		////////System.out.println("ADictionary --- adjectivalNoun");
		Stack s = new Stack();

		s.push(new Entry(topElmt, -1));
		Sandhi.kctp(s);
		String inputstring="";
		byte[] inputByte = topElmt;
		byte[] inputByte1 = null;

		if (inputByte[inputByte.length - 1] == Constant.a[0])
		{
			inputByte1 = ByteMeth.addArray(inputByte, Constant.m);
			for(int i=0;i<inputByte1.length;i++)
			inputstring+=inputByte1[i];
			if (Noun_BTree.contains(inputstring))
			{
				//////System.out.println( "Adjectival Noun");
				s.pop();
				s.push(new Entry((inputByte), Tag.AdjectivalNoun));
				allStk.push(s);
				return true;
			}
		}
		return false;
	}
	
	public static boolean doubleNoun(Stack allStk,byte [] topElmt)
	{
		////System.out.println("ADictionary --- Double Noun called");
		Stack s = new Stack();

		s.push(new Entry(topElmt, -1));
		if(ADictionary.dnoun(s))
		{
			allStk.push(s);
			////System.out.println("I am true"+s.size());
			return true;
		}
		return false;
	}
		

	
	public static boolean noun_PronounCase_InterrogativeNoun(Stack s)
	{
		String x = "";
        	//////System.out.println("Noun/PronounCase/Interrogative Noun");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		String input="";
		for(int i=0;i<topElmt.length;i++)
		input+=topElmt[i];

		if (Noun_BTree.contains(input))
		{
			//////System.out.println( "Noun");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Noun));
			return true;
		}
		if (BooleanMethod.isPronoun(topElmt))
		{
			//////System.out.println( "Pronoun");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Pronoun));
			return true;
		}
		if (BooleanMethod.isPronoun_Case(topElmt))
		{
			//////System.out.println( "Pronoun Case");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.PronounCase));
			return true;
		}
		if (Interrogative_BTree.contains(input))
		{
			//////System.out.println( "Interrogative Noun");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.InterrogativeNoun));
			return true;
		}
		return false;
	}

	public static boolean noun_PronounClitic_InterrogativeNoun(Stack s)
	{
		String x = "";
        	//////System.out.println("Noun/PronounClitic/Interrogative Noun");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		String input="";
		for(int i=0;i<topElmt.length;i++)
		input+=topElmt[i];
		//////System.out.println("revert"+UnicodeConverter.revert(topElmt));
		if (Noun_BTree.contains(input))
		{
			//////System.out.println( "Noun");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Noun));
			return true;
		}
		if (BooleanMethod.isPronoun(topElmt))
		{
			//////System.out.println( "Pronoun");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Pronoun));
			return true;
		}
		if (BooleanMethod.isPronoun_Clitic(topElmt))
		{
			//////System.out.println( "Pronoun Clitic");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.PronounClitic));
			return true;
		}
		if (Interrogative_BTree.contains(input))
		{
			//////System.out.println( "Interrogative Noun");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.InterrogativeNoun));
			return true;
		}
		if(ADictionary.dnoun(s))
		return true;
		return false;
	}

	public static boolean postposition(Stack s)
	{
		String x = "";
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		String input="";
		for(int i=0;i<topElmt.length;i++)
		input+=topElmt[i];
		if (Postposition_BTree.contains(input))
		{
			//////System.out.println( "Postposition");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Postposition));
			return true;
		}
		return false;
	}

	public static boolean noun(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		String input="";
		for(int i=0;i<topElmt.length;i++)
		input+=topElmt[i];
		//////System.out.println("revert "+UnicodeConverter.revert(topElmt));
		
		 if (Noun_BTree.contains(input))
		{
			//////System.out.println( "Noun");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Noun));
			return true;
		}
		else if (Entity_BTree.contains(input))
		{
			//////System.out.println("Entity");
			//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Entity");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Entity));
		   	 return true;
		}
		else if (ProNoun_BTree.contains(input))
		{
			//////System.out.println( "ProNoun");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Pronoun));
		    return true;
		}
        	else if (En_BTree.contains(input))
		{
			if(ByteMeth.endsWith(topElmt, Constant.pathu))
			{
				//////System.out.println( "Enpathu");
				s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Enpathu));
				return true;
			}
			else
			{
					//////System.out.println( "Enpavar");
					s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Enpavar));
				    return true;
			}
		}
		else  if (Particle_BTree.contains(input))
		{
			////////System.out.println("Particle");
			//////System.out.println( "Particle");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Particle));
			return true;
		
		}
		return false;

	}

	//double noun

	public static boolean dnoun(Stack s)
		{
			int i = 1;
			int length =0;
			byte[] topElmt = ((Entry) s.peek()).getPart();
			byte[] oldTopElmt = topElmt;
			byte[] checkElmt = topElmt;
			String input="";
			
		length = topElmt.length;
		while(i!=length)
	        {
			//////System.out.println("i<=length   :"+i);
			checkElmt= ByteMeth.subArray(topElmt, (topElmt.length)-i,topElmt.length);
			input="";
			for(int j=0;j<checkElmt.length;j++)
			input+=checkElmt[j];
			
			////System.out.println("convert"+UnicodeConverter.revert(checkElmt));
			      if (Noun_BTree.contains(input))
			      {
				       //////System.out.println( "Noun");
				       s.pop();
				       s.push(new Entry(checkElmt, Tag.Noun));
					//////System.out.println("break");
				       break;
			      }
			      else if (Adjective_BTree.contains(input))
				{
					////////System.out.println("ADJ");
					//////System.out.println( "ADJ");
					//Stack s = (Stack) s1.clone();

					s.pop();
					s.push(new Entry(checkElmt, Tag.Adjective));
					 break;

				}				
		          i++;
		}

		
		    if(i!=length)
		    {
				////System.out.println("i==length   :"+i);
				  
				checkElmt= ByteMeth.subArray(topElmt,0, topElmt.length-i);
				s.push(new Entry(checkElmt, -1, oldTopElmt));
				Sandhi.kctp(s);
				//Sandhi.kctp(s);
				checkElmt = ((Entry) s.peek()).getPart();
				input="";
				////System.out.println("check Element         "+UnicodeConverter.revert(checkElmt));
			 	for(int i1=0;i1<checkElmt.length;i1++)
				input+=checkElmt[i1];
			    	if (Noun_BTree.contains(input))
				{
						//////System.out.println( "Noun");
						s.pop();
						s.push(new Entry(checkElmt, Tag.Noun));
						return true;
				}
				if (m_End_Noun_BTree.contains(input))
				{
						//////System.out.println( "Noun");
						s.pop();
						s.push(new Entry(checkElmt, Tag.AdjectivalNoun));
						return true;
				}
			}
					//////System.out.println(" after while");
			     return false;

	}
	public static boolean m_EndNoun(Stack s)
		{
			byte[] topElmt = ((Entry) s.peek()).getPart();
			byte[] oldTopElmt = topElmt;
			String input="";
			for(int i=0;i<topElmt.length;i++)
			input+=topElmt[i];
			if(ByteMeth.endsWith(topElmt, Constant.u))
		    {
			  topElmt = ByteMeth.subArray(topElmt, 0,
			  topElmt.length - Constant.u.length);
			  topElmt = ByteMeth.addArray(topElmt, Constant.a);
		    }

			if (m_End_Noun_BTree.contains(input))
			{
				//////System.out.println( "AdjectivalNoun");
				s.push(new Entry(((Entry) s.pop()).getPart(), Tag.AdjectivalNoun));
				return true;
			}
			return false;
	    }

	// Adverb
	public static boolean adverb(Stack s)
	{
		Sandhi.kctp(s);		//this statement is for checking whether the adverb comes with sandhi or not
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		String input="";
		for(int i=0;i<topElmt.length;i++)
		input+=topElmt[i];

		if (Adverb_BTree.contains(input))
		{
			//////System.out.println( "Adverb");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Adverb));
			return true;
		}
		return false;
	}

	// Verb
	public static boolean verb(Stack s)
	{
		//////System.out.println( "Chking Verb Dic");
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		String input="";
		for(int i=0;i<topElmt.length;i++)
		input+=topElmt[i];

		//////System.out.println("revert  1 "+UnicodeConverter.revert(topElmt));
		if (Verb_BTree.contains(input))
		{
			//////System.out.println("Verb_BTree True");
			if(ByteMeth.isEqual(topElmt, Constant.en))
			{
				//////System.out.println( "En");
				s.push(new Entry(((Entry) s.pop()).getPart(), Tag.En));
			    return true;
			}
			else
			{
			//////System.out.println( "Verb");
			s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Verb));
			return true;
		    }
		}
		return false;
	}

	//Nverb 1-06-06
  public static boolean Nverb(Stack s)
  	{
		int i = 1;
		int length =0;
		//////System.out.println( "Chking Noun+Verb Dic");
  		byte[] topElmt = ((Entry) s.peek()).getPart();
  		byte[] oldTopElmt = topElmt;
		String input="";

        byte[] checkElmt = topElmt;
        length = topElmt.length;
        while(i!=length)
			  {
			  checkElmt= ByteMeth.subArray(topElmt, (topElmt.length)-i,
			  topElmt.length);
				input="";
			  for(int i1=0;i1< checkElmt.length;i1++)
				input+= checkElmt[i1];	
			  //////System.out.println("check Element         "+UnicodeConverter.revert(checkElmt));
  		      if (Verb_BTree.contains(input))
  	          	{
				////////System.out.println("Chking Verb Dic----mine"+checkElmt);
  	    			//////System.out.println( "Verb");
				s.pop();
				s.push(new Entry(checkElmt, Tag.Verb));
				break;
  		        }
  		        i++;
	          }
		//////System.out.println("i"+":"+i+"="+length);
	    	 if(i!=length)
		      {
			//////System.out.println("noun/verb chenking");
			  checkElmt= ByteMeth.subArray(topElmt,0, topElmt.length-i);
				input="";
			  for(int i1=0;i1< checkElmt.length;i1++)
				input+= checkElmt[i1];	
			 // //////System.out.println("Chking Verb Dic--aaaaa--mine"+checkElmt);
			 //////System.out.println("check Element         "+UnicodeConverter.revert(checkElmt));
			  s.push(new Entry(checkElmt, -1, oldTopElmt));
			Sandhi.kctp(s);
			  //Sandhi.check(s);
			 Case.check(s,true);
			  ////////System.out.println("check Element         "+UnicodeConverter.revert(checkElmt));
			  checkElmt = ((Entry) s.peek()).getPart();
			  if (Noun_BTree.contains(input))
			  		{
					//////System.out.println( "Noun");
			  		s.pop();
			  		s.push(new Entry(checkElmt, Tag.Noun));
			  		return true;
				    }
			   else
			        s.push(new Entry(checkElmt, -1));
			   }
	    //////System.out.println("return false--mine"+checkElmt);
  		return false;
	}
	public static boolean longVowel(Stack s)
	{
		byte[] topElmt = ((Entry) s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(topElmt[topElmt.length-1]==1)
		{

			topElmt[topElmt.length-1]=2;
			String input="";
			for(int i=0;i<topElmt.length;i++)
			input+=topElmt[i];
		//	////System.out.println("revert "+UnicodeConverter.revert(topElmt));
		
			/* if (Noun_BTree.contains(input))
			{
				//////System.out.println( "Noun");
				s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Noun));
				return true;
			}*/
			if (Entity_BTree.contains(input))
			{
				//////System.out.println("Entity");
				//clia.unl.unicode.utils.Utils.printOut(Analyser.print, x + "Entity");
				s.push(new Entry(((Entry) s.pop()).getPart(), Tag.Entity));
			   	 return true;
			}
			return false;
		}
		return false;
	}
	/*public static boolean Verbalnoun(Stack allStk,String inputString)
	{
		Stack s = new Stack();

		s.push(new Entry(TC.convert(inputString), -1));
		//Sandhi.kctp(s);

		//byte[] inputByte = ((Entry) s.peek()).getPart();
		//byte[] inputByte1 = null;
		int i = 1;
		int length =0;
		int length1=0;
		//////System.out.println( "checking verb noun");
  		byte[] topElmt = ((Entry) s.peek()).getPart();
  		byte[] oldTopElmt = topElmt;
        	byte[] checkElmt = topElmt;
        	length = topElmt.length;
		length1=inputString.length();
		boolean isNoun=false;
		boolean isVerb=false;
		Stack nounStk=new Stack();
        	while(i!=length)
			  {
			 checkElmt= ByteMeth.subArray(topElmt, (topElmt.length)-i,
			  topElmt.length);
			String input=new String(UnicodeConverter.revert(checkElmt));
			// //////System.out.println("verbalnoun        "+UnicodeConverter.revert(checkElmt));
			//for(int k=0;k< checkElmt.length;k++)		
			 //input+=checkElmt[k];
			
			//////System.out.println("input is.."+input);
			isNoun= Noun.check(allStk, input, true);
  		      if (isNoun)
  	          	{
				for(int k=0;k<allStk.size();k++)
				{
					nounStk= (Stack) allStk.get(k);
				}
				allStk.clear();
				//////System.out.println("break.."+input);
				//s.pop();
				//s.push(new Entry(checkElmt, Tag.Verb));
				break;
  		        }
  		        i++;
	          }
		if(i!=length)
		{
			checkElmt= ByteMeth.subArray(topElmt, 0,
			 (topElmt.length)-i);
			String input=new String(UnicodeConverter.revert(checkElmt));
			//s.push(new Entry(checkElmt, -1, oldTopElmt));
			//////System.out.println("verbalnoun String is "+input);
			isVerb = Verb.check(allStk, input, false);
			int size=allStk.size();
			//////System.out.println("size is "+size);
			if(isVerb)
			{
				
				allStk.push(nounStk);
				
				//s.pop();
			  	//s.push(new Entry(checkElmt, Tag.Noun));
			  	return true;
			}
		}
		return false;
	}*/
	
	/*public static boolean longvowel(Stack allStk, byte [] topElmt,boolean analysePart)
	{
		int length=topElmt.length;
		byte b=topElmt[length-1];
		if(b==1)
		{
			////System.out.println("i am AH");
		}
		return true;
	}*/
}
