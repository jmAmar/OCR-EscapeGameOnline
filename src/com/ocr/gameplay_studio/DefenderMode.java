package com.ocr.gameplay_studio;

import java.util.Random;

public class DefenderMode extends AbstractMode
{
    public DefenderMode()
    {   super();
        resultatEssai = new String[nbEssais];
        combinaison = new int[nbChiffres];
        serieJoueur = new int[nbChiffres];
        serieEssais = new int[nbEssais][nbChiffres];
        serieCaracteres = new String[nbChiffres];
        System.out.print(Wording.DESCRIPTION_DEFENDER);
        showMenu();
    }
    /**/

    protected void showMenu()
    {   System.out.print(Wording.MENU_PARTIE_DEFENDER);
        System.out.print("\n\n\t\t\tvotre choix ?  ");
        try { choix = scanner.nextInt(); }
        catch(Exception Err) {}
        System.out.print("\t\t\tvotre choix :  " + String.valueOf(choix));
        switch(choix)
        {   case 1:
        {   System.out.println("  >> Lancer la Partie");
            this.setPlayerDigits();
            this.showPlayerDigits();
            this.runMatch();
            break;
        }
            case 2:
            {   System.out.println("  >> Quitter la Partie");
                new EscapeGameOnline().selectGameMode();
                break;
            }
            case 3:
            {   System.out.print("  >> Quitter Defender");
                ModeSelection selection = new ModeSelection();
                selection.selectMode();
                break;
            }
            case 9:
            {   System.out.print("  >> Quitter le Jeu");
                this.exitGame();
                break;
            }
            default:
            {   System.out.print("  ! choix invalide !\n");
                new ChallengerMode();
            }
        }
    }
    /**/

    protected void setPlayerDigits()
    {   this.inputDigits();
        this.convertDigits();
    }
    /**/

    protected void showPlayerDigits()
    {   String chiffresJoueur = "";
        for(int i = 0; i < serieJoueur.length; i++)
            chiffresJoueur += serieJoueur[i];
        System.out.print("\tvos " + nbChiffres + " chiffres\t:  " + chiffresJoueur + "\n");
    }
    /**/

    protected void runMatch()
    {   for(noEssai = 0; noEssai < nbEssais; noEssai++)
        {   System.out.print("\n\t--essai no." + (noEssai+1) + "--\n");
            resultatEssai[noEssai] = "";
            resultatEssai[noEssai] = this.runTrial(noEssai);
            System.out.print("\tcombinaison\t\t:  ");
            for(noChiffre = 0; noChiffre < nbChiffres; noChiffre++)
                System.out.print(combinaison[noChiffre]);
            //System.out.print("\tresultat\t\t:  " + resultatEssai[noEssai] + "\n");
            System.out.print(showResult(resultatEssai[noEssai]) + "\n");
            if(resultatEssai[noEssai].equals("===="))
            {   System.out.print("\t! partie gagnée par le logiciel !");
                this.showMenu();
                break;
            }
        }
    }
    /**/

    protected String runTrial(int noEssai)
    {   if(noEssai == 0)
        {   for(int i = 0; i < nbChiffres; i++)
            {   combinaison[i] = 5;
                serieEssais[noEssai][i] = combinaison[i];
            }
        }
        else
        {   serieCaracteres = resultatEssai[noEssai-1].split("");
            for (noChiffre = 0; noChiffre < nbChiffres; noChiffre++)
            {   if(serieCaracteres[noChiffre].equals("-"))
                {
                    switch (serieEssais[noEssai - 1][noChiffre])
                    {
                        case 9:
                            combinaison[noChiffre] = 7;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 7:
                            combinaison[noChiffre] = 5;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 5:
                            combinaison[noChiffre] = 3;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 3:
                            combinaison[noChiffre] = 1;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 1:
                            combinaison[noChiffre] = 0;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                    }
                }
                else if(serieCaracteres[noChiffre].equals("+"))
                {   switch(serieEssais[noEssai-1][noChiffre])
                    {
                        case 1:
                            combinaison[noChiffre] = 2;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 2:
                            combinaison[noChiffre] = 3;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 3:
                            combinaison[noChiffre] = 4;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 4:
                            combinaison[noChiffre] = 5;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 5:
                            combinaison[noChiffre] = 6;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 6:
                            combinaison[noChiffre] = 7;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 7:
                            combinaison[noChiffre] = 8;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                        case 8:
                            combinaison[noChiffre] = 9;
                            serieEssais[noEssai][noChiffre] = combinaison[noChiffre];
                            break;
                    }
                }

            }
        }
        /*
        else
        {   String str = "";
            serieChiffres = resultatEssai.split("");
            for (noChiffre = 0; noChiffre < nbChiffres; noChiffre++)
            {   str += noChiffre + ":" +combinaison[noChiffre] + ">";
                switch (serieCaracteres[noChiffre])

                {
                    case "-":
                    {   //System.out.print(serieCaracteres[noChiffre]);
                        if ((combinaison[noChiffre] - 2) >= 0)
                            combinaison[noChiffre] = combinaison[noChiffre] - 2;
                        else
                            combinaison[noChiffre] = combinaison[noChiffre] - 1;
                        str += combinaison[noChiffre] + " / ";
                        break;
                    }
                    case "+":
                    {   //System.out.print(serieCaracteres[noChiffre]);
                        if ((combinaison[noChiffre] + 2) <= 9)
                            combinaison[noChiffre] = combinaison[noChiffre] + 2;
                        else
                            combinaison[noChiffre] = combinaison[noChiffre] + 1;
                        str += combinaison[noChiffre] + " / ";
                        break;
                    }
                }
                System.out.print(str);
            }
        }
        */
        return(this.computeTrial(noEssai));
    }
    /**/

    protected String computeTrial(int noEssai)
    {   for (int i = 0; i < nbChiffres; i++)
        {   if (combinaison[i] == serieJoueur[i])
                resultatEssai[noEssai] += "=";
            else if (combinaison[i] > serieJoueur[i])
                resultatEssai[noEssai] += "-";
            else
                resultatEssai[noEssai] += "+";
        }
        return resultatEssai[noEssai];
    }
    /**/

}
/**/
