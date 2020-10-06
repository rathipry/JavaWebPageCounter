package com.study.mypackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * This class is used to read pageCount variable from locally saved file.
 */
public class PageCounter {
	
	int pageCount = 0;
	
	PageCounter() 
	{
		String text = null;
		BufferedReader reader = null; 
		
		
		try {
			FileReader fr = new FileReader("D:\\count.txt");
			reader = new BufferedReader(fr);
			while ( (text = reader.readLine()) != null )
			{
				pageCount = Integer.parseInt(text);
			}
			System.out.println(" pagecount = " + pageCount);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try
			{
				if(reader != null)
				{
					reader.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	int getPageCount()
	{
		return this.pageCount;
	}
	
	public void writeFile(int count)
	{
		pageCount = count;
		
		try {
			File f = new File("D:\\count.txt");
			String wt = String.valueOf(pageCount);
			FileWriter fw = new FileWriter("D:\\count.txt");
			fw.write(wt);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}

}
