package ssg.search.trace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssg.search.trace.dto.SsgCoverage;
import ssg.search.trace.dto.SsgCoverageId;

@Repository
public interface SsgCoverageRepository extends JpaRepository<SsgCoverage, SsgCoverageId>, SsgCoverageRepositoryCustom {}

