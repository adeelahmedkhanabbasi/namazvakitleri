package salatTimes;
/**
 *
 * @author mehmetrg
 */
import static java.lang.Math.*;
public class SalatTimes extends SunData{
    public double fajr, sunRise,dzhur, asr_shafi,asr_hanafi,magrib,isha; 
    private double T,D,Z,U,U2,V1,V2,W,X;
    //Constructors
    //Yapicilar 
     public SalatTimes ()    
     {   //Yalin olarak calistirildigi takdirde Istanbul icin hesaplama yapcaktir*/
    
         this (28.96,41.02,2,0,System.currentTimeMillis(),-18,-17);
     }
     
    public SalatTimes (double longitude, double latitude, double timeZone, double H, double time,double G1, double G2)    
            
    {   //Formulation is done according to the http://www.ummah.net/astronomy/saltime/   
        double B;
        double R=timeZone*15;
        double jCentury=calculateJulianCentury (time);
        T =calculateEquationOfTime(jCentury);
        D =calculateSunDeclination(jCentury);
        
        D=toRadians(D);G1=toRadians(G1);G2=toRadians(G2);B=toRadians(latitude);
        
        Z = 12+(R-longitude)/15-T/60;
   
        U = toDegrees(acos(( sin (toRadians(-0.8333-0.0347 * sqrt(H)) )-sin(D)* sin(B))/(cos(D) * cos(B))))/15;
        U2 = toDegrees(acos(( sin (toRadians(-1) )-sin(D)* sin(B))/(cos(D) * cos(B))))/15;
        V1= toDegrees(acos(((-sin(G1)-sin(D)*sin(B))/(cos(D)*cos(B)))))/15;
        V2= toDegrees(acos((-sin(G2)-sin(D)*sin(B))/(cos(D)*cos(B)))/15);
        W = toDegrees(acos((sin(atan(1/(1+tan(B-D))))-sin(D)*sin(B))/(cos(D)*cos(B))))/15;
        X = toDegrees(acos((sin(atan(1/(2+tan(B-D))))-sin(D)*sin(B))/(cos(D)*cos(B))))/15;
        
        fajr =Z-V1;
        sunRise= Z-U;
        dzhur = Z;
        asr_shafi = Z+W;
        asr_hanafi = Z+X;
        magrib = Z+U2;
        isha = Z+V2;   
    }    
}
