
package javaapplication1;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author vip
 */
public  class CoursesModule  {
   
     private ArrayList<CourseComponent> courses =new ArrayList<>();
     private File database = new File("E:\\Faculty2\\Pl2\\JavaApplication1\\users.txt");
     private File Teacher = new File("E:\\Faculty2\\Pl2\\JavaApplication1\\Teacher.txt");
     private File Students = new File("E:\\Faculty2\\Pl2\\JavaApplication1\\Students.txt");
    CoursesModule(){
        
    }
     
     CoursesModule(ArrayList<CourseComponent> course){
         this.courses=course;
         
        
     }

   public ArrayList<String> shwoAllInstractor(){
          
          Scanner read=null;//for scope
         try {
             read = new Scanner(Teacher);
         } catch (FileNotFoundException ex) {
             System.out.println(ex);
         }
          ArrayList<String> output = new ArrayList<>();
          int i = 0;
          while (read.hasNext()) {
              String values = read.nextLine();
              String[] seprated = values.split("::");
                  output.add(i, seprated[0]+" Id:"+seprated[1] );
                  i++;
          }
          read.close();
          return output;
     }
     
      public ArrayList<String> shwoAllStudent() {
          
          Scanner read=null;//for scope
         try {
             read = new Scanner(Students);
         } catch (FileNotFoundException ex) {
             System.out.println(ex);
         }
          ArrayList<String> output = new ArrayList<>();
          int i = 0;
          while (read.hasNext()) {
              String values = read.nextLine();
              String[] seprated = values.split("::");
                  output.add(i, seprated[0]+" Id:"+seprated[1] );
                  i++;
              
          }
          read.close();
          return output;
     }
     
    public void addCourse(ArrayList<CourseComponent> c ,boolean stat){
   
       File file =  new File("E:\\Faculty2\\Pl2\\JavaApplication1\\value.txt");
       
        if(!file.exists()){
            System.out.println("the file not exit ");
        }
        try{
       FileWriter out=new FileWriter(file,stat);
        for (CourseComponent x:c) {
           String crName= x.getCourseName();
           String id=x.getCourseId();
           String room=x.getRoom();
           String branch=x.getBranch();
           String  coursePrice = x.getCoursePrice();
           String startDate = x.getStartCourse();
           String daysOfCourse =x.getDaysCourse();
           String endDate = x.getEndCourse();
  
           if(stat){
           out.append('\n');
           }
           stat=true;
   out.write(crName+"@"+id+"@"+room+"@"+branch+"@"+coursePrice+"@"+startDate+"@"
           +daysOfCourse+"@"+endDate);
        }
         out.close();
        }catch(IOException ex){
            System.out.println(ex);
        }
        
       

       }
  

    private ArrayList<CourseComponent> cData()  {
          ArrayList<CourseComponent> l=new ArrayList<>();
        File file=new File("E:\\Faculty2\\Pl2\\JavaApplication1\\value.txt");
        CourseComponent x;
        Scanner read=null;
         try {
             
               read = new Scanner(file);
         } catch (FileNotFoundException ex) {
             System.out.println("Prob");
         }
        while(read.hasNext()){
            x = new CourseComponent();
                String Line = read.nextLine();
                String[] seprated = Line.split("@");
                x.setCourseName(seprated[0]);
                x.setCourseId(seprated[1]);
                x.setRoom(seprated[2]);
                x.setBranch(seprated[3]);
                x.setCoursePrice(seprated[4]);
                 x.setStartCourse(seprated[5]);
                 x.setDaysCourse(seprated[6]);
                 x.setEndCourse(seprated[7]);
               l.add(x);
               // System.out.println(view(l));
        }
        read.close();
        return l;
         } 
    
    public void deleteCourse(String crName){
        
        ArrayList<CourseComponent>cr =cData();
         for (int i = 0; i < cr.size(); i++) {
            if(cr.get(i).getCourseName().equals(crName))
                cr.remove(i);
        }
         try{
         addCourse(cr,false);
         }catch(Exception ex){ System.out.println("File NotExist");}
    }


