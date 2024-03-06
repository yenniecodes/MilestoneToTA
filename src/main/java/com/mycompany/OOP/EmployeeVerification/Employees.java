/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.OOP.EmployeeVerification;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.String.format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yennie
 */
public class Employees {
    
    private String employeenum,firstname,lastname,birthday,address,phonenum,
            sssnum,phnum,tin,pgbnum,status,position,supervisor,
            basicsalary,riceall,phoneall,clotheall,smrate,hourlyrate; 
    
    
    
    public Employees(){};
    
    public Employees(String _employeenum,String _firstname,String _lastname,String _birthday,String _address,
                     String _phonenum,String _sssnum,String _phnum,String _tin, String _pgbnum, 
                     String _status,String _position,String _supervisor,String _basicsalary, String _riceall,
                     String _phoneall, String _clotheall, String _smrate, String _hourlyrate){
                    
        
        employeenum = _employeenum;
        firstname = _firstname;
        lastname = _lastname;
        birthday = _birthday;
        address = _address;
        phonenum = _phonenum;
        sssnum = _sssnum;
        phnum = _phnum;
        tin = _tin;
        pgbnum = _pgbnum;
        status = _status;
        position = _position;
        supervisor = _supervisor;
        basicsalary = _basicsalary;
        riceall = _riceall;
        phoneall = _phoneall;
        clotheall = _clotheall;
        smrate = _smrate;
        hourlyrate = _hourlyrate;
    }
    
    public void setemployeenum(String _employeenum){
        employeenum = _employeenum;
    }
    
    public void setfirstname(String _firstname){
        firstname = _firstname;
    }
    
    public void setlastname(String _lastname){
        lastname = _lastname;
    }
    
    public void setbirthday(String _birthday){
        birthday = _birthday;
    }
    
    public void setaddress(String _address){
        address=_address;
    }
    
    public void setphonenum(String _phonenum){
        phonenum = _phonenum;
    }
    
    public void setsssnum(String _sssnum){
        sssnum=_sssnum;
    }
    
    public void setphnum(String _phnum){
        phnum = _phnum;
    }
    public void settin(String _tin){
        tin = _tin;
    }
    
    public void setpgbnum(String _pgbnum){
        pgbnum = _pgbnum;
    }
    
    public void setstatus(String _status){
        status = _status;
    }
    
    public void setposition(String _position){
        position = _position;
    }
    
    public void setsupervisor(String _supervisor){
        supervisor = _supervisor;
    }
    
    public void setbasic(String _basicsalary){
        basicsalary=_basicsalary;
    }
    
    public void setriceall(String _riceall){
        riceall = _riceall;
    }
    public void setphoneall(String _phoneall){
        phoneall = _phoneall;
    }
    public void setclotheall(String _clotheall){
        clotheall = _clotheall;
    }
    public void setsmrate(String _smrate){
        smrate = _smrate;
    }
    public void sethourlyrate(String _hourlyrate){
        hourlyrate = _hourlyrate;
    }
    
    
    
    public String getEmployeeNum(){
        return employeenum ;
    }
    
    public String getFirstName(){
        return firstname;
    }
    
    public String getLastName(){
        return lastname ;
    }
    
