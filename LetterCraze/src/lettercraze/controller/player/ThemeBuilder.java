package lettercraze.controller.player;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import lettercraze.model.Alphabet;
import lettercraze.model.BoardState;
import lettercraze.model.Letter;
import lettercraze.model.Model;
import lettercraze.model.Square;
import lettercraze.model.Word;

/**
 * the Theme builder generates an initial boardState using words from the
 * targetWords list, up to 36 characters total. If there are more than 36 characters
 * words are selected at random to get as close to 36 as possible.
 * 
 * @author Everett
 *
 */
public class ThemeBuilder {

	/** the squares to be filled with letters. **/
	Square[][] squares;

	/** the words with which to fill the squares. **/
	ArrayList<Word> targetWords;
	
	/** the boardState that holds the squares. **/
	BoardState boardState;

	/**
	 * Constructor for the theme-builder.
	 * 
	 * @param bState as BoardState : the boardState which is to be filled with the letters from targetWords
	 * @param targetStrings as Strings : the words to be found in the level
	 */
	public ThemeBuilder(BoardState bState, ArrayList<String> targetStrings) {
		this.boardState = bState;
		this.squares = bState.getSquares();
		this.targetWords = convertTargets(targetStrings);
		for(int i = 0; i <6; i ++){
			for(int j = 0; j < 6; j ++){
				squares[i][j].setLetter(null);
			}
		}
	}

	/**
	 * gets the total characters in all the target words.
	 * @param words as ArrayList<Word>
	 * @return an integer value, representing the total characters in the target words
	 */
	public int getTotalCharacters(ArrayList<Word> words){
		int total = 0;
		for(Word w: words){
			total += w.getWordLength();
		}
		return total;
	}

	/**
	 * fill the squares with selection of the words in the word-list.
	 * 
	 * @return true if successful, false otherwise
	 */
	public Square[][] populateSquares(){
		//useWords -> pick from targetWords: words that have <36 characters total
		ArrayList<Word> useWords = pickFromList(targetWords);
		ArrayList<Word> placedWords = new ArrayList<Word>();
		//for each word in usewords:
		//place the first square (randomly)
		//DFS to check for placing the whole word there\
		for(Word w: useWords){
			boolean placed = false;
			int count = 0;
			//keep trying to place the word until you've tried 36 times or it has been placed
			while(!placed && count < 36){
				System.out.println(w.getWordString() + "Try: " + count);
				int row = ThreadLocalRandom.current().nextInt(0,6);
				int col = ThreadLocalRandom.current().nextInt(0,6);
				
				//make a new word to accumulate locations to place squares
				Word toPlace = new Word(new Square(0,0));
				toPlace.removeSquare();
				
				//now, if the starting square is empty, try to place the word
				if(squares[row][col].getLetter() == null && squares[row][col].isActive()){
					placed = placeWord(w.copyWord(), squares[row][col], toPlace);
					if(placed){
						System.out.println("Successfully Placed!");
						//boardState.floatTileDown(squares, toPlace);
						placedWords.add(w);
						printAllSquares();
					}
				}
				count++;
			}
		}
		boardState.fillEmptySquares(squares);
		System.out.println("Words Placed in Board: ");
		for(Word usedWord: placedWords)
			System.out.print(usedWord.getWordString()+ " ");
		System.out.println();
		return squares;		
	}
	
	/**
	 * print the letter (or lack thereof) in each square.
	 */
	private void printAllSquares(){
		for(int i = 0; i < 6; i ++){
			for(int j = 0; j < 6; j ++){
				if(squares[i][j].getLetter() != null){
					System.out.print(squares[i][j].getLetter().getLetter() + " ");
				}
				else{
					System.out.print("_ ");
				}
			}System.out.println();
		}
	}

	/**
	 * recursively places the squares in the word on the board.
	 * @param w the word to place
	 * @param square the square class which will be placed
	 * @return true if the word was placed successfully, false otherwise
	 */
	private boolean placeWord(Word w, Square square, Word toPlace) {
		System.out.println("Word: " + w.getWordString()+ ",   toPlace: " + toPlace.getWordString());
		
		//if there are no letters left, stop, return true
		if(w.getWordLength() == 0){
			return true;
		} else { 
			//add this location & letter to toPlace
			setSquareLocation(w.getLastSquare(), square, toPlace);
			
			//if the word can remove a letter...
			if(w.removeSquare()){
				
				//get all the possible locations to put the next letter
				ArrayList<Square> adjacentSquares = findAdjacents(square);

				//check that there are adjacent squares...
				if(adjacentSquares.size() == 0){

					//...if not, check if we need any
					if(w.getWordLength() == 0){return true;}
					//otherWise, delete the previously placed letters and return false
					else {
						revertSquares(toPlace);
						return false;}

					//otherwise, put the rest of the word in the next square
				} else {
					int index = ThreadLocalRandom.current().nextInt(0,adjacentSquares.size());
					Square nextPlace = adjacentSquares.get(index);
					return placeWord(w, nextPlace, toPlace);
				}
			} else {
				revertSquares(toPlace);
				return false;
			}
		}
	}

