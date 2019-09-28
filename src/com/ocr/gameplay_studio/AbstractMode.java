package com.ocr.gameplay_studio;

import javax.swing.*;
import java.util.Scanner;

public abstract class AbstractMode
{
    protected Scanner scanner;
    protected int choix = -1;
    protected int nbChiffres = 4;
    protected int nbEssais = 3;
    protected int[] combinaison;
    protected int[] serieJoueur;
    protected String[] serieChiffres;
    protected String reponseJoueur = "";
    protected String resultatEssai = "";
    ;

    public AbstractMode()
    {   scanner = new Scanner(System.in);
    }
    /**/

    protected abstract void showMenu();
    protected abstract void runMatch();
    protected abstract void setCombination();
    protected abstract String runTest();
    protected abstract String computeTest();

    protected String showResult(String rslt)
    {   String string = "";
        for(int i = 0; i < 3; i++)
        {   if (i == 0 || i == 2)
            {   string += "\n\t\t\t\t\t   ";
                for (int j = 0; j < rslt.length() + 6; j++)
                    string += "*";
            }
            else
            {   string += "\n\t";
                string += "resultat\t\t:  *  " + rslt + "  *";
            }
        }
        return(string);
    }
    /**/

   public void exitMode()
   {   scanner.close();
   }
   /**/

}
/**/
