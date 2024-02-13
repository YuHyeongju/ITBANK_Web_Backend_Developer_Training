package com.itbank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// JSON 데이터에서 DTO에 명시되지 않은 속성(알 수 없는 속성) 은 무시하겠다.
@JsonIgnoreProperties(ignoreUnknown = true)

//JSON의 속성이름을 자바 네이밍 컨벤션(camelCase)으로 변환하는 과정이 맞아야 한다.
public class FestivalDTO { // 이렇게 하면 DTO에서 매핑 가능함.
	@JsonProperty("UC_SEQ")
	private int UC_SEQ;
	@JsonProperty("MAIN_TITLE")
	private String MAIN_TITLE;
	@JsonProperty("GUGUN_NM")
	private String GUGUN_NM;
	@JsonProperty("HOMEPAGE_URL")
	private String HOMEPAGE_URL;
	@JsonProperty("HOME_IMG_NORMAL")
	private String HOME_IMG_NORMAL;
	@JsonProperty("ITEMCNTNTS")
	private String ITEMCNTNTS;

	public int getUC_SEQ() {
		return UC_SEQ;
	}

	public void setUC_SEQ(int uC_SEQ) {
		UC_SEQ = uC_SEQ;
	}

	public String getMAIN_TITLE() {
		return MAIN_TITLE;
	}

	public void setMAIN_TITLE(String mAIN_TITLE) {
		MAIN_TITLE = mAIN_TITLE;
	}

	public String getGUGUN_NM() {
		return GUGUN_NM;
	}

	public void setGUGUN_NM(String gUGUN_NM) {
		GUGUN_NM = gUGUN_NM;
	}

	public String getHOMEPAGE_URL() {
		return HOMEPAGE_URL;
	}

	public void setHOMEPAGE_URL(String hOMEPAGE_URL) {
		HOMEPAGE_URL = hOMEPAGE_URL;
	}

	public String getHOME_IMG_NORMAL() {
		return HOME_IMG_NORMAL;
	}

	public void setHOME_IMG_NORMAL(String hOME_IMG_NORMAL) {
		HOME_IMG_NORMAL = hOME_IMG_NORMAL;
	}

	public String getITEMCNTNTS() {
		return ITEMCNTNTS;
	}

	public void setITEMCNTNTS(String iTEMCNTNTS) {
		ITEMCNTNTS = iTEMCNTNTS;
	}

}