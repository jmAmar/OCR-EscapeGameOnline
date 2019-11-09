package com.ocr.gameplay_studio;

public class GameWording
{
    static final String BIENVENUE
    = "\n\t\t**** BIENVENUE ****"
    + "\n\tdans notre jeu ESCAPE GAME ONLINE"
    + "\n\t\t! prenez-y plaisir !"
    + "\n\tGAMEPLAY STUDIO , éditeur"
    ;

    static final String AU_REVOIR
    = "\n\n\t... Nous espèrons vous être bien amusés !"
    + "\n\t\t\t**** AU REVOIR ****"
    + "\n"
    ;

    static final String DESCRIPTION_JEU
    = "\n\t\t** Description Générale **"
    + "\nCe jeu est inspiré de celui où une équipe de joueurs est enfermée dans une pièce."
    + " Pour en sortir ils doivent résoudre des égnimes scénarisées."
    + "\nDans notre jeu les égnimes sont concrétisées par des séries de chiffres (de 0 à 9) à deviner et/ou déduire."
    + "\nLe nombre de chiffres de chaque série est déterminé en début de partie (4 par défaut)."
    + "\nUn chiffre peut être redondant une ou plusieurs fois dans une même série (exemples: 12325 , 2222)."
    + "\n3 modes sont proposés :"
    + "\n- mode CHALLENGER (le joueur doit deviner les chiffres de la série déterminés aléatoirement par le logiciel)."
    + "\n- mode DEFENDER (le joueur détermine les chiffres de la série et le logiciel doit les deviner)."
    + "\n- mode DUEL (le joueur et le logiciel jouent à tour. Le gagnant est le premier qui a trouvé la combinaison de l'autre)."
    + "\nRemarque: le nombre d'essais pour chaque partie est limité.\n"
    ;

    static final String MENU_JEU
    = "\n\t\t** Menu du Jeu **"
    + "\n- Mode CHALLENGER\t:  1"
    + "\n- Mode DEFENDER\t\t:  2"
    + "\n- Mode DUEL\t\t:  3"
    + "\n- QUITTER le Jeu\t:  9"
    ;

    static final String DESCRIPTION_CHALLENGER
        = "\n\t\t** Description du Mode Challenger **"
        + "\nLe logiciel génère aléatoirement une combinaison de chiffres entre 0 et 9 (4 par défaut)."
        + "\nUn même chiffre peut être contenu une ou plusieurs fois dans la même combinaison."
        + "\nIl vous demande ensuite de saisir les chiffres que vous pensez composer la combinaison."
        + "\nA la fin de votre saisie le logiciel vous indique un résultat intermédiaire sous forme de chaîne contenant des \"=\", \"-\", ou \"+\""
        + " relativement à la position de chaque chiffre."
        + "\n\"=\" signifie que le chiffre de la combinaison est égal à celui saisi."
        + "\n\"-\" signifie que le chiffre de la combinaison est plus petit que celui saisi."
        + "\n\"+\" signifie que le chiffre de la combinaison est plus grand que celui saisi."
        + "\nExemple: si la combinaison générée est 3562 est que vous avez saisi les chiffres 1264, le résultat intermédiaire sera ++=-."
        + "\nLe nombre d'essais (générant des résultats intermédiaires) est limité."
        + "\nLe résultat final de la partie est celui de votre dernier essai.\n"
        ;

    static final String DESCRIPTION_DEFENDER
    = "\n\t\t** Description du Mode Defender **"
    + "\nVous, le joueur, définissez une combinaison de chiffres entre 0 et 9 (4 par défaut)."
    + "\nLe logiciel génère aléatoirement une combinaison de chiffres entre 0 et 9 (4 par défaut)."
    + "\nUn même chiffre peut être contenu une ou plusieurs fois dans la même combinaison."
    + "\nPar ses traitements, le logiciel doit deviner votre combinaison."
    + "\nA la fin de chaque essai de sa part, le logiciel exprime un résultat intermédiaire sous forme de chaîne contenant des \"=\", \"-\", ou \"+\""
    + " relativement à la position de chaque chiffre."
    + "\n\"=\" signifie que le chiffre de la combinaison est égal à celui saisi."
    + "\n\"-\" signifie que le chiffre de la combinaison est plus petit que celui saisi."
    + "\n\"+\" signifie que le chiffre de la combinaison est plus grand que celui saisi."
    + "\nExemple: si la combinaison que vous avez saisie est 3562 est que lors d'une essai le logiciel sort 1264, le résultat intermédiaire sera ++=-."
    + "\nLe nombre d'essais (générant des résultats intermédiaires) est limité."
    + "\nLe résultat final de la partie est celui du dernier essai.\n"
    ;

    static final String DESCRIPTION_DUEL
    = "\n\t\t** Description du Mode Duel **"
    + "\nVous, le joueur, et le logiciel jouez tour à tour."
    + "\nLe premier à trouver la combinaison secrète de l'autre a gagné.\n"
    ;

    static final String NOUVELLE_PARTIE
    /* = "\n\n\t\t** Nouvelle Partie **" */
    = "\n... La partie démarre ...\n"
    ;

    static final String MENU_PARTIE_CHALLENGER
    = "\n\t\t** Menu Partie Challenger **"
    + "\n- Lancer une Partie\t:  1"
    + "\n- Quitter Challenger\t:  2"
    + "\n- Modifier la Config.\t:  8"
    + "\n- Quitter le Jeu\t:  9"
    ;

    static final String MENU_PARTIE_DEFENDER
    = "\n\t\t** Menu Partie Defender **"
    + "\n- Lancer une Partie\t:  1"
    + "\n- Quitter Defender\t:  2"
    + "\n- Modifier la Config.\t:  8"
    + "\n- Quitter le Jeu\t:  9"
    ;

    static final String MENU_PARTIE_DUEL
    = "\n\t\t** Menu Partie Duel **"
    + "\n- Lancer une Partie\t:  1"
    + "\n- Quitter Duel\t:  2"
    + "\n- Modifier la Config.\t:  8"
    + "\n- Quitter le Jeu\t:  9"
    ;

}
/**/