	/**
	 * sets all the squares in toPlace to false.
	 * @param toPlace
	 */
	private void revertSquares(Word toPlace) {
		System.out.println("Before revert:");
		printAllSquares();
		for(Square s: toPlace.getLetters()){
			s.setLetter(null);
		}
		System.out.println("After revert:");
		printAllSquares();
	}

	/**
	 * returns a list of square objects from global squares that are adjacent to the given square.
	 * @param square as the square that the method will find adjacents to
	 * @return ArrayList of adjacent squares
	 */
	private ArrayList<Square> findAdjacents(Square square) {
		int prevRow = square.getRow()-1;
		int prevCol = square.getColumn() -1;
		int nextRow = square.getRow() + 1;
		int nextCol = square.getColumn() + 1;

		ArrayList<Square> adjacents = new ArrayList<Square>();
		for(int i = prevRow; i <= nextRow; i ++){
			for(int j = prevCol; j <= nextCol; j ++){
				if(i >= 0 &&  i < 6 && j >= 0 && j < 6){	
					if(squares[i][j].getLetter() == null && squares[i][j].isActive())
						adjacents.add(squares[i][j]);
				}
			}
		}
		return adjacents;
	}

	/**
	 * places the letter from the square from the word into the given square from the board
	 * @param wordSquare : the square from the word
	 * @param boardSquare : the square from the board
	 */
	private void setSquareLocation(Square wordSquare, Square boardSquare, Word toPlace) {
		boardSquare.setLetter(wordSquare.getLetter().copyLetter());
		toPlace.addSquare(boardSquare);
	}


	/**
	 * given a list of words, produces a list of words whose total length is less than 36.
	 * @param targetWords2
	 * @return the list of words to use
	 */
	private ArrayList<Word> pickFromList(ArrayList<Word> targetWords2) {
		int max = 36;
		ArrayList<Word> useWords = new ArrayList<Word>();
		
		for(Word w: targetWords2){
			//if this word does not bring the total too high, add it to the list
			if(getTotalCharacters(useWords) + w.getWordLength() < max){
				useWords.add(w);
			}
		}
		//print the result
		System.out.print("Use Words: ");
		for(Word w: useWords){
			System.out.print(w.getWordString() + " ");
		}
		System.out.println();
		return useWords;
	}

	/**
	 * converts the arrayList of strings to an arrayList of words.
	 * @return an arraylist of all the words to be added to the board
	 */
	private ArrayList<Word> convertTargets(ArrayList<String> targetStrings){
		//make the arrayList of target words
		ArrayList<Word> targets = new ArrayList<Word>();

		//iterate through the target strings, making a new word from each string
		for(String s: targetStrings){
			Word newWord = new Word(new Square(0,0));
			newWord.removeSquare();
			String string = s.toUpperCase();
			//for each character (counting Qu as one character) get the letter object, then put it into a square
			for(int i = 0; i < string.length(); i++){
				String sub = string.substring(i, i + 1);
				System.out.println(sub);
				//Assumes q is always followed by a u
				if(sub.equals("Q")){
					sub = "Qu";
					i+=1;
				}				

				Letter l = Alphabet.letters.get(sub).copyLetter();
				Square square = new Square(i%6, i%3);
				square.setLetter(l);
				newWord.addSquare(square);
			}
			targets.add(newWord);
		}
		return targets;
	}


	/**
	 * Main static method to run the JFrame.
	 * @param args System arguments
	 */
	public static void main(String args[]){
		Model model = new Model();
		BoardState b = model.getCurrentBoardState();
		ArrayList<String> targets = new ArrayList<String>();
		targets.add("Lit");
		targets.add("Tips");
		targets.add("Finals");
		targets.add("Quit");
		targets.add("Adequate");
		targets.add("Suck");
		targets.add("extravagant");
		targets.add("pedantic");
		ThemeBuilder tbuild = new ThemeBuilder(b, targets);
		System.out.println(tbuild.targetWords);
		for(Word w : tbuild.targetWords){
			System.out.println(w.getWordString());
			for(Square s: w.getLetters()){
				int row = s.getRow();
				int col = s.getColumn();
				String letter = s.getLetter().getLetter();
				System.out.print(letter + "(" + row + ", " + col + ")     ");
			}
			System.out.println();
		}

		tbuild.printAllSquares();

		System.out.println(tbuild.getTotalCharacters(tbuild.targetWords));

		tbuild.populateSquares();

		tbuild.printAllSquares();
	}



}
