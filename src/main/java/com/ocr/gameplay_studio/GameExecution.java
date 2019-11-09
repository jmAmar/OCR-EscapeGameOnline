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
		GameLogging.logInfo("Scanner start");
		scanner = new Scanner(System.in);
		this.showWelcome();
		this.loadSetting();
		this.showDescription();
		this.showSetting();
		this.editSetting();
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
	{  GameSetting.showSetting();
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

	protected void editSetting()
	{   GameSetting.editSetting();
	}
	/**/

	protected void selectMode()
	{   ModeSelection modeSelection = new ModeSelection();
		modeSelection.selectMode();
	}
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