package com.ocr.gameplay_studio;

import java.util.Scanner;

public class GameExecution
{
	protected static Scanner scanner;
	protected ModeSelection modeSelection;

	void start()
	{   this.showWelcome();
		scanner = new Scanner(System.in);
		new GameSetting();
		this.showDescription();
		this.showSetting();
		this.changeSetting();
		modeSelection = new ModeSelection();
		this.selectMode();
	}

	void showWelcome()
	{   System.out.println(GameWording.BIENVENUE);
	}
	/**/

	void showDescription()
	{   GameSetting.parametreDescription = GameSetting.readProperty("parametreDescription" , GameSetting.getDescriptionParameter());
		if(GameSetting.parametreDescription.equals("O")) { System.out.print(GameWording.DESCRIPTION_JEU); }
	}

	void showSetting()
	{   System.out.print("\n\n\t\t** Paramétrage du Jeu **\n");
		System.out.print(GameSetting.readProperties());
	}
	/**/

	void setSetting()
	{   GameSetting.showMenu();
	}
	/**/

	void changeSetting()
	{   System.out.print("\n* Modifier ces Paramètres (O/N)\t?  ");
		String reponseJoueur = scanner.next();
		reponseJoueur = reponseJoueur.toUpperCase();
		System.out.print("* Modifier ces Paramètres (O/N)\t:  " + reponseJoueur + "\n");
		if(reponseJoueur.equals("O")) { this.setSetting(); }
	}
	/**/

	void readSetting()
	{}

	void selectMode()
	{   modeSelection.selectMode();
	}
	/**/

	void changeMode()
	{   modeSelection.selectMode();}
	/**/

	void quit()
	{   scanner.close();
		System.out.print(GameWording.AU_REVOIR);
		System.exit(0);
	}
	/**/

}
/**/