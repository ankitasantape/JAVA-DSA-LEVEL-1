/*

CHESS CHALLANGE

We have a chess board and there is a immovable piece ( pawn, knight, queen, king ) which cannot move in any direction, and we have a bishop which can only
move diagonally. Find if we can reach the immovable piece using bishop and in how many minimum steps.

*/


package Goldman_Sachs_Coderpad_Round_Interview_Question;

import java.util.ArrayDeque;
import java.util.Arrays;

public class A21_Chess_Challange {

	public static class Pair{
		int srcX;
		int srcY;
		
		Pair() {
			
		}
		
		Pair(int srcX, int srcY){
			this.srcX = srcX;
			this.srcY = srcY;
		}
	}
	
	public static int INF = (int) (1e9+10);
	public static int visited[][] = new int[8][8];
	public static int level[][] = new int[8][8];
	
	public static void main(String[] args) {
		
		
		int bishopX = 0;
		int bishopY = 0;
		int pawnX = 7;
		int pawnY = 7;
		
		for(int[] lev : level ) {
			Arrays.fill(lev, INF);
		}

		int result = chessChallange( bishopX, bishopY, bishopY, bishopX );
		
		if( result == -1 ) {
			System.out.println("Not Reachable");
		}
		else {
			
			System.out.println(result);
		}
		
	}

	private static int chessChallange(int bishopX, int bishopY, int pawnX, int pawnY) {
		
		boolean canReach = canBishopReachToPawn( bishopX, bishopY, pawnX, pawnY );
		
		if( canReach == true ) {
			return getShortestDistance(  bishopX, bishopY, pawnX, pawnY );
		}
		else {
			int ans = bfs( bishopX, bishopY, pawnX, pawnY );
			if( ans != INF ) {
				return ans;
			}
		}
		
		return -1;
	}

	private static boolean canBishopReachToPawn(int bishopX, int bishopY, int pawnX, int pawnY) {
		// if pawn is at angle 45 or 225 degree
		if( pawnX - bishopX == pawnY - bishopY ) {
			return true;
		}
		// if pawn is at 135 or 315 degree
		else if( -pawnX + bishopX == pawnY - bishopY ) {
			return true;
		}
		else {
		    return false;
		}    
	}

	private static int getShortestDistance(int bishopX, int bishopY, int pawnX, int pawnY) {
		
		int v1 = Math.abs(pawnX - bishopX);
		int v2 = Math.abs(pawnY - bishopY);
		
		int distance = (int) Math.sqrt( (int)(v1 * v1) + (int)(v2 * v2) );
		
		return distance;
	}
	
	private static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < 8 && y < 8;
	}

	private static int[][] movements = {
			{  1, -1 },  // bottom-left
			{  1,  1 },  // bottom-right
			{ -1,  1 },  // top-right
			{ -1, -1 }   // top-left
	};
	
	private static int bfs(int bishopX, int bishopY, int pawnX, int pawnY) {
		int srcX = bishopX;
		int srcY = bishopY;
		int destX = pawnX;
		int destY = pawnY;
		
		ArrayDeque<Pair> dq = new ArrayDeque<>();
		dq.add(new Pair(srcX, srcY));
		
		visited[srcX][srcY] = 1;
		level[srcX][srcY] = 0;
		
		while ( dq.size() != 0 ) {
			Pair rem = dq.peek();
			
			int x = rem.srcX;
			int y = rem.srcY;
			
			dq.remove();
			
			for(int[] move : movements ) {
				int childX = move[0] + x;
				int childY = move[1] + y;
				
				if( !isValid(childX, childY) ) {
					continue;
				}
				
				if( visited[childX][childY] == 0 ) {
					dq.push(new Pair(childX, childY));
					level[childX][childY] = level[x][y] + 1;
					visited[childX][childY] = 1;
				}
			}
			if( level[destX][destY] != INF ) {
				break;
			}
		}
		
		return level[destX][destY];
	}

}
