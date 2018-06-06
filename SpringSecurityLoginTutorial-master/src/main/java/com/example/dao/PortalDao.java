package com.example.dao;

import java.util.List;

import com.example.entities.Problem;
import com.example.entities.Solution;
import com.example.entities.Vote;
import com.example.exceptions.PortalException;
import com.example.model.User;

public interface PortalDao  {

	public User validateEmployee(String email) throws PortalException;

	/* public Idea addIdea(Idea idea); */

	/* public IdeaSuggestion addSuggestion(IdeaSuggestion suggestion); */

	public Problem addProblem(Problem problem);

	public Solution addSolution(Solution solution);

	/* public List<Solution> loadAll(); */

	/* public List<Idea> viewAllIdea(); */

	List<Problem> viewAllProblem();

	/* public Idea viewIdea(long iId); */

	public Problem viewProblem(long pId);

	/* public List<IdeaSuggestion> viewSuggestion(long iId); */

	/* public IdeaSuggestion viewSingleIdeaSolution(long siId); */

	public List<Solution> viewSolution(long pId);

	public Solution viewSingleSolution(long sId);

	/* public List<Solution> viewAllSolutions(); */

	public Problem modifyProblem(Problem problem);

	public Solution modifySolution(Solution solution);

	public Vote addVote(Vote vote);

	//public void undoVote(long id);

	public Vote undoVote(long sId, long userId);

}
