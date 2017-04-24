package algo;

import generic.AlgorithmeAbstract;
import generic.ProblemeAbstract;
import generic.SolutionAbstract;

import java.util.List;
import java.util.Random;


public class SLS extends AlgorithmeAbstract{
    
    public SLS(ProblemeAbstract probleme,
	       SolutionAbstract initiale,
	       int maxEvaluations){
	super(probleme, initiale, maxEvaluations);
    }
		
    //proposition d'une nouvelle solution
    public boolean amelioreSolution(){

	// TODO a ecrire etudiant
		
	// Prend un voisin au hasard et l'evaluer 
    SolutionAbstract randomSolution = solutionEnCours.retournePerturbation(5);
    double valRand = problemeATraiter.evaluation(randomSolution);
    double val = problemeATraiter.evaluation(solutionEnCours);
    if(valRand < val){
        solutionEnCours = randomSolution;
        return true;
    }

       	// si c'est meilleur, on remplace et retourn vrai


	// FinTODO a ecrire etudiant

	// sion on s'arrete si la solution ne s'ameliore plus		
	
	return false;

	
	
	
    }
    
}
