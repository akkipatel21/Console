package com.esense;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo
{
	public static void destination(String destination) throws IOException

	{
		File file = new File(destination);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String str = null;
		while ((str = bufferedReader.readLine()) != null)
		{
			Set<String> uniqueWords = new HashSet<String>();
			String[] words = str.split("[ \\[“”\\-'\"\n\\t\\r.,;:!?(){}]");
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
				System.out.println(s + " = " + count);
			}

		}
		bufferedReader.close();
	}

}
