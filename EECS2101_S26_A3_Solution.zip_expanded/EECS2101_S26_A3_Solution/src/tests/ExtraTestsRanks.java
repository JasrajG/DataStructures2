package tests;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import model.TreeUtilities;

public class ExtraTestsRanks extends TestBase {

	TreeUtilities u;

	
    @Before
    public void setup() {
    	u = new TreeUtilities();	
    }
    
	@Test
	public void test_getElementsOfRanks_normal() {
		/*
		 * comment: get each element from the tree with getElementsOfRanks. 
		 */
		TreeNode<Integer> tree = t(
				90,
				t(1), 
				t(22, 
						t(33)
				)
		);
		SLLNode<Integer> output = u.getElementsOfRanks(tree, 1, 1);
		checkValuesInOrder(
				Arrays.asList(1), output
		);
		output = u.getElementsOfRanks(tree, 2, 2);
		checkValuesInOrder(
				Arrays.asList(22), output
		);
		output = u.getElementsOfRanks(tree, 3, 3);
		checkValuesInOrder(
				Arrays.asList(33), output
		);
	}
	

	@Test
	public void test_getElementsOfRanks_normal_2() {
		/*
		 * comment: test "flat" tree structure: there are only two levels in the tree. 
		 */
		TreeNode<Integer> tree = t(
				90,
				t(1), t(22), t(33), t(99), t(83)
		);
		// order: 1, 22, 33, 83, 90, 99
		SLLNode<Integer> output = u.getElementsOfRanks(tree, 3, 3);
		checkValuesInOrder(
				Arrays.asList(33), output
		);
		output = u.getElementsOfRanks(tree, 6, 6);
		checkValuesInOrder(
				Arrays.asList(99), output
		);
	}
	

	@Test
	public void test_getElementsOfRanks_normal_3() {
		/*
		 * comment: test "deep" tree structure: each node has only one parent. 
		 */
		TreeNode<Integer> tree = t(
				90,
				t(1, 
						t(22, 
								t(33, 
										t(99, 
												t(83)
										)
								)
						) 
				)
		);
		// order: 1, 22, 33, 83, 90, 99
		SLLNode<Integer> output = u.getElementsOfRanks(tree, 2, 2);
		checkValuesInOrder(
				Arrays.asList(22), output
		);
		output = u.getElementsOfRanks(tree, 5, 5);
		checkValuesInOrder(
				Arrays.asList(90), output
		);
	}
	

	@Test
	public void test_getElementsOfRanks_normal_4() {
		/*
		 * comment: test binary tree structure: each node has two children. 
		 */
		TreeNode<Integer> tree = t(
				90,
				t(1, 
						t(22), 
						t(34)
				),
				t(2, 
						t(12,
								t(36), 
								t(37, 
										t(67), t(92)
								)
						),
						t(18)
				)
		);
		// order: 1, 2, 12, 18, 22, 34, 36, 37, 67, 90, 92
		SLLNode<Integer> output = u.getElementsOfRanks(tree, 4, 10);
		checkValuesInOrder(
				Arrays.asList(18, 22, 34, 36, 37, 67, 90), output
		);
		output = u.getElementsOfRanks(tree, 2, 2);
		checkValuesInOrder(
				Arrays.asList(2), output
		);
	}
	
	// this one is from Jackie.
    @Test
    public void test_getElementsOfRanks_duplicate_1() {
    	/*
    	 * comment: tree nodes with duplicate values.
    	 * 
    	 */
    	TreeNode<Integer> tree = t(
    			46, 
    			t(23, 
    					t(92), t(69)
				),
    			t(69, 
    					t(138)
				),
    			t(161)
		);
	
    	SLLNode<Integer> output = u.getElementsOfRanks(tree, 3, 5);
		checkValuesInOrder(
				Arrays.asList(69, 69, 92), output
		);
    }
    
    

    @Test
    public void test_getElementsOfRanks_duplicate_2() {
    	/*
    	 * comment: tree nodes with duplicate values (binary tree)
    	 * 
    	 */
    	TreeNode<Integer> tree = t(
    			46, 
    			t(23, 
    					t(11), 
    					t(69)
				),
    			t(69, 
    					t(11),
    					t(161,
    							t(33), t(33)
    					)
				)
		);
    	
    	// order: 11, 11,  23, 33, 33, 46, 69, 69, 161 
    	SLLNode<Integer> output = u.getElementsOfRanks(tree, 1, 8);
		checkValuesInOrder(
				Arrays.asList(11, 11, 23, 33, 33, 46, 69, 69), output
		);
    }


    @Test
    public void test_getElementsOfRanks_duplicate_3() {
    	/*
    	 * comment: tree nodes with duplicate values (deep tree)
    	 * 
    	 */
    	TreeNode<Integer> tree = t(
    			46, 
    			t(23, 
    					t(11),
		    			t(46, 
		    					t(11),
		    					t(161, 
		    							t(22), 
		    							t(23, 
		    									t(46,
		    			    							t(33, t(33))
    			    							)
    			    					)
    							)
						)
				)
		);
    	
    	// order: 11, 11, 22, 23, 23, 33, 33, 46, 46, 46, 161 
    	SLLNode<Integer> output = u.getElementsOfRanks(tree, 1, 9);
		checkValuesInOrder(
				Arrays.asList(11, 11, 22, 23, 23, 33, 33, 46, 46), output
		);
    }

