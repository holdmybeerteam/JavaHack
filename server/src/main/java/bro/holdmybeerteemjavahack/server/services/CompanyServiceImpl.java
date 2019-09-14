package bro.holdmybeerteemjavahack.server.services;

import bro.holdmybeerteemjavahack.server.model.Company;
import bro.holdmybeerteemjavahack.server.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService
{
	private final CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository)
	{
		this.companyRepository = companyRepository;
	}

	@Transactional
	@Override
	public BigInteger save(Company company)
	{
		Company savedCompany = companyRepository.save(company);
		return savedCompany.getId();
	}

	@Override
	public List<Company> getCompanies()
	{
		return companyRepository.findAll();
	}

	@Override
	public Company getCompany(BigInteger id)
	{
		return companyRepository.getOne(id);
	}
}
