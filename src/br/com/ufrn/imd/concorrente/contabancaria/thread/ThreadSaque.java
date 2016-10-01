package br.com.ufrn.imd.concorrente.contabancaria.thread;

import br.com.ufrn.imd.concorrente.contabancaria.dominio.ContaBancaria;

public class ThreadSaque extends Thread{
	private ContaBancaria conta;
	private int valor;

	public ThreadSaque(ContaBancaria conta, int valor) {
		super();
		this.conta = conta;
		this.valor = valor;
	}

	public ContaBancaria getConta() {
		return conta;
	}

	public void setConta(ContaBancaria conta) {
		this.conta = conta;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public synchronized void realizaSaque() throws InterruptedException {
		if(conta.getSaldo() - valor < 0){
			System.out.println("!!! Saque não realizado !!!");
			int nv = conta.getSaldo() - valor;
			System.out.println("Saldo fica negativo: " + nv);
			wait();
		}
		
		while(conta.getSaldo() - valor >= 0){
			int novoValor = conta.getSaldo() - valor;
			conta.setSaldo(novoValor);
			System.out.println("Saque efetuado no valor de: " + valor);
			System.out.println("Saldo atual (depois do saque): " + conta.getSaldo());
			Thread.sleep((long) Math.random() * 1000); 
			notifyAll();
			realizaSaque();
		}
	}
	
	@Override
	public void run() {
		try {
			realizaSaque();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
