package leetcode.ing;

public class WordSearch{

	public static void main(String[] args){
		WordSearch w = new WordSearch();
		char[][] board = new char[][]{{'A','B','C','E'}
		   							 ,{'S','F','C','S'}
		                             ,{'A','D','E','E'}};
//		System.out.println(w.exist(board, "ABCCED"));
//		System.out.println(w.exist(board, "SEE"));
//		System.out.println(w.exist(board, "ADEE"));
//		System.out.println(w.exist(board, "ABCB"));
//		
//		board = new char[][]{{'C','A','A'}
//			 				,{'A','A','A'}
//			 				,{'B','C','D'}};
//		System.out.println(w.exist(board, "AAB"));
		
		//FIXME Time Limit Exceeded
		board = new char[][]{{'b', 'b'},
						     {'a', 'b'},
						     {'b', 'a'}};
		System.out.println(w.exist(board, "a"));
	}

	public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i=0;i<board.length;i++){
        	for (int j=0;j<board[i].length;j++){
        		if (board[i][j] != words[0]){
        			continue;
        		}
        		if (checkWordSearch(board, words, 1, i, j, 0)){
        			return true;
        		}
        	}
        }
        return false;
    }
	
	
	/**
	 * @param board
	 * @param words
	 * @param wordsIdx words의 시작위치
	 * @param idxX
	 * @param idxY
	 * @param direction 직전 위치, 0 없음, 1 왼쪽, 2 오른쪽, 3 위, 4 아래
	 * @return
	 *
	 */
	public boolean checkWordSearch(char[][] board, char[] words, int wordsIdx, int idxX, int idxY, int direction){
		
		System.out.print(board[idxX][idxY]);
		
		if (wordsIdx >= words.length){
			return true;
		}
		
		boolean left = direction == 1 ? true : false;
		boolean right = direction == 2 ? true : false;
		boolean above = direction == 3 ? true : false;
		boolean below = direction == 4 ? true : false;
		
		boolean result = false;
		
		if (!below && idxX+1 < board.length && words[wordsIdx] == board[idxX+1][idxY]){
			idxX++;
			direction = 3;
			result = checkWordSearch(board, words, wordsIdx+1, idxX, idxY, direction);
		}
		if (!result && !above && idxX-1 >= 0 && words[wordsIdx] == board[idxX-1][idxY]){
			idxX--;
			direction = 4;
			result = checkWordSearch(board, words, wordsIdx+1, idxX, idxY, direction);
		}
		if (!result && !right && idxY+1 < board[idxX].length && words[wordsIdx] == board[idxX][idxY+1]){
			idxY++;
			direction = 1;
			result = checkWordSearch(board, words, wordsIdx+1, idxX, idxY, direction);
		}
		if (!result && !left && idxY-1 >= 0 && words[wordsIdx] == board[idxX][idxY-1]){
			idxY--;
			direction = 2;
			result = checkWordSearch(board, words, wordsIdx+1, idxX, idxY, direction);
		}
		
		return result;
	}
}
