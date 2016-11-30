package ssg.search.trace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssg.search.trace.dto.SsgCtr40;
import ssg.search.trace.dto.SsgCtrId;

@Repository
public interface SsgCtr40Repository extends JpaRepository<SsgCtr40, SsgCtrId>, SsgCtr40RepositoryCustom {}

