package tests;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import model.TreeUtilities;

public class ComplexExtraTestsStats extends TestBase {

	TreeUtilities u;

	
    @Before
    public void setup() {
    	u = new TreeUtilities();	
    }
    
	@Test
	public void test_getStats_complex_1() {
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
		
		TreeNode<String> output = u.getStats(tree);
		checkOutputForAllLevels(output,
				Arrays.asList(
						Arrays.asList(
								statMsg(52, 1378)
						),
						Arrays.asList(
								statMsg(8, 148),
								statMsg(6, 125),
								statMsg(8, 212),
								statMsg(7, 209),
								statMsg(7, 236),
								statMsg(6, 213),
								statMsg(3, 75),
								statMsg(3, 78),
								statMsg(3, 81)
						),
						Arrays.asList(
								statMsg(1, 11),
								statMsg(1, 20),
								statMsg(1, 21),
								statMsg(1, 22),
								statMsg(1, 23),
								statMsg(1, 24),
								statMsg(1, 25)
						),
						Arrays.asList(
								statMsg(1, 12),
								statMsg(1, 26),
								statMsg(1, 27),
								statMsg(1, 28),
								statMsg(1, 29)
						),
						Arrays.asList(
								statMsg(1, 13),
								statMsg(1, 30),
								statMsg(1, 31),
								statMsg(1, 32),
								statMsg(1, 33),
								statMsg(1, 34),
								statMsg(1, 35)
						),
						Arrays.asList(
								statMsg(1, 14),
								statMsg(1, 36),
								statMsg(3, 116),
								statMsg(1, 38)
						),
						Arrays.asList(
								statMsg(1, 15),
								statMsg(1, 41),
								statMsg(1, 42),
								statMsg(1, 43),
								statMsg(1, 44),
								statMsg(1, 45)
						),
						Arrays.asList(
								statMsg(1, 16),
								statMsg(1, 46),
								statMsg(1, 47),
								statMsg(2, 97)
						),
						Arrays.asList(
								statMsg(1, 17),
								statMsg(1, 50)
						),
						Arrays.asList(
								statMsg(2, 69)
						),
						Arrays.asList(
								statMsg(2, 71)
						),
						// 11 - 36; 21 nulls. 
						null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null,
						null,
						// 37.
						Arrays.asList(
								statMsg(1, 39),
								statMsg(1, 40)
						),
						// 38-47, 10 nulls
						null, null, null, null, null, null, null, null, null, null,
						Arrays.asList(
								statMsg(1, 49)	
						),
						null, null,
						Arrays.asList(
								statMsg(1, 51)	
						),
						Arrays.asList(
								statMsg(1, 52)	
						)
				));
	}
	

	@Test
	public void test_getStats_complex_2() {
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

		TreeNode<String> output = u.getStats(tree);
		checkOutputForAllLevels(output,
				Arrays.asList(
						Arrays.asList(
								statMsg(50, 1275)
						),
						Arrays.asList(
								statMsg(48, 1271),
								statMsg(1, 3)
						),
						Arrays.asList(
								statMsg(40, 940),
								statMsg(1, 44),
								statMsg(1, 45),
								statMsg(1, 46),
								statMsg(1, 47),
								statMsg(1, 48),
								statMsg(1, 49),
								statMsg(1, 50)
						),
						// 3.
						null,
						Arrays.asList(
								statMsg(36, 805),
								statMsg(1, 41),
								statMsg(1, 42),
								statMsg(1, 43)
						),
						// 44-50
						null, null, null, null, null, null, null,
						Arrays.asList(
								statMsg(31, 641),
								statMsg(1, 37),
								statMsg(1, 38),
								statMsg(1, 39),
								statMsg(1, 40)
						),
						// 41-43
						null, null, null,
						Arrays.asList(
								statMsg(24, 429),
								statMsg(1, 31),
								statMsg(1, 32),
								statMsg(1, 33),
								statMsg(1, 34),
								statMsg(1, 35),
								statMsg(1, 36)
						),
						// 37-40
						null, null, null, null,
						// 13, 
						Arrays.asList(
								statMsg(13, 162),
								statMsg(1, 26),
								statMsg(1, 27),
								statMsg(1, 28),
								statMsg(1, 29),
								statMsg(6, 145)
						),
						// 31 - 36
						null, null, null, null, null, null,
						// 14
						Arrays.asList(
								statMsg(12, 149)
						),
						// 26-29
						null, null, null, null,
						Arrays.asList(
								statMsg(1, 21),
								statMsg(3, 71),
								statMsg(1, 23)
						),
						// 15 - 20
						Arrays.asList(
								statMsg(7, 61),
								statMsg(1, 17),
								statMsg(1, 18),
								statMsg(1, 19),
								statMsg(1, 20)
						),
						// 21
						null,
						Arrays.asList(
								statMsg(1, 24),
								statMsg(1, 25)
						),
						null,
						Arrays.asList(
								statMsg(1, 16),
								statMsg(1, 4),
								statMsg(1, 5),
								statMsg(3, 21)
						),
						// 17 - 20
						null, null, null, null,
						// 24-25
						null, null,
						// 16-5
						null, null, null,
						Arrays.asList(
								statMsg(1, 7),
								statMsg(1, 8)
						)
				));
	}
	
}
