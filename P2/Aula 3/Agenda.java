/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;

public class Agenda {

	Nota [] notas = new Nota[0];
	
	public void novaNota(Data2 inicio, Data2 fim, String texto){
		Nota [] novaNota = new Nota[notas.length+1];

		for(int i=0;i<notas.length;i++){
			novaNota[i] = notas[i];
		}
		
		novaNota[notas.length] = new Nota(inicio, fim, texto);
		
		notas=novaNota;
	}
	
	public Nota[] compromissos(Data2 inicio, Data2 fim){
		int n=0;
		
		for(int i=0;i<notas.length;i++){
			if((notas[i].getInicio().maiorDoQue(inicio) || notas[i].getInicio().igualA(inicio)) && (notas[i].getInicio().menorDoQue(fim) ||notas[i].getInicio().igualA(fim))){
		        n++;
		      }else if((notas[i].getFim().maiorDoQue(inicio) || notas[i].getFim().igualA(inicio)) && (notas[i].getFim().menorDoQue(fim) || notas[i].getFim().igualA(fim))){
		        n++;
		      }
		}
		
		Nota ret[] = new Nota[n];
		
		n=0;
		for(int i=0;i<notas.length;i++){
			if((notas[i].getInicio().maiorDoQue(inicio) || notas[i].getInicio().igualA(inicio)) && (notas[i].getInicio().menorDoQue(fim) ||notas[i].getInicio().igualA(fim))){
				ret[n]=notas[i];
				n++;
		    }
			else if((notas[i].getFim().maiorDoQue(inicio) || notas[i].getFim().igualA(inicio)) && (notas[i].getFim().menorDoQue(fim) || notas[i].getFim().igualA(fim))){
				ret[n]=notas[i];
				n++;
		    }
		}
		
		
		return ret;
	}
	
	public void escreve(){
		boolean troca;
		
		do{
			troca=false;
			for(int i=0;i<notas.length-1;i++){
				if(notas[i+1].getInicio().menorDoQue(notas[i].getInicio())){
					Nota [] temp = new Nota[1];
					temp[0]=notas[i];
					notas[i]=notas[i+1];
					notas[i+1]=temp[0];
					troca=true;
				}
			}
			
		}while(troca);
		
		for(int i=0;i<notas.length;i++){
			out.println(notas[i].escreve());
		}
	}

}
