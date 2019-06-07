package ssg.search.trace.repository;

import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.util.StringUtils;
import ssg.search.trace.dto.Parameter;
import ssg.search.trace.dto.QSsgArea;
import ssg.search.trace.dto.QSsgSite;
import ssg.search.trace.dto.SsgArea;

import java.util.List;

public class SsgAreaRepositoryImpl extends QueryDslRepositorySupport implements SsgAreaRepositoryCustom {

	public SsgAreaRepositoryImpl() {
		super(SsgArea.class);
	}

	@Override
	public List<SsgArea> findByCritnDtQ(String date) {
		QSsgArea ssgArea = QSsgArea.ssgArea;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		return from(ssgArea)
				.innerJoin(ssgArea.SSG_SITE, ssgSite)
				.orderBy(ssgArea.SITE_NO.asc(), ssgArea.PV_COUNT.desc(), ssgArea.CLICK_COUNT.desc())
				.where(ssgArea.CRITN_DT.eq(date))
				.where(ssgArea.QUERY.eq("_ALL"))
				.fetchJoin()
				.fetch();
	}

	@Override
	public List<SsgArea> findNotAllByCritnDtQ(String date, int page, int pageSize) {
		QSsgArea ssgArea = QSsgArea.ssgArea;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		return from(ssgArea)
				.innerJoin(ssgArea.SSG_SITE, ssgSite)
				.orderBy(ssgArea.SITE_NO.asc(), ssgArea.PV_COUNT.desc(), ssgArea.CLICK_COUNT.desc())
				.where(ssgArea.CRITN_DT.eq(date))
				.where(ssgArea.QUERY.ne("_ALL"))
				.limit(pageSize)
				.offset((page-1) * pageSize)
				.fetchJoin()
				.fetch();
	}

	@Override
	public long findNotAllByCritnDtCountQ(String date) {
		QSsgArea ssgArea = QSsgArea.ssgArea;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		return from(ssgArea)
				.innerJoin(ssgArea.SSG_SITE, ssgSite)
				.orderBy(ssgArea.SITE_NO.asc(), ssgArea.PV_COUNT.desc(), ssgArea.CLICK_COUNT.desc())
				.where(ssgArea.CRITN_DT.eq(date))
				.where(ssgArea.QUERY.ne("_ALL"))
				.fetchJoin()
				.fetchCount();
	}

	@Override
	public List<SsgArea> findNotAllByCritnDtQ(Parameter parameter) {
		QSsgArea ssgArea = QSsgArea.ssgArea;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		JPQLQuery query = from(ssgArea)
				.innerJoin(ssgArea.SSG_SITE, ssgSite)
				.orderBy(ssgArea.SITE_NO.asc(), ssgArea.PV_COUNT.desc(), ssgArea.CLICK_COUNT.desc())
				.where(ssgArea.CRITN_DT.eq(parameter.getDate()))
				.limit(parameter.getPageSize())
				.offset((parameter.getPage()-1) * parameter.getPageSize());

		if(!StringUtils.isEmpty(parameter.getQuery())) {
			query.where(ssgArea.QUERY.eq(parameter.getQuery()));
		}

		if(!StringUtils.isEmpty(parameter.getSite())) {
			query.where(ssgArea.SITE_NO.eq(parameter.getSite()));
		}

		return query
				.fetchJoin()
				.fetch();
	}

	@Override
	public long findNotAllByCritnDtCountQ(Parameter parameter) {
		QSsgArea ssgArea = QSsgArea.ssgArea;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		JPQLQuery query = from(ssgArea)
				.innerJoin(ssgArea.SSG_SITE, ssgSite)
				.orderBy(ssgArea.SITE_NO.asc(), ssgArea.PV_COUNT.desc(), ssgArea.CLICK_COUNT.desc())
				.where(ssgArea.CRITN_DT.eq(parameter.getDate()))
				.limit(parameter.getPageSize())
				.offset((parameter.getPage()-1) * parameter.getPageSize());

		if(!StringUtils.isEmpty(parameter.getQuery())) {
			query.where(ssgArea.QUERY.eq(parameter.getQuery()));
		}

		if(!StringUtils.isEmpty(parameter.getSite())) {
			query.where(ssgArea.SITE_NO.eq(parameter.getSite()));
		}

		return query
				.fetchJoin()
				.fetchCount();
	}
}
