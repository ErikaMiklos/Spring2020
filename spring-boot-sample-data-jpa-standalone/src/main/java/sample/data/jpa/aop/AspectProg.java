package sample.data.jpa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectProg {
    /**
     * Logging
     */
    private final Logger logger = LoggerFactory.getLogger(AspectProg.class);

    @Before(value = "execution(* sample.data.jpa.web.*.*(..))")
    public void logDeclarationBefore(JoinPoint joinPoint){
        logger.info("Executing {}", joinPoint);
    }

    @After(value = "execution(* sample.data.jpa.web.*.*(..))")
    public void logDeclarationAfter(JoinPoint joinPoint){
        logger.info("Complete execution of {}", joinPoint);
    }

}
