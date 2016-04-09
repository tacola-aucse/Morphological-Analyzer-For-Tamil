package org.apache.nutch.analysis.unl.ta;


import java.util.*;


public class AnalyserUtils
{
	public static Vector getPartVector(Stack stk)
	{
		Stack s = (Stack) stk.clone();

		Vector part = new Vector();

		while (!s.empty())
		{
			Entry entry = (Entry) s.pop();
			String str = UnicodeConverter.revert(entry.getPart());

			part.add(str);
		}
		return part;
	}

	public static Vector getTagVector(Stack stk)
	{
		Stack s = (Stack) stk.clone();

		Vector tag = new Vector();

		while (!s.empty())
		{
			Entry entry = (Entry) s.pop();
			int tagInt = entry.getTag();

			tag.add(new Integer(tagInt));
		}
		return tag;
	}
}
