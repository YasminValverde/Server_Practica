package cat.institutmarianao;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/* REVIEW - Add the necessary configuration for Spring to work in multilanguage */
	/*
	 * @Bean MessageSource messageSource() { ResourceBundleMessageSource
	 * messageSource = new ResourceBundleMessageSource();
	 * messageSource.setBasename("messages");
	 * messageSource.setDefaultEncoding("UTF-8"); return messageSource; }
	 * 
	 * @Bean LocaleResolver localeResolver() { SessionLocaleResolver resolver = new
	 * SessionLocaleResolver(); resolver.setDefaultLocale(Locale.getDefault());
	 * return resolver; }
	 * 
	 * @Bean LocaleChangeInterceptor localeChangeInterceptor() {
	 * LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
	 * interceptor.setParamName("language"); return interceptor; }
	 * 
	 * @Override public void addInterceptors(InterceptorRegistry registry) {
	 * registry.addInterceptor(localeChangeInterceptor()); }
	 */
}