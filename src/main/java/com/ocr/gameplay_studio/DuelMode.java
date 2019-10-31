package com.ocr.gameplay_studio;

public class DuelMode extends AbstractMode
{
	protected ChallengerMode challenger;
	protected DefenderMode defender;
	protected String[][] resultatEssaiDuel;

	public DuelMode()
	{   super();
		resultatEssai = new String[nbEssais];
		combinaison = new int[nbChiffres];
		serieJoueur = new int[nbChiffres];
		serieEssais = new int[nbEssais][nbChiffres];
		serieCaracteres = new String[nbChiffres];
		//
		challenger = new ChallengerMode();
		defender = new DefenderMode();
		//
		resultatEssaiDuel = new String[2][nbEssais];
	}
	/**/

	protected void showDescription(boolean enabled)
	{   if(enabled == true) { System.out.print(GameWording.DESCRIPTION_DUEL); }
	}
	/**/

	protected void showMenu()
	{   System.out.print(GameWording.MENU_PARTIE_DUEL);
		System.out.print("\n\n\tvotre choix\t?  ");
		try { choix = GameExecution.scanner.nextInt(); }
		catch(Exception Err) {}
		System.out.print("\tvotre choix\t:  " + String.valueOf(choix));
		switch(choix)
		{   case 1:
			{   System.out.print("  >> Lancer la Partie");
				System.out.print("\n" + GameWording.NOUVELLE_PARTIE + "\n");
				challenger.setRandomDigits();
				defender.setPlayerDigits();
				challenger.showDeveloperMode(GameSetting.getIsDeveloperModeEnable());
				defender.showPlayerDigits();
				this.runMatch();
				break;
			}
			case 2:
			{   System.out.print("  >> Quitter la Partie");
				new GameExecution().selectMode();
				break;
			}
			case 3:
			{   System.out.print("  >> Quitter Duel\n");
				ModeSelection selection = new ModeSelection();
				selection.selectMode();
				break;
			}
			case 9:
			{   System.out.print("  >> Quitter le Jeu");
				this.exitGame();
				break;
			}
			default:
			{   System.out.print("  ! choix invalide !\n");
				new ChallengerMode();
			}
		}
	}
	/**/

	protected void runMatch()
	{   System.out.print("\n\t! partie en " + nbEssais + " essais maximum !");
		System.out.print("\n\t! combinaisons de " + nbChiffres + " chiffres !\n");
		for(noEssai = 0; noEssai < nbEssais; noEssai++)
		{   System.out.print("\n\t--essai no." + (noEssai+1) + "--\n");
			resultatEssaiDuel[0][noEssai] = "";
			resultatEssaiDuel[0][noEssai] = challenger.runTrial(noEssai);
			System.out.print(challenger.showResult(resultatEssaiDuel[0][noEssai], "joueur ")+ "\n");
			resultatEssaiDuel[1][noEssai] = "";
			resultatEssaiDuel[1][noEssai] = defender.runTrial(noEssai);
			System.out.print(defender.showResult(resultatEssaiDuel[1][noEssai], "logiciel") + "\n");
			if(resultatEssaiDuel[0][noEssai].equals("====") && resultatEssaiDuel[1][noEssai].equals("===="))
			{   System.out.print("\n\t! partie gagnée par le joueur et le logiciel en " + (noEssai+1) + " essais ! égalité !\n");
				this.showMenu();
				break;
			}
			else if(resultatEssaiDuel[0][noEssai].equals("===="))
			{   System.out.print("\n\t! partie gagnée par le joueur en " + (noEssai+1) + " essais ! félicitations !\n");
				this.showMenu();
				break;
			}
			else if(resultatEssaiDuel[1][noEssai].equals("===="))
			{   System.out.print("\n\t! partie gagnée par le logiciel en " + (noEssai+1) + " essais ! désolé !\n");
				this.showMenu();
				break;
			}

		}
	}
	/**/

	protected String runTrial(int noEssai)
	{
		return("toto");
	}
	/**/
}
/**/
