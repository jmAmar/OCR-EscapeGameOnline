package com.ocr.gameplay_studio;

import java.util.*;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class GameSetting
{
	protected static final String ESCAPE_GAME_ONLINE_PROPERTIES = "EscapeGameOnline.properties";
	protected static final String IS_DESCRIPTION_ENABLE = "IS_DESCRIPTION_ENABLE";
	protected static final String NUMBER_OF_TRIALS = "NUMBER_OF_TRIALS";
	protected static final String NUMBER_OF_DIGITS = "NUMBER_OF_DIGITS";
	//
	protected static boolean isDescriptionEnable;
	protected static int numberOfTrials;
	protected static int numberOfDigits;
	//
	protected static HashMap<String,String> settingHashmap;


	protected static void showMenu()
	{   newIsDescriptionEnable();
		newNumberOfTrials();
		newNumberOfDigits();
		saveSetting();
	}
	/**/

	protected static void setIsDescriptionEnable()
	{   isDescriptionEnable = Boolean.valueOf(settingHashmap.get(IS_DESCRIPTION_ENABLE));
	}
	/**/
	protected static void newIsDescriptionEnable()
	{   System.out.print("\n- Afficher les Descriptions (O/N)\t?  ");
		String reponse = GameExecution.scanner.next();
		reponse = reponse .toUpperCase();
		if(reponse.equals("N")) { isDescriptionEnable = false; }
		else { isDescriptionEnable = true; }
	}
	/**/
	protected static boolean getIsDescriptionEnable()
	{   return(isDescriptionEnable);
	}
	/**/

	protected static void setNumberOfTrials()
	{   numberOfTrials = Integer.valueOf(settingHashmap.get(NUMBER_OF_TRIALS));
	}
	/**/
	protected static void newNumberOfTrials()
	{   System.out.print("- Nombre d'Essais / Partie\t\t\t?  ");
		try
		{   numberOfTrials = GameExecution.scanner.nextInt();
			if(numberOfTrials <= 0 || numberOfTrials > 10)
				numberOfTrials = 10;
		}
		catch(Exception Err)
		{   System.out.print("\t! saisie incorrecte !");
			GameExecution.scanner.next();
			setNumberOfTrials();
		}
	}
	/**/
	protected static int getNumberOfTrials()
	{	return(numberOfTrials);
	}
	/**/

	protected static void setNumberOfDigits()
	{   numberOfDigits = Integer.valueOf(settingHashmap.get(NUMBER_OF_DIGITS));
	}
	/**/
	protected static void newNumberOfDigits()
	{   System.out.print("- Nombre de Chiffres / Combinaison\t?  ");
		try
		{   numberOfDigits = GameExecution.scanner.nextInt();
			if (numberOfDigits <= 0 || numberOfDigits > 10)
				numberOfDigits = 4;
		}
		catch(Exception Err)
		{   System.out.print("\t! saisie incorrecte !");
			GameExecution.scanner.next();
			setNumberOfDigits();
		}
	}
	/**/
	public static int getNumberOfDigits()
	{	return(numberOfDigits);
	}
	/**/

	protected static void saveSetting()
	{   Properties properties = new Properties();
		try
		{   properties.setProperty(IS_DESCRIPTION_ENABLE, String.valueOf(getIsDescriptionEnable()));
			properties.setProperty(NUMBER_OF_TRIALS, String.valueOf(getNumberOfTrials()));
			properties.setProperty(NUMBER_OF_DIGITS, String.valueOf(getNumberOfDigits()));
			properties.store(new FileOutputStream(ESCAPE_GAME_ONLINE_PROPERTIES) ,  "EscapeGameOnline Properties");
		}
		catch(IOException ioE)
		{   ioE.printStackTrace();
		}
	}
	/**/


	protected static void readProperties()
	{   Properties properties = new Properties();
		settingHashmap = new HashMap<>();
		try
		{   properties.load(new FileInputStream(ESCAPE_GAME_ONLINE_PROPERTIES));
			settingHashmap.put(IS_DESCRIPTION_ENABLE, properties.getProperty(IS_DESCRIPTION_ENABLE, "true"));
			settingHashmap.put(NUMBER_OF_TRIALS, properties.getProperty(NUMBER_OF_TRIALS, "10"));
			settingHashmap.put(NUMBER_OF_DIGITS, properties.getProperty(NUMBER_OF_DIGITS, "4"));
		}
		catch(Exception Err)
		{   Err.printStackTrace();
		}
	}
	/**/


	protected static String readProperty(String property)
	{   Properties properties = new Properties();
		try
		{   properties.load(new FileInputStream(ESCAPE_GAME_ONLINE_PROPERTIES));
		}
		catch(IOException ioE)
		{   ioE.printStackTrace();
		}
		return(properties.getProperty(property));
	}
	/**/

	protected static void showSetting()
	{   readProperties();
		String propertiesString
		= "\n- Afficher les Descriptions\t\t\t:  " +  (settingHashmap.get(IS_DESCRIPTION_ENABLE).equals("true") ? "Oui" : "Non")
		+ "\n- Nombre d'Essais / Partie\t\t\t:  " +  settingHashmap.get(NUMBER_OF_TRIALS)
		+ "\n- Nombre de Chiffres / Combinaison\t:  " +  settingHashmap.get(NUMBER_OF_DIGITS)
		;
		System.out.print(propertiesString + "\n");
	}
	/**/

}
/**/
