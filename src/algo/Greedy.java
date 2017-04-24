package algo;

import java.util.List;

import generic.AlgorithmeAbstract;
import generic.ProblemeAbstract;
import generic.SolutionAbstract;

/**
 * classe representant un algorithme de type greedy
 * 
 * @author vthomas
 *
 */
public class Greedy extends AlgorithmeAbstract {

	/**
	 * constructeur d'un algorithme greedy
	 *  @param probleme
	 *            le probleme a resoudre
	 * @param initiale
	 * @param maxEvaluations
	 */
	public Greedy(ProblemeAbstract probleme, SolutionAbstract initiale, int maxEvaluations) {
		super(probleme, initiale, maxEvaluations);
	}

	/**
	 * permet d'améliorer la solution selon une approche gloutonne
	 */
	public boolean amelioreSolution() {

		//throw new Error("TODO"); // TODO  a ecrire etudiant

		List<SolutionAbstract> voisins = solutionEnCours.retourneVoisinage();
		boolean res = true;
		double max = problemeATraiter.evaluation(solutionEnCours);
		for(SolutionAbstract a : voisins){
		    double solV = problemeATraiter.evaluation(a);
            if(max > solV){
                solutionEnCours = a;
                res = false;
            }
        }
        return res;
		// on s'arrete si la solution ne s'ameliore plus
	}

}
