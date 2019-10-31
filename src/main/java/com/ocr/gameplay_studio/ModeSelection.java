package com.ocr.gameplay_studio;

/**
 * @author JMichel AMAR
 * @version 1.0
 *
 * Dispatches the player's game mode choice
 */
public class ModeSelection
{
    private int choixJoueur = -1;

    public void selectMode()
    {   GameLogging.logInfo("Mode Selection");
        System.out.print(GameWording.MENU_JEU);
        System.out.print("\n\n\tvotre choix\t?  ");
        try { choixJoueur = GameExecution.scanner.nextInt(); }
        catch(Exception Err) { GameLogging.logError("Selection Error: " + Err.getMessage()); }
        System.out.print("\tvotre choix\t:  " + String.valueOf(choixJoueur));
        switch(choixJoueur)
        {   case 9:
            {   System.out.print("  >> QUITTER le Jeu");
                System.out.print(GameWording.AU_REVOIR);
                GameExecution.scanner.close();
                GameLogging.logWarning("Scanner Close");
                GameLogging.logInfo("Game Exit");
                System.exit(0);
                break;
            }
            case 1:
            {   System.out.println("  >> CHALLENGER");
                ChallengerMode challenger = new ChallengerMode();
                GameLogging.logInfo("Challenger Mode");
                challenger.showDescription(GameSetting.getIsDescriptionEnable() ? true : false);
                challenger.showMenu();
                break;
            }
            case 2:
            {   System.out.println("  >> DEFENDER");
                DefenderMode defender = new DefenderMode();
                GameLogging.logInfo("Defender Mode");
                defender.showDescription(GameSetting.getIsDescriptionEnable() ? true : false);
                defender.showMenu();
                break;
            }
            case 3:
            {   System.out.println("  >> DUEL");
                DuelMode duel = new DuelMode();
                GameLogging.logInfo("Duel Mode");
                duel.showDescription(GameSetting.getIsDescriptionEnable() ? true : false);
                duel.showMenu();
                break;
            }
            default:
            {   System.out.print("\n  ! choix invalide !");
                GameLogging.logWarning("Invalid Input");
                new GameExecution().selectMode();
                break;
            }
        }
    }
    /**/

}
/**/
