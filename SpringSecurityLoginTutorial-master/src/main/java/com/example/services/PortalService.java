package com.example.services;

import java.util.List;

import com.example.entities.Problem;
import com.example.entities.Solution;
import com.example.entities.Vote;
import com.example.exceptions.PortalException;
import com.example.model.User;

public interface PortalService {

	/*
	 * 1. addProblem 2. addSolution 3. retreiveAllSolutions 4. deleteProblem 5.
	 * viewSolution 6. viewProblem 7. retreiveAllProblems 8. addNewIdea 9.
	 * addSuggestion
	 */

	public User validateEmployee(String email) throws PortalException;

	/* public Idea addIdea(Idea idea); */

	public Problem addProblem(Problem problem);

	/* public IdeaSuggestion addSuggestion(IdeaSuggestion suggestion); */

	public Solution addSolution(Solution solution);

	/* public List<Solution> loadAll(); */

	/* List<Idea> viewAllIdea(); */

	List<Problem> viewAllProblem();

	/* public Idea viewIdea(long iId); */

	public Problem viewProblem(long pId);

	/* public List<IdeaSuggestion> viewSuggestion(long iId); */

	public List<Solution> viewSolution(long pId);

	/* public IdeaSuggestion viewSingleIdeaSuggestion(long siId); */

	public Solution viewSingleSolution(long sId);

	public Problem modifyProblem(Problem problem);

	public Solution modifySolution(Solution solution);

	/* public List<Solution> viewAllSolutions(); */

	public Vote addVote(Vote vote);

	public Vote findVote(long sId, long userId);

	public Vote undoVote(long pId, long sId, long userId);

}
