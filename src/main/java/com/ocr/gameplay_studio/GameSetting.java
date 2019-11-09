package com.ocr.gameplay_studio;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author JMichel AMAR
 * @version 1.0
 *
 * Manages the game setting parameters
 */
public class GameSetting
{
	protected static final String ESCAPE_GAME_ONLINE_PROPERTIES = "EscapeGameOnline.properties";
	protected static final String IS_DEVElOPER_MODE_ENABLE = "IS_DEVElOPER_MODE_ENABLE";
	protected static final String IS_DESCRIPTION_ENABLE = "IS_DESCRIPTION_ENABLE";
	protected static final String NUMBER_OF_TRIALS = "NUMBER_OF_TRIALS";
	protected static final String NUMBER_OF_DIGITS = "NUMBER_OF_DIGITS";
	//
	protected static boolean isDeveloperModeEnable;
	protected static boolean isDescriptionEnable;
	protected static int numberOfTrials;
	protected static int numberOfDigits;
	//
	protected static Map<String,String> settingHashmap;

	/**
	 * @see GameExecution#loadSetting()
	 */
	protected static void showMenu()
	{   newIsDeveloperModeEnable();
		newIsDescriptionEnable();
		newNumberOfTrials();
		newNumberOfDigits();
		saveSetting();
	}
	/**/

	protected static void setIsDeveloperModeEnable()
	{   isDeveloperModeEnable = Boolean.valueOf(settingHashmap.get(IS_DEVElOPER_MODE_ENABLE));
	}
	/**/
	protected static void newIsDeveloperModeEnable()
	{   System.out.print("\n- Mode Développeur (O/N)\t\t?  ");
		String reponse = GameExecution.scanner.next().toUpperCase();
		if(reponse.equals("O")) { isDeveloperModeEnable = true; }
		else { isDeveloperModeEnable = false; }
	}
	/**/
	protected static boolean getIsDeveloperModeEnable()
	{   return(isDeveloperModeEnable);
	}
	/**/

	protected static void setIsDescriptionEnable()
	{   isDescriptionEnable = Boolean.valueOf(settingHashmap.get(IS_DESCRIPTION_ENABLE));
	}
	/**/
	protected static void newIsDescriptionEnable()
	{   System.out.print("- Afficher les Descriptions (O/N)\t?  ");
		String reponse = GameExecution.scanner.next().toUpperCase();
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
	{   System.out.print("- Nombre d'Essais / Partie\t\t?  ");
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

	protected static void readProperties()
	{   Properties properties = new Properties();
		settingHashmap = new HashMap<>();
		try
		{   File propertiesFile = new File(ESCAPE_GAME_ONLINE_PROPERTIES);
			if(propertiesFile.exists())
			{   try
				{   FileInputStream inStream = new FileInputStream(propertiesFile);
					properties.load(inStream);
				}
				catch (FileNotFoundException fnfE) { fnfE.printStackTrace(); }
			}
			else
			{   InputStream inStream = GameSetting.class.getClassLoader().getResourceAsStream(ESCAPE_GAME_ONLINE_PROPERTIES);
				properties.load(inStream);
			}
			settingHashmap.put(IS_DEVElOPER_MODE_ENABLE, properties.getProperty(IS_DEVElOPER_MODE_ENABLE, "false"));
			settingHashmap.put(IS_DESCRIPTION_ENABLE, properties.getProperty(IS_DESCRIPTION_ENABLE, "true"));
			settingHashmap.put(NUMBER_OF_TRIALS, properties.getProperty(NUMBER_OF_TRIALS, "10"));
			settingHashmap.put(NUMBER_OF_DIGITS, properties.getProperty(NUMBER_OF_DIGITS, "4"));
		}
		catch(Exception Err)
		{   Err.printStackTrace();
		}
	}
	/**/

	protected static void showSetting()
	{   readProperties();
		String propertiesString
		= "\n\t\t** Paramétrage du Jeu **"
		+ "\n- Mode Développeur\t\t\t:  " +  (settingHashmap.get(IS_DEVElOPER_MODE_ENABLE).equals("true") ? "Oui" : "Non")
		+ "\n- Afficher les Descriptions\t\t:  " +  (settingHashmap.get(IS_DESCRIPTION_ENABLE).equals("true") ? "Oui" : "Non")
		+ "\n- Nombre d'Essais / Partie\t\t:  " +  settingHashmap.get(NUMBER_OF_TRIALS)
		+ "\n- Nombre de Chiffres / Combinaison\t:  " +  settingHashmap.get(NUMBER_OF_DIGITS)
		;
		System.out.print(propertiesString + "\n");
	}
	/**/

	protected static void editSetting()
	{   boolean validiteReponse = true;
		System.out.print("\n* Modifier ces Paramètres (O/N)\t\t?  ");
		String reponseJoueur = GameExecution.scanner.next().toUpperCase();
		if(!reponseJoueur.equals("O") && !reponseJoueur.equals("N"))
		{   reponseJoueur += "  >> ! saisie incorrecte !";
			validiteReponse = false;
		}
		System.out.print("* Modifier ces Paramètres (O/N)\t\t:  " + reponseJoueur + "\n");
		if(reponseJoueur.equals("O")) { showMenu(); }
		else if(validiteReponse == false) { showSetting(); editSetting(); }
	}
	/**/

	protected static void saveSetting()
	{   Properties properties = new Properties();
		try
		{   properties.setProperty(IS_DEVElOPER_MODE_ENABLE, String.valueOf(getIsDeveloperModeEnable()));
			properties.setProperty(IS_DESCRIPTION_ENABLE, String.valueOf(getIsDescriptionEnable()));
			properties.setProperty(NUMBER_OF_TRIALS, String.valueOf(getNumberOfTrials()));
			properties.setProperty(NUMBER_OF_DIGITS, String.valueOf(getNumberOfDigits()));
			File propertiesFile = new File(ESCAPE_GAME_ONLINE_PROPERTIES);
			properties.store(new FileOutputStream(propertiesFile) ,  "EscapeGameOnline Properties");
		}
		catch(IOException ioE)
		{   ioE.printStackTrace();
		}
	}
	/**/

}
/**/
