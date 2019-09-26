package com.ocr.gameplay_studio;

import java.util.Scanner;

public abstract class AbstractMode
{
    Scanner scanner;
    int choix = -1;

    public AbstractMode()
    {   scanner = new Scanner(System.in);
    }
    /**/

   protected abstract void runMatch();

   public void exitMode()
   {   scanner.close();
   }

}
/**/
