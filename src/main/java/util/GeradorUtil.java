package util;

public class GeradorUtil {
	public static String gerarCaracter(int qtd) {
		String palavra = "";
		int indice;
		String[] caracteres = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
				"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " " };

		for (int i = 0; i < qtd; i++) {
			indice = (int) (Math.random() * caracteres.length);
			palavra += caracteres[indice];
		}
		return palavra;
	}

	public static String gerarNome() {
		String nome;
		int indice;
		String[] nomes = { "Jo�o", "Maria", "Beatriz", "Antonio", "Jefferson", "Silvio", "Tatiana", "Soeli", "Joana",
				"Camilla", "kelly", "Venicius", "Marcos", "Pedro", "Rodrigo", "Jurema", "Cintia", "Marta", "Michelly",
				"Anderson", "Sergio", "Elisabete", "Sandra", "Ana", "Alex" };
		indice = (int) (Math.random() * nomes.length);
		nome = nomes[indice];
		nome = nome + " " + gerarSobreNome();
		return nome;
	}
	
	private static String gerarSobreNome() {
		String sobrenome;
		int indice;
		String[] nomes = { "Silva", "Motto", "Ribeiro", "May", "Junior", "Cionette", "Souza", "Aurelio", "Pereira",
				"Oliveira", "Araujo", "Matos", "Barbosa", "Nascimento", "Coe", "Garc�a", "Lopez", "Peres", "Pires",
				"Martinez", "Rodrigues", "Neto" };
		indice = (int) (Math.random() * nomes.length);
		sobrenome = nomes[indice];
		return sobrenome;
	}
	
	public static String gerarDisciplina() {
		String nome;
		int indice;
		String[] nomes = {"POO", "Banco de dados", "Arquitetura de software"
				,"Sistemas embarcados"};
		indice = (int) (Math.random() * nomes.length);
		nome = nomes[indice];
		return nome;
	}
	
	public static String gerarCurso() {
		String nome;
		int indice;
		String[] nomes = {"ADS", "TGTI", "ADM"
				,"TGRH"};
		indice = (int) (Math.random() * nomes.length);
		nome = nomes[indice];
		return nome;
	}
	
	public static String gerarComplemento() {
		String nome;
		int indice;
		String[] nomes = {"Casa", "Apartamento"};
		indice = (int) (Math.random() * nomes.length);
		nome = nomes[indice];
		return nome;
	}
	
	public static String gerarBairro() {
		String nome;
		int indice;
		String[] nomes = {"BARREIROS", "AGRONOMICA", "MONTE VERDE"
				,"AREIAS", "JURERE", "CAMPECHE", "CENTRO", "INGLESES", "KOBRASOL"};
		indice = (int) (Math.random() * nomes.length);
		nome = nomes[indice];
		return nome;
	}
	
	public static String gerarTipoCurso() {
		String nome;
		int indice;
		String[] nomes = {"Gradua��o", "P�s-Gradua��o", "Ensino T�cnico"};
		indice = (int) (Math.random() * nomes.length);
		nome = nomes[indice];
		return nome;
	}
	
	public static String gerarNomeEixo() {
		String nome;
		int indice;
		String[] nomes = {"Ambiente e Sa�de", "Informa��o e Comunica��o", "Gest�o e Neg�cios"};
		indice = (int) (Math.random() * nomes.length);
		nome = nomes[indice];
		return nome;
	}
	

	public static String gerarCidade() {
		String cidade;
		int indice;
		String[] cidades = { "Florian�polis", "S�o Jos�", "Palho�a", "S�o Bento", "Bigua�u", "Curitiba", "Urupema",
				"Tijucas", "Balne�rio", "Cambori�", "Santo Ant�nio", "Lapa", "Portal", "Matinhos" };
		indice = (int) (Math.random() * cidades.length);
		cidade = cidades[indice];
		return cidade;
	}

	public static String gerarUF() {
		String uf;
		int indice;
		String[] estados = { "RS", "SC", "PR", "SP", "BA", "AC", "ES", "AM", "CE", "GO", "SE", "MT", "TO", "RJ" };
		indice = (int) (Math.random() * estados.length);
		uf = estados[indice];
		return uf;
	}

	public static String gerarLogradouro() {
		String logradouro;
		int indice;
		String[] logs = { "Rua das Palmeiras", "Rua das Sambambaia", "Rua das Perdas", "Rua S�o Bento",
				"Rua dos Ara�as", "Rua dos Carac�is", "Rua dos Javeiros", "Rua Brasileira", "Rua da Figa",
				"Rua da Urupema", "Rua Tijucas do Meio", "Rua di Balne�ri", "Travessa Cambori�", "Pra�a Santo Ant�nio",
				"Beco da Lapa", "Av Portal 2", "Av Matinhos Verde" };
		indice = (int) (Math.random() * logs.length);
		logradouro = logs[indice];
		return logradouro;
	}

	public static String gerarNumero(int qtd) {
		String numero = "";
		for (int i = 0; i < qtd; i++) {
			numero += (int) (Math.random() * 10);
		}
		return numero;
	}

	public static String gerarEmail() {
		return gerarCaracter(8) + "@email.com";
	}

	public static String gerarCep() {
		return gerarNumero(5) + "-" + gerarNumero(3);
	}
	public static int gerarHora(int qtd) {
		int numero = 0;
		for (int i = 0; i < qtd; i++) {
			numero += (int) (Math.random() * 10);
		}
		return numero;
}

	public static String gerarCpf() {
		return gerarNumero(3) + "." + gerarNumero(3) + "." + gerarNumero(3) + "-" + gerarNumero(2);
	}
	
	public static String gerarCnpj() {
	    return gerarNumero(2) + "." + gerarNumero(3) + "." + gerarNumero(3) + "/" + gerarNumero(4) + "-" + gerarNumero(2);
	    }

	public static String gerarTelefoneFixo() {
		return "(48)3" + gerarNumero(3) + "-" + gerarNumero(4);
	}

	public static String gerarTeleCelular() {
		return "(48)99" + gerarNumero(3) + "-" + gerarNumero(4);
	}

	public static int criarNumeroAleatorioEntre2Valores(int menor, int maior) {
		int numero = (int) (Math.random() * (maior - menor));
		if (numero == 0) {
			numero++;
		}
		numero = numero + menor;
		return numero;
	}
}
