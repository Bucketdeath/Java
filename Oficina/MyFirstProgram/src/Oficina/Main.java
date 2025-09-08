package Oficina;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Enum;
import java.nio.file.Files;

public class Main {
private static Scanner x;	
public static void main (String []args) { 
	 System.out.println("\nBem vindo \n   a \nOficina do Jailson");
	 
	 Scanner input = new Scanner(System.in);
	 
	 int escolha = 0;
	 do {
		 System.out.println("\nDigite 1 para Fazer login\nDigite 0 pra sair");
		 escolha = Integer.parseInt(input.nextLine());
		 switch(escolha) {
		     case 1:
		    	 System.out.println("Digite seu nome:");
		    	 String nome = input.nextLine();
		    	 System.out.println("Digite sua senha:");
		    	 String senha = input.nextLine();
		    	 login(nome, senha);
		    	 break;
		     case 0:
		    	 System.out.println("\nPrograma encerrado");
		    	 break;
		    default:
		    	System.out.println("Op��o Inv�lida");
		 } 
	 } while(escolha != 0 && escolha !=1);
	 
  }	  

public static void login(String nome, String senha) {
	File dir = new File("C:\\projeto oficina");
	File arq = new File(dir, "funcionarios.txt");
	
	try {
		FileReader fileReader = new FileReader(arq);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String linha = "";
		
		List <String> result =  new ArrayList<String>();
		
		while((linha = bufferedReader.readLine()) !=null) {
			if (linha != null && !linha.isEmpty()){
			   result.add(linha);
			}
		}
		fileReader.close();
		bufferedReader.close();
		
		for (String i : result) {
			
			String[] funcionario = i.split(";");
			
			if (funcionario[0].equals(nome) && funcionario[2].equals(senha)) {
				switch(funcionario[3]) {
				    case "1":
				    	Gerente gerente = new Gerente(funcionario[0], funcionario[1], funcionario[2], funcionario[3]);
				    	telaGerente(gerente);
				    	break;
				    case "2":
				    	Mecanico mecanico =  new Mecanico(funcionario[0], funcionario[1], funcionario[2], funcionario[3]);
				    	telaMecanico(mecanico);
				    	break;
				    case "3":
				    	Recepcionista recepcionista =  new Recepcionista(funcionario[0], funcionario[1], funcionario[2], funcionario[3]);
				    	telaRecepcionista(recepcionista);
				    	break;
				   default:
					   System.out.println("\nNome ou senha incorreta, tente novamente");
				}
			}
			
		}
	}catch(IOException e ) {
		e.printStackTrace();
	}
	
	
}

public static void menuPrincipalGerente() throws IOException {
	  Scanner input = new Scanner(System.in);
	  boolean escolhamenu1 = false;
	  int escolhamenu = 0;
	  System.out.println();
	  do {
	   System.out.println("        Gerente");	 
	   System.out.println("escolha a op��o que deseja\n");
	   System.out.println("1- Gerenciar Funcion�rio\n2- Ver ordem de servi�o\n3- Visualizar Clientes");
	   escolhamenu = Integer.parseInt(input.nextLine());
	   switch(escolhamenu) {
	         case 1:
	        	 respostamenucase1gerente();
	        	 break;
	         case 2:
	        	 respostamenucase2gerente();
	        	 break;
	         case 3:
	        	 respostacase3gerente();
	        	 break;
	         default:
	        	 System.out.println("Op��o Inv�lida");
	   }
		  
	
	  }while(escolhamenu1 == false); 
	  
  } 
  
private static void respostamenucase1gerente() throws IOException {
	
	Scanner input = new Scanner(System.in);
	
	System.out.println("Funcionarios cadastrados abaixo:\n");
	listFuncionarios();
	            
	int escolhamenu2  = 0;
	  		  
	           do {
	          	System.out.println("\n   Gerente menu2");  
	  	        System.out.println("Escolha uma op��o");
	   	        System.out.println("1- Adicionar Funcion�rio \n2- Editar Funcion�rio \n3- Deletar Funcion�rio");
	   	        escolhamenu2 = Integer.parseInt(input.nextLine());
	   	        switch(escolhamenu2) {
	   	          case 1:
	   	        	  
	   	    	    System.out.println("Digite o nome:");
	   	    	    String nome = input.nextLine();
	   	    	    System.out.println("Digite a senha");
	   	    	    String senha = input.nextLine();
	   	    	    System.out.println("Cargos disponiveis: \n1- Gerente\n2- Mecanico\n3- Recepcionista");
	   	    	    System.out.println("Digite o numero do Cargo do Funcion�rio: ");
	   	    	    String cargo = input.nextLine();
	   	    	    switch(cargo) {
	   	    	      case "1":
	   	    		     String id ="1";
	   	    		     String temp;
	   	    		     temp = cargo;
	   	    		     cargo = id;
	   	    		     break;
	   	    	      case "2":
	   	    		     String id2 = "2";
	   	    		     String temp2;
	   	    		     temp2 = cargo;
	   	    		     cargo = id2;		
	   	    		     break;
	   	    	     case "3":
	   	    		     String id3 = "3";
	   	    		     String temp3;
	   	    		     temp3 = cargo;
	   	    		     cargo = id3;
	   	    		     break;
	   	    	   }
	   	    	    
	   	    	   System.out.println("Digite o CPF:");
	   	    	   String cpf = input.nextLine();
	   	    	 
	   	    	   gcadastro(nome,cpf,senha,cargo);
	   	    	   break;
	   	          case 2:
	   	        	  String filepath = "funcionarios.txt";
	   	     	      
	   	        	  System.out.println("Funcion�rios Disponiveis abaixo:\n");
	   	        	  listFuncionarios();
	   	        	  System.out.println("\nDigite o nome do Funcion�rio que deseja editar:");
	   	        	  String editafnome = input.nextLine();
	   	        	  
	   	        	  System.out.println("Digite o novo nome:");
	   	        	  String novoNome = input.nextLine();
	   	        	  System.out.println("Digite o novo cpf:");
	   	        	  String novoCpf = input.nextLine();
	   	        	  System.out.println("Digite a nova senha:");
	   	              String novaSenha = input.nextLine();
	   	              System.out.println("Digite o novo id de 1 a 3:");
	   	              String novoId = input.nextLine();
	   	        	  
	   	        	  editarFuncion�rio(filepath, editafnome, novoNome, novoCpf, novaSenha, novoId);
	   	        	  break;
	   	          case 3:
	   	        	  System.out.println("Funcion�rios Disponiveis abaixo:\n");
	   	        	  listFuncionarios();
	   	        	  System.out.println("\nDigite o nome do Funcion�rio que deseja remover:");
	   	        	  String removefnome = input.nextLine();
	   	        	  
					  removerFuncion�rio(removefnome);
	   	        	  break;
	   	           default:
	   	    	  
	   	    	    System.out.println("Op��o Inv�lida\n");
	   	    	    
	   	      }
	  	 
	              
	  }while(escolhamenu2 !=1 && escolhamenu2 !=2 && escolhamenu2 != 3);
	
  }

private static void respostamenucase2gerente() throws IOException {
	
	      Scanner input = new Scanner (System.in);
	
		  System.out.println("Lista Ordem de Servi�o abaixo:\n");
		  listOrdemdeServi�o();
		  System.out.println();
		  
		  
		  int escolhamenu2 = 0;
		  do {
		  System.out.println("\n   Gerente menu2");
		  System.out.println("Ordem de Servi�o");
		  System.out.println("Escolha uma op��o");
		  System.out.println("\n1- Deletar\n2- Concluir\n3- Ver Concluidas\n4- Ver Ativas");
		  escolhamenu2 = Integer.parseInt(input.nextLine());
		  switch(escolhamenu2) {
		       case 1:
		    	   
		    	   System.out.println("Lista ordem de Servi�o abaixo\n");
		    	   listOrdemdeServi�o();
		    	   System.out.println();
		    	   System.out.println("Digite o ID da Ordem de Servi�o que deseja deletar");
		    	   String idOrdemDelete = input.nextLine();
		    	   removerOrdemdeServi�o(idOrdemDelete);
		    	   break;
		       case 2:
		    	   System.out.println("Lista ordem de Servi�o abaixo\n");
		    	   listOrdemdeServi�o();
		    	   System.out.println();
		    	   System.out.println("Digite o ID da Ordem de Servi�o que deseja concluir");
		    	   String idOrdemConcluir = input.nextLine();
		    	   concluirOrdemdeServi�o(idOrdemConcluir);
		    	   break;
		       case 3:
		    	   System.out.println("Lista  Ordem de Servi�os Concluidas abaixo\n");
		    	   listConluidaOrdemDeServi�o();
		    	   break;
		       case 4:
		    	   System.out.println("Lista Ordem de Servi�os ativas abaixo\n");
		    	   listOrdemdeServi�o();
		    	   break;
		       default:
		    	   System.out.println("Op��o Inv�lida");
		    	    
		  }
		  
	  }while(escolhamenu2 != 1 && escolhamenu2 !=2 && escolhamenu2 !=3 && escolhamenu2 !=4); 
	}

private static void respostacase3gerente() throws IOException {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Lista de Clientes abaixo:\n");
	listClientes();
	System.out.println();
	int escolha = 0;
	do {
		System.out.println("     Gerente  ");
		System.out.println("visualizar Clientes\n");
		System.out.println("op��o");
		System.out.println("1- Deletar Cliente");
		escolha = Integer.parseInt(input.nextLine());
		switch(escolha) {
		     case 1:
		    	 System.out.println("Lista de Clientes abaixo:\n");
		    	 listClientes();
		    	 System.out.println();
		    	 System.out.println("Digite o ID do Cliente que deseja deletar");
		    	 String idDelete = input.nextLine();
		    	 removerCliente(idDelete);
		}
		
	}while(escolha != 1);
	
	
}

private static void removerCliente(String idDelete) throws IOException {
	File dir = new File("C:\\projeto oficina");
	File arq = new File(dir, "Clientes.txt");
	
	File temp = File.createTempFile("Clientes", ".txt", arq.getParentFile());
	String linha;
	String[]lineArr;
	ArrayList <String> tempArray = new ArrayList <String>();
	
	try {
		try(BufferedReader br =  new BufferedReader(new InputStreamReader(new FileInputStream(arq)))){
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp)));
			
