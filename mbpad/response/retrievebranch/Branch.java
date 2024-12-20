package com.td.api.mbpad.response.retrievebranch;

import java.util.List;

import lombok.Data;

@Data
public class Branch {
	private String financialInstitutionBankNum;
	private List<FinancialInstitutionName> financialInstitutionName;
	private String internalOrganizationBranchNum;
	private String financialInstitutionTypeName;
	private Locator locator;
}
