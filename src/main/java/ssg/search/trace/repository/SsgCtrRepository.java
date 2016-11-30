package ssg.search.trace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssg.search.trace.dto.SsgCtr;
import ssg.search.trace.dto.SsgCtrId;

@Repository
public interface SsgCtrRepository extends JpaRepository<SsgCtr, SsgCtrId>, SsgCtrRepositoryCustom {}

