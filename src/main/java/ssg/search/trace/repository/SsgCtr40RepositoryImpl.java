package ssg.search.trace.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import ssg.search.trace.dto.*;

import java.util.List;

public class SsgCtr40RepositoryImpl extends QueryDslRepositorySupport implements SsgCtr40RepositoryCustom {

	public SsgCtr40RepositoryImpl() {
		super(SsgCtr40.class);
	}

	@Override
	public List<SsgCtr40> findByCritnDtQ(String date) {
		QSsgCtr40 ssgCtr40 = QSsgCtr40.ssgCtr40;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		return from(ssgCtr40)
				.innerJoin(ssgCtr40.SSG_SITE, ssgSite)
				.orderBy(ssgCtr40.SITE_NO.asc(), ssgCtr40.TOTAL.desc(), ssgCtr40.COUNT.desc())
				.where(ssgCtr40.CRITN_DT.eq(date))
				.where(ssgCtr40.QUERY.eq("_ALL"))
				.where(ssgCtr40.POSITION_NM.eq("ctr"))
				.fetchJoin()
				.fetch();
	}

	@Override
	public List<SsgCtr40> findNotAllByCritnDtQ(String date, int page, int pageSize) {
		QSsgCtr40 ssgCtr40 = QSsgCtr40.ssgCtr40;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		return from(ssgCtr40)
				.innerJoin(ssgCtr40.SSG_SITE, ssgSite)
				.orderBy(ssgCtr40.SITE_NO.asc(), ssgCtr40.TOTAL.desc(), ssgCtr40.COUNT.desc())
				.where(ssgCtr40.CRITN_DT.eq(date))
				.where(ssgCtr40.QUERY.ne("_ALL"))
				.where(ssgCtr40.POSITION_NM.eq("ctr"))
				.limit(pageSize)
				.offset((page-1) * pageSize)
				.fetchJoin()
				.fetch();
	}

	@Override
	public long findNotAllByCritnDtCountQ(String date) {
		QSsgCtr40 ssgCtr40 = QSsgCtr40.ssgCtr40;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		return from(ssgCtr40)
				.innerJoin(ssgCtr40.SSG_SITE, ssgSite)
				.orderBy(ssgCtr40.SITE_NO.asc(), ssgCtr40.TOTAL.desc(), ssgCtr40.COUNT.desc())
				.where(ssgCtr40.CRITN_DT.eq(date))
				.where(ssgCtr40.QUERY.ne("_ALL"))
				.where(ssgCtr40.POSITION_NM.eq("ctr"))
				.fetchJoin()
				.fetchCount();
	}
}
