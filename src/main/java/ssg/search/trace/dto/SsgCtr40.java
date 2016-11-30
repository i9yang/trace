package ssg.search.trace.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "SSG_CTR40")
@IdClass(SsgCtrId.class)
public class SsgCtr40 {
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
	private String POSITION_NM;

	@Id
	private int COUNT;

	@Id
	private int TOTAL;
}