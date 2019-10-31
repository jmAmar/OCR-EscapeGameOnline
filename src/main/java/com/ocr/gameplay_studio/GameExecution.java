package com.ocr.gameplay_studio;

import java.util.Scanner;

/**
 * @author JMichel AMAR
 * @version 1.0
 *
 * Executes the EscapeGameOnline game
 */
public class GameExecution
{
	protected static Scanner scanner;
	protected ModeSelection modeSelection;

	/**
	 * When the game starts :
	 * - displays a welcome message
	 * - initializes a data input tool : java.util.Scanner object
	 * - reads the parameters stored in a Java .properties file (EscapeGameOnline.properties located in the same directory as the .java files)
	 * - displays a game description if the related parameter is set to "oui" (yes)
	 * - displays all the parameters read from the properties file
	 * - asks if the player wishes to change the game parameters
	 * - instantiates the ModeSelection class
	 * - calls the ModeSelection#selectMode() method
	 */
	protected void start()
	{   GameLogging.logInfo("Game Start");
		this.showWelcome();
		GameLogging.logInfo("Scanner start");
		scanner = new Scanner(System.in);
		this.loadSetting();
		this.showDescription();
		this.showSetting();
		this.changeSetting();
		modeSelection = new ModeSelection();
		this.selectMode();
	}

	protected void showWelcome()
	{   System.out.println(GameWording.BIENVENUE);
	}
	/**/

	protected void showDescription()
	{   if(GameSetting.settingHashmap.get("IS_DESCRIPTION_ENABLE").equals("true"))
		{ System.out.print(GameWording.DESCRIPTION_JEU); }
	}

	protected void showSetting()
	{   System.out.print("\n\t\t** Paramétrage du Jeu **");
		GameSetting.showSetting();
	}
	/**/

	/**
	 * reads all the parameters stored within the EscapeGameOnline.properties file
	 * for each parameter asks the player to input a new value or the old value
	 */
	protected void loadSetting()
	{   GameLogging.logInfo("Setting Load from propertiesFile");
		GameSetting.readProperties();
		GameSetting.setIsDeveloperModeEnable();
		GameSetting.setIsDescriptionEnable();
		GameSetting.setNumberOfTrials();
		GameSetting.setNumberOfDigits();
	}
	/**/

	protected void newSetting()
	{   GameSetting.showMenu();
	}
	/**/

	/**
	 * @see GameExecution#newSetting()
	 */
	protected void changeSetting()
	{   System.out.print("\n* Modifier ces Paramètres (O/N)\t\t?  ");
		String reponseJoueur = scanner.next().toUpperCase();
		System.out.print("* Modifier ces Paramètres (O/N)\t\t:  " + reponseJoueur + "\n");
		if(reponseJoueur.equals("O")) { this.newSetting(); }
	}
	/**/

	protected void selectMode()
	{   modeSelection.selectMode();
	}
	/**/

	/**
	 * @see GameExecution#selectMode()
	 */
	protected void changeMode()
	{   modeSelection.selectMode();}
	/**/

	protected void quit()
	{   scanner.close();
		System.out.print(GameWording.AU_REVOIR);
		GameLogging.logInfo("Game End");
		System.exit(0);
	}
	/**/

}
/**/