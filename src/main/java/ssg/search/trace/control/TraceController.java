package ssg.search.trace.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ssg.search.trace.dto.SsgCoverage;
import ssg.search.trace.repository.SsgCoverageRepository;

import java.util.List;

@RestController
public class TraceController {
	@Autowired
	private SsgCoverageRepository ssgCoverageRepo;

	@RequestMapping("/coverage")
	public List<SsgCoverage> coverage(@RequestParam(defaultValue = "1") String page){
		Integer p = Integer.parseInt(page);

		List<SsgCoverage> list = ssgCoverageRepo.findAllQ(p, 6);
		return list;
	}
}