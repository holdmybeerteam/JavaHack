package bro.holdmybeerteemjavahack.server.services;

import bro.holdmybeerteemjavahack.server.model.Company;

import java.math.BigInteger;
import java.util.List;


public interface CompanyService {
	BigInteger save(Company company);
	List<Company> getCompanies();
	Company getCompany(BigInteger id);
}
