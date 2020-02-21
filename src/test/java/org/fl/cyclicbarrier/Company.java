package test.java.org.fl.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author david
 * @create 2018-08-09 15:24
 **/
public class Company {

	public static void main(String[] args) throws InterruptedException {

		//员工数量
		int count = 5;
		//创建计数器
		CyclicBarrier barrier = new CyclicBarrier(count + 1);

		//创建线程池，可以通过以下方式创建
		//ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1,1,60,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>
		// (count));
		ExecutorService threadPool = Executors.newFixedThreadPool(count);

		System.out.println("公司发送通知，每一位员工在周六早上8点【自驾车】到公司大门口集合");
		for (int i = 0; i < count; i++) {
			//将子线程添加进线程池执行
			threadPool.execute(new Employee(barrier, i + 1));
			Thread.sleep(10);
		}
		try {
			//阻塞当前线程，直到所有员工到达公司大门口之后才执行
			barrier.await();
			Thread.sleep(10);
			// 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断或超出了指定的等待时间。
			//latch.await(long timeout, TimeUnit unit)
			System.out.println("所有员工已经到达公司大门口，公司领导一并【自驾车】同员工前往活动目的地。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		} finally {
			//最后关闭线程池，但执行以前提交的任务，不接受新任务
			threadPool.shutdown();
			//关闭线程池，停止所有正在执行的活动任务，暂停处理正在等待的任务，并返回等待执行的任务列表。
			//threadPool.shutdownNow();
		}
	}
}
