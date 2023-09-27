package questaoUm;

// Não precisam colcoar os imports na prova. //
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Paciente {
	/*
	 * (1) Com base nos conceitos de O.O aprendidos, crie uma classe em Java que
	 * abstraia o registro de um paciente acerca de um sistema de gerenciamento de
	 * prontuário. Considere os atributos: CPF, nome, altura, peso, sexo e IMC como
	 * sendo obrigatórios. Do ponto de vista do comportamento da classe, os métodos
	 * calcularIMC() e calcularMetabolismoBasal(), ambos com retorno float, são
	 * imprescindíveis. Por fim, os métodos equals(), toString() e hashCode() devem
	 * ser implementados utilizando apenas o atributo CPF. Complementarmente,
	 * abstraia uma classe que represente o exame médico para paciente. O exame deve
	 * conter um campo de identificação, data e descrição. Considere que um paciente
	 * pode ter nenhum ou vários exames. Os métodos equals(), toString() e
	 * hashCode() também devem ser implementados para a classe exame.
	 * 
	 * Os cálculos para os métodos como calcularMetabolismoBasal() estarão na prova,
	 * então podem ficar "tranquilos".
	 */

	/*
	 * A anotação "@Override" indica que o método está sobrescrevendo um método da
	 * classe PAI(neste caso a classe Object).
	 */

	// Atributos. //
	public String CPF;
	public String nome;
	public int idade;
	public float altura;
	public float peso;
	public String sexo;
	public float IMC;
	public List<Exame> exames;
	// /atributos. //

	// Construtor. //
	public Paciente(String CPF, String nome, int idade, float altura, float peso, String sexo) {
		this.CPF = CPF;
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
		this.sexo = sexo;
		this.IMC = calcularIMC();
		this.exames = new ArrayList<Exame>();
	}
	// /construtor. //

	// Métodos. //
	public float calcularIMC() {
		return this.peso / (this.altura * altura);
	}

	public float calcularMetabolismoBasal() {
		/*
		 * Em questões mais extensas, não é necessário fornecer uma explicação detalhada
		 * para cada parte do código. É suficiente demonstrar que você compreende e sabe
		 * como fazer. No entanto, caso tenha dúvidas, não hesite em perguntar durante a
		 * prova.
		 */

		if (this.sexo == "feminino") {
			if (this.idade >= 0 || this.idade < 3) {
				return (61 * this.peso) - 51;
			} else if (this.idade >= 3 || this.idade < 10) {
				return (22.5f * this.peso) + 499;
			} else if (this.idade >= 10 || this.idade < 18) {
				return (12.2f * this.peso) + 746;
			} else if (this.idade >= 18 || this.idade < 30) {
				return (14.7f * this.peso) + 496;
			} else if (this.idade >= 30 || this.idade < 60) {
				return (8.7f * this.peso) + 829;
			} else {
				return (10.5f * this.peso) + 596;
			}
		} else {
			if (this.idade >= 0 || this.idade < 3) {
				return (60.9f * this.peso) - 54;
			} else if (this.idade >= 3 || this.idade < 10) {
				return (22.7f * this.peso) + 495;
			} else if (this.idade >= 10 || this.idade < 18) {
				return (17.5f * this.peso) + 651;
			} else if (this.idade >= 18 || this.idade < 30) {
				return (15.3f * this.peso) + 679;
			} else if (this.idade >= 30 || this.idade < 60) {
				return (11.6f * this.peso) + 879;
			} else {
				return (13.5f * this.peso) + 487;
			}
		}
	}

	public boolean adicionarExame(Exame exame) {
		if (this.exames.contains(exame)) {
			/*
			 * A função "contains" vefirica se o valor passado como argumento já está
			 * presente na coleção. Retorna TRUE se o exame foi encontrado na coleção, caso
			 * contrário, retorna FALSE.
			 */
			return false;
		} else {
			// A função "add" adiciona o valor passado como argumento à coleção. //
			this.exames.add(exame);
			return true;
		}
	}

	public boolean removerExame(Exame exame) {
		if (this.exames.contains(exame)) {
			// A função "remove" remove o elemento passado da coleção. //
			this.exames.remove(exame);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		/*
		 * O toString é sempre chamado quando o objeto é usado para apresentar
		 * informações, por exemplo "System.out.println(paciente);".
		 */
		return "Paciente [CPF=" + this.CPF + "]";
	}

	@Override
	public int hashCode() {
		/*
		 * O hashCode é usado para fornecer uma representação numérica única de um
		 * objeto, que é frequentemente utilizado para fins de identificação.
		 */
		return Objects.hash(this.CPF);
	}

	@Override
	public boolean equals(Object obj) {
		/*
		 * O método equals é usado para comparar dois objetos e verificar se eles são
		 * iguais em conteúdo.
		 */

		/*
		 * Podem colocar assim na prova, mas antes perguntem ao professor se está tudo
		 * bem fazer assim.
		 */

		// if (this.hashCode() == obj.hashCode()) {
		// return true;
		// } else {
		// return false;
		// }

		/*
		 * Mas na duvida perguntem ao professor na hora da prova.
		 */
		
		// Este código foi gerado pelo ecplise. //
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Paciente other = (Paciente) obj;
		return Objects.equals(this.CPF, other.CPF);
		// /este código foi gerado pelo ecplise. //
	}
	// /métodos. //
}
