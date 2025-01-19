package com.application;

import java.util.Scanner;

import com.entity.Hospital_Management;

public class MainApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hospital_Management h = new Hospital_Management();
		 boolean start = true;
		 while(start) {
			 System.out.println();
			
			 System.out.println("~~~~~~~~~~~~~~~~:( HOSPITAL MANAGEMENT SYSTEM ):~~~~~~~~~~~~~~~~~~~");
			 System.out.println();
			 System.out.println("1)  Add Patient      ");
			 System.out.println();
			 System.out.println("2)  View All Patients   ");
			 System.out.println();
			 System.out.println("3)  View Single Patients  ");
			 System.out.println();
			 System.out.println("4)  Update Patients");
			 System.out.println();
			 System.out.println("5)  Delete Patients");
			 System.out.println();
			 System.out.println("6)  Add Doctors");
			 System.out.println();
			 System.out.println("7)  View All Doctors");
			 System.out.println();
			 System.out.println("8)  View Single Doctor");
			 System.out.println();
			 System.out.println("9)  Update Doctor");
			 System.out.println();
			 System.out.println("10) delete Doctor");
			 System.out.println();
			 System.out.println("11) View All Appointment");
			 System.out.println();
			 System.out.println("12) Create Appointment");
			 System.out.println();
			 System.out.println("13) Update Appointment");
			 System.out.println();
			 System.out.println("14) Delete Appintmant");
			 System.out.println();
			 System.out.println("15) Exit..");
			 System.out.println();
			 System.out.println("Enter your choice : ");
			 System.out.println();
//			 System.out.println();
			 int choice = sc.nextInt();
			 
			 switch(choice) {
			 
			 case 1:
				 h.addPatient();
				 break;
			 case 2:
				 h.ViewAllPatients();
				 break;
			 case 3:
				 h.ViewSinglePatient();
				 break;
			 case 4:
				 h.updatePatient();
				 break;
			 case 5:
				 h.deletePatient();
				 break;
			 case 6:
				 h.addDoctor();
				 break;
			 case 7:
				 h.viewAllDoctors();
				 break;
			 case 8 :
				 h.ViewSingleDoctor();
				 break;
			 case 9:
				 h.updateDoctor();
				 break;
			 case 10 :
				 h.deleteDoctor();
				 
			 case 11:
				 h.viewAllAppoitments();
				 break;
			 case 12:
				 h.createAppoitment();
				 break;
			 case 13 :
				 h.updateAppoitment();
				 break;
			 case 14 : 
				 h.deleteAppointment();
				 break;
			 case 15: 
				 start = false;
				 System.out.println("Thank you for your Time........");
				
			 
			 
			 
			 }
		
		 
		}
		 
		 
}
	 
	
	

}
