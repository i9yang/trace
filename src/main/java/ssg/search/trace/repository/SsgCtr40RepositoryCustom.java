package ssg.search.trace.repository;

import ssg.search.trace.dto.SsgCtr;
import ssg.search.trace.dto.SsgCtr40;

import java.util.List;

public interface SsgCtr40RepositoryCustom {
	List<SsgCtr40> findByCritnDtQ(String date);
	List<SsgCtr40> findNotAllByCritnDtQ(String date, int page, int pageSize);
	long findNotAllByCritnDtCountQ(String date);
}
