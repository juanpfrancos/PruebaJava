/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

/**
 *
 * @author Crhistian arenas y Juan Pablo Sanchez
 * 
 * 
 * Probando Git
 */
public class Heap {
    public static String mostrar = "";
    public static String mostrarHeapLleno = "";
    int i = 0;
    int heap[] = new int[tamano];
    public String buscado ="";
    public static int tamano = 10;

    public Heap(){
        i = 0;
        while(i < 10 ){
            heap[i]=0;
            i++;
        }
        i = 0;
    }
    public Heap(int valor){
        heap[0] = valor;
        i = 1;
    }
    
    public void insertar(int num){
        heap[i] = num;
        i++;
        ordenar(i);
    }
    
    public void ordenar(int j){
        int aux;
        int padre = 0;
        
        if(j > 1){
            padre = ((j)/2);
            if(heap[j-1] > heap[padre-1]){
                aux = heap[padre-1];
                heap[padre-1] = heap[j-1];
                heap[j-1] = aux;
            }
            ordenar(padre);
        }
    }
    
    public void mostrar(){
        int tam = 0;
        while(heap[tam] != 0 || tam==tamano){
            mostrar += "  " + heap[tam];
            tam++;
        }
    }
    
    public void mostrarHeapLleno(){
        for(int i=0; i<tamano; i++){
            mostrarHeapLleno += " " + heap[i];
        }
    }
    
    public void reordenarMayor(int x){
        int mayor=hijoMayor(x);
        int aux=0;
        if(heap[x]<heap[mayor]){
            aux=heap[x];
            heap[x]=heap[mayor];
            heap[mayor]=aux;
            reordenarMayor(mayor);
        }
    }
    
    public void reordenarMenor(int x){
        int menor=hijoMenor(x);
        int aux=0;
        if(heap[x]<heap[menor]){
            aux=heap[x];
            heap[x]=heap[menor];
            heap[menor]=aux;
            reordenarMenor(menor);
        }
    }
    
    public void eliminar(int num){
        int tam=0;
        int aux=0;
        while(tam < i){
            if(num==heap[tam]){ //si el valor a elimnar existe
                aux = tam+1;
                i--;
            }
            if(tam < i){ // Si el valor no es el ultimo
                heap[tam] = heap[aux];
                reordenarMayor(tam);
            }else{ // Si es el ultimo
                heap[i] = 0;
            }
            tam++;
            aux++;
        }
        heap[i] = 0; // convierte en cero el ultimo valor del array
    }
    
    public void buscar(int num){
        int tam=0;
        int cont = 0;
        buscado="No";
        for(int j = 0; j < i;j++){
            if(heap[j]==num){
                buscado= "El valor " + num + " Se encuentra en el arbol";
            }
            if(buscado=="No"){
                buscado= "El valor " + num + " No Se encuentra en el arbol";
            }
        }
    }    
    
    public int hijoMayor(int x){
        int hizq = (x+1)*2;
        int hder = (x+1)*2+1;
        if(heap[hizq-1]>heap[hder-1])
            return hizq-1;
        else return hder-1;
    }

    public int hijoMenor(int x){
        int hizq = (x+1)*2;
        int hder = (x+1)*2+1;
        if(heap[hizq-1]<heap[hder-1])
            return hizq-1;
        else return hder-1;
    }
    public void clearMostrar(){
        mostrar = "";
    }
    public String getMostrar(){
        return mostrar;
    }
    public void clearMostrarHeapLleno(){
        mostrarHeapLleno = "";
    }
    public String getMostrarHeapLleno(){
        return mostrarHeapLleno;
    }

    public int[] getHeap() {
        return heap;
    }

    public void setHeap(int[] heap) {
        this.heap = heap;
    }

    public String getBuscado() {
        return buscado;
    }

    public void setBuscado(String buscado) {
        this.buscado = buscado;
    }
   
}