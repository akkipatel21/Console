package com.esense;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Db.Database;

public class WordCounter
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
	{
		File file = new File("d:\\jsonInput.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String str = null;
		// Statement statement = Database.getConnection().createStatement();
		while ((str = bufferedReader.readLine()) != null)
		{
			Set<String> uniqueWords = new HashSet<String>();

			String[] words = str.split("[ \\[“”\\-'\"\n\\t\\r.,;:!?(){}]");
			//System.out.println(words[69]);
			for (String word : words)
			{
				if (!word.equals("") && !word.equals(" "))
					uniqueWords.add(word.toLowerCase());
			}
			for (String s : uniqueWords)
			{
				Pattern p1 = Pattern.compile(s);
				Matcher m = p1.matcher(str.toLowerCase());
				int count = 0;
				while (m.find())
				{
					count++;
				}
				// statement.executeUpdate("insert into counttable (word,count) values('" + s +"','" + count + "')");
				System.out.println(s + " = " + count);
			}
		}
		bufferedReader.close();
	}
}
