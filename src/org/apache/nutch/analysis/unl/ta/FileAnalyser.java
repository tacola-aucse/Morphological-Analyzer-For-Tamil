package org.apache.nutch.analysis.unl.ta;

import java.util.*;


public class FileAnalyser
{
	public static void main(String[] args)
	{
		String input = null;
		String inputFileName = null;
		String outputFileName = null;
		String output = null;

		if (args.length >= 2)
		{
			inputFileName = args[0];
			input = Utils.readData(inputFileName);

			outputFileName = args[1];
			output = Analyse(input, 2);
			//////System.out.println("Analysing...");
			Utils.writeData(output, outputFileName);
			//////System.out.println("Finished");
		} else
		{
		////System.out.println("usage: java analyser.FileAnalyser <input file> <output file>");
			return;
		}
	}

	static public String[] tokenize(String string)
	{
		int i = 0;
		String wordSeparators = (new String(Utils.WORD_SEPARATORS_FOR_DIC)).intern();
		StringTokenizer stringTokens = new StringTokenizer(string,wordSeparators);
		String[] result = new String[stringTokens.countTokens()];

		while (stringTokens.hasMoreTokens())
		{
			result[i++] = (stringTokens.nextToken()).intern();
		}
		return result;
	}

	// tag is 1 for tamil, 2 for english
	static public String Analyse(String inputStr, int tag)
	{
		String tagStr = "org/apache/nutch/analysis/unl/ta/";

		// tamil
		if (tag == 1)
		{
			tagStr += "Tamil_Expanded";
		} else
		{
			tagStr += "English_Expanded";
		}

		org.apache.nutch.analysis.unl.ta.Analyser.Tags = ResourceBundle.getBundle(tagStr);

		inputStr = Utils.removeTag(inputStr);
		String[] s = tokenize(inputStr);
		String op = "";

		int errCount = 0;

		for (int i = 0; i < s.length; i++)
		{
			String output = (org.apache.nutch.analysis.unl.ta.Analyser.analyseW(s[i], false)).intern();

			op += (i + 1) + ". ";
			if ("Unknown".equals(output))
			{
				errCount++;
			}
			op += output;
			op += Utils.newLineStr_OS + "----" + Utils.newLineStr_OS;
		}

		int correctCount = s.length - errCount;
		double percentage = (float) correctCount / s.length;

		percentage *= 100;
		String msg = Utils.newLineStr_OS + "Percentage: " + correctCount + "/"
		  + s.length + "=" + percentage;

		return op;
	}
}
