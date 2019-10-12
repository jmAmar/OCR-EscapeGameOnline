package com.ocr.gameplay_studio;

import java.util.HashMap;
import java.util.Scanner;

public class GameExecution
{
	protected static Scanner scanner;
	protected ModeSelection modeSelection;

	protected void start()
	{   this.showWelcome();
		scanner = new Scanner(System.in);
		this.setSetting();
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
	{   System.out.println(GameSetting.getIsDescriptionEnable());
		if(GameSetting.settingHashmap.get("IS_DESCRIPTION_ENABLE").equals("true")) { System.out.print(GameWording.DESCRIPTION_JEU); }
	}

	protected void showSetting()
	{   System.out.print("\n\n\t\t** Paramétrage du Jeu **\n");
		GameSetting.showSetting();
	}
	/**/

	protected void setSetting()
	{   GameSetting.readProperties();
		GameSetting.setIsDescriptionEnable();
		GameSetting.setNumberOfTrials();
		GameSetting.setNumberOfDigits();
	}
	/**/

	protected void newSetting()
	{   GameSetting.showMenu();
	}
	/**/

	protected void changeSetting()
	{   System.out.print("\n* Modifier ces Paramètres (O/N)\t\t?  ");
		String reponseJoueur = scanner.next();
		reponseJoueur = reponseJoueur.toUpperCase();
		System.out.print("* Modifier ces Paramètres (O/N)\t\t:  " + reponseJoueur + "\n");
		if(reponseJoueur.equals("O")) { this.newSetting(); }
	}
	/**/

	protected void selectMode()
	{   modeSelection.selectMode();
	}
	/**/

	protected void changeMode()
	{   modeSelection.selectMode();}
	/**/

	protected void quit()
	{   scanner.close();
		System.out.print(GameWording.AU_REVOIR);
		System.exit(0);
	}
	/**/

}
/**/