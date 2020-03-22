package de.howtohelppeople;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.NotNull;

import java.util.Set;

import static org.mockito.Mockito.spy;

public class TestApp extends HowToHelpPeopleApp{

	private static final Set<String> BEANS_TO_SPY_ON = Set.of(
			""
	);

	@Bean
	public BeanPostProcessor beanPostProcessorForSpyingOnBeans() {
		return new BeanPostProcessor() {
			@Override
			public Object postProcessAfterInitialization(@NotNull Object bean, String beanName) throws BeansException {
				if (BEANS_TO_SPY_ON.contains(beanName)) {
					return spy(bean);
				}
				return bean;
			}
		};
	}
}
