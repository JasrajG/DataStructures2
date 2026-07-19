package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.TreeUtilities;

public class ExtraTests extends TestBase{
	
	TreeUtilities u;
	
	@Before 
	public void setup() {
		u = new TreeUtilities();
	}
	

	@Test
	public void test_1_tree() {
		/*
		 * comment: test getInfixTree with expression: ((((3 + 1) * 3) * ((9 - 5) + 2)) - ((3 * (7 - 4)) + 6))
		 */
		List<Expression> tokens = tokenize("3 1 + 3 * 9 5 - 2 + * 3 7 4 - * 6 + -"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		TreeNode<Expression> root = u.getInfixTree(expression);
		
		TreeNode<Integer> expectedShape =
			t(18,
				t(10, // *
					t(4, // *
						t(2, // +
							t(0), // 3
							t(1) // 1
						),
						t(3) // 3
					),
					t(9, // +
						t(7, // -
							t(5), // 9
							t(6) // 5
						),
						t(8) // 2
					)
				),
				t(17,
					t(15,
						t(11),
						t(14,
							t(12),
							t(13)
						)
					),
					t(16)
				)
			);
		
		checkTrees(expectedShape, tokens, root);
	}
	

	@Test
	public void test_1_sequence() {
		/*
		 * comment: test getInfixSequence with expression: ((((3 + 1) * 3) * ((9 - 5) + 2)) - ((3 * (7 - 4)) + 6))
		 */
		List<Expression> tokens = tokenize("3 1 + 3 * 9 5 - 2 + * 3 7 4 - * 6 + -"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		assertEquals("((((3 + 1) * 3) * ((9 - 5) + 2)) - ((3 * (7 - 4)) + 6))", 
				u.getInfixSequence(expression));
	}
	
	

	@Test
	public void test_2_tree() {
		/*
		 * comment: test getInfixTree with expression: (1* 2) - (31 +40) + 55
		 */
		List<Expression> tokens = tokenize("1 2 * 31 40 + - 55 +"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		TreeNode<Expression> root = u.getInfixTree(expression);
		
		TreeNode<Integer> expectedShape =
		t(8, // +
				t(6, // -
						t(2, // *
								t(0) // 1
								, t(1) // 2
						), t(5, // +
								t(3) // 31
								, t(4) // 40
						)
				), t(7) // 55
		);

		checkTrees(expectedShape, tokens, root);
	}
	
	@Test
	public void test_2_sequence() {
		/*
		 * comment: test getInfixTree with expression: (1* 2) - (31 +40) + 55
		 */
		List<Expression> tokens = tokenize("1 2 * 31 40 + - 55 +"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		assertEquals("(((1 * 2) - (31 + 40)) + 55)", 
				u.getInfixSequence(expression));
	}
	

	@Test
	public void test_3_tree() {
		/*
		 * comment: test getInfixTree with expression: (1* 2) - ((31 +40) + 55) * 9
		 */
		List<Expression> tokens = tokenize("1 2 * 31 40 + 55 + 9 * -"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		TreeNode<Expression> root = u.getInfixTree(expression);
		
		TreeNode<Integer> expectedShape =
				t(10, // -
						t(2, // *
								t(0), // 1
								t(1) // 2
						),

						t(9, // *
								t(7, // +
										t(5, // +
												t(3), // 31
												t(4) // 40
										),
										t(6) // 55
								),
								t(8) // 9
						)

				);

		checkTrees(expectedShape, tokens, root);
	}
	
	@Test
	public void test_3_sequence() {
		/*
		 * comment: test getInfixTree with expression: (1* 2) - ((31 +40) + 55) * 9
		 */
		List<Expression> tokens = tokenize("1 2 * 31 40 + 55 + 9 * -"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		assertEquals("((1 * 2) - (((31 + 40) + 55) * 9))", 
				u.getInfixSequence(expression));
	}
	

	@Test
	public void test_4_tree() {
		/*
		 * comment: test getInfixTree with expression: 1* (((2 - ((31 +40) + 55)) * 2) - 3) * 9
		 */
		List<Expression> tokens = tokenize("1 2 31 40 + 55 + - 2 * 3 - * 9 *"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		TreeNode<Expression> root = u.getInfixTree(expression);
		
		TreeNode<Integer> expectedShape =
				t(14, // *
						t(12, // *
								t(0), // 1
								t(11, // -
										t(9, // *
												t(7, // -
														t(1), // 2
														t(6, // +
																t(4, // +
																		t(2), // 31
																		t(3) // 40
																),

																t(5) // 55
														)

												),

												t(8) // 2
										),

										t(10) // 3
								)

						),

						t(13) // 9
				);


		checkTrees(expectedShape, tokens, root);
	}

	
	@Test
	public void test_4_sequence() {
		/*
		 * comment: test getInfixTree with expression: 1* (((2 - ((31 +40) + 55)) * 2) - 3) * 9
		 */
		List<Expression> tokens = tokenize("1 2 31 40 + 55 + - 2 * 3 - * 9 *"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		assertEquals("((1 * (((2 - ((31 + 40) + 55)) * 2) - 3)) * 9)", 
				u.getInfixSequence(expression));
	}
	

	@Test
	public void test_5_tree() {
		/*
		 * comment: test getInfixTree with expression: 1 - ((3 + 69) * 8)
		 */
		List<Expression> tokens = tokenize("1 3 69 + 8 * -"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		TreeNode<Expression> root = u.getInfixTree(expression);
		
		TreeNode<Integer> expectedShape =
				t(6, // -
						t(0), // 1
						t(5, // *
								t(3, // +
										t(1), // 3
										t(2) // 69
								),

								t(4) // 8
						)

				);


		checkTrees(expectedShape, tokens, root);
	}
	

	@Test
	public void test_5_sequence() {
		/*
		 * comment: test getInfixTree with expression:  1 - ((3 + 69) * 8)
		 */
		List<Expression> tokens = tokenize("1 3 69 + 8 * -"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		assertEquals("(1 - ((3 + 69) * 8))", 
				u.getInfixSequence(expression));
	}
	

	@Test
	public void test_6_tree() {
		/*
		 * comment: test getInfixTree with expression: ((((((3 + 1) * 3) * ((9 - 5) + 2)) - ((3 * (7 - 4)) + 6)) * 8) + ((2 -1) + (2* (3-9))))
		 */
		List<Expression> tokens = tokenize("3 1 + 3 * 9 5 - 2 + * 3 7 4 - * 6 + - 8 * 2 1 - 2 3 9 - * + +"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		TreeNode<Expression> root = u.getInfixTree(expression);
		
		TreeNode<Integer> expectedShape =
				t(30, // +
						t(20, // *
								t(18, // -
										t(10, // *
												t(4, // *
														t(2, // +
																t(0), // 3
																t(1) // 1
														),

														t(3) // 3
												),

												t(9, // +
														t(7, // -
																t(5), // 9
																t(6) // 5
														),

														t(8) // 2
												)

										),

										t(17, // +
												t(15, // *
														t(11), // 3
														t(14, // -
																t(12), // 7
																t(13) // 4
														)

												),

												t(16) // 6
										)

								),

								t(19) // 8
						),

						t(29, // +
								t(23, // -
										t(21), // 2
										t(22) // 1
								),

								t(28, // *
										t(24), // 2
										t(27, // -
												t(25), // 3
												t(26) // 9
										)

								)

						)

				);

		checkTrees(expectedShape, tokens, root);
	}
	

	@Test
	public void test_6_sequence() {
		/*
		 * comment: test getInfixTree with expression: ((((((3 + 1) * 3) * ((9 - 5) + 2)) - ((3 * (7 - 4)) + 6)) * 8) + ((2 -1) + (2* (3-9))))
		 */
		List<Expression> tokens = tokenize("3 1 + 3 * 9 5 - 2 + * 3 7 4 - * 6 + - 8 * 2 1 - 2 3 9 - * + +"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		assertEquals("((((((3 + 1) * 3) * ((9 - 5) + 2)) - ((3 * (7 - 4)) + 6)) * 8) + ((2 - 1) + (2 * (3 - 9))))", 
				u.getInfixSequence(expression));
	}
	


	@Test
	public void test_7_tree() {
		/*
		 * comment: test getInfixTree with expression: (-1* 2) - (31 + (-40)) + 55
		 */
		List<Expression> tokens = tokenize("-1 2 * 31 -40 + - 55 +"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		TreeNode<Expression> root = u.getInfixTree(expression);
		
		TreeNode<Integer> expectedShape =
		t(8, // +
				t(6, // -
						t(2, // *
								t(0) // 1
								, t(1) // 2
						), t(5, // +
								t(3) // 31
								, t(4) // 40
						)
				), t(7) // 55
		);

		checkTrees(expectedShape, tokens, root);
	}
	
	@Test
	public void test_7_sequence() {
		/*
		 * comment: test getInfixTree with expression: (-1* 2) - (31 + (-40)) + 55
		 */
		List<Expression> tokens = tokenize("-1 2 * 31 -40 + - 55 +"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		assertEquals("(((-1 * 2) - (31 + -40)) + 55)", 
				u.getInfixSequence(expression));
	}
	
	
	@Test
	public void test_8_tree() {
		/*
		 * comment: test getInfixTree with expression: (0 + -3) + -1
		 */
		List<Expression> tokens = tokenize("0 -3 + -1 +"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		TreeNode<Expression> root = u.getInfixTree(expression);
		
		TreeNode<Integer> expectedShape =
				t(4, // -
						t(2, // +
								t(0), // 0
								t(1) // -3
						),

						t(3) // 1
				);

		checkTrees(expectedShape, tokens, root);
	}
	
	@Test
	public void test_8_sequence() {
		/*
		 * comment: test getInfixTree with expression: (0 + -3) + -1
		 */
		List<Expression> tokens = tokenize("0 -3 + -1 +"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		assertEquals("((0 + -3) + -1)", 
				u.getInfixSequence(expression));
	}
}
