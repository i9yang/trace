package ssg.search.trace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SsgCoverageId implements Serializable {
	private String CRITN_DT;
	private String SITE_NO;
	private int PV_COUNT;
	private int SUCCESS_COUNT;
	private int NR1_COUNT;
	private int NR2_COUNT;
}