package testModel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AffichableTest.class, DaemonTest.class, MapCreatorTest.class, SpellTest.class, WorldTest.class })
public class AllTests {

}
