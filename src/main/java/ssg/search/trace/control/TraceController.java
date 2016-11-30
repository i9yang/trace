package ssg.search.trace.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssg.search.trace.repository.SsgCoverageRepository;

@Controller
public class TraceController {
	@Autowired
	private SsgCoverageRepository ssgCoverageRepo;

	@RequestMapping("/coverage")
	public void coverage(){}

//	@RequestMapping("/")
//	public String index(ModelMap model, @RequestParam(defaultValue = "1") String p){
//		List<SsgCoverage> list = ssgCoverageRepo.findAllQ(Integer.parseInt(p), 6);
//		//List<SsgCoverage> list = ssgCoverageRepo.findAllQ();
//
//		model.put("list", list);
//		return "index";
//	}
}
