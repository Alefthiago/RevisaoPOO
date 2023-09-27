package questaoTres;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import questaoDois.ContaBancaria;

/*
 * "De forma complementar à questão anterior, abstraia uma classe que represente
 *  a figura do cliente detentor da conta bancária. Para o cliente, defina uma classe com 
 *  CPF e nome, além da variável de referência que faz referência à conta. Os métodos 
 *  equals(), toString() e hashCode() devem ser implementados
 */
public class Cliente {
	public String cpf;
	public String nome;
	public List<ContaBancaria> conta;

	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
		this.conta = new ArrayList<>();

	}

	public boolean adicionarConta(ContaBancaria conta) {
		if (this.conta.contains(conta)) {
			return false; // A conta já está associada ao cliente.
		} else {
			this.conta.add(conta);
			return true; // A conta foi adicionada com sucesso.
		}
	}

	public boolean removerConta(ContaBancaria conta) {
		if (this.conta.contains(conta)) {
			this.conta.remove(conta);
			return true; // A conta foi removida com sucesso.
		} else {
			return false; // A conta não estava associada ao cliente.
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Cliente))
			return false;
		Cliente cliente = (Cliente) o;
		return Objects.equals(cpf, cliente.cpf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public String toString() {
		return "Cliente{" + "cpf='" + cpf + '\'' + ", nome='" + nome + '}';
	}
}
