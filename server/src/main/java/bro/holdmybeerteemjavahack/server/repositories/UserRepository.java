package bro.holdmybeerteemjavahack.server.repositories;

import bro.holdmybeerteemjavahack.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User, BigInteger>
{
}
