package  org.apache.nutch.analysis.unl.ta;
import java.io.*;
class UnicodeTest
{
public static void main(String args[])
{
	try
	{
		//ADictionary.reloadDic();
		/*File f=new File("/root/bharath/OptimizedAnalyzer/src/clia/unl/unicode/analyzer/Dictionary");
		File fileslist[]=f.listFiles();
		for(int i=0;i<fileslist.length;i++)
		{
			
			String filename=fileslist[i].getName();
			FileOutputStream fos=new FileOutputStream("/root/bharath/OptimizedAnalyzer/src/clia/unl/unicode/analyzer/DictInternalcode/"+filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			//BufferedWriter bw=new BufferedWriter(new FileWriter("/root/bharath/OptimizedAnalyzer/src/clia/unl/unicode/analyzer/DictInternalcode/"+filename));
			BufferedReader br=new BufferedReader(new FileReader(fileslist[i]));
			String str="";
			while((str=br.readLine())!=null)
			{
				//System.out.print("String is :"+str);
				byte b[]=UnicodeConverter.convert(str);
				//bw.write("word is	:"+str+"     Internal code is	:");
				//bw.write(str);				
				oos.write(b);
				
				for(int i1=0;i1<b.length;i1++)
				{
					//System.out.print(b[i1]+",");		
				}
				//System.out.println();
				//bw.write("word is	:"+str+"	:Internalcode is	:"+s);	
			}
			oos.close();
			br.close();
			//bw.close();
		}*/
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

}
