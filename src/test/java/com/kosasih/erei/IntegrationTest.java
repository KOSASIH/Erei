package com.kosasih.erei;

import com.kosasih.erei.EreiApp;
import com.kosasih.erei.config.AsyncSyncConfiguration;
import com.kosasih.erei.config.EmbeddedElasticsearch;
import com.kosasih.erei.config.EmbeddedKafka;
import com.kosasih.erei.config.EmbeddedSQL;
import com.kosasih.erei.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { EreiApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
