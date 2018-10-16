package lecturaBytes;

import java.io.*;

public interface Leer {
	
	public static void LeerFichero(File archivo, File ruta ) {
				
		int contador=0;
		
		int array[];
		
		try {
	
			//CREAMOS UNA CONEXION CON ALGUN FICHERO EXTERNO
			FileInputStream fichero=new FileInputStream(archivo);
			
			//Creamos un array con la longitud del fichero
			array=new int[(int) fichero.getChannel().size()];
			
			boolean final_array=false;
			
			//RELLENAMOS EL ARRAY CON LOS BYTES DEL FICHERO
			while(!final_array) {
				
				//creamos una variable que guarda los byte de entrada desde el fichero externo
				int byte_entrada=fichero.read();
				//el metodo .read cuando ya no ahi mas lineas que leer del fichero lanza un "-1"
				if(byte_entrada!=-1) {
					array[contador]=byte_entrada;
				}else {
					final_array=true;
				}
				
				contador++;	
			}
			
			fichero.close();
			
			FileOutputStream fichero_nuevo=new FileOutputStream(ruta);
			
			for(int i=0;i<array.length;i++) {
				fichero_nuevo.write(array[i]);
			}
			
			fichero_nuevo.close();
			
		}catch(IOException e) {
			System.out.println("Imagen no encontrada");
			e.printStackTrace();
		}
			

		
		
	}
	
}
