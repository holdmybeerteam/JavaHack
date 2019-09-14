package bro.holdmybeerteemjavahack.server.services;

import bro.holdmybeerteemjavahack.server.model.Task;

import java.math.BigInteger;
import java.util.List;

public interface TaskService
{
	BigInteger saveTask(Task task);
	Task getTask(BigInteger taskId);
}
