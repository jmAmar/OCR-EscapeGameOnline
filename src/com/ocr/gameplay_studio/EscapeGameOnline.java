package com.ocr.gameplay_studio;

public class EscapeGameOnline
{
    public static void main(String[] argS)
   {
       EscapeGameOnline game = new EscapeGameOnline();
       game.showGameWelcome();
       game.showGameDescription();
       game.selectGameMode();
   }
   /**/

    void showGameWelcome()
    {   System.out.println(Wording.BIENVENUE);
    }
    /**/

    void selectGameMode()
    {   ModeSelection selection = new ModeSelection();
        selection.selectMode();
    }
    /**/

    void showGameEnding()
    {   System.out.print(Wording.AU_REVOIR);
    }
    /**/

    void showGameDescription()
    {   System.out.print(Wording.DESCRIPTION_JEU);
    }
    /**/

}
/**/
