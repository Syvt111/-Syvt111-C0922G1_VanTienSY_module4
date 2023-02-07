package blog_application.repository;

import blog_application.model.BlogApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<BlogApp,Integer> {

}

