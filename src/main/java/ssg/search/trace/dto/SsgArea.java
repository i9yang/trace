package ssg.search.trace.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "SSG_AREA")
@IdClass(SsgAreaId.class)
public class SsgArea {
	@Id
	private String CRITN_DT;

	@Id
	private String SITE_NO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SITE_NO", insertable = false, updatable  = false)
	private SsgSite SSG_SITE;

	@Id
	private String QUERY;

	@Id
	private String AREA_ID;

	@Id
	private int PV_COUNT;

	@Id
	private int CLICK_COUNT;

}
