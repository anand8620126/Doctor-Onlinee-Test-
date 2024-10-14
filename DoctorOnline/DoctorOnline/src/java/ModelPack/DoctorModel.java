package ModelPack;


import Servlet.SQLDemo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class DoctorModel {
    PreparedStatement pst;
    ResultSet rst;
    SQLDemo sd;
    ArrayList aobj=new ArrayList();
    public DoctorModel()
    {
    sd=new SQLDemo();
    }
    public boolean InsertAppointment(String userid,String drid,String patienttxt,String agetxt, String gender,String msymtxt,String prevtrmtxt,String pdtxt,String adtxt,String attxt,String atypetxt)
    {
    boolean flag=false;
    sd.Connect();
    try
    {
    pst=sd.con.prepareCall("{call prcinsertappointment(?,?,?,?,?,?,?,?,?,?,?)}");
    pst.setLong(1,Long.parseLong(userid));
    pst.setLong(2,Long.parseLong(drid));
    pst.setString(3,patienttxt);
    pst.setString(4,agetxt);
    pst.setString(5,gender);
    pst.setString(6,msymtxt);
    pst.setString(7,prevtrmtxt);
    pst.setString(8,pdtxt);
    pst.setString(9,adtxt);
    pst.setString(10,attxt);
    pst.setString(11,atypetxt);
    
    if(pst.execute()==false)                                   //==false because in cas of insert and update we use false and in select statement of procedure we use true 
    if(pst.getUpdateCount()>0)
    flag=true;
        }
    catch(Exception ex)
    {
    System.out.println("error in appointment insert"+ex);
    }
    sd.Disconnect();
    return flag;
    }
 public boolean UpdateAppointment(String appid,String userid,String patienttxt,String agetxt, String gender,String msymtxt,String prevtrmtxt,String pdtxt,String adtxt,String acdecradio,String attxt,String atypetxt,String natxt)
 {
  boolean flag=false;
 sd.Connect(); 
 try
 {
    pst=sd.con.prepareCall("{call prcupdatetbappointment(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
    pst.setLong(1,Long.parseLong(appid));
    pst.setLong(2,Long.parseLong(userid));
    pst.setString(3,patienttxt);
    pst.setString(4,agetxt);
    pst.setString(5,gender);
    pst.setString(6,msymtxt);
    pst.setString(7,prevtrmtxt);
    pst.setString(8,pdtxt);
    pst.setString(9,adtxt);
    pst.setString(10, acdecradio);
    pst.setString(11,attxt);
    pst.setString(12,atypetxt);
    pst.setString(13,natxt);
    if(pst.execute()==false)                                   //==false because in cas of insert and update we use false and in select statement of procedure we use true 
    if(pst.getUpdateCount()>0)
    flag=true;
 }
   catch(Exception ex)
{
System.out.println("error in appointment update"+ex);
}
         return flag;
}
    public ArrayList SearchAppointment(String patienttxt)
    {
        sd.Connect();
        try
        {
        pst=sd.con.prepareStatement("selelct * from tbAppointment where Patient_Name=?");
        pst.setString(1, patienttxt);
        rst=pst.executeQuery();
        while(rst.next())
        {
        aobj.add(rst.getString(1)); 
        aobj.add(rst.getString(2));
        aobj.add(rst.getString(3));
        aobj.add(rst.getString(4));
        aobj.add(rst.getString(5));
        aobj.add(rst.getString(6));
        aobj.add(rst.getString(7));
        aobj.add(rst.getString(8));
        aobj.add(rst.getString(9));
        aobj.add(rst.getString(10));
        aobj.add(rst.getString(11));
        aobj.add(rst.getString(12));
        aobj.add(rst.getString(13));
        }
        rst.close();
        }
        catch(Exception ex)
        {
        System.out.println("error in searching appointment"+ex);
        }
    return aobj;
    }
    public ArrayList editAppointment(String appid)
    {
        sd.Connect();
        try
        {
        pst=sd.con.prepareStatement("select * from tbAppointment where Appointment_ID=?");
        pst.setLong(1,Long.parseLong(appid));
        rst=pst.executeQuery();
        while(rst.next())
        {
        aobj.add(rst.getString(1)); 
        aobj.add(rst.getString(2));
        aobj.add(rst.getString(3));
        aobj.add(rst.getString(4));
        aobj.add(rst.getString(5));
        aobj.add(rst.getString(6));
        aobj.add(rst.getString(7));
        aobj.add(rst.getString(8));
        aobj.add(rst.getString(9));
        aobj.add(rst.getString(10));
        aobj.add(rst.getString(11));
        aobj.add(rst.getString(12));
        aobj.add(rst.getString(13));
        aobj.add(rst.getString(14));
        }
        rst.close();
        }
        catch(Exception ex)
        {
        System.out.println("error in edit appointment model"+ex);
        }
    return aobj;
    }
  public boolean CheckDoctor(String phtxt,String pwdtxt)
  {
  boolean flag=false;
  sd.Connect();
  try
  {
  pst=sd.con.prepareStatement("select * from tbDoctor where phone=? and password=?");
  pst.setString(1, phtxt);
  pst.setString(2, pwdtxt);
  rst=pst.executeQuery();
  if(rst.next())
  flag=true;
  }
  catch(Exception ex)
  {
  System.out.println("error in login user"+ex);
  }
  return flag;
  }
   public ArrayList getdrname(String phtxttxt,String pwdtxt)
   {
   ArrayList aobj=new ArrayList();
   sd.Connect();
   try
   {
   pst=sd.con.prepareStatement("select Doctor_ID, Doctor_Name from tbDoctor where Phone=? and Password=?");
   pst.setString(1, phtxttxt);
   pst.setString(2, pwdtxt);
   rst=pst.executeQuery();
   while(rst.next())
   {
   aobj.add(rst.getString(1));
   aobj.add(rst.getString(2));
   }
   rst.close();
   }
   catch(Exception ex)
   {
   System.out.println("error in getdrname"+ex);
   }
return aobj;   
   } 
   public boolean ChangePassworddoctor(String phtxt,String npwdtxt,String pwdtxt)
  {
  boolean flag=false;
  sd.Connect();
  try
  {
  pst=sd.con.prepareStatement("update tbDoctor set Password=? where phone=? and password=?");
  pst.setString(1, npwdtxt);
  pst.setString(2, phtxt);
  pst.setString(3, pwdtxt);
      if(pst.executeUpdate()>0)
          flag=true;
  }
  catch(Exception ex)
  {
  System.out.println("error in changing password"+ex);
  }
  return flag;
  }
   public ArrayList GetUserDetails(String emailtxt,String pwdtxt)
   {
   ArrayList aobj=new ArrayList();
   sd.Connect();
   try
   {
   pst=sd.con.prepareStatement("select User_ID,Name from tbUser where Email=? and Password=?");
   pst.setString(1, emailtxt);
   pst.setString(2, pwdtxt);
   rst=pst.executeQuery();
   while(rst.next())
   {
   aobj.add(rst.getString(1));
   aobj.add(rst.getString(2));
   }
   rst.close();
   }
   catch(Exception ex)
   {
   System.out.println("error in getting user name"+ex);
   }
return aobj;   
   }
    public boolean InsertDoctor(String drnametxt,String pwdtxt,String addtxt,String citytxt,String phtxt,String qlftxt,String exptxt,String spctxt,String hospitalid,String prevhosntxt)          
    {
    boolean flag=false;
    sd.Connect();
    try
    {
    pst=sd.con.prepareCall("{call prcinserttbdoctor(?,?,?,?,?,?,?,?,?,?)}");
    pst.setString(1,drnametxt);
    pst.setString(2,pwdtxt);
    pst.setString(3,addtxt);
    pst.setString(4,citytxt);
    pst.setString(5,phtxt);
    pst.setString(6,qlftxt);
    pst.setString(7,exptxt);
    pst.setString(8,spctxt);
    pst.setLong(9,Long.parseLong(hospitalid));
    pst.setString(10,prevhosntxt);
    if(pst.execute()==false)
        if(pst.getUpdateCount()>0)
        flag=true;
    }
    catch(Exception ex)
    {
    System.out.println("error in insert doctor"+ex);
    }
    return flag; 
    }
    public boolean UpdateDoctor(String doctorid,String drnametxt,String pwdtxt,String addtxt,String citytxt,String phtxt,String qlftxt,String exptxt,String spctxt,String hospitalid,String prevhosntxt)
    {
        boolean flag=false;
    sd.Connect();
    try
    {
    pst=sd.con.prepareCall("call prcupdatetbdoctor(?,?,?,?,?,?,?,?,?,?,?)");
    pst.setLong(1,Long.parseLong(doctorid));
    pst.setString(2,drnametxt);
    pst.setString(3,pwdtxt);
    pst.setString(4,addtxt);
    pst.setString(5,citytxt);
    pst.setString(6,phtxt);
    pst.setString(7,qlftxt);
    pst.setString(8,exptxt);
    pst.setString(9,spctxt);
    pst.setLong(10,Long.parseLong(hospitalid));
    pst.setString(11,prevhosntxt);
    if(pst.execute()==false)
    if(pst.getUpdateCount()>0)
    flag=true;
    }
    catch(Exception ex)
    {
    System.out.println("error in update doctor"+ex);
    }
    return flag;
    }
    public ArrayList SearchDoctor(String spctxt)
    {
    ArrayList aobj=new ArrayList();
    sd.Connect();
    try
    {
    pst=sd.con.prepareStatement("select * from tbDoctor where Specialization=?");
    pst.setString(1, spctxt);
    rst=pst.executeQuery();
    while(rst.next())
    {
    aobj.add(rst.getString(1));
    aobj.add(rst.getString(2));
    aobj.add(rst.getString(3));
    aobj.add(rst.getString(4));
    aobj.add(rst.getString(5));
    aobj.add(rst.getString(6));
    aobj.add(rst.getString(7));
    aobj.add(rst.getString(8));
    aobj.add(rst.getString(9));
    aobj.add(rst.getString(10));
    aobj.add(rst.getString(11));
    aobj.add(rst.getString(12));
    }
    rst.close();
    }
    catch(Exception ex)
    {
    System.out.println("error in searching doctor"+ex);
    }
    return aobj;
    }
    public boolean InsertHospital(String hospntxt,String hospatxt,String citytxt,String rdtxt,String desctxt,String timetxt,String phtxt,String emailtxt,String webtxt)
    {
    boolean flag=false;
    sd.Connect();
    try
    {
    pst=sd.con.prepareCall("{call prcinserttbhospital(?,?,?,?,?,?,?,?,?)}");
    pst.setString(1, hospntxt);
    pst.setString(2,hospatxt); 
    pst.setString(3,citytxt);
    pst.setString(4,rdtxt);
    pst.setString(5,desctxt);
    pst.setString(6,timetxt);
    pst.setString(7,phtxt);
    pst.setString(8,emailtxt);
    pst.setString(9,webtxt);
    if(pst.execute()==false)
    if(pst.getUpdateCount()>0)
    flag=true;
    }
    catch(Exception ex)
    {
    System.out.println("error in insert hospital"+ex);
    }
    return flag;
    }
    public boolean UpdateHospital(String hospitalid,String hospntxt,String hospatxt,String citytxt,String rdtxt,String desctxt,String timetxt,String phtxt,String emailtxt,String webtxt)
    {
    boolean flag=false;
    sd.Connect();
    try
    {
    pst=sd.con.prepareCall("{call prcupdatetbhospital(?,?,?,?,?,?,?,?,?,?)}");
    pst.setLong(1,Long.parseLong(hospitalid));
    pst.setString(2, hospntxt);
    pst.setString(3,hospatxt); 
    pst.setString(4,citytxt);
    pst.setString(5,rdtxt);
    pst.setString(6,desctxt);
    pst.setString(7,timetxt);
    pst.setString(8,phtxt);
    pst.setString(9,emailtxt);
    pst.setString(10,webtxt);
    if(pst.execute()==false)
    if(pst.getUpdateCount()>0)
    flag=true;
    }
    catch(Exception ex)
    {
     System.out.println("error in update hospital"+ex);
    }
    return flag;
    }
    public ArrayList SearchHospital(String hospitalidtxt)
    {
    ArrayList aobj=new ArrayList();
    sd.Connect();
    try
    {
    pst=sd.con.prepareStatement("select * from tbHospital where Hospital_ID=?");
            pst.setLong(1,Long.parseLong(hospitalidtxt));
            rst=pst.executeQuery();
            while(rst.next())
            {
            aobj.add(rst.getString(1));
            aobj.add(rst.getString(2));
            aobj.add(rst.getString(3));
            aobj.add(rst.getString(4));
            aobj.add(rst.getString(5));
            aobj.add(rst.getString(6));
            aobj.add(rst.getString(7));
            aobj.add(rst.getString(8));
            aobj.add(rst.getString(9));
            aobj.add(rst.getString(10));
            }
            rst.close();
    }
    catch(Exception ex)
    {
    System.out.println("error in search hospital"+ex);
    }
    sd.Disconnect();
    return aobj;
    }
    public boolean InsertNews(String newsdtxt,String newsttxt,String newsdesctxt)
    {
    boolean flag=false;
    sd.Connect();
    try
    {
    pst=sd.con.prepareCall("{call prcinserttbnews(?,?,?)}");
    pst.setString(1,newsdtxt);
    pst.setString(2,newsttxt);
    pst.setString(3,newsdesctxt);
    
    if(pst.execute()==false)
        if(pst.getUpdateCount()>0)
            flag=true;
    }
    catch(Exception ex)
    {
    System.out.println("error in insert news"+ex);
    }
    return flag;
    }
    public boolean UpdateNews(String newsid,String newsdtxt,String newsttxt,String newsdesctxt,String statustxt)
    {
    boolean flag=false;
    sd.Connect();
    try
    {
    pst=sd.con.prepareCall("{call prcupdatetbnews(?,?,?,?,?)}");
    pst.setLong(1,Long.parseLong(newsid));
    pst.setString(2,newsdtxt);
    pst.setString(3,newsttxt);
    pst.setString(4,newsdesctxt);
    pst.setString(5,statustxt);
    if(pst.execute()==false)
        if(pst.getUpdateCount()>0)
            flag=true;
    }
    catch(Exception ex)
    {
    System.out.println("error in update news"+ex);
    }
    return flag;
    }
    public ArrayList SearchNews(String commnewsid)
    {
    ArrayList aobj=new ArrayList();
    sd.Connect();
    try
    {
    pst=sd.con.prepareStatement("select *from tbNews where NewsID=?");
    pst.setLong(1,Long.parseLong(commnewsid));
    rst=pst.executeQuery();
     while(rst.next())
     {
     aobj.add(rst.getString(1));
     aobj.add(rst.getString(2));
     aobj.add(rst.getString(3));
     aobj.add(rst.getString(4));
     aobj.add(rst.getString(5));
     }
     rst.close();
    }
    catch(Exception ex)
    {
    System.out.println("error in searching news"+ex);
    }
    return aobj;
    }
    public boolean InsertNewsComment(String newsid,String Doctor_ID,String commdesctxt)
    {
    boolean flag=false;
    sd.Connect();
    try
    {
    pst=sd.con.prepareCall("{call prcinserttbnewscomment(?,?,?)}");
    pst.setLong(1,Long.parseLong(newsid));
    pst.setLong(2,Long.parseLong(Doctor_ID));
    pst.setString(3,commdesctxt);
    if(pst.execute()==false)
        if(pst.getUpdateCount()>0)
            flag=true;
    }
    catch(Exception ex)
    {
    System.out.println("error in insert in news comment"+ex);
    }
    return flag;
    }
    public ArrayList CommInf(String newsid,String Doctor_ID,String commdestxt)
    {
    ArrayList aobj=new ArrayList();
    sd.Connect();
    try
    {
    pst=sd.con.prepareStatement("SELECT        dbo.tbNews.News_Description, dbo.tbNews_Comment.Comments_Description, dbo.tbDoctor.Doctor_Name "+
"FROM            dbo.tbNews INNER JOIN "+
                         "dbo.tbNews_Comment ON dbo.tbNews.NewsID = dbo.tbNews_Comment.News_ID AND dbo.tbNews.NewsID = dbo.tbNews_Comment.News_ID INNER JOIN "+
                         "dbo.tbDoctor ON dbo.tbNews_Comment.Doctor_ID = dbo.tbDoctor.Doctor_ID AND dbo.tbNews_Comment.Doctor_ID = dbo.tbDoctor.Doctor_ID where NewsID=?");
    pst.setLong(1,Long.parseLong(newsid));
    rst=pst.executeQuery();
     while(rst.next())
     {
     aobj.add(rst.getString(1));
     aobj.add(rst.getString(2));
     aobj.add(rst.getString(3));
     }
     rst.close();
    }
    catch(Exception ex)
    {
    System.out.println("error in searching news"+ex);
    }
    return aobj;
    }
  public boolean UpdateNewsComment(String newscommentid,String newsid,String doctorid,String commdesctxt,String dateofcommtxt,String statustxt)
    {
    boolean flag=false;
    sd.Connect();
    try
    {
    pst=sd.con.prepareCall("{call prcupdatetbnewscomment(?,?,?,?,?,?)}");
    pst.setLong(1,Long.parseLong(newscommentid));
    pst.setLong(2,Long.parseLong(newsid));
    pst.setLong(3,Long.parseLong(doctorid));
    pst.setString(4,commdesctxt);
    pst.setString(5, dateofcommtxt);
    pst.setString(6,statustxt);
    if(pst.execute()==false)
        if(pst.getUpdateCount()>0)
            flag=true;
    }
    catch(Exception ex)
    {
    System.out.println("error in insert in news comment"+ex);
    }
    return flag;
    }
  public ArrayList SearchNewscomment(String commnewsid)
  {
  ArrayList aobj=new ArrayList();
  sd.Connect();
  try
  {
  pst=sd.con.prepareStatement("select * from tbNews_Comment where News_Comment_ID=?");
  pst.setLong(1,Long.parseLong(commnewsid));
  rst=pst.executeQuery();
  while(rst.next())
  {
  aobj.add(rst.getString(1));
  aobj.add(rst.getString(2));
  aobj.add(rst.getString(3));
  aobj.add(rst.getString(4));
  aobj.add(rst.getString(5));
  aobj.add(rst.getString(6));
  }
  rst.close();
  }
  catch(Exception ex)
  {
  System.out.println("error in searching newscomment"+ex);
  }
  return aobj;
  }
  public boolean InsertTeatment(String Appointment_ID,String Doctor_ID,String treatdtxt,String treatctxt,String treattimetxt,String treatdesctxt,String recttxt,String recprectxt)
  {
  boolean flag=false;
  sd.Connect();
  try
  {
  pst=sd.con.prepareCall("{call prcinserttbtreatment(?,?,?,?,?,?,?,?)}");
  pst.setLong(1,Long.parseLong(Appointment_ID));
  pst.setLong(2,Long.parseLong(Doctor_ID));
  pst.setString(3,treatdtxt);
  pst.setString(4,treatctxt);
  pst.setString(5,treattimetxt);
  pst.setString(6,treatdesctxt);
  pst.setString(7,recttxt);
  pst.setString(8,recprectxt);
  if(pst.execute()==false)
      if(pst.getUpdateCount()>0)
          flag=true;
  }
  catch(Exception ex)
  {
  System.out.println("error in treatment insert"+ex);
  }
  return flag;
  }
  public boolean UpdateTeatment(String treatmentid,String appointmentid,String doctorid,String treatdtxt,String treatctxt,String treattimetxt,String treatdesctxt,String recttxt,String recprectxt)
  {
  boolean flag=false;
  sd.Connect();
  try
  {
  pst=sd.con.prepareCall("{call prcupdatetbtreatment(?,?,?,?,?,?,?,?,?)}");
  pst.setLong(1,Long.parseLong(treatmentid));
  pst.setLong(2,Long.parseLong(appointmentid));
  pst.setLong(3,Long.parseLong(doctorid));
  pst.setString(4,treatdtxt);
  pst.setString(5,treatctxt);
  pst.setString(6,treattimetxt);
  pst.setString(7,treatdesctxt);
  pst.setString(8,recttxt);
  pst.setString(9,recprectxt);
  if(pst.execute()==false)
      if(pst.getUpdateCount()>0)
          flag=true;
  }
  catch(Exception ex)
  {
  System.out.println("error in treatment update"+ex);
  }
  return flag;
  }
  public ArrayList SearchTreatment(String Treatment_ID)
  {
  ArrayList aobj=new ArrayList();
  sd.Connect();
  try
  {
  pst=sd.con.prepareStatement("select * from tbTreatment where Treatment_id=?");
  pst.setLong(1,Long.parseLong(Treatment_ID));
  rst=pst.executeQuery();
  while(rst.next())
  {
  aobj.add(rst.getString(1));
  aobj.add(rst.getString(2));
  aobj.add(rst.getString(3));
  aobj.add(rst.getString(4));
  aobj.add(rst.getString(5));
  aobj.add(rst.getString(6));
  aobj.add(rst.getString(7));
  aobj.add(rst.getString(8));
  }
  rst.close();
  }
  catch(Exception ex)
  {
  System.out.println("error in searching treatment"+ex);
  }
  return aobj;
  }
  public ArrayList addtreatment(String appid)
  {
  ArrayList aobj=new ArrayList();
  sd.Connect();
  try
  {
      pst=sd.con.prepareStatement("select Appointment_ID from tbAppointment where Appointment_ID=?");
      pst.setLong(1,Long.parseLong(appid));
      rst=pst.executeQuery();
      while(rst.next())
      {
      aobj.add(rst.getString(1));
      }
      rst.close();
  }
  catch(Exception ex)
  {
      System.out.println("error in add treatment getting data"+ex);
  }
  return aobj;
  }
  public boolean CheckUser(String emailtxt,String pwdtxt)
  {
  boolean flag=false;
  sd.Connect();
  try
  {
  pst=sd.con.prepareStatement("select * from tbUser where Email=? and Password=?");
  pst.setString(1, emailtxt);
  pst.setString(2, pwdtxt);
  rst=pst.executeQuery();
  if(rst.next())
  {
  flag=true;
  }
  rst.close();
  }
  catch(Exception ex)
  {
  System.out.println("error in login user"+ex);
  }
  return flag;
  }
  public boolean ChangePassworduser(String emailtxt,String npwdtxt,String pwdtxt)
  {
  boolean flag=false;
  sd.Connect();
  try
  {
  pst=sd.con.prepareStatement("update tbUser set Password=? where email=? and password=?");
  pst.setString(1, npwdtxt);
  pst.setString(2, emailtxt);
  pst.setString(3, pwdtxt);
      if(pst.executeUpdate()>0)
          flag=true;
  }
  catch(Exception ex)
  {
  System.out.println("error in changing password"+ex);
  }
  return flag;
  }
  public boolean InsertUser(String nametxt,String pwdtxt,String addresstxt,String citytxt,String statetxt,String phonetxt,String emailtxt)
  {
  boolean flag=false;
  sd.Connect();
  try
  {
  pst=sd.con.prepareCall("{call prcinserttbUser(?,?,?,?,?,?,?)}");
  pst.setString(1,nametxt);
  pst.setString(2,pwdtxt);
  pst.setString(3,addresstxt);
  pst.setString(4,citytxt);
  pst.setString(5, statetxt);
  pst.setString(6,phonetxt);
  pst.setString(7,emailtxt);
 
  if(pst.execute()==false)
      if(pst.getUpdateCount()>0)
          flag=true;
  }
  catch(Exception ex)
  {
  System.out.println("error in user insert"+ex);
  }
  return flag;
  }
  public boolean UpdateUser(String userid,String nametxt,String pwdtxt,String addresstxt,String citytxt,String statetxt,String phonetxt, String emailtxt,String regdtxt)
  {
  boolean flag=false;
  sd.Connect();
  try
  {
  pst=sd.con.prepareCall("{call prcupdatetbUser(?,?,?,?,?,?,?,?,?)}");
  pst.setLong(1,Long.parseLong(userid));
  pst.setString(2,nametxt);
  pst.setString(3,pwdtxt);
  pst.setString(4,addresstxt);
  pst.setString(5,citytxt);
  pst.setString(6, statetxt);
  pst.setString(7,phonetxt);
  pst.setString(8,emailtxt);
  pst.setString(9, regdtxt);
  if(pst.execute()==false)
      if(pst.getUpdateCount()>0)
          flag=true;
  }
  catch(Exception ex)
  {
  System.out.println("error in user update"+ex);
  }
  return flag;
  }
  public ArrayList SearchUser(String pwdtxt)
  {
  ArrayList aobj=new ArrayList();
  sd.Connect();
  try
  {
  pst=sd.con.prepareStatement("select * from tbUser where pwdtxt=?");
  pst.setString(1,pwdtxt);
  rst=pst.executeQuery();
  while(rst.next())
  {
  aobj.add(rst.getString(1));
  aobj.add(rst.getString(2));
  aobj.add(rst.getString(3));
  aobj.add(rst.getString(4));
  aobj.add(rst.getString(5));
  aobj.add(rst.getString(6));
  aobj.add(rst.getString(7));
  }
  rst.close();
  }
  catch(Exception ex)
  {
  System.out.println("error in searching user"+ex);
  }
  return aobj;
  }
   public boolean DelAdmin(String nametxt,String pwdtxt)
  {
  boolean flag=false;
  sd.Connect();
  try
  {
  pst=sd.con.prepareStatement("delete tbAdmin_Login where admin_name=? and password=?");
  pst.setString(1, nametxt);
  pst.setString(2, pwdtxt);
      if(pst.executeUpdate()>0)
          flag=true;
  }
  catch(Exception ex)
  {
  System.out.println("error in deleting admin"+ex);
  }
  return flag;
  }
   public boolean ChangePasswordAdmin(String adminnametxt,String pwdtxt,String npwdtxt)
  {
  boolean flag=false;
  sd.Connect();
  try
  {
  pst=sd.con.prepareStatement("update tbAdmin_Login set Password=? where admin_name=? and password=?");
  pst.setString(1, npwdtxt);
  pst.setString(2,adminnametxt);
  pst.setString(3, pwdtxt);
      if(pst.executeUpdate()>0)
          flag=true;
  }
  catch(Exception ex)
  {
  System.out.println("error in changing password"+ex);
  }
  return flag;
  }
   public boolean CheckAdmin(String adminnametxt,String pwdtxt)
   {
   boolean flag=false;
   sd.Connect();
   try
   {
   pst=sd.con.prepareStatement("select * from tbAdmin_login where Admin_Name=? and password=?");
           pst.setString(1,adminnametxt);
           pst.setString(2, pwdtxt);
           rst=(pst.executeQuery());
            if(rst.next())
                flag=true;
   }
   catch(Exception ex)
   {
   System.out.println("error in login admin"+ex);
   }
   return flag;
   }
   public boolean InsertContact(String nametxt,String emailtxt,String subtxt,String msgtxt)
   {
   boolean flag=false;
   sd.Connect();
   try
   {
   pst=sd.con.prepareCall("{call inserttbcontact(?,?,?,?)}");
   pst.setString(1,nametxt);
   pst.setString(2,emailtxt);
   pst.setString(3,subtxt);
   pst.setString(4,msgtxt);
   if(pst.execute()==false)
       if(pst.getUpdateCount()>0)
           flag=true;
   }
   catch(Exception ex)
   {
   System.out.println("error in insert contact"+ex);
   }
   return flag;
   }
      } 
