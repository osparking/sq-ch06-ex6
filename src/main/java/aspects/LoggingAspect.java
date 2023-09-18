package aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import space.jbpark.utility.MyUtil;

@Aspect
@Order(1)
public class LoggingAspect {
	private Logger logger = MyUtil.getLogger(LoggingAspect.class.getName());
	
	@Around("@annotation(ToLog)")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("차단 전");
		var result = joinPoint.proceed();
		logger.info("반환 후");
		return result;
	}
}
