import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {

	public static void main(String[] args) {
		String[] nombres= {"Daniel","Pablo","Juan","Juana","Antonio","Reyes","Pedro","Manuel","David","Elena","Ramon","Esmeralda","Miguel","Lucas","James","Johnny","Ricardo"
				,"Manuela","Ana","Angela","Eva","Roman","Flavio","Andrea","Robin","Andres","Javier","Ivan","Leire","Leia","Luca","Eduardo","Rafael","Alejandro",
				"Marina","Maria","Carmen","Noelia","Noelle","Sakura","Carolina","Lourdes","Rocio","Cristian","Cristina"};
		String[] apellidos= {"Llamas","Ruiz","Garcia","Nadal","Abascal","Rajoy","Zapatero","Bellucci","Kennedy","Varillas","Tabilo","Alcaraz","Struff","Haruno","Yamanako",
				"Rodriguez","Cobolli","Erhard","Hardt","Machis","Roquemesa","Santamaria","Castillo","Romero","De Gea","Romanoff","Stark","Napolitano","Lincoln","Trump",
				"Vaquero","Beraknis","Mbappe","Zapata","Miralles","Baena","Carballes","Zverev","Putin","Medvedev","Biden","Rublev","Monedero","Iglesias","Ayuso","Fernandez"
		};
		int [] edades= {18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		List<String> dni= new ArrayList<String>();
		for(int i=0;i<100;i++) {
			Random rand= new Random();
			int r1=rand.nextInt(nombres.length),r2=rand.nextInt(apellidos.length),r3=rand.nextInt(apellidos.length),r4=rand.nextInt(edades.length);
			String R=generarDNINumerico();
			dni.add(R);
			System.out.println("insert into alumno values ('"+R+"','"+nombres[r1]+"','"+apellidos[r2]+" "+apellidos[r3]+"',"+edades[r4]+");");
		}
		matricula(dni);

	}
	public static void matricula(List<String> p) {
		String[] ciclo= {"DAM","PD","EI","IS","MC"};
		String[] pdam= {"SIN","BD","PRO","LM","ED","FOL"};
		String[] sdam={"AD","DI","PM","PSP","SGE","EIE","PFG","PE"};
		String[] ppd={"LPD","PPR","DFP","PC","AOF","FOL"};
		String[] spd={"RRE","PSI","REM","EIE","PFG","PE"};
		String[] pei={"DEI","AUT","EYC","DCM","DS","FOL"};
		String[] sei={"HS","INT","PAU","JIM","EIE","PFG","PE"};
		String[] pis={"CIS","ISL","AUC","PAP","MIS","FOL"};
		String[] sis={"MC","AIE","SDC","PAU","HS","EIE","PFG","PE"};
		String[] pmc={"MIS","SCP","ISP","CMC","LS","IPD","FOL"};
		String[] smc={"AAL","TIC","SAC","HS","PAU","EIE","PFG","PE"};
		LocalDate startDate = LocalDate.of(2018, 4, 1); // Start date
        LocalDate endDate = LocalDate.of(2023, 9, 1); // End date
        Date d1 = generateRandomSQLDate(startDate, endDate);
        Date d2 = generateRandomSQLDate(startDate, endDate);
        Date d3 = generateRandomSQLDate(startDate, endDate);
        Date d4 = generateRandomSQLDate(startDate, endDate);
        Date d5 = generateRandomSQLDate(startDate, endDate);
        Date d6 = generateRandomSQLDate(startDate, endDate);
        Date d7 = generateRandomSQLDate(startDate, endDate);
        Date d8 = generateRandomSQLDate(startDate, endDate);
        Date d9 = generateRandomSQLDate(startDate, endDate);
        Date d10 = generateRandomSQLDate(startDate, endDate);
        List<matricula> datos= new ArrayList<matricula>();
        for(int i=0;i<10;i++) {
        	for(int j=0;j<pdam.length;j++) {
        	System.out.println("insert into matricula values ('"+p.get(i)+"','"+ciclo[0]+"','"+pdam[j]+"',"+"1,'"+d1+"');");
        	matricula m= new matricula(p.get(i),ciclo[0],pdam[j],1,d1);
        	datos.add(m);
        	}
        }
        for(int i=10;i<20;i++) {
        	for(int j=0;j<sdam.length;j++) {
        	System.out.println("insert into matricula values ('"+p.get(i)+"','"+ciclo[0]+"','"+sdam[j]+"',"+"2,'"+d2+"');");
        	matricula m= new matricula(p.get(i),ciclo[0],sdam[j],2,d2);
        	datos.add(m);
        	}
        }
        for(int i=20;i<30;i++) {
        	for(int j=0;j<ppd.length;j++) {
        	System.out.println("insert into matricula values ('"+p.get(i)+"','"+ciclo[1]+"','"+ppd[j]+"',"+"1,'"+d3+"');");
        	matricula m= new matricula(p.get(i),ciclo[1],ppd[j],1,d3);
        	datos.add(m);
        	}
        }
        for(int i=30;i<40;i++) {
        	for(int j=0;j<spd.length;j++) {
        	System.out.println("insert into matricula values ('"+p.get(i)+"','"+ciclo[1]+"','"+spd[j]+"',"+"2,'"+d4+"');");
        	matricula m= new matricula(p.get(i),ciclo[1],spd[j],2,d4);
        	datos.add(m);
        	}
        }
        for(int i=40;i<50;i++) {
        	for(int j=0;j<pei.length;j++) {
        	System.out.println("insert into matricula values ('"+p.get(i)+"','"+ciclo[2]+"','"+pei[j]+"',"+"1,'"+d5+"');");
        	matricula m= new matricula(p.get(i),ciclo[2],pei[j],1,d5);
        	datos.add(m);
        	}
        }
        for(int i=50;i<60;i++) {
        	for(int j=0;j<sei.length;j++) {
        	System.out.println("insert into matricula values ('"+p.get(i)+"','"+ciclo[2]+"','"+sei[j]+"',"+"2,'"+d6+"');");
        	matricula m= new matricula(p.get(i),ciclo[2],sei[j],2,d6);
        	datos.add(m);
        	}
        }
        for(int i=60;i<70;i++) {
        	for(int j=0;j<pis.length;j++) {
        	System.out.println("insert into matricula values ('"+p.get(i)+"','"+ciclo[3]+"','"+pis[j]+"',"+"1,'"+d7+"');");
        	matricula m= new matricula(p.get(i),ciclo[3],pis[j],1,d7);
        	datos.add(m);
        	}
        }
        for(int i=70;i<80;i++) {
        	for(int j=0;j<sis.length;j++) {
        	System.out.println("insert into matricula values ('"+p.get(i)+"','"+ciclo[3]+"','"+sis[j]+"',"+"2,'"+d8+"');");
        	matricula m= new matricula(p.get(i),ciclo[3],sis[j],2,d8);
        	datos.add(m);
        	}
        }
        for(int i=80;i<90;i++) {
        	for(int j=0;j<pmc.length;j++) {
        	System.out.println("insert into matricula values ('"+p.get(i)+"','"+ciclo[4]+"','"+pmc[j]+"',"+"1,'"+d9+"');");
        	matricula m= new matricula(p.get(i),ciclo[4],pmc[j],1,d9);
        	datos.add(m);
        	}
        }
        for(int i=90;i<100;i++) {
        	for(int j=0;j<smc.length;j++) {
        	System.out.println("insert into matricula values ('"+p.get(i)+"','"+ciclo[4]+"','"+smc[j]+"',"+"2,'"+d10+"');");
        	matricula m= new matricula(p.get(i),ciclo[4],smc[j],2,d10);
        	datos.add(m);
        	}
        }
        notas(datos);
		}
	public static Date generateRandomSQLDate(LocalDate startDate, LocalDate endDate) {
        Random rand = new Random();
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        long randomEpochDay = startEpochDay + rand.nextInt((int) (endEpochDay - startEpochDay));
        LocalDate randomLocalDate = LocalDate.ofEpochDay(randomEpochDay);
        return Date.valueOf(randomLocalDate);
    }
	 public static String generarDNINumerico() {
	        Random rand = new Random();
	        int numero = rand.nextInt(99999999); // Genera un número aleatorio entre 0 y 99999999
	        String dni = String.format("%08d", numero); // Rellena con ceros a la izquierda si el número tiene menos de 8 dígitos
	        String letra = obtenerLetraDNI(numero);
	        return dni + letra;
	    }

	    public static String obtenerLetraDNI(int dniNumerico) {
	        String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
	        int indice = dniNumerico % 23;
	        return letras[indice];
	    }

	    public static void notas(List<matricula> datos) {
	    	for(int i=0; i<datos.size();i++) {
	    		DecimalFormat decimalFormat = new DecimalFormat("#.##");
	    		Random r= new Random();
	    		double ran= r.nextDouble()*10;
	    		Random r2= new Random();
	    		double ran2= r2.nextDouble()*10;
	    		double numm=Double.parseDouble(decimalFormat.format(ran)) ;
	    		double numm2=Double.parseDouble(decimalFormat.format(ran2)) ;

	    		if(datos.get(i).getModulo().equals("PFG")==false && datos.get(i).getModulo().equals("PE")==false)  {
	    			System.out.println("insert into notasBoletin values ('"+datos.get(i).getDni()+"','"+datos.get(i).getCiclo()+"','"+datos.get(i).getModulo()+"',"+null+",1,"+null+");");
	    			System.out.println("insert into nota values ('"+datos.get(i).getDni()+"','"+datos.get(i).getCiclo()+"','"+datos.get(i).getModulo()+"',"+numm+","+datos.get(i).getCurso()+",1,'"+"examen');");
		    		System.out.println("insert into nota values ('"+datos.get(i).getDni()+"','"+datos.get(i).getCiclo()+"','"+datos.get(i).getModulo()+"',"+numm2+","+datos.get(i).getCurso()+",1,'"+"practica');");
		    		
	    		}
	    		
	    	}
	    	for(int i=0; i<datos.size();i++) {
	    		DecimalFormat decimalFormat = new DecimalFormat("#.##");
	    		Random r= new Random();
	    		double ran= r.nextDouble()*10;
	    		Random r2= new Random();
	    		double ran2= r2.nextDouble()*10;
	    		double numm=Double.parseDouble(decimalFormat.format(ran)) ;
	    		double numm2=Double.parseDouble(decimalFormat.format(ran2)) ;
	    		if(datos.get(i).getModulo().equals("PFG")==false && datos.get(i).getModulo().equals("PE")==false)  {
	    			System.out.println("insert into notasBoletin values ('"+datos.get(i).getDni()+"','"+datos.get(i).getCiclo()+"','"+datos.get(i).getModulo()+"',"+null+",2,"+null+");");
	    		System.out.println("insert into nota values ('"+datos.get(i).getDni()+"','"+datos.get(i).getCiclo()+"','"+datos.get(i).getModulo()+"',"+numm+","+datos.get(i).getCurso()+",2,'"+"examen');");
	    		System.out.println("insert into nota values ('"+datos.get(i).getDni()+"','"+datos.get(i).getCiclo()+"','"+datos.get(i).getModulo()+"',"+numm2+","+datos.get(i).getCurso()+",2,'"+"practica');");
	    		
	    		}}
	    	for(int i=0; i<datos.size();i++) {
	    		DecimalFormat decimalFormat = new DecimalFormat("#.##");
	    		Random r= new Random();
	    		double ran= r.nextDouble()*10;
	    		Random r2= new Random();
	    		double ran2= r2.nextDouble()*10;
	    		double numm=Double.parseDouble(decimalFormat.format(ran)) ;
	    		double numm2=Double.parseDouble(decimalFormat.format(ran2)) ;
	    		if(datos.get(i).getModulo().equals("PFG")==false && datos.get(i).getModulo().equals("PE")==false && datos.get(i).getCurso()==1) {
	    			System.out.println("insert into notasBoletin values ('"+datos.get(i).getDni()+"','"+datos.get(i).getCiclo()+"','"+datos.get(i).getModulo()+"',"+null+",3,"+null+");");
	    		System.out.println("insert into nota values ('"+datos.get(i).getDni()+"','"+datos.get(i).getCiclo()+"','"+datos.get(i).getModulo()+"',"+numm+","+datos.get(i).getCurso()+",3,'"+"examen');");
	    		System.out.println("insert into nota values ('"+datos.get(i).getDni()+"','"+datos.get(i).getCiclo()+"','"+datos.get(i).getModulo()+"',"+numm2+","+datos.get(i).getCurso()+",3,'"+"practica');");
	    		
	    	}}
	    }
}
