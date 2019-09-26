package com.ocr.gameplay_studio;

import java.util.*;

public class ChallengerMode extends AbstractMode
{
    private int nbChiffres = 4;
    private int[] combinaison;
    private int[] serieJoueur;
    private int nbEssais = nbChiffres * 2;

    public ChallengerMode()
    {   super();
        combinaison = new int[nbChiffres];
        serieJoueur = new int[nbChiffres];
        System.out.print(Wording.DESCRIPTION_CHALLENGER);
        showMenu();
    }
    /**/

    protected void setCombination()
    {   for (int i = 0; i < nbChiffres; i++)
            combinaison[i] = getRandom();
    }
    /**/

    protected int getRandom()
    {   int x = (int)(Math.random() * 10);
        while(x == 0)
            x = getRandom();
        return(x);
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
                showCombination();
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
                selection.selectGameMode();
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
                break;
            }
        }
    }
    /**/

    protected void runMatch()
    {   System.out.print("\n\t! saisie de " + nbChiffres + " chiffres entre 1 et 9 !\n");
        for(int i = 0; i < nbEssais; i++)
        {   System.out.print("\n\t--essai no." + (i+1) + "--\n");
            String resultat = this.runTest();
            System.out.print("\tresultat \t\t:  " + resultat + "\n");
            if(resultat.equals("===="))
            {
                System.out.print("\t! partie gagnée ! félicitations !");
                this.showMenu();
                break;
            }
            else
            {   System.out.print("\tnouvel essai (O/N)\t?  ");
                String reponse = scanner.nextLine(); reponse = scanner.nextLine();
                if (!reponse.equals("O") && !reponse.equals("o"))
                {   showMenu();
                    break;
                }
            }
        }
    }
    /**/

    protected String runTest()
    {   for (int i = 0; i < nbChiffres; i++)
        {   System.out.print("\tchiffre no." + (i+1) + "/" + nbChiffres + "\t?  ");
            int chiffre = scanner.nextInt();
            serieJoueur[i] = chiffre;
        }
        return this.computeTest();
    }
    /**/

    protected String computeTest()
    {   String resultatEssai = "";
        for (int i = 0; i < nbChiffres; i++)
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

}
/**/
