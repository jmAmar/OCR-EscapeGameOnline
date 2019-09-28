package com.ocr.gameplay_studio;

import java.util.*;

public class ChallengerMode extends AbstractMode
{
    public ChallengerMode()
    {   super();
        combinaison = new int[nbChiffres];
        serieJoueur = new int[nbChiffres];
        System.out.print(Wording.DESCRIPTION_CHALLENGER);
        showMenu();
    }
    /**/

    protected void setCombination()
    {   Random random = new Random();
        for (int i = 0; i < nbChiffres; i++)
            combinaison[i] = random.nextInt(9+1);
    }
    /**/

    protected void showCombination()
    {   String chiffresCombinaison = "";
        for(int i = 0; i < combinaison.length; i++)
            chiffresCombinaison += combinaison[i];
        System.out.println("\n\tcombinaison \t:  " + chiffresCombinaison);
    }
    /**/

    protected void showMenu()
    {   System.out.print(Wording.MENU_PARTIE_CHALLENGER);
        System.out.print("\n\n\t\t\tvotre choix ?  ");
        try { choix = scanner.nextInt(); }
        catch(Exception Err) {}
        System.out.print("\t\t\tvotre choix :  " + String.valueOf(choix));
        switch(choix)
        {   case 1:
            {   System.out.println("  --Lancer la Partie--");
                setCombination();
                showCombination();;
                scanner.nextLine();
                this.runMatch();
                break;
            }
            case 2:
            {   System.out.println("  --Quitter la Partie--");
                new EscapeGameOnline().selectGameMode();
                break;
            }
            case 3:
            {   System.out.print("  --Quitter Challenger--");
                ModeSelection selection = new ModeSelection();
                selection.selectMode();
                break;
            }
            case 9:
            {   System.out.print("  --Quitter le Jeu--");
                System.out.print(Wording.AU_REVOIR);
                this.exitMode();
                System.exit(0);
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
    {   System.out.print("\n\t! saisie de " + nbChiffres + " chiffres entre 0 et 9 !\n");
        for(int i = 0; i < nbEssais; i++)
        {   System.out.print("\n\t--essai no." + (i+1) + "--\n");
            String resultat = this.runTest();
            //System.out.print("\tresultat \t\t:  " + resultat + "\n");
            System.out.print(showResult(resultat) + "\n");
            if(resultat.equals("===="))
            {
                System.out.print("\t! partie gagnée ! félicitations !");
                this.showMenu();
                break;
            }
        }
    }
    /**/

    protected String runTest()
    {   resultatEssai = "";
        this.inputTest();
        serieChiffres = reponseJoueur.split("");
        for(int i = 0; i < nbChiffres; i++)
            serieJoueur[i] = Integer.parseInt(serieChiffres[i]);
        return this.computeTest();
    }
    /**/

    protected String computeTest()
    {   for (int i = 0; i < nbChiffres; i++)
        {   if (combinaison[i] == serieJoueur[i])
                resultatEssai += "=";
            else if (combinaison[i] < serieJoueur[i])
                resultatEssai += "-";
            else
             resultatEssai += "+";
        }
        return resultatEssai;
    }
    /**/

    protected void inputTest()
    {   System.out.print("\tvos " + nbChiffres + " chiffres\t?  ");
        reponseJoueur = scanner.nextLine();
        if(reponseJoueur.length() < nbChiffres)
            this.inputTest();
        if(reponseJoueur.length() > nbChiffres)
        {   reponseJoueur = reponseJoueur.substring(0, nbChiffres);
            System.out.print("\tvos " + nbChiffres + " chiffres\t:  " + reponseJoueur + "\n");
        }
        for(int i = 0; i < reponseJoueur.length(); i++)
        {   char chr = reponseJoueur.charAt(i);
            if(! Character.isDigit(chr))
            {   this.inputTest();
                break;
            }
        }
    }
    /**/

}
/**/
