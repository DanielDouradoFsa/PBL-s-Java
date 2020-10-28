/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.organizer.util;
import java.util.Comparator;
/**
 *
 * @author administrador1
 */

public class Sort
{ 
    Comparator x;
    public Sort(Comparator x) {
        this.x = x;
    }
	List head = null; 
	public List sortedMerge(List a, List b) 
	{ 
		List result = null; 
		//Caso base para encerrar recursão
		if (a == null) 
			return b; 
		if (b == null) 
			return a; 

		/* Escolha a ou b para e recorrer */
		if (x.compare(a.getDados(), b.getDados())>0){
                    result = a; 
                    result.prox = sortedMerge(a.prox, b); 
		} 
		else{ 
                    result = b; 
                    result.prox = sortedMerge(a, b.prox); 
		} 
		return result; 

	} 

	public List mergeSort(List h) 
	{ 
		// Base case : if head is null 
		if (h == null || h.prox == null){ 
			return h; 
		} 

		// get the middle of the list 
		List middle = getMiddle(h); 
		List nextofmiddle = middle.prox; 

		// set the next of middle node to null 
		middle.prox = null; 

		// Aplica merge sort na lista da esquerda
		List left = mergeSort(h); 

		// Aplica mergeSort na lista da direita 
		List right = mergeSort(nextofmiddle); 

		// Funde as listas da direita e da esquerda
		List sortedlist = sortedMerge(left, right); 
		return sortedlist; 
	} 

	// Utility function to get the middle of the linked list 
	public List getMiddle(List h) {
	 
		//Base case 
		if (h == null) 
			return h; 
		List fastptr = h.prox; 
		List slowptr = h; 
		
		// Move fastptr por dois e slowptr por um
                
		// Ao final slowptr ira apontar para o meio da lista 
		while (fastptr != null) 
		{ 
			fastptr = fastptr.prox; 
			if(fastptr!=null) 
			{ 
                            slowptr = slowptr.prox; 
                            fastptr=fastptr.prox; 
			} 
		} 
		return slowptr; 
	} 
} 




