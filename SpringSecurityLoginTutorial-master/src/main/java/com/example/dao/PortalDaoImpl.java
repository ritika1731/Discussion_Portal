package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.entities.Problem;
import com.example.entities.Solution;
import com.example.entities.Vote;
import com.example.exceptions.PortalException;
import com.example.model.User;
import com.example.wrapper.SolutionWrap;

@Repository
public class PortalDaoImpl implements PortalDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User validateEmployee(String email) throws PortalException {

		try {
			String sql = "select e from User e where email= :email";
			TypedQuery<User> typedQuery = entityManager.createQuery(sql, User.class);
			typedQuery.setParameter("email", email);
			return typedQuery.getSingleResult();

		} catch (Exception e) {
			throw new PortalException("message", e);

		}

	}

	/*
	 * @Override public Idea addIdea(Idea idea) { entityManager.persist(idea);
	 * entityManager.flush(); return idea; }
	 */

	/*
	 * @Override public IdeaSuggestion addSuggestion(IdeaSuggestion suggestion) {
	 * entityManager.persist(suggestion); entityManager.flush(); return suggestion;
	 * }
	 */

	@Override
	public Problem addProblem(Problem problem) {
		entityManager.persist(problem);
		entityManager.flush();
		return problem;
	}

	@Override
	public Solution addSolution(Solution solution) {
		entityManager.persist(solution);
		entityManager.flush();
		return solution;
	}

	/*
	 * @Override public List <Solution> loadAll() { TypedQuery<Solution> query =
	 * entityManager.createQuery("SELECT s FROM Solution s", Solution.class); return
	 * query.getResultList();
	 * 
	 * }
	 */

	/*
	 * @Override public List<Idea> viewAllIdea() { String query =
	 * "Select i FROM Idea i"; TypedQuery<Idea> typedQuery =
	 * entityManager.createQuery(query, Idea.class); return
	 * typedQuery.getResultList(); }
	 */

	@Override
	public List<Problem> viewAllProblem() {
		String query = "SELECT p FROM Problem p";
		TypedQuery<Problem> typedQuery = entityManager.createQuery(query, Problem.class);
		return typedQuery.getResultList();
	}

	/*
	 * @Override public Idea viewIdea(long iId) { Idea
	 * idea=entityManager.find(Idea.class, iId); return idea; }
	 */

	@Override
	public Problem viewProblem(long pId) {
		Problem prob = entityManager.find(Problem.class, pId);
		return prob;
	}

	/*
	 * @Override public List<IdeaSuggestion> viewSuggestion(long iId) {
	 * TypedQuery<IdeaSuggestion> typedQuery =
	 * entityManager.createQuery("SELECT si FROM IdeaSuggestion si WHERE iId= :iId",
	 * IdeaSuggestion.class); typedQuery.setParameter("iId", iId); return
	 * typedQuery.getResultList(); }
	 */

	@Override
//	public List<Solution> viewSolution(long pId) {
	public List<SolutionWrap> viewSolution(long pId, long sId, long userId) {
		TypedQuery<Solution> typedQuery = entityManager.createQuery("SELECT s FROM Solution s WHERE pId= :pId",
				Solution.class);
		typedQuery.setParameter("pId", pId);
		
		List <Solution> listOfSol = typedQuery.getResultList();
		for (Solution sol : listOfSol) {
			/*CreateDTO*/ 
			SolutionWrap solWrap = new SolutionWrap();
			solWrap.setSolution(sol);
			solWrap.setSolutionPresence(true);
			
			/*findinVoteTable4 and set boolean*/
			TypedQuery<Vote> typedQueryVote = entityManager.createQuery("SELECT v FROM Vote v WHERE pId= :pId AND s_Id= :sId AND user_Id= :userId",
					Vote.class);
			typedQueryVote.setParameter("pId", pId);
			typedQueryVote.setParameter("sId", sId);
			typedQueryVote.setParameter("userId", userId);
			
		}
		
//		return typedQuery.getResultList();
		return null;
	}

	/*
	 * @Override public IdeaSuggestion viewSingleIdeaSolution(long siId) {
	 * IdeaSuggestion si = entityManager.find(IdeaSuggestion.class, siId); return
	 * si; }
	 */

	@Override
	public Solution viewSingleSolution(long sId) {
		Solution sol = entityManager.find(Solution.class, sId);
		return sol;
	}

	@Override
	public Problem modifyProblem(Problem problem) {
		// TODO Auto-generated method stub
		entityManager.merge(problem);
		entityManager.flush();
		return problem;
	}

	@Override
	public Solution modifySolution(Solution solution) {
		// TODO Auto-generated method stub
		entityManager.merge(solution);
		entityManager.flush();
		return solution;

	}

	@Override
	public Vote addVote(Vote vote) {
		// TODO Auto-generated method stub
		entityManager.persist(vote);
		entityManager.flush();
		return vote;
	}

	/*@Override
	public void undoVote(long id) {
		// TODO Auto-generated method stub
		Vote vote = entityManager.find(Vote.class, id);
		entityManager.remove(vote);
		entityManager.flush();
	}*/

	@Override
	public Vote undoVote(long pId, long sId, long userId) {
		String query = "SELECT v FROM Vote v WHERE p_id=:pId AND s_Id= :sId AND user_Id= :userId";
		TypedQuery<Vote> typedQuery = entityManager.createQuery(query,Vote.class);
//		entityManager.find(Vote.class, sId);
//		entityManager.find(Vote.class, userId);
		typedQuery.setParameter("pId", pId);
		typedQuery.setParameter("sId", sId);
		typedQuery.setParameter("userId", userId);
	
		List<Vote> vote= typedQuery.getResultList();
		System.out.println(vote);
		if(vote.equals(null))
			//not exists
		{
			System.out.println("No vote present");
		}
		else
		{
			System.out.println(vote);
			for (Vote eachvote : vote) {
				entityManager.remove(eachvote);
			}
			//entityManager.remove(vote);
		}
		
		return null;
	}

	@Override
	public List<Solution> viewSolution(long pId) {
		// TODO Auto-generated method stub
		return null;
	}

}