	// this one is from Jackie.
    @Test
    public void test_getElementsOfRanks_negative_1() {
    	/*
    	 * comment: tree nodes with negative values.
    	 */

    	TreeNode<Integer> tree = t(
    			-46, 
    			t(-23, 
    					t(-92), t(-69)
				),
    			t(115, 
    					t(138)
				),
    			t(161)
		);
	
    	SLLNode<Integer> output = u.getElementsOfRanks(tree, 2, 6);
		checkValuesInOrder(
				Arrays.asList(-69, -46, -23, 115, 138), output
		);
    }

    @Test
    public void test_getElementsOfRanks_negative_2() {
    	/*
    	 * comment: tree nodes with negative values (binary tree).
    	 */

    	TreeNode<Integer> tree = t(
    			-46, 
    			t(115, 
    					t(138),t(-161)
    			),
    			t(-23, 
    					t(-92,
    							t(-3), t(-4)
						), 
    					t(-69,
								t(-9), t(-10)
						)
    			)
		);
    		
    	// order: -161, -92, -69, -46, -23, -10, -9, -4, -3, 115, 138 
    	SLLNode<Integer> output = u.getElementsOfRanks(tree, 3, 8);
		checkValuesInOrder(
				Arrays.asList(-69, -46, -23, -10, -9, -4), output
		);
    }
    

    @Test
    public void test_getElementsOfRanks_negative_3() {
    	/*
    	 * comment: tree nodes with negative values (deep tree).
    	 */

    	TreeNode<Integer> tree = t(
    			-46, 
    			t(-22, 
					t(-92,
							t(3),
			    			t(115, 
			    					t(138,
			    							t(-161, t(4))
	    							)
	    					)
					)
				)
		);
    		
    	// order: -161, -92, -46, -22, 3, 4, 115, 138 
    	SLLNode<Integer> output = u.getElementsOfRanks(tree, 4, 8);
		checkValuesInOrder(
				Arrays.asList(-22, 3, 4, 115, 138), output
		);
    }

//  @Test
//  public void test_getElementsOfRanks_5() {
//      TreeNode<Integer> n1 = new TreeNode<>(23);
//      TreeNode<Integer> n2 = new TreeNode<>(46);
//      TreeNode<Integer> n3 = new TreeNode<>(69);
//      TreeNode<Integer> n4 = new TreeNode<>(92);
//      TreeNode<Integer> n5 = new TreeNode<>(69);
//      TreeNode<Integer> n6 = new TreeNode<>(138);
//      TreeNode<Integer> n7 = new TreeNode<>(161);
//     
//      n2.addChild(n1); n1.setParent(n2);
//      n2.addChild(n5); n5.setParent(n2);
//      n2.addChild(n7); n7.setParent(n2);
//      n1.addChild(n4); n4.setParent(n1);
//      n1.addChild(n3); n3.setParent(n1);
//      n5.addChild(n6); n6.setParent(n5);
//     
//      TreeUtilities u = new TreeUtilities();
//     
//      SLLNode<Integer> output = u.getElementsOfRanks(n2, 3, 5);
//      assertTrue(output.getElement() == 69);
//      assertTrue(output.getNext().getElement() == 69);
//      assertTrue(output.getNext().getNext().getElement() == 92);
//      assertNull(output.getNext().getNext().getNext());
//  }
    
//    
//    @Test
//    public void test_getElementsOfRanks_6() {
//        TreeNode<Integer> n1 = new TreeNode<>(-23);
//        TreeNode<Integer> n2 = new TreeNode<>(-46);
//        TreeNode<Integer> n3 = new TreeNode<>(-69);
//        TreeNode<Integer> n4 = new TreeNode<>(-92);
//        TreeNode<Integer> n5 = new TreeNode<>(115);
//        TreeNode<Integer> n6 = new TreeNode<>(138);
//        TreeNode<Integer> n7 = new TreeNode<>(161);
//       
//        n2.addChild(n1); n1.setParent(n2);
//        n2.addChild(n5); n5.setParent(n2);
//        n2.addChild(n7); n7.setParent(n2);
//        n1.addChild(n4); n4.setParent(n1);
//        n1.addChild(n3); n3.setParent(n1);
//        n5.addChild(n6); n6.setParent(n5);
//       
//        TreeUtilities u = new TreeUtilities();
//       
//        SLLNode<Integer> output = u.getElementsOfRanks(n2, 2, 6);
//        assertTrue(output.getElement() == -69);
//        assertTrue(output.getNext().getElement() == -46);
//        assertTrue(output.getNext().getNext().getElement() == -23);
//        assertTrue(output.getNext().getNext().getNext().getElement() == 115);
//        assertTrue(output.getNext().getNext().getNext().getNext().getElement() == 138);
//        assertNull(output.getNext().getNext().getNext().getNext().getNext());
//    }

}
