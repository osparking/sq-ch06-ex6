package main;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ProjectConfig;
import model.Comment;
import services.CommentService;
import space.jbpark.utility.MyUtil;

public class Main {
	private static Logger logger = MyUtil.getLogger(Main.class.getName());

	public static void main(String[] args) {
		// @formatter:off
		var context = new AnnotationConfigApplicationContext(
				ProjectConfig.class);
		// @formatter:on
		var comment = new Comment("남한산성은 굴욕의 장소였다.", "김진명");
		var service = context.getBean("commentService", CommentService.class);
		Object result = service.publishComment(comment);
		logger.info("코맨트 생성 및 출판 결과: " + result);
	}

}
