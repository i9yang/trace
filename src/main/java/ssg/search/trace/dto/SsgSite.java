package ssg.search.trace.dto;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "SSG_SITE")
@Embeddable
public class SsgSite {
	@Id
	private String SITE_NO;

	private String SITE_NM;
}
