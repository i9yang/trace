package ssg.search.trace.repository;

import ssg.search.trace.dto.SsgCoverage;

import java.util.List;

public interface SsgCoverageRepositoryCustom {
	List<SsgCoverage> findByCritnDtQ(String date);
}
