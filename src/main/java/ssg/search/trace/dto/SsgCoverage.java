package ssg.search.trace.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "SSG_COVERAGE")
@IdClass(SsgCoverageId.class)
public class SsgCoverage implements Serializable {
	@Id
	private String CRITN_DT;

	@Id
	private String SITE_NO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SITE_NO", insertable = false, updatable  = false)
	private SsgSite SSG_SITE;

	private int PV_COUNT;
	private int SUCCESS_COUNT;
	private int NR1_COUNT;
	private int NR2_COUNT;
}