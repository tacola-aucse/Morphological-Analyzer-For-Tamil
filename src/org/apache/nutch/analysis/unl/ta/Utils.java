package org.apache.nutch.analysis.unl.ta;


import java.io.*;
import java.util.*;


public class Utils
{
	static String y = "";
	public static String newLineStr = "\n";
	public static String newLineStr_OS = System.getProperty("line.separator");

	public static final char[] WORD_SEPARATORS_FOR_DIC = {
		' ', '\t', '\n', ';',
		'?', '_', '\r', '\f', '.', ',', ':', '(', ')', '[', ']', '{', '}', '<',
		'>', '/', '|', '\\', '\'', '\"'};

	public static String readData(String fileName)
	{
		String s = "";

		try
		{
			InputStream fInStream = new FileInputStream(fileName);
			int n = fInStream.available();
			byte b[] = new byte[n];

			fInStream.read(b);
			fInStream.close();
			s = (new String(b, 0, n)).intern();
		} catch (IOException ioe)
		{
			ioe.printStackTrace();
			return "Error input";
		}
		return s;
	}

	public static void writeData(String words, String fileName)
	{
		StringTokenizer inputTokens = new StringTokenizer(words, "\n");

		try
		{
			BufferedWriter bw;

			if (fileName != null)
			{
				bw = new BufferedWriter(new FileWriter(new File(fileName)));
			} else
			{
				bw = new BufferedWriter(new FileWriter(new File("/usr/output/SomeFile.txt")));
			}
			for (; inputTokens.hasMoreTokens();)
			{
				String s = (inputTokens.nextToken()).intern();

				bw.write(s, 0, s.length());
				bw.newLine();
			}
			bw.close();
		} catch (IOException ioe)
		{
			ioe.printStackTrace();
			return;
		}
	}

	public static String removeTag(String ip)
	{
		StringBuffer output = new StringBuffer();

		return parseLine1(ip, output);
	}

	static String parseLine1(String input, StringBuffer output)
	{
		try
		{
			int ltIndex = -1;
			int gtIndex = -1;

			while (input.length() > 0)
			{
				ltIndex = input.indexOf("<");
				if (ltIndex != -1)
				{
					gtIndex = input.indexOf(">");
					if (gtIndex != -1)
					{
						output.append(input.substring(0, ltIndex));
						input = input.substring(gtIndex + 1);
					} else
					{
						input = "WRONG INPUT";
					}
				} else
				{
					output.append(input.substring(0, input.length()));
					break;
				}
			}
		} catch (StringIndexOutOfBoundsException ex)
		{
			////System.out.println(y + "Utils parseLine: " + ex);
		}
		return output.toString();
	}

}
