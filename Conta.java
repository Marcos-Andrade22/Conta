package contaEx;

public class Conta {
			String celular;
			Cliente titular;
			double saldo;
			double salario;
			
			boolean saca(double valor)
			{
				if(valor > this.saldo)
				{
					System.out.println("Saldo insuficiente para retirar esse valor!");
					return false;
				}
				else
				{
					System.out.println("Saldo de " + this.titular.nome + " antes do saque: R$" + this.saldo);
					double novoSaldo = this.saldo - valor;
					this.saldo = novoSaldo;
					System.out.println("Saldo de " + this.titular.nome + " após saque: R$" + this.saldo);
					return true;					
				}
			}
			void deposita(double quantidade)
			{
				System.out.println("Saldo de "+ this.titular.nome + " antes do depósito: R$" + this.saldo);
				double novoSaldo = this.saldo + quantidade;
				this.saldo = novoSaldo;
				System.out.println("Saldo de "+ this.titular.nome + " após depósito: R$" + this.saldo);
			}
			
			boolean transferePara(Conta destino, double valor) 
			{
				boolean retirou = this.saca(valor);				
				if(retirou)
				{
					System.out.println("Transferência de R$" + valor + " realizada da conta de " + this.titular.nome + " para a conta de " + destino.titular.nome);
					destino.deposita(valor);
					return true;
				}
				else
					System.out.println("Não foi possível transferir o dinheiro");
					return false;
			}
			
			public  void testaDuasContas()
			{
				Conta minhaConta;
				minhaConta = new Conta();		
				minhaConta.saldo = 1000;
				
				Conta meuSonho;
				meuSonho = new Conta();
				meuSonho.saldo = 1500000;
				
			}
						
			public  void testaReferencias()
			{
				Conta c1 = new Conta();
				c1.deposita(100);
				Conta c2 = c1;
				c2.deposita(200);
				System.out.println(c1.saldo);
				System.out.println(c2.saldo);
			}
			
			public  void testaContasIguais()
			{
				Conta c1 = new Conta();
				Cliente cliente1 = new Cliente();
				Cliente cliente2 = new Cliente();
				c1.titular = cliente1;
				c1.saldo = 227;
				
				Conta c2 = new Conta();
				c2.titular = cliente2;
				c2.saldo = 227;
				if(c1 == c2)
				{
					System.out.println("Contas iguais!");
				}
				else
				{
					System.out.println("Contas diferentes!");
				}				
			}
			
			
}
