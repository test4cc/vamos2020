package experiment;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import baseline.Feature;
import baseline.FeatureType;
import baseline.PowerSet;
import baseline.SPL;
import guidsl.SATtest;
import guidsl.Tool;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import testset.*;

public class BaselineAdapter {
	PowerSet powerset;

	public BaselineAdapter() {
		powerset = new PowerSet();
	}

	public void baselineRun() {
		Feature f1 = new Feature();
		f1.setType(FeatureType.MANDATORY);
		Feature f2 = new Feature();
		f2.setType(FeatureType.OPTIONAL);
		Feature f3 = new Feature();
		f3.setType(FeatureType.OPTIONAL);
		Feature f4 = new Feature();
		f4.setType(FeatureType.OPTIONAL);
		SPL spl = new SPL();
		spl.addOthersFeature(f2);
		spl.addOthersFeature(f3);
		spl.addOthersFeature(f4);
		makeProduct(spl);

	makeProduct(spl);

	}

	private void makeProduct(SPL spl) {
		List<Integer> list = new ArrayList<Integer>();
		for (int cont = 0; cont < spl.getOthersFeatureList().size(); cont++) {
			list.add(cont);
		}

		int cont = 0;
		Record record = new Record();
		// System.out.println(powerset.getSubsetUsingBitMap(list));
		for (ArrayList<Integer> integer : powerset.getSubsetUsingBitMap(list)) {

			starFeature();
			for (Integer integer2 : integer) {
				if (integer2 == 0)
					Configuration.AI_PLAYER = true;
				if (integer2 == 1)
					Configuration.ONLINE_PLAYER = true;
				if (integer2 == 2)
					Configuration.OFFLINE_PLAYER = true;

			}

//			Configuration.AI_PLAYER=true;
//		    Configuration.ONLINE_PLAYER=false;
//		    Configuration.OFFLINE_PLAYER=false;
			
			if (Configuration.validProduct()) {

				cont++;

				Configuration.productPrint();

				/* Chama a blibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));

				org.junit.runner.Result result = junit.run(
						AI_PlayerTest.class,
						BishopTest.class,
						BoardPanelTest.class,
						BoardTest.class,
						KingTest.class,
						KnightTest.class,
						ModelTest.class,
						MVCTest.class,
						PawnTest.class,
						PieceTest.class,
						PlayerTest.class,
						QueenTest.class,
						RookTest.class,
						SpaceTest.class,
						ViewTest.class
						);
				/* fim core junit */
				System.err.println("cont: " + cont + "((( apos os testes))) ");
				Configuration.productPrint();
				System.out.println("\n\n ----------------------- \n\n");
				starFeature();

			} else {
				// System.err.println("Inv�lido");
			}

		}
		try {
			record.record2();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Contador de produtos:" + cont);
	}

	private void starFeature() {
		Configuration.AI_PLAYER = false;
		Configuration.ONLINE_PLAYER = false;
		Configuration.OFFLINE_PLAYER = false;
	}
}