    public String getBirthday(){
        return birthday;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getPhoneNum(){
        return phonenum;
    }
    
    public String getSssNum(){
        return sssnum;
    }
    
    public String getPhNum(){
        return phnum;
    }
    public String getTinNum(){
        return tin;
    }
    
    public String getPagibigNum(){
        return pgbnum;
    }
    
    public String getStatus(){
        return status;
    }
    
    public String getPosition(){
        return position ;
    }
    
    public String getSupervisor(){
        return supervisor;
    }
    
    public String getBasicSalary(){
        return basicsalary;
    }
    
    public String getRiceAllowance(){
        return riceall;
    }
    public String getphoneAllowance(){
        return phoneall;
    }
    public String getClothAllowance(){
        return clotheall;
    }
    public String getSemRate(){
        return smrate;
    }
    public String getHourlyRate(){
        return hourlyrate;
    }
    
    
    
    
    public DefaultTableModel tableDetails(String filename) throws FileNotFoundException, IOException, CsvValidationException{
        DefaultTableModel details;
        
        try(CSVReader csvreader = new CSVReader(new FileReader(filename))){
            
            String[] line1 = csvreader.readNext();
            String[] header = {line1[0], line1[1],line1[2],line1[6],line1[7],line1[8],line1[9] };
            details = new DefaultTableModel(header,0);
            
            String[] line;

            while((line=csvreader.readNext()) != null){

                String[] data = {line[0], line[1],line[2],line[6],line[7],line[8],line[9] };
                
                details.addRow(data);
            }
        }
        
        return details;
        
    }
    
       public DefaultTableModel leaveDetails(String filename) throws FileNotFoundException, IOException, CsvValidationException{
        DefaultTableModel leave;
        
        try(CSVReader csvreader = new CSVReader(new FileReader(filename))){
            
            String[] line1 = csvreader.readNext();
            String[] header = {line1[0], line1[1],line1[2],line1[3],line1[4],line1[5] };
            leave = new DefaultTableModel(header,0);
            
            String[] line;

            while((line=csvreader.readNext()) != null){

                String[] data = {line[0], line[1],line[2],line[3],line[4],line[5] };
                
                leave.addRow(data);
            }
            
        }
        
        return leave;
        
    }
    
    public void UpdateEmployee(String filename) throws FileNotFoundException, IOException, CsvValidationException{
        String tempfilename = filename.replace(".csv", ".tmp");
        
        CSVReader csvreader = new CSVReader(new FileReader(filename));
        String[] line;
        
        CSVWriter csvwriter = new CSVWriter(new FileWriter(tempfilename,true));
        
        while((line=csvreader.readNext())!=null){
            if(line[0].equals(employeenum)){
                line[0] = employeenum;
                line[1] = lastname;
                line[2] = firstname;
                line[3] = birthday;
                line[4] = address;
                line[5] = phonenum;
                line[6] = sssnum;
                line[7] = phnum;
                line[8] = tin;
                line[9] = pgbnum;
                line[10] = status;
                line[11] = position;
                line[12] = supervisor;
                line[13] = String.valueOf(basicsalary);
                line[14] = String.valueOf(riceall);
                line[15] = String.valueOf(phoneall);
                line[16] = String.valueOf(clotheall);
                line[17] = String.valueOf(smrate);
                line[18] = String.valueOf(hourlyrate);  
            }
            
            csvwriter.writeNext(line);
        }
        csvreader.close();
        csvwriter.close();
        
        new File(filename).delete();
        new File(tempfilename).renameTo(new File(filename));
    }
    
    public void AddEmployee(String filename) throws IOException{
        try(CSVWriter csvwriter = new CSVWriter(new FileWriter(filename, true))){
            String[] line = new String[19];

            line[0] = employeenum;
            line[1] = lastname;
            line[2] = firstname;
            line[3] = birthday;
            line[4] = address;
            line[5] = phonenum;
            line[6] = sssnum;
            line[7] = phnum;
            line[8] = tin;
            line[9] = pgbnum;
            line[10] = status;
            line[11] = position;
            line[12] = supervisor;
            line[13] = basicsalary;
            line[14] = riceall;
            line[15] = phoneall;
            line[16] = clotheall;
            line[17] = smrate;
            line[18] = hourlyrate;

            csvwriter.writeNext(line);
        }
        
    }
    
    public void DeleteEmployee(String filename) throws FileNotFoundException, IOException, CsvValidationException{
        String tempfilename = filename.replace(".csv", ".tmp");
        
        CSVReader csvreader = new CSVReader(new FileReader(filename));
        String[] line;
        
        try(CSVWriter csvwriter = new CSVWriter(new FileWriter(tempfilename, true))){
            while((line = csvreader.readNext())!= null){
                if(!(line[0].equals(employeenum))){
                    csvwriter.writeNext(line);
                }       
            }
            csvreader.close();
        }
        finally{
            new File(filename).delete();
            new File(tempfilename).renameTo(new File(filename));    
        }    
    }
    
    public float ComputeHoursWorked(String startDate, String endDate) throws FileNotFoundException, IOException, CsvValidationException, ParseException{
        
        SimpleDateFormat format1 = new SimpleDateFormat("M/d/yyyy HH:mm:ss");    
        SimpleDateFormat format2 = new SimpleDateFormat("M/d/yyyy");
        
        Date dateIn = format2.parse(startDate);
        Date dateOut = format2.parse(endDate);
        
        try(CSVReader csvreader = new CSVReader(new FileReader("Attendance Record 1.csv"))){
            
            String[] line;

            
            ArrayList<String> timein = new ArrayList<>();
            ArrayList<String> timeout = new ArrayList<>();

            while((line=csvreader.readNext())!=null){
                if(line[0].equals(employeenum)){
                    timein.add(line[1]);
                    timeout.add(line[2]);
                }    
            }

        int indexStart = 0;
        for (int i =0; i< timein.size();i++){
           Date dStart = format1.parse(timein.get(i));
           if (dStart.compareTo(dateIn)==0){               
                indexStart = i;                                     
            }                                              
        } 
        

        int indexEnd = 0;
        for (int i =0; i< timeout.size();i++){     //limit of loop is the length on the elements in Array
              
           Date dEnd = format2.parse(timeout.get(i)); 
           if (dEnd.compareTo(dateOut)==0){               
                indexEnd=i; // saves the index within the array of end date      
           }
        }   
        
       
            float sum= 0;                       
            for (int k =indexStart; k<=indexEnd;k++){ // this loop gets the total time from start date to end date input
                Date t1 = format1.parse(timein.get(k));                               
                Date t2 = format1.parse(timeout.get(k));               
                                                                  
                float t = t2.getTime() - t1.getTime()-(60 * 60 * 1000);                
                float test =  t/(60 * 60 * 1000);
                                
                if (test >= 47/6){ // this test is to assign a complete 8 hours if the employee is late within 10 minutes                   
                    test = 8;                    
                }
                sum = sum+ test;                                                                                                 
            }
              
            return sum;
            
        }
       
    }
    public String computeSalEarned(float hw){
        float salEarned= Float.parseFloat(hourlyrate)*hw;
        return format("%.2f",salEarned);
    }
    
    public String computeGross(float hw){
        float gross =  Float.parseFloat(computeSalEarned(hw))+
                       Float.parseFloat(riceall)+
                       Float.parseFloat(phoneall)+
                       Float.parseFloat(clotheall);
        
        return format("%.2f",gross);
    }
    
    public String computeSSS(){
        double sss;
         
        float sal = Float.parseFloat(basicsalary);
         
         
         if(sal<=3250){
                sss = 135;
            }
            else if(sal>3250 & sal<=24750) {
               if(sal%1000==250 |sal%1000==750 ){// this check whether the salary is in the lower/upper bound of range. 
                   float mod = (sal-3250)%500; // after deducting 3250, in every 500 increment, the sss increases by 22.5
                    float multiplier = ((sal-3250-mod)/500);              
                    sss = 22.5*(multiplier)+135;                        
               }
                else{// this applies the normal formule is salary falls within the range
                    float mod = (sal-3250)%500; 
                    float multiplier = ((sal-3250-mod)/500);              
                    sss = 22.5*(multiplier+1)+135;           
               }
            }
            else{
                sss = 1125;
            }
           
            return format("%.2f",sss);  
    }
    
    public String computePH(){
        double ph;

        float sal = Float.parseFloat(basicsalary);
         

        if(sal<=10000){//if-elseif-else statement checks the range of salary and applies formula in each range
           ph = 300/2;
        }
        else if (sal>10000 & sal<60000){
           ph = sal*(0.03)/2;
        }
        else{
           ph = 1800/2;
        }
       
       return format("%.2f",ph);
    }
    
    public String computePGB(){
        double pagibig;
        float sal = Float.parseFloat(basicsalary);
        
        if(sal>1000 & sal<=1500){//if-else statement checks the range of salary and applies formula in each rang
            pagibig = sal*(float)0.01;
        } 
        else{
            if(sal*0.02 <100){// this nested if-else statement provides the pagibig to be 100 if the values exceeds 100
              pagibig= sal*(float)0.02;
            }
            else{
                pagibig = 100;
            }
        }
        
        return format("%.2f",pagibig);    
    }
    
    public String computeTax(){
        float tax;
        float sal = Float.parseFloat(basicsalary);
        float sss = Float.parseFloat(computeSSS());
        float pagibig = Float.parseFloat(computePGB());
        float ph = Float.parseFloat(computePH());
        
        float taxable = sal-sss-pagibig-ph;
       
         if(sal <=20832){//if-elseif-else statement checks the range of taxable income and applies formula in each range 
                tax = 0;
            }
            else if(sal>20832 & sal<33333){
                tax = (float) ((taxable-20833)*0.2);               
            }
            else if(sal>=33333 & sal< 66667){
                tax = (float) ((taxable-33333)*0.25+2500);
            }
            else if(sal>=66667 & sal< 166667){
                tax = (float) ((taxable-66667)*0.3+10833);
            }
            else if(sal>=166667 & sal< 666667){
                tax = (float) ((taxable-166667)*0.32+40833.33);
            }
            else{
                tax = (float) ((sal-666667)*0.35+200833.33);
            }
           
            
            return format("%.2f",tax);
    }
    
    public String computeTotalDeduct(){
        
        float tax = Float.parseFloat(computeTax());
        float sss = Float.parseFloat(computeSSS());
        float pagibig = Float.parseFloat(computePGB());
        float ph = Float.parseFloat(computePH());
        
        return format("%.2f",sss+ph+pagibig+tax);
    }
    
    public String computeNet(float hw){
        float net = Float.parseFloat(computeGross(hw))-Float.parseFloat(computeTotalDeduct());
        return format("%.2f",net);
    }
    
    public boolean LeaveIsAllowed(String filename,String leaveType, String days) throws FileNotFoundException, IOException, CsvValidationException{
        
        try(CSVReader csvreader = new CSVReader(new FileReader(filename))){
            
            String[] line;
            int leaveDays = Integer.parseInt(days);
            while((line=csvreader.readNext())!=null){
                if(line[0].equals(employeenum) & leaveType.equals("Sick Leave")){
                   int remainSL = Integer.parseInt(line[3]);
                   
                   if(leaveDays>remainSL){
                       return false;
                   }
                   
                   
                            
                }
                else if(line[0].equals(employeenum) & leaveType.equals("Vacation Leave")){
                   int remainVL = Integer.parseInt(line[4]);
                   
                   if(leaveDays>remainVL){
                       return false;
                   }
                   
                }
                else if(line[0].equals(employeenum) & leaveType.equals("Sick Leave")){
                   int remainEL = Integer.parseInt(line[3]);
                   
                   if(leaveDays>remainEL){
                       return false;
                   }
                   
                }
            }
            
            return true;
            
        }
    }
    
    public void ApplyLeave(String filename, String leaveType, String days) throws FileNotFoundException, IOException, CsvValidationException {
        
        String tempfilename = filename.replace(".csv", ".tmp");
        
        try(CSVWriter csvwriter = new CSVWriter(new FileWriter(tempfilename,true))){
            
            String[] line;

            
            CSVReader csvreader = new CSVReader(new FileReader(filename));        
            
            String[] header =csvreader.readNext();
            csvwriter.writeNext(header);
            
            while((line=csvreader.readNext())!=null){
                if(line[0].equals(employeenum) & leaveType.equals("Sick Leave")){
                    
                    line[3] = String.valueOf(Integer.parseInt(line[3])-Integer.parseInt(days));
                        
                }
                else if(line[0].equals(employeenum) & leaveType.equals("Vacation Leave")){
                    line[4] = String.valueOf(Integer.parseInt(line[4])-Integer.parseInt(days));
                }
                else if(line[0].equals(employeenum) & leaveType.equals("Sick Leave")){
                    line[5] = String.valueOf(Integer.parseInt(line[5])-Integer.parseInt(days));
                }
                

               csvwriter.writeNext(line); 
               
            } 
            
            csvreader.close();
               
        }
        finally{
            new File(filename).delete();
            new File(tempfilename).renameTo(new File(filename));
        }
        
    }
    
    public void createLeaveApplication(String dateFiled, String leaveType, String days,String start, String end) throws IOException, CsvValidationException{
        
        String file="Remaining_Leave.csv";
        
        CSVReader csvreader = new CSVReader(new FileReader(file));
        String [] line;
        String remainsl=null;
        String remainvl=null;
        String remainel=null;
        
        while((line=csvreader.readNext())!=null){
            if(line[0].equals(employeenum)){
                remainsl = line[3];
                remainvl = line[4];
                remainel = line[5];
                break;
            }
        }
        csvreader.close();
        
        
        
        try(CSVWriter csvwriter= new CSVWriter(new FileWriter("Leave Application.csv"))){
            
            String[] line1 = {"Date Filed:",dateFiled};
            String[] line2 = {"Employee Number:",employeenum};
            String[] line3 = {"Last Name:",lastname};
            String[] line4 = {"First Name:",firstname};
            String[] line5 = {"Type of Leave Applied:",leaveType};
            String[] line6 = {"Number of Days:",days};
            String[] line7 = {"Start Date:",start};
            String[] line8 = {"End Date:",end};  
            String[] line9 = {"Application Status:","Approved"};
            String[] line10 ={"Remarks:",""};
            String[] line11 ={"Remaining Sick Leave:",remainsl};
            String[] line12 ={"Remaining Vacation Leave",remainvl};
            String[] line13 ={"Remaining Emergency Leave:",remainel};

            csvwriter.writeNext(line1);
            csvwriter.writeNext(line2);
            csvwriter.writeNext(line3);
            csvwriter.writeNext(line4);
            csvwriter.writeNext(line5);
            csvwriter.writeNext(line6);
            csvwriter.writeNext(line7);
            csvwriter.writeNext(line8);
            csvwriter.writeNext(line9);
            csvwriter.writeNext(line10);
            csvwriter.writeNext(line11);
            csvwriter.writeNext(line12);
            csvwriter.writeNext(line13);

           
            
        }
    }
    
    
}
