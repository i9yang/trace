package ssg.search.trace.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ssg.search.trace.dto.SsgCoverage;
import ssg.search.trace.repository.SsgCoverageRepository;

import java.util.List;

@Controller
public class TraceController {
	@Autowired
	private SsgCoverageRepository ssgCoverageRepo;

	@RequestMapping("/")
	public String index(ModelMap model){
		//List<SsgCoverage> list = ssgCoverageRepo.findAllQ(1, 6);
		List<SsgCoverage> list = ssgCoverageRepo.findAllQ();

		model.put("list", list);
		return "index";
	}
}
