package ssg.search.trace.repository;

import ssg.search.trace.dto.Parameter;
import ssg.search.trace.dto.SsgArea;

import java.util.List;

public interface SsgAreaRepositoryCustom {
	List<SsgArea> findByCritnDtQ(String date);
	List<SsgArea> findNotAllByCritnDtQ(String date, int page, int pageSize);
	long findNotAllByCritnDtCountQ(String date);

	List<SsgArea> findNotAllByCritnDtQ(Parameter parameter);
	long findNotAllByCritnDtCountQ(Parameter parameter);
}
