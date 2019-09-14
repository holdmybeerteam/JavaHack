package bro.holdmybeerteemjavahack.server.repositories;

import bro.holdmybeerteemjavahack.server.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TaskRepository extends JpaRepository<Task, BigInteger>
{
}
