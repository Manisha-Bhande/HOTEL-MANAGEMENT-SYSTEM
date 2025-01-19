package com.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Configuration.Configuration;
import com.unimplemented.HospitalUnimpl;

public class Hospital_Management implements HospitalUnimpl{
 Scanner sc = new Scanner(System.in);
	@Override
	public void addPatient() {
		try {
//			
			
			Connection con = Configuration.Connecting();
	        PreparedStatement ps = con.prepareStatement("insert into patients (Patient_name, Patient_age, Patient_gender, Patient_contact, Patient_address) values (? , ?, ?, ?, ?)");
	        
	        // Use sc.nextLine() to read the full name
	        System.out.println("Enter The Patient Name:");
//	        sc.nextLine(); // Consume the leftover newline character
	        String n = sc.nextLine();  // Allows full names with spaces like "Ram Kumar"
	        
	        System.out.println("Enter the Patient Age:");
	        int a = sc.nextInt();
	        
	        System.out.println("Enter the Patient Gender:");
	        sc.nextLine(); // Consume the leftover newline character
	        String g = sc.nextLine();
	        
	        System.out.println("Enter the Patient Contact:");
	        String c = sc.next();
	        
	        System.out.println("Enter the Patient Address:");
	        sc.nextLine(); // Consume the leftover newline character
	        String ad = sc.nextLine();
	        
	        ps.setString(1, n);
	        ps.setInt(2, a);
	        ps.setString(3, g);
	        ps.setString(4, c);
	        ps.setString(5, ad);

	        ps.executeUpdate();
	        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	        System.out.println();
	        System.out.println("Data inserted successfully");
	        System.out.println();
	        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	        
	        ps.close();
	    	con.close();
			
			} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void ViewAllPatients() {
		
		try {
			Connection con = Configuration.Connecting();
			PreparedStatement ps = con.prepareStatement("select * from patients");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println();
				System.out.println("Patient Id       : " + rs.getString(1));
				System.out.println("Patent Name      : " + rs.getString(2));
				System.out.println("Patient Age      : " + rs.getString(3));
				System.out.println("Patient Gender   : " + rs.getString(4));
				System.out.println("Patient Contact  : " + rs.getString(5));
				System.out.println("Patient Address  : " + rs.getString(6));
				System.out.println();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println();
				
			}
			System.out.println();
			System.out.println("All Patients");
			System.out.println();
			ps.close();
			con.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void ViewSinglePatient() {
		try {
			Connection con = Configuration.Connecting();
			PreparedStatement ps = con.prepareStatement("select * from patients where Patient_name =?");
			System.out.println("Enter the Patient Name : ");
			String n = sc.nextLine();
			ps.setString(1, n);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println();
				System.out.println("Patient Id       : " + rs.getString(1));
				System.out.println("Patent Name      : " + rs.getString(2));
				System.out.println("Patient Age      : " + rs.getString(3));
				System.out.println("Patient Gender   : " + rs.getString(4));
				System.out.println("Patient Contact  : " + rs.getString(5));
				System.out.println("Patient Address  : " + rs.getString(6));
				
				System.out.println();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println();
				
				
			}
			System.out.println();
			System.out.println("Patient..........");
			System.out.println();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void updatePatient() {
		try {
			Connection con = Configuration.Connecting();
			PreparedStatement ps = con.prepareStatement("update patients set Patient_age=?,patient_gender=?,Patient_contact=?,Patient_address=? where Patient_name = ?");
			System.out.println("Enter New Patient age :");
			String a = sc.nextLine();
			System.out.println("Enter New Patient Gender :");
			String g= sc.nextLine();
			System.out.println("Enter New Patient Contact :");
			String c = sc.nextLine();
			System.out.println("Enter New Patient Address :");
			String ad = sc.nextLine();
			System.out.println("Enter the Patient Name to be Updated :");
			String n = sc.nextLine();
			ps.setString(1, a);
			ps.setString(2, g);
			ps.setString(3, c);
			ps.setString(4, ad);
			ps.setString(5, n);
			
			 int rowsAffected = ps.executeUpdate();
		        if (rowsAffected > 0) {
		        	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		        	System.out.println();
		            System.out.println("Record updated successfully.");
		            System.out.println();
		            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		            System.out.println();
		            
		        } else {
		        	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		        	System.out.println();
		            System.out.println("No record found with the given patient Name.");
		            System.out.println();
		            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		            System.out.println();
		        }
			ps.close();
			con.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deletePatient() {
		try {
			Connection con = Configuration.Connecting();
			PreparedStatement ps = con.prepareStatement("delete from patients where Patient_name =?");
			System.out.println("Enter the Patient name :");
			String n = sc.nextLine();
			ps.setString(1, n);
			int rowsAffected = ps.executeUpdate(); // Returns the number of rows affected
	        if (rowsAffected > 0) {
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	            System.out.println("Data Deleted From Hotel Database");
	            System.out.println();
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	            
	        } else {
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	            System.out.println("Room Number not found in the database.");
	            System.out.println();
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	        }
	        ps.close();
	        con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void addDoctor() {
		try {
			Connection con =Configuration.Connecting();
			PreparedStatement ps = con.prepareStatement("insert into doctors(Doctor_name,Doctor_gender,Specialization,Contact) values (?,?,?,?)");
			System.out.println("Enter the Doctor Name :");
			String n = sc.nextLine();
			System.out.println("Enter the Doctor Gender : ");
			String g = sc.nextLine();
			System.out.println("Enter the Doctor Specialization :");
			String s = sc.nextLine();
			System.out.println("Enter the Doctor Contact :");
			String c = sc.nextLine();
			
			ps.setString(1, n);
			ps.setString(2, g);
			ps.setString(3, s);
			ps.setString(4, c);
			
			ps.executeUpdate();
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Doctor data Added...");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			ps.close();
			con.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void viewAllDoctors() {
		try {
			Connection con = Configuration.Connecting();
			PreparedStatement ps = con.prepareStatement("select * from doctors");
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				System.out.println();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println();
				System.out.println("Doctor Id             : " + rs.getString(1));
				System.out.println("Doctor Name           : " + rs.getString(2));
				System.out.println("Doctor Gender         : " + rs.getString(3));
				System.out.println("Doctor Specialization : " + rs.getString(4));
				System.out.println("Doctor Contact        : " + rs.getString(5));
				System.out.println();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println();
			}
			System.out.println();
			System.out.println("All Doctors..");
			System.out.println();
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void ViewSingleDoctor() {
		try {
			Connection con = Configuration.Connecting();
			PreparedStatement ps = con.prepareStatement("select * from doctors where Doctor_name = ?");
			System.out.println("Enter the doctor Name :");
			String n = sc.nextLine();
			ps.setString(1, n);
		ResultSet rs	= ps.executeQuery();
		while(rs.next()) {
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			System.out.println("Doctor Id             : " + rs.getString(1));
			System.out.println("Doctor Name           : " + rs.getString(2));
			System.out.println("Doctor Gender         : " + rs.getString(3));
			System.out.println("Doctor Specialization : " + rs.getString(4));
			System.out.println("Doctor Contact        : " + rs.getString(5));
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			
		}
		System.out.println();;
		System.out.println("Single Doctor...");
		System.out.println();
		ps.close();
		con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void updateDoctor() {
		try {
			Connection con = Configuration.Connecting();
			PreparedStatement ps = con.prepareStatement("update doctors set Doctor_gender = ?,Specialization = ?,Contact=? where Doctor_name = ? ");
			System.out.println("Enter updated Doctor Gender :");
			String g = sc.nextLine();
			System.out.println("Enter updated Doctor Specialization :");
			String s = sc.nextLine();
			System.out.println("Enter updated Doctor Contact :");
			String c = sc.nextLine();
			System.out.println("Enter Doctor Name to be Updated :");
			String n = sc.nextLine();
			
			ps.setString(1, g);
			ps.setString(2, s);
			ps.setString(3, c);
			ps.setString(4, n);
			int r = ps.executeUpdate();
			if (r > 0) {
	        	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	        	System.out.println();
	            System.out.println("Record updated successfully.");
	            System.out.println();
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	            
	        } else {
	        	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	        	System.out.println();
	            System.out.println("No record found with the given patient Name.");
	            System.out.println();
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	        }
		ps.close();
		con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void deleteDoctor() {
		try {
			Connection con = Configuration.Connecting();
			PreparedStatement ps = con.prepareStatement("delete from doctors where Doctor_name = ?");
			System.out.println("Enter the Doctor name :");
			String n = sc.nextLine();
			ps.setString(1, n);
			int rowsAffected = ps.executeUpdate(); // Returns the number of rows affected
	        if (rowsAffected > 0) {
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	            System.out.println("Data Deleted From Hotel Database");
	            System.out.println();
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	            
	        } else {
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	            System.out.println("Room Number not found in the database.");
	            System.out.println();
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	        }
	        ps.close();
	        con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void viewAllAppoitments() {
	 try {
		Connection con = Configuration.Connecting();
		PreparedStatement ps = con.prepareStatement("select * from appointments");
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
			 System.out.println();
			 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			 System.out.println();
			 System.out.println("Appintment Id      : " + rs.getInt(1));
			 System.out.println("Patient Name       : " + rs.getString(2));
			 System.out.println("Doctor Name        : " + rs.getString(3));
			 System.out.println("Appointment Date   : " + rs.getString(4));
//			 System.out.println("Appointment Date   : " + rs.getTimestamp(5));
			 
			 System.out.println();
			 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			 System.out.println();
		 }
		 System.out.println("All Appointments...");
		 ps.close();
		 con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		
		
	}

	@Override
	public void createAppoitment() {
		try {
			Connection con = Configuration.Connecting();
			PreparedStatement ps = con.prepareStatement("insert into appointments (Patient_name,Doctor_name,Appointment_Date) values (?,?,?)");
			
			System.out.println("Enter Patient Name :");
			String pn =sc.nextLine();
			System.out.println("Enter Doctor Name: ");
			String dn =sc.nextLine();
			System.out.println("Enter Appointment date : ");
			String d =sc.nextLine();
			
			ps.setString(1, pn);
			ps.setString(2, dn);
			ps.setString(3, d);
			
			ps.executeUpdate();
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Appintment created...");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			ps.close();
			con.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void updateAppoitment() {
		try {
			Connection con = Configuration.Connecting();
			PreparedStatement ps = con.prepareStatement("update appointments set Patient_name = ?,Doctor_name=?,Appointment_Date=? where Patient_name = ?");
			System.out.println("Enter the new Patient Name: ");
			String pn = sc.nextLine();
			
			System.out.println("Enter the new DoctorName: ");
			String dn = sc.nextLine();
			System.out.println("Enter the new Appointment Date: ");
			String d = sc.nextLine();
			System.out.println("Enter the  Patient Name to be Updated: ");
			String n = sc.nextLine();
			ps.setString(1, pn);
			ps.setString(2, dn);
			ps.setString(3, d);
			ps.setString(4, n);
			int r = ps.executeUpdate();
			if (r > 0) {
	        	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	        	System.out.println();
	            System.out.println("Record updated successfully.");
	            System.out.println();
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	            
	        } else {
	        	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	        	System.out.println();
	            System.out.println("No record found with the given patient Name.");
	            System.out.println();
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	        }
		ps.close();
		con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteAppointment() {
		try {
			Connection con = Configuration.Connecting();
			PreparedStatement ps = con.prepareStatement("delete drom appointments where Patient_name = ?");
			System.out.println("Enter the Patient Name :");
			String n = sc.nextLine();
			ps.setString(1, n);
			int rowsAffected = ps.executeUpdate(); // Returns the number of rows affected
	        if (rowsAffected > 0) {
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	            System.out.println("Data Deleted From Hotel Database");
	            System.out.println();
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	            
	        } else {
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	            System.out.println("patient Name not found in the database.");
	            System.out.println();
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println();
	        }
	        ps.close();
	        con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	

}
