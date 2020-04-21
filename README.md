PRO-grammers taldearen EasyBooking proiektua
===
Softwarearen Diseinua - Deustuko Unibertsitatea
===
EXEKUZIO PAUSUAK
---

1. mvn clean --> mvn compile --> mvn package (konpilatu eta zerbitzaria exekutatzen du)
2. ant -f build.xml klientea (klientea exekutatzen du)

Datanucleusen probak egiteko exekuzio pausuak
---
3. mvn datanucleus:schema-create (Datubasearen eskema sortzen du)
4. mvn exec:java -PprobaORM_1 (Datuak sartzen ditu datubasean)
5. mvn exec:java -PprobaORM_2 (Selecta querya erabilita, 73037449Y NAN a duen erabiltzailea bilatzen du)
6. mvn exec:java -PprobaORM_3 (Selecta Extenta erabilita, erabiltzaile taularen gainean)
7. mvn exec:java -PprobaORM_4 (Deletea querya erabilita, 2 bidaiari baino gehiago dituzten erreserbak ezabatzen ditu)
8. mvn exec:java -PprobaORM_5 (Updatea querya erabilita, Iberia aerolinearen izena aldatzen du)