			while((linha = br.readLine()) != null) {
				  lineArr = linha.split(";");
				if(!(lineArr[0].equals(idDelete))) {
					pw.println(linha);
				}
			}
			pw.flush();
			pw.close();
			br.close();
			
			arq.delete();
			temp.renameTo(arq);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	System.out.println("Lista de Clientes Abaixo:\n");
	listClientes();
	System.out.println();
	
	
}

public static void listConluidaOrdemDeServi�o() {
	File dir = new File ("C:\\projeto oficina");
	File arq = new File (dir, "Ordem de Servi�os Concluidas.txt");
	  
	  try {
		FileReader fileReader = new FileReader(arq);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String linha = "";
		List <String> result =  new ArrayList<String>();
		
		while((linha = bufferedReader.readLine()) != null) {
			
			 if(linha != null && !linha.isEmpty()) {
				 result.add(linha);
			 }
				 
		}
		fileReader.close();
        bufferedReader.close();
        
        for(String i : result) {
        	String [] ordemConcluida = i.split(";");
        	
        	System.out.print("ID" + ordemConcluida[0] + "; ");
        	System.out.print("CPF Cliente: " + ordemConcluida[1] + "; ");
        	System.out.print("CPF Mec�nico: " + ordemConcluida[2] + "; ");
        	System.out.print("Valor R$: " + ordemConcluida[3] + "; ");
        	System.out.println("Servi�o: " + ordemConcluida[4]);
        }
	  
	  
	  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  
} 

private static void concluirOrdemdeServi�o(String idOrdemConcluir) throws IOException {
	File dir = new File("C:\\projeto oficina");
	  File arqOriginal = new File(dir, "Ordem de Servi�o.txt");
	  File temp = File.createTempFile("Ordem de Servi�o", ".txt", arqOriginal.getParentFile());
	  File novoArqCopia = new File(dir, "Ordem de Servi�os Concluidas.txt");
	  ArrayList <String> tempArray = new ArrayList <String>();
	
	  try {
		  FileReader fr = new FileReader(arqOriginal);
		  BufferedReader br = new BufferedReader(fr);
		  String linha = "";
		  String[] lineArr;
		  
		  while((linha = br.readLine())!=null) {
			   lineArr = linha.split(";");
			   if(lineArr[0].equals(idOrdemConcluir)) {
				   tempArray.add(linha);
			   }
		  }
		  fr.close();
		  br.close();
		  
		  try{
			  
			  BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(arqOriginal)));
			  PrintWriter  pw2 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(novoArqCopia)));
			  String linha2 = "";
			  String[] lineArr2;
			  while((linha2 = br2.readLine())!=null) {
				  lineArr2 = linha2.split(";");
				  if(!(lineArr2[0].equals(idOrdemConcluir))) {
					  pw2.println(linha2);
				  }
			  }
			  pw2.flush();
			  pw2.close();
			  br2.close();
			  
			  arqOriginal.delete();
			  temp.renameTo(arqOriginal);
			  
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  
		    
	  }catch(Exception e) {
		  System.out.println("Error");
	  }
	
	System.out.println("Lista Ordem de Servi�o");
	listOrdemdeServi�o();
	System.out.println();
}

