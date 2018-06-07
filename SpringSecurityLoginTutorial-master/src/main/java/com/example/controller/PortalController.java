package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Problem;
import com.example.entities.Solution;
import com.example.entities.Vote;
import com.example.model.User;
import com.example.services.PortalService;


@Controller
public class PortalController {

	@Autowired
	PortalService service;
		
	/*@RequestMapping("/home")
	public String retrieveAll(Model model)
	{
		List<Problem> plist = (List<Problem>) service.viewAllProblem();
		System.out.println(plist);
		model.addAttribute("problemList",plist);
		return "home";
	}*/
	
	
	
	/*@RequestMapping(value="/addNewIdea",method = RequestMethod.GET)
	public ModelAndView addNewIdea(Integer id,Model model,HttpSession session)
	{
		ModelAndView modelAndView = new ModelAndView();
		User user=(User) session.getAttribute("user");
		id=user.getId();
		System.out.println(id);
		modelAndView.addObject("idea", new Idea());
		modelAndView.addObject("empId",id);
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.setViewName("addIdea");
		System.out.println("id="+id);
		return modelAndView;		
	}*/
	
	/*@RequestMapping(value = "/addIdea", method = RequestMethod.POST)
	public String addIdea(@ModelAttribute("idea")Idea idea, Model model)
	{
		idea=service.addIdea(idea);
		model.addAttribute("message","Idea added successfully!");
		return "addIdea";
	}*/
	
	/*@RequestMapping("/viewIdea")
	public String retrieveIdea(@RequestParam("iId")long iId,Model model){
		Idea idea = service.viewIdea(iId);
		System.out.println(idea);
		System.out.println(iId);
		model.addAttribute("idea",idea);
		return "viewIdea";
	}*/

	/*@RequestMapping("/addSuggestion")
	public ModelAndView addSuggestion(@RequestParam("iId")String iId, Integer id, Model model, HttpSession session)
	{
		ModelAndView modelAndView = new ModelAndView();
		User user=(User) session.getAttribute("user");
		id=user.getId();
		System.out.println(id);
		System.out.println(iId);
		modelAndView.addObject("suggestion", new IdeaSuggestion());
		modelAndView.addObject("iId", iId);
		modelAndView.addObject("empId", id);
		modelAndView.setViewName("addSuggestion");
		return modelAndView;		
	}*/
	
	/*@RequestMapping("/addSugg")
	public String add(@ModelAttribute("suggestion")IdeaSuggestion suggestion,@RequestParam("iId") String iId, Model model)
	{
		model.addAttribute("iId",iId);
		service.addSuggestion(suggestion);
		model.addAttribute("message","Your suggestion is added successfully!");
		model.addAttribute("iId",suggestion.getSiId());
		return "addSolution";
	}*/
	
	/*@RequestMapping("/suggestions")
	public String viewAllSuggestions(@RequestParam("iId")long iId,Model model){
		
		List<IdeaSuggestion> silist = (List<IdeaSuggestion>) service.viewSuggestion(iId);
		System.out.println(silist);
		model.addAttribute("suggestionList",silist);
		model.addAttribute("iId",iId);
		model.addAttribute("suggestion",new IdeaSuggestion());
		return "suggestion";
	}*/
	
	/*@RequestMapping("/viewSuggestion")
	public String viewIdea(@RequestParam("siId")long siId, Model model){
		IdeaSuggestion si = service.viewSingleIdeaSuggestion(siId);
		System.out.println(si);
		model.addAttribute("suggestion",si);
		return "viewSuggestion";
	}*/
	
	@PostMapping("/doVote")
	@ResponseBody
	public Vote doVote(@RequestParam("pId") long pId, @RequestParam("sId") long sId, @RequestParam("id") long userId)
	{
		Vote vote = new Vote();
		vote.setpId(pId);
		vote.setsId(sId);
		vote.setUserId(userId);
		service.addVote(vote);
		return vote;
	}
	
	@PostMapping("/undoVote")
	@ResponseBody
	public String undoVote(@RequestParam("pId") long pId, @RequestParam("sId") long sId, @RequestParam("id") long userId)
	{
		service.undoVote(pId, sId, userId);
		/*Vote vote = service.findVote(sId, userId);
		service.deleteVote(vote);*/
		return "deleted";
	}
	
