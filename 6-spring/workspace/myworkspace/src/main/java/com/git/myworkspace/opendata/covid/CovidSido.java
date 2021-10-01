package com.git.myworkspace.opendata.covid;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CovidSido {
	@Id
	private String gubun; // ����
	@Id
	private String stdDay; // �����Ͻ�

	private String defCnt; // Ȯ���� ��
	private String incDec; // ���� ��� ���� ��
	private String deathCnt; // ����� ��
	private String isolIngCnt; // �ݸ��� ��
	private String localOccCnt; // �����߻� ��
	private String overFlowCnt; // �ؿ����� ��
}