    public void UpdateCourse(String crName){
        ArrayList<CourseComponent>cr =cData();
        Scanner input=new Scanner(System.in).useLocale(Locale.US);
        int a=0;
        while(a!=99){
        System.out.println("What update On "+crName.toUpperCase()+"\n\t"+" 1--> The Id "
                + "\n\t"+"2-->The Room"+"\n\t"+"3-->The Branch"+"\n\t"
                + "4-->The Price"+"\n\t"+"5-->The NumOFdaY"+"\n\t"+"6-->The StartDate"+"\n\t"+"7-->The EndDate"
                +"\n\t"+"99-->For Finish Updates");
            a=input.nextInt();
        
        switch(a){
            case 1->{
                System.out.println("Enter Ur NewId:");
                String s=input.next();
                for (int i = 0; i < cr.size(); i++) {
           if(cr.get(i).getCourseName().equals(crName))
                cr.get(i).setCourseId(s);
        }
                break;
            }
            case 2->{
                
                System.out.println("Enter Ur NewRoom:");
                String s=input.next();
                for (int i = 0; i < cr.size(); i++) {
           if(cr.get(i).getCourseName().equals(crName))
                cr.get(i).setRoom(s);
          }
           break; 
        }
            case 3->{
                
                System.out.println("Enter Ur NewBranch:");
                String s=input.next();
                for (int i = 0; i < cr.size(); i++) {
           if(cr.get(i).getCourseName().equals(crName))
                cr.get(i).setBranch(s);
        
        }
           break;
        }
            case 4->{
                
                System.out.println("Enter Ur NewPrice:");
                String s=input.next();
                for (int i = 0; i < cr.size(); i++) {
           if(cr.get(i).getCourseName().equals(crName))
                cr.get(i).setCoursePrice(s);
        }
           break;
        }
            case 5->{
                
                System.out.println("Enter New NumOfDay:");
                String s=input.next();
                for (int i = 0; i < cr.size(); i++) {
           if(cr.get(i).getCourseName().equals(crName))
                cr.get(i).setDaysCourse(s);
        }
           break;
        }
            case 6->{
                
                System.out.println("Enter New StartDate:");
                String s=input.next();
                for (int i = 0; i < cr.size(); i++) {
           if(cr.get(i).getCourseName().equals(crName))
                cr.get(i).setStartCourse(s);
        
        }
           break;
        }
            case 7->{
                
                System.out.println("Enter Ur New EndDate:");
                String s=input.next();
                for (int i = 0; i < cr.size(); i++) {
           if(cr.get(i).getCourseName().equals(crName))
                cr.get(i).setEndCourse(s);
        }
           break;
        }
            
    
    }
        }
         try {
             addCourse(cr,false);
         } catch (Exception ex) {
             System.out.println("The File Not Existing");
         }
    }
    public void nearToStaCourse() {
            SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
    ArrayList<CourseComponent>cr =cData();
    CourseComponent comp=new CourseComponent();
    CourseComponent cotemp=new CourseComponent();
    cotemp=cr.get(0);
    String str=cr.get(0).getStartCourse();
    try{
                 Date d=sdf.parse(str);
        for (int i = 1; i < cr.size(); i++) {
            comp=cr.get(i);
                String str2=cr.get(i).getStartCourse();
                 Date d2=sdf.parse(str2);
                 if(d.compareTo(d2)>0){
                     cotemp=comp;
                 }
            
        }
         System.out.println("The Near Course Is " +cotemp.getCourseName().toUpperCase()+"\n"+
                           "The Details ARE "+"\n"+"Id:"+cotemp.getCourseId()+"\n"+"Price:"+cotemp.getCoursePrice()
                     +"\n"+"NumOFdaYs:"+cotemp.getDaysCourse()+"\n"+"StartDate Of Course:"+
                             cotemp.getStartCourse());
    }catch(ParseException ex){
          System.out.println(ex);  
            }
    
    
    
       
    }
    public void nearToEnDCours() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
    ArrayList<CourseComponent>cr =cData();
    CourseComponent comp=new CourseComponent();
    CourseComponent cotemp=new CourseComponent();
    cotemp=cr.get(0);
    String str=cr.get(0).getEndCourse();
    try{
                 Date d=sdf.parse(str);
        for (int i = 1; i < cr.size(); i++) {
            comp=cr.get(i);
                String str2=cr.get(i).getEndCourse();
                 Date d2=sdf.parse(str2);
                 if(d.compareTo(d2)>0){
                     cotemp=comp;
                 }
            
        }
         System.out.println("The Near Course Is " +cotemp.getCourseName().toUpperCase()+"\n"+
                           "The Details ARE "+"\n"+"Id:"+cotemp.getCourseId()+"\n"+"Price:"+cotemp.getCoursePrice()
                     +"\n"+"NumOFdaYs:"+cotemp.getDaysCourse()+"\n"+"EndDate Of Course:"+
                             cotemp.getEndCourse());
    
     }catch(ParseException ex){
          System.out.println(ex);  
            }
    
    
    }
        }


    
    


    
    
    

    

