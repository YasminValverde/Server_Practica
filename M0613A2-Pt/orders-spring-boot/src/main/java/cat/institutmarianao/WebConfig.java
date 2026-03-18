package cat.institutmarianao;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/* Internationalization configuration */

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		// messages.properties, messages_es.properties, etc are on classpath
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setFallbackToSystemLocale(false);
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		// set default locale (choose 'es' or system default)
		resolver.setDefaultLocale(new Locale("es"));
		return resolver;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		// the templates use ?language=es and ?language=en
		interceptor.setParamName("language");
		return interceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
}