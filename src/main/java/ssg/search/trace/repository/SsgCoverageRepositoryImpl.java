package ssg.search.trace.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import ssg.search.trace.dto.QSsgCoverage;
import ssg.search.trace.dto.QSsgSite;
import ssg.search.trace.dto.SsgCoverage;

import java.util.List;

public class SsgCoverageRepositoryImpl extends QueryDslRepositorySupport implements SsgCoverageRepositoryCustom {

	public SsgCoverageRepositoryImpl() {
		super(SsgCoverage.class);
	}

	@Override
	public List<SsgCoverage> findAllQ() {
		return findAllQ(1,9999);
	}

	@Override
	public List<SsgCoverage> findAllQ(int page, int pageSize) {
		QSsgCoverage ssgCoverage = QSsgCoverage.ssgCoverage;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		return from(ssgCoverage)
				.innerJoin(ssgCoverage.SSG_SITE, ssgSite)
				.orderBy(ssgCoverage.SITE_NO.asc())
				.limit(pageSize)
				.offset((page-1) * pageSize)
				.fetchJoin()
				.fetch();
	}

	@Override
	public List<SsgCoverage> findByCritnDtQ(String date) {
		QSsgCoverage ssgCoverage = QSsgCoverage.ssgCoverage;
		QSsgSite ssgSite = QSsgSite.ssgSite;

		return from(ssgCoverage)
				.innerJoin(ssgCoverage.SSG_SITE, ssgSite)
				.orderBy(ssgCoverage.SITE_NO.asc())
				.where(ssgCoverage.CRITN_DT.eq(date))
				.fetchJoin()
				.fetch();
	}
}
