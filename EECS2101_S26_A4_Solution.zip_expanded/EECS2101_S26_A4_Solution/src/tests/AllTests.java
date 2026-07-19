package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   StarterTests.class, // 10
   StarterTestsMod.class, // 10
   ExtraTests.class, // 16
})
public class AllTests {
	
}
