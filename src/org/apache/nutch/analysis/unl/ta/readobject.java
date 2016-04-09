package org.apache.nutch.analysis.unl.ta;
import java.io.*;
class readobject
{
public static void main(String args[])
{
	try
	{
		File f=new File("/root/bharath/OptimizedAnalyzer/src/clia/unl/unicode/analyzer/DictInternalcode");
		File fileslist[]=f.listFiles();
		for(int i=0;i<fileslist.length;i++)
		{
			
			//String filename=fileslist[i].getName();
			FileInputStream fis=new FileInputStream(fileslist[i]);
			ObjectInputStream ois=new ObjectInputStream(fis);
			//BufferedWriter bw=new BufferedWriter(new FileWriter("/root/bharath/OptimizedAnalyzer/src/clia/unl/unicode/analyzer/DictInternalcode/"+filename));
			//BufferedReader br=new BufferedReader(new FileReader(fileslist[i]));
			//String str="";
			byte [] o=null;
			while((o=(byte[])ois.readObject())!=null)
			{
				
				//String str=UnicodeConverter.revert(o);
				//System.out.print("String is :"+str);	
				//bw.write("word is	:"+str+"     Internal code is	:");
				//bw.write(str);				
				//oos.write(b);
				
				//for(int i1=0;i1<b.length;i1++)
				//{
				//	//System.out.print(b[i1]+",");		
				//}
				////System.out.println();
				//bw.write("word is	:"+str+"	:Internalcode is	:"+s);	
			}
			ois.close();
			//br.close();
			//bw.close();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

}
