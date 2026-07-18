package tests;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import model.TreeUtilities;

public class ExtraTestsStats extends TestBase {

	TreeUtilities u;

	
    @Before
    public void setup() {
    	u = new TreeUtilities();	
    }
    
    @Test
    public void test_getStats_1() {
    	/*
    	 * comment: getStats from a "deep" tree.
    	 */
    	TreeNode<Integer> tree = t(
    			11, 
    			t(22, 
    					t(33, 
    							t(44, 
    									t(55,
    											t(66)
										)
								)
						)
				)
		);

		TreeNode<String> output = u.getStats(tree);
		checkOutputForAllLevels(output,
				Arrays.asList(
						Arrays.asList(
								statMsg(6, 231)
						),
						Arrays.asList(
								statMsg(5, 220)
						),
						Arrays.asList(
								statMsg(4, 198)
						),
						Arrays.asList(
								statMsg(3, 165)
						),
						Arrays.asList(
								statMsg(2, 121)
						),
						Arrays.asList(
								statMsg(1, 66)
						)
				));
    }
	

    
    @Test
    public void test_getStats_2() {
    	/*
    	 * comment: getStats from a binary tree.
    	 */
    	TreeNode<Integer> tree = t(
    			11, 
    			t(22, 
						t(44),
						t(77)
				),
				t(33, 
						t(55),
						t(66)
				)
		);
    	
		TreeNode<String> output = u.getStats(tree);
		checkOutputForAllLevels(output,
				Arrays.asList(
						Arrays.asList(
								statMsg(7, 308)
						),
						Arrays.asList(
								statMsg(3, 143),
								statMsg(3, 154)
						),
						Arrays.asList(
								statMsg(1, 44),
								statMsg(1, 77)
						),
						Arrays.asList(
								statMsg(1, 55),
								statMsg(1, 66)
						)
				));
    }
    

    
    @Test
    public void test_getStats_3() {
    	/*
    	 * comment: getStats from a "flat" tree.
    	 */
    	TreeNode<Integer> tree = t(
    			11, 
    			t(22),
				t(44),
				t(55),
				t(33),
				t(66)
		);
    	
		TreeNode<String> output = u.getStats(tree);
		checkOutputForAllLevels(output,
				Arrays.asList(
						Arrays.asList(
								statMsg(6, 231)
						),
						Arrays.asList(
								statMsg(1, 22),
								statMsg(1, 44),
								statMsg(1, 55),
								statMsg(1, 33),
								statMsg(1, 66)
						)
				));
    }

    @Test
    public void test_getStats_4() {
    	/*
    	 * comment: getStats from a tree of an arbitrary shape with negative & duplicate values.
    	 */
    	TreeNode<Integer> tree = t(
    			11, 
    			t(22,
    					t(55),
    					t(33, 
    							t(33)
						),
    					t(-33)
				),
				t(-44),
				t(0, 
						t(-4, 
								t(10), t(21), t(38)
						)
				)
		);
    	
		TreeNode<String> output = u.getStats(tree);
		// nodes order: (11), (22, -44, 0), (55, 33, -33), null, (-4), null, (33), null, (10, 21, 38)
		checkOutputForAllLevels(output,
				Arrays.asList(
						Arrays.asList(
								statMsg(12, 142)
						),
						Arrays.asList(
								statMsg(5, 110),
								statMsg(1, -44),
								statMsg(5, 65)
						),
						Arrays.asList(
								statMsg(1, 55),
								statMsg(2, 66),
								statMsg(1, -33)
						),
						null,
						Arrays.asList(
								statMsg(4, 65)
						),
						null,
						Arrays.asList(
								statMsg(1, 33)
						),
						null,
						Arrays.asList(
								statMsg(1, 10),
								statMsg(1, 21),
								statMsg(1, 38)
						)
				));
    }
}
