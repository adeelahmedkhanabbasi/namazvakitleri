# The Determination of Salat Times #


[[ 1. Introduction](#1.%20Introduction.md) [| 2. Definitions of Prayer Times](#2.%20Definition.md) [| 3. What is twilight?](#3.Twilight.md) [| 4. Twilight and calculation of Fajr and Isha](#4.%20Twilight%20and%20calc.md) [| 5. Conventions currently in use ](#5.%20Conventions.md) [| 6. Persisting twilight ](#6.%20Persisting%20twilight.md) [| 7. Calculation of salat times - technical notes](#7.%20Calculation.md) [| 8. Software ](#8.%20Software.md) [| 9. Summary](#9.%20Summary.md) [| 10. References ](#References.md)]

---


## 1. Introduction ##

The five Islamic prayers are named Fajr, Zuhr, Asr, Maghrib and Isha. The timing of these five prayers varies from place to place and from day to day. It is obligatory for Muslims to perform these prayers at the correct time.

The prayer times for any given location on earth may be determined mathematically if the latitude and longitude of the location are known. However, the theoretical determination of prayer times is a lengthy process. Much of this tedium may be alleviated by using [computer programs](http://www.ummah.net/software/ptc/).

[Back to top](#Top.md)

---


## 2. Definition of prayer times ##

  * FAJR starts with the dawn or morning twilight. Fajr ends just before sunrise.

  * ZUHR begins after midday when the trailing limb of the sun has passed the meridian. For convenience, many published prayer timetables add five minutes to mid-day (zawal) to obtain the start of Zuhr. Zuhr ends at the start of Asr time.

  * The timing of ASR depends on the length of the shadow cast by an object. According to the Shafi school of jurisprudence, Asr begins when the length of the shadow of an object exceeds the length of the object. According to the Hanafi school of jurisprudence, Asr begins when the length of the shadow exceeds TWICE the length of the object. In both cases, the minimum length of shadow (which occurs when the sun passes the meridian) is subtracted from the length of the shadow before comparing it with the length of the object.

  * MAGHRIB begins at sunset and ends at the start of isha.

  * ISHA starts after dusk when the evening twilight disappears.

![http://namazvakitleri.googlecode.com/svn-history/r4/trunk/NamazVakitleri/src/salatTimes/res/solarcy.gif](http://namazvakitleri.googlecode.com/svn-history/r4/trunk/NamazVakitleri/src/salatTimes/res/solarcy.gif)
### Salat Times ###

|  | Start | End |
|:-|:------|:----|
| Fajr | When whitishness begins to appear on the horizon (dawn) | At beginning of sunrise |
| Zuhr | After sun's trailing limb crosses meridian | Start of Asr |
| Asr | When length of shadow =2x length of object + noon shadow (Hanafi) or  When length of shadow = length of object + noon shadow (Shafi) | Before sunset |
| Maghrib | Sunset | Reddishness in the sky |
| Isha | After reddishness in sky (dusk) ends | Midnight (afzal), next fajr (makruh) |

[Back to top](#Top.md)

---


## 3. What is twilight? ##

If the earth did not have an atmosphere, the sky would become dark immediately after sunset. The earth's atmosphere causes scattering of sunlight so that light reaches the observer **before** sunrise and **after** sunset. This scattered light is called twilight. After sunset, as the depression of the sun increases the sky gets darker and darker until no scattered light reaches the observer. Conversely, in the morning light starts to appear in the sky even before sunrise. The morning twilight is called dawn whilst the evening twilight is known as dusk.

![http://namazvakitleri.googlecode.com/svn/trunk/NamazVakitleri/src/salatTimes/res/depr.gif](http://namazvakitleri.googlecode.com/svn/trunk/NamazVakitleri/src/salatTimes/res/depr.gif)
In astronomy the twilight period is divided into civil, nautical and astronomical twilight corresponding to solar depressions of 6, 12 and 18 degrees respectively.

![http://namazvakitleri.googlecode.com/svn/trunk/NamazVakitleri/src/salatTimes/res/twilgrph.gif](http://namazvakitleri.googlecode.com/svn/trunk/NamazVakitleri/src/salatTimes/res/twilgrph.gif)

  * Civil twilight - roughly equivalent to lighting up time. The brightest stars are visible and at sea the horizon is clearly visible.

  * Nautical twilight - the horizon at sea ceases to be clearly visible and it is impossible to determine altitudes with reference to the horizon.

  * Astronomical twilight- when it is truly dark and no perceptible twilight remains.

[Back to top](#Top.md)

---


## 4. Twilight and calculation of fajr and isha ##

Fajr starts with the morning twilight (dawn) whilst isha starts at the end of the evening twilight (dusk). There is some debate as to which twilight angle should be used in the calculation of fajr/isha. For a discussion on the subject, I refer you to Dr. Ilyas' book: Astronomy of Islamic Times for the Twenty- first Century. Here is a brief extract from chapter five of Dr. Ilyas' book (in italics):

_" In modern times, astronomical twilight (18 degrees) has come to be widely used for the determination of isha and fajr times. As the average intensity curve of evening twilight indicates, the flux decreases to a minimum level, and thus it would seem appropriate that even for Islamic purposes, this should indicate a reasonable starting value for the end of 'astro-lslamic twilight' (AIT). Indeed, 18 degrees depression was a commonly used value for fajr and isha in the medieval period, when it must have been based on careful observations. Nevertheless, slight variations from this value- between 16 degrees and 20 degrees- were also used during the medieval period. According to King, 20 degrees and 16 degrees were the parameters used by Ibn Yunus for morning and evening AIT respectively, whereas 19 degrees and 17 degrees were the parameters used by various Egyptian astronomers. Nasr also refers to 19 degrees being used in the Islamic world for the fajr and isha times. King has confirmed that although Muslim astronomers widely used 18 degrees/l8 degrees symmetrical values or a slight variation to 19 degrees/17 degrees (morning/evening)-and in a few (earlier) cases even 20 degrees/16 degrees values were adopted-no record has been found of the use of a value as small as 15 degrees. This is of specific interest to us because a few years ago, values of 15 degrees/15 degrees for both AlTs were proposed by Bagvi on the authority of Maulana Rashid Ahmad Ludianvi of Karachi, who is reported to have made some observations personally. Indeed, I myself followed Bagvi in preparing the first South Australian Islamic Time Table, although I did consider the need to examine the matter very carefully and introduced a distinct term for it. Subsequently, this 15 degrees proposition has come under criticism and is apparently not proved by others' observations made in recent years in that particular area (Karachi). Concern on this matter is obviously understandable, because an erroneous delay in the beginning of fajr would have serious implications for the beginning of the Fast. One of the useful studies arguing against this 15 degrees depression for AIT is that of Latiff, who claims to have conducted some observational work. Unfortunately, Latiff has argued for a fixed 18 degrees/18 degrees case for all over the globe-no less and no more. This, it seems, may not be the true situation either as there seems to be some room for geographical variability and perhaps 18 degrees serves as a good upper limit only. The value for morning AIT has widely been used as 18 degrees, although a practice of using 20 degrees prevails in Egypt and Indonesia/Malaysia (under Egyptian influence, apparently owing to the concerned persons having been trained there). Possibly, 20 degrees is taken as a safeguard because of the sanctification of the Fast. On the other hand, the use of smaller values than 18 degrees for India and Yemen has been reported to me in personal communications by Abdul Hafiz Maniar of Surat, India, and Dr. M.M. Qurashi of Islamabad, Pakistan, respectively. However, as we have noted elsewhere, in general, at 18 degrees depression, no detectable trace of twilight flux will be found, meaning that 18 degrees represents an upper limit. "_

Generally, using smaller twilight angles will produce later fajr times and earlier isha times.

eg for**London** (51:32N, 00:06W, Time zone 0 ),
> On 1st January 1996:

```

			Fajr		Isha
18 degrees		6:02		18:04
15 degrees		6:22		17:43

```

The two graphs below show the change in the timing of the prayer times during the year is shown for London below: (F= Fajr, Z=Zuhr, A2=Hanafi Asr, M=Maghrib, I=Isha).

In the first graph (below), 15 degrees has been used for calculation of both Fajr and Isha.

![http://namazvakitleri.googlecode.com/svn/trunk/NamazVakitleri/src/salatTimes/res/twil15.gif](http://namazvakitleri.googlecode.com/svn/trunk/NamazVakitleri/src/salatTimes/res/twil15.gif)

##### Diagram produced by [Prayer Time Calculator v2.5](http://www.ummah.net/software/ptc) #####

In the second graph (below), 18 degrees has been used for calculation of Fajr and Isha. Note that in the second example, Fajr starts earlier and Isha starts later.

![http://namazvakitleri.googlecode.com/svn/trunk/NamazVakitleri/src/salatTimes/res/twil18.gif](http://namazvakitleri.googlecode.com/svn/trunk/NamazVakitleri/src/salatTimes/res/twil18.gif)

##### Diagram produced by [Prayer Time Calculator v2.5](http://www.ummah.net/software/ptc) #####

[Back to top](#Top.md)

---


## 5. Conventions currently in use ##

Several conventions for the calculation of Fajr and Isha are already in use in various countries. Fajr and Isha times are usually calculated using fixed twilight angles as discussed above but some countries also use a method involving adding/subtracting a fixed interval of time to sunset/sunrise respectively . Using the latter method, a time interval is subtracted from sunrise to obtain Fajr whilst the interval is added to sunset to obtain Isha. The methods used by some Islamic organisations are are summarised in the following table:

| Organisation | Fajr - twilight angle | Isha - twilight angle | Region |  |
|:-------------|:----------------------|:----------------------|:-------|:-|
| University of Islamic Sciences, Karachi | 18                    | 18                    | Pakistan, Bangladesh, India, Afganistan, parts of Europe |  |
| Islamic Society of North America (ISNA) | 15                    | 15                    | Parts of USA & Canada, parts of UK |  |
| World Islamic League | 18                    | 17                    | Europe, Far East, parts of USA |  |
| Um Ul-Qura, Makkah | 19                    | 90 mins after Maghrib, 120 mins during Ramadhan | Arabian Peninsula |  |
| Egyptian General Organisation of Surveying | 19.5                  | 17.5                  | Africa, Syria, Iraq, Lebanon, Malaysia, parts of USA |  |

[Back to top](#Top.md)

---


## 6. Persisting Twilight ##

At extreme latitudes the twilight may persist between sunset and the next sunrise for certain months of the year. In these months the sun does not go below the horizon by a sufficient amount to abolish twilight. Hence there is no true night. Under these circumstances, Fajr and Isha times may be calculated using one of four agreed principles (refs 4 & 2):

**1. Nearest latitude** _(Aqrab Al-Balad)_ - add the interval between sunset and isha for a location on latitude 48 degrees to the local sunset time to obtain time for local isha. Similarly the interval between fajr and sunrise for a location on latitude 48 degrees is subtracted from local sunrise to obtain local fajr time.

**2. Nearest day**_(Aqrab Al-Ayyam)_ - use fajr and isha times from the last day when it was possible to calculate these times in the normal way for that location.

**3. Middle of night** _(Nisf Al-Lail)_ - split interval between sunrise and sunset into two halves. Isha is offered before the midpoint (e.g. 15 minutes before) and fajr is offered after the midpoint.

**4. One seventh of night** _(Sube Al-Lail)_ - split interval between sunset and sunrise into seven segments. Isha is offered after the first segment and fajr is offered after the sixth segment.

[Back to top](#Top.md)

---


## 7. Calculation of Salat Times - technical notes ##

To calculate the prayer times for a certain place we need to know the latitude (B) and longitude (L) of the location and its reference longitude (R). B and L may be obtained from an atlas and R may be calculated by multiplying 15 by the difference between local time and GMT (i.e. 15 x Time Band).

We also need to know two astronomical measures called the declination angle of the sun (D) and the real time-mean time difference, also known as the equation of time (T).

Declination is the angular distance between a celestial object and the celestial equator. The Declination and the Right Ascension are used together to give the position of a star with reference to the celestial equator and the vernal equinox respectively.

The equation of time is a correction to be added to apparent solar time, as read on a sundial, to obtain mean solar time, as commonly used. This difference is a consequence of the ellipticity and tilt of the Earth's orbit, causing the irregular apparent movement of the Sun across the sky.

D and T vary according to the time of year and can be obtained accurately from The Star Almanac or calculated approximately.

**Graph of Declination angle (D) versus Month**

![http://namazvakitleri.googlecode.com/svn/trunk/NamazVakitleri/src/salatTimes/res/decang.gif](http://namazvakitleri.googlecode.com/svn/trunk/NamazVakitleri/src/salatTimes/res/decang.gif)

**Graph of Equation of Time(T) versus Month**

![http://namazvakitleri.googlecode.com/svn/trunk/NamazVakitleri/src/salatTimes/res/eoft.gif](http://namazvakitleri.googlecode.com/svn/trunk/NamazVakitleri/src/salatTimes/res/eoft.gif)

The following equations may be used to calculate the prayer times:

```

	(R-L)    T
Z = 12+ ----- + ---					........1
	 15      60

    1        {sin(-0.8333-0.0347(H)^0.5)}-sinD.sinB
U= -- arccos --------------------------------------  	........2
   15                   cosD.cosB

    1        -sinG-sinD.sinB
V= -- arccos --------------- 				........3
   15          cosD.cosB

    1        sin{arccot(1+tan(B-D)}-sinD.sinB
W= -- arccos -------------------------------- 		........4
   15                 cosD.cosB

    1        sin{arccot(2+tan(B-D)}-sinD.sinB
X= -- arccos -------------------------------- 		........5
   15                 cosD.cosB

where

B= latitude of place
L= longitude of place
R= reference longitude (i.e. TIME BAND x 15)
H= height above sea level in metres
D= declination angle of sun from celestial equator (-ve in southern hemisphere)
T= equation of time
G= twilight angle

Fajr = Z-V
Sunrise = Z-U
Zuhr  = Z
Asr1 (Shafi) = Z+W
Asr2 (Hanafi) = Z+X
Maghrib/Sunset = Z+U
Isha = Z+V

```

The algorithms to calculate T and D are not shown here. These algorithms may be found in, for example, Jean Meeus' Astronomical Algorithms. Zuhr time is calculated using equation 1. The time for sunrise and sunset/ maghrib may be calculated by subtracting or adding 'U'(obtained from equation 2) to the Zuhr time respectively.

Fajr and Isha times may be calculated by subtracting or adding 'V' (obtained from equation 3) to the Zuhr time respectively. The term G (twilight angle) in equation 3 is usually set to 18 degrees. For a location with an extreme latitude, days in summer may be so long that twilight persists between sunset and the next sunrise. Under these circumstances, 'V' is undefined and Fajr and Isha have to be determined using agreed principles of fiqh.

The start of Asr time (Shafi) may be obtained by adding 'W' (obtained from equation 4) to Zuhr; Asr time (Hanafi) is calculated by adding 'X' (obtained from equation 5) to Zuhr.

[Back to top](#Top.md)

---


## 8. Software ##

[Prayer Time Calculator v2.5 ](http://www.ummah.net/software/ptc)- this DOS program can calculate prayer times and [Qibla](http://www.ummah.com/software/qibla) direction for any location on earth using the principles and techniques discussed above.[Download ](http://www.ummah.net/software/ptc25.zip)Prayer Time Calculator v2.5.

[Other Software](http://www.ummah.net/software).

[Back to top](#Top.md)

---


## 8. Summary ##

  * Zuhr, Asr (Shafi and Hanafi) and Maghrib times may be calculated unambiguously.
  * Fajr and Isha times depend on twilight and require the adoption of a suitable_twilght angle_.
  * Generally, a twilight angle of 18 degrees may represent a safe upper limit although opinions and practices vary.
  * In locations at higher latitude, twilight may persist throughout the night during some months of the year - here alternative methods such as 1/7th night rule must be used to calculate fajr/isha times.

[Back to top](#Top.md)

---


## 10. References ##

1. Dr. Monzur Ahmed; README.TXT file of [Prayer Time Calculator v2.5](http://www.ummah.net/software/ptc)

2. Dr. Mohammad Ilyas; Astronomy of Islamic Times for the Twenty-first Century, 1989; Mansell, London.

3. Dr. Mohammad Ilyas; A Modern Guide to Astronomical Calculations of Islamic Calendar, Times & Qibla;1984,Berita Publishing Sdn Bhd., Kuala Lumpur, Malaysia

4. Moulana Yakub Qasmi and Tariq Muneer, Prayer Times for United Kingdom & Ireland; 1989, Islamic Research Institute of Britain, Dewsbury, UK.

5. Abdul Lateef Bin Abdul Aziz, Perpetual Prayer Time Table for the Whole World; 1986, Published by Abdul Majeed Qureshi, Karachi, Pakistan.

6. Jean Meeus, Astronomical Algorithms; 2nd ed; 1991; Willmann -Bell Inc; Richmond, USA.

[Back to top](#Top.md)

---

_Last modified: 4th January 1997, copyright � by Dr. Monzur Ahmed ![http://www.ummah.net/astronomy/saltime/mail.gif](http://www.ummah.net/astronomy/saltime/mail.gif) [monz@starlight.demon.co.uk](mailto:monz@starlight.demon.co.uk)_
----ing