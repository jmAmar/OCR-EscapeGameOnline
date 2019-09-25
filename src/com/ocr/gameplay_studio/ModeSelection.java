package com.ocr.gameplay_studio;

import java.util.Scanner;

public class ModeSelection
{
    private Scanner scn ;
    private int chx;

    public ModeSelection()
    {   scn = new Scanner(System.in);
        chx = 0;
        System.out.print(Wording.MENU_JEU);
    }

    public void selectGameMode()
    {   System.out.print("\n\n\t\tvotre choix ?  ");
        try { chx = scn.nextInt(); }
        catch(Exception Err) {}
        System.out.print("\t\tvotre choix :  " + String.valueOf(chx));
        switch(chx)
        {   case 9:
            {   System.out.print("  --QUITTER le Jeu--");
                System.out.print(Wording.AU_REVOIR);
                break;
            }
            case 1:
            {   System.out.println("  --CHALLENGER--");
                ChallengerMode challenger = new ChallengerMode();
                challenger.setCombination();
                challenger.runChallengertSet();
                break;
            }
            case 2:
            {   System.out.println("  --DEFENDER--");
            break;
            }
            case 3:
            {   System.out.println("  --DUEL--");
                break;
            }
            default:
            {
                System.out.print("  ! choix invalide !");
                new EscapeGameOnline().selectGameMode();
            }
        }
    }
    /**/

}
/**/
