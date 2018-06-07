package com.example.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PortalDao;
import com.example.entities.Problem;
import com.example.entities.Solution;
import com.example.entities.Vote;
import com.example.exceptions.PortalException;
import com.example.model.User;
import com.example.wrapper.SolutionWrap;

@Service
@Transactional
public class PortalServiceImpl implements PortalService {

	@Autowired
	PortalDao dao;

	@Override
	public User validateEmployee(String email) throws PortalException {
		// TODO Auto-generated method stub
		return dao.validateEmployee(email);
	}

	/*
	 * @Override public Idea addIdea(Idea idea) { return dao.addIdea(idea); }
	 * 
	 * @Override public IdeaSuggestion addSuggestion(IdeaSuggestion suggestion) {
	 * return dao.addSuggestion(suggestion); }
	 */

	@Override
	public Problem addProblem(Problem problem) {
		return dao.addProblem(problem);
	}

	@Override
	public Solution addSolution(Solution solution) {
		return dao.addSolution(solution);
	}

	/*
	 * @Override public List<Solution> loadAll() { // TODO Auto-generated method
	 * stub return dao.loadAll(); }
	 */

	/*
	 * @Override public List<Idea> viewAllIdea() { return dao.viewAllIdea(); }
	 */

	@Override
	public List<Problem> viewAllProblem() {
		return dao.viewAllProblem();
	}

	/*
	 * @Override public Idea viewIdea(long iId) { return dao.viewIdea(iId); }
	 */

	@Override
	public Problem viewProblem(long pId) {
		return dao.viewProblem(pId);
	}

	/*
	 * @Override public List<IdeaSuggestion> viewSuggestion(long iId) { return
	 * dao.viewSuggestion(iId); }
	 */

	@Override
	public List<Solution> viewSolution(long pId) {
		List<Solution> solutionList= dao.viewSolution(pId);
		//List<SolutionWrap> solutionWrapList= dao.viewSolution(pId);
		
		return dao.viewSolution(pId);
	}

	/*
	 * @Override public List<Solution> viewAllSolutions() { // TODO Auto-generated
	 * method stub return dao.viewAllSolutions(); }
	 */

	/*
	 * @Override public IdeaSuggestion viewSingleIdeaSuggestion(long siId) { return
	 * dao.viewSingleIdeaSolution(siId); }
	 */

	@Override
	public Solution viewSingleSolution(long sId) {
		return dao.viewSingleSolution(sId);
	}

	@Override
	public Problem modifyProblem(Problem problem) {
		// TODO Auto-generated method stub
		return dao.modifyProblem(problem);
	}

	@Override
	public Solution modifySolution(Solution solution) {
		// TODO Auto-generated method stub
		return dao.modifySolution(solution);
	}

	@Override
	public Vote addVote(Vote vote) {
		// TODO Auto-generated method stub
		return dao.addVote(vote);
	}

	@Override
	public Vote findVote(long sId, long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vote undoVote(long pId, long sId, long userId) {
		// TODO Auto-generated method stub
		
		return dao.undoVote(pId, sId,userId);
	}

}
