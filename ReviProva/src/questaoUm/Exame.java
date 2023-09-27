package questaoUm;

import java.util.Date;
import java.util.Objects;

public class Exame {
	// Atributos. //
	public int id;
	public Date data;
	public String descricao;

	static int CONTADOR = 0;
	// /atributos. //

	// Construtor. //
	public Exame(String descricao) {
		this.id = CONTADOR++;
		/*
		 * O valor que sera colocado no atributo "this.data" vai ser a data do sistema
		 * operacional na hora da criação do objeto.
		 */
		this.data = new Date();
		this.descricao = descricao;
	}
	// /construtor. //

	// Métodos. //
	@Override
	public String toString() {
		return "Exames [id=" + this.id + ", data=" + this.data + ", descricao=" + this.descricao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, descricao, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exame other = (Exame) obj;
		return Objects.equals(data, other.data) && Objects.equals(descricao, other.descricao) && id == other.id;
	}
	// /métodos. //
}
