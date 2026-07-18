package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.TreeNode;
import model.TreeUtilities;

public class TestGeneralTrees {
	
	@Test
	public void test_general_trees_construction() {
		TreeNode<String> agnarr = new TreeNode<>("Agnarr");
		TreeNode<String> elsa = new TreeNode<>("Elsa");
		TreeNode<String> anna = new TreeNode<>("Anna");
		
		agnarr.addChild(elsa);
		agnarr.addChild(anna);
		elsa.setParent(agnarr);
		anna.setParent(agnarr);
		
		assertNull(agnarr.getParent());
		assertTrue(agnarr == elsa.getParent());
		assertTrue(agnarr == anna.getParent());
		assertTrue(agnarr.getChildren().length == 2);
		assertTrue(agnarr.getChildren()[0] == elsa);
		assertTrue(agnarr.getChildren()[1] == anna);
	}

	@Test
	public void test_general_trees_depths() {
		TreeNode<String> david = new TreeNode<>("David");
		TreeNode<String> ernesto = new TreeNode<>("Ernesto");
		TreeNode<String> chris = new TreeNode<>("Chris");
		TreeNode<String> elsa = new TreeNode<>("Elsa");
		TreeNode<String> anna = new TreeNode<>("Anna");
		TreeNode<String> shirley = new TreeNode<>("Shirley");
		TreeNode<String> vanessa = new TreeNode<>("Vanessa");
		TreeNode<String> peter = new TreeNode<>("Peter");
		
		/* Nodes with depth 1 */
		ernesto.setParent(david); david.addChild(ernesto);
		chris.setParent(david); david.addChild(chris);
		
		/* Nodes with depth 2 */
		elsa.setParent(chris); chris.addChild(elsa);
		anna.setParent(chris); chris.addChild(anna);
		
		/* Nodes with depth 3 */
		shirley.setParent(elsa); elsa.addChild(shirley);
		vanessa.setParent(elsa); elsa.addChild(vanessa);
		peter.setParent(elsa); elsa.addChild(peter);
		
		TreeUtilities<String> u = new TreeUtilities<>();
		assertEquals(0, u.depth(david));
		assertEquals(1, u.depth(ernesto));
		assertEquals(1, u.depth(chris));
		assertEquals(2, u.depth(elsa));
		assertEquals(2, u.depth(anna));
		assertEquals(3, u.depth(shirley));
		assertEquals(3, u.depth(vanessa));
		assertEquals(3, u.depth(peter));
	}

	@Test
	public void test_general_trees_heights() {
		TreeNode<String> david = new TreeNode<>("David");
		TreeNode<String> ernesto = new TreeNode<>("Ernesto");
		TreeNode<String> chris = new TreeNode<>("Chris");
		TreeNode<String> elsa = new TreeNode<>("Elsa");
		TreeNode<String> anna = new TreeNode<>("Anna");
		TreeNode<String> shirley = new TreeNode<>("Shirley");
		TreeNode<String> vanessa = new TreeNode<>("Vanessa");
		TreeNode<String> peter = new TreeNode<>("Peter");
		
		/* Nodes with depth 1 */
		ernesto.setParent(david); david.addChild(ernesto);
		chris.setParent(david); david.addChild(chris);
		
		/* Nodes with depth 2 */
		elsa.setParent(chris); chris.addChild(elsa);
		anna.setParent(chris); chris.addChild(anna);
		
		/* Nodes with depth 3 */
		shirley.setParent(elsa); elsa.addChild(shirley);
		vanessa.setParent(elsa); elsa.addChild(vanessa);
		peter.setParent(elsa); elsa.addChild(peter);
		
		TreeUtilities<String> u = new TreeUtilities<>();
		
		/* internal nodes */
		assertEquals(3, u.height(david));
		assertEquals(2, u.height(chris));
		assertEquals(1, u.height(elsa));
		
		/* external nodes */
		assertEquals(0, u.height(ernesto));
		assertEquals(0, u.height(anna));
		assertEquals(0, u.height(shirley));
		assertEquals(0, u.height(vanessa));
		assertEquals(0, u.height(peter));
	}
	

	@Test
	public void test_general_trees_ancestors() {
		TreeNode<String> david = new TreeNode<>("David");
		TreeNode<String> ernesto = new TreeNode<>("Ernesto");
		TreeNode<String> chris = new TreeNode<>("Chris");
		TreeNode<String> elsa = new TreeNode<>("Elsa");
		TreeNode<String> anna = new TreeNode<>("Anna");
		TreeNode<String> shirley = new TreeNode<>("Shirley");
		TreeNode<String> vanessa = new TreeNode<>("Vanessa");
		TreeNode<String> peter = new TreeNode<>("Peter");
		
		/* Build the tree */
		ernesto.setParent(david); david.addChild(ernesto);
		chris.setParent(david); david.addChild(chris);
		elsa.setParent(chris); chris.addChild(elsa);
		anna.setParent(chris); chris.addChild(anna);
		shirley.setParent(elsa); elsa.addChild(shirley);
		vanessa.setParent(elsa); elsa.addChild(vanessa);
		peter.setParent(elsa); elsa.addChild(peter);
		
		/* Test 1: Ancestors of a Leaf Node (Shirley) */
		// Passing shirley as the parameter 'n'
		TreeNode<String>[] shirleyAncestors = david.ancestors(shirley);
		assertEquals("Ancestors of Shirley should be 4 nodes", 4, shirleyAncestors.length);
		assertSame(shirley, shirleyAncestors[0]);
		assertSame(elsa, shirleyAncestors[1]);
		assertSame(chris, shirleyAncestors[2]);
		assertSame(david, shirleyAncestors[3]);

		/* Test 2: Ancestors of an Internal Node (Chris) */
		TreeNode<String>[] chrisAncestors = david.ancestors(chris);
		assertEquals("Ancestors of Chris should be 2 nodes", 2, chrisAncestors.length);
		assertSame(chris, chrisAncestors[0]);
		assertSame(david, chrisAncestors[1]);

		/* Test 3: Ancestors of the Root (David) */
		TreeNode<String>[] davidAncestors = david.ancestors(david);
		assertEquals("Ancestors of David should be 1 node", 1, davidAncestors.length);
		assertSame(david, davidAncestors[0]);
	}

