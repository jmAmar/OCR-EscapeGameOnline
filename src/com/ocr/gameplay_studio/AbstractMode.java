package com.ocr.gameplay_studio;

import javax.swing.*;
import java.util.Scanner;

public abstract class AbstractMode
{
    protected Scanner scanner;
    protected int choix = -1;
    protected int nbChiffres = 4;
    protected int noChiffre = 1;
    protected int nbEssais = 5;
    protected int noEssai = 1;
    protected int[][] serieEssais;
    protected int[] combinaison;
    protected int[] serieJoueur;
    protected String saisieJoueur = "";
    protected String[] resultatEssai;
    protected String[] serieChiffres;
    protected String caractere = "";
    protected String[] serieCaracteres;
    ;

    public AbstractMode()
    {   scanner = new Scanner(System.in);
    }
    /**/

    protected abstract void showMenu();
    protected abstract void runMatch();
    protected abstract String runTrial(int noEssai);

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

    public void exitGame()
    {   System.out.print(Wording.AU_REVOIR);
        this.exitMode();
        System.exit(0);
    }
    /**/

    protected void inputDigits()
    {   System.out.print("\n\tvos " + nbChiffres + " chiffres\t?  ");
        saisieJoueur = scanner.next();
        //System.out.println(saisieJoueur + "  " + saisieJoueur.length());
        if(saisieJoueur.length() < nbChiffres)
            this.inputDigits();
        if(saisieJoueur.length() > nbChiffres)
            saisieJoueur = saisieJoueur.substring(0, nbChiffres);
        for(int i = 0; i < saisieJoueur.length(); i++)
        {   char chr = saisieJoueur.charAt(i);
            if(! Character.isDigit(chr))
            {   this.inputDigits();
                break;
            }
        }
    }
    /**/

    protected void convertDigits()
    {   serieChiffres = saisieJoueur.split("");
        for(int i = 0; i < nbChiffres; i++)
            serieJoueur[i] = Integer.parseInt(serieChiffres[i]);
    }
    /**/
}
/**/
