package ssg.search.trace.control;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssg.search.trace.dto.*;
import ssg.search.trace.repository.SsgAreaRepository;
import ssg.search.trace.repository.SsgCoverageRepository;
import ssg.search.trace.repository.SsgCtr40Repository;
import ssg.search.trace.repository.SsgCtrRepository;

import java.util.List;
import java.util.Map;

@RestController
public class TraceRestController {
	@Autowired
	private SsgCoverageRepository ssgCoverageRepo;

	@Autowired
	private SsgCtrRepository ssgCtrRepo;

	@Autowired
	private SsgCtr40Repository ssgCtr40Repo;

	@Autowired
	private SsgAreaRepository ssgAreaRepo;

	@RequestMapping("/coverage/{date}")
	public Map<String, Object> coverage(@PathVariable String date){
		System.out.println("한글");
		List<SsgCoverage> list = ssgCoverageRepo.findByCritnDtQ(date);

		Map<String, Object> result = Maps.newHashMap();
		result.put("list", list);

		return result;
	}

	@RequestMapping("/ctr/{date}")
	public Map<String, Object> ctr(@PathVariable String date){
		List<SsgCtr> list = ssgCtrRepo.findByCritnDtQ(date);

		Map<String, Object> result = Maps.newHashMap();
		result.put("list", list);

		return result;
	}

	@RequestMapping("/ctrNotAll/{date}/{page}")
	public Map<String, Object> ctrNotAll(@PathVariable String date, @PathVariable String page, Parameter parameter){
		parameter.setDate(date);
		parameter.setPage(Integer.parseInt(page));

		List<SsgCtr> list = ssgCtrRepo.findNotAllByCritnDtQ(parameter);
		long cnt = ssgCtrRepo.findNotAllByCritnDtCountQ(parameter);

		Map<String, Object> result = Maps.newHashMap();
		result.put("list", list);
		result.put("cnt", cnt);

		return result;
	}

	@RequestMapping("/ctr40/{date}")
	public Map<String, Object> ctr40(@PathVariable String date){
		List<SsgCtr40> list = ssgCtr40Repo.findByCritnDtQ(date);

		Map<String, Object> result = Maps.newHashMap();
		result.put("list", list);

		return result;
	}

	@RequestMapping("/ctr40NotAll/{date}/{page}")
	public Map<String, Object> ctr40NotAll(@PathVariable String date, @PathVariable String page, Parameter parameter){
		parameter.setDate(date);
		parameter.setPage(Integer.parseInt(page));

		List<SsgCtr40> list = ssgCtr40Repo.findNotAllByCritnDtQ(parameter);
		long cnt = ssgCtr40Repo.findNotAllByCritnDtCountQ(parameter);

		Map<String, Object> result = Maps.newHashMap();
		result.put("list", list);
		result.put("cnt", cnt);

		return result;
	}

	@RequestMapping("/area/{date}")
	public Map<String, Object> area(@PathVariable String date){
		List<SsgArea> list = ssgAreaRepo.findByCritnDtQ(date);

		Map<String, Object> result = Maps.newHashMap();
		result.put("list", list);

		return result;
	}

	@RequestMapping("/areaNotAll/{date}/{page}")
	public Map<String, Object> area(@PathVariable String date, @PathVariable String page, Parameter parameter){
		parameter.setDate(date);
		parameter.setPage(Integer.parseInt(page));

		List<SsgArea> list = ssgAreaRepo.findNotAllByCritnDtQ(parameter);
		long cnt = ssgAreaRepo.findNotAllByCritnDtCountQ(parameter);

		Map<String, Object> result = Maps.newHashMap();
		result.put("list", list);
		result.put("cnt", cnt);

		return result;
	}

}
