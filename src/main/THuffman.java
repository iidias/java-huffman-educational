package main;

import java . util . Scanner ;
public class THuffman {
	private int MAX = 256;
	private String mensagem ;
	private int [] frequencia ;
	private String [] codigos ;
	private String binOriginal ;
	private TNodo raiz ;
	private String codificada ;
	private String decodificada ;
	public THuffman () {
		frequencia = new int [MAX ];
		codigos = new String [ MAX ];
	}
	public void contarFrequencias() {
		for (int i = 0; i < mensagem . length (); i ++) {
			frequencia [ mensagem . charAt (i) ]++;
		}
		System.out.println("\nFrequência dos caracteres:");
		for (int i = 0; i < MAX; i ++) {
			if ( frequencia [i] > 0) {
				System.out.println("’" + ( char )i + "’ ? " + frequencia [i]);
			}
		}
	}
	public String getMensagem() {
		return mensagem ;
	}
	
	public void setMensagem() {
		Scanner sc = new Scanner(System .in);
		System.out.print("Digite a mensagem: ");
		mensagem = sc.nextLine();
		sc.close();
		System.out.println("\nMensagem original: " + mensagem );
	}
	
	public void mensagemParaBinario() {
		String resultado = "";
		System.out.println("\nMensagem original em binário:");
		for (int i = 0; i < mensagem . length (); i ++) {
			String bin = String.format("%8s", Integer.toBinaryString(mensagem.charAt (i))).replace(' ', '0');
			resultado += bin ;
			System.out.println ("’" + mensagem . charAt (i) + "’ ? " + bin );
		}
		binOriginal = resultado ;
	}
	
	public void construirArvore() {
		TNodo [] fila = new TNodo [MAX];
		int tam = 0;
		// Criar nós folhas
		for (int i = 0; i < MAX; i++) {
			if (frequencia[i] > 0) {
				fila[tam ++] = new TNodo ((char) i, frequencia[i]);
			}
		}
		
		// Árvore
		while ( tam > 1) {
			int menor1 = 0, menor2 = 1;
			if ( fila [ menor2 ]. frequencia < fila [ menor1 ]. frequencia ) {
				int tmp = menor1 ;
				menor1 = menor2 ;
				menor2 = tmp ;
			}
			for (int i = 2; i < tam; i ++) {
				if ( fila [i]. frequencia < fila [ menor1 ]. frequencia ) {
					menor2 = menor1 ;
					menor1 = i;
				} else if ( fila [i]. frequencia < fila [ menor2 ]. frequencia ) {
					menor2 = i;
				}
			}
			TNodo nova = new TNodo (
				fila [ menor1 ]. frequencia + fila [ menor2 ]. frequencia ,
				fila [ menor1 ],
				fila [ menor2 ]
			);
			System.out.println ("\nUnindo árvores:");
			System.out.println(" - '" + mostrarCaractere(fila[menor1]) + "' com freq " 
			        + fila[menor1].frequencia);

			System.out.println(" - '" + mostrarCaractere(fila[menor2]) + "' com freq " 
			        + fila[menor2].frequencia);
			System . out . println (" ? Nova árvore com freq " + nova . frequencia );
			if ( menor2 > menor1 ) {
				fila [ menor1 ] = nova ;
				for (int i = menor2 ; i < tam - 1; i++)
					fila [i] = fila [i + 1];
			} else {
				fila [ menor2 ] = nova ;
				for (int i = menor1 ; i < tam - 1; i++) 
					fila [i] = fila [i + 1];
			}
			tam --;
		}
		raiz = fila [0];
	}
	
	private String mostrarCaractere(TNodo n) {
		return n.ehFolha () ? (n. caractere + "") : "*";
	}
	
	public void gerarCodigos () {
		System.out.println("\nTabela de Códigos de Huffman:");
		gerarCodigos(raiz ,"");
	}
	
	private void gerarCodigos(TNodo raiz , String caminho ) {
		if (raiz == null) return ;
		if (raiz.ehFolha ()) {
			codigos[raiz.caractere] = caminho ;
			System.out.println("’" + raiz.caractere + "’ ? " + caminho );
		}
		gerarCodigos(raiz.esq, caminho + "0");
		gerarCodigos(raiz.dir, caminho + "1");
	}
	
	public void codificarMensagem () {
		String resultado = "";
		for (int i = 0; i < mensagem . length (); i ++) {
			resultado += codigos [ mensagem . charAt (i)];
		}
		codificada = resultado ;
		System.out.println ("\nMensagem codificada: " + codificada );
	}
	
	public void decodificarMensagem () {
		String resultado = "";
		TNodo atual = raiz ;
		for (int i = 0; i < codificada . length (); i++) {
			atual = ( codificada . charAt (i) == '0') ? atual.esq : atual.dir ;
			if (atual.ehFolha ()) {
				resultado += atual.caractere ;
				atual = raiz ;
			}
		}
		decodificada = resultado ;
		System.out.println("Mensagem decodificada: " + decodificada);
	}
	
	public void analisarCompressao (){
		int originalBits = binOriginal . length ();
		int compactadoBits = codificada . length ();
		double fator = 100.0 * (1.0 - ( double ) compactadoBits / originalBits );
		System.out.println ("\n--- Comparação ---");
		System.out.println (" Tamanho original (bits): " + originalBits );
		System.out.println (" Tamanho codificado (bits): " + compactadoBits );
		System.out.printf(" Fator de compressão : %.2f%% de economia \n", fator);

	}
}