private static void removerOrdemdeServi�o(String idOrdemDelete) throws IOException {
	File dir = new File("C:\\projeto oficina");
	File arq =  new File(dir, "Ordem de Servi�o.txt");
	
	File temp = File.createTempFile("Ordem de Servi�o", ".txt", arq.getParentFile());
	String linha = "";
	String[] lineArr;
	ArrayList <String> tempArray = new ArrayList <String>();
	
	try {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arq)))){
		     PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp)));
		     
		     while((linha = br.readLine())!=null) {
		    	 lineArr = linha.split(";");
		    	 if(!(lineArr[0].equalsIgnoreCase(idOrdemDelete))) {
		    		 tempArray.add(linha);
		    	 }
		     }
		     pw.flush();
		     pw.close();
		     br.close();
		     
		     
		     arq.delete();
		     temp.renameTo(arq);
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}catch(Exception e) {
		e.printStackTrace();
	}
	System.out.println("Lista Ordem de Servi�o");
	listOrdemdeServi�o();
	System.out.println();
	
}

private static void removerFuncion�rio(String removefnome) throws IOException  {
	
	File dir = new File ("C:\\projeto oficina");
	File arq = new File(dir, "funcionarios.txt");
	
	File temp = File.createTempFile("funcionario", ".txt", arq.getParentFile());
	String linha;
	String[] lineArr;
	ArrayList <String> tempArray = new ArrayList <String>();
	
	try {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arq)))){
		     PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp)));
		     
		     while((linha = br.readLine())!=null) {
		    	 lineArr = linha.split(";");
		    	 if(!(lineArr[0].equalsIgnoreCase(removefnome))) {
		    		 pw.println(linha);
		    	 }
		     }
		     pw.flush();
		     pw.close();
		     br.close();
		     
		     
		     arq.delete();
		     temp.renameTo(arq);
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}catch(Exception e) {
		e.printStackTrace();
	}
	System.out.println("Lista dos funcion�rios\\n");
	listFuncionarios();
	System.out.println();
}

