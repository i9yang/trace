package ssg.search.trace.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import ssg.search.trace.dto.*;

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
				.where(ssgArea.PV_COUNT.gt(0))
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
				.where(ssgArea.PV_COUNT.gt(0))
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
				.where(ssgArea.PV_COUNT.gt(0))
				.fetchJoin()
				.fetchCount();
	}
}
