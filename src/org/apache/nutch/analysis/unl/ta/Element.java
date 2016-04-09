package org.apache.nutch.analysis.unl.ta;


import java.util.Vector;
import java.util.Date;


public class Element
{
	Vector part;
	Vector tag;
	public Element(Vector part, Vector tag)
	{
		this.part = part;
		this.tag = tag;
	}

	public Vector getPart()
	{
		return part;
	}

	public Vector getTag()
	{
		return tag;
	}

	public int containsTag(Integer i)
	{
		if (tag.contains(i))
		{
			return tag.indexOf(i);
		}
		return -1;
	}

}
