import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GestorBanco {
	private Cliente[] clientes;
	private Scanner sc;
	
	public GestorBanco(Cliente[] clientes) {
		this.clientes = clientes;
		this.sc=new Scanner(System.in);
	}
	
	public Cliente[] getClientes() {
		return clientes;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public void altaCliente() {
		Cliente cliente= new Cliente();
		System.out.println("Introduce el DNI del cliente");
		cliente.DNI= this.sc.nextLine();
		System.out.println("Introduce el nombre completo del cliente");
		cliente.nombreCompleto=this.sc.nextLine();
		System.out.println("Introduce la fecha de nacimiento");
		cliente.fechaNacimiento=this.sc.nextLine();
		System.out.println("Introduce el saldo");
		cliente.saldo=this.sc.nextDouble();
			this.clientes=Arrays.copyOf(this.clientes, this.clientes.length+1);
			this.clientes[this.clientes.length-1]=cliente;
			System.out.println("Cliente añadido!");
	}
	public void bajaCliente() {
		System.out.println("Introduce el DNI del cliente");
		String dni=this.sc.nextLine();
		boolean check=false;
		int index=0;
		for(int i=0;i<clientes.length;i++) {
			if(clientes[i].DNI.equals(dni)) {
				index=i;
				check=true;
			}
		}
		if(check) {
		for(int j=index;j<clientes.length-1;j++) {
			clientes[j]=clientes[j+1];
		}
		clientes=Arrays.copyOf(clientes, clientes.length-1);
		}
		else {
			System.out.println("Cliente con dicho DNI no está en la lista");
		}
	}
	public void mostrar() {
		double max=0,min=0,sum=0;
		Arrays.sort(clientes, Comparator.comparing(Cliente::getDNI));
		max=clientes[0].saldo;
		min=clientes[0].saldo;
		for(int i=0;i<clientes.length;i++) {
			System.out.println("DNI: "+clientes[i].DNI.toString());
			System.out.println("Nombre: "+clientes[i].nombreCompleto.toString());
			System.out.println("Fecha de nacimiento:"+clientes[i].fechaNacimiento.toString());
			System.out.println("Saldo:"+Double.valueOf(clientes[i].saldo).toString()+"\n");
			if(max<clientes[i].saldo) {
				max=clientes[i].saldo;
			}
			if(min>clientes[i].saldo) {
				min=clientes[i].saldo;
			}
			sum+=clientes[i].saldo;
		}
		System.out.println("\nEl saldo máximo es: "+max+"\nEl saldo mínimo es: "+min+"\nEl saldo medio es: "+(sum/clientes.length));
	}
	public void guardar(String ruta) {
		try(BufferedWriter writer= new BufferedWriter(new FileWriter(ruta))) {
			for(int i=0;i<clientes.length;i++) {
				writer.write(clientes[i].DNI.toString()+";");
				writer.write(clientes[i].nombreCompleto.toString()+";");
				writer.write(clientes[i].fechaNacimiento.toString()+";");
				writer.write(Double.valueOf(clientes[i].saldo).toString());
				writer.newLine();
				writer.flush();
				sc.close();
			}
		}catch(IOException ex) {
			System.out.println(ex.toString());
		}
}
}