	@Test
	public void test_general_trees_descendants() {
		TreeNode<String> david = new TreeNode<>("David");
		TreeNode<String> ernesto = new TreeNode<>("Ernesto");
		TreeNode<String> chris = new TreeNode<>("Chris");
		TreeNode<String> elsa = new TreeNode<>("Elsa");
		TreeNode<String> anna = new TreeNode<>("Anna");
		TreeNode<String> shirley = new TreeNode<>("Shirley");
		TreeNode<String> vanessa = new TreeNode<>("Vanessa");
		TreeNode<String> peter = new TreeNode<>("Peter");
		
		/* Build the tree */
		ernesto.setParent(david); david.addChild(ernesto);
		chris.setParent(david); david.addChild(chris);
		elsa.setParent(chris); chris.addChild(elsa);
		anna.setParent(chris); chris.addChild(anna);
		shirley.setParent(elsa); elsa.addChild(shirley);
		vanessa.setParent(elsa); elsa.addChild(vanessa);
		peter.setParent(elsa); elsa.addChild(peter);
		
		/* Test 1: Descendants of a Leaf Node (Ernesto) */
		TreeNode<String>[] ernestoDescendants = david.descendants(ernesto);
		assertEquals("Descendants of Ernesto should just be Ernesto", 1, ernestoDescendants.length);
		assertSame(ernesto, ernestoDescendants[0]);

		/* Test 2: Descendants of an Internal Node (Elsa) */
		
		TreeNode<String>[] elsaDescendants = david.descendants(elsa);
		assertEquals("Descendants of Elsa should be 4 nodes", 4, elsaDescendants.length);
		assertSame(elsa, elsaDescendants[0]);
		assertSame(shirley, elsaDescendants[1]);
		assertSame(vanessa, elsaDescendants[2]);
		assertSame(peter, elsaDescendants[3]);

		/* Test 3: Descendants of the Root (David) */
		
		TreeNode<String>[] davidDescendants = david.descendants(david);
		assertEquals("Descendants of David should be all 8 nodes", 8, davidDescendants.length);
		assertSame(david, davidDescendants[0]);
		assertSame(ernesto, davidDescendants[1]);
		assertSame(chris, davidDescendants[2]);
		assertSame(elsa, davidDescendants[3]);
		assertSame(shirley, davidDescendants[4]);
		assertSame(vanessa, davidDescendants[5]);
		assertSame(peter, davidDescendants[6]);
		assertSame(anna, davidDescendants[7]);
	}
	
	
	@Test
	public void test_general_trees_remove_child_at() {
		TreeNode<String> david = new TreeNode<>("David");
		TreeNode<String> ernesto = new TreeNode<>("Ernesto");
		TreeNode<String> chris = new TreeNode<>("Chris");
		TreeNode<String> elsa = new TreeNode<>("Elsa");
		TreeNode<String> anna = new TreeNode<>("Anna");
		
		// Setup: David has 4 children [Ernesto, Chris, Elsa, Anna]
		david.addChild(ernesto);
		david.addChild(chris);
		david.addChild(elsa);
		david.addChild(anna);
		
		assertEquals(4, david.getChildren().length);
		
		/* Test 1: Remove from the middle (Index 1 - Chris) */
		david.removeChildAt(1);
		
		TreeNode<String>[] childrenAfterFirstRemoval = david.getChildren();
		assertEquals("Number of children should be 3", 3, childrenAfterFirstRemoval.length);
		assertSame(ernesto, childrenAfterFirstRemoval[0]); // Index 0 unchanged
		assertSame(elsa, childrenAfterFirstRemoval[1]);    // Shifted left
		assertSame(anna, childrenAfterFirstRemoval[2]);    // Shifted left
		
		/* Test 2: Remove from the beginning (Index 0 - Ernesto) */
		david.removeChildAt(0);
		
		TreeNode<String>[] childrenAfterSecondRemoval = david.getChildren();
		assertEquals("Number of children should be 2", 2, childrenAfterSecondRemoval.length);
		assertSame(elsa, childrenAfterSecondRemoval[0]);   // Shifted left
		assertSame(anna, childrenAfterSecondRemoval[1]);   // Shifted left
		
		/* Test 3: Remove from the end (Index 1 - Anna) */
		david.removeChildAt(1);
		
		TreeNode<String>[] childrenAfterThirdRemoval = david.getChildren();
		assertEquals("Number of children should be 1", 1, childrenAfterThirdRemoval.length);
		assertSame(elsa, childrenAfterThirdRemoval[0]);    // Unchanged
	}
}
