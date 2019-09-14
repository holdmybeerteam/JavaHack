package bro.holdmybeerteemjavahack.server.repositories;

import bro.holdmybeerteemjavahack.server.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CompanyRepository extends JpaRepository<Company, BigInteger>
{
}
