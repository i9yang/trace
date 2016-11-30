package ssg.search.trace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SsgCtrId implements Serializable {
	private String CRITN_DT;
	private String SITE_NO;
	private String QUERY;
	private String POSITION_NM;
	private int COUNT;
	private int TOTAL;
}