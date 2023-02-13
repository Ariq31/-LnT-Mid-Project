import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
Scanner scan = new Scanner(System.in);
ArrayList<Employee> employeeData = new ArrayList<>();
Random random = new Random();
	public Main() {
		int menu=0;
		
		do {
			printMenu();
			menu= scan.nextInt();
			
			switch (menu) {
			case 1:
				insertEmployee();
				scan.nextLine();
				break;
			case 2:
			 viewKaryawan();
				scan.nextLine();
				break;
			case 3:
				updateKaryawan();
				scan.nextLine();
				break;
			case 4:
				deleteKaryawan();
				scan.nextLine();
				break;

			default:
				break;
			}
		} while (menu!=5);
		
	}

	public static void main(String[] args) {
		new Main();

	}
	
	void printMenu() {
	System.out.println("PT Meksiko");
	System.out.println("1. Insert data keryawan");
	System.out.println("2. View data karyawan");
	System.out.println("3. Update data karyawan");
	System.out.println("4. Delete data karyawan");
	System.out.println("5. Exit");
	
		
	}
	
	
	
	void insertEmployee() {
		String employeeName;
		String  employeeGender;
		String employeePosition;
		int employeeSalary=0;
		String ID;
		int bonus=0;
		
		do {
			System.out.println("Input nama karyawan [>=3]: ");
			employeeName = scan.nextLine(); scan.nextLine();
			
		} while (employeeName.length()<3);
		
		do {
			System.out.println("Input jenis kelamin[Laki-laki | Perempuan] (Case Sensitive): ");
			employeeGender =  scan.nextLine(); scan.nextLine();
		} while (!employeeGender.equals("Laki-laki")&&!employeeGender.equals("Perempuan"));
	
	do {
		System.out.println("Input jabatan[Manager | Supervisor | Admin] (Case Sensitive): ");
		employeePosition =  scan.nextLine(); scan.nextLine();
	} while (!employeePosition.equals("Manager")&&!employeePosition.equals("Supervisor")&&!employeePosition.equals("Admin"));
	
	if(employeePosition.equals("Manager")) {
		employeeSalary = 8000000;
		bonus=800000;
		
	}
	else if(employeePosition.equals("Supervisor")) {
		employeeSalary = 6000000;
		bonus=450000;
	}
	
	else if(employeePosition.equals("Admin")) {
		employeeSalary = 4000000;
		bonus=200000;
		
	}
	
	
	int positionCounter = 0;
    
        if (employeePosition=="Manager") {
            positionCounter+=1;
        }
        else if(employeePosition=="Supervisor") {
        	 positionCounter+=1;
        }
        else if(employeePosition=="Admin") {
        	 positionCounter+=1;
        }
    
    
    ID = kodeKaryawan();
    
	
	


	
	if (employeeData.size()<3) {
		employeeSalary+=bonus;
		employeeData.add( new Employee(employeeName,employeeGender,employeePosition,employeeSalary,ID));
		System.out.println("Berhasil menambah data karyawan dengan id "+ ID);
	}
	else {
		
		employeeData.add( new Employee(employeeName,employeeGender,employeePosition,employeeSalary,ID));	
		System.out.println("Berhasil menambah data karyawan dengan id "+ ID);
	}
	
	System.out.println("Enter to return");
	
	

	

	
	
	}
	
	
	
	

		
	
		
	
	
	String kodeKaryawan() {
		String ID;
		String mm="";
		String xxxx="";
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String number = "0123456789";
		
		
		for (int i = 0; i < 2; i++) {
		mm+=alphabet.charAt(random.nextInt(26));
		}
		
		for (int i = 0; i < 4; i++) {
			xxxx+=number.charAt(random.nextInt(9));
		}
		
		ID=mm+"-"+xxxx;
		
		return ID;
		
		
		
		
		
		
	}

	void viewKaryawan() {
if(employeeData.isEmpty()) {
	System.out.println("Tidak ada data");
}
else {
	
	for (int i = 0; i < employeeData.size(); i++) {
		for (int j = i + 1; j < employeeData.size(); j++) {
			if (employeeData.get(j).employeeName.compareTo(employeeData.get(i).employeeName) < 0) {
				Employee temp = employeeData.get(j);
				employeeData.set(j, employeeData.get(i));
				employeeData.set(i, temp);
			}
		}
	}
		System.out.printf("| %-2s | %-10s | %-35s | %-13s | %-13s |%-13s|\n", 
				"No", "ID", "Nama karyawan", "Jenis kelamin", "Jabatan","Gaji");
for (int i = 0; i < employeeData.size(); i++) {
	System.out.printf("| %-2s | %-10s | %-35s | %-13s | %-13s |%-13s|\n", 
			i+1, employeeData.get(i).ID, employeeData.get(i).employeeName, employeeData.get(i).employeeGender, employeeData.get(i).employeePosition,employeeData.get(i).employeeSalary);
}
	}
scan.nextLine();
	}
	
	void updateKaryawan() {
		String employeeName;
		String  employeeGender;
		String employeePosition;
		int employeeSalary=0;
		String UID;
		String[] name;
		int input;
		int index;
		if(employeeData.isEmpty()) {
			System.out.println("Tidak ada data");
		}
		else {
		viewKaryawan();
		System.out.println("Masukkan nomor yang ingin diganti "+"[1-"+employeeData.size()+"]");
		
		
		do {
			input = scan.nextInt();scan.nextLine();
			if (input==0) {
				break;
			}
		} while (input>employeeData.size());
		if (input!=0) {
			do {
				index=input-1;
				System.out.println("Input nama karyawan [>=3]: ");
				employeeName = scan.nextLine(); scan.nextLine();
				
			} while (employeeName.length()<3);
			
			do {
				System.out.println("Input jenis kelamin: ");
				employeeGender =  scan.nextLine(); scan.nextLine();
			} while (!employeeGender.equals("Laki-laki")&&!employeeGender.equals("Perempuan"));
		
		do {
			System.out.println("Input jabatan: ");
			employeePosition =  scan.nextLine(); scan.nextLine();
		} while (!employeePosition.equals("Manager")&&!employeePosition.equals("Supervisor")&&!employeePosition.equals("Admin"));
		
		
		UID=employeeData.get(index).ID;
		if(employeePosition.equals("Manager")) {
			employeeSalary = 8000000;
			
			
		}
		else if(employeePosition.equals("Supervisor")) {
			employeeSalary = 6000000;
		}
		
		else if(employeePosition.equals("Admin")) {
			employeeSalary = 4000000;
			
		}
		
		if(employeeData.set(index, new Employee (employeeName,employeeGender,employeePosition,employeeSalary,UID)) != null) {
			System.out.println("Berhasil mengupdate karyawan dengan ID "+employeeData.get(index).ID+" berhasil dihapus");
		};
		}
		
		}
		
		scan.nextLine();
	}	
	
	void deleteKaryawan() {
		
		int input;
		int index;
		if(employeeData.isEmpty()) {
			System.out.println("Tidak ada data");
		}
		else {
		viewKaryawan();
		do {
			System.out.println("Masukkan nomor yang ingin dihapus"+"[1-"+employeeData.size()+"]");
			input = scan.nextInt(); 
			if (input==0) {
				break;	
				}
		} while (input>employeeData.size());
		
		if (input!=0) {
			index = input-1;
			
			System.out.println("Karyawan dengan kode+ "+employeeData.get(index).ID+" Berhasil dihapus");
			employeeData.remove(index);	
		}
		
	}
	scan.nextLine();	
	}
	
	}

