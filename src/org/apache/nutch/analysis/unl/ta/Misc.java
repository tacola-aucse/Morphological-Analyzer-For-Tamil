package org.apache.nutch.analysis.unl.ta;

import java.util.Stack;
import java.util.Vector;


public class Misc
{
	static void backTrack(Stack o, Stack s)
	{
		while (!s.empty())
		{
			s.pop();
		}
		for (int i = 0; i < o.size(); i++)
		{
			s.push((Entry) o.get(i));
		}
	}

	// push s1 into s2
	static void merge(Stack s1, Stack s2)
	{
		for (int i = 0; i < s1.size(); i++)
		{
			s2.push((Entry) s1.get(i));
		}
	}

	static void backTrack1(Stack o, Stack s)
	{
		while (!s.empty())
		{
			s.pop();
		}
		for (int i = 0; i < o.size(); i++)
		{
			s.push(o.get(i));
		}
	}

	public static void reverse(byte[] n)
	{
		for (int i = 0; i < n.length / 2; i++)
		{
			byte t = n[i];

			n[i] = n[n.length - i - 1];
			n[n.length - i - 1] = t;
		}
	}

	public static void printArray(byte[] n)
	{
		for (int i = 0; i < n.length; i++)
		{
			//////System.out.println(i + ": " + n[i]);
		}
	}
}