private static void editarFuncion�rio(String filepath, String editafnome, String novoNome, String novoCpf, String novaSenha, String novoId) {
	File dir = new File("C:\\projeto oficina");
	File arq = new File(dir, "funcionarios.txt");
	ArrayList <String> tempArray = new ArrayList <String>();
	
	try {
		 try(FileReader fr = new FileReader(arq)){
			BufferedReader br =  new BufferedReader(fr);
			String linha;
			String[] lineArr;
			
			while((linha = br.readLine())!=null) {
				lineArr = linha.split(";");
				if(lineArr[0].equals(editafnome)) {
					tempArray.add(
							novoNome + ";" +
						    novoCpf + ";" + 
						    novaSenha + ";" +
						    novoId);
				
				}else {
					tempArray.add(linha);
				}           
			}
			fr.close();
			br.close();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}catch(Exception e) {
		System.out.println("error");
	}
	try {
		 PrintWriter pw = new PrintWriter(arq);
		 for(String i : tempArray) {
				pw.println(i);
			}
			pw.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	System.out.println("Lista dos funcion�rios\n");
	listFuncionarios();
	System.out.println();
}

public static void telaGerente(Gerente gerente) throws IOException {
	  menuPrincipalGerente();
	  	
 }

public static void gcadastro(String nome, String cpf, String senha, String cargo) {
	  File dir = new File("C:\\projeto oficina");
	  File arq = new File(dir, "funcionarios.txt");
	  
	  
	  
	  try {
			FileReader fileReader = new FileReader(arq);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";
			
			List <String> result =  new ArrayList<String>();
			
			while((linha = bufferedReader.readLine()) !=null) {
				if (linha != null && !linha.isEmpty()){
				   result.add(linha);
				   
				}
			}
			fileReader.close();
			bufferedReader.close();
            
			FileWriter fileWriter = new FileWriter(arq);
			PrintWriter printWriter =  new PrintWriter(fileWriter);
			Funcionario ff = new Funcionario();
            for(String i : result){
        	  
   	          String [] funcionario = i.split(";");
   	        
   	          printWriter.print(funcionario[0] + ";");
   	          printWriter.print(funcionario[1] + ";");
   	          printWriter.print(funcionario[2] + ";");
   	          printWriter.println(funcionario[3]);
            }
            printWriter.print(nome + ";");
            printWriter.print(cpf + ";");
            printWriter.print(senha + ";");
            printWriter.println(cargo);
            
            
            
            
            printWriter.flush();
            printWriter.close();
            
           
            System.out.println("Funcionarios cadastrados abaixo:\n");
            listFuncionarios();
            System.out.println();
            
            
   }catch(IOException e) {
  	 e.printStackTrace();
   }
   
   
  }

public static void listFuncionarios() {
	  File dir = new File ("C:\\projeto oficina");
	  File arq = new File (dir, "funcionarios.txt");
	  
	  try {
		FileReader fileReader = new FileReader(arq);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String linha = "";
		List <String> result =  new ArrayList<String>();
		
		while((linha = bufferedReader.readLine()) != null) {
			
			 if(linha != null && !linha.isEmpty()) {
				 result.add(linha);
			 }
				 
		}
		fileReader.close();
        bufferedReader.close();
        for(String i : result) {
        	String[] funcionario = i.split(";");
        	
        	
        	if(funcionario[3].equals("1")) {
           	 
            	System.out.print("cargo=Gerente;"+"nome="+funcionario[0]+";");
            	System.out.print("cpf="+funcionario[1]+";");
            	System.out.print("senha="+funcionario[2]+";");
            	System.out.println("id="+funcionario[3]);
            }
        	else if (funcionario[3].equals("2")) {
        		
            	System.out.print("cargo=Mecanico;"+"nome="+funcionario[0]+";");
            	System.out.print("cpf="+funcionario[1]+";");
            	System.out.print("senha="+funcionario[2]+";");
            	System.out.println("id="+funcionario[3]);
        	}
        	else {
        		
            	System.out.print("cargo=Recepcionista;"+"nome="+funcionario[0]+";");
            	System.out.print("cpf="+funcionario[1]+";");
            	System.out.print("senha="+funcionario[2]+";");
            	System.out.println("id=" + funcionario[3]);
        	}
        	
    }
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }

public static void telaMecanico(Mecanico mecanico) {
	  menuPrincipalMecanico();
}

public static void menuPrincipalMecanico() {
	  Scanner input = new Scanner (System.in);
	  boolean escolha1 = false;
	  int escolha = 0;
	  do {
	  System.out.println();
	  System.out.println("       Mecanico");
	  System.out.println("escolha a op��o desejada:\n");
	  System.out.println("1- Cadastrar Or�amento\n2- Visualizar Ordem de servi�o");
	  escolha = Integer.parseInt(input.nextLine());
	  switch(escolha) {
	       case 1:
	    	   respostacase1Mecanico();
	    	   break;
	       case 2:
	    	   respostacase2Mecanico();
	    	   break;
	    	default:
	    		System.out.println("Op��o Inv�lida");
	    		
	    	   
	  }
	}while(escolha1 == false);
}

public static void respostacase1Mecanico() {
	
	Scanner input = new Scanner(System.in);
	
    
    	   System.out.println("Lista de Or�amento abaixo\n");
    	   listOr�amento();
    	   int escolhamenuMec = 0;
    	   do {
    		     System.out.println("       Mec�nico");
    		     System.out.println("Cadastro de Or�amentos");
		    	 System.out.println("Escolha uma op��o\n");
		    	 System.out.println("1- Adicionar\n2- Editar");
		    	 escolhamenuMec = Integer.parseInt(input.nextLine());
		    	 switch(escolhamenuMec) {
		    	     case 1:
		    	    	 System.out.println("Digite o id de fila (ordem de chegada):");
		    	    	 String idO = input.nextLine();
		    	    	 listClientes();
		    	    	 System.out.println("CPF dos Clientes acima");
		    	    	 System.out.println("\nDigite o CPF do Cliente:");
		    	    	 String cpfClienteO = input.nextLine();
		    	    	 System.out.println("\nDigite o CPF do Mec�nico");
		    	    	 String cpfMecanicoO = input.nextLine();
		    	    	 System.out.println("Digite o Valor R$:");
		    	    	 String valor = input.nextLine();
		    	    	 System.out.println("Digite o Servi�o a ser realizado");
		    	    	 String servico = input.nextLine();
		    	    	 cadastroOr�amento(idO, cpfClienteO, cpfMecanicoO, valor, servico);
		    	    	 break;
		    	     case 2:
		    	    	 System.out.println("Digite o id do Or�amento que deseja editar");
		    	    	 String idEditO = input.nextLine();
		    	    	 System.out.println();
		    	    	 System.out.println("Digite o novo id");
		    	    	 String novoIdO = input.nextLine();
		    	    	 System.out.println("CPF disponiveis de Clientes abaixo");
		    	    	 listClientes();
		    	    	 System.out.println("\nDigite o novo CPF do Cliente");
		    	    	 String novoCpfClienteO = input.nextLine();
		    	    	 System.out.println();
		    	    	 System.out.println("Digite o novo CPF do Mec�nico:");
		    	    	 String novoCpfMecO = input.nextLine();
		    	    	 System.out.println("Digite o novo Valor R$:");
		    	    	 String novoValorO = input.nextLine();
		    	    	 System.out.println("Digite o novo Servi�o a ser realizado");
		    	    	 String novoServicoO = input.nextLine();
		    	    	 editarOr�amento(idEditO, novoIdO, novoCpfClienteO, novoCpfMecO, novoValorO, novoServicoO);
		    	    	 break;
		    	     default:
			   	    	 System.out.println("Op��o Inv�lida\n");	 
		    	 }
		    	 
    		   
    		   
    	   }while(escolhamenuMec != 1 && escolhamenuMec != 2);
    }

public static void respostacase2Mecanico() {
	Scanner input = new Scanner(System.in);
	
	   int escolhamenu2 = 0;
	   do {
	   System.out.println("     Mec�nico");
	   System.out.println("escolha a op�ao desejada:\n");
	   System.out.println("1- Ver Ordens de Servi�o Comcluidas\n2- Ver Ordens de Servi�o Ativas");
	   escolhamenu2 = Integer.parseInt(input.nextLine());
	   switch(escolhamenu2) {
	        case 1:
	        	System.out.println("Lista Ordem de Servi�o Concluidas abaixo:\n");
	        	listConluidaOrdemDeServi�o();
	        	System.out.println();
	        	break;
	        case 2:
	        	System.out.println("Lista Ordem de Servi�o Ativa abaixo:\n");
	        	listOrdemdeServi�o();
	        	System.out.println();
	        	break;
	        default:
	        	System.out.println("Op��o Inv�lida");
	   
		
	}
	
   }while(escolhamenu2 !=1 && escolhamenu2 !=2);
	
}

private static void editarOr�amento(String idEditO, String novoIdO, String novoCpfClienteO, String novoCpfMecO,
		String novoValorO, String novoServicoO) {
	   File dir = new File("C:\\projeto oficina");
	   File arq = new File (dir, "Or�amento.txt");
	   ArrayList<String> tempArray = new ArrayList <String>();
	   
	   try {
		   try(FileReader fr = new FileReader(arq)) {
			   BufferedReader br = new BufferedReader(fr);
			   String linha;
			   String [] lineArr;
			   
			   while((linha = br.readLine())!= null) {
				   lineArr = linha.split(";");
				   if(lineArr[0].equals(idEditO)) {
					   tempArray.add(
							        novoIdO + ";"+ 
					                novoCpfClienteO + ";" + 
							        novoCpfMecO + ";" + 
					                novoValorO + ";" + 
							        novoServicoO);
				   }else {
					   tempArray.add(linha);
				   }
			   }
			   fr.close();
			   br.close();
			   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   
	   }catch(Exception e){
		   System.out.println("error");
	   }
	   try {
		   PrintWriter pw = new PrintWriter(arq);
		   for(String i : tempArray) {
			   pw.println(i);
		   }
		   pw.flush();
		   pw.close();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   System.out.println("Lista dos Ora�amentos\n");
	   listOr�amento();
	   System.out.println();
}


private static void cadastroOr�amento(String idO, String cpfClienteO, String cpfMecanicoO, String valor,
		String servico) {
	  File dir = new File("C:\\projeto oficina");
	  File arq = new File(dir, "Or�amento.txt");
	  ArrayList <String> result = new ArrayList <String>();
	  
	  try {
		  try(FileReader fr = new FileReader(arq)) {
			  BufferedReader br =  new BufferedReader(fr);
			  String linha;
			  
			  while((linha = br.readLine())!=null) {
				  if(linha != null && !linha.isEmpty()) {
					  result.add(linha);
				  }
			  }
			  fr.close();
			  br.close();
			  
			  FileWriter fw = new FileWriter(arq);
			  PrintWriter pw =  new PrintWriter(fw);
			  for(String i: result) {
				  String [] orcamento = i.split(";");
				  
				  pw.print(orcamento[0] + ";");
				  pw.print(orcamento[1] + ";");
				  pw.print(orcamento[2] + ";");
				  pw.print(orcamento[3] + ";");
				  pw.println(orcamento[4]);
			  }
			  pw.print(idO + ";");
			  pw.print(cpfClienteO + ";");
			  pw.print(cpfMecanicoO + ";");
			  pw.print(valor + ";");
			  pw.println(servico);
			  
			  fw.flush();
			  pw.flush();
			  fw.close();
			  pw.close();
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  System.out.println("Or�amentos cadastrados abaixo");
	  listOr�amento();
	  System.out.println();
}

public static void listOr�amento() {
	File dir = new File("C:\\projeto oficina");
	File arq = new File(dir, "Or�amento.txt");
	ArrayList <String> result = new ArrayList <String>();
	
	try {
		FileReader fr = new FileReader(arq);
		BufferedReader br =  new BufferedReader(fr);
		String linha = "";
		
		while((linha = br.readLine())!=null) {
			if(linha!=null && !linha.isEmpty()) {
				result.add(linha);
			}
		}
		fr.close();
		br.close();
		
		for(String i : result) {
			String[] orcamento = i.split(";");
			
			System.out.print("ID:" + orcamento[0] + ";");
			System.out.print("CPF Cliente:" + orcamento[1] + ";");
			System.out.print("CPF Mec�nico:" + orcamento[2] + ";");
			System.out.print("Valor R$:" + orcamento[3] + ";");
			System.out.println("Servi�o:"+ orcamento[4]);
			
            
			
		}
			
		
	}catch (FileNotFoundException e) {
		e.printStackTrace();	
	}catch(Exception e) {
		e.printStackTrace();
	}
}	


public static void telaRecepcionista(Recepcionista recepcionista) throws IOException {
	  menuPrincipalRecepcionista();
	  
	  
  }


public static void menuPrincipalRecepcionista() throws IOException{
	  Scanner input = new Scanner (System.in);
	  boolean escolha1 = false;
	  int escolha = 0;
	  do {
	    System.out.println();
	    System.out.println("       Recepcionista");
	    System.out.println("  Escolha a op��o desejada\n");
	    System.out.println("1- Cadastrar Cliente\n2- Ver Or�amentos");
	    escolha = Integer.parseInt(input.nextLine());
	    switch(escolha) {
	         case 1:
	        	 
	        	 respostacase1Recepcionista();
	        	 
	        	 break;
	         case 2:
	        	 respostacase2Recepcionista();
	        	 break;
	         default:
	        	System.out.println("Op��o Inv�lida"); 
	    }
	    
	  
	  }while(escolha1 == false);
  }


public static void respostacase1Recepcionista() {
	    
		Scanner input = new Scanner(System.in);
		
	    
	        	System.out.println("Lista de Clientes\n");
	        	listClientes();
	        	System.out.println();
	        	int escolhamenurecep = 0;
		    	 do {
		    	 System.out.println("       Recepcionista");
		    	 System.out.println("    Cadastro de Clientes\n");
		    	 System.out.println("Escolha uma op��o\n");
		    	 System.out.println("1- Adicionar\n2- Editar");
		    	 escolhamenurecep = Integer.parseInt(input.nextLine());
		    	 switch(escolhamenurecep) {
		    	    case 1:
		    	    	System.out.println("Digite o id do Cliente (Ordem num�rica)");
		    	    	String idC = input.nextLine();
		    	    	System.out.println();
		    	    	System.out.println("Nome do Cliente:");
		    	    	String nomeC = input.nextLine();
		    	    	System.out.println("Telefone do Cliente:");
		    	    	String telefoneC = input.nextLine();
		    	    	System.out.println("CPF do Cliente:");
		    	    	String cpfC = input.nextLine();
		    	    	System.out.println("Email do Cliente:");
		    	    	String emailC = input.nextLine();
		    	    	System.out.println("Endere�o do Cliente:");
		    	    	String enderecoC = input.nextLine();
                        System.out.println("Placa do carro ou moto:");
                        String placaC = input.nextLine();
                        cadastroCliente(idC, nomeC, telefoneC, cpfC, emailC, enderecoC, placaC);
		    	    	break;
		    	    case 2:
		    	    	System.out.println("Clientes disponiveis abaixo:\n");
		    	    	listClientes();
		    	    	System.out.println();
		    	    	System.out.println("Digite o id do Cliente que deseja editar:");
		    	    	String editIdCliente = input.nextLine();
		    	    	
		    	    	System.out.println("Digite o novo Id:");
		    	    	String novoId = input.nextLine();
		    	    	System.out.println("Digite o novo Nome:");
		    	    	String novoNome = input.nextLine();
		    	    	System.out.println("Digite o novo Telefone:");
		    	    	String novoTelefone = input.nextLine();
		    	    	System.out.println("Digite o novo Cpf:");
		    	    	String novoCpf = input.nextLine();
		    	    	System.out.println("Digite o novo Email:");
		    	    	String novoEmail = input.nextLine();
		    	    	System.out.println("Digite o novo Endere�o:");
		    	    	String novoEndereco = input.nextLine();
		    	    	System.out.println("Digite a nova Placa:");
		    	    	String novaPlaca = input.nextLine();
		    	    	editarCliente(editIdCliente, novoId, novoNome, novoTelefone, novoCpf, novoEmail, novoEndereco, novaPlaca);
		    	        break;
		    	     default:
		    	        System.out.println("Op��o Invalida");	   
		    	 }
		    	 
		    	 
		     }while(escolhamenurecep !=1 && escolhamenurecep !=2);
	    }
  


public static void respostacase2Recepcionista() throws IOException {
	
	Scanner input = new Scanner(System.in);
	
    
    	  System.out.println("Lista de Or�amento\n");
    	  listOr�amento();
    	  
    	  int escolhamenu2Recep = 0;
    	  do {
                 System.out.println();    		  
     		     System.out.println("     Recepcionista");
		    	 System.out.println("    Ver Or�amentos");
		    	 System.out.println("   Escolha uma op��o\n");
		    	 System.out.println("1- Deletar  Or�amento\n2- Transformar em Ordem de Servi�o");
		    	 escolhamenu2Recep = Integer.parseInt(input.nextLine());
		    	 switch(escolhamenu2Recep) {
		    	      case 1:
		    	    	  
		    	    	  System.out.println("\nDigite o ID  do Or�amento que deseja deletar");
		    	    	  System.out.println("Lista de Or�amento abaixo:\n");
		    	    	  listOr�amento();
		    	    	  System.out.println();
		    	    	  String idDelete = input.nextLine();
		    	    	  removerOr�amento(idDelete);
		    	    	  break;
		    	      case 2:
		    	    	  
		    	    	  System.out.println("\nDigite o ID do Or�amento que deseja transforma em Ordem de Servi�o");
		    	    	  System.out.println("Lista de or�amentos abaixo\n");
		    	    	  listOr�amento();
		    	    	  System.out.println();
		    	    	  String idOTransforma = input.nextLine();
		    	    	  transformaEmOrdemDeServi�o(idOTransforma);
		    	    	  
		    	 }
    		  
    	  }while(escolhamenu2Recep != 1 && escolhamenu2Recep !=2);
    	  
    }
   
  
private static void transformaEmOrdemDeServi�o(String idOTransforma) throws IOException {
	  File dir = new File("C:\\projeto oficina");
	  File arqOriginal = new File(dir, "Or�amento.txt");
	  File temp = File.createTempFile("Or�amento", ".txt", arqOriginal.getParentFile());
	  File novoArqCopia = new File(dir, "Ordem de Servi�o.txt");
	  ArrayList <String> tempArray = new ArrayList <String>();
	
	  try {
		  FileReader fr = new FileReader(arqOriginal);
		  BufferedReader br = new BufferedReader(fr);
		  String linha = "";
		  String[] lineArr;
		  
		  while((linha = br.readLine())!=null) {
			   lineArr = linha.split(";");
			   if(lineArr[0].equals(idOTransforma)) {
				   tempArray.add(linha);
			   }
		  }
		  fr.close();
		  br.close();
		  
		  try{
			  
			  BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(arqOriginal)));
			  PrintWriter  pw2 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp)));
			  String linha2 = "";
			  String[] lineArr2;
			  while((linha2 = br2.readLine())!=null) {
				  lineArr2 = linha2.split(";");
				  if(!(lineArr2[0].equals(idOTransforma))) {
					  pw2.println(linha2);
				  }
			  }
			  pw2.flush();
			  pw2.close();
			  br2.close();
			  
			  arqOriginal.delete();
			  temp.renameTo(arqOriginal);
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  try {
			  ArrayList <String> result = new ArrayList <String>();
			  FileReader fr1 = new FileReader(novoArqCopia);
			  BufferedReader br1 = new BufferedReader(fr1);
			  String linha1 = "";
			  while((linha = br1.readLine())!=null) {
				  if(linha!=null && !linha.isEmpty()) {
					  result.add(linha1);
				  }
			  }
			  fr1.close();
			  br1.close();
			  
			  FileWriter fw = new FileWriter(novoArqCopia);
			  PrintWriter pw =  new PrintWriter(fw);
			  
			  for(String i : tempArray) {
				  String[] ordemDeServi�o = i.split(";");
				  
				  pw.print("ID:" + ordemDeServi�o[0]+ ";");
				  pw.print("CPF do Cliente:" + ordemDeServi�o[1] + ";");
				  pw.print("CPF do Mec�nico:" + ordemDeServi�o[2] + ";");
				  pw.print("Valor R$:" + ordemDeServi�o[3] + ";");
				  pw.println("Servi�os:" + ordemDeServi�o[4]);
			  }
			  pw.flush();
			  pw.close();
			  fw.close();
			
			  
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		    
	  }catch(Exception e) {
		  System.out.println("Error");
	  }
	 
}

public static void listOrdemdeServi�o() {
	File dir =  new File("C:\\projeto oficina");
	File arq =  new File(dir, "Ordem de Servi�o.txt");
    ArrayList <String> result =  new ArrayList<String>();
    
    try {
    	FileReader fr = new FileReader(arq);
    	BufferedReader br = new BufferedReader(fr);
    	String linha = "";
    	
    	while((linha =  br.readLine()) != null) {
    		if(linha!=null && !linha.isEmpty()) {
    			result.add(linha);
    		}
    	}
    	fr.close();
    	br.close();
    	
    	for(String i : result) {
    		String []ordemDeServico = i.split(";");
    		
    		System.out.print(ordemDeServico[0] + ";");
    		System.out.print(ordemDeServico[1] + ";");
    		System.out.print(ordemDeServico[2] + ";");
    		System.out.print(ordemDeServico[3] + ";");
    		System.out.println(ordemDeServico[4]);
    		
    	}
    }catch(Exception e) {
    	e.printStackTrace();
    }
	
}

private static void removerOr�amento(String idDelete) throws IOException {
	File dir = new File ("C:\\projeto oficina");
	File arq = new File(dir, "Or�amento.txt");
	
	File temp = File.createTempFile("Or�amento", ".txt", arq.getParentFile());
	String linha;
	String[] lineArr;
	ArrayList <String> tempArray = new ArrayList <String>();
	
	try {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arq)))){
		     PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp)));
		     
		     while((linha = br.readLine())!=null) {
		    	 lineArr = linha.split(";");
		    	 if(!(lineArr[0].equalsIgnoreCase(idDelete))) {
		    		 pw.println(linha);
		    	 }
		     }
		     pw.flush();
		     pw.close();
		     br.close();
		     
		     
		     arq.delete();
		     temp.renameTo(arq);
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}catch(Exception e) {
		e.printStackTrace();
	}
	System.out.println("Lista dos Or�amentos\n");
	listOr�amento();
	System.out.println();
	
}

