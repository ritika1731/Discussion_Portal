package com.example.wrapper;

import com.example.entities.Solution;

public class SolutionWrap {

	private Solution solution;
	private boolean solutionPresence;

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	public boolean isSolutionPresence() {
		return solutionPresence;
	}

	public void setSolutionPresence(boolean solutionPresence) {
		this.solutionPresence = solutionPresence;
	}

	@Override
	public String toString() {
		return "SolutionWrap [solution=" + solution + ", solutionPresence=" + solutionPresence + "]";
	}

}
