package dev.swanhtet.todolist;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
    viewControllerRegistry.addViewController("/addition").setViewName("addition");
  }
}
