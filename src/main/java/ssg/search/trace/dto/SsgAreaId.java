package ssg.search.trace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SsgAreaId implements Serializable {
	private String CRITN_DT;
	private String SITE_NO;
	private String QUERY;
	private String AREA_ID;
	private int PV_COUNT;
	private int CLICK_COUNT;
}