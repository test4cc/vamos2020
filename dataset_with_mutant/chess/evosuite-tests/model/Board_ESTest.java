/*
 * This file was automatically generated by EvoSuite
 * Mon Aug 19 19:56:06 BRT 2019
 */

package model;

import static org.evosuite.runtime.EvoAssertions.verifyException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Point;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import jogador.AI_Player;
import jogador.Player;
import piece.Piece;
import piece.PieceType;
import piece.Space;
import specifications.Configuration;

@RunWith(EvoRunner.class) @EvoRunnerParameters(useVNET = true, separateClassLoader = true, useJEE = true) 
public class Board_ESTest extends Board_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Point point0 = new Point(0, 0);
      Board.Memento board_Memento0 = new Board.Memento((Piece) null, (Piece) null, point0);
      Point point1 = board_Memento0.getPointSaved();
      assertSame(point1, point0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Piece piece0 = new Piece();
      Point point0 = new Point();
      Board.Memento board_Memento0 = new Board.Memento(piece0, piece0, point0);
      Piece piece1 = board_Memento0.getPieceTakenSaved();
      assertSame(piece1, piece0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Board board0 = new Board();
      board0.buildAI();
      // Undeclared exception!
      try { 
        board0.whiteKingCheck(true);
     //   fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Board board0 = new Board();
      Configuration.OFFLINE_PLAYER = true;
      boolean boolean0 = board0.blackKingCheck();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Board board0 = new Board();
      PieceType pieceType0 = board0.getType(0, 0);
      assertEquals(PieceType.ROOK, pieceType0);
      assertEquals(0, board0.getBestY());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Board board0 = new Board();
      int int0 = board0.getTeam(0, 0);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Board board0 = new Board();
      Piece piece0 = board0.getPiece(6, 1);
      assertEquals(0, piece0.getTeam());
      assertNotNull(piece0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Board board0 = new Board();
      Piece piece0 = board0.getPiece(6, 0);
      assertEquals(0, piece0.getTeam());
      assertNotNull(piece0);
      assertEquals(0, board0.getBestX());
      assertEquals(0, piece0.getLocY());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Board board0 = new Board();
      Player player0 = new Player((-1));
      board0.j1 = player0;
      Player player1 = board0.getJ1();
      assertEquals(0, board0.getBestY());
      assertEquals((-1), player1.getTeam());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Board board0 = new Board(2);
      board0.getJ0();
      assertEquals(0, board0.getBestY());
      assertEquals(0, board0.getBestX());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Board board0 = new Board();
      Player player0 = board0.getJ1();
      board0.j0 = player0;
      Player player1 = board0.getJ0();
      assertEquals(0, board0.getBestY());
      assertEquals(1, player1.getTeam());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Board board0 = new Board();
      board0.AI = null;
      AI_Player aI_Player0 = new AI_Player(0);
      board0.AI = aI_Player0;
      board0.getAI();
      assertEquals(0, board0.getBestX());
      assertEquals(0, board0.getBestY());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Board board0 = new Board();
      board0.buildSingle();
      board0.buildBoard(8);
      board0.checkKings();
      int int0 = 2040;
      int int1 = 1;
      // Undeclared exception!
      try { 
     //   board0.white_check_mate(true);
       //  fail("Expecting exception: IndexOutOfBoundsException");
       // Unstable assertion
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 0, Size: 0
         //
         verifyException("java.util.ArrayList", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Board board0 = new Board();
      boolean boolean0 = board0.blackKingCheck();
      board0.buildAI();
      // Undeclared exception!
      try { 
        board0.white_check_mate(boolean0);
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 0, Size: 0
         //
         verifyException("java.util.ArrayList", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Board board0 = new Board();
      board0.mode = (-526);
      Piece piece0 = new Piece(700, 1807, (-572));
      int int0 = 2313;
      piece0.deletePiece((-505), 2313);
      Space[][] spaceArray0 = new Space[8][4];
      Space[] spaceArray1 = new Space[3];
      Space space0 = new Space();
      spaceArray1[0] = space0;
      Space space1 = new Space(piece0);
      spaceArray1[1] = space1;
      Space space2 = new Space(piece0);
      spaceArray1[2] = space2;
      spaceArray0[0] = spaceArray1;
      Space[] spaceArray2 = new Space[9];
      spaceArray2[0] = space2;
      spaceArray2[1] = space1;
      spaceArray2[2] = space0;
      spaceArray2[3] = space1;
      spaceArray2[4] = space1;
      spaceArray2[5] = space0;
      spaceArray2[6] = space0;
      Space space3 = new Space(piece0);
      spaceArray2[7] = space3;
      spaceArray2[8] = space1;
      spaceArray0[1] = spaceArray2;
      Space[] spaceArray3 = new Space[5];
      spaceArray3[0] = space0;
      spaceArray3[1] = space2;
      spaceArray3[2] = space2;
      spaceArray3[3] = space2;
      spaceArray3[4] = space1;
      spaceArray0[2] = spaceArray3;
      Space[] spaceArray4 = new Space[2];
      spaceArray4[0] = space3;
      Space space4 = new Space(piece0);
      spaceArray4[1] = space4;
      spaceArray0[3] = spaceArray4;
      Space[] spaceArray5 = new Space[6];
      spaceArray5[0] = space4;
      spaceArray5[1] = space2;
      spaceArray5[2] = space3;
      spaceArray5[3] = space3;
      spaceArray5[4] = space4;
      spaceArray5[5] = space0;
      spaceArray0[4] = spaceArray5;
      Space[] spaceArray6 = new Space[7];
      spaceArray6[0] = space2;
      spaceArray6[1] = space0;
      spaceArray6[2] = space1;
      spaceArray6[3] = space4;
      spaceArray6[4] = space3;
      spaceArray6[5] = space2;
      spaceArray6[6] = space1;
      spaceArray0[5] = spaceArray6;
      Space[] spaceArray7 = new Space[7];
      spaceArray7[0] = space0;
      spaceArray7[1] = space4;
      spaceArray7[2] = space1;
      spaceArray7[3] = space0;
      spaceArray7[4] = space0;
      spaceArray7[5] = space0;
      spaceArray7[6] = space2;
      spaceArray0[6] = spaceArray7;
      Space[] spaceArray8 = new Space[6];
      spaceArray8[0] = space1;
      spaceArray8[1] = space4;
      spaceArray8[2] = space0;
      spaceArray8[3] = space4;
      spaceArray8[4] = space0;
      spaceArray8[5] = space2;
      spaceArray0[7] = spaceArray8;
      board0.board = spaceArray0;
      piece0.setTeam(1963);
      board0.isValid(89, 700, piece0);
      // Undeclared exception!
      try { 
        board0.white_check_mate(false);
       //  fail("Expecting exception: ArrayIndexOutOfBoundsException");
       // Unstable assertion
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Board board0 = new Board();
      Piece piece0 = new Piece();
      // Undeclared exception!
      try { 
        board0.isValid(0, 0, piece0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Board board0 = new Board(2);
      // Undeclared exception!
      try { 
        board0.isPlayerPiece(0, 0, 0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Board board0 = new Board((-1));
      // Undeclared exception!
      try { 
        board0.isPlayerPiece(0, 8, 0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 8
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Board board0 = new Board((-1));
      // Undeclared exception!
      try { 
        board0.getType(0, 8);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 8
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Board board0 = new Board();
      int int0 = 6;
      int int1 = (-1);
      // Undeclared exception!
      try { 
        board0.getPiece(int1, int0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // -1
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Board board0 = new Board(2);
      // Undeclared exception!
      try { 
        board0.checkKings();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Board board0 = new Board();
      Piece piece0 = new Piece(0, 0, 0);
      // Undeclared exception!
      try { 
        board0.changePosition(8, 0, piece0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 8
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Board board0 = new Board(2);
      // Undeclared exception!
      try { 
        board0.black_check_mate();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Board board0 = new Board(2);
      // Undeclared exception!
      try { 
        board0.blackKingCheck();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Board board0 = new Board();
      board0.buildAI();
      board0.buildAI();
      board0.blackKingCheck();
      Board.Memento board_Memento0 = board0.m;
      board0.m = null;
      board0.getBestY();
      int int0 = 8;
      // Undeclared exception!
      try { 
//        board0.bestMove(8, 0);
      //  fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Board board0 = new Board();
      Configuration.AI_PLAYER = false;
      board0.black_check_mate();
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Board board0 = new Board();
      Configuration.ONLINE_PLAYER = false;
      int int0 = 0;
      board0.removePiece(0, 0);
      board0.getPiece(0, 0);
      // Undeclared exception!
      try { 
        board0.changePosition((-1577), 89, (Piece) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Board board0 = new Board();
      board0.removePiece(2, 0);
      assertEquals(0, board0.getBestY());
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Board board0 = new Board();
      board0.removePiece(0, 0);
      assertEquals(0, board0.getBestY());
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Board board0 = new Board();
      Piece piece0 = new Piece(0, 0, 0);
      board0.changePosition(2, 0, piece0);
      assertEquals(2, piece0.getLocX());
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      Board board0 = new Board();
      Configuration.AI_PLAYER = true;
      int int0 = 3;
      board0.buildAI();
      board0.isPlayerPiece(3, 3, 3);
      board0.buildSingle();
      int int1 = 0;
      int int2 = 0;
      Piece piece0 = new Piece();
      int int3 = 0;
      // Undeclared exception!
      try { 
        piece0.deletePiece(40, 0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("piece.Piece", e);
      }
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Board board0 = new Board();
      board0.buildBoard(0);
      assertEquals(0, board0.getBestY());
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Board board0 = new Board((-1));
      board0.buildBoard();
      // Undeclared exception!
      try { 
        board0.black_check_mate();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Piece piece0 = new Piece();
      Point point0 = new Point();
      Board.Memento board_Memento0 = new Board.Memento(piece0, piece0, point0);
      Piece piece1 = board_Memento0.getPieceMovedSaved();
      assertEquals((-1), piece1.getTeam());
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Board board0 = new Board(2);
      // Undeclared exception!
      try { 
        board0.getTeam(0, 0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      Board board0 = new Board();
      int int0 = 2526;
      int int1 = 0;
      board0.blackKingCheck();
      // Undeclared exception!
      board0.black_check_mate();
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      Board board0 = new Board(2);
      // Undeclared exception!
      try { 
        board0.whiteKingCheck(true);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      Board board0 = new Board();
      board0.whiteKingCheck(false);
      Configuration.OFFLINE_PLAYER = true;
      Space[][] spaceArray0 = new Space[6][4];
      Space[] spaceArray1 = new Space[1];
      // Undeclared exception!
      try { 
        board0.getTeam(30, (-2770));
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 30
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      Board board0 = new Board();
      Player player0 = board0.getJ1();
      board0.j0 = player0;
      // Undeclared exception!
      board0.black_check_mate();
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      Board board0 = new Board();
      board0.blackKingCheck();
      // Undeclared exception!
      board0.white_check_mate(false);
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      Board board0 = new Board();
      Player player0 = board0.getJ1();
      board0.j0 = player0;
      // Undeclared exception!
      board0.white_check_mate(false);
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      Board board0 = new Board();
      Configuration.ONLINE_PLAYER = true;
      // Undeclared exception!
      board0.white_check_mate(false);
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      Board board0 = new Board(2);
      boolean boolean0 = board0.pieceExists(0, 0);
      assertEquals(0, board0.getBestY());
      assertEquals(0, board0.getBestX());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      Board board0 = new Board();
      Configuration.ONLINE_PLAYER = true;
      Configuration.ONLINE_PLAYER = false;
      Piece piece0 = board0.getPiece(0, 0);
      assertEquals(0, piece0.getLocY());
      
      boolean boolean0 = board0.checkKings();
      board0.getJ1();
      boolean boolean1 = board0.isPlayerPiece(0, 0, 0);
      assertFalse(boolean1 == boolean0);
      
      board0.buildBoard(2280);
      // Undeclared exception!
      board0.white_check_mate(false);
  }
//
//  @Test(timeout = 4000)
//  public void test44()  throws Throwable  {
//      Board board0 = new Board(1);
//  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      Board board0 = new Board();
      board0.buildAI();
      boolean boolean0 = board0.checkKings();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      Board board0 = new Board();
      board0.buildSingle();
      boolean boolean0 = board0.checkKings();
     // assertTrue(boolean0);
      assertEquals(0, board0.getBestY());
      assertEquals(0, board0.getBestX());
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      Board board0 = new Board();
      int int0 = board0.getBestX();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      Board board0 = new Board();
      board0.getAI();
      assertEquals(0, board0.getBestY());
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      Board board0 = new Board((-1));
      board0.getJ1();
      assertEquals(0, board0.getBestY());
      assertEquals(0, board0.getBestX());
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      Board board0 = new Board((-1));
      // Undeclared exception!
      try { 
        board0.getType(0, 0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      Board board0 = new Board(2);
      // Undeclared exception!
      try { 
        board0.getPiece(0, 0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("model.Board", e);
      }
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      Board board0 = new Board();
      Player player0 = board0.getJ0();
      assertEquals(0, board0.getBestY());
      assertEquals(0, player0.getTeam());
  }
}