	@RequestMapping(value="/addProblem",method = RequestMethod.GET)
	public ModelAndView addProblem(Integer id,Model model,HttpSession session)
	{
		ModelAndView modelAndView = new ModelAndView();
		User user=(User) session.getAttribute("user");
		id=user.getId();
		System.out.println(id);
		modelAndView.addObject("problem", new Problem());
		/*modelAndView.addObject("user", new User());*/
		modelAndView.addObject("empId",id);
		modelAndView.setViewName("addProblem");
		System.out.println("id="+id);
		return modelAndView;		
	}
	
	@RequestMapping(value = "/addProb", method = RequestMethod.POST)
	public String add(@ModelAttribute("problem")Problem problem, Model model)
	{
		problem=service.addProblem(problem);
		model.addAttribute("message","Problem added successfully!");
		return "addProblem";
	}
	
	
	@RequestMapping("/viewProblem")
	public String retrieveProblem(@RequestParam("pId")long pId,Model model){
		Problem prob = service.viewProblem(pId);
		System.out.println(prob);
		System.out.println(pId);
		model.addAttribute("problem",prob);
		return "viewProblem";
	}
			
	@PostMapping(path="/addSolution"/*,consumes=MediaType.MULTIPART_FORM_DATA*/)
	public ModelAndView addSolution(
			@RequestParam("file") MultipartFile file,
			@RequestParam("pId")String pId, Integer id, Model model, HttpSession session)
	{
		ModelAndView modelAndView = new ModelAndView();
		User user=(User) session.getAttribute("user");
		id=user.getId();
		System.out.println(id);
		System.out.println(pId);
		modelAndView.addObject("solution", new Solution());
		modelAndView.addObject("pId", pId);
		modelAndView.addObject("id", id);
		modelAndView.addObject("empId", id);
		modelAndView.setViewName("addSolution");
		/*modelAndView.addObject("solution", new Solution());*/
		return modelAndView;		
	}
	
	@RequestMapping("/addSol")
	public String add(@ModelAttribute("solution")Solution solution,@RequestParam("pId") String pId, Model model)
	{
		model.addAttribute("pId",pId);
		service.addSolution(solution);
		model.addAttribute("message","Solution added successfully!");
		model.addAttribute("sId",solution.getsId());
		return "addSolution";
	}
	
	@RequestMapping("/solutions")
	public String viewAllSolutions(@RequestParam("pId")long pId,Model model){
		
		List<Solution> slist = (List<Solution>) service.viewSolution(pId);
		System.out.println(slist);
		model.addAttribute("solutionList",slist);
		model.addAttribute("pId",pId);
		model.addAttribute("solution",new Solution());
		return "solution";
	}
	
	@RequestMapping("/viewSolution")
	public String viewProblem(@RequestParam("sId")long sId, Model model){
		Solution sol = service.viewSingleSolution(sId);
		System.out.println(sol);
		model.addAttribute("solution",sol);
		return "viewSolution";
	}
	
	/*@RequestMapping("/vote")
	public String addVote(@ModelAttribute("vote") Vote vote)
	{
		Vote votes = service.addVote(vote);
		return null;
	}*/
	
	@RequestMapping(value="/modifyProblem",method = RequestMethod.GET)
	public String modifyProblem(@RequestParam("pId") Long pId,Model model)
	{	
		// TODO Auto-generated method stub
		System.out.println(pId);
		Problem prob=service.viewProblem(pId);
		model.addAttribute("problem",prob);
		return "modifyProblem";
	}
	
	@RequestMapping("/modifyProb")
	public String modify(@ModelAttribute("problem")Problem problem,Model model)
	{
		// TODO Auto-generated method stub
		Problem prob=service.modifyProblem(problem);
		model.addAttribute("message","Problem modified successfully!");
		System.out.println(prob);
		return "modifyProblem";
	} 
 
	@RequestMapping(value="/modifySolution",method = RequestMethod.GET)
	public String modifySolution(@RequestParam("sId") Long sId, Model model)
	{
		// TODO Auto-generated method stub
		System.out.println(sId);
		Solution sol=service.viewSingleSolution(sId);
		model.addAttribute("solution", sol);
		return "modifySolution";
	} 
 
	@RequestMapping("/modifySol")
	public String modifySol(@ModelAttribute("solution")Solution solution, Model model)
	{
		Solution sol=service.modifySolution(solution);
		model.addAttribute("message","Solution updated successfully");
		System.out.println(sol);
		return "modifySolution";
	}  

	
	@RequestMapping("/leaderBoard")
	public String viewLeaderboard()
	{
		return "leaderBoard";
	}
	
	
}
