package ssg.search.trace.repository;

import ssg.search.trace.dto.SsgCtr;

import java.util.List;

public interface SsgCtrRepositoryCustom {
	List<SsgCtr> findAllQ();
	List<SsgCtr> findAllQ(int page, int pageSize);
	List<SsgCtr> findByCritnDtQ(String date);
	List<SsgCtr> findNotAllByCritnDtQ(String date, int page, int pageSize);
	long findNotAllByCritnDtCountQ(String date);
}
