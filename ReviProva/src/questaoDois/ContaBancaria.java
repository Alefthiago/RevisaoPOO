package questaoDois;

import java.util.Objects;

/*
 * Com base nos conceitos de O.O aprendidos, crie uma classe que abstraia uma conta bancária acerca de
 * um sistema de gerenciamento de contas. Considere os atributos número de conta, saldo e 
 * status como sendo obrigatórios. Do ponto de vista do comportamento da conta, a mesma pode ser ativada, desativada a 
 * qualquer momento, como também deve compreender as seguintes operações: consultar saldo, sacar e transferir quantia. 
 * Também considere que, para realizar as operações, a conta deve estar ativa. 
 * Se a operação envolver mais de uma conta, ambas devem estar ativas. 
 * Por fim, os métodos equals(), toString() e hashCode() devem ser implementados.
 */
public class ContaBancaria {

	// Atributos obrigatórios
	private int numeroConta;
	private double saldo;
	private boolean stauts;

	// Construtor
	public ContaBancaria(int numeroConta, double saldo) {
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.stauts = true; // A conta é ativada por padrão ao ser criada
	}

	// Método para consultar o saldo
	public double consultarSaldo() {
		return saldo;
	}

	// Método para sacar uma quantia
	public boolean sacar(double quantia) {
		if (this.stauts && quantia > 0 && this.saldo >= quantia) {
			saldo -= quantia;
			return true;
		}
		return false;
	}

	// Método para transferir uma quantia para outra conta
	public boolean transferir(ContaBancaria contaDestino, double quantia) {
		if (this.stauts && contaDestino.isAtiva() && quantia > 0 && this.saldo >= quantia) {
			saldo -= quantia;
			contaDestino.depositar(quantia);
			return true;
		}
		return false;
	}

	// Método para depositar uma quantia
	public void depositar(double quantia) {
		if (quantia > 0) {
			this.saldo += quantia;
		}
	}

	// Método para desativar a conta
	public void desativarConta() {
		this.stauts = false;
	}

	// Método para ativar a conta
	public void ativarConta() {
		this.stauts = true;
	}

	// Método equals para comparar duas contas
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ContaBancaria))
			return false;
		ContaBancaria that = (ContaBancaria) o;
		return numeroConta == that.numeroConta;
	}

	// Método toString para representação em string da conta
	@Override
	public String toString() {
		return "ContaBancaria{" + "numeroConta=" + numeroConta + ", saldo=" + this.saldo + ", ativa=" + this.stauts
				+ '}';
	}

	// Método hashCode para calcular o hash da conta
	@Override
	public int hashCode() {
		return Objects.hash(numeroConta);
	}

	// Getter para verificar se a conta está ativa
	public boolean isAtiva() {
		return this.stauts;
	}
}
