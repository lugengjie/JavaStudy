/* 
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */
 
package ���߳�;

import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;


import java.util.Date;
/**
 * quartzѧϰ����
 * @author jie
 *
 */
public class SimpleExample {

  public void run() throws Exception {
  

	//1.����scheduler����
    SchedulerFactory sf = new StdSchedulerFactory();
    //2.�ӹ����л�ȡ������
    Scheduler sched = sf.getScheduler();
    // 3.����JobDetail
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
    //ʱ��
    Date runTime = evenSecondDateAfterNow();
    //4.������
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
    //5.ע������ʹ�������
    sched.scheduleJob(job, trigger);
    //6.start
    sched.start();
    try {
      //5���ֹͣ
      Thread.sleep(5L * 1000L);
    } catch (Exception e) {
    }
    sched.shutdown(true);
  }

  public static void main(String[] args) throws Exception {

    SimpleExample example = new SimpleExample();
    example.run();

  }

}
