package org.file.handling;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileHandling {
File file=new File("C:\\Users\\Prakash\\eclipse-workspace\\FileHandling1\\src\\test.txt");
	
	public void readFile() {
		int lineCount=0;
		int sentanceCount=0;
		int wordCount=0;
		int charCount=0;
		try {
			FileReader reader=new FileReader(file);
			BufferedReader Br=new BufferedReader(reader);
			String line=Br.readLine();
			System.out.println("The Content:");
			while(line!=null)
			{
				String[] sentance=line.split("[.]");
				sentanceCount+=sentance.length;
				String[] word=line.split(" ");
				wordCount+=word.length;
				System.out.println("\t"+line);
				charCount+=line.length();
				line=Br.readLine();
				++lineCount;
			}
			System.out.println("No of Lines:"+lineCount);
			System.out.println("No of sentances:"+sentanceCount);
			System.out.println("No of words:"+wordCount);
			System.out.println("No of characters:"+charCount);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public void reWriteFile(String input)
	{
		try {
			FileWriter fw=new FileWriter(file);
			BufferedWriter b=new BufferedWriter(fw);
			b.write(input);
			b.flush();
			System.out.println("Contents ReWriten");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void writeFile(String input)
	{
		FileWriter writer;
		try {
			writer = new FileWriter(file,true);
			BufferedWriter Bw=new BufferedWriter(writer);
			Bw.write(input);
			Bw.flush();
			System.out.println("String Appended Successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		int option;
		int flag=0;
		String inp;
		FileHandling ob=new FileHandling();
		Scanner in=new Scanner(System.in);
		do {
			
			System.out.println("Welcome to File Handler");
			System.out.println("1.Read a File");
			System.out.println("2.Rewrite a File");
			System.out.println("3.Append to the Existing File");
			System.out.println("Enter the operations you want to perform:");
			option=in.nextInt();
			switch(option)
			{	
			case 1:
			{
				ob.readFile();	
				break;
			}
			case 2:
			{
				System.out.println("\t Note:This will erase existing contents in the file!!!");
				System.out.println("Enter the String to be rewrited:");
				inp=in.next();
				ob.reWriteFile(inp);
				break;
				
			}				
			case 3:
			{
				System.out.println("Enter the String to Append:");
				inp=in.next();
				ob.writeFile(inp);
				break;
			}
				
			default:
				System.out.println("Invalid Option.");
				flag=1;
				break;
			}
		}
		while(flag==1);

	}

}
