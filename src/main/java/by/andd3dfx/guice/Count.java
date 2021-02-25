package by.andd3dfx.guice;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import javax.inject.Qualifier;

@Qualifier
@Retention(RUNTIME)
@interface Count {

}
