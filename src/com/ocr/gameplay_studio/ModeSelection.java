package com.ocr.gameplay_studio;

import java.util.Scanner;

public class ModeSelection
{
    private Scanner scanner ;
    private int choix = -1;

    public ModeSelection()
    {   scanner = new Scanner(System.in);
        System.out.print(Wording.MENU_JEU);
    }

    public void selectGameMode()
    {   System.out.print("\n\n\t\tvotre choix ?  ");
        try { choix = scanner.nextInt(); }
        catch(Exception Err) {}
        System.out.print("\t\tvotre choix :  " + String.valueOf(choix));
        switch(choix)
        {   case 9:
            {   System.out.print("  --QUITTER le Jeu--");
                System.out.print(Wording.AU_REVOIR);
                scanner.close();
                System.exit(0);
                break;
            }
            case 1:
            {   System.out.println("  --CHALLENGER--");
                ChallengerMode challenger = new ChallengerMode();
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
                System.out.print("\n  ! choix invalide !");
                new EscapeGameOnline().selectGameMode();
                break;
            }
        }
    }
    /**/

}
/**/
