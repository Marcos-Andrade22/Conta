package contaEx;
import java.util.Scanner;

public class Index {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Conta minhaConta;
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		int time = 1;
		minhaConta = new Conta(); 
		System.out.println("Montando objeto cliente...");
		minhaConta.titular = retornaCliente(cliente1, scanner);
		minhaConta.saldo = 1000.0;
		minhaConta.celular = "32991040123";
		Conta conta2;
		conta2 = new Conta();
		System.out.println("Montando segundo objeto cliente...");
		conta2.titular = retornaCliente(cliente2, scanner);
		conta2.saldo = 20.0;
		conta2.celular = "3298532059";
		System.out.println("Titular: " + minhaConta.titular.nome + " " + minhaConta.titular.sobrenome);
		System.out.println("CPF: " + minhaConta.titular.cpf);
		System.out.println("Saldo: " + minhaConta.saldo);
		System.out.println("Celular: " + minhaConta.celular);
		//while(time == 1)
		{
			System.out.println("Digite qual ação deseja tomar");
			System.out.println("Para sacar, digite 'saque' sem as aspas");
			System.out.println("Para depositar, digite 'depósito' sem as aspas");	
			System.out.println("Para transferir digite 'transfere' sem as aspas");
			String chave = scanner.nextLine();
			if(!chave.equals("saque") && !chave.equals("deposito") && !chave.equals("transfere") )
				
				System.out.println("Please type an text instead of a number or symbol");
			else
			{
				if (chave.equals("saque"))
				{
					System.out.println("Digite quanto dinheiro deseja sacar: ");
					double saca = Double.parseDouble(scanner.nextLine());
					if(minhaConta.saca(saca))
					{
						System.out.println("Saque realizado com sucesso");
					}
				}
				else if(chave.equals("deposito"))
				{
					System.out.println("Digite quanto dinheiro deseja depositar: ");
					double deposita = Double.parseDouble(scanner.nextLine());
					minhaConta.deposita(deposita);
				}			
				else if(chave.equals("transfere"))
				{
					System.out.println("Digite quanto dinheiro deseja transferir");
					double valor = Double.parseDouble(scanner.nextLine());
					boolean deuCerto =  minhaConta.transferePara(conta2, valor);
				}
			}					
			
		}
		//testaReferencias();
		//Conta.testaContasIguais();
		
	 }
	public static Cliente retornaCliente(Cliente cliente1, Scanner scanner)
	{
		System.out.println("Digite o nome: ");
		cliente1.nome = scanner.nextLine();
		System.out.println("Digite o sobrenome: ");
		cliente1.sobrenome = scanner.nextLine();
		System.out.println("Digite o seu cpf: ");
		cliente1.cpf= scanner.nextLine();
		return cliente1;
	}
	
	
	}
