package bro.holdmybeerteemjavahack.server.services;

import bro.holdmybeerteemjavahack.server.model.Task;
import bro.holdmybeerteemjavahack.server.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
public class TaskServiceImpl implements TaskService
{
	private final TaskRepository taskRepository;

	public TaskServiceImpl(TaskRepository taskRepository)
	{
		this.taskRepository = taskRepository;
	}

	@Transactional
	@Override
	public BigInteger saveTask(Task task)
	{
		return taskRepository.save(task).getId();
	}

	@Override
	public Task getTask(BigInteger taskId) {
		return taskRepository.getOne(taskId);
	}

}
