package com.ocr.gameplay_studio;

import java.util.Scanner;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class GameSetting
{
	protected static String parametreDescription;
	protected static int nombreEssais;
	protected static int nombreChiffres;


	public GameSetting()
	{   parametreDescription    = "O";
		nombreEssais            = 10;
		nombreChiffres          = 4;
	}
	/**/

	public static void showMenu()
	{   setDescriptionParameter();
		setNumberOfTrials();
		setNumberOfDigits();
		saveSetting();
	}
	/**/

	public static void setDescriptionParameter()
	{   System.out.print("\n- Afficher les Descriptions (O/N)\t?  ");
		parametreDescription = GameExecution.scanner.next();
		parametreDescription = parametreDescription.toUpperCase();
		if(!parametreDescription.equals("N"))
			parametreDescription = "O";
		System.out.print("- Afficher les Descriptions (O/N)\t:  " + parametreDescription + "\n");
	}
	/**/
	public static String getDescriptionParameter()
	{   return(parametreDescription);
	}
	/**/

	public static void setNumberOfTrials()
	{   System.out.print("\n- Nombre d'Essais / Partie\t\t\t?  ");
		try
		{   nombreEssais = GameExecution.scanner.nextInt();
			if(nombreEssais <= 0 || nombreEssais > 10)
				nombreEssais = 10;
			System.out.print("- nombre d'Essais / Partie\t\t\t:  " + nombreEssais + "\n");
		}
		catch(Exception Err)
		{   System.out.print("\t! saisie incorrecte !");
			GameExecution.scanner.next();
			setNumberOfTrials();
		}
	}
	/**/
	public static String getNumberOfTrials()
	{	return(String.valueOf(nombreEssais));
	}
	/**/

	public static void setNumberOfDigits()
	{
		System.out.print("\n- Nombre de Chiffres / Combinaison\t?  ");
		try
		{
			nombreChiffres = GameExecution.scanner.nextInt();
			if (nombreChiffres <= 0 || nombreChiffres > 10)
				nombreChiffres = 4;
			System.out.print("- Nombre de Chiffres / Combinaison\t:  " + nombreChiffres + "\n");
		}
		catch(Exception Err)
		{   System.out.print("\t! saisie incorrecte !");
			GameExecution.scanner.next();
			setNumberOfDigits();
		}
	}
	/**/
	public static String getNumberOfDigits()
	{	return(String.valueOf(nombreChiffres));
	}
	/**/

	protected static void saveSetting()
	{   Properties properties = new Properties();
		try
		{   properties.setProperty("parametreDescription", getDescriptionParameter());
			properties.setProperty("nombreEssais", String.valueOf(getNumberOfTrials()));
			properties.setProperty("nombreChiffres", String.valueOf(getNumberOfDigits()));
			properties.store(new FileOutputStream("EscapeGameOnline.properties") ,  "EscapeGameOnline Properties");
		}
		catch(IOException ioE)
		{   ioE.printStackTrace();
		}
	}
	/**/

	protected static String readProperties()
	{   Properties properties = new Properties();
		String propertiesString = "";
		try
		{
			properties.load(new FileInputStream("EscapeGameOnline.properties"));
			//
			propertiesString
			+= "- Afficher les Descriptions\t\t\t:  "
			+  properties.getProperty("parametreDescription", "O") + "\n"
			;
			propertiesString
			+= "- Nombre d'Essais / Partie\t\t\t:  "
			+  properties.getProperty("nombreEssais", "10") + "\n"
			;
			propertiesString
			+= "- Nombre de Chiffres / Combinaison\t:  "
			+  properties.getProperty("nombreChiffres", "4") + "\n"
			;
		}
		catch(IOException ioE)
		{   ioE.printStackTrace();
		}
		return(propertiesString);
	}
	/**/

	protected static String readProperty(String property, String value)
	{   Properties properties = new Properties();
		try
		{   properties.load(new FileInputStream("EscapeGameOnline.properties"));
		}
		catch(IOException ioE)
		{   ioE.printStackTrace();
		}
		return(properties.getProperty(property, value));
	}
	/**/

}
/**/
