package ssg.search.trace.repository;

import ssg.search.trace.dto.Parameter;
import ssg.search.trace.dto.SsgCtr;

import java.util.List;

public interface SsgCtrRepositoryCustom {
	List<SsgCtr> findByCritnDtQ(String date);
	List<SsgCtr> findNotAllByCritnDtQ(String date, int page, int pageSize);
	long findNotAllByCritnDtCountQ(String date);

	List<SsgCtr> findNotAllByCritnDtQ(Parameter parameter);
	long findNotAllByCritnDtCountQ(Parameter parameter);
}