public static void editarCliente(String editIdCliente, String novoId, String novoNome, String novoTelefone,
		String novoCpf, String novoEmail, String novoEndereco, String novaPlaca) {
	File dir = new File ("C:\\projeto oficina");
	File arq = new File(dir, "Clientes.txt");
	ArrayList <String> tempArray = new ArrayList <String>();
	
	try {
		try (FileReader fr = new FileReader(arq)){
			BufferedReader br = new BufferedReader(fr);
			String linha;
			String[] lineArr;
			
			while((linha = br.readLine())!=null) {
				lineArr = linha.split(";");
				if(lineArr[0].equals(editIdCliente)) {
					tempArray.add(
							     novoId + ";" + 
					             novoNome + ";" + 
							     novoTelefone + ";" + 
					             novoCpf + ";" + 
							     novoEmail + ";" + 
					             novoEndereco + ";" + 
							     novaPlaca);
				}else {
					tempArray.add(linha);
				}
			}
			fr.close();
			br.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}catch(Exception e) {
		System.out.println("error");
	}
	try {
		PrintWriter pw = new PrintWriter(arq);
		for(String i:tempArray) {
			pw.println(i);
			
			
		}
		pw.flush();
		pw.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
    System.out.println("Lista dos Clientes");
    listClientes();
    System.out.println();
	
}


public static void cadastroCliente(String idC, String nomeC, String telefoneC, String cpfC, String emailC,
		String enderecoC, String placaC) {
	File dir = new File("C:\\projeto oficina");
	File arq = new File(dir, "Clientes.txt");
	ArrayList <String> result = new ArrayList <String>();
	try {
		try(FileReader fr = new FileReader(arq)) {
			BufferedReader br = new BufferedReader(fr);
			String linha;
			
			while((linha = br.readLine()) !=null) {
				if(linha !=null && !linha.isEmpty()) {
					result.add(linha);
				}
			}
			fr.close();
			br.close();
			
			FileWriter fw = new FileWriter(arq);
			PrintWriter pw =  new PrintWriter(fw);
			for(String i : result) {
				String [] Cliente = i.split(";");
				
				pw.print(Cliente[0] + ";");
				pw.print(Cliente[1] + ";");
				pw.print(Cliente[2] + ";");
				pw.print(Cliente[3] + ";");
				pw.print(Cliente[4] + ";");
				pw.print(Cliente[5] + ";");
				pw.println(Cliente[6]);
			}
			pw.print(idC + ";");
			pw.print(nomeC + ";");
			pw.print(telefoneC + ";");
			pw.print(cpfC + ";");
			pw.print(emailC + ";");
			pw.print(enderecoC + ";");
			pw.println(placaC);
			
			fw.flush();
			pw.flush();
			fw.close();
			pw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	System.out.println("Clientes Disponiveis abaixo:\n");
	listClientes();
	System.out.println();
}


public static void listClientes() {
	File dir = new File("C:\\projeto oficina");
	File arq =  new File(dir, "Clientes.txt");
	ArrayList <String> result = new ArrayList <String>();
	try {
		FileReader fr = new FileReader(arq);
		BufferedReader br = new BufferedReader(fr);
		String linha="";
		
		while((linha = br.readLine()) !=null) {
			if(linha !=null && !linha.isEmpty()) {
				result.add(linha);
			}
		}
		fr.close();
		br.close();
		
		for(String i : result) {
			String [] cliente = i.split(";");
			
			System.out.print("ID: " + cliente[0] + ";");
			System.out.print("Nome: " + cliente[1] + ";");
			System.out.print("Telefone: " + cliente[2] + ";");
			System.out.print("CPF: " + cliente[3] + ";");
			System.out.print("Email: " + cliente[4] + ";");
			System.out.print("Endere�o: " + cliente[5] + ";");
			System.out.println("Placa: " + cliente[6]);
		}
		
		
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}

	

