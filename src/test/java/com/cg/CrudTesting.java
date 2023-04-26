package com.cg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.entity.Task;
import com.cg.repository.TaskRepository;

@SpringBootTest
//@ContextConfiguration(classes=Task.class)
@RunWith(SpringRunner.class)

public class CrudTesting {

	@Autowired
	public TaskRepository taskrepository;

	
	/*
	 * @InjectMocks public TaskServiceImplement taskservice;
	 */
	 // @Autowired public TaskController taskcontroller;
	 

	/*
	 * @Before public void setup() { MockitoAnnotations.initMocks(this); }
	 */

	/*
	 * @Test public void contextLoads() throws Exception {
	 * assertThat(taskcontroller).isNotNull();
	 * 
	 * }
	 */

	@Test
	public void testShow() {

		Task t = new Task();
		t.setTid(4);
		t.setTaskName("to do list");
		t.setTaskStatus("True");
		taskrepository.save(t);
		assertNotNull(taskrepository.findById(4).get());

	}

	@Test

	public void testFind() {

		List l = taskrepository.findAll();
		assertThat(l).size().isGreaterThan(0);

	}
	
	
	@Test

	public void TestFindbyid() {
		Task t = taskrepository.findById(4).get();
		assertEquals("to do list", t.getTaskName());

	}
	  
	
		 
	 
	/*
	 * @Test public void testShowAllBookingDetailsMethod() { List<Task> rbd = new
	 * ArrayList<Task>(); TaskRepository brMock =
	 * Mockito.mock(TaskRepository.class); //
	 * TaskServiceImplement.setTaskRepository(brMock);
	 * Mockito.when(brMock.findAll()).thenReturn(rbd); List<Task> actual =
	 * taskservice.showAllTasks(); assertTrue(rbd.equals(actual));
	 * Mockito.verify(brMock, Mockito.times(1)).findAll(); }
	 */
	
	/*
	 * @Test
	 * 
	 * @Order(1)public void showTask () {
	 * 
	 * Task task=new Task(4, "to do list","True", null);
	 * 
	 * taskrepository.save(task);
	 * 
	 * List<Task> tasks= taskservice.showAllTasks();
	 * 
	 * assertEquals(1,tasks.size());
	 * 
	 * assertTrue(tasks.contains(task)); }
	 * 
	 */
	 

}
