package tests;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import model.TreeUtilities;

public class TestDemo extends TestBase {
	TreeUtilities u;

    @Before
    public void setup() {
    	u = new TreeUtilities();	
    }
    
	@Test
	/**
	 * This is a demonstration of the helper functions, 
	 * this test case is exactly the same as test_getStats_3 in the StarterTests.
	 */
	public void test_getStats() {
		TreeNode<Integer> tree = t(
				46,
				t(23, 
					t(92), t(69)
				), 
				t(115,
					t(138)
				), 
				t(161)
		);
		TreeNode<String> output = u.getStats(tree);
		checkOutputForAllLevels(output,
				Arrays.asList(
						Arrays.asList(
								statMsg(7, 644)
						),
						Arrays.asList(
								statMsg(3, 184),
								statMsg(2, 253),
								statMsg(1, 161)
						),
						Arrays.asList(
								statMsg(1, 92),
								statMsg(1, 69)
						),
						Arrays.asList(
								statMsg(1, 138)
						)
				));
	}
	
	@Test
	/**
	 * this is a demonstration of the helper functions.
	 * this test case is the same as test_general_trees_construction_strings in the TestGeneralTrees.
	 * Note that this only checks the final state of the tree.
	 */
	public void test_general_tree() {
		TreeNode<String> tree = t(
				"Jonathan",
				t("Alan"), 
				t("Mark"), 
				t("Tom")
		);
		checkOutputForAllLevels(tree,
				Arrays.asList(
						Arrays.asList(
								"Jonathan"
						),
						Arrays.asList(
								"Alan", "Mark", "Tom"
						)
				));
	}
}
