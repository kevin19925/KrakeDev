package p1;

import java.util.ArrayList;
import java.util.Collections;

public class laberinto {
	public static ArrayList<Character> letras = new ArrayList<Character>();
	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		int xa = 0;
		int ya = 0;
		char[][] matriz = { { 'A', 'S', 'L', 'D' },
				{ 'T', 'R', 'W', 'R' }, 
				{ 'R', 'M', 'S', 'R' },

				{ 'W', 'R', 'R', 'M' } };

		// Mostrar la matriz de caracteres por pantalla
		System.out.println("Matriz de caracteres:");

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(" [" + i + "],[" + j + " ] ");
			}
			System.out.println();
		}
		int numero = 0;

		do {

			if (x == 0 && y == 0) {

				if ('R' == matriz[x + 1][y]) {
					x = x + 1;
					y = y;

				}
				else {
					//System.out.print(matriz[x + 1][y]);
				}

				if ('R' == matriz[x][y + 1]) {
					x = x;
					y = y + 1;
					//System.out.println(x);
				//	System.out.println(y);
				}
				else {
					//System.out.print(matriz[x ][y+1]);
				}
				
				if ('R' == matriz[x + 1][y + 1]) {
					x = x+1;
					y = y + 1;
					
				}else {
					//System.out.print(matriz[x ][y+1]);
				}

				

			}
			
	
			if(x!=0 && y!=0) {
				if ('R' == matriz[x][y + 1]) {
					x = x ;
					y = y+1;
				}
				
				if ('R' == matriz[x][y - 1]) {
					x = x ;
					y = y-1;
				}
				if ('R' == matriz[x - 1][y]) {
					x = x - 1;
					y = y;
				}
				if ('R' == matriz[x + 1][y]) {
					x = x + 1;
					y = y;
				}
				
				if ('R' == matriz[x + 1][y+1]) {
					x = x + 1;
					y = y+1;
				}
				
				if ('R' == matriz[x - 1][y-1]) {
					x = x - 1;
					y = y-1;
				}
				
				if ('R' == matriz[x + 1][y-1]) {
					x = x + 1;
					y = y-1;
				}
				
				if ('R' == matriz[x -1][y+1]) {
					x = x - 1;
					y = y+1;
				}
				
				imprimir(matriz[x + 1][y]);
				imprimir(matriz[x - 1][y]);
				imprimir(matriz[x][y + 1]);
				imprimir(matriz[x][y - 1]);
				
				imprimir(matriz[x + 1][y+1]);
				imprimir(matriz[x - 1][y-1]);
				imprimir(matriz[x-1][y + 1]);
				imprimir(matriz[x+1][y - 1]);
				 Collections.sort(letras);
				 System.out.println(letras);
			}
			
			
			
//		
//			if(y==0) {
//				if ('R' == matriz[x - 1][y]) {
//					x = x - 1;
//					y = y;
//				}
//				if ('R' == matriz[x + 1][y]) {
//					x = x + 1;
//					y = y;
//				}
//				if ('R' == matriz[x][y + 1]) {
//					x = x ;
//					y = y+1;
//				}
//				System.out.print(matriz[x + 1][y]);
//				System.out.print(matriz[x - 1][y]);
//				System.out.print(matriz[x][y + 1]);
//				//System.out.print(matriz[x][y - 1]);
//
//			}
//			
//			if(x==0) {
//				if ('R' == matriz[x + 1][y]) {
//					x = x + 1;
//					y = y;
//				}
//				if ('R' == matriz[x][y + 1]) {
//					x = x ;
//					y = y+1;
//				}
//				if ('R' == matriz[x][y - 1]) {
//					x = x ;
//					y = y-1;
//				}
//				
//				System.out.print(matriz[x + 1][y]);
//				//System.out.print(matriz[x - 1][y]);
//				System.out.print(matriz[x][y + 1]);
//				System.out.print(matriz[x][y - 1]);
//				
//			}
//		

			numero++;
		} while (numero < 1);

	}
	
	public static void imprimir(char letra) {
		
		if(letra!='A' &&letra!='R'&&letra!='M') {
			
			letras.add(letra);
		}
		
		    
		    
		  
		
		 
		
			
	}
}

//
//	public static void encontrar(char [] [] m,int x , int y) {
//		
//		
//		ArrayList<Posicion> posisciones= new ArrayList<Posicion>(); 
//		
//		posisciones.add(new Posicion(x+1, y));
//		posisciones.add(new Posicion(x+1, y));
//		posisciones.add(new Posicion(x+1, y));
//		posisciones.add(new Posicion(x+1, y));
//		posisciones.add(new Posicion(x+1, y));
//		
//		if(x==0 && y==0) {
//		
//			posisciones.add(new Posicion(x, y+1));
//			posisciones.add(new Posicion(x+1, y));
//			posisciones.add(new Posicion(x+1, y+1));
//			
//	}
//		
//		if(x==0 ) {
//			
//			posisciones.add(new Posicion(x, y-1));
//			posisciones.add(new Posicion(x+1, y));
//			posisciones.add(new Posicion(x+1, y+1));
//			
//	}
//
//}
//
////	System.out.print(m[x+1][y]);
////	System.out.print(m[x-1][y]);
////	System.out.print(m[x][y+1]);
////	System.out.print(m[x][y-1]);
//	
//class Posicion{
//	int x;
//	int y;
//	public Posicion(int x, int y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//	
//	
//}


