package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   StarterTests.class, // 7
   StarterTestsMod.class, // 7
   ExtraTestsRanks.class, // 10
   ExtraTestsStats.class, // 4
   ComplexExtraTestsRanks.class, // 3
   ComplexExtraTestsStats.class, // 2
})
public class AllTests {

}
