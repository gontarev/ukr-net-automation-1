package net.ukr.automation.selenium.utils;


import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

@Resource.Classpath("test.properties")
public interface TestProperties {

    @Property("ukr.net.user")
    String getUserName();

    @Property("ukr.net.password")
    String getUserPassword();

}
