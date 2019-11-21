package desktopsearcher;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.TermFreqVector;
import org.apache.lucene.search.ScoreDoc;

import specifications.Configuration;


public class Commandline implements UI{

	String prompt="lucene desktop searcher>";
	String line="";
	MrPinkMain mrpinkmain;

	public Commandline(MrPinkMain mrpinkmain) {
		if (Configuration.COMMAND_LINE) {
			this.mrpinkmain = mrpinkmain;
		}
	}

    public void printSearch_SearchPanel(ScoreDoc[] hits, Indexer index, String query){
    	if (Configuration.COMMAND_LINE) {
    		printHits(hits, index, "lastModify");  //printSearch_SearchPanel(hits, index, query);
    	}
    }

	public void printErrorMessage(String message){
		if (Configuration.COMMAND_LINE) {
			System.out.println("An Error has Occured! Error message: "+message);
		}
	}
	
	
	void startCommandline(){
		if (Configuration.COMMAND_LINE) {
			while (true) {

				System.out.print(prompt);

				BufferedReader in = new BufferedReader(new InputStreamReader(
						System.in));
				try {
					line = in.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (parseCommand(line) == -1)
					return;
			}
		}
	}
	
	/**
	 * this method is necessary because we want to support pathes that contains whitespaces
	 * @param s
	 * @return
	 */
	public String substituteWhiteSpacesinSingleQuotedStringArea(String s){
		String ret="";
		if (Configuration.COMMAND_LINE) {
			boolean isinSingleQuotedArea = false;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '\'')
					isinSingleQuotedArea = !isinSingleQuotedArea;

				if (isinSingleQuotedArea && s.charAt(i) == ' ') {
					ret += "%20";
				} else {
					ret += s.charAt(i);
				}
			}
		}
		return ret;
	}
	
	public int parseCommand(String cmd){
		if (Configuration.COMMAND_LINE) {
			cmd = substituteWhiteSpacesinSingleQuotedStringArea(cmd);

			StringTokenizer st = new StringTokenizer(cmd, " "); // trenne den String durch das Trennzeichen

			String[] tokens = new String[10];

			int tokenindex = 0;
			while (st.hasMoreTokens() && tokenindex < 10) {
				// System.out.println(st.nextToken()); // Token fuer Token
				// ausgeben
				tokens[tokenindex++] = st.nextToken().replace("%20", " ")
						.replace("'", "");
			}

			if (tokens[0].equals("?")) {

				System.out.println("this is a desktop search application");
				System.out.println("for commands type h");

			} else if (tokens[0].equals("h")) {

				System.out
						.println("? - short description, what this application is for");
				System.out.println("h - show this help");
				System.out
						.println("i path - index the directory with Path 'patch'");
				System.out
						.println("s query - search for files that contains the word query");
				System.out.println("q - quit this apllication");

			} else if (tokens[0].equals("i") || tokens[0].equals("index")) {

				if (tokenindex < 2) {
					System.out.println("to few arguments for command index!");
					return 0;
				}
				System.out.println("Indexing directory: '" + tokens[1] + "'");
				mrpinkmain.createIndex(tokens[1]);

			} else if (tokens[0].equals("s") || tokens[0].equals("search")) {

				if (tokenindex < 2) {
					System.out.println("to few arguments for command search!");
					return 0;
				}
				System.out.println("Searching for query: '" + tokens[1] + "'");
				try {
					mrpinkmain.searchInIndex(tokens[1], 10,
							OptionStorage.SEARCHNORMAL); // max 10 results,
															// normal search
															// mode
				} catch (Exception e) {
					System.err
							.println("Exception occured while searching in index! "
									+ e.toString());
				}

			} else if (tokens[0].equals("q") || tokens[0].equals("quit")) {
				System.out.println("Exiting...");
				return -1;
				// }else if(tokens[0].equals("")){

			} else {
				System.out.println("unknown command: '" + tokens[0]
						+ "' try 'h' for help");
			}
		}
		return 0;
	}
	
		/**
	 * Komplette Ausgabe der Ergebnisse.
	 * 
	 * Diese Methode gibt die einzelnen gefundenen Dokumente aus.
	 * Dabei werden neben dem Titel und dem Pfad auch noch
	 * die Dateigroesse oder der Zeitpunkt der letzten Aenderung
	 * ausgegeben, falls der letzte Parameter entsprechend
	 * gesetzt wird.
	 * 
	 * @param hits              die IDs der Trefferdokumente
	 * @param index             Indexer auf dem gearbeitet wird
	 * @param interestingField  Field nach dem gesucht wurde. Der Parameter ist nur bei Anfragen, die nach 
	 *                          "largest" oder "mostRecent" gestellt wurden, relevant.
	 */
	public void printHits(ScoreDoc[] hits, Indexer index, String interestingField) {
		if (Configuration.COMMAND_LINE) {
			try {
				System.out.println(interestingField);
				// for (ScoreDoc doc : hits) {
				for (int i = 0; i < hits.length; i++) {
					ScoreDoc doc = hits[i];

					int documentID = doc.doc;
					Object[] ret = index.getDocument(documentID);
					Document document = (Document) ret[0];
					TermFreqVector[] freqVec = (TermFreqVector[]) ret[1];

					String value = document.getField(interestingField)
							.stringValue();

					if (interestingField.equals("lastModify")) {
						Timestamp ts = new Timestamp(new Long(value));
						Date d = new Date(ts.getTime());

						value = d.toString();
					} else if (interestingField.equals("size")) {
						value += " Byte";
					}

					System.out.println("  -> doc #" + documentID + " (" + value
							+ ")");
					System.out.println("  -> title "
							+ document.getField("title").stringValue());
					System.out.println("  -> path "
							+ document.getField("path").stringValue());
				}
			} catch (Exception e) {
				System.err.println(e);
				e.printStackTrace();
			}
		}
	}

}
