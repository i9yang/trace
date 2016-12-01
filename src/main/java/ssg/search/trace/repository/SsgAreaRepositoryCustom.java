package ssg.search.trace.repository;

import ssg.search.trace.dto.SsgArea;
import ssg.search.trace.dto.SsgCtr;

import java.util.List;

public interface SsgAreaRepositoryCustom {
	List<SsgArea> findByCritnDtQ(String date);
	List<SsgArea> findNotAllByCritnDtQ(String date, int page, int pageSize);
	long findNotAllByCritnDtCountQ(String date);
}
