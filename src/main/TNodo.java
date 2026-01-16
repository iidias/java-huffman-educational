package main;

public class TNodo {
	char caractere ;
	int frequencia ;
	TNodo esq ;
	TNodo dir ;
	
	public TNodo ( char c, int f) {
		caractere = c;
		frequencia = f;
		esq = dir = null ;
	}
	public TNodo ( int f, TNodo e, TNodo d) {
		caractere = '\0';
		frequencia = f;
		esq = e;
		dir = d;
	}
	public boolean ehFolha () {
		return esq == null && dir == null ;
	}
}