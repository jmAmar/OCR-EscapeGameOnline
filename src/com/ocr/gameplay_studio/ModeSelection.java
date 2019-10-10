package com.ocr.gameplay_studio;

import java.util.Scanner;

public class ModeSelection
{
    //private Scanner scanner ;
    private int choix = -1;

    public ModeSelection()
    {   //scanner = new Scanner(System.in);
    }

    public void selectMode()
    {   System.out.print(GameWording.MENU_JEU);
        System.out.print("\n\n\t\tvotre choix ?  ");
        try { choix = GameExecution.scanner.nextInt(); }
        catch(Exception Err) {}
        System.out.print("\t\tvotre choix :  " + String.valueOf(choix));
        switch(choix)
        {   case 9:
            {   System.out.print("  >> QUITTER le Jeu");
                System.out.print(GameWording.AU_REVOIR);
                GameExecution.scanner.close();
                System.exit(0);
                break;
            }
            case 1:
            {   System.out.println("  >> CHALLENGER");
                ChallengerMode challenger = new ChallengerMode();
                challenger.showDescription(GameSetting.parametreDescription.equals("O") ? true : false);
                challenger.showMenu();
                break;
            }
            case 2:
            {   System.out.println("  >> DEFENDER");
                DefenderMode defender = new DefenderMode();
                defender.showDescription(GameSetting.parametreDescription.equals("O") ? true : false);
                defender.showMenu();
                break;
            }
            case 3:
            {   System.out.println("  >> DUEL");
                DuelMode duel = new DuelMode();
                duel.showDescription(GameSetting.parametreDescription.equals("O") ? true : false);
                duel.showMenu();
                break;
            }
            default:
            {   System.out.print("\n  ! choix invalide !");
                new GameExecution().selectMode();
                break;
            }
        }
    }
    /**/

}
/**/
