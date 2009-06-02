/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salatTimes;
import static java.lang.Math.*;
/**
 *
 * @author nf155c
 */
public class SunData {
     /**
     * Calculate the declination of the sun. Declination is analogous to latitude
     * on Earth's surface, and measures an angular displacement north or south
     * from the projection of Earth's equator on the celestial sphere to the
     * location of a celestial body.
     *
     * @param t number of Julian centuries since J2000.
     * @return Sun's declination in degrees.
     */
   double calculateSunDeclination(double t) {
        final double e = toRadians(obliquityCorrected(t));
        final double b = toRadians(sunApparentLongitude(t));
        final double sint = sin(e) * sin(b);
        final double theta = asin(sint);
        return toDegrees(theta);
    }
    
     
    /***
     * TA'D�L-� ZEM�N
     * Tadil-i zaman degiskenini doner. 
     * Gunesin saat 12 de iken tepe noktasinda olmasi gerekirken olamayipda  aradaki farki dakika cinsinden
     * veren fonksiyon.
     * Calculate the difference between true solar time and mean. The "equation
     * of time" is a term accounting for changes in the time of solar noon for
     * a given location over the course of a year. Earth's elliptical orbit and
     * Kepler's law of equal areas in equal times are the culprits behind this
     * phenomenon. See the
     * <A HREF="http://www.analemma.com/Pages/framesPage.html">Analemma page</A>.
     * Below is a plot of the equation of time versus the day of the year.
     *
     * <P align="center"><img src="doc-files/EquationOfTime.png"></P>
     *
     * @param  t number of Julian centuries since J2000.
     * @return Equation of time in minutes of time.
     * TA'DIL-I ZEMAN
     */
     
     double calculateEquationOfTime(final double t)
    {
        double eps = toRadians(obliquityCorrected(t));
        double l0  = toRadians(sunGeometricMeanLongitude(t));
        double m   = toRadians(sunGeometricMeanAnomaly(t));
        double e   = eccentricityEarthOrbit(t);
        double y   = tan(eps/2);
        y *= y;
        double sin2l0 = sin(2 * l0);
        double cos2l0 = cos(2 * l0);
        double sin4l0 = sin(4 * l0);
        double sin1m  = sin(m);
        double sin2m  = sin(2 * m);
        double etime = y*sin2l0 - 2*e*sin1m + 4*e*y*sin1m*cos2l0
                       -0.5*y*y*sin4l0 - 1.25*e*e*sin2m;
        return toDegrees(etime)*4.0;
    }
    
    
    /**
     * Calculate the number of Julian centuries since J2000.
     * for more explanation about epoch julian day.
     * http://www.giss.nasa.gov/tools/mars24/help/algorithm.html
     * @param t System current time in Milliseconds.
     * @return number of Julian centuries since J2000.
     */
     double calculateJulianCentury (double time)
     {  double JULIAN_DAY_1970 = 2440587.5; //2451544.5-10957;
        double MILLIS_IN_DAY = 1000*60*60*24;
        return ((time/MILLIS_IN_DAY) + JULIAN_DAY_1970-2451545)/36525;
    }
   

    /***
     * Calculate the corrected obliquity of the ecliptic.
     *
     * @param  t number of Julian centuries since J2000.
     * @return Corrected obliquity in degrees.
     */
    private double obliquityCorrected( double t) {
        final double e0 = meanObliquityOfEcliptic(t);
        final double omega = toRadians(125.04 - 1934.136*t);
        return e0 + 0.00256 * cos(omega);
    }
    /*Calculate the mean obliquity of the ecliptic.
         @param  t number of Julian centuries since J2000.
        @return Mean obliquity in degrees.
     */
    private double meanObliquityOfEcliptic(final double t)
    {
        final double seconds = 21.448 - t*(46.8150 + t*(0.00059 - t*(0.001813)));
        return 23.0 + (26.0 + (seconds/60.0))/60.0;
    }
    /***
     * Calculate the Geometric Mean Anomaly of the Sun.
     *
     * @param  t number of Julian centuries since J2000.
     * @return Geometric Mean Anomaly of the Sun in degrees.
     */
    private double sunGeometricMeanAnomaly(double t)
    {
        return 357.52911 + t * (35999.05029 - 0.0001537*t);
    }
    /***
     * Calculate the equation of center for the sun. This value is a correction
     * to add to the geometric mean longitude in order to get the "true" longitude
     * @param  t number of Julian centuries since J2000.
     */
    private  double sunEquationOfCenter(final double t)
    {
        double m = toRadians(sunGeometricMeanAnomaly(t));
        return sin(1*m) * (1.914602 - t*(0.004817 + 0.000014*t)) +
                sin(2*m) * (0.019993 - t*(0.000101             )) +
                sin(3*m) * (0.000289);
    }
    /***
     * Calculate the Geometric Mean Longitude of the Sun.
     * This value is close to 0? at the spring equinox,
     * 90? at the summer solstice, 180? at the automne equinox
     * and 270? at the winter solstice.
     *
     * @param  t number of Julian centuries since J2000.
     * @return Geometric Mean Longitude of the Sun in degrees,
     *         in the range 0? (inclusive) to 360? (exclusive).
     */
    private double sunGeometricMeanLongitude(final double t)
    {
        double L0 = 280.46646 + t*(36000.76983 + 0.0003032*t);
        L0 = L0 - 360*floor(L0/360);
        return L0;
    }
    /***
     * Calculate the true longitude of the sun. This the geometric mean
     * longitude plus a correction factor ("equation of center" for the
     * sun).
     *
     * @param  t number of Julian centuries since J2000.
     * @return Sun's true longitude in degrees.
     */
    private double sunTrueLongitude(final double t)
    {
        return sunGeometricMeanLongitude(t) + sunEquationOfCenter(t);
    }
    /***
     * Calculate the apparent longitude of the sun.
     *
     * @param  t number of Julian centuries since J2000.
     * @return Sun's apparent longitude in degrees.
     */
    private double sunApparentLongitude(final double t)
    {
        final double omega = toRadians(125.04 - 1934.136 * t);
        return sunTrueLongitude(t) - 0.00569 - 0.00478 * sin(omega);
    }
    /***
     * Calculate the corrected obliquity of the ecliptic.
     *
     * @param  t number of Julian centuries since J2000.
     * @return Corrected obliquity in degrees.
     */
    
      /***
     * Calculate the eccentricity of earth's orbit. This is the ratio
     * <code>(a-b)/a</code> where <var>a</var> is the semi-major axis
     * length and <var>b</var> is the semi-minor axis length.   Value
     * is 0 for a circular orbit.
     *
     * @param  t number of Julian centuries since J2000.
     * @return The unitless eccentricity.
     */
    private double eccentricityEarthOrbit(final double t)
    {
        return 0.016708634 - t*(0.000042037 + 0.0000001267*t);
    }

}
