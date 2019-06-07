package ssg.search.trace.repository;

import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.util.StringUtils;
import ssg.search.trace.dto.*;

import java.util.List;

public class SsgCtrRepositoryImpl extends QueryDslRepositorySupport implements SsgCtrRepositoryCustom {

	public SsgCtrRepositoryImpl() {
		super(SsgCtr.class);
	}

	@Override
	public List<SsgCtr> findByCritnDtQ(String date) {
		QSsgCtr ssgCtr = QSsgCtr.ssgCtr;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		return from(ssgCtr)
				.innerJoin(ssgCtr.SSG_SITE, ssgSite)
				.orderBy(ssgCtr.SITE_NO.asc(), ssgCtr.TOTAL.desc(), ssgCtr.COUNT.desc())
				.where(ssgCtr.CRITN_DT.eq(date))
				.where(ssgCtr.QUERY.eq("_ALL"))
				.where(ssgCtr.POSITION_NM.eq("ctr"))
				.fetchJoin()
				.fetch();
	}

	@Override
	public List<SsgCtr> findNotAllByCritnDtQ(String date, int page, int pageSize) {
		QSsgCtr ssgCtr = QSsgCtr.ssgCtr;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		return from(ssgCtr)
				.innerJoin(ssgCtr.SSG_SITE, ssgSite)
				.orderBy(ssgCtr.SITE_NO.asc(), ssgCtr.TOTAL.desc(), ssgCtr.COUNT.desc())
				.where(ssgCtr.CRITN_DT.eq(date))
				.where(ssgCtr.QUERY.ne("_ALL"))
				.where(ssgCtr.POSITION_NM.eq("ctr"))
				.limit(pageSize)
				.offset((page-1) * pageSize)
				.fetchJoin()
				.fetch();
	}

	@Override
	public long findNotAllByCritnDtCountQ(String date) {
		QSsgCtr ssgCtr = QSsgCtr.ssgCtr;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		return from(ssgCtr)
				.innerJoin(ssgCtr.SSG_SITE, ssgSite)
				.orderBy(ssgCtr.SITE_NO.asc(), ssgCtr.TOTAL.desc(), ssgCtr.COUNT.desc())
				.where(ssgCtr.CRITN_DT.eq(date))
				.where(ssgCtr.QUERY.ne("_ALL"))
				.where(ssgCtr.POSITION_NM.eq("ctr"))
				.fetchJoin()
				.fetchCount();
	}

	@Override
	public List<SsgCtr> findNotAllByCritnDtQ(Parameter parameter) {
		QSsgCtr ssgCtr = QSsgCtr.ssgCtr;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		JPQLQuery query =  from(ssgCtr)
				.innerJoin(ssgCtr.SSG_SITE, ssgSite)
				.orderBy(ssgCtr.SITE_NO.asc(), ssgCtr.TOTAL.desc(), ssgCtr.COUNT.desc())
				.where(ssgCtr.CRITN_DT.eq(parameter.getDate()))
				.where(ssgCtr.QUERY.ne("_ALL"))
				.where(ssgCtr.POSITION_NM.eq("ctr"))
				.limit(parameter.getPageSize())
				.offset((parameter.getPage()-1) * parameter.getPageSize());

		if(!StringUtils.isEmpty(parameter.getQuery())) {
			query.where(ssgCtr.QUERY.eq(parameter.getQuery()));
		}

		if(!StringUtils.isEmpty(parameter.getSite())) {
			query.where(ssgCtr.SITE_NO.eq(parameter.getSite()));
		}

		return query
				.fetchJoin()
				.fetch();
	}

	@Override
	public long findNotAllByCritnDtCountQ(Parameter parameter) {
		QSsgCtr ssgCtr = QSsgCtr.ssgCtr;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		JPQLQuery query =  from(ssgCtr)
				.innerJoin(ssgCtr.SSG_SITE, ssgSite)
				.orderBy(ssgCtr.SITE_NO.asc(), ssgCtr.TOTAL.desc(), ssgCtr.COUNT.desc())
				.where(ssgCtr.CRITN_DT.eq(parameter.getDate()))
				.where(ssgCtr.QUERY.ne("_ALL"))
				.where(ssgCtr.POSITION_NM.eq("ctr"))
				.limit(parameter.getPageSize())
				.offset((parameter.getPage()-1) * parameter.getPageSize());

		if(!StringUtils.isEmpty(parameter.getQuery())) {
			query.where(ssgCtr.QUERY.eq(parameter.getQuery()));
		}

		if(!StringUtils.isEmpty(parameter.getSite())) {
			query.where(ssgCtr.SITE_NO.eq(parameter.getSite()));
		}

		return query
				.fetchJoin()
				.fetchCount();
	}
}
