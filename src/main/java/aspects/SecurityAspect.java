package aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import space.jbpark.utility.MyUtil;

@Aspect
@Component
public class SecurityAspect {
	private Logger logger = MyUtil.getLogger(SecurityAspect.class.getName());
	
	@Around("@annotation(ToLog)")
	public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("보안 검사 논리 수행");
		Object result = joinPoint.proceed();
		logger.info("보안 검사 반환값: " + result);
		return result;
		
	}
}
