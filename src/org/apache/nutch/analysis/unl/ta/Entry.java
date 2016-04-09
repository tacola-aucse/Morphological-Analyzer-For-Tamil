package org.apache.nutch.analysis.unl.ta;


import java.util.Stack;
import java.util.Vector;
import java.util.Date;


/*
 analyser output stack's element
 */
public class Entry
{
	byte[] part;
	int tag;
	public Entry(byte[] part, int tag)
	{
		this.part = part;
		this.tag = tag;
	}

	public Entry(byte[] part, int tag, byte[] o)
	{
		this.part = part;
		this.tag = tag;
	}

	public byte[] getPart()
	{
		return part;
	}

	public int getTag()
	{
		return tag;
	}

}
