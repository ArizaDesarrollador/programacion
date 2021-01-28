package programacion;

public class Pruebas {

	public static void main(String[] args) {
		
		int [] array = {1,2,3,4,5};
		int aux;
		for (int i = 0; i < array.length ; i++) {
			int contador = (int) Math.floor(Math.random()*5 );
			aux = array [contador];
			array [contador] = array [contador+1];
			array [contador+1] = aux;
		}
		
		for (int i = 0; i < array.length ; i++) {
			System.out.println(array [i]);
		}

	}

}
