package ssg.search.trace.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "SSG_COVERAGE")
@IdClass(SsgCoverageId.class)
public class SsgCoverage {
	@Id
	private String CRITN_DT;

	@Id
	private String SITE_NO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SITE_NO", insertable = false, updatable  = false)
	private SsgSite SSG_SITE;

	@Id
	private int PV_COUNT;

	@Id
	private int SUCCESS_COUNT;

	@Id
	private int NR1_COUNT;

	@Id
	private int NR2_COUNT;
}