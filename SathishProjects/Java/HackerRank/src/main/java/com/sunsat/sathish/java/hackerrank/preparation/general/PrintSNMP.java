package com.sunsat.sathish.java.hackerrank.preparation.general;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class PrintSNMP {
	
	public static void main(String ... args) throws IOException {
		//printSnmpHostPollCli();
		//printSnmpHostTrapCli();
		//printVniInterface();
		printNetwork();
		//printNetworkAndCLI();
	}
	
	/**
	 * This Method is to generate 4096 SNMP host poll CLIS.
	 * @throws IOException
	 */
	public static void printSnmpHostPollCli() throws IOException {
		StringBuilder snmpCli = new StringBuilder();
		int count = 0;
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.12."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.13."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.14."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.15."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.16."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.17."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.18."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.19."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.20."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.21."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.22."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.23."+i+" poll community sat123\n"); 
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.24."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.25."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.26."+i+" poll community sat123\n");
		}
		for(int i=1;i<255;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.27."+i+" poll community sat123\n");
		}
		for(int i=1;i<33;i++,count++) {
			snmpCli.append("snmp-server host kavi 125.12.28."+i+" poll community sat123\n");
		}
		System.out.println(count);
		File f =new File("c:/project/snmp/snmpHostPollCLI.txt");
		f.createNewFile();
		FileWriter fwriter = new FileWriter(f);
		fwriter.write(snmpCli.toString());
		fwriter.flush();
	}
	
	/**
	 * This method is used to generate 128 SNMP Host Trap CLIs.
	 * @throws IOException
	 */
	public static void printSnmpHostTrapCli() throws IOException {
		StringBuilder snmpCli = new StringBuilder();
		int count = 0;
		for(int i=1;i<129;i++,count++) {
			snmpCli.append("snmp-server host kavi 19.12.12."+i+" trap community sat123\n");
		}
		System.out.println(count);
		File f =new File("c:/project/snmp/snmpHostTrapCLI.txt");
		f.createNewFile();
		FileWriter fwriter = new FileWriter(f);
		fwriter.write(snmpCli.toString());
		fwriter.flush();
	}
	
	/**
	 * This method will be used to print VNI INerfaces.
	 * @throws IOException
	 */
	public static void printVniInterface() throws IOException {
		StringBuilder intf = new StringBuilder();
		StringBuilder snmpCli = new StringBuilder();
		for(int i=1;i<100;i++) {
			intf.append("interface vni"+i+"\n");
			intf.append("  segment-id "+i+"\n");
			intf.append("  nameif vni"+i+"\n");
			intf.append("security-level 100\n");
		}
		File f =new File("c:/project/snmp/vinInterface.txt");
		f.createNewFile();
		FileWriter fwriter = new FileWriter(f);
		fwriter.write(intf.toString());
		fwriter.write(snmpCli.toString());
		fwriter.flush();
	}
	
	/**
	 * This method is used to print the network with range count is 2.
	 *
	 * object network sat_Range1
 	 * range 12.12.12.12 12.12.12.17
	 * @throws IOException
	 */
	public static void printNetwork() throws IOException {
		
		
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i=1;i<255;i=i+2) {
			sb.append("object network snmp_Range10-"+i+"\n");
			sb.append("range 12.12.10."+i+" 12.12.10."+(i+1)+"\n");
			count++;
		}
		for(int i=1;i<255;i=i+2) {
			sb.append("object network snmp_Range11-"+i+"\n");
			sb.append("range 12.12.11."+i+" 12.12.11."+(i+1)+"\n");
			count++;
		}
		for(int i=1;i<255;i=i+2) {
			sb.append("object network snmp_Range12-"+i+"\n");
			sb.append("range 12.12.12."+i+" 12.12.12."+(i+1)+"\n");
			count++;
		}
		for(int i=1;i<255;i=i+2) {
			sb.append("object network snmp_Range13-"+i+"\n");
			sb.append("range 12.12.13."+i+" 12.12.13."+(i+1)+"\n");
			count++;
		}
		for(int i=1;i<255;i=i+2) {
			sb.append("object network snmp_Range14-"+i+"\n");
			sb.append("range 12.12.14."+i+" 12.12.14."+(i+1)+"\n");
			count++;
		}
		File f =new File("c:/project/snmp/ObjectNetwork.txt");
		f.createNewFile();
		FileWriter fwriter = new FileWriter(f);
		fwriter.write(sb.toString());
		fwriter.flush();
		System.out.println("The count is : " + count);
		
	}
	/*
	 * 
	 */
	
	public static void printNetworkAndCLI() throws IOException {
		StringBuilder snmpCli = new StringBuilder();
		int count=0;
		for(int i=101;i<105;i++) {
			for(int j=1;j<=100;j++) {
				snmpCli.append("snmp-server host-group vni"+j+" snmp_Range"+i+" poll community sat\n");
				count++;
			}
		}
		File f =new File("c:/project/snmp/host_group_cli.txt");
		f.createNewFile();
		FileWriter fwriter = new FileWriter(f);
		fwriter.write(snmpCli.toString());
		fwriter.flush();
		System.out.println(snmpCli.toString());
		System.out.println(count);
	}
}
