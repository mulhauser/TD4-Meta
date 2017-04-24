import generic.*;
import algo.*;
import probleme.quatreCouleurs.*;
import probleme.TSP.*;

import java.util.Properties;

public class ILS {

    public static void main(String[] args) {

        Properties parametres = readProperties("parametres.properties");
        if (args.length > 0)
            parametres = readProperties(args[1]);

        // read parameters
        int maxEvaluations = 10000;
        String s;
        if ((s = parametres.getProperty("maxEvaluations")) != null)
            maxEvaluations = Integer.parseInt(s);


        // Choix du probleme
        Probleme4Couleurs probleme = new Probleme4Couleurs(10);
        Solution4Couleurs solution = new Solution4Couleurs(probleme);

        //TSP probleme         = new TSP(100,400);
        //SolutionTSP solution = new SolutionTSP(probleme);

        // choix de l'algorithme
        AlgorithmeAbstract LS =
                AlgorithmeAbstract.getAlgo("sls", probleme, solution,
                        maxEvaluations);

        System.out.println("Parametres : " + parametres + "\n");


        // TODO a ecrire etudiant

        // une execution de l'algorithme
        LS.executeJusquaFin();
        SolutionAbstract saveSol = LS.getSolutionEnCours();

        // sauvgarde de la solution
        SolutionAbstract perturbation;
        SolutionAbstract solPrim;
        // tant que notre budget en evaluation n'est pas termine

        while (probleme.getNbEvaluations() < maxEvaluations) {

            // Perturber la solution courante
            perturbation = saveSol.retournePerturbation(5);

            // Executer de l'algorithme
            LS.reset(perturbation);
            LS.executeJusquaFin();

            double val = probleme.evaluation(saveSol);
            if(LS.valeur() < val){
                val = LS.valeur();
                saveSol = LS.getSolutionEnCours();
            }

            // Si la solution et meilleure on remplce

        }

        // FinTODO a ecrire etudiant


        System.out.println("# Best Ever solution value= "
                + LS.getValeurMeilleureSolution());
    }

    /**
     * Lecture du fichier de parametres
     */

    private static Properties readProperties(String fileName) {
        Properties properties = new Properties();
        try {
            java.io.FileInputStream fis = new java.io.FileInputStream(fileName);
            properties.load(fis);
            fis.close();
        } catch (java.io.IOException e) {
            System.out.println("File '" + fileName + "' not found, no options read");
            e.printStackTrace();
            System.exit(1);
        }

        return properties;
    }


}
