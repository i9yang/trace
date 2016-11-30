package ssg.search.trace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssg.search.trace.dto.SsgArea;
import ssg.search.trace.dto.SsgAreaId;

@Repository
public interface SsgAreaRepository extends JpaRepository<SsgArea,SsgAreaId>, SsgAreaRepositoryCustom {}

