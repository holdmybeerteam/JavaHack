package bro.holdmybeerteemjavahack.server.services;

import bro.holdmybeerteemjavahack.server.model.Task;
import bro.holdmybeerteemjavahack.server.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService
{
	@Autowired
	private TaskRepository taskRepository;

	@Transactional
	@Override
	public BigInteger createTask(Task task)
	{
		return taskRepository.save(task).getId();
	}
}
