package tests;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import model.TreeUtilities;

public class ComplexExtraTestsRanks extends TestBase {

	TreeUtilities u;

	
    @Before
    public void setup() {
    	u = new TreeUtilities();	
    }
    

	@Test
	public void test_getElementsOfRanks_complex_1() {
		/*
		 * comment: test "deep" and "wide" tree structure: 
		 * depth: 10 breadth: 8   
		 */
		TreeNode<Integer> tree = t(
				1,
				t(2, 
						t(9, 
								t(10, 
										t(11, 
												t(12,
														t(13,
																t(14,
																		t(15,
																				t(16)
																				
																		),
																		t(17),
																		t(18),
																		t(19),
																		t(20)
																)
														),
														t(26),
														t(27),
														t(28),
														t(29),
														t(30)
												),
												t(31),
												t(32),
												t(33),
												t(34),
												t(35),
												t(36)
										),
										t(37),
										t(38),
										t(39),
										t(40)
								),
								t(41),
								t(42),
								t(43)
						),
						t(44),
						t(45),
						t(46),
						t(47),
						t(48),
						t(49),
						t(50)
				),
				t(3,
						t(51,
								t(21),
								t(22),
								t(23),
								t(24),
								t(25)),
						t(52),
						t(53),
						t(54),
						t(55),
						t(56,
								t(79),
								t(80),
								t(81),
								t(82),
								t(83, 
										t(84),
										t(85),
										t(86),
										t(87),
										t(88),
										t(89)
								)
						)),
				t(4,
						t(57),
						t(58),
						t(59),
						t(60)),
				t(5,
						t(61),
						t(62,
								t(90),
								t(91),
								t(92),
								t(93),
								t(94),
								t(95)
						),
						t(63),
						t(64),
						t(65)),
				t(6,
						t(66),
						t(67),
						t(68),
						t(69)),
				t(7,
						t(70),
						t(71),
						t(72,
								t(96),
								t(97),
								t(98),
								t(99),
								t(100)
						),
						t(73),
						t(74),
						t(75),
						t(76)
				),
				t(8,
						t(77),
						t(78))
		);
		
		SLLNode<Integer> output = u.getElementsOfRanks(tree, 1, 50);
		checkValuesInOrder(
				IntStream.range(1, 51).boxed().collect(Collectors.toList()), output
		);
		output = u.getElementsOfRanks(tree, 51, 100);
		checkValuesInOrder(
				IntStream.range(51, 101).boxed().collect(Collectors.toList()), output
		);
	}

	@Test
	public void test_getElementsOfRanks_complex_2() {
		/*
		 * comment: test "deep" tree structure: 
		 * depth: 11   
		 */
		TreeNode<Integer> tree = t(
				1,
				t(2, 
						t(9, 
								t(10, 
										t(11, 
												t(12,
														t(13,
																t(14,
																		t(15,
																				t(16),
																				t(4),
																				t(5),
																				t(6,
																						t(7),
																						t(8))
																				
																		),
																		t(17),
																		t(18),
																		t(19),
																		t(20)
																)
														),
														t(26),
														t(27),
														t(28),
														t(29),
														t(30,
																t(21),
																t(22,
																		t(24),
																		t(25)),
																t(23))
												),
												t(31),
												t(32),
												t(33),
												t(34),
												t(35),
												t(36)
										),
										t(37),
										t(38),
										t(39),
										t(40)
								),
								t(41),
								t(42),
								t(43)
						),
						t(44),
						t(45),
						t(46),
						t(47),
						t(48),
						t(49),
						t(50)
				),
				t(3)
		);
		
		SLLNode<Integer> output = u.getElementsOfRanks(tree, 1, 50);
		checkValuesInOrder(
				IntStream.range(1, 51).boxed().collect(Collectors.toList()), output
		);
	}
	

	@Test
	public void test_getElementsOfRanks_complex_3() {
		/*
		 * comment: test "wide" tree structure: 
		 * breadth: 10   
		 */
		TreeNode<Integer> tree = t(
				1,
				t(2,
						t(11),
						t(20),
						t(21),
						t(22),
						t(23),
						t(24),
						t(25)),
				t(3,
						t(12),
						t(26),
						t(27),
						t(28),
						t(29)),
				t(4,
						t(13),
						t(30),
						t(31),
						t(32),
						t(33),
						t(34),
						t(35)),
				t(5,
						t(14),
						t(36),
						t(37,
								t(39),
								t(40)),
						t(38)),
				t(6,
						t(15),
						t(41),
						t(42),
						t(43),
						t(44),
						t(45)),
				t(7,
						t(16),
						t(46),
						t(47),
						t(48,
								t(49))),
				t(8,
						t(17),
						t(50)),
				t(9,
						t(18,
								t(51))),
				t(10,
						t(19,
								t(52)))
		);
		
		SLLNode<Integer> output = u.getElementsOfRanks(tree, 1, 50);
		checkValuesInOrder(
				IntStream.range(1, 51).boxed().collect(Collectors.toList()), output
		);
	}
	
}